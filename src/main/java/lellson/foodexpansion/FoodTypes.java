package lellson.foodexpansion;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class FoodTypes {
    public static final FoodProperties JELLY = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).effect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0), 1F).alwaysEat().build();
    public static final FoodProperties BACON = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.2F).meat().fast().build();
    public static final FoodProperties COOKED_BACON = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).meat().fast().build();
    public static final FoodProperties FRIED_EGG = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).build();
    public static final FoodProperties BACON_AND_EGG = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.8F).build();
    public static final FoodProperties CARROT_SEED_SOUP = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.8F).build();
    public static final FoodProperties SQUID = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.2F).build();
    public static final FoodProperties COOKED_SQUID = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.5F).build();
    public static final FoodProperties COMPRESSED_FLESH = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.2F).meat().build();
    public static final FoodProperties CHOCOLATE_BAR = (new FoodProperties.Builder()).nutrition(8).saturationMod(1.0F).build();
    public static final FoodProperties SPIDER_SOUP = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.4F).effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 200, 0), 1F).alwaysEat().build();
    public static final FoodProperties NETHER_WART_SOUP = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).alwaysEat().build();
    public static final FoodProperties CACTUS_FRUIT = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).build();
    public static final FoodProperties HORSE_MEAT = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).meat().build();
    public static final FoodProperties COOKED_HORSE_MEAT = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.8F).meat().build();
    public static final FoodProperties COOKED_MUSHROOM = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F).build();
    public static final FoodProperties CARROT_PIE = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.8F).build();
    public static final FoodProperties BAT_WING = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.HUNGER, 200, 0), 0.5F).build();
    public static final FoodProperties COOKED_BAT_WING = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.2F).effect(new MobEffectInstance(MobEffects.HUNGER, 200, 0), 0.14F).build();
    public static final FoodProperties BLAZE_CREAM = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300, 0), 1F).alwaysEat().build();
    public static final FoodProperties MELON_SALAD = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).build();
    public static final FoodProperties ROASTED_SEED = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).build();
    public static final FoodProperties WOLF_MEAT = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).meat().build();
    public static final FoodProperties COOKED_WOLF_MEAT = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.7F).meat().build();
    public static final FoodProperties OCELOT_MEAT = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).meat().build();
    public static final FoodProperties COOKED_OCELOT_MEAT = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.7F).meat().build();
    public static final FoodProperties LOLLIPOP = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.5F).build();
    public static final FoodProperties BEETROOT_NOODLES = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).build();
    public static final FoodProperties PARROT_MEAT = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).meat().build();
    public static final FoodProperties COOKED_PARROT_MEAT = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.7F).meat().build();
    public static final FoodProperties LLAMA_MEAT = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).meat().build();
    public static final FoodProperties COOKED_LLAMA_MEAT = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.8F).meat().build();
    public static final FoodProperties POLAR_BEAR_MEAT = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).meat().build();
    public static final FoodProperties COOKED_POLAR_BEAR_MEAT = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.8F).meat().build();

    //NEW FOOD TYPES
    public static final FoodProperties VEGGIE_STEW = (new FoodProperties.Builder()).nutrition(10).saturationMod(1F).build();
    public static final FoodProperties BAT_SOUP = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0), 1F).alwaysEat().build();
    public static final FoodProperties GOLDEN_FEAST = (new FoodProperties.Builder()).nutrition(14).saturationMod(1F).effect(new MobEffectInstance(MobEffects.SATURATION, 2400, 0), 1F).alwaysEat().build();

}
