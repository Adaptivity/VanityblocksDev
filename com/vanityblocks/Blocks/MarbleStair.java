package com.vanityblocks.Blocks;

import java.util.List;

import com.vanityblocks.VanityBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MarbleStair extends BlockStairs
{
    public MarbleStair(int par1, Block par2Block, int par3)
    {
        super(par2Block, par3);
        setCreativeTab(VanityBlocks.tabvanityblocks);
        this.setLightOpacity(0);
    }
}