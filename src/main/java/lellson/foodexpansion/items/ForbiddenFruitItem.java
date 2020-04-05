package lellson.foodexpansion.items;

import lellson.foodexpansion.FoodExpansion;
import lellson.foodexpansion.FoodItems;
import lellson.foodexpansion.Reference;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ForbiddenFruitItem extends Item {
    private boolean beneficial;

    public ForbiddenFruitItem(String name, boolean beneficial) {
        super(new Item.Properties().maxStackSize(1).group(FoodExpansion.ITEM_GROUP));
        setRegistryName(new ResourceLocation(Reference.MODID, name));
        this.beneficial = beneficial;

        FoodItems.ITEM_LIST.add(this);
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
