package lellson.foodexpansion.config;

import com.google.common.collect.Lists;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

final class CommonConfig {
    final ForgeConfigSpec.BooleanValue disableRecipeBacon;
    final ForgeConfigSpec.BooleanValue disableRecipeCookedBacon;
    final ForgeConfigSpec.BooleanValue disableRecipeBaconAndEgg;
    final ForgeConfigSpec.BooleanValue disableRecipeBlazeCream;
    final ForgeConfigSpec.BooleanValue disableRecipeCactusFruit;
    final ForgeConfigSpec.BooleanValue disableRecipeCarrotSeedSoup;
    final ForgeConfigSpec.BooleanValue disableRecipeChocolateBar;
    final ForgeConfigSpec.BooleanValue disableRecipeCompressedFlesh;
    final ForgeConfigSpec.BooleanValue disableRecipeCookedBatWing;
    final ForgeConfigSpec.BooleanValue disableRecipeCookedHorseMeat;
    final ForgeConfigSpec.BooleanValue disableRecipeCookedMushroom;
    final ForgeConfigSpec.BooleanValue disableRecipeCookedSquid;
    final ForgeConfigSpec.BooleanValue disableRecipeCookedWolfMeat;
    final ForgeConfigSpec.BooleanValue disableRecipeCookedOcelotMeat;
    final ForgeConfigSpec.BooleanValue disableRecipeFriedEgg;
    final ForgeConfigSpec.BooleanValue disableRecipeJelly;
    final ForgeConfigSpec.BooleanValue disableRecipeNetherWartStew;
    final ForgeConfigSpec.BooleanValue disableRecipeCarrotPie;
    final ForgeConfigSpec.BooleanValue disableRecipeSpiderSoup;
    final ForgeConfigSpec.BooleanValue disableRecipeCompressedToLeather;
    final ForgeConfigSpec.BooleanValue disableRecipeBatToLeather;
    final ForgeConfigSpec.BooleanValue disableForbiddenFruit;
    final ForgeConfigSpec.BooleanValue disableMelonSalad;
    final ForgeConfigSpec.BooleanValue disableRoastedSeed;
    final ForgeConfigSpec.BooleanValue disableDough;
    final ForgeConfigSpec.BooleanValue disableStarvingFruit;
    final ForgeConfigSpec.BooleanValue disableLollipop;
    final ForgeConfigSpec.BooleanValue disableBeetrootNoodles;
    final ForgeConfigSpec.BooleanValue disableRecipeCookedParrotMeat;
    final ForgeConfigSpec.BooleanValue disableRecipeCookedLlamaMeat;
    final ForgeConfigSpec.BooleanValue disableRecipeCookedPolarBearMeat;
    final ForgeConfigSpec.BooleanValue disableSquidDrop;
    final ForgeConfigSpec.BooleanValue disableHorseMeatDrop;
    final ForgeConfigSpec.BooleanValue disableBatWingDrop;
    final ForgeConfigSpec.BooleanValue disableWolfMeatDrop;
    final ForgeConfigSpec.BooleanValue disableOcelotMeatDrop;
    final ForgeConfigSpec.BooleanValue disableParrotMeatDrop;
    final ForgeConfigSpec.BooleanValue disableLlamaMeatDrop;
    final ForgeConfigSpec.BooleanValue disablePolarBearMeatDrop;

    //NEW FOOD RECIPES
    final ForgeConfigSpec.BooleanValue disableRecipeVeggieStew;
    final ForgeConfigSpec.BooleanValue disableRecipeBatSoup;
    final ForgeConfigSpec.BooleanValue disableRecipeGoldenFeast;
    final ForgeConfigSpec.BooleanValue disableRecipeChocolateCake;

    final ForgeConfigSpec.ConfigValue<List<String>> bowlStackSizeItems;

    private static final String DISABLERECIPE_Bacon = "Disable Bacon Recipe";
    private static final String DISABLERECIPE_CookedBacon = "Disable Cooked Bacon Smelting Recipe";
    private static final String DISABLERECIPE_BaconAndEgg = "Disable Bacon And Egg Recipe";
    private static final String DISABLERECIPE_BlazeCream = "Disable Blaze Cream Recipe";
    private static final String DISABLERECIPE_CactusFruit = "Disable Cactus Fruit Recipe";
    private static final String DISABLERECIPE_CarrotSeedSoup = "Disable Carrot Seed Soup Recipe";
    private static final String DISABLERECIPE_ChocolateBar = "Disable Chocolate Bar Recipe";
    private static final String DISABLERECIPE_CompressedFlesh = "Disable Compressed Flesh Recipe";
    private static final String DISABLERECIPE_CookedMushroom = "Disable Cooked Mushroom Smelting Recipe";
    private static final String DISABLERECIPE_CookedSquid = "Disable Cooked Squid Smelting Recipe";
    private static final String DISABLERECIPE_CookedBatWing = "Disable Cooked Bat Wing Smelting Recipe";
    private static final String DISABLERECIPE_CookedHorseMeat = "Disable Cooked Horse Meat Smelting Recipe";
    private static final String DISABLERECIPE_CookedWolfMeat = "Disable Cooked Wolf Meat Smelting Recipe";
    private static final String DISABLERECIPE_CookedOcelotMeat = "Disable Cooked Ocelot Meat Smelting Recipe";
    private static final String DISABLERECIPE_CookedParrotMeat = "Disable Cooked Parrot Meat Smelting Recipe";
    private static final String DISABLERECIPE_CookedLlamaMeat = "Disable Llama Steak Smelting Recipe";
    private static final String DISABLERECIPE_CookedPolarBearMeat = "Disable Polar Bear Steak Smelting Recipe";
    private static final String DISABLERECIPE_FriedEgg = "Disable Fried Egg Smelting Recipe";
    private static final String DISABLERECIPE_Jelly = "Disable Jelly Recipe";
    private static final String DISABLERECIPE_NetherWartStew = "Disable Nether Wart Stew Recipe";
    private static final String DISABLERECIPE_CarrotPie = "Disable Carrot Pie Recipe";
    private static final String DISABLERECIPE_SpiderSoup = "Disable Spider Soup Recipe";
    private static final String DISABLERECIPE_CompressedToLeather = "Disable Compressed Flesh to Leather Smelting Recipe";
    private static final String DISABLERECIPE_BatToLeather = "Disable Bat Wing to Leather Recipe";
    private static final String DISABLERECIPE_ForbiddenFruit = "Disable Recipe for the Forbidden Fruit (8 Notch Apples + 1 Diamond Block)";
    private static final String DISABLERECIPE_StarvingFruit = "Disable Recipe for the Starving Fruit (8 Rotten Flesh + 1 Diamond Block)";
    private static final String DISABLERECIPE_MelonSalad = "Disable Melon Salad Recipe";
    private static final String DISABLERECIPE_RoastedSeed = "Disable Roasted Seed Recipe";
    private static final String DISABLERECIPE_Dough = "Disable Dough Recipe";
    private static final String DISABLERECIPE_Lollipop = "Disable Lollipop Recipe";
    private static final String DISABLERECIPE_BeetrootNoodles = "Disable Beetroot Noodles Recipe";
    private static final String DISABLEDROP_SquidDrop = "If set to true, squids are not allowed to drop Squid Meat";
    private static final String DISABLEDROP_HorseMeatDrop = "If set to true, horses are not allowed to drop Horse Meat";
    private static final String DISABLEDROP_BatWingDrop = "If set to true, bats are not allowed to drop Bat Wings";
    private static final String DISABLEDROP_WolfMeatDrop = "If set to true, wolves are not allowed to drop Wolf Meat";
    private static final String DISABLEDROP_OcelotMeatDrop = "If set to true, ocelots are not allowed to drop Ocelot Meat";
    private static final String DISABLEDROP_ParrotMeatDrop = "If set to true, parrots are not allowed to drop Parrot Meat";
    private static final String DISABLEDROP_LlamaMeatDrop = "If set to true, llamas are not allowed to drop Llama Meat";
    private static final String DISABLEDROP_PolarBearMeatDrop = "If set to true, polar bears are not allowed to drop Polar Bear Meat";

    //NEW FOOD RECIPES
    private static final String DISABLERECIPE_VeggieStew = "Disable Veggie Stew Recipe";
    private static final String DISABLERECIPE_BatSoup = "Disable Bat Soup Recipe";
    private static final String DISABLERECIPE_GoldenFeast = "Disable Golden Feast Recipe";
    private static final String DISABLERECIPE_ChocolateCake = "Disable Chocolate Cake Recipe";

    private static final String STACKSIZE_BowlItems = "Items defined here have their stacksize increased to 64";

    CommonConfig(final ForgeConfigSpec.Builder builder) {
        builder.comment("General Settings").push("general");
        bowlStackSizeItems = builder
                .comment(STACKSIZE_BowlItems)
                .define("bowlStackSizeItems", Lists.newArrayList("minecraft:mushroom_stew", "minecraft:rabbit_stew", "minecraft:beetroot_soup", "foodexpansion:melon_salad", "foodexpansion:carrot_seed_soup", "foodexpansion:blaze_cream", "foodexpansion:nether_wart_soup", "foodexpansion:spider_soup", "foodexpansion:beetroot_noodles", "foodexpansion:veggie_stew", "foodexpansion:bat_soup", "foodexpansion:golden_feast"));
        builder.pop();

        builder.comment("Set to true, to disable the Recipes").push("general.disable_recipes");
        disableRecipeBacon = builder
                .comment(DISABLERECIPE_Bacon)
                .define("disableRecipeBacon", false);
        disableRecipeCookedBacon = builder
                .comment(DISABLERECIPE_CookedBacon)
                .define("disableRecipeCookedBacon", false);
        disableRecipeBaconAndEgg = builder
                .comment(DISABLERECIPE_BaconAndEgg)
                .define("disableRecipeBaconAndEgg", false);
        disableRecipeBlazeCream = builder
                .comment(DISABLERECIPE_BlazeCream)
                .define("disableRecipeBlazeCream", false);
        disableRecipeCactusFruit = builder
                .comment(DISABLERECIPE_CactusFruit)
                .define("disableRecipeCactusFruit", false);
        disableRecipeCarrotSeedSoup = builder
                .comment(DISABLERECIPE_CarrotSeedSoup)
                .define("disableRecipeCarrotSeedSoup", false);
        disableRecipeChocolateBar = builder
                .comment(DISABLERECIPE_ChocolateBar)
                .define("disableRecipeChocolateBar", false);
        disableRecipeCompressedFlesh = builder
                .comment(DISABLERECIPE_CompressedFlesh)
                .define("disableRecipeCompressedFlesh", false);
        disableRecipeCookedBatWing = builder
                .comment(DISABLERECIPE_CookedBatWing)
                .define("disableRecipeCookedBatWing", false);
        disableRecipeCookedHorseMeat = builder
                .comment(DISABLERECIPE_CookedHorseMeat)
                .define("disableRecipeCookedHorseMeat", false);
        disableRecipeCookedMushroom = builder
                .comment(DISABLERECIPE_CookedMushroom)
                .define("disableRecipeCookedMushroom", false);
        disableRecipeCookedSquid = builder
                .comment(DISABLERECIPE_CookedSquid)
                .define("disableRecipeCookedSquid", false);
        disableRecipeCookedWolfMeat = builder
                .comment(DISABLERECIPE_CookedWolfMeat)
                .define("disableRecipeCookedWolfMeat", false);
        disableRecipeCookedOcelotMeat = builder
                .comment(DISABLERECIPE_CookedOcelotMeat)
                .define("disableRecipeCookedOcelotMeat", false);
        disableRecipeFriedEgg = builder
                .comment(DISABLERECIPE_FriedEgg)
                .define("disableRecipeFriedEgg", false);
        disableRecipeJelly = builder
                .comment(DISABLERECIPE_Jelly)
                .define("disableRecipeJelly", false);
        disableRecipeNetherWartStew = builder
                .comment(DISABLERECIPE_NetherWartStew)
                .define("disableRecipeNetherWartStew", false);
        disableRecipeCarrotPie = builder
                .comment(DISABLERECIPE_CarrotPie)
                .define("disableRecipeCarrotPie", false);
        disableRecipeSpiderSoup = builder
                .comment(DISABLERECIPE_SpiderSoup)
                .define("disableRecipeSpiderSoup", false);
        disableRecipeCompressedToLeather = builder
                .comment(DISABLERECIPE_CompressedToLeather)
                .define("disableRecipeCompressedToLeather", false);
        disableRecipeBatToLeather = builder
                .comment(DISABLERECIPE_BatToLeather)
                .define("disableRecipeBatToLeather", false);
        disableForbiddenFruit = builder
                .comment(DISABLERECIPE_ForbiddenFruit)
                .define("disableForbiddenFruit", true);
        disableMelonSalad = builder
                .comment(DISABLERECIPE_MelonSalad)
                .define("disableMelonSalad", false);
        disableRoastedSeed = builder
                .comment(DISABLERECIPE_RoastedSeed)
                .define("disableRoastedSeed", false);
        disableDough = builder
                .comment(DISABLERECIPE_Dough)
                .define("disableDough", false);
        disableStarvingFruit = builder
                .comment(DISABLERECIPE_StarvingFruit)
                .define("disableStarvingFruit", true);
        disableLollipop = builder
                .comment(DISABLERECIPE_Lollipop)
                .define("disableLollipop", false);
        disableBeetrootNoodles = builder
                .comment(DISABLERECIPE_BeetrootNoodles)
                .define("disableBeetrootNoodles", false);
        disableRecipeCookedParrotMeat = builder
                .comment(DISABLERECIPE_CookedParrotMeat)
                .define("disableRecipeCookedParrotMeat", false);
        disableRecipeCookedLlamaMeat = builder
                .comment(DISABLERECIPE_CookedLlamaMeat)
                .define("disableRecipeCookedLlamaMeat", false);
        disableRecipeCookedPolarBearMeat = builder
                .comment(DISABLERECIPE_CookedPolarBearMeat)
                .define("disableRecipeCookedPolarBearMeat", false);

        //NEW FOOD RECIPES
        disableRecipeVeggieStew = builder
                .comment(DISABLERECIPE_VeggieStew)
                .define("disableRecipeVeggieStew", false);
        disableRecipeBatSoup = builder
                .comment(DISABLERECIPE_BatSoup)
                .define("disableRecipeBatSoup", false);
        disableRecipeGoldenFeast = builder
                .comment(DISABLERECIPE_GoldenFeast)
                .define("disableRecipeGoldenFeast", false);
        disableRecipeChocolateCake = builder
                .comment(DISABLERECIPE_ChocolateCake)
                .define("disableRecipeChocolateCake", false);
        builder.pop();

        builder.comment("Set to true, to disable the Mobdrops").push("disable_mobdrops");
        disableSquidDrop = builder
                .comment(DISABLEDROP_SquidDrop)
                .define("disableSquidDrop", false);
        disableHorseMeatDrop = builder
                .comment(DISABLEDROP_HorseMeatDrop)
                .define("disableHorseMeatDrop", false);
        disableBatWingDrop = builder
                .comment(DISABLEDROP_BatWingDrop)
                .define("disableBatWingDrop", false);
        disableWolfMeatDrop = builder
                .comment(DISABLEDROP_WolfMeatDrop)
                .define("disableWolfMeatDrop", false);
        disableOcelotMeatDrop = builder
                .comment(DISABLEDROP_OcelotMeatDrop)
                .define("disableOcelotMeatDrop", false);
        disableParrotMeatDrop = builder
                .comment(DISABLEDROP_ParrotMeatDrop)
                .define("disableParrotMeatDrop", false);
        disableLlamaMeatDrop = builder
                .comment(DISABLEDROP_LlamaMeatDrop)
                .define("disableLlamaMeatDrop", false);
        disablePolarBearMeatDrop = builder
                .comment(DISABLEDROP_PolarBearMeatDrop)
                .define("disablePolarBearMeatDrop", false);
        builder.pop();
    }
}
