/*
 *     public static final Block redstoneLampIdle = (new BlockRedstoneLight(123, false)).setHardness(0.3F).setStepSound(soundGlassFootstep).setUnlocalizedName("redstoneLight").setCreativeTab(CreativeTabs.tabRedstone).func_111022_d("redstone_lamp_off");
    public static final Block redstoneLampActive = (new BlockRedstoneLight(124, true)).setHardness(0.3F).setStepSound(soundGlassFootstep).setUnlocalizedName("redstoneLight").func_111022_d("redstone_lamp_on");
 */
package vanityblocks.Registrations;

import vanityblocks.RedstoneLampDimItemBlock;
import vanityblocks.RedstoneLampLitItemBlock;
import vanityblocks.RedstonedimLamps;
import vanityblocks.RedstonelitLamps;
import vanityblocks.VanityRandomBlocks;
import vanityblocks.VanityRandomItemBlock;
import vanityblocks.Storageprops;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class RedstoneLampRegistrations {

	public static void redstonelampregistration() {
		redstonelampdimconfig = Storageprops.redstonelampdimconfig;
		RedstoneLampDim = new RedstonedimLamps(redstonelampdimconfig, false);

		redstonelamplitconfig = Storageprops.redstonelamplitconfig;
		RedstoneLampLit = new RedstonelitLamps(redstonelamplitconfig, true);
		// String[] randomblocknames = { "Clay Brick",
		// "White Soul Sand", "Lapis block - old", "Lapis Brick - old",
		// "Lapis Brick - Current", "Invisible Glass", "", "",
		// "", "", "", "" };
		/* ##### Dim Lamps ##### */
		GameRegistry.registerBlock(RedstoneLampDim,
				RedstoneLampDimItemBlock.class, "Redstone Lamp Dim");
		LanguageRegistry.addName(new ItemStack(RedstoneLampDim, 1, 0),
				"Dim Black Redstone Lamp");
		LanguageRegistry.addName(new ItemStack(RedstoneLampDim, 1, 1),
				"Dim Red Redstone Lamp");
		LanguageRegistry.addName(new ItemStack(RedstoneLampDim, 1, 2),
				"Dim Green Redstone Lamp");
		LanguageRegistry.addName(new ItemStack(RedstoneLampDim, 1, 3),
				"Dim Brown Redstone Lamp");
		LanguageRegistry.addName(new ItemStack(RedstoneLampDim, 1, 4),
				"Dim Blue Redstone Lamp");
		LanguageRegistry.addName(new ItemStack(RedstoneLampDim, 1, 5),
				"Dim Purple Redstone Lamp");
		LanguageRegistry.addName(new ItemStack(RedstoneLampDim, 1, 6),
				"Dim Pink Redstone Lamp");
		LanguageRegistry.addName(new ItemStack(RedstoneLampDim, 1, 7),
				"Dim Light Blue Redstone Lamp");
		LanguageRegistry.addName(new ItemStack(RedstoneLampDim, 1, 8),
				"Dim Magenta Redstone Lamp");
		// #### Lit Lamps ###
		GameRegistry.registerBlock(RedstoneLampLit,
				RedstoneLampLitItemBlock.class, "Redstone Lamp Lit");
		LanguageRegistry.addName(new ItemStack(RedstoneLampLit, 1, 0),
				"Lit Black Redstone Lamp");
		LanguageRegistry.addName(new ItemStack(RedstoneLampLit, 1, 1),
				"Lit Red Redstone Lamp");
		LanguageRegistry.addName(new ItemStack(RedstoneLampLit, 1, 2),
				"Lit Green Redstone Lamp");
		LanguageRegistry.addName(new ItemStack(RedstoneLampLit, 1, 3),
				"Lit Brown Redstone Lamp");
		LanguageRegistry.addName(new ItemStack(RedstoneLampLit, 1, 4),
				"Lit Blue Redstone Lamp");
		LanguageRegistry.addName(new ItemStack(RedstoneLampLit, 1, 5),
				"Lit Purple Redstone Lamp");
		LanguageRegistry.addName(new ItemStack(RedstoneLampLit, 1, 6),
				"Lit Pink Redstone Lamp");
		LanguageRegistry.addName(new ItemStack(RedstoneLampLit, 1, 7),
				"Lit Light Blue Redstone Lamp");
		LanguageRegistry.addName(new ItemStack(RedstoneLampLit, 1, 8),
				"Lit Magenta Redstone Lamp");
	}

	public static void addRecipes() {
	}

	public static Block RedstoneLampDim;
	public static int redstonelampdimconfig;
	public static Block RedstoneLampLit;
	public static int redstonelamplitconfig;
}
