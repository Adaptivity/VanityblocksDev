package vanityblocks.Registrations;

import vanityblocks.Storageprops;
import vanityblocks.Blocks.CompressBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class CompressedRegistrations
{

    public static void compressblockregistration ()
    {
        compressblocksconfig = Storageprops.compressblocksconfig;
        CompressBlocks = new CompressBlocks(compressblocksconfig);

        String[] randomblocknames = { "9X Compressed CobblesStone", "81X Compressed CobblesStone", "729X Compressed CobblesStone", "9X Compressed Dirt", "81X Compressed Dirt", "729X Compressed Dirt",
                "9X Compressed Sand", "81X Compressed Sand", "729X Compressed Sand", "9X Compressed Gravel", "81X Compressed Gravel", "729X Compressed Gravel", "", "", "", "" };
        /* ##### Vannila ##### */
        GameRegistry.registerBlock(CompressBlocks, vanityblocks.ItemBlocks.CompressItemBlock.class, "Compressed Blocks");
        LanguageRegistry.addName(new ItemStack(CompressBlocks, 1, 0), "9X Compressed CobbleStone");
        LanguageRegistry.addName(new ItemStack(CompressBlocks, 1, 1), "81X Compressed CobbleStone");
        LanguageRegistry.addName(new ItemStack(CompressBlocks, 1, 2), "729X Compressed CobbleStone");
        LanguageRegistry.addName(new ItemStack(CompressBlocks, 1, 3), "9X Compressed Dirt");
        LanguageRegistry.addName(new ItemStack(CompressBlocks, 1, 4), "81X Compressed Dirt");
        LanguageRegistry.addName(new ItemStack(CompressBlocks, 1, 5), "729X Compressed Dirt");
        LanguageRegistry.addName(new ItemStack(CompressBlocks, 1, 6), "9X Compressed Sand");
        LanguageRegistry.addName(new ItemStack(CompressBlocks, 1, 7), "81X Compressed Sand");
        LanguageRegistry.addName(new ItemStack(CompressBlocks, 1, 8), "729X Compressed Sand");
        LanguageRegistry.addName(new ItemStack(CompressBlocks, 1, 9), "9X Compressed Gravel");
        LanguageRegistry.addName(new ItemStack(CompressBlocks, 1, 10), "81X Compressed Gravel");
        LanguageRegistry.addName(new ItemStack(CompressBlocks, 1, 11), "729X Compressed Gravel");
    }

    public static void addRecipes ()
    {
        //Cobble 
        GameRegistry.addRecipe(new ItemStack(CompressBlocks, 1, 0), new Object[] { "xxx", "xxx", "xxx", 'x', new ItemStack(Block.cobblestone) });
        GameRegistry.addShapelessRecipe(new ItemStack(Block.cobblestone, 9), new ItemStack(CompressBlocks, 1, 0));

        GameRegistry.addRecipe(new ItemStack(CompressBlocks, 1, 1), new Object[] { "xxx", "xxx", "xxx", 'x', new ItemStack(CompressBlocks, 1, 0) });
        GameRegistry.addShapelessRecipe(new ItemStack(CompressBlocks, 9, 0), new ItemStack(CompressBlocks, 1, 1));

        GameRegistry.addRecipe(new ItemStack(CompressBlocks, 1, 2), new Object[] { "xxx", "xxx", "xxx", 'x', new ItemStack(CompressBlocks, 1, 1) });
        GameRegistry.addShapelessRecipe(new ItemStack(CompressBlocks, 9, 1), new ItemStack(CompressBlocks, 1, 2));
        /* Dirt */
        GameRegistry.addRecipe(new ItemStack(CompressBlocks, 1, 3), new Object[] { "xxx", "xxx", "xxx", 'x', new ItemStack(Block.dirt) });
        GameRegistry.addShapelessRecipe(new ItemStack(Block.dirt, 9), new ItemStack(CompressBlocks, 1, 3));

        GameRegistry.addRecipe(new ItemStack(CompressBlocks, 1, 4), new Object[] { "xxx", "xxx", "xxx", 'x', new ItemStack(CompressBlocks, 1, 3) });
        GameRegistry.addShapelessRecipe(new ItemStack(CompressBlocks, 9, 3), new ItemStack(CompressBlocks, 1, 4));

        GameRegistry.addRecipe(new ItemStack(CompressBlocks, 1, 5), new Object[] { "xxx", "xxx", "xxx", 'x', new ItemStack(CompressBlocks, 1, 4) });
        GameRegistry.addShapelessRecipe(new ItemStack(CompressBlocks, 9, 4), new ItemStack(CompressBlocks, 1, 5));
        /* Sand */
        GameRegistry.addRecipe(new ItemStack(CompressBlocks, 1, 6), new Object[] { "xxx", "xxx", "xxx", 'x', new ItemStack(Block.sand) });
        GameRegistry.addShapelessRecipe(new ItemStack(Block.sand, 9), new ItemStack(CompressBlocks, 1, 6));

        GameRegistry.addRecipe(new ItemStack(CompressBlocks, 1, 7), new Object[] { "xxx", "xxx", "xxx", 'x', new ItemStack(CompressBlocks, 1, 6) });
        GameRegistry.addShapelessRecipe(new ItemStack(CompressBlocks, 9, 6), new ItemStack(CompressBlocks, 1, 7));

        GameRegistry.addRecipe(new ItemStack(CompressBlocks, 1, 8), new Object[] { "xxx", "xxx", "xxx", 'x', new ItemStack(CompressBlocks, 1, 7) });
        GameRegistry.addShapelessRecipe(new ItemStack(CompressBlocks, 9, 7), new ItemStack(CompressBlocks, 1, 8));
        /* Gravel */
        GameRegistry.addRecipe(new ItemStack(CompressBlocks, 1, 9), new Object[] { "xxx", "xxx", "xxx", 'x', new ItemStack(Block.gravel) });
        GameRegistry.addShapelessRecipe(new ItemStack(Block.gravel, 9), new ItemStack(CompressBlocks, 1, 9));

        GameRegistry.addRecipe(new ItemStack(CompressBlocks, 1, 10), new Object[] { "xxx", "xxx", "xxx", 'x', new ItemStack(CompressBlocks, 1, 9) });
        GameRegistry.addShapelessRecipe(new ItemStack(CompressBlocks, 9, 9), new ItemStack(CompressBlocks, 1, 10));

        GameRegistry.addRecipe(new ItemStack(CompressBlocks, 1, 11), new Object[] { "xxx", "xxx", "xxx", 'x', new ItemStack(CompressBlocks, 1, 10) });
        GameRegistry.addShapelessRecipe(new ItemStack(CompressBlocks, 9, 10), new ItemStack(CompressBlocks, 1, 11));
    }

    public static Block CompressBlocks;
    public static int compressblocksconfig;
}