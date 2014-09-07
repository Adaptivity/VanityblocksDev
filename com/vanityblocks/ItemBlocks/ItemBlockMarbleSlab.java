package com.vanityblocks.ItemBlocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMarbleSlab extends ItemBlock
{
    private final static String[] subNames = { "Marble Slab", "Marble Brick Slab", "Chiseled Marble Slab", "Marble Pillar Slab", "Marble Tile Slab", "Ashford Black Marble Slab",
            "Ashford Black Marble Brick Slab", "Chiseled Ashford Black Marble Slab", "Ashford Black Marble Pillar Slab", "Ashford Black Marble Tile Slab", "", "", "", "", "", "" };

    public ItemBlockMarbleSlab(Block id)
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
