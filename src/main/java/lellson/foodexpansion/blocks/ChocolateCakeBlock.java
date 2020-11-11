package lellson.foodexpansion.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
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

    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote) {
            return this.eatCake(worldIn, pos, state, player);
        } else {
            ItemStack itemstack = player.getHeldItem(handIn);
            return this.eatCake(worldIn, pos, state, player) || itemstack.isEmpty();
        }
    }

    private boolean eatCake(IWorld worldIn, BlockPos pos, BlockState state, @Nonnull PlayerEntity player) {
        if (!player.canEat(false)) {
            return false;
        } else {
            player.addStat(Stats.EAT_CAKE_SLICE);
            player.getFoodStats().addStats(4, 0.3F);
            int i = state.get(BITES);
            if (i < 6) {
                worldIn.setBlockState(pos, state.with(BITES, i + 1), 3);
            } else {
                worldIn.removeBlock(pos, false);
            }

            return true;
        }
    }
}
