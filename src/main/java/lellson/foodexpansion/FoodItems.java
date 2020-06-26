package lellson.foodexpansion;

import lellson.foodexpansion.items.BasicFoodItem;
import lellson.foodexpansion.items.ForbiddenFruitItem;
import lellson.foodexpansion.items.LollipopItem;
import lellson.foodexpansion.items.NetherWartSoupItem;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.List;

public class FoodItems {
    public static final List<Item> ITEM_LIST = new ArrayList<>();

    public static Item jelly;
    public static Item bacon;
    public static Item cookedBacon;
    public static Item friedEgg;
    public static Item baconAndEgg;
    public static Item carrotSeedSoup;
    public static Item squid;
    public static Item cookedSquid;
    public static Item compressedFlesh;
    public static Item chocolateBar;
    public static Item spiderSoup;
    public static Item netherWartSoup;
    public static Item cactusFruit;
    public static Item horseMeat;
    public static Item cookedHorseMeat;
    public static Item cookedMushroom;
    public static Item carrotPie;
    public static Item batWing;
    public static Item cookedBatWing;
    public static Item blazeCream;
    public static Item melonSalad;
    public static Item roastedSeed;
    public static Item dough;
    public static Item wolfMeat;
    public static Item cookedWolfMeat;
    public static Item ocelotMeat;
    public static Item cookedOcelotMeat;
    public static Item lollipop;
    public static Item forbiddenFruit;
    public static Item starvingFruit;
    public static Item beetrootNoodles;
    public static Item parrotMeat;
    public static Item cookedParrotMeat;
    public static Item llamaMeat;
    public static Item cookedLlamaMeat;
    public static Item polarBearMeat;
    public static Item cookedPolarBearMeat;

    public static void init() {
        jelly = new BasicFoodItem("jelly", FoodTypes.JELLY);
        bacon = new BasicFoodItem("bacon", FoodTypes.BACON);
        cookedBacon = new BasicFoodItem("cooked_bacon", FoodTypes.COOKED_BACON);
        friedEgg = new BasicFoodItem("fried_egg", FoodTypes.FRIED_EGG);
        baconAndEgg = new BasicFoodItem("bacon_and_egg", FoodTypes.BACON_AND_EGG);
        carrotSeedSoup = new BasicFoodItem("carrot_seed_soup", FoodTypes.CARROT_SEED_SOUP, true);
        squid = new BasicFoodItem("squid", FoodTypes.SQUID);
        cookedSquid = new BasicFoodItem("cooked_squid", FoodTypes.COOKED_SQUID);
        compressedFlesh = new BasicFoodItem("compressed_flesh", FoodTypes.COMPRESSED_FLESH);
        chocolateBar = new BasicFoodItem("chocolate_bar", FoodTypes.CHOCOLATE_BAR);
        spiderSoup = new BasicFoodItem("spider_soup", FoodTypes.SPIDER_SOUP, true);
        netherWartSoup = new NetherWartSoupItem();
        cactusFruit = new BasicFoodItem("cactus_fruit", FoodTypes.CACTUS_FRUIT);
        horseMeat = new BasicFoodItem("horse_meat", FoodTypes.HORSE_MEAT);
        cookedHorseMeat = new BasicFoodItem("cooked_horse_meat", FoodTypes.COOKED_HORSE_MEAT);
        cookedMushroom = new BasicFoodItem("cooked_mushroom", FoodTypes.COOKED_MUSHROOM);
        carrotPie = new BasicFoodItem("carrot_pie", FoodTypes.CARROT_PIE);
        batWing = new BasicFoodItem("bat_wing", FoodTypes.BAT_WING);
        cookedBatWing = new BasicFoodItem("cooked_bat_wing", FoodTypes.COOKED_BAT_WING);
        blazeCream = new BasicFoodItem("blaze_cream", FoodTypes.BLAZE_CREAM, true);
        melonSalad = new BasicFoodItem("melon_salad", FoodTypes.MELON_SALAD, true);
        roastedSeed = new BasicFoodItem("roasted_seed", FoodTypes.ROASTED_SEED);
        dough = new Item(new Item.Properties().group(FoodExpansion.ITEM_GROUP)).setRegistryName(new ResourceLocation(Reference.MODID, "dough"));
        ITEM_LIST.add(dough);
        wolfMeat = new BasicFoodItem("wolf_meat", FoodTypes.WOLF_MEAT);
        cookedWolfMeat = new BasicFoodItem("cooked_wolf_meat", FoodTypes.COOKED_WOLF_MEAT);
        ocelotMeat = new BasicFoodItem("ocelot_meat", FoodTypes.OCELOT_MEAT);
        cookedOcelotMeat = new BasicFoodItem("cooked_ocelot_meat", FoodTypes.COOKED_OCELOT_MEAT);
        lollipop = new LollipopItem();
        beetrootNoodles = new BasicFoodItem("beetroot_noodles", FoodTypes.BEETROOT_NOODLES, true);
        parrotMeat = new BasicFoodItem("parrot_meat", FoodTypes.PARROT_MEAT);
        cookedParrotMeat = new BasicFoodItem("cooked_parrot_meat", FoodTypes.COOKED_PARROT_MEAT);
        llamaMeat = new BasicFoodItem("llama_meat", FoodTypes.LLAMA_MEAT);
        cookedLlamaMeat = new BasicFoodItem("cooked_llama_meat", FoodTypes.COOKED_LLAMA_MEAT);
        polarBearMeat = new BasicFoodItem("polar_bear_meat", FoodTypes.POLAR_BEAR_MEAT);
        cookedPolarBearMeat = new BasicFoodItem("cooked_polar_bear_meat", FoodTypes.COOKED_POLAR_BEAR_MEAT);
        forbiddenFruit = new ForbiddenFruitItem("forbidden_fruit", true);
        starvingFruit = new ForbiddenFruitItem("starving_fruit", false);
    }

    public static void increaseStackSizes() {
        for (String s : FoodExpansionConfig.bowlStackSizeItems) {
            Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(s));
            if (item != null) {
                LogManager.getLogger(Reference.MODID).info("Food Expansion: Increasing stack of " + s + "...");
                item.maxStackSize = 64;
            } else {
                LogManager.getLogger(Reference.MODID).warn("Food Expansion: Couldn't increase stack size. " + s + " is not a valid item!");
            }
        }
    }
}
