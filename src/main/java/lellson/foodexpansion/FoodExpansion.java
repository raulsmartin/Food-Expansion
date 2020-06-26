package lellson.foodexpansion;

import lellson.foodexpansion.config.ConfigHelper;
import lellson.foodexpansion.config.ConfigHolder;
import lellson.foodexpansion.crafting.conditions.ConfigEnabledCondition;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.passive.horse.LlamaEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;

@Mod(Reference.MODID)
public class FoodExpansion {
    public static final ItemGroup ITEM_GROUP = new FoodExpansionItemGroup();
    public static final Map<Class<?>, Drop> DROP_LIST = new HashMap<>();

    public static FoodExpansion instance;

    public FoodExpansion() {
        instance = this;

        final ModLoadingContext modLoadingContext = ModLoadingContext.get();
        modLoadingContext.registerConfig(ModConfig.Type.COMMON, ConfigHolder.COMMON_SPEC);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCommonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void onCommonSetup(final FMLCommonSetupEvent event) {
        FoodItems.increaseStackSizes();

        addDrop(FoodExpansionConfig.disableSquidDrop, SquidEntity.class, FoodItems.squid, FoodItems.cookedSquid, 2);
        addDrop(FoodExpansionConfig.disableHorseMeatDrop, HorseEntity.class, FoodItems.horseMeat, FoodItems.cookedHorseMeat, 3, true);
        addDrop(FoodExpansionConfig.disableBatWingDrop, BatEntity.class, FoodItems.batWing, FoodItems.cookedBatWing, 1);
        addDrop(FoodExpansionConfig.disableWolfMeatDrop, WolfEntity.class, FoodItems.wolfMeat, FoodItems.cookedWolfMeat, 2, true);
        addDrop(FoodExpansionConfig.disableOcelotMeatDrop, OcelotEntity.class, FoodItems.ocelotMeat, FoodItems.cookedOcelotMeat, 1, true);
        addDrop(FoodExpansionConfig.disableParrotMeatDrop, ParrotEntity.class, FoodItems.parrotMeat, FoodItems.cookedParrotMeat, 1, true);
        addDrop(FoodExpansionConfig.disableLlamaMeatDrop, LlamaEntity.class, FoodItems.llamaMeat, FoodItems.cookedLlamaMeat, 2, true);
        addDrop(FoodExpansionConfig.disablePolarBearMeatDrop, PolarBearEntity.class, FoodItems.polarBearMeat, FoodItems.cookedPolarBearMeat, 3, true);
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
        public static void onModConfig(final ModConfig.ModConfigEvent event) {
            final ModConfig config = event.getConfig();
            if (config.getSpec() == ConfigHolder.COMMON_SPEC) {
                ConfigHelper.bakeCommon(config);
            }
        }

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            FoodItems.init();

            for (Item item : FoodItems.ITEM_LIST) {
                event.getRegistry().register(item);
            }
        }

        @SubscribeEvent
        public static void registerRecipeSerializers(final RegistryEvent.Register<IRecipeSerializer<?>> event) {
            CraftingHelper.register(ConfigEnabledCondition.Serializer.INSTANCE);
        }
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ForgeRegistry {

        @SubscribeEvent
        public static void onLivingDrops(final LivingDropsEvent event) {
            if (!event.getEntityLiving().isChild()) {
                for (Class<?> entityClass : DROP_LIST.keySet()) {
                    if (entityClass.isInstance(event.getEntityLiving())) {
                        ItemEntity item = DROP_LIST.get(entityClass).getDrop(event.getEntityLiving());
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
            if (event.getEntityLiving() instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) event.getEntityLiving();

                if (isBowl(event.getItem().getItem()) && !player.isCreative()) {
                    ItemStack result = event.getResultStack().copy();
                    ItemStack itemStack = event.getItem().copy();
                    itemStack.setCount(itemStack.getCount() - 1);
                    event.setResultStack(itemStack);
                    if (itemStack.isEmpty()) {
                        event.setResultStack(result);
                    } else if (!player.inventory.addItemStackToInventory(result.copy())) {
                        player.dropItem(result, false);
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
                int count = alwaysDrop ? entity.world.rand.nextInt(maxDropAmount) + 1 : entity.world.rand.nextInt(maxDropAmount + 1);
                if (count > 0) {
                    return new ItemEntity(entity.world, entity.getPosX(), entity.getPosY() + 0.5D, entity.getPosZ(), new ItemStack(entity.isBurning() ? cooked : uncooked, count));
                }
            }
            return null;
        }
    }
}
