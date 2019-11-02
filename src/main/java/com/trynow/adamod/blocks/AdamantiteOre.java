package com.trynow.adamod.blocks;

import java.util.Random;

import com.trynow.adamod.init.ItemInit;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IPlantable;

public class AdamantiteOre extends BlockBase{
	
	public AdamantiteOre(String name, Material material) {
		super(name, material);
		setSoundType(SoundType.METAL);
		setHardness(5.0F);
		setResistance(15.0F);
		setHarvestLevel("pickaxe", 3);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) 
	{
		return ItemInit.BLUEADAMANTIUMNUGGET;
	} 	

	@Override
	public int quantityDropped(Random rand) 
	{
		int max = 2;
		int min = 1;
		return rand.nextInt(max) + min; 
	}
	
	@Override 
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable)
	{
		return true;
	}
}
