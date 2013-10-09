package vanityblocks.Dimensions;

import vanityblocks.Registrations.MiningWorldRegistrations;
import vanityblocks.Dimensions.DimensionManagement;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PortalStarter extends Item
{
    public Icon[] icons;
    public String[] textureNames = new String[] { "portalstarteritem" };

    public PortalStarter(int par1)
    {
        super(par1);
        this.setHasSubtypes(true);
        this.maxStackSize = 1;
        setMaxDamage(10);
        setCreativeTab(DimensionManagement.tabDimensions);
    }

    public boolean onItemUse (ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {

        int blockID = par3World.getBlockId(par4, par5, par6);
        /*if (blockID == Block.blockGold.blockID)
        {
            if (!MiningWorldRegistrations.vanityportal.tryToCreatePortal(par3World, par4, par5 + 1, par6))
            {
                if (par2EntityPlayer.capabilities.isCreativeMode)
                {
                    //the abreviations are Directionplacement
                    par3World.setBlock(par4, par5 - 1, par6, Block.blockGold.blockID); // middle
                    par3World.setBlock(par4, par5, par6, 0); // middle
                    par3World.setBlock(par4 + 1, par5 - 1, par6, Block.stone.blockID); // floor east pillar
                    par3World.setBlock(par4 - 1, par5 - 1, par6, Block.stone.blockID); // floor west pillar
                    par3World.setBlock(par4, par5 - 1, par6 + 1, Block.stone.blockID); // floor south pillar
                    par3World.setBlock(par4, par5 - 1, par6 - 1, Block.stone.blockID); // floor north pillar

                    par3World.setBlock(par4, par5 + 3, par6, Block.blockLapis.blockID); // middle top

                    par3World.setBlock(par4 - 2, par5 + 0, par6, Block.stone.blockID); //wfb
                    par3World.setBlock(par4 - 2, par5 + 1, par6, Block.stone.blockID); //wfm
                    par3World.setBlock(par4 - 1, par5 + 2, par6, Block.stone.blockID); //wft

                    par3World.setBlock(par4, par5 + 0, par6 - 2, Block.stone.blockID); //nfb
                    par3World.setBlock(par4, par5 + 1, par6 - 2, Block.stone.blockID); //nfm
                    par3World.setBlock(par4, par5 + 2, par6 - 1, Block.stone.blockID); //nft

                    par3World.setBlock(par4 + 2, par5 + 0, par6, Block.stone.blockID); //efb
                    par3World.setBlock(par4 + 2, par5 + 1, par6, Block.stone.blockID); //efm
                    par3World.setBlock(par4 + 1, par5 + 2, par6, Block.stone.blockID); //eft

                    par3World.setBlock(par4, par5 + 0, par6 + 2, Block.stone.blockID); //sfb
                    par3World.setBlock(par4, par5 + 1, par6 + 2, Block.stone.blockID); //sfm
                    par3World.setBlock(par4, par5 + 2, par6 + 1, Block.stone.blockID); //sft

                }
            }
            else
            {
                par1ItemStack.damageItem(1, par2EntityPlayer);
            }
        } */
        if (blockID == Block.plantYellow.blockID || blockID == Block.plantRed.blockID || blockID == Block.grass.blockID) //Builder for plains
        {
            if (!MiningWorldRegistrations.vanityportal.tryToCreatePortal(par3World, par4, par5 + 1, par6))
            {
                if (par2EntityPlayer.capabilities.isCreativeMode)
                {
                    //the abreviations are Directionplacement
                    par3World.setBlock(par4, par5 - 1, par6, Block.grass.blockID); // middle
                    par3World.setBlock(par4, par5, par6, 0); // middle
                    par3World.setBlock(par4 + 1, par5 - 1, par6, Block.stone.blockID); // floor east pillar
                    par3World.setBlock(par4 - 1, par5 - 1, par6, Block.stone.blockID); // floor west pillar
                    par3World.setBlock(par4, par5 - 1, par6 + 1, Block.stone.blockID); // floor south pillar
                    par3World.setBlock(par4, par5 - 1, par6 - 1, Block.stone.blockID); // floor north pillar

                    par3World.setBlock(par4, par5 + 3, par6, Block.blockLapis.blockID); // middle top

                    par3World.setBlock(par4 - 2, par5 + 0, par6, Block.stone.blockID); //wfb
                    par3World.setBlock(par4 - 2, par5 + 1, par6, Block.stone.blockID); //wfm
                    par3World.setBlock(par4 - 1, par5 + 2, par6, Block.stone.blockID); //wft

                    par3World.setBlock(par4, par5 + 0, par6 - 2, Block.stone.blockID); //nfb
                    par3World.setBlock(par4, par5 + 1, par6 - 2, Block.stone.blockID); //nfm
                    par3World.setBlock(par4, par5 + 2, par6 - 1, Block.stone.blockID); //nft

                    par3World.setBlock(par4 + 2, par5 + 0, par6, Block.stone.blockID); //efb
                    par3World.setBlock(par4 + 2, par5 + 1, par6, Block.stone.blockID); //efm
                    par3World.setBlock(par4 + 1, par5 + 2, par6, Block.stone.blockID); //eft

                    par3World.setBlock(par4, par5 + 0, par6 + 2, Block.stone.blockID); //sfb
                    par3World.setBlock(par4, par5 + 1, par6 + 2, Block.stone.blockID); //sfm
                    par3World.setBlock(par4, par5 + 2, par6 + 1, Block.stone.blockID); //sft

                }
            }
            else
            {
                par1ItemStack.damageItem(1, par2EntityPlayer);
            }
        }
        if (blockID == Block.sandStone.blockID) //Builder for desert hills
        {
            if (!MiningWorldRegistrations.vanityportal.tryToCreatePortal(par3World, par4, par5 + 1, par6))
            {
                if (par2EntityPlayer.capabilities.isCreativeMode)
                {
                    //the abreviations are Directionplacement
                    par3World.setBlock(par4, par5 - 1, par6, Block.sandStone.blockID); // middle
                    par3World.setBlock(par4, par5, par6, 0); // middle
                    par3World.setBlock(par4 + 1, par5 - 1, par6, Block.stone.blockID); // floor east pillar
                    par3World.setBlock(par4 - 1, par5 - 1, par6, Block.stone.blockID); // floor west pillar
                    par3World.setBlock(par4, par5 - 1, par6 + 1, Block.stone.blockID); // floor south pillar
                    par3World.setBlock(par4, par5 - 1, par6 - 1, Block.stone.blockID); // floor north pillar

                    par3World.setBlock(par4, par5 + 3, par6, Block.blockLapis.blockID); // middle top

                    par3World.setBlock(par4 - 2, par5 + 0, par6, Block.stone.blockID); //wfb
                    par3World.setBlock(par4 - 2, par5 + 1, par6, Block.stone.blockID); //wfm
                    par3World.setBlock(par4 - 1, par5 + 2, par6, Block.stone.blockID); //wft

                    par3World.setBlock(par4, par5 + 0, par6 - 2, Block.stone.blockID); //nfb
                    par3World.setBlock(par4, par5 + 1, par6 - 2, Block.stone.blockID); //nfm
                    par3World.setBlock(par4, par5 + 2, par6 - 1, Block.stone.blockID); //nft

                    par3World.setBlock(par4 + 2, par5 + 0, par6, Block.stone.blockID); //efb
                    par3World.setBlock(par4 + 2, par5 + 1, par6, Block.stone.blockID); //efm
                    par3World.setBlock(par4 + 1, par5 + 2, par6, Block.stone.blockID); //eft

                    par3World.setBlock(par4, par5 + 0, par6 + 2, Block.stone.blockID); //sfb
                    par3World.setBlock(par4, par5 + 1, par6 + 2, Block.stone.blockID); //sfm
                    par3World.setBlock(par4, par5 + 2, par6 + 1, Block.stone.blockID); //sft

                }
            }
            else
            {
                par1ItemStack.damageItem(1, par2EntityPlayer);
            }
        }
        if (blockID == Block.blockEmerald.blockID) //Builder for extreme hills
        {
            if (!MiningWorldRegistrations.vanityportal.tryToCreatePortal(par3World, par4, par5 + 1, par6))
            {
                if (par2EntityPlayer.capabilities.isCreativeMode)
                {
                    //the abreviations are Directionplacement
                    par3World.setBlock(par4, par5 - 1, par6, Block.blockEmerald.blockID); // middle
                    par3World.setBlock(par4, par5, par6, 0); // middle
                    par3World.setBlock(par4 + 1, par5 - 1, par6, Block.stone.blockID); // floor east pillar
                    par3World.setBlock(par4 - 1, par5 - 1, par6, Block.stone.blockID); // floor west pillar
                    par3World.setBlock(par4, par5 - 1, par6 + 1, Block.stone.blockID); // floor south pillar
                    par3World.setBlock(par4, par5 - 1, par6 - 1, Block.stone.blockID); // floor north pillar

                    par3World.setBlock(par4, par5 + 3, par6, Block.blockLapis.blockID); // middle top

                    par3World.setBlock(par4 - 2, par5 + 0, par6, Block.stone.blockID); //wfb
                    par3World.setBlock(par4 - 2, par5 + 1, par6, Block.stone.blockID); //wfm
                    par3World.setBlock(par4 - 1, par5 + 2, par6, Block.stone.blockID); //wft

                    par3World.setBlock(par4, par5 + 0, par6 - 2, Block.stone.blockID); //nfb
                    par3World.setBlock(par4, par5 + 1, par6 - 2, Block.stone.blockID); //nfm
                    par3World.setBlock(par4, par5 + 2, par6 - 1, Block.stone.blockID); //nft

                    par3World.setBlock(par4 + 2, par5 + 0, par6, Block.stone.blockID); //efb
                    par3World.setBlock(par4 + 2, par5 + 1, par6, Block.stone.blockID); //efm
                    par3World.setBlock(par4 + 1, par5 + 2, par6, Block.stone.blockID); //eft

                    par3World.setBlock(par4, par5 + 0, par6 + 2, Block.stone.blockID); //sfb
                    par3World.setBlock(par4, par5 + 1, par6 + 2, Block.stone.blockID); //sfm
                    par3World.setBlock(par4, par5 + 2, par6 + 1, Block.stone.blockID); //sft

                }
            }
            else
            {
                par1ItemStack.damageItem(1, par2EntityPlayer);
            }
        }
        if (blockID == Block.wood.blockID) //Builder for forest
        {
            if (!MiningWorldRegistrations.vanityportal.tryToCreatePortal(par3World, par4, par5 + 1, par6))
            {
                if (par2EntityPlayer.capabilities.isCreativeMode)
                {
                    //the abreviations are Directionplacement
                    par3World.setBlock(par4, par5 - 1, par6, Block.wood.blockID); // middle
                    par3World.setBlock(par4, par5, par6, 0); // middle
                    par3World.setBlock(par4 + 1, par5 - 1, par6, Block.stone.blockID); // floor east pillar
                    par3World.setBlock(par4 - 1, par5 - 1, par6, Block.stone.blockID); // floor west pillar
                    par3World.setBlock(par4, par5 - 1, par6 + 1, Block.stone.blockID); // floor south pillar
                    par3World.setBlock(par4, par5 - 1, par6 - 1, Block.stone.blockID); // floor north pillar

                    par3World.setBlock(par4, par5 + 3, par6, Block.blockLapis.blockID); // middle top

                    par3World.setBlock(par4 - 2, par5 + 0, par6, Block.stone.blockID); //wfb
                    par3World.setBlock(par4 - 2, par5 + 1, par6, Block.stone.blockID); //wfm
                    par3World.setBlock(par4 - 1, par5 + 2, par6, Block.stone.blockID); //wft

                    par3World.setBlock(par4, par5 + 0, par6 - 2, Block.stone.blockID); //nfb
                    par3World.setBlock(par4, par5 + 1, par6 - 2, Block.stone.blockID); //nfm
                    par3World.setBlock(par4, par5 + 2, par6 - 1, Block.stone.blockID); //nft

                    par3World.setBlock(par4 + 2, par5 + 0, par6, Block.stone.blockID); //efb
                    par3World.setBlock(par4 + 2, par5 + 1, par6, Block.stone.blockID); //efm
                    par3World.setBlock(par4 + 1, par5 + 2, par6, Block.stone.blockID); //eft

                    par3World.setBlock(par4, par5 + 0, par6 + 2, Block.stone.blockID); //sfb
                    par3World.setBlock(par4, par5 + 1, par6 + 2, Block.stone.blockID); //sfm
                    par3World.setBlock(par4, par5 + 2, par6 + 1, Block.stone.blockID); //sft

                }
            }
            else
            {
                par1ItemStack.damageItem(1, par2EntityPlayer);
            }
        }
        if (blockID == Block.blockSnow.blockID) //Builder for taiga
        {
            if (!MiningWorldRegistrations.vanityportal.tryToCreatePortal(par3World, par4, par5 + 1, par6))
            {
                if (par2EntityPlayer.capabilities.isCreativeMode)
                {
                    //the abreviations are Directionplacement
                    par3World.setBlock(par4, par5 - 1, par6, Block.blockSnow.blockID); // middle
                    par3World.setBlock(par4, par5, par6, 0); // middle
                    par3World.setBlock(par4 + 1, par5 - 1, par6, Block.stone.blockID); // floor east pillar
                    par3World.setBlock(par4 - 1, par5 - 1, par6, Block.stone.blockID); // floor west pillar
                    par3World.setBlock(par4, par5 - 1, par6 + 1, Block.stone.blockID); // floor south pillar
                    par3World.setBlock(par4, par5 - 1, par6 - 1, Block.stone.blockID); // floor north pillar

                    par3World.setBlock(par4, par5 + 3, par6, Block.blockLapis.blockID); // middle top

                    par3World.setBlock(par4 - 2, par5 + 0, par6, Block.stone.blockID); //wfb
                    par3World.setBlock(par4 - 2, par5 + 1, par6, Block.stone.blockID); //wfm
                    par3World.setBlock(par4 - 1, par5 + 2, par6, Block.stone.blockID); //wft

                    par3World.setBlock(par4, par5 + 0, par6 - 2, Block.stone.blockID); //nfb
                    par3World.setBlock(par4, par5 + 1, par6 - 2, Block.stone.blockID); //nfm
                    par3World.setBlock(par4, par5 + 2, par6 - 1, Block.stone.blockID); //nft

                    par3World.setBlock(par4 + 2, par5 + 0, par6, Block.stone.blockID); //efb
                    par3World.setBlock(par4 + 2, par5 + 1, par6, Block.stone.blockID); //efm
                    par3World.setBlock(par4 + 1, par5 + 2, par6, Block.stone.blockID); //eft

                    par3World.setBlock(par4, par5 + 0, par6 + 2, Block.stone.blockID); //sfb
                    par3World.setBlock(par4, par5 + 1, par6 + 2, Block.stone.blockID); //sfm
                    par3World.setBlock(par4, par5 + 2, par6 + 1, Block.stone.blockID); //sft

                }
            }
            else
            {
                par1ItemStack.damageItem(1, par2EntityPlayer);
            }
        }
        if (blockID == Block.blockClay.blockID) //Builder for swampland
        {
            if (!MiningWorldRegistrations.vanityportal.tryToCreatePortal(par3World, par4, par5 + 1, par6))
            {
                if (par2EntityPlayer.capabilities.isCreativeMode)
                {
                    //the abreviations are Directionplacement
                    par3World.setBlock(par4, par5 - 1, par6, Block.blockClay.blockID); // middle
                    par3World.setBlock(par4, par5, par6, 0); // middle
                    par3World.setBlock(par4 + 1, par5 - 1, par6, Block.waterStill.blockID); // floor east pillar
                    par3World.setBlock(par4 - 1, par5 - 1, par6, Block.waterStill.blockID); // floor west pillar
                    par3World.setBlock(par4, par5 - 1, par6 + 1, Block.waterStill.blockID); // floor south pillar
                    par3World.setBlock(par4, par5 - 1, par6 - 1, Block.waterStill.blockID); // floor north pillar

                    par3World.setBlock(par4, par5 + 3, par6, Block.blockLapis.blockID); // middle top

                    par3World.setBlock(par4 - 2, par5 + 0, par6, Block.stone.blockID); //wfb
                    par3World.setBlock(par4 - 2, par5 + 1, par6, Block.stone.blockID); //wfm
                    par3World.setBlock(par4 - 1, par5 + 2, par6, Block.stone.blockID); //wft

                    par3World.setBlock(par4, par5 + 0, par6 - 2, Block.stone.blockID); //nfb
                    par3World.setBlock(par4, par5 + 1, par6 - 2, Block.stone.blockID); //nfm
                    par3World.setBlock(par4, par5 + 2, par6 - 1, Block.stone.blockID); //nft

                    par3World.setBlock(par4 + 2, par5 + 0, par6, Block.stone.blockID); //efb
                    par3World.setBlock(par4 + 2, par5 + 1, par6, Block.stone.blockID); //efm
                    par3World.setBlock(par4 + 1, par5 + 2, par6, Block.stone.blockID); //eft

                    par3World.setBlock(par4, par5 + 0, par6 + 2, Block.stone.blockID); //sfb
                    par3World.setBlock(par4, par5 + 1, par6 + 2, Block.stone.blockID); //sfm
                    par3World.setBlock(par4, par5 + 2, par6 + 1, Block.stone.blockID); //sft

                }
            }
            else
            {
                par1ItemStack.damageItem(1, par2EntityPlayer);
            }
        }
        if (blockID == Block.mycelium.blockID) //Builder for shroomisland
        {
            if (!MiningWorldRegistrations.vanityportal.tryToCreatePortal(par3World, par4, par5 + 1, par6))
            {
                if (par2EntityPlayer.capabilities.isCreativeMode)
                {
                    //the abreviations are Directionplacement
                    par3World.setBlock(par4, par5 - 1, par6, Block.mycelium.blockID); // middle
                    par3World.setBlock(par4, par5, par6, 0); // middle
                    par3World.setBlock(par4 + 1, par5 - 1, par6, Block.stone.blockID); // floor east pillar
                    par3World.setBlock(par4 - 1, par5 - 1, par6, Block.stone.blockID); // floor west pillar
                    par3World.setBlock(par4, par5 - 1, par6 + 1, Block.stone.blockID); // floor south pillar
                    par3World.setBlock(par4, par5 - 1, par6 - 1, Block.stone.blockID); // floor north pillar

                    par3World.setBlock(par4, par5 + 3, par6, Block.blockLapis.blockID); // middle top

                    par3World.setBlock(par4 - 2, par5 + 0, par6, Block.stone.blockID); //wfb
                    par3World.setBlock(par4 - 2, par5 + 1, par6, Block.stone.blockID); //wfm
                    par3World.setBlock(par4 - 1, par5 + 2, par6, Block.stone.blockID); //wft

                    par3World.setBlock(par4, par5 + 0, par6 - 2, Block.stone.blockID); //nfb
                    par3World.setBlock(par4, par5 + 1, par6 - 2, Block.stone.blockID); //nfm
                    par3World.setBlock(par4, par5 + 2, par6 - 1, Block.stone.blockID); //nft

                    par3World.setBlock(par4 + 2, par5 + 0, par6, Block.stone.blockID); //efb
                    par3World.setBlock(par4 + 2, par5 + 1, par6, Block.stone.blockID); //efm
                    par3World.setBlock(par4 + 1, par5 + 2, par6, Block.stone.blockID); //eft

                    par3World.setBlock(par4, par5 + 0, par6 + 2, Block.stone.blockID); //sfb
                    par3World.setBlock(par4, par5 + 1, par6 + 2, Block.stone.blockID); //sfm
                    par3World.setBlock(par4, par5 + 2, par6 + 1, Block.stone.blockID); //sft

                }
            }
            else
            {
                par1ItemStack.damageItem(1, par2EntityPlayer);
            }
        }
        if (blockID == Block.leaves.blockID) //Builder for jungle
        {
            if (!MiningWorldRegistrations.vanityportal.tryToCreatePortal(par3World, par4, par5 + 1, par6))
            {
                if (par2EntityPlayer.capabilities.isCreativeMode)
                {
                    //the abreviations are Directionplacement
                    par3World.setBlock(par4, par5 - 1, par6, Block.leaves.blockID); // middle
                    par3World.setBlock(par4, par5, par6, 0); // middle
                    par3World.setBlock(par4 + 1, par5 - 1, par6, Block.leaves.blockID); // floor east pillar
                    par3World.setBlock(par4 - 1, par5 - 1, par6, Block.leaves.blockID); // floor west pillar
                    par3World.setBlock(par4, par5 - 1, par6 + 1, Block.leaves.blockID); // floor south pillar
                    par3World.setBlock(par4, par5 - 1, par6 - 1, Block.leaves.blockID); // floor north pillar

                    par3World.setBlock(par4, par5 + 3, par6, Block.blockLapis.blockID); // middle top

                    par3World.setBlock(par4 - 2, par5 + 0, par6, Block.stone.blockID); //wfb
                    par3World.setBlock(par4 - 2, par5 + 1, par6, Block.stone.blockID); //wfm
                    par3World.setBlock(par4 - 1, par5 + 2, par6, Block.stone.blockID); //wft

                    par3World.setBlock(par4, par5 + 0, par6 - 2, Block.stone.blockID); //nfb
                    par3World.setBlock(par4, par5 + 1, par6 - 2, Block.stone.blockID); //nfm
                    par3World.setBlock(par4, par5 + 2, par6 - 1, Block.stone.blockID); //nft

                    par3World.setBlock(par4 + 2, par5 + 0, par6, Block.stone.blockID); //efb
                    par3World.setBlock(par4 + 2, par5 + 1, par6, Block.stone.blockID); //efm
                    par3World.setBlock(par4 + 1, par5 + 2, par6, Block.stone.blockID); //eft

                    par3World.setBlock(par4, par5 + 0, par6 + 2, Block.stone.blockID); //sfb
                    par3World.setBlock(par4, par5 + 1, par6 + 2, Block.stone.blockID); //sfm
                    par3World.setBlock(par4, par5 + 2, par6 + 1, Block.stone.blockID); //sft

                }
            }
            else
            {
                par1ItemStack.damageItem(1, par2EntityPlayer);
            }
        }
        if (blockID == Block.blockNetherQuartz.blockID) //Builder for hell dimension
        {
            if (!MiningWorldRegistrations.vanityportal.tryToCreatePortal(par3World, par4, par5 + 1, par6))
            {
                if (par2EntityPlayer.capabilities.isCreativeMode)
                {
                    //the abreviations are Directionplacement
                    par3World.setBlock(par4, par5 - 1, par6, Block.blockNetherQuartz.blockID); // middle
                    par3World.setBlock(par4, par5, par6, 0); // middle
                    par3World.setBlock(par4 + 1, par5 - 1, par6, Block.netherBrick.blockID); // floor east pillar
                    par3World.setBlock(par4 - 1, par5 - 1, par6, Block.netherBrick.blockID); // floor west pillar
                    par3World.setBlock(par4, par5 - 1, par6 + 1, Block.netherBrick.blockID); // floor south pillar
                    par3World.setBlock(par4, par5 - 1, par6 - 1, Block.netherBrick.blockID); // floor north pillar

                    par3World.setBlock(par4, par5 + 3, par6, Block.blockNetherQuartz.blockID); // middle top

                    par3World.setBlock(par4 - 2, par5 + 0, par6, Block.netherBrick.blockID); //wfb
                    par3World.setBlock(par4 - 2, par5 + 1, par6, Block.netherBrick.blockID); //wfm
                    par3World.setBlock(par4 - 1, par5 + 2, par6, Block.netherBrick.blockID); //wft

                    par3World.setBlock(par4, par5 + 0, par6 - 2, Block.netherBrick.blockID); //nfb
                    par3World.setBlock(par4, par5 + 1, par6 - 2, Block.netherBrick.blockID); //nfm
                    par3World.setBlock(par4, par5 + 2, par6 - 1, Block.netherBrick.blockID); //nft

                    par3World.setBlock(par4 + 2, par5 + 0, par6, Block.netherBrick.blockID); //efb
                    par3World.setBlock(par4 + 2, par5 + 1, par6, Block.netherBrick.blockID); //efm
                    par3World.setBlock(par4 + 1, par5 + 2, par6, Block.netherBrick.blockID); //eft

                    par3World.setBlock(par4, par5 + 0, par6 + 2, Block.netherBrick.blockID); //sfb
                    par3World.setBlock(par4, par5 + 1, par6 + 2, Block.netherBrick.blockID); //sfm
                    par3World.setBlock(par4, par5 + 2, par6 + 1, Block.netherBrick.blockID); //sft

                }
            }
            else
            {
                par1ItemStack.damageItem(1, par2EntityPlayer);
            }
        }
        return true;
    }

    @Override
    public boolean hasContainerItem ()
    {
        return true;
    }

    @Override
    public ItemStack getContainerItemStack (ItemStack itemStack)
    {
        ItemStack copyStack = itemStack.copy();
        copyStack.setItemDamage(copyStack.getItemDamage() + 1);
        if (copyStack.getItemDamage() >= copyStack.getMaxDamage())
            return null;

        return copyStack;
    }

    @Override
    public void registerIcons (IconRegister par1IconRegister)
    {
        itemIcon = par1IconRegister.registerIcon("vanityblocks:portalstarter");
    }
}
