package lellson.foodexpansion;

import lellson.foodexpansion.config.ConfigHelper;
import lellson.foodexpansion.config.ConfigHolder;
import lellson.foodexpansion.crafting.conditions.ConfigEnabledCondition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

import java.util.HashMap;
import java.util.Map;

@Mod(Reference.MODID)
public class FoodExpansion {
    public static final CreativeModeTab ITEM_GROUP = new FoodExpansionItemGroup();
    public static final Map<Class<?>, Drop> DROP_LIST = new HashMap<>();

    public static FoodExpansion instance;

    public FoodExpansion() {
        instance = this;

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigHolder.COMMON_SPEC);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCommonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);

        FoodBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        FoodItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void onCommonSetup(final FMLCommonSetupEvent event) {
        FoodItems.increaseStackSizes();

        addDrop(FoodExpansionConfig.disableSquidDrop, Squid.class, FoodItems.SQUID.get(), FoodItems.COOKED_SQUID.get(), 2);
        addDrop(FoodExpansionConfig.disableHorseMeatDrop, Horse.class, FoodItems.HORSE_MEAT.get(), FoodItems.COOKED_HORSE_MEAT.get(), 3, true);
        addDrop(FoodExpansionConfig.disableBatWingDrop, Bat.class, FoodItems.BAT_WING.get(), FoodItems.COOKED_BAT_WING.get(), 1);
        addDrop(FoodExpansionConfig.disableWolfMeatDrop, Wolf.class, FoodItems.WOLF_MEAT.get(), FoodItems.COOKED_WOLF_MEAT.get(), 2, true);
        addDrop(FoodExpansionConfig.disableOcelotMeatDrop, Ocelot.class, FoodItems.OCELOT_MEAT.get(), FoodItems.COOKED_OCELOT_MEAT.get(), 1, true);
        addDrop(FoodExpansionConfig.disableParrotMeatDrop, Parrot.class, FoodItems.PARROT_MEAT.get(), FoodItems.COOKED_PARROT_MEAT.get(), 1, true);
        addDrop(FoodExpansionConfig.disableLlamaMeatDrop, Llama.class, FoodItems.LLAMA_MEAT.get(), FoodItems.COOKED_LLAMA_MEAT.get(), 2, true);
        addDrop(FoodExpansionConfig.disablePolarBearMeatDrop, PolarBear.class, FoodItems.POLAR_BEAR_MEAT.get(), FoodItems.COOKED_POLAR_BEAR_MEAT.get(), 3, true);
    }

    private void onClientSetup(final FMLClientSetupEvent event) {

    }

    private void addDrop(boolean cfgDisable, Class<?> entityClass, Item uncooked, Item cooked, int maxDropAmount) {
        addDrop(cfgDisable, entityClass, uncooked, cooked, maxDropAmount, false);
    }

    private void addDrop(boolean cfgDisable, Class<?> entityClass, Item uncooked, Item cooked, int maxDropAmount, boolean alwaysDrop) {
        DROP_LIST.put(entityClass, new Drop(cfgDisable, uncooked, cooked, maxDropAmount, alwaysDrop));
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class FoodRegistry {

        @SubscribeEvent
        public static void onModConfig(final ModConfigEvent event) {
            final ModConfig config = event.getConfig();
            if (config.getSpec() == ConfigHolder.COMMON_SPEC) {
                ConfigHelper.bakeCommon(config);
            }
        }

        @SubscribeEvent
        public static void register(final RegisterEvent event) {
            event.register(ForgeRegistries.Keys.ITEMS, helper -> FoodBlocks.BLOCKS.getEntries().forEach(block -> helper.register(block.getId(), new BlockItem(block.get(), new Item.Properties()))));
            event.register(ForgeRegistries.Keys.RECIPE_SERIALIZERS, helper -> CraftingHelper.register(ConfigEnabledCondition.Serializer.INSTANCE));
        }
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ForgeRegistry {

        @SubscribeEvent
        public static void onLivingDrops(final LivingDropsEvent event) {
            if (!event.getEntity().isBaby()) {
                for (Class<?> entityClass : DROP_LIST.keySet()) {
                    if (entityClass.isInstance(event.getEntity())) {
                        ItemEntity item = DROP_LIST.get(entityClass).getDrop(event.getEntity());
                        if (item != null) {
                            event.getDrops().add(item);
                        }
                        break;
                    }
                }
            }
        }

        @SubscribeEvent
        public static void onLivingEntityUseItem(LivingEntityUseItemEvent.Finish event) {
            if (event.getEntity() instanceof Player player) {
                if (isBowl(event.getItem().getItem()) && !player.isCreative()) {
                    ItemStack result = event.getResultStack().copy();
                    ItemStack itemStack = event.getItem().copy();
                    itemStack.setCount(itemStack.getCount() - 1);
                    event.setResultStack(itemStack);
                    if (itemStack.isEmpty()) {
                        event.setResultStack(result);
                    } else if (!player.getInventory().add(result.copy())) {
                        player.drop(result, false);
                    }
                }
            }
        }

        private static boolean isBowl(Item item) {
            for (String s : FoodExpansionConfig.bowlStackSizeItems) {
                Item bowl = ForgeRegistries.ITEMS.getValue(new ResourceLocation(s));

                if (bowl != null && bowl.equals(item)) {
                    return true;
                }
            }

            return false;
        }
    }

    public static class Drop {
        public boolean cfgDisable, alwaysDrop;
        public Item uncooked, cooked;
        public int maxDropAmount;

        public Drop(boolean cfgDisable, Item uncooked, Item cooked, int maxDropAmount, boolean alwaysDrop) {
            this.cfgDisable = cfgDisable;
            this.uncooked = uncooked;
            this.cooked = cooked;
            this.maxDropAmount = maxDropAmount;
            this.alwaysDrop = alwaysDrop;
        }

        public ItemEntity getDrop(LivingEntity entity) {
            if (!cfgDisable) {
                int count = alwaysDrop ? entity.level.getRandom().nextInt(maxDropAmount) + 1 : entity.level.getRandom().nextInt(maxDropAmount + 1);
                if (count > 0) {
                    return new ItemEntity(entity.level, entity.position().x, entity.position().y + 0.5D, entity.position().z, new ItemStack(entity.isOnFire() ? cooked : uncooked, count));
                }
            }
            return null;
        }
    }
}
