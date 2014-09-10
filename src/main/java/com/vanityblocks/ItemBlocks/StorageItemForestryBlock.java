package com.vanityblocks.ItemBlocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class StorageItemForestryBlock extends ItemBlock
{

    private final static String[] subNames = { "Apatite Block", "Honey Block", "Honeydew Block", "Peat Block", "", "", "", "", "", "", "", "", "", "", "", "" };

    public StorageItemForestryBlock(Block id)
    {
        super(id);
        setHasSubtypes(true);
        // setItemName("storageblockmod");
    }

    @Override
    public int getMetadata (int i)
    {
        return i;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack)
    {
        String name = "forestry";
        switch (itemstack.getItemDamage())
        {
        case 0:
        {
            name = "apatiteblock";
            break;
        }
        case 1:
        {
            name = "honeyblock";
            break;
        }
        case 2:
        {
            name = "honeydewblock";
            break;
        }        
        case 3:
        {
            name = "peatblock";
            break;
        }           
        default:
            name = "Report_To_The_Author";
        }
        return getUnlocalizedName() + "." + name;
    }
}
