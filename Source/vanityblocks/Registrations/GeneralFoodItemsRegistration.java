package vanityblocks.Registrations;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
	
//	if (Storageprops.enableflintitem) {		
	// ############# to make the flint item
//	GameRegistry.addRecipe(new ItemStack(flintitem,1), "xxx", "xxx", "xxx", 'x', new ItemStack(Item.flint,1));
//	GameRegistry.addShapelessRecipe(new ItemStack(Item.flint,9), new ItemStack(flintitem));
//	GameRegistry.addShapelessRecipe(new ItemStack(bluerupee5), new ItemStack(greenrupee1), new ItemStack(greenrupee1), new ItemStack(greenrupee1), new ItemStack(greenrupee1), new ItemStack(greenrupee1));
//	}
}
}