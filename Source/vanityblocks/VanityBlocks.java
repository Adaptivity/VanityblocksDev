package vanityblocks;

import vanityblocks.FuelHandler.VanityForestryFuelHandler;
import vanityblocks.FuelHandler.VanitymodFuelHandler;
import vanityblocks.FuelHandler.VanityvanFuelHandler;
import vanityblocks.Registrations.GeneralFoodItemsRegistration;
import vanityblocks.Registrations.GeneralItemRegistration;
import vanityblocks.Registrations.Modbypass;
import vanityblocks.Registrations.RupeeRegistration;
import vanityblocks.Registrations.StorageBlocksRegistration;
import vanityblocks.Registrations.TEBlocksRegistration;
import vanityblocks.Registrations.VanityBlocksRegistration;
import vanityblocks.WorldGen.AVillageTrades;
import vanityblocks.WorldGen.MarbleGen;
import vanityblocks.WorldGen.VillageModHandler;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.liquids.LiquidDictionary;
import net.minecraftforge.liquids.LiquidStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.FMLLog;
//import railcraft.common.api.crafting.RailcraftCraftingManager;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
//import railcraft.common.api.core.items.ItemRegistry;
//import railcraft.common.api.crafting.ICokeOvenCraftingManager;
import cpw.mods.fml.common.registry.VillagerRegistry;

@Mod(modid = "VanityBlocks", name = "Anarchys Vanity Blocks", version = DefaultProps.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
/* 				
TO DO
Hold f3 and hit h for item id's
Villager that trades modded items
Vanity - Chiseled sandstone blocks, chairs? redstone lamps diff colored, curtains maybe?, inverted redstone lamps, colored sand/glass
ADD STONEHENGE!!!!!!!!!!
Item.doorWood.setMaxStackSize(16); - way to change stacksize of vannila
 */
public class VanityBlocks
{

    @Instance("VanityBlocks")
    public static VanityBlocks instance;
    public static final String modid = "VanityBlocks";

    @SidedProxy(clientSide = "vanityblocks.ProxyClient", serverSide = "vanityblocks.Proxy")
    public static Proxy proxy;

    @PreInit
    public void preInit (FMLPreInitializationEvent event)
    {
        Storageprops.initProps();
    }

    @Init
    public void load (FMLInitializationEvent event)
    {
        proxy.registerRenderInformation();
        proxy.addNames();
        /* ########### Storage Block Registration ######### */
        StorageBlocksRegistration.blockregistration();
        StorageBlocksRegistration.addVanillaRecipes();
        /* ####### Furnace melting Registration ### */
        FurnaceMelting.addFurnaceMelts();
        /* Vanity Block Registrations */
        VanityBlocksRegistration.vanityregistration();
        VanityBlocksRegistration.addVanityRecipes();
        /* ######## Tile Entity Registration ###### */
        TEBlocksRegistration.teregistration();
        TEBlocksRegistration.addTeRecipes();
        /* General Item Registrations */
        GeneralItemRegistration.generalitemregistration();
        GeneralItemRegistration.additemrecipes();
        /* General Foot Item Registrations */
        GeneralFoodItemsRegistration.generalitemregistration();
        GeneralFoodItemsRegistration.additemrecipes();
        /* Rupee Registration */
        if (Storageprops.enablerupees)
        {
            RupeeRegistration.rupeeregistration();
            RupeeRegistration.addrupeerecipes();
        }

        /* ######################## World Gen Registration ###### */
        GameRegistry.registerWorldGenerator(new MarbleGen(0));
        GameRegistry.registerFuelHandler(new VanityvanFuelHandler());
        /*
         * Removed code for time being.
         *GameRegistry.registerWorldGenerator(new UnderWaterRuinHandler()); //Registration of world gen for ruins(removed)
         *Dungeonlootspawning.chestHooks();
         *Villager/village Related
         *AVillageTrades trades = new AVillageTrades();
         *VillagerRegistry.instance().registerVillagerType(56789, "/mods/vanityblocks/textures/mob/villager.png");
         *VillagerRegistry.instance().registerVillageCreationHandler(new VillageModHandler());
         *VillagerRegistry.instance().registerVillageTradeHandler(56789, trades);
         */

        /*Creative tab related */
        LanguageRegistry.instance().addStringLocalization("itemGroup.vanityblocks", "en_US", "Anarchys Vanity Blocks");
    }

    public static CreativeTabs tabCustom = new CreativeTabs("vanityblocks")
    {
        public ItemStack getIconItemStack ()
        {
            return new ItemStack(vanityblocks.Registrations.VanityBlocksRegistration.VanityDesignblock, 1, 0);
        }
    };

    @PostInit
    public void postInit (FMLPostInitializationEvent event)
    {
        StorageBlocksRegistration.addModRecipes();
        StorageBlocksRegistration.addForestryRecipes();
        GameRegistry.registerFuelHandler(new VanityForestryFuelHandler());
        GameRegistry.registerFuelHandler(new VanitymodFuelHandler());
        /* Mod bypassing */
        if (Storageprops.enablegregtechbypass)
        {
            Modbypass.bypassrecipes();
            FMLLog.info("[VanityBlocks] Bypass recipes are enabled");
        }
        FMLLog.info("[VanityBlocks] Seems to have loaded well!");
    }
}
