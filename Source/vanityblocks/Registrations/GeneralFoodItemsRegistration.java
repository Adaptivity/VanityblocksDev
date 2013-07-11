package vanityblocks.Registrations;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;
import vanityblocks.Storageprops;
import vanityblocks.Items.Mugitems.*;
//import vanityblocks.Items.Mugitems.emptymug;
//import vanityblocks.Items.ClayMugItem;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class GeneralFoodItemsRegistration
{
    public static Item unfiredmug;
    public static Item emptymug;
    public static Item mugwater;
    public static Item mugwaterhot;
    public static Item mugwaterchoco;
    public static Item mugwaterchocosugar;
    public static Item mugmilk;
    public static Item mugmilkhot;
    public static Item mugmilkchoco;
    public static Item mugmilkchocosugar;

    /*
     * To do: add recipes, make textures, finish item files
     */
    public static void generalitemregistration ()
    {
        if (Storageprops.enableclaymugstuff)
        {
            unfiredmug = new unfiredmug(Storageprops.mugunfired - 256).setUnlocalizedName("unfiremug");
            LanguageRegistry.addName(unfiredmug, "Unfired Mug");
            emptymug = new emptymug(Storageprops.emptymug - 256).setUnlocalizedName("emptymug");
            LanguageRegistry.addName(emptymug, "Empty Mug");
            mugwater = new mugwater(Storageprops.mugwater - 256, 0).setUnlocalizedName("mugwater");
            LanguageRegistry.addName(mugwater, "Mug with water");
            mugwaterhot = new mugwaterhot(Storageprops.mugwaterhot - 256, 0).setUnlocalizedName("mugwaterhot");
            LanguageRegistry.addName(mugwaterhot, "Mug with hot water");
            mugwaterchoco = new mugwaterchoco(Storageprops.mugwaterhotchoco - 256, 0).setUnlocalizedName("mugwaterchoco");
            LanguageRegistry.addName(mugwaterchoco, "Hot Chocolate with water");
            mugwaterchocosugar = new mugwaterchocosugar(Storageprops.mugwaterhotchocosugar - 256, 0).setUnlocalizedName("mugwaterchocosugar");
            LanguageRegistry.addName(mugwaterchocosugar, "Sweetend Hot Chocolate with water");
            mugmilk = new mugmilk(Storageprops.mugmilk - 256, 0).setUnlocalizedName("mugmilk");
            LanguageRegistry.addName(mugmilk, "Mug with milk");
            mugmilkhot = new mugmilk(Storageprops.mugmilkhot - 256, 0).setUnlocalizedName("mugmilkhot");
            LanguageRegistry.addName(mugmilkhot, "Mug with hot milk");
            mugmilkchoco = new mugmilkchoco(Storageprops.mugmilkhotchoco - 256, 0).setUnlocalizedName("mugmilkchoco");
            LanguageRegistry.addName(mugmilkchoco, "Hot Chocolate with milk");
            mugmilkchocosugar = new mugmilkchocosugar(Storageprops.mugmilkhotchocosugar - 256, 0).setUnlocalizedName("mugmilkchocosugar");
            LanguageRegistry.addName(mugmilkchocosugar, "Sweetend Hot Chocolate with milk");
        }
    }

    public static void additemrecipes ()
    {
        if (Storageprops.enableclaymugstuff)
        {
            //	GameRegistry.addRecipe(new ItemStack(claymugitem,0), "x x", " x ", 'x', new ItemStack(Item.clay,1));
            //    FurnaceRecipes.smelting().addSmelting(claymugitem.itemID, 0, new ItemStack(claymugitem, 1, 1), 0.0f); 
            //	GameRegistry.addShapelessRecipe(new ItemStack(bluerupee5), new ItemStack(greenrupee1), new ItemStack(greenrupee1), new ItemStack(greenrupee1), new ItemStack(greenrupee1), new ItemStack(greenrupee1));
        }
    }
}