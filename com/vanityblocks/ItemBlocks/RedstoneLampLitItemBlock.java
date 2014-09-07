package com.vanityblocks.ItemBlocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class RedstoneLampLitItemBlock extends ItemBlock
{

    private final static String[] subNames = { "blackLamp_Lit", "redLamp_Lit", "greenLamp_Lit", "brownLamp_Lit", "blueLamp_Lit", "purpleLamp_Lit", "pinkLamp_Lit", "lightBlueLamp_Lit",
            "magentaLamp_Lit", "", "", "", "", "", "", "", "", "" };

    public RedstoneLampLitItemBlock(Block id)
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