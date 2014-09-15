package com.vanityblocks.Blocks;

import com.vanityblocks.VanityBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class ClayStairs extends BlockStairs
{
    public ClayStairs(Block par2Block, int par3)
    {
        super(par2Block, par3);
		setCreativeTab(VanityBlocks.tabvanityblocks);
        this.setLightOpacity(0);
    }

}