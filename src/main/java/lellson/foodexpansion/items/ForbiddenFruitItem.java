package lellson.foodexpansion.items;

import lellson.foodexpansion.FoodExpansion;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

public class ForbiddenFruitItem extends Item {
    private final boolean beneficial;

    public ForbiddenFruitItem(boolean beneficial) {
        super(new Item.Properties().stacksTo(1));
        this.beneficial = beneficial;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, @NotNull InteractionHand handIn) {
        ItemStack item = playerIn.getItemInHand(handIn);
        playerIn.getFoodData().eat(beneficial ? 20 : -20, beneficial ? 20 : -20);
        worldIn.playSound(playerIn, playerIn.position().x, playerIn.position().y, playerIn.position().y, SoundEvents.PLAYER_BURP, SoundSource.PLAYERS, 0.5F, worldIn.getRandom().nextFloat() * 0.1F + 0.9F);
        if (!playerIn.isCreative()) {
            item.setCount(item.getCount() - 1);
        }
        return new InteractionResultHolder<>(InteractionResult.SUCCESS, item);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean isFoil(@NotNull ItemStack stack) {
        return true;
    }
}
