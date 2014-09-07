package com.vanityblocks.ItemBlocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class TileItemBlock extends ItemBlock
{

    private final static String[] subNames = { "Melting Core", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" };

    public TileItemBlock(Block id)
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
    public String getUnlocalizedName(ItemStack itemstack)
    {
        String name = "tileentitys";
        switch (itemstack.getItemDamage())
        {
        case 0:
        {
            name = "meltingcore";
            break;
        }   
        default:
            name = "Report_To_The_Author";
        }
        return getUnlocalizedName() + "." + name;
    }
}