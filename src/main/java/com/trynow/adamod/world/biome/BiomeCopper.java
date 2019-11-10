package com.trynow.adamod.world.biome;

import java.util.Random;

import com.trynow.adamod.Main;
import com.trynow.adamod.gen.WorldGenCopperTree;
import com.trynow.adamod.init.BlockInit;

import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class BiomeCopper extends Biome 
{
	
 protected static final WorldGenAbstractTree TREE = new WorldGenCopperTree(); 
 

			 
 public BiomeCopper()
 {
	  super(new BiomeProperties("Copper").setBaseHeight(1.5F).setHeightVariation(1.2F).setTemperature(0.6F).setRainDisabled().setWaterColor(16711680));
	  
	  topBlock = BlockInit.ADAMANTITE_ORE.getDefaultState();
	  //Change
	  fillerBlock = BlockInit.ADAMANTITE_ORE.getDefaultState();
	  
	  
	  
	  this.decorator.treesPerChunk = 2;
	  this.spawnableCaveCreatureList.clear();
	  this.spawnableCreatureList.clear();
	  this.spawnableMonsterList.clear();
	  this.spawnableWaterCreatureList.clear();
	  this.spawnableCreatureList.add(new SpawnListEntry(EntityWither.class,10,1,5));
	  this.spawnableCreatureList.add(new SpawnListEntry(EntityDragon.class,5,1,2)); 
	  

 }
 
 @Override
 
 public WorldGenAbstractTree getRandomTreeFeature(Random rand)
 {
	 return TREE;
 }
}
