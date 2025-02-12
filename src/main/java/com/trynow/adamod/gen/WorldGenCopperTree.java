package com.trynow.adamod.gen;

import java.util.Random;

import com.trynow.adamod.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.IPlantable;

public class WorldGenCopperTree extends WorldGenAbstractTree 
{


	
	private final int minHeight;
	
	public WorldGenCopperTree() 
	{
		super(false);
		this.minHeight = 12;
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos) 
	{
		int height = this.minHeight + rand.nextInt(3);
		boolean flag = true;
		
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		
		for(int yPos = y; yPos <= y + 1 + height; yPos++)
		{
			int b0 = 2;
			if(yPos == y) b0 = 1;
			if(yPos >= y + 1 + height - 2) b0 = 2;
			
			BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
			
			for(int xPos = x - b0; xPos <= x + b0 && flag; xPos++)
			{
				for(int zPos = z - b0; zPos <- z + b0 && flag; zPos++)
				{
					if(yPos >= 0 && yPos < world.getHeight())
					{
						if(!this.isReplaceable(world, new BlockPos(xPos, yPos, zPos)))
						{
							flag = false;
						}
					}
					else
					{
						flag = false;
					}
				}
			}
		}
		
		if(!flag)
		{
			return false;
		}
		else
		{
			BlockPos down = pos.down();
			IBlockState state = world.getBlockState(down);
			boolean isSoil = isSoil(world, down, state);
			
			if(isSoil && y < world.getHeight() - height - 1)
			{
				state.getBlock().onPlantGrow(state, world, down, pos);
				
				for(int yPos = y - 3 + height; yPos <= y + height; yPos++)
				{
					int b1 = yPos - (y + height);
					int b2 = 1 - b1 / 2;
					
					for(int xPos = x - b2; xPos <= x + b2; xPos++)
					{
						int b3 = xPos - x;
						for(int zPos = z - b2; zPos <= z + b2; zPos++)
						{
							int b4 = zPos - z;
							if(Math.abs(b3) != b2 || Math.abs(b4) != b2 || rand.nextInt(2) != 0 && b1 != 0)
							{
								BlockPos treePos = new BlockPos(xPos, yPos, zPos);
								IBlockState treeState = world.getBlockState(treePos);
								
							}
						}
					}
				}
				
				for(int logHeight = 0; logHeight < height; logHeight++)
				{
					BlockPos up = pos.up(logHeight);
					IBlockState logState = world.getBlockState(up);
					
					if(logState.getBlock().isAir(logState, world, up) || logState.getBlock().isLeaves(logState, world, up))
					{
						this.setBlockAndNotifyAdequately(world, pos.up(logHeight), logState);
					}
				}
				
				return true;
			}
		}
		
		return true;
	}

	private boolean isSoil(World world, BlockPos down, IBlockState state) {
		boolean isSoil = state.getBlock().canSustainPlant(state, world, down, EnumFacing.UP, (IPlantable) Blocks.SAPLING);
		return isSoil;
	}	
	
	@Override
	protected boolean canGrowInto(Block blockType)
	{
		Material material = blockType.getDefaultState().getMaterial();
        return material == Material.AIR || material == Material.LEAVES || material == Material.GROUND || blockType == BlockInit.ADAMANTITE_ORE || blockType == Blocks.GRASS || blockType == Blocks.DIRT || blockType == Blocks.LOG || blockType == Blocks.LOG2 || blockType == Blocks.SAPLING || blockType == Blocks.VINE;
  
	}
}
