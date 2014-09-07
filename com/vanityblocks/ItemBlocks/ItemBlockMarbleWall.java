package com.vanityblocks.ItemBlocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMarbleWall extends ItemBlock
{
    private final static String[] subNames = { "Marble Wall", "Marble Brick Wall", "Chiseled Marble Wall", "Marble Pillar Wall", "Marble Tile Wall", "Ashford Black Marble Wall",
            "Ashford Black Marble Brick Wall", "Chiseled Ashford Black Marble Wall", "Ashford Black Marble Pillar Wall", "Ashford Black Marble Tile Wall", "", "", "", "", "", "" };

    public ItemBlockMarbleWall(Block id)
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
