package com.vanityblocks.Items;

import javax.swing.Icon;

import com.vanityblocks.VanityBlocks;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class coalstorageitem extends Item {
	public String[] textureNames = new String[] { "coalstorageitem" };

	public coalstorageitem(int par1) {
		super();
		setUnlocalizedName("coalstorageitem");
		this.setHasSubtypes(true);
		setCreativeTab(VanityBlocks.tabvanityblocks);
	}

	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister par1IconRegister) {
		icons = new IIcon[2];

		for (int i = 0; i < icons.length; i++) {
			icons[i] = par1IconRegister
					.registerIcon("vanityblocks:coalstorageitem");
		}
	}

	// @Override
	// public String getUnlocalizedName(ItemStack par1ItemStack)
	// {
	// final String modid = "vanityblocks";
	// int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 15);
	// return modid + "." + super.getUnlocalizedName();
	// }

	@Override
	public IIcon getIconFromDamage(int par1) {
		return icons[par1];
	}
}
