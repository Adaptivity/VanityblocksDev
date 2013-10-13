package vanityblocks.Dimensions;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import vanityblocks.Storageprops;
import vanityblocks.Dimensions.Providers.VmDesertHillsProvider;
import vanityblocks.Dimensions.Providers.VmExtremeHillsProvider;
import vanityblocks.Dimensions.Providers.VmForestProvider;
import vanityblocks.Dimensions.Providers.VmHellProvider;
import vanityblocks.Dimensions.Providers.VmJungleProvider;
import vanityblocks.Dimensions.Providers.VmPlainsProvider;
import vanityblocks.Dimensions.Providers.VmShroomIslandProvider;
import vanityblocks.Dimensions.Providers.VmSwamplandProvider;
import vanityblocks.Dimensions.Providers.VmTaigaProvider;
import vanityblocks.Registrations.MiningWorldRegistrations;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class DimensionManagement
{
    String[] vbportalnames = { "VB Plains Dimension Portal", "VB Desert Hills Dimension Portal", "VB Extreme Hills Dimension Portal", "VB Forest Dimension Portal", "VB Taiga Dimension Portal",
            "VB Swampland Dimension Portal", "VB Shroom Dimension Portal", "VB Jungle Dimension Portal", "VB Hell Dimension Portal", "", "", "", "", "", "", "" };

    public static void registrations ()
    {
        MiningWorldRegistrations.registrations();
        MiningWorldRegistrations.addRecipes();
        LanguageRegistry.instance().addStringLocalization("itemGroup.vanityblocksdimensions", "en_US", "AnarchySage's VB Dimensions");
    }

    public static void dimensionregistration ()
    {
        //Registers the Plains Dimension
        if (Storageprops.vmenableplains)
        {
            DimensionManager.registerDimension(Storageprops.vmplainsid, Storageprops.vmplainsid);
        }
        //Registers the Desert hills Dimensions
        if (Storageprops.vmenabledeserthills)
        {
            DimensionManager.registerDimension(Storageprops.vmdeserthillsid, Storageprops.vmdeserthillsid);
        }
        //Registers the Extremehills Dimension
        if (Storageprops.vmenableextremehills)
        {
            DimensionManager.registerDimension(Storageprops.vmextremehillsid, Storageprops.vmextremehillsid);
        }
        //Registers the Forest Dimension
        if (Storageprops.vmenableforest)
        {
            DimensionManager.registerDimension(Storageprops.vmforestid, Storageprops.vmforestid);
        }
        //Registers the Taiga Dimension
        if (Storageprops.vmenabletaiga)
        {
            DimensionManager.registerDimension(Storageprops.vmtaigaid, Storageprops.vmtaigaid);
        }
        //Registers the Swampland Dimension
        if (Storageprops.vmenableswampland)
        {
            DimensionManager.registerDimension(Storageprops.vmswamplandid, Storageprops.vmswamplandid);
        }
        //Registers the Shroom Dimension
        if (Storageprops.vmenableshroom)
        {
            DimensionManager.registerDimension(Storageprops.vmshroomislandid, Storageprops.vmshroomislandid);
        }
        //Registers the Jungle Dimension
        if (Storageprops.vmenablejungle)
        {
            DimensionManager.registerDimension(Storageprops.vmjungleid, Storageprops.vmjungleid);
        }
        //Registers the Hell Dimension
        if (Storageprops.vmenablehell)
        {
            DimensionManager.registerDimension(Storageprops.vmhellid, Storageprops.vmhellid);
        }
    }

    public static void providerregistrations ()
    {
        if (Storageprops.vmenableplains)
        {
            DimensionManager.registerProviderType(Storageprops.vmplainsid, VmPlainsProvider.class, false);
        }
        //Registers the Desert hills Dimensions
        if (Storageprops.vmenabledeserthills)
        {
            DimensionManager.registerProviderType(Storageprops.vmdeserthillsid, VmDesertHillsProvider.class, false);
        }
        //Registers the Extremehills Dimension
        if (Storageprops.vmenableextremehills)
        {
            DimensionManager.registerProviderType(Storageprops.vmextremehillsid, VmExtremeHillsProvider.class, false);
        }
        //Registers the Forest Dimension
        if (Storageprops.vmenableforest)
        {
            DimensionManager.registerProviderType(Storageprops.vmforestid, VmForestProvider.class, false);
        }
        //Registers the Taiga Dimension
        if (Storageprops.vmenabletaiga)
        {
            DimensionManager.registerProviderType(Storageprops.vmtaigaid, VmTaigaProvider.class, false);
        }
        //Registers the Swampland Dimension
        if (Storageprops.vmenableswampland)
        {
            DimensionManager.registerProviderType(Storageprops.vmswamplandid, VmSwamplandProvider.class, false);
        }
        //Registers the Shroom Dimension
        if (Storageprops.vmenableshroom)
        {
            DimensionManager.registerProviderType(Storageprops.vmshroomislandid, VmShroomIslandProvider.class, false);
        }
        //Registers the Jungle Dimension
        if (Storageprops.vmenablejungle)
        {
            DimensionManager.registerProviderType(Storageprops.vmjungleid, VmJungleProvider.class, false);
        }
        //Registers the Hell Dimension
        if (Storageprops.vmenablehell)
        {
            DimensionManager.registerProviderType(Storageprops.vmhellid, VmHellProvider.class, false);
        }
    }

    public static CreativeTabs tabDimensions = new CreativeTabs("vanityblocksdimensions")
    {
        public ItemStack getIconItemStack ()
        {
            return new ItemStack(vanityblocks.Registrations.MiningWorldRegistrations.portalstarter);
        }
    };
}
