package lellson.foodexpansion;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class FoodTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Reference.MODID);

    public static final RegistryObject<CreativeModeTab> FOOD_TAB = TABS.register("foodexpansion_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.foodexpansion_tab"))
            .icon(FoodItems.BACON_AND_EGG.get()::getDefaultInstance)
            .displayItems((params, output) -> {
                FoodItems.ITEMS.getEntries().forEach(item -> output.accept(item.get()));
                FoodBlocks.BLOCKS.getEntries().forEach(block -> output.accept(block.get()));
            })
            .withTabsBefore(CreativeModeTabs.FOOD_AND_DRINKS)
            .build());
}
