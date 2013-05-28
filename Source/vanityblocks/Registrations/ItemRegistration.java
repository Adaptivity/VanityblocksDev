package vanityblocks.Registrations;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import vanityblocks.ForestryBlock;
import vanityblocks.StorageBlock;
import vanityblocks.StorageBlockMod;
import vanityblocks.Storageprops;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemRegistration {
public static void itemregistration() {
	if (Storageprops.enablerupees) {
/*##### Items ##### */
//	GameRegistry.registerBlock(StorageBlock, vanityblocks.StorageItemBlock.class, "Vannila Storage Block");
//	LanguageRegistry.addName(new ItemStack(StorageBlock, 1, 0), "Charcoal block");
	GameRegistry.registerItem(greenrupee1, "greenrupee");
	LanguageRegistry.addName(greenrupee1, "Green Rupee - 1 Rupee");
    }
}
	/*
	 *         greenrupee1 = config.getItem(items, "Green Rupee - 1 Rupees", 19000).getInt(19000);
        bluerupee5 = config.getItem(items, "Blue Rupee - 5 Rupees", 19001).getInt(19001);
        redrupee20 = config.getItem(items, "Red Rupee - 20 Rupees", 19002).getInt(19002);
        biggreenrupee50 = config.getItem(items, "Big Green Rupee - 50 Rupees", 19003).getInt(19003);
        bigbluerupee100 = config.getItem(items, "Big Blue Rupee - 100 Rupees", 19004).getInt(19004);
        bigredrupee200 = config.getItem(items, "Big Red Rupee - 200 Rupees", 19005).getInt(19005);
	 */
	public static void addrupeerecipes() {
	
	if (Storageprops.enablerupees) {
		
		
//	GameRegistry.addRecipe(new ItemStack(StorageBlock, 1, 0), "xxx", "xxx", "xxx", 'x', new ItemStack(Item.coal,1,1));
//	GameRegistry.addShapelessRecipe(new ItemStack(Item.coal, 9, 1), new ItemStack(StorageBlock,1,0));
	}
}
public static Item greenrupee1;
public static Item bluerupee5;
public static Item redrupee20;
public static Item biggreenrupee50;
public static Item bigbluerupee100;
public static Item bigredrupee200;	
}