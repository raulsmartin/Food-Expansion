package lellson.foodexpansion.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class ChocolateCakeBlock extends CakeBlock {
    public ChocolateCakeBlock(Block.Properties properties) {
        super(properties);
    }

    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (worldIn.isRemote) {
            ItemStack itemstack = player.getHeldItem(handIn);
            if (func_226911_a_(worldIn, pos, state, player) == ActionResultType.SUCCESS) {
                return ActionResultType.SUCCESS;
            }

            if (itemstack.isEmpty()) {
                return ActionResultType.CONSUME;
            }
        }

        return func_226911_a_(worldIn, pos, state, player);
    }

    private ActionResultType func_226911_a_(IWorld worldIn, BlockPos pos, BlockState state, @Nonnull PlayerEntity playerIn) {
        if (!playerIn.canEat(false)) {
            return ActionResultType.PASS;
        } else {
            playerIn.addStat(Stats.EAT_CAKE_SLICE);
            playerIn.getFoodStats().addStats(4, 0.3F);
            int i = state.get(BITES);
            if (i < 6) {
                worldIn.setBlockState(pos, state.with(BITES, i + 1), 3);
            } else {
                worldIn.removeBlock(pos, false);
            }

            return ActionResultType.SUCCESS;
        }
    }
}
