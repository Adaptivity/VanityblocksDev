package vanityblocks.Registrations;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import vanityblocks.ItemBlockMarbleSlab;
import vanityblocks.Marbleslab;
import vanityblocks.Storageprops;
import vanityblocks.VanityDesignblock;
import vanityblocks.VanityDesignworldblock;
import vanityblocks.VanitydesignItemBlock;
import vanityblocks.VanitydesignworldItemBlock;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class VanityBlocksRegistration {
	
	public static Block VanityDesignblock;
	public static int VanityDesignId;
	public static int VanityDesignworldId;
	public static Block VanityDesignworldblock;
	public static int VanityDesignworldslabId;
	public static Block VanityDesignworldslabblock;
	
	
	public static void vanityregistration() {
	VanityDesignId = Storageprops.vanitydesignconfig;
	VanityDesignblock = new VanityDesignblock(VanityDesignId);
	
	VanityDesignworldId = Storageprops.vanitydesignworldconfig;
	VanityDesignworldblock = new VanityDesignworldblock(VanityDesignworldId);
	
	VanityDesignworldslabId = Storageprops.vanitydesignworldslabconfig;
	VanityDesignworldslabblock = new Marbleslab(VanityDesignworldslabId);	
	String[] vanitydesignBlockNames = {
			"Lava Lamp"
	};		
	String [] vanitydesignWorldblockNames = {
			"Marble", "Marble Brick", "Chiseled Marble",
			"Ashford Black Marble", "Ashford Black Marble Brick", "Chiseled Ashford Black Marble"
	};
	/* ######### Block registration and naming for vanity #### */
	GameRegistry.registerBlock(VanityDesignblock, VanitydesignItemBlock.class, "Vanity Blocks Design blocks");
	LanguageRegistry.addName(new ItemStack(VanityDesignblock, 1, 0), "Lava Lamp");
	
	/* ######### Block registration and naming for world gen #### */
	GameRegistry.registerBlock(VanityDesignworldblock, VanitydesignworldItemBlock.class, "Vanity Blocks World blocks");
	LanguageRegistry.addName(new ItemStack(VanityDesignworldblock, 1, 0), "Marble");
	LanguageRegistry.addName(new ItemStack(VanityDesignworldblock, 1, 1), "Marble Brick");
	LanguageRegistry.addName(new ItemStack(VanityDesignworldblock, 1, 2), "Chiseled Marble");
	LanguageRegistry.addName(new ItemStack(VanityDesignworldblock, 1, 3), "Ashford Black Marble");
	LanguageRegistry.addName(new ItemStack(VanityDesignworldblock, 1, 4), "Ashford Black Marble Brick");
	LanguageRegistry.addName(new ItemStack(VanityDesignworldblock, 1, 5), "Chiseled Ashford Black Marble");
	
	
	/* ######################################### Block Registration of Slabs ############ */
	GameRegistry.registerBlock(VanityDesignworldslabblock, ItemBlockMarbleSlab.class, "Vanity Blocks World Block slabs");
	LanguageRegistry.addName(new ItemStack(VanityDesignworldslabblock, 1, 0), "Marble Slab");
	LanguageRegistry.addName(new ItemStack(VanityDesignworldslabblock, 1, 1), "Marble Brick Slab");
	LanguageRegistry.addName(new ItemStack(VanityDesignworldslabblock, 1, 2), "Chiseled Marble Slab");
	LanguageRegistry.addName(new ItemStack(VanityDesignworldslabblock, 1, 3), "Ashford Black Marble Slab");
	LanguageRegistry.addName(new ItemStack(VanityDesignworldslabblock, 1, 4), "Ashford Black Marble Brick Slab");
	LanguageRegistry.addName(new ItemStack(VanityDesignworldslabblock, 1, 5), "Chiseled Ashford Black Marble Slab");	
	}
	public static void addVanityRecipes() {
		//##### This is Vanity Block Recipes
		ItemStack glasspane = new ItemStack(Block.thinGlass);
		ItemStack lavabukkit = new ItemStack(Item.bucketLava);
        if (Storageprops.enablelavalamp) {
    	GameRegistry.addRecipe(new ItemStack(VanityDesignblock, 4, 0), "zxz", "xyx", "zxz", 'x', glasspane, 'y', lavabukkit , 'z', Block.stone);
        }
        //##### This is world gen recipes for marble/black marble
        if (Storageprops.generatemarble) {
        GameRegistry.addRecipe(new ItemStack(VanityDesignworldblock, 4, 1), "xx", "xx",  'x', new ItemStack(VanityDesignworldblock,0,0));
        GameRegistry.addShapelessRecipe(new ItemStack(VanityDesignworldblock, 1, 0), new ItemStack(VanityDesignworldblock,0,1));
        GameRegistry.addRecipe(new ItemStack(VanityDesignworldblock, 4, 2), "xx", "xx",  'x', new ItemStack(VanityDesignworldblock,0,1));
        }
        if (Storageprops.generateblackmarble) {
        GameRegistry.addRecipe(new ItemStack(VanityDesignworldblock, 4, 4), "xx", "xx",  'x', new ItemStack(VanityDesignworldblock,0,3));
        GameRegistry.addShapelessRecipe(new ItemStack(VanityDesignworldblock, 1, 3), new ItemStack(VanityDesignworldblock,0,4));
        GameRegistry.addRecipe(new ItemStack(VanityDesignworldblock, 4, 5), "xx", "xx",  'x', new ItemStack(VanityDesignworldblock,0,4));
        }
        
        /* Marble Slabs */
        if (Storageprops.generatemarble && Storageprops.generateblackmarble && Storageprops.marbleslabs)  {
        GameRegistry.addRecipe(new ItemStack(VanityDesignworldslabblock, 6, 0), "xxx",  'x', new ItemStack(VanityDesignworldblock,0,0));
        GameRegistry.addRecipe(new ItemStack(VanityDesignworldslabblock, 6, 1), "xxx",  'x', new ItemStack(VanityDesignworldblock,0,1));
        GameRegistry.addRecipe(new ItemStack(VanityDesignworldslabblock, 6, 2), "xxx",  'x', new ItemStack(VanityDesignworldblock,0,2));
        GameRegistry.addRecipe(new ItemStack(VanityDesignworldslabblock, 6, 3), "xxx",  'x', new ItemStack(VanityDesignworldblock,0,3));
        GameRegistry.addRecipe(new ItemStack(VanityDesignworldslabblock, 6, 4), "xxx",  'x', new ItemStack(VanityDesignworldblock,0,4));
        GameRegistry.addRecipe(new ItemStack(VanityDesignworldslabblock, 6, 5), "xxx",  'x', new ItemStack(VanityDesignworldblock,0,5));
        }
        /* This is Random Recipes */
    	if (Storageprops.arrowtofeather) {
		GameRegistry.addShapelessRecipe(new ItemStack(Item.feather,1), new ItemStack(Item.arrow,1));
    	}
    	if (Storageprops.fleshtoleather) {
    	GameRegistry.addSmelting(Item.rottenFlesh.itemID, new ItemStack(Item.leather, 1), 0.5F);
    	}
    	if (Storageprops.quartzblocktoquartz) {
    	GameRegistry.addShapelessRecipe(new ItemStack(Item.netherQuartz, 4), new ItemStack(Block.blockNetherQuartz));
    	}
    	if (Storageprops.greendye) {
            GameRegistry.addShapelessRecipe(new ItemStack(Item.dyePowder,1,2), new ItemStack(Item.dyePowder,1,4), new ItemStack(Item.dyePowder,1,11));
    	}
    	if (Storageprops.wooltostring) {
    		GameRegistry.addShapelessRecipe(new ItemStack(Item.silk,4), new ItemStack(Block.cloth, 1, Short.MAX_VALUE));
    		//Short.Maxvalue is required to use any meta in the block
    	}
    	if (Storageprops.magmacreamtoslime) {
    		GameRegistry.addShapelessRecipe(new ItemStack(Item.slimeBall,1),new ItemStack(Item.magmaCream,1));
    	}
	
	}

}
