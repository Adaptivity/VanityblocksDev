package vanityblocks.Dimensions.Providers;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;
import vanityblocks.Storageprops;

public class VmDesertHillsProvider extends WorldProvider
{

    public void registerWorldChunkManager ()
    {
        this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.desertHills, 2.0F, 0.0F);
        this.dimensionId = Storageprops.vmdeserthillsid;
    }

    public IChunkProvider createChunkGenerator ()
    {
        return new ChunkProviderGenerate(this.worldObj, this.worldObj.getSeed(), true);
    }

    @Override
    public String getSaveFolder ()
    {
        return (dimensionId == 0 ? null : "VBDesHills");
    }

    @Override
    public void setAllowedSpawnTypes (boolean allowHostile, boolean allowPeaceful)
    {
        if (Storageprops.vmpassive)
        {
            allowPeaceful = true;
        }
        if (Storageprops.vmhostile)
        {
            allowHostile = true;
        }
    }

    /**
     * True if the player can respawn in this dimension (true = overworld, false = nether).
     */
    @Override
    public boolean canRespawnHere ()
    {
        if (Storageprops.vmrespawn)
        {
            return true;
        }
        return false;
    }

    @Override
    public String getWelcomeMessage ()
    {
        return "Entering the VanityBlocks Mining Desert Hills Dimension";
    }

    @Override
    public String getDepartMessage ()
    {
        return "Leaving the VanityBlocks Mining Desert Hills Dimension";
    }

    @Override
    public String getDimensionName ()
    {
        return "VanityBlocks Mining Desert Hills Dimension";
    }
}