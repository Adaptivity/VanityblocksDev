package vanityblocks.Dimensions;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
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

public class DimensionManagement
{
    String[] vbportalnames = { "VB Plains Dimension Portal", "VB Desert Hills Dimension Portal", "VB Extreme Hills Dimension Portal", "VB Forest Dimension Portal", "VB Taiga Dimension Portal",
            "VB Swampland Dimension Portal", "VB Shroom Dimension Portal", "VB Jungle Dimension Portal", "VB Hell Dimension Portal", "", "", "", "", "", "", "" };

    public static void registrations ()
    {
        MiningWorldRegistrations.registrations();
        MiningWorldRegistrations.addRecipes();
        //Registers the Plains Dimension
        if (Storageprops.vmenableplains)
        {
            DimensionManager.registerProviderType(Storageprops.vmplainsid, VmPlainsProvider.class, false);
            DimensionManager.registerDimension(Storageprops.vmplainsid, Storageprops.vmplainsid);
        }
        //Registers the Desert hills Dimensions
        if (Storageprops.vmenabledeserthills)
        {
            DimensionManager.registerProviderType(Storageprops.vmdeserthillsid, VmDesertHillsProvider.class, false);
            DimensionManager.registerDimension(Storageprops.vmdeserthillsid, Storageprops.vmdeserthillsid);
        }
        //Registers the Extremehills Dimension
        if (Storageprops.vmenableextremehills)
        {
            DimensionManager.registerProviderType(Storageprops.vmextremehillsid, VmExtremeHillsProvider.class, false);
            DimensionManager.registerDimension(Storageprops.vmextremehillsid, Storageprops.vmextremehillsid);
        }
        //Registers the Forest Dimension
        if (Storageprops.vmenableforest)
        {
            DimensionManager.registerProviderType(Storageprops.vmforestid, VmForestProvider.class, false);
            DimensionManager.registerDimension(Storageprops.vmforestid, Storageprops.vmforestid);
        }
        //Registers the Taiga Dimension
        if (Storageprops.vmenabletaiga)
        {
            DimensionManager.registerProviderType(Storageprops.vmtaigaid, VmTaigaProvider.class, false);
            DimensionManager.registerDimension(Storageprops.vmtaigaid, Storageprops.vmtaigaid);
        }
        //Registers the Swampland Dimension
        if (Storageprops.vmenableswampland)
        {
            DimensionManager.registerProviderType(Storageprops.vmswamplandid, VmSwamplandProvider.class, false);
            DimensionManager.registerDimension(Storageprops.vmswamplandid, Storageprops.vmswamplandid);
        }
        //Registers the Shroom Dimension
        if (Storageprops.vmenableshroom)
        {
            DimensionManager.registerProviderType(Storageprops.vmshroomislandid, VmShroomIslandProvider.class, false);
            DimensionManager.registerDimension(Storageprops.vmshroomislandid, Storageprops.vmshroomislandid);
        }
        //Registers the Jungle Dimension
        if (Storageprops.vmenablejungle)
        {
            DimensionManager.registerProviderType(Storageprops.vmjungleid, VmJungleProvider.class, false);
            DimensionManager.registerDimension(Storageprops.vmjungleid, Storageprops.vmjungleid);
        }
        //Registers the Hell Dimension
        if (Storageprops.vmenablehell)
        {
            DimensionManager.registerProviderType(Storageprops.vmhellid, VmHellProvider.class, false);
            DimensionManager.registerDimension(Storageprops.vmhellid, Storageprops.vmhellid);
        }
        LanguageRegistry.instance().addStringLocalization("itemGroup.vanityblocksdimensions", "en_US", "AnarchySage's VB Dimensions");
    }

    public static CreativeTabs tabDimensions = new CreativeTabs("vanityblocksdimensions")
    {
        public ItemStack getIconItemStack ()
        {
            return new ItemStack(vanityblocks.Registrations.MiningWorldRegistrations.portalstarter);
        }
    };
}
