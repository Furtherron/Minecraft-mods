package com.furtherron.mod.init;

import java.util.List;

import com.furtherron.mod.objects.items.ItemBase;
import com.furtherron.mod.objects.items.tools.ToolSword;

import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ItemInit 
{
	public static final List<Item> ITEMS = new ArrayList<Item>(); 
	
	//Materiales
	public static final ToolMaterial MATERIAL_BLUEADAMANTIUM = EnumHelper.addToolMaterial("material_blueadamantium", 3, 1700, 8.0F, 4.0F, 10);
	
	//Items
	public static final Item BLUEADAMANTIUMINGOT = new ItemBase("blueadamantiumingot");
	public static final Item BLUEADAMANTIUMNUGGET = new ItemBase("blueadamantiumnugget");
	
	
	//Tools
	public static final ItemSword BLUEADAMANTIUMSWORD = new ToolSword("blue_adamantium_sword",MATERIAL_BLUEADAMANTIUM);
	
}
