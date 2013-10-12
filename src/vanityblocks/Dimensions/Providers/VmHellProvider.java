package vanityblocks.Dimensions.Providers;

import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderHell;
import vanityblocks.Storageprops;

public class VmHellProvider extends WorldProviderHell
{
    public void registerWorldChunkManager ()
    {
        this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.hell, 2.0F, 0.0F);
        this.isHellWorld = true;
        this.hasNoSky = true;
        this.dimensionId = Storageprops.vmhellid;
    }

    public IChunkProvider createChunkGenerator ()
    {
        return new ChunkProviderHell(this.worldObj, this.worldObj.getSeed());
    }

    @Override
    public String getSaveFolder ()
    {
        return (dimensionId == 0 ? null : "VBHell");
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
        return "Entering the VanityBlocks Mining Hell Dimension";
    }

    @Override
    public String getDepartMessage ()
    {
        return "Leaving the VanityBlocks Mining Hell Dimension";
    }

    @Override
    public String getDimensionName ()
    {
        return "VanityBlocks Mining Hell Dimension";
    }
}