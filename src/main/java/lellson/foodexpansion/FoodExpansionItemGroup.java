package lellson.foodexpansion;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class FoodExpansionItemGroup extends ItemGroup {

    public FoodExpansionItemGroup() {
        super("foodexpansion_tab");
    }

    @Nonnull
    @Override
    public ItemStack createIcon() {
        return new ItemStack(FoodItems.BACON_AND_EGG.get());
    }
}
