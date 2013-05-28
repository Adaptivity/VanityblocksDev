package vanityblocks.Registrations;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import vanityblocks.ForestryBlock;
import vanityblocks.StorageBlock;
import vanityblocks.StorageBlockMod;
import vanityblocks.Storageprops;
import vanityblocks.items.greenrupee;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemRegistration {
	public static Item greenrupee1;
	public static Item bluerupee5;
	public static Item redrupee20;
	public static Item biggreenrupee50;
	public static Item bigbluerupee100;
	public static Item bigredrupee200;	
	
	public static void itemregistration() {
		if (Storageprops.enablerupees) {
			/*##### Items ##### */
			//	GameRegistry.registerBlock(StorageBlock, vanityblocks.StorageItemBlock.class, "Vannila Storage Block");
			//	LanguageRegistry.addName(new ItemStack(StorageBlock, 1, 0), "Charcoal block");
//			GameRegistry.registerItem(greenrupee1, "greenrupee");
			greenrupee1 = new greenrupee(Storageprops.greenrupee1).setUnlocalizedName("Greenrupee");
			LanguageRegistry.addName(greenrupee1, "Green Rupee - 1 Rupee");
    }
}
	public static void addrupeerecipes() {
	
	if (Storageprops.enablerupees) {
		
		
//	GameRegistry.addRecipe(new ItemStack(StorageBlock, 1, 0), "xxx", "xxx", "xxx", 'x', new ItemStack(Item.coal,1,1));
//	GameRegistry.addShapelessRecipe(new ItemStack(Item.coal, 9, 1), new ItemStack(StorageBlock,1,0));
	}
}
}