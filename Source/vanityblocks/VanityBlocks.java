package vanityblocks;

import vanityblocks.FuelHandler.VanityForestryFuelHandler;
import vanityblocks.FuelHandler.VanitymodFuelHandler;
import vanityblocks.FuelHandler.VanityvanFuelHandler;
import vanityblocks.Registrations.GeneralFoodItemsRegistration;
import vanityblocks.Registrations.GeneralItemRegistration;
import vanityblocks.Registrations.RupeeRegistration;
import vanityblocks.Registrations.StorageBlocksRegistration;
import vanityblocks.Registrations.TEBlocksRegistration;
import vanityblocks.Registrations.VanityBlocksRegistration;
import vanityblocks.WorldGen.AVillageTrades;
import vanityblocks.WorldGen.MarbleGen;
import vanityblocks.WorldGen.UnderWaterRuinHandler;
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
add mossy planks
Hold f3 and hit h for item id's
user suggestion
make fish block, maybe smooth version of end stone-vanity,double stone slab crafting - vanity
liquid water thats colored -waiting on forge api for it
maybe- potatoe, carrot, seeds, clay block 9x clayballs
Villager that trades modded items
Vanity - Chiseled sandstone blocks, chairs? redstone lamps diff colored, curtains maybe?, inverted redstone lamps, colored sand/glass
spling wants enchant for bow that teleports the mob, and potion of swimming,  ..SubSide.. Anarchy, you could make it that only if they are in water, they get a speed potion boost.
To add info to the bottom of blocks = https://github.com/mDiyo/Natura/blob/master/mods/natura/blocks/CloudItem.java
ADD STONEHENGE!!!!!!!!!!
!!!!!!!!



Item.doorWood.setMaxStackSize(16); - way to change stacksize of vannila
 */
public class VanityBlocks
{

    @Instance("VanityBlocks")
    public static VanityBlocks instance;
    public static final String modid = "VanityBlocks";

    @SidedProxy(clientSide = "vanityblocks.ProxyClient", serverSide = "vanityblocks.Proxy")
    public static Proxy proxy;

    /*	public static int storageblockconfig;
    	public static int storageblockmodconfig;
    	public static boolean storageblockint;
    	public static Block StorageBlock;
    	public static Block StorageBlockMod;
    	public static Block ForestryBlock;
    	public static int StorageBlockId;
    	public static int StorageBlockModId;
    	public static int ForestryBlockId; */

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
        GameRegistry.registerWorldGenerator(new UnderWaterRuinHandler());
        GameRegistry.registerFuelHandler(new VanityvanFuelHandler());
        //		Dungeonlootspawning.chestHooks();
        // ### Villager/village Related
        //		AVillageTrades trades = new AVillageTrades();
        //		VillagerRegistry.instance().registerVillagerType(56789, "/mods/vanityblocks/textures/mob/villager.png");
        //        VillagerRegistry.instance().registerVillageCreationHandler(new VillageModHandler());
        //        VillagerRegistry.instance().registerVillageTradeHandler(56789, trades);
        //###Creative tab related
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
        //		Dungeonlootspawning.chestHooks();
        GameRegistry.registerFuelHandler(new VanityForestryFuelHandler());
        //		GameRegistry.registerFuelHandler(new VanitymodFuelHandler());
        FMLLog.info("Vanity Blocks seems to have loaded well.!");
    }
}
