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

public class CompressedRegistrations {

	public static void compressblockregistration() {
		compressblocksconfig = Storageprops.compressblocksconfig;
		CompressBlocks = new CompressBlocks(compressblocksconfig);

		String[] randomblocknames = { "9X Compressed CobblesStone", "81X Compressed CobblesStone",
				"729X Compressed CobblesStone", "",
				"", "", "", "", "", "", "",
				"" };
		/* ##### Vannila ##### */
		GameRegistry.registerBlock(CompressBlocks,
				vanityblocks.ItemBlocks.CompressItemBlock.class,
				"Compressed Blocks");
		LanguageRegistry.addName(new ItemStack(CompressBlocks, 1, 0),
				"9X Compressed CobbleStone");
		LanguageRegistry.addName(new ItemStack(CompressBlocks, 1, 1),
				"81X Compressed CobbleStone");
		LanguageRegistry.addName(new ItemStack(CompressBlocks, 1, 2),
				"729X Compressed CobbleStone");
	}

	public static void addRecipes() {
		// System.out.println("Random Block Registration loaded");
		GameRegistry.addRecipe(new ItemStack(CompressBlocks, 1, 0),
				new Object[] { "xxx", "xxx", "xxx", 'x',
						new ItemStack(Block.cobblestone) });
		GameRegistry.addShapelessRecipe(new ItemStack(Block.cobblestone, 9),
				new ItemStack(CompressBlocks, 1, 0));
		
		GameRegistry.addRecipe(new ItemStack(CompressBlocks, 1, 1),
				new Object[] { "xxx", "xxx", "xxx", 'x',
						new ItemStack(CompressBlocks, 1, 0) });
		GameRegistry.addShapelessRecipe(new ItemStack(CompressBlocks, 9, 0),
				new ItemStack(CompressBlocks, 1, 1));
		
		GameRegistry.addRecipe(new ItemStack(CompressBlocks, 1, 2),
				new Object[] { "xxx", "xxx", "xxx", 'x',
						new ItemStack(CompressBlocks, 1, 1) });
		GameRegistry.addShapelessRecipe(new ItemStack(CompressBlocks, 9, 1),
				new ItemStack(CompressBlocks, 1, 2));
		}

	public static Block CompressBlocks;
	public static int compressblocksconfig;
}