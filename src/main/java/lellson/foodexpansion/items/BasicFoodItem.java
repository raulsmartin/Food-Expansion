package lellson.foodexpansion.items;

import lellson.foodexpansion.FoodExpansion;
import lellson.foodexpansion.FoodItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class BasicFoodItem extends Item {
    private final boolean isSoup;

    public BasicFoodItem(FoodProperties foodType, boolean isSoup) {
        super(new Item.Properties().food(foodType).stacksTo(isSoup ? 1 : 64));
        this.isSoup = isSoup;
    }

    public BasicFoodItem(FoodProperties foodType) {
        this(foodType, false);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        if (Objects.requireNonNull(stack.getItem()).equals(FoodItems.JELLY.get())) {
            return 64;
        } else {
            return super.getUseDuration(stack);
        }
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level worldIn, @NotNull LivingEntity entityLiving) {
        ItemStack item = super.finishUsingItem(stack, worldIn, entityLiving);
        if (isSoup) {
            if (!(entityLiving instanceof Player) || !((Player) entityLiving).isCreative()) {
                return new ItemStack(Items.BOWL);
            }
        }
        return item;
    }
}
