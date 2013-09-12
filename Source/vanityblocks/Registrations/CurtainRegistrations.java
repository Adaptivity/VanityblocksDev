package vanityblocks.Registrations;

import vanityblocks.Storageprops;
import vanityblocks.Blocks.BlockCurtain;
import vanityblocks.Blocks.HiddenTrapdoor;
import vanityblocks.Blocks.VanityRandomBlocks;
import vanityblocks.ItemBlocks.VanityRandomItemBlock;
import vanityblocks.tileentitys.TileCurtain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class CurtainRegistrations {
// https://raw.github.com/mDiyo/TinkersConstruct/master/src/tconstruct/client/block/TableRender.java
// https://github.com/mDiyo/TinkersConstruct/blob/master/src/tconstruct/blocks/ToolStationBlock.java#L99
// Use te's for it, so rewrite and follow carpenters way.
	public static void CurtainRegistration() {
		curtainblockconfig = Storageprops.curtainblockconfig;
		CurtainBlock = new BlockCurtain(curtainblockconfig);

		/* ##### Vannila ##### */
		GameRegistry.registerBlock(CurtainBlock,
				vanityblocks.ItemBlocks.CurtainItemBlock.class,
				"Curtain Blocks");
		LanguageRegistry.addName(new ItemStack(CurtainBlock, 1, 0),
				"E-W Curtain");
		LanguageRegistry.addName(new ItemStack(CurtainBlock, 1, 1),
				"N-S Curtain");
    	GameRegistry.registerTileEntity(TileCurtain.class, "TileEntityCurtain");
	}

	public static void addCurtainRecipes() {
		// System.out.println("Random Block Registration loaded");
		}
public static int curtainblockconfig;
public static Block CurtainBlock;
}