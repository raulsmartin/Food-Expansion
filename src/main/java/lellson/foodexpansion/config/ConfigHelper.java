package lellson.foodexpansion.config;

import lellson.foodexpansion.FoodExpansionConfig;
import net.minecraftforge.fml.config.ModConfig;

public final class ConfigHelper {

    public static void bakeCommon(final ModConfig config) {
        FoodExpansionConfig.disableRecipeBacon = ConfigHolder.COMMON.disableRecipeBacon.get();
        FoodExpansionConfig.disableRecipeCookedBacon = ConfigHolder.COMMON.disableRecipeCookedBacon.get();
        FoodExpansionConfig.disableRecipeBaconAndEgg = ConfigHolder.COMMON.disableRecipeBaconAndEgg.get();
        FoodExpansionConfig.disableRecipeBlazeCream = ConfigHolder.COMMON.disableRecipeBlazeCream.get();
        FoodExpansionConfig.disableRecipeCactusFruit = ConfigHolder.COMMON.disableRecipeCactusFruit.get();
        FoodExpansionConfig.disableRecipeCarrotSeedSoup = ConfigHolder.COMMON.disableRecipeCarrotSeedSoup.get();
        FoodExpansionConfig.disableRecipeChocolateBar = ConfigHolder.COMMON.disableRecipeChocolateBar.get();
        FoodExpansionConfig.disableRecipeCompressedFlesh = ConfigHolder.COMMON.disableRecipeCompressedFlesh.get();
        FoodExpansionConfig.disableRecipeCookedBatWing = ConfigHolder.COMMON.disableRecipeCookedBatWing.get();
        FoodExpansionConfig.disableRecipeCookedHorseMeat = ConfigHolder.COMMON.disableRecipeCookedHorseMeat.get();
        FoodExpansionConfig.disableRecipeCookedMushroom = ConfigHolder.COMMON.disableRecipeCookedMushroom.get();
        FoodExpansionConfig.disableRecipeCookedSquid = ConfigHolder.COMMON.disableRecipeCookedSquid.get();
        FoodExpansionConfig.disableRecipeCookedWolfMeat = ConfigHolder.COMMON.disableRecipeCookedWolfMeat.get();
        FoodExpansionConfig.disableRecipeCookedOcelotMeat = ConfigHolder.COMMON.disableRecipeCookedOcelotMeat.get();
        FoodExpansionConfig.disableRecipeFriedEgg = ConfigHolder.COMMON.disableRecipeFriedEgg.get();
        FoodExpansionConfig.disableRecipeJelly = ConfigHolder.COMMON.disableRecipeJelly.get();
        FoodExpansionConfig.disableRecipeNetherWartStew = ConfigHolder.COMMON.disableRecipeNetherWartStew.get();
        FoodExpansionConfig.disableRecipeCarrotPie = ConfigHolder.COMMON.disableRecipeCarrotPie.get();
        FoodExpansionConfig.disableRecipeSpiderSoup = ConfigHolder.COMMON.disableRecipeSpiderSoup.get();
        FoodExpansionConfig.disableRecipeCompressedToLeather = ConfigHolder.COMMON.disableRecipeCompressedToLeather.get();
        FoodExpansionConfig.disableRecipeBatToLeather = ConfigHolder.COMMON.disableRecipeBatToLeather.get();
        FoodExpansionConfig.disableSquidDrop = ConfigHolder.COMMON.disableSquidDrop.get();
        FoodExpansionConfig.disableHorseMeatDrop = ConfigHolder.COMMON.disableHorseMeatDrop.get();
        FoodExpansionConfig.disableBatWingDrop = ConfigHolder.COMMON.disableBatWingDrop.get();
        FoodExpansionConfig.disableWolfMeatDrop = ConfigHolder.COMMON.disableWolfMeatDrop.get();
        FoodExpansionConfig.disableOcelotMeatDrop = ConfigHolder.COMMON.disableOcelotMeatDrop.get();
        FoodExpansionConfig.disableForbiddenFruit = ConfigHolder.COMMON.disableForbiddenFruit.get();
        FoodExpansionConfig.disableMelonSalad = ConfigHolder.COMMON.disableMelonSalad.get();
        FoodExpansionConfig.disableRoastedSeed = ConfigHolder.COMMON.disableRoastedSeed.get();
        FoodExpansionConfig.disableDough = ConfigHolder.COMMON.disableDough.get();
        FoodExpansionConfig.disableStarvingFruit = ConfigHolder.COMMON.disableStarvingFruit.get();
        FoodExpansionConfig.disableLollipop = ConfigHolder.COMMON.disableLollipop.get();
        FoodExpansionConfig.disableBeetrootNoodles = ConfigHolder.COMMON.disableBeetrootNoodles.get();
        FoodExpansionConfig.disableRecipeCookedParrotMeat = ConfigHolder.COMMON.disableRecipeCookedParrotMeat.get();
        FoodExpansionConfig.disableRecipeCookedLlamaMeat = ConfigHolder.COMMON.disableRecipeCookedLlamaMeat.get();
        FoodExpansionConfig.disableRecipeCookedPolarBearMeat = ConfigHolder.COMMON.disableRecipeCookedPolarBearMeat.get();
        FoodExpansionConfig.disableParrotMeatDrop = ConfigHolder.COMMON.disableParrotMeatDrop.get();
        FoodExpansionConfig.disableLlamaMeatDrop = ConfigHolder.COMMON.disableLlamaMeatDrop.get();
        FoodExpansionConfig.disablePolarBearMeatDrop = ConfigHolder.COMMON.disablePolarBearMeatDrop.get();

        //NEW FOOD RECIPES
        FoodExpansionConfig.disableRecipeVeggieStew = ConfigHolder.COMMON.disableRecipeVeggieStew.get();
        FoodExpansionConfig.disableRecipeBatSoup = ConfigHolder.COMMON.disableRecipeBatSoup.get();
        FoodExpansionConfig.disableRecipeGoldenFeast = ConfigHolder.COMMON.disableRecipeGoldenFeast.get();
        FoodExpansionConfig.disableRecipeChocolateCake = ConfigHolder.COMMON.disableRecipeChocolateCake.get();

        FoodExpansionConfig.bowlStackSizeItems = ConfigHolder.COMMON.bowlStackSizeItems.get();
    }

    private static void setValueAndSave(final ModConfig modConfig, final String path, final Object newValue) {
        modConfig.getConfigData().set(path, newValue);
        modConfig.save();
    }
}