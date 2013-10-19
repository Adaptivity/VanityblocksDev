package vanityblocks.Dimensions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import vanityblocks.Storageprops;
import vanityblocks.Dimensions.Teleporters.TeleporterVanityDesertHills;
import vanityblocks.Dimensions.Teleporters.TeleporterVanityExtremehills;
import vanityblocks.Dimensions.Teleporters.TeleporterVanityForest;
import vanityblocks.Dimensions.Teleporters.TeleporterVanityHell;
import vanityblocks.Dimensions.Teleporters.TeleporterVanityJungle;
import vanityblocks.Dimensions.Teleporters.TeleporterVanityPlains;
import vanityblocks.Dimensions.Teleporters.TeleporterVanityShroom;
import vanityblocks.Dimensions.Teleporters.TeleporterVanitySwampland;
import vanityblocks.Dimensions.Teleporters.TeleporterVanityTaiga;
import vanityblocks.Registrations.MiningWorldRegistrations;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockVanityPortal extends BlockBreakable
{
    public BlockVanityPortal(int par1)
    {
        super(par1, "vanityblocks:dimension:blockvanityportalblank", Material.portal, false);
        this.setTickRandomly(true);
        this.setHardness(-1.0F);
        this.setStepSound(soundGlassFootstep);
        this.setLightValue(0.75F);
        setCreativeTab(DimensionManagement.tabDimensions);
    }

    /**
    * Ticks the block if it's been scheduled
    */
    /* @Override
     public void updateTick (World par1World, int par2, int par3, int par4, Random par5Random)
     {
         super.updateTick(par1World, par2, par3, par4, par5Random);

         if (par1World.provider.isSurfaceWorld() && par5Random.nextInt(2000) < par1World.difficultySetting)
         {
             
             int l;

             for (l = par3; !par1World.doesBlockHaveSolidTopSurface(par2, l, par4) && l > 0; --l)
             {
                 ;
             }

             if (l > 0 && !par1World.isBlockNormalCube(par2, l + 1, par4))
             {
                 Entity entity = ItemMonsterPlacer.spawnCreature(par1World, 57, (double)par2 + 0.5D, (double)l + 1.1D, (double)par4 + 0.5D);

                 if (entity != null)
                 {
                     entity.timeUntilPortal = entity.getPortalCooldown();
                 }
             }
         }
     } */

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool (World par1World, int par2, int par3, int par4)
    {
        return null;
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    /* @Override
     public void setBlockBoundsBasedOnState (IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
     {
         float f;
         float f1;
         /*
         if (par1IBlockAccess.getBlockId(par2 - 1, par3, par4) != this.blockID && par1IBlockAccess.getBlockId(par2 + 1, par3, par4) != this.blockID)
         {
             f = 0.125F;
             f1 = 0.5F;
             this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
         }
         else
         {
             f = 0.5F;
             f1 = 0.125F;
             this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
         }
     } */

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    @Override
    public boolean isOpaqueCube ()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    @Override
    public boolean renderAsNormalBlock ()
    {
        return true;
    }

    /**
     * Checks to see if this location is valid to create a portal and will return True if it does. Args: world, x, y, z
     */
    public boolean tryToCreatePortal (World par1World, int par2, int par3, int par4)
    {
        int metadata = par1World.getBlockMetadata(par2, par3, par4);
        int id0 = par1World.getBlockId(par2, par3 - 1, par4); // middle - gold block
        int id1 = par1World.getBlockId(par2, par3 + 3, par4); // middle top  - Lapis block

        int id2 = par1World.getBlockId(par2 + 1, par3 - 1, par4); // floor east pillar - stone
        int id3 = par1World.getBlockId(par2 - 1, par3 - 1, par4); // floor west pillar - stone
        int id4 = par1World.getBlockId(par2, par3 - 1, par4 + 1); // floor south pillar - stone
        int id5 = par1World.getBlockId(par2, par3 - 1, par4 - 1); // floor north pillar - stone
        int id6 = par1World.getBlockId(par2 - 2, par3 + 0, par4); //wfb - stone
        int id7 = par1World.getBlockId(par2 - 2, par3 + 1, par4); //wfm - stone
        int id8 = par1World.getBlockId(par2 - 1, par3 + 2, par4); //wft - stone
        int id9 = par1World.getBlockId(par2, par3 + 0, par4 - 2); //nfb - stone
        int id10 = par1World.getBlockId(par2, par3 + 1, par4 - 2); //nfm - stone
        int id11 = par1World.getBlockId(par2, par3 + 2, par4 - 1); //nft - stone
        int id12 = par1World.getBlockId(par2 + 2, par3 + 0, par4); //efb - stone
        int id13 = par1World.getBlockId(par2 + 2, par3 + 1, par4); //efm - stone
        int id14 = par1World.getBlockId(par2 + 1, par3 + 2, par4); //eft - stone
        int id15 = par1World.getBlockId(par2, par3 + 0, par4 + 2); //sfb - stone
        int id16 = par1World.getBlockId(par2, par3 + 1, par4 + 2); //sfm - stone
        int id17 = par1World.getBlockId(par2, par3 + 2, par4 + 1); //sft - stone     
        //if (id0 == Block.blockGold.blockID && id1 == Block.blockLapis.blockID && id2 == id3 && id3 == id4 && id4 == id5 && id6 == id7 && id7 == id8 && id8 == id9 && id9 == id10 && id10 == id11
        //        && id11 == id12 && id12 == id13 && id13 == id14 && id14 == id15 && id15 == id16 && id17 == Block.stone.blockID)
        //{
        //    par1World.setBlock(par2, par3, par4, MiningWorldRegistrations.vanityportal.blockID, 0, 2);
        //    par1World.setBlock(par2, par3 + 1, par4, MiningWorldRegistrations.vanityportal.blockID, 0, 2);
        //    par1World.setBlock(par2, par3 + 2, par4, MiningWorldRegistrations.vanityportal.blockID, 0, 2);
        //    return true;
        //}

        //portal creation statements for the plains biome dimension
        if (id0 == Block.grass.blockID && id1 == Block.blockLapis.blockID && id2 == id3 && id3 == id4 && id4 == id5 && id6 == id7 && id7 == id8 && id8 == id9 && id9 == id10 && id10 == id11
                && id11 == id12 && id12 == id13 && id13 == id14 && id14 == id15 && id15 == id16 && id17 == Block.stone.blockID)
        {
            if (Storageprops.vmenableplains)
            {
                par1World.setBlock(par2, par3, par4, MiningWorldRegistrations.vanityportal.blockID, 0, 2);
                par1World.setBlock(par2, par3 + 1, par4, MiningWorldRegistrations.vanityportal.blockID, 0, 2);
                par1World.setBlock(par2, par3 + 2, par4, MiningWorldRegistrations.vanityportal.blockID, 0, 2);
                return true;
            }
        }
        //portal creation statements for the deserthills biome dimension
        if (id0 == Block.sandStone.blockID && id1 == Block.blockLapis.blockID && id2 == id3 && id3 == id4 && id4 == id5 && id6 == id7 && id7 == id8 && id8 == id9 && id9 == id10 && id10 == id11
                && id11 == id12 && id12 == id13 && id13 == id14 && id14 == id15 && id15 == id16 && id17 == Block.stone.blockID)
        {
            if (Storageprops.vmenabledeserthills)
            {
                par1World.setBlock(par2, par3, par4, MiningWorldRegistrations.vanityportal.blockID, 1, 2);
                par1World.setBlock(par2, par3 + 1, par4, MiningWorldRegistrations.vanityportal.blockID, 1, 2);
                par1World.setBlock(par2, par3 + 2, par4, MiningWorldRegistrations.vanityportal.blockID, 1, 2);
                return true;
            }
        }
        //portal creation statements for the extreme hills biome dimension
        if (id0 == Block.blockEmerald.blockID && id1 == Block.blockLapis.blockID && id2 == id3 && id3 == id4 && id4 == id5 && id6 == id7 && id7 == id8 && id8 == id9 && id9 == id10 && id10 == id11
                && id11 == id12 && id12 == id13 && id13 == id14 && id14 == id15 && id15 == id16 && id17 == Block.stone.blockID)
        {
            if (Storageprops.vmenableextremehills)
            {
                par1World.setBlock(par2, par3, par4, MiningWorldRegistrations.vanityportal.blockID, 2, 2);
                par1World.setBlock(par2, par3 + 1, par4, MiningWorldRegistrations.vanityportal.blockID, 2, 2);
                par1World.setBlock(par2, par3 + 2, par4, MiningWorldRegistrations.vanityportal.blockID, 2, 2);
                return true;
            }
        }
        //portal creation statements for the forest biome dimension
        if (id0 == Block.wood.blockID && id1 == Block.blockLapis.blockID && id2 == id3 && id3 == id4 && id4 == id5 && id6 == id7 && id7 == id8 && id8 == id9 && id9 == id10 && id10 == id11
                && id11 == id12 && id12 == id13 && id13 == id14 && id14 == id15 && id15 == id16 && id17 == Block.stone.blockID)
        {
            if (Storageprops.vmenableforest)
            {
                par1World.setBlock(par2, par3, par4, MiningWorldRegistrations.vanityportal.blockID, 3, 2);
                par1World.setBlock(par2, par3 + 1, par4, MiningWorldRegistrations.vanityportal.blockID, 3, 2);
                par1World.setBlock(par2, par3 + 2, par4, MiningWorldRegistrations.vanityportal.blockID, 3, 2);
                return true;
            }
        }
        //portal creation statements for the taiga biome dimension
        if (id0 == Block.blockSnow.blockID && id1 == Block.blockLapis.blockID && id2 == id3 && id3 == id4 && id4 == id5 && id6 == id7 && id7 == id8 && id8 == id9 && id9 == id10 && id10 == id11
                && id11 == id12 && id12 == id13 && id13 == id14 && id14 == id15 && id15 == id16 && id17 == Block.stone.blockID)
        {
            if (Storageprops.vmenabletaiga)
            {
                par1World.setBlock(par2, par3, par4, MiningWorldRegistrations.vanityportal.blockID, 4, 2);
                par1World.setBlock(par2, par3 + 1, par4, MiningWorldRegistrations.vanityportal.blockID, 4, 2);
                par1World.setBlock(par2, par3 + 2, par4, MiningWorldRegistrations.vanityportal.blockID, 4, 2);
                return true;
            }
        }
        //portal creation statements for the swampland biome dimension
        if (id0 == Block.blockClay.blockID && id1 == Block.blockLapis.blockID && id2 == id3 && id3 == id4 && id4 == id5 && id5 == Block.waterStill.blockID && id6 == id7 && id7 == id8 && id8 == id9
                && id9 == id10 && id10 == id11 && id11 == id12 && id12 == id13 && id13 == id14 && id14 == id15 && id15 == id16 && id17 == Block.stone.blockID)
        {
            if (Storageprops.vmenableswampland)
            {
                par1World.setBlock(par2, par3, par4, MiningWorldRegistrations.vanityportal.blockID, 5, 2);
                par1World.setBlock(par2, par3 + 1, par4, MiningWorldRegistrations.vanityportal.blockID, 5, 2);
                par1World.setBlock(par2, par3 + 2, par4, MiningWorldRegistrations.vanityportal.blockID, 5, 2);
                return true;
            }
        }
        //portal creation statements for the shroom island biome dimension 
        if (id0 == Block.mycelium.blockID && id1 == Block.blockLapis.blockID && id2 == id3 && id3 == id4 && id4 == id5 && id6 == id7 && id7 == id8 && id8 == id9 && id9 == id10 && id10 == id11
                && id11 == id12 && id12 == id13 && id13 == id14 && id14 == id15 && id15 == id16 && id17 == Block.stone.blockID)
        {
            if (Storageprops.vmenableshroom)
            {
                par1World.setBlock(par2, par3, par4, MiningWorldRegistrations.vanityportal.blockID, 6, 2);
                par1World.setBlock(par2, par3 + 1, par4, MiningWorldRegistrations.vanityportal.blockID, 6, 2);
                par1World.setBlock(par2, par3 + 2, par4, MiningWorldRegistrations.vanityportal.blockID, 6, 2);
                return true;
            }
        }
        //portal creation statements for the jungle biome dimension
        if (id0 == Block.leaves.blockID && id1 == Block.blockLapis.blockID && id2 == id3 && id3 == id4 && id4 == id5 && id6 == id7 && id7 == id8 && id8 == id9 && id9 == id10 && id10 == id11
                && id11 == id12 && id12 == id13 && id13 == id14 && id14 == id15 && id15 == id16 && id17 == Block.stone.blockID)
        {
            if (Storageprops.vmenablejungle)
            {
                par1World.setBlock(par2, par3, par4, MiningWorldRegistrations.vanityportal.blockID, 7, 2);
                par1World.setBlock(par2, par3 + 1, par4, MiningWorldRegistrations.vanityportal.blockID, 7, 2);
                par1World.setBlock(par2, par3 + 2, par4, MiningWorldRegistrations.vanityportal.blockID, 7, 2);
                return true;
            }
        }
        //portal creation statements for the hell biome dimension
        if (id0 == id1 && id1 == Block.blockNetherQuartz.blockID && id2 == id3 && id3 == id4 && id4 == id5 && id6 == id7 && id7 == id8 && id8 == id9 && id9 == id10 && id10 == id11 && id11 == id12
                && id12 == id13 && id13 == id14 && id14 == id15 && id15 == id16 && id17 == Block.netherBrick.blockID)
        {
            if (Storageprops.vmenablehell)
            {
                par1World.setBlock(par2, par3, par4, MiningWorldRegistrations.vanityportal.blockID, 8, 2);
                par1World.setBlock(par2, par3 + 1, par4, MiningWorldRegistrations.vanityportal.blockID, 8, 2);
                par1World.setBlock(par2, par3 + 2, par4, MiningWorldRegistrations.vanityportal.blockID, 8, 2);
                return true;
            }
        }
        return false;
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    @Override
    public void onNeighborBlockChange (World par1World, int par2, int par3, int par4, int par5)
    {
        byte b0 = 0;
        byte b1 = 1;

        if (par1World.getBlockId(par2 - 1, par3, par4) == this.blockID || par1World.getBlockId(par2 + 1, par3, par4) == this.blockID)
        {
            b0 = 1;
            b1 = 0;
        }

        int i1;

        for (i1 = par3; par1World.getBlockId(par2, i1 - 1, par4) == this.blockID; --i1)
        {
            ;
        }

        if (par1World.getBlockId(par2, i1 - 1, par4) != Block.stone.blockID)
        {
            par1World.setBlockToAir(par2, par3, par4);
        }
        else
        {
            int j1;

            for (j1 = 1; j1 < 4 && par1World.getBlockId(par2, i1 + j1, par4) == this.blockID; ++j1)
            {
                ;
            }

            if (j1 == 3 && par1World.getBlockId(par2, i1 + j1, par4) == Block.stone.blockID)
            {
                boolean flag = par1World.getBlockId(par2 - 1, par3, par4) == this.blockID || par1World.getBlockId(par2 + 1, par3, par4) == this.blockID;
                boolean flag1 = par1World.getBlockId(par2, par3, par4 - 1) == this.blockID || par1World.getBlockId(par2, par3, par4 + 1) == this.blockID;

                if (flag && flag1)
                {
                    par1World.setBlockToAir(par2, par3, par4);
                }
                else
                {
                    if ((par1World.getBlockId(par2 + b0, par3, par4 + b1) != Block.stone.blockID || par1World.getBlockId(par2 - b0, par3, par4 - b1) != this.blockID)
                            && (par1World.getBlockId(par2 - b0, par3, par4 - b1) != Block.stone.blockID || par1World.getBlockId(par2 + b0, par3, par4 + b1) != this.blockID))
                    {
                        par1World.setBlockToAir(par2, par3, par4);
                    }
                }
            }
            else
            {
                par1World.setBlockToAir(par2, par3, par4);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    @Override
    public boolean shouldSideBeRendered (IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        if (par1IBlockAccess.getBlockId(par2, par3, par4) == this.blockID)
        {
            return false;
        }
        else
        {
            boolean flag = par1IBlockAccess.getBlockId(par2 - 1, par3, par4) == this.blockID && par1IBlockAccess.getBlockId(par2 - 2, par3, par4) != this.blockID;
            boolean flag1 = par1IBlockAccess.getBlockId(par2 + 1, par3, par4) == this.blockID && par1IBlockAccess.getBlockId(par2 + 2, par3, par4) != this.blockID;
            boolean flag2 = par1IBlockAccess.getBlockId(par2, par3, par4 - 1) == this.blockID && par1IBlockAccess.getBlockId(par2, par3, par4 - 2) != this.blockID;
            boolean flag3 = par1IBlockAccess.getBlockId(par2, par3, par4 + 1) == this.blockID && par1IBlockAccess.getBlockId(par2, par3, par4 + 2) != this.blockID;
            boolean flag4 = flag || flag1;
            boolean flag5 = flag2 || flag3;
            return flag4 && par5 == 4 ? true : (flag4 && par5 == 5 ? true : (flag5 && par5 == 2 ? true : flag5 && par5 == 3));
        }
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    @Override
    public int quantityDropped (Random par1Random)
    {
        return 0;
    }

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    @Override
    public void onEntityCollidedWithBlock (World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        if (par5Entity.ridingEntity == null && par5Entity.riddenByEntity == null)
        {
            if (par5Entity instanceof EntityPlayerMP)
            {
                EntityPlayer player = (EntityPlayerMP) par5Entity;
                //par5Entity.setInPortal();
                //if(par5Entity.getPortalCooldown() == 0)
                //if(Math.random() > 0.999)
                int metadata = par1World.getBlockMetadata(par2, par3, par4);
                //Plains dimension
                if (metadata == 0)
                {
                    if (par5Entity.timeUntilPortal == 0 && par5Entity instanceof EntityPlayerMP)
                    {
                        par5Entity.timeUntilPortal = 100;
                        MinecraftServer minecraftserver = MinecraftServer.getServer();
                        int dimID = par5Entity.dimension;
                        WorldServer worldserver = minecraftserver.worldServerForDimension(0);
                        WorldServer worldserver1 = minecraftserver.worldServerForDimension(Storageprops.vmplainsid);
                        if (dimID == Storageprops.vmplainsid)
                        {
                            minecraftserver.getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) par5Entity, 0, new TeleporterVanityPlains(worldserver));
                            //par5Entity.travelToDimension(-1);
                        }
                        else
                        {
                            minecraftserver.getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) par5Entity, Storageprops.vmplainsid, new TeleporterVanityPlains(worldserver1));
                            // par5Entity.travelToDimension(Storageprops.VanityMiningID);
                        }
                    }
                }
                if (metadata == 1)
                {
                    if (par5Entity.timeUntilPortal == 0 && par5Entity instanceof EntityPlayerMP)
                    {
                        par5Entity.timeUntilPortal = 100;
                        MinecraftServer minecraftserver = MinecraftServer.getServer();
                        int dimID = par5Entity.dimension;
                        WorldServer worldserver = minecraftserver.worldServerForDimension(0);
                        WorldServer worldserver1 = minecraftserver.worldServerForDimension(Storageprops.vmdeserthillsid);
                        if (dimID == Storageprops.vmdeserthillsid)
                        {
                            minecraftserver.getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) par5Entity, 0, new TeleporterVanityDesertHills(worldserver));
                            //par5Entity.travelToDimension(-1);
                        }
                        else
                        {
                            minecraftserver.getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) par5Entity, Storageprops.vmdeserthillsid,
                                    new TeleporterVanityDesertHills(worldserver1));
                            // par5Entity.travelToDimension(Storageprops.vmdeserthills);
                        }
                    }
                }
                if (metadata == 2)
                {
                    if (par5Entity.timeUntilPortal == 0 && par5Entity instanceof EntityPlayerMP)
                    {
                        par5Entity.timeUntilPortal = 100;
                        MinecraftServer minecraftserver = MinecraftServer.getServer();
                        int dimID = par5Entity.dimension;
                        WorldServer worldserver = minecraftserver.worldServerForDimension(0);
                        WorldServer worldserver1 = minecraftserver.worldServerForDimension(Storageprops.vmextremehillsid);
                        if (dimID == Storageprops.vmextremehillsid)
                        {
                            minecraftserver.getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) par5Entity, 0, new TeleporterVanityExtremehills(worldserver));
                            //par5Entity.travelToDimension(-1);
                        }
                        else
                        {
                            minecraftserver.getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) par5Entity, Storageprops.vmextremehillsid,
                                    new TeleporterVanityExtremehills(worldserver1));
                            // par5Entity.travelToDimension(Storageprops.vmdeserthills);
                        }
                    }
                }
                if (metadata == 3)
                {
                    if (par5Entity.timeUntilPortal == 0 && par5Entity instanceof EntityPlayerMP)
                    {
                        par5Entity.timeUntilPortal = 100;
                        MinecraftServer minecraftserver = MinecraftServer.getServer();
                        int dimID = par5Entity.dimension;
                        WorldServer worldserver = minecraftserver.worldServerForDimension(0);
                        WorldServer worldserver1 = minecraftserver.worldServerForDimension(Storageprops.vmforestid);
                        if (dimID == Storageprops.vmforestid)
                        {
                            minecraftserver.getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) par5Entity, 0, new TeleporterVanityForest(worldserver));
                            //par5Entity.travelToDimension(-1);
                        }
                        else
                        {
                            minecraftserver.getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) par5Entity, Storageprops.vmforestid, new TeleporterVanityForest(worldserver1));
                            // par5Entity.travelToDimension(Storageprops.vmdeserthills);
                        }
                    }
                }
                if (metadata == 4)
                {
                    if (par5Entity.timeUntilPortal == 0 && par5Entity instanceof EntityPlayerMP)
                    {
                        par5Entity.timeUntilPortal = 100;
                        MinecraftServer minecraftserver = MinecraftServer.getServer();
                        int dimID = par5Entity.dimension;
                        WorldServer worldserver = minecraftserver.worldServerForDimension(0);
                        WorldServer worldserver1 = minecraftserver.worldServerForDimension(Storageprops.vmtaigaid);
                        if (dimID == Storageprops.vmtaigaid)
                        {
                            minecraftserver.getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) par5Entity, 0, new TeleporterVanityTaiga(worldserver));
                            //par5Entity.travelToDimension(-1);
                        }
                        else
                        {
                            minecraftserver.getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) par5Entity, Storageprops.vmtaigaid, new TeleporterVanityTaiga(worldserver1));
                            // par5Entity.travelToDimension(Storageprops.vmdeserthills);
                        }
                    }
                }
                if (metadata == 5)
                {
                    if (par5Entity.timeUntilPortal == 0 && par5Entity instanceof EntityPlayerMP)
                    {
                        par5Entity.timeUntilPortal = 100;
                        MinecraftServer minecraftserver = MinecraftServer.getServer();
                        int dimID = par5Entity.dimension;
                        WorldServer worldserver = minecraftserver.worldServerForDimension(0);
                        WorldServer worldserver1 = minecraftserver.worldServerForDimension(Storageprops.vmswamplandid);
                        if (dimID == Storageprops.vmswamplandid)
                        {
                            minecraftserver.getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) par5Entity, 0, new TeleporterVanitySwampland(worldserver));
                            //par5Entity.travelToDimension(-1);
                        }
                        else
                        {
                            minecraftserver.getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) par5Entity, Storageprops.vmswamplandid, new TeleporterVanitySwampland(worldserver1));
                            // par5Entity.travelToDimension(Storageprops.vmdeserthills);
                        }
                    }
                }
                if (metadata == 6)
                {
                    if (par5Entity.timeUntilPortal == 0 && par5Entity instanceof EntityPlayerMP)
                    {
                        par5Entity.timeUntilPortal = 100;
                        MinecraftServer minecraftserver = MinecraftServer.getServer();
                        int dimID = par5Entity.dimension;
                        WorldServer worldserver = minecraftserver.worldServerForDimension(0);
                        WorldServer worldserver1 = minecraftserver.worldServerForDimension(Storageprops.vmshroomislandid);
                        if (dimID == Storageprops.vmshroomislandid)
                        {
                            minecraftserver.getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) par5Entity, 0, new TeleporterVanityShroom(worldserver));
                            //par5Entity.travelToDimension(-1);
                        }
                        else
                        {
                            minecraftserver.getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) par5Entity, Storageprops.vmshroomislandid, new TeleporterVanityShroom(worldserver1));
                            // par5Entity.travelToDimension(Storageprops.vmdeserthills);
                        }
                    }
                }
                if (metadata == 7)
                {
                    if (par5Entity.timeUntilPortal == 0 && par5Entity instanceof EntityPlayerMP)
                    {
                        par5Entity.timeUntilPortal = 100;
                        MinecraftServer minecraftserver = MinecraftServer.getServer();
                        int dimID = par5Entity.dimension;
                        WorldServer worldserver = minecraftserver.worldServerForDimension(0);
                        WorldServer worldserver1 = minecraftserver.worldServerForDimension(Storageprops.vmjungleid);
                        if (dimID == Storageprops.vmjungleid)
                        {
                            minecraftserver.getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) par5Entity, 0, new TeleporterVanityJungle(worldserver));
                            //par5Entity.travelToDimension(-1);
                        }
                        else
                        {
                            minecraftserver.getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) par5Entity, Storageprops.vmjungleid, new TeleporterVanityJungle(worldserver1));
                            // par5Entity.travelToDimension(Storageprops.vmdeserthills);
                        }
                    }
                }
                if (metadata == 8)
                {
                    final ArrayList<Integer> array = new ArrayList<Integer>();

                    if (par5Entity.timeUntilPortal == 0 && par5Entity instanceof EntityPlayerMP)
                    {
                        par5Entity.timeUntilPortal = 100;
                        MinecraftServer minecraftserver = MinecraftServer.getServer();
                        int dimID = par5Entity.dimension;
                        WorldServer worldserver = minecraftserver.worldServerForDimension(0);
                        WorldServer worldserver1 = minecraftserver.worldServerForDimension(Storageprops.vmhellid);
                        if (dimID == Storageprops.vmhellid)
                        {
                            minecraftserver.getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) par5Entity, 0, new TeleporterVanityHell(worldserver));
                            //par5Entity.travelToDimension(-1);
                        }
                        else
                        {
                            minecraftserver.getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) par5Entity, Storageprops.vmhellid, new TeleporterVanityHell(worldserver1));
                            minecraftserver.getConfigurationManager().sendPacketToAllPlayers(PacketDimensionList.buildDimensionListPacket(array));
                            // par5Entity.travelToDimension(Storageprops.vmdeserthills);
                        }

                    }
                }
            }
        }
    }

    private Icon[] iconBuffer;

    @Override
    public void registerIcons (IconRegister par1IconRegister)
    {
        iconBuffer = new Icon[9];

        iconBuffer[0] = par1IconRegister.registerIcon("vanityblocks:dimensions/blockvanityportalplains");
        iconBuffer[1] = par1IconRegister.registerIcon("vanityblocks:dimensions/blockvanityportaldeserthills");
        iconBuffer[2] = par1IconRegister.registerIcon("vanityblocks:dimensions/blockvanityportalextremehills");
        iconBuffer[3] = par1IconRegister.registerIcon("vanityblocks:dimensions/blockvanityportalforest");
        iconBuffer[4] = par1IconRegister.registerIcon("vanityblocks:dimensions/blockvanityportaltaiga");
        iconBuffer[5] = par1IconRegister.registerIcon("vanityblocks:dimensions/blockvanityportalswampland");
        iconBuffer[6] = par1IconRegister.registerIcon("vanityblocks:dimensions/blockvanityportalshroom");
        iconBuffer[7] = par1IconRegister.registerIcon("vanityblocks:dimensions/blockvanityportaljungle");
        iconBuffer[8] = par1IconRegister.registerIcon("vanityblocks:dimensions/blockvanityportalhell");
    }

    @Override
    public Icon getIcon (int side, int metadata)
    {

        if (metadata == 0)
        {
            return iconBuffer[0];
        }
        if (metadata == 1)
        {
            return iconBuffer[1];
        }
        if (metadata == 2)
        {
            return iconBuffer[2];
        }
        if (metadata == 3)
        {
            return iconBuffer[3];
        }
        if (metadata == 4)
        {
            return iconBuffer[4];
        }
        if (metadata == 5)
        {
            return iconBuffer[5];
        }
        if (metadata == 6)
        {
            return iconBuffer[6];
        }
        if (metadata == 7)
        {
            return iconBuffer[7];
        }
        if (metadata == 8)
        {
            return iconBuffer[8];
        }
        if (metadata == 8)
        {
            return iconBuffer[8];
        }
        return blockIcon;
    }

    @SideOnly(Side.CLIENT)
    /**
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
    @Override
    public int getRenderBlockPass ()
    {
        return 1;
    }

    @SideOnly(Side.CLIENT)
    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     */
    @Override
    public int idPicked (World par1World, int par2, int par3, int par4)
    {
        return 0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks (int par1, CreativeTabs tab, List subItems)
    {
        for (int ix = 0; ix < 9; ix++)
        {
            subItems.add(new ItemStack(this, 1, ix));
        }
    }
}