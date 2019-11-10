package com.furtherron.mod.objects.items;

import com.furtherron.mod.Main;
import com.furtherron.mod.init.ItemInit;
import com.furtherron.mod.proxy.ClientProxy;
import com.furtherron.mod.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel
{

	public ItemBase(String name) {
	
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		
		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "invent");
	}

}
