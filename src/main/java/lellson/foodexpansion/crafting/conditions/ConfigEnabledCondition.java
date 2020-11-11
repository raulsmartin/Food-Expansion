package lellson.foodexpansion.crafting.conditions;

import com.google.gson.JsonObject;
import lellson.foodexpansion.FoodExpansionConfig;
import lellson.foodexpansion.Reference;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import org.apache.logging.log4j.LogManager;

public class ConfigEnabledCondition implements ICondition {
    private static final ResourceLocation NAME = new ResourceLocation(Reference.MODID, "config_enabled");
    private final String config_key;

    public ConfigEnabledCondition(String config_key) {
        this.config_key = config_key;
    }

    @Override
    public ResourceLocation getID() {
        return NAME;
    }

    @Override
    public boolean test() {
        try {
            return !FoodExpansionConfig.class.getField(config_key).getBoolean(null);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            LogManager.getLogger(Reference.MODID).warn("No " + config_key + " configuration found! Details: " + e.getMessage());
            return false;
        }
    }

    @Override
    public String toString() {
        return "config_enabled(\"" + config_key + "\")";
    }

    public static class Serializer implements IConditionSerializer<ConfigEnabledCondition> {
        public static final ConfigEnabledCondition.Serializer INSTANCE = new ConfigEnabledCondition.Serializer();

        @Override
        public void write(JsonObject json, ConfigEnabledCondition value) {
            json.addProperty("config_key", value.config_key);
        }

        @Override
        public ConfigEnabledCondition read(JsonObject json) {
            return new ConfigEnabledCondition(JSONUtils.getString(json, "config_key"));
        }

        @Override
        public ResourceLocation getID() {
            return ConfigEnabledCondition.NAME;
        }
    }
}
