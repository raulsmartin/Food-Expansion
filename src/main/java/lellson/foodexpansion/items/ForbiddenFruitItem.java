package lellson.foodexpansion.items;

import lellson.foodexpansion.FoodExpansion;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ForbiddenFruitItem extends Item {
    private final boolean beneficial;

    public ForbiddenFruitItem(boolean beneficial) {
        super(new Item.Properties().maxStackSize(1).group(FoodExpansion.ITEM_GROUP));
        this.beneficial = beneficial;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack item = playerIn.getHeldItem(handIn);
        playerIn.getFoodStats().addStats(beneficial ? 20 : -20, beneficial ? 20 : -20);
        worldIn.playSound(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
        if (!playerIn.isCreative()) {
            item.setCount(item.getCount() - 1);
        }

        return new ActionResult<>(ActionResultType.SUCCESS, item);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
