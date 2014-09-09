package com.vanityblocks.Registrations;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.vanityblocks.Storageprops;
import com.vanityblocks.Blocks.MarbleStair;
import com.vanityblocks.Blocks.MarbleWall;
import com.vanityblocks.Blocks.Marbleslab;
import com.vanityblocks.Blocks.Designblock;
import com.vanityblocks.Blocks.DesignWorldblock;
import com.vanityblocks.ItemBlocks.ItemBlockMarbleSlab;
import com.vanityblocks.ItemBlocks.ItemBlockMarbleWall;
import com.vanityblocks.ItemBlocks.DesignItemBlock;
import com.vanityblocks.ItemBlocks.DesignWorldItemBlock;
import com.vanityblocks.ItemBlocks.TileItemBlock;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class VanityBlocksRegistration
{

    public static Block VanityDesignblock;
    public static int VanityDesignId;
    public static int VanityDesignworldId;
    public static Block VanityDesignworldblock;
    public static int VanityDesignworldslabId;
    public static Block VanityDesignworldslabblock;
    public static int VanityDesignworldWallId;
    public static Block VanityDesignworldWallblock;
    public static Block marblestair;
    public static Block marblebrickstair;
    public static Block marblepillarstair;
    public static Block marbletilestair;
    public static Block blackmarblestair;
    public static Block blackmarblebrickstair;
    public static Block blackmarblepillarstair;
    public static Block blackmarbletilestair;

    public static void vanityregistration ()
    {
        VanityDesignId = Storageprops.vanitydesignconfig;
        VanityDesignblock = new Designblock(VanityDesignId);

        VanityDesignworldId = Storageprops.vanitydesignworldconfig;
        VanityDesignworldblock = new DesignWorldblock(VanityDesignworldId);

        VanityDesignworldslabId = Storageprops.vanitydesignworldslabconfig;
        VanityDesignworldslabblock = new Marbleslab(VanityDesignworldslabId);

        VanityDesignworldWallId = Storageprops.vanitydesignworldWallconfig;
        VanityDesignworldWallblock = new MarbleWall(VanityDesignworldWallId, VanityDesignworldblock);


        /* Block registration and naming for vanity */
        GameRegistry.registerBlock(VanityDesignblock, DesignItemBlock.class, "Vanity Blocks Design blocks");


        /* Block registration and naming for world gen */
        if (Storageprops.generatemarble && Storageprops.generateblackmarble)
        {
            GameRegistry.registerBlock(VanityDesignworldblock, DesignWorldItemBlock.class, "Vanity Blocks World blocks");
        }
        /*
         * Block Registration of Slabs
         */
        if (Storageprops.generatemarble && Storageprops.generateblackmarble && Storageprops.marbleslabs)
        {
            GameRegistry.registerBlock(VanityDesignworldslabblock, ItemBlockMarbleSlab.class, "Vanity Blocks World Block slabs");

        }
        /*
         * Block Registration of Marble walls
         */
        if (Storageprops.generatemarble && Storageprops.generateblackmarble && Storageprops.marblewalls)
        {
            GameRegistry.registerBlock(VanityDesignworldWallblock, ItemBlockMarbleWall.class, "Vanity Blocks World Block Walls");
        }
        if (Storageprops.generatemarble && Storageprops.marblestairs)
        {
            marblestair = new MarbleStair(Storageprops.marblestair, VanityDesignworldblock, 0).setBlockName("marblestair");
            marblestair.stepSound = Block.soundTypeStone;
            GameRegistry.registerBlock(marblestair, "marblestair");

            marblebrickstair = new MarbleStair(Storageprops.marblebrickstair, VanityDesignworldblock, 1).setBlockName("marblebrickstair");
            marblebrickstair.stepSound = Block.soundTypeStone;
            GameRegistry.registerBlock(marblebrickstair, "marblebrickstair");

            marblepillarstair = new MarbleStair(Storageprops.marblepillarstair, VanityDesignworldblock, 3).setBlockName("marblepillarstair");
            marblepillarstair.stepSound = Block.soundTypeStone;
            GameRegistry.registerBlock(marblepillarstair, "marblepillarstair");

            marbletilestair = new MarbleStair(Storageprops.marbletilestair, VanityDesignworldblock, 4).setBlockName("marbletilestair");
            marbletilestair.stepSound = Block.soundTypeStone;
            GameRegistry.registerBlock(marbletilestair, "marbletilestair");
        }
        if (Storageprops.generateblackmarble && Storageprops.marblestairs)
        {
            blackmarblestair = new MarbleStair(Storageprops.blackmarblestair, VanityDesignworldblock, 5).setBlockName("blackmarblestair");
            blackmarblestair.stepSound = Block.soundTypeStone;
            GameRegistry.registerBlock(blackmarblestair, "blackmarblestair");

            blackmarblebrickstair = new MarbleStair(Storageprops.blackmarblebrickstair, VanityDesignworldblock, 6).setBlockName("blackmarblebrickstair");
            blackmarblebrickstair.stepSound = Block.soundTypeStone;
            GameRegistry.registerBlock(blackmarblebrickstair, "blackmarblebrickstair");

            blackmarblepillarstair = new MarbleStair(Storageprops.blackmarblepillarstair, VanityDesignworldblock, 8).setBlockName("blackmarblepillarstair");
            blackmarblepillarstair.stepSound = Block.soundTypeStone;
            GameRegistry.registerBlock(blackmarblepillarstair, "blackmarblepillarstair");

            blackmarbletilestair = new MarbleStair(Storageprops.blackmarbletilestair, VanityDesignworldblock, 9).setBlockName("blackmarbletilestair");
            blackmarbletilestair.stepSound = Block.soundTypeStone;
            GameRegistry.registerBlock(blackmarbletilestair, "blackmarbletilestair");
        }
    }

    public static void addVanityRecipes ()
    {
        // ##### This is Vanity Block Recipes
        ItemStack glasspane = new ItemStack(Blocks.glass_pane);
        ItemStack lavabukkit = new ItemStack(Items.lava_bucket);
        if (Storageprops.enablelavalamp)
        {
            GameRegistry.addRecipe(new ItemStack(VanityDesignblock, 4, 0), "zxz", "xyx", "zxz", 'x', glasspane, 'y', lavabukkit, 'z', Blocks.stone);
        }
        if (Storageprops.enablestoneglowstone)
        {
            GameRegistry.addRecipe(new ItemStack(VanityDesignblock, 1, 1), " x ", "xyx", " x ", 'x', Blocks.stone, 'y', Blocks.glowstone);
        }
        // ##### This is world gen recipes for marble/black marble
        if (Storageprops.generatemarble)
        {
            GameRegistry.addRecipe(new ItemStack(VanityDesignworldblock, 4, 1), "xx", "xx", 'x', new ItemStack(VanityDesignworldblock, 0, 0));
            GameRegistry.addShapelessRecipe(new ItemStack(VanityDesignworldblock, 1, 0), new ItemStack(VanityDesignworldblock, 0, 1));
            GameRegistry.addRecipe(new ItemStack(VanityDesignworldblock, 4, 2), "xx", "xx", 'x', new ItemStack(VanityDesignworldblock, 0, 1));
            GameRegistry.addRecipe(new ItemStack(VanityDesignworldblock, 2, 3), "x", "x", 'x', new ItemStack(VanityDesignworldblock, 0, 0));
            GameRegistry.addRecipe(new ItemStack(VanityDesignworldblock, 4, 4), " x ", "x x", " x ", 'x', new ItemStack(VanityDesignworldblock, 0, 0));

        }
        if (Storageprops.generateblackmarble)
        {
            GameRegistry.addRecipe(new ItemStack(VanityDesignworldblock, 4, 6), "xx", "xx", 'x', new ItemStack(VanityDesignworldblock, 0, 5));
            GameRegistry.addShapelessRecipe(new ItemStack(VanityDesignworldblock, 1, 5), new ItemStack(VanityDesignworldblock, 0, 6));
            GameRegistry.addRecipe(new ItemStack(VanityDesignworldblock, 4, 7), "xx", "xx", 'x', new ItemStack(VanityDesignworldblock, 0, 6));
            GameRegistry.addRecipe(new ItemStack(VanityDesignworldblock, 2, 8), "x", "x", 'x', new ItemStack(VanityDesignworldblock, 0, 5));
            GameRegistry.addRecipe(new ItemStack(VanityDesignworldblock, 4, 9), " x ", "x x", " x ", 'x', new ItemStack(VanityDesignworldblock, 0, 5));
        }

        /* Marble Slabs */
        if (Storageprops.generatemarble && Storageprops.generateblackmarble && Storageprops.marbleslabs)
        {
            GameRegistry.addRecipe(new ItemStack(VanityDesignworldslabblock, 6, 0), "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 0));
            GameRegistry.addRecipe(new ItemStack(VanityDesignworldslabblock, 6, 1), "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 1));
            GameRegistry.addRecipe(new ItemStack(VanityDesignworldslabblock, 6, 2), "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 2));
            GameRegistry.addRecipe(new ItemStack(VanityDesignworldslabblock, 6, 3), "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 3));
            GameRegistry.addRecipe(new ItemStack(VanityDesignworldslabblock, 6, 4), "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 4));
            GameRegistry.addRecipe(new ItemStack(VanityDesignworldslabblock, 6, 5), "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 5));
            GameRegistry.addRecipe(new ItemStack(VanityDesignworldslabblock, 6, 6), "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 6));
            GameRegistry.addRecipe(new ItemStack(VanityDesignworldslabblock, 6, 7), "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 7));
            GameRegistry.addRecipe(new ItemStack(VanityDesignworldslabblock, 6, 8), "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 8));
            GameRegistry.addRecipe(new ItemStack(VanityDesignworldslabblock, 6, 9), "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 9));
        }
        /* Marble walls */
        if (Storageprops.generatemarble && Storageprops.generateblackmarble && Storageprops.marblewalls)
        {
            GameRegistry.addRecipe(new ItemStack(VanityDesignworldWallblock, 6, 0), "xxx", "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 0));
            GameRegistry.addRecipe(new ItemStack(VanityDesignworldWallblock, 6, 1), "xxx", "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 1));
            GameRegistry.addRecipe(new ItemStack(VanityDesignworldWallblock, 6, 2), "xxx", "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 2));
            GameRegistry.addRecipe(new ItemStack(VanityDesignworldWallblock, 6, 3), "xxx", "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 3));
            GameRegistry.addRecipe(new ItemStack(VanityDesignworldWallblock, 6, 4), "xxx", "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 4));
            GameRegistry.addRecipe(new ItemStack(VanityDesignworldWallblock, 6, 5), "xxx", "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 5));
            GameRegistry.addRecipe(new ItemStack(VanityDesignworldWallblock, 6, 6), "xxx", "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 6));
            GameRegistry.addRecipe(new ItemStack(VanityDesignworldWallblock, 6, 7), "xxx", "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 7));
            GameRegistry.addRecipe(new ItemStack(VanityDesignworldWallblock, 6, 8), "xxx", "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 8));
            GameRegistry.addRecipe(new ItemStack(VanityDesignworldWallblock, 6, 9), "xxx", "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 9));

        }
        /* Recipes for marble stairs */
        if (Storageprops.generatemarble && Storageprops.marblestairs)
        {
            GameRegistry.addRecipe(new ItemStack(marblestair, 4), "  x", " xx", "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 0));
            GameRegistry.addRecipe(new ItemStack(marblestair, 4), "x   ", "xx ", "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 0));
            GameRegistry.addRecipe(new ItemStack(marblebrickstair, 4), "  x", " xx", "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 1));
            GameRegistry.addRecipe(new ItemStack(marblebrickstair, 4), "x   ", "xx ", "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 1));
            GameRegistry.addRecipe(new ItemStack(marblepillarstair, 4), "  x", " xx", "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 3));
            GameRegistry.addRecipe(new ItemStack(marblepillarstair, 4), "x   ", "xx ", "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 3));
            GameRegistry.addRecipe(new ItemStack(marbletilestair, 4), "  x", " xx", "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 4));
            GameRegistry.addRecipe(new ItemStack(marbletilestair, 4), "x   ", "xx ", "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 4));
        }
        if (Storageprops.generateblackmarble && Storageprops.marblestairs)
        {
            GameRegistry.addRecipe(new ItemStack(blackmarblestair, 4), "  x", " xx", "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 5));
            GameRegistry.addRecipe(new ItemStack(blackmarblestair, 4), "x   ", "xx ", "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 5));
            GameRegistry.addRecipe(new ItemStack(blackmarblebrickstair, 4), "  x", " xx", "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 6));
            GameRegistry.addRecipe(new ItemStack(blackmarblebrickstair, 4), "x   ", "xx ", "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 6));
            GameRegistry.addRecipe(new ItemStack(blackmarblepillarstair, 4), "  x", " xx", "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 8));
            GameRegistry.addRecipe(new ItemStack(blackmarblepillarstair, 4), "x   ", "xx ", "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 8));
            GameRegistry.addRecipe(new ItemStack(blackmarbletilestair, 4), "  x", " xx", "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 9));
            GameRegistry.addRecipe(new ItemStack(blackmarbletilestair, 4), "x   ", "xx ", "xxx", 'x', new ItemStack(VanityDesignworldblock, 0, 9));
        }
    }

}
