package vanityblocks.Dimensions.Providers;

import java.util.Random;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;
import vanityblocks.Storageprops;

public class VmPlainsProvider extends WorldProvider
{
    public void registerWorldChunkManager ()
    {
        this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.plains, 0.8F, 0.1F);
        this.dimensionId = Storageprops.vmplainsid;
    }

    public IChunkProvider createChunkGenerator ()
    {
        return new ChunkProviderGenerate(this.worldObj, this.worldObj.getSeed(), true);
    }

    @Override
    public boolean canDoLightning (Chunk chunk)
    {
        return true;
    }

    @Override
    public boolean canDoRainSnowIce (Chunk chunk)
    {
        return true;
    }

    @Override
    public String getSaveFolder ()
    {
        return (dimensionId == 0 ? null : "VBPlains");
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
        return "Entering the VanityBlocks Mining Plains Dimension";
    }

    @Override
    public String getDepartMessage ()
    {
        return "Leaving the VanityBlocks Mining Plains Dimension";
    }

    @Override
    public String getDimensionName ()
    {
        return "VanityBlocks Mining Plains Dimension";
    }
}