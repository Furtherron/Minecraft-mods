package com.furtherron.mod.init;

import java.util.ArrayList;
import java.util.List;

import com.furtherron.mod.blocks.AdamantiteOre;
import com.furtherron.mod.blocks.BlockBase;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInit {
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//public static final Block ADAMANTITE_BLOCK = new BlockBase("adamantite_block", Material.IRON);
	public static final Block ADAMANTITE_ORE = new AdamantiteOre("adamantite_ore", Material.FIRE);
	
}

