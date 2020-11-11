package lellson.foodexpansion.items;

import lellson.foodexpansion.FoodTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class NetherWartSoupItem extends BasicFoodItem {

    public NetherWartSoupItem() {
        super(FoodTypes.NETHER_WART_SOUP, true);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        entityLiving.setFire(5);
        entityLiving.getActivePotionEffects().removeIf(effect -> !effect.getPotion().isBeneficial());
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}
