package com.vanityblocks.ItemBlocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class DesignWorldItemBlock extends ItemBlock
{

    private final static String[] subNames = { "Marble", "Marble Brick", "Chiseled Marble", "Marble Pillar", "Marble Tile", "Ashford Black Marble", "Ashford Black Marble Brick",
            "Chiseled Ashford Black Marble", "Ashford Black Marble Pillar", "Ashford Black Marble Tile", "", "", "", };

    public DesignWorldItemBlock(Block id)
    {
        super(id);
        setHasSubtypes(true);
    }

    @Override
    public int getMetadata (int i)
    {
        return i;
    }

    @Override
    public String getUnlocalizedName (ItemStack itemstack)
    {
        return subNames[itemstack.getItemDamage()];
    }
}