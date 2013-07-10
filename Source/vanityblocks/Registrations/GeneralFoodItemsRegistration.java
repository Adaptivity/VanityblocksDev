package vanityblocks.Registrations;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;
import vanityblocks.Storageprops;
import vanityblocks.Items.ClayMugItem;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class GeneralFoodItemsRegistration {
	public static Item claymugitem;

	
	public static void generalitemregistration() {
		if (Storageprops.enableclaymugstuff) {
			claymugitem = new ClayMugItem(Storageprops.mugunfired - 256, 0).setUnlocalizedName("ClaymugItem");

		}
}
	public static void additemrecipes() {
		if (Storageprops.enableclaymugstuff) {
	GameRegistry.addRecipe(new ItemStack(claymugitem,0), "x x", " x ", 'x', new ItemStack(Item.clay,1));
    FurnaceRecipes.smelting().addSmelting(claymugitem.itemID, 0, new ItemStack(claymugitem, 1, 1), 0.0f); //Concecrated Soil
//	GameRegistry.addShapelessRecipe(new ItemStack(bluerupee5), new ItemStack(greenrupee1), new ItemStack(greenrupee1), new ItemStack(greenrupee1), new ItemStack(greenrupee1), new ItemStack(greenrupee1));
		}
	}
}