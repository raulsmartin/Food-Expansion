package lellson.foodexpansion.items;

import lellson.foodexpansion.FoodExpansion;
import lellson.foodexpansion.FoodItems;
import lellson.foodexpansion.Reference;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.Objects;

public class BasicFoodItem extends Item {
    private boolean isSoup;

    public BasicFoodItem(String name, Food foodType, boolean isSoup) {
        super(new Item.Properties().food(foodType).group(FoodExpansion.ITEM_GROUP).maxStackSize(isSoup ? 1 : 64));
        setRegistryName(new ResourceLocation(Reference.MODID, name));
        this.isSoup = isSoup;
        FoodItems.ITEM_LIST.add(this);
    }
    public BasicFoodItem(String name, Food foodType) {
        this(name, foodType, false);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        if (Objects.requireNonNull(stack.getItem()).equals(FoodItems.jelly)) {
            return 64;
        } else {
            return super.getUseDuration(stack);
        }
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        ItemStack item = super.onItemUseFinish(stack, worldIn, entityLiving);
        return isSoup ? new ItemStack(Items.BOWL) : item;
    }
}
