package lellson.foodexpansion;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class FoodExpansionItemGroup extends CreativeModeTab {

    public FoodExpansionItemGroup() {
        super("foodexpansion_tab");
    }

    @Override
    public @NotNull ItemStack makeIcon() {
        return new ItemStack(FoodItems.BACON_AND_EGG.get());
    }
}
