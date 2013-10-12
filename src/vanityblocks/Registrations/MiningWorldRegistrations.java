package vanityblocks.Registrations;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import vanityblocks.Storageprops;
import vanityblocks.Dimensions.BlockVanityPortal;
import vanityblocks.Dimensions.PortalStarter;
import vanityblocks.Dimensions.VanityPortalItemBlock;
import vanityblocks.Dimensions.VbMwManual;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class MiningWorldRegistrations
{
    public static BlockVanityPortal vanityportal;
    public static int vanityportalid;
    public static Item portalstarter;

    public static void registrations ()
    {
        vanityportalid = Storageprops.vanityportalID;
        vanityportal = (BlockVanityPortal) new BlockVanityPortal(vanityportalid);

        String[] vbportalnames = { "VB Plains Dimension Portal", "VB Desert Hills Dimension Portal", "VB Extreme Hills Dimension Portal", "VB Forest Dimension Portal", "VB Taiga Dimension Portal",
                "VB Swampland Dimension Portal", "VB Shroom Dimension Portal", "VB Jungle Dimension Portal", "VB Hell Dimension Portal", "", "", "", "", "", "", "" };
        /* ##### Registrys for the portal blocks ##### */
        GameRegistry.registerBlock(vanityportal, VanityPortalItemBlock.class, "Vanity Portal Blocks");
        LanguageRegistry.addName(new ItemStack(vanityportal, 1, 0), "VB Plains Dimension Portal ");
        LanguageRegistry.addName(new ItemStack(vanityportal, 1, 1), "VB Desert Hills Dimension Portal ");
        LanguageRegistry.addName(new ItemStack(vanityportal, 1, 2), "VB Extreme Hills Dimension Portal ");
        LanguageRegistry.addName(new ItemStack(vanityportal, 1, 3), "VB Forest Dimension Portal ");
        LanguageRegistry.addName(new ItemStack(vanityportal, 1, 4), "VB Taiga Dimension Portal ");
        LanguageRegistry.addName(new ItemStack(vanityportal, 1, 5), "VB Swampland Dimension Portal ");
        LanguageRegistry.addName(new ItemStack(vanityportal, 1, 6), "VB Shroom Dimension Portal ");
        LanguageRegistry.addName(new ItemStack(vanityportal, 1, 7), "VB Jungle Dimension Portal ");
        LanguageRegistry.addName(new ItemStack(vanityportal, 1, 8), "VB Hell Dimension Portal ");

        //        vanityportal = (BlockVanityPortal) new BlockVanityPortal(Storageprops.vanityportalID).setUnlocalizedName("VanityPortalBlock");
        //        GameRegistry.registerBlock(vanityportal, "vanityportal");
        //        LanguageRegistry.addName(vanityportal, "VanityBlocks Mining World Portal");

        portalstarter = new PortalStarter(Storageprops.portalstarterID - 256).setUnlocalizedName("PortalStarterItem");
        LanguageRegistry.addName(portalstarter, "VB Mining World Portal Lighter");
    }

    public static void addRecipes ()
    {
        //GameRegistry.addShapelessRecipe(VbMwManual.manual, portalstarter, Item.book);
        GameRegistry.addShapelessRecipe(VbMwManual.manual, new ItemStack(portalstarter, 1, Short.MAX_VALUE), Item.book);
        GameRegistry.addRecipe(new ItemStack(portalstarter), new Object[] { " y ", "xzx", "xzx", 'x', new ItemStack(Item.ingotIron), 'y', new ItemStack(Item.flintAndSteel), 'z',
                new ItemStack(Item.coal) });
    }

}
