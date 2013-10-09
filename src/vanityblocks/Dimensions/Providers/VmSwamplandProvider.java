package vanityblocks.Dimensions.Providers;

import vanityblocks.Storageprops;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderEnd;
import net.minecraft.world.gen.ChunkProviderGenerate;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class VmSwamplandProvider extends WorldProvider
{
    public void registerWorldChunkManager ()
    {
        this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.swampland, 0.8F, 0.9F);
        this.dimensionId = Storageprops.vmswamplandid;
    }

    public IChunkProvider createChunkGenerator ()
    {
        return new ChunkProviderGenerate(this.worldObj, this.worldObj.getSeed(), true);
    }

    /**
     * True if the player can respawn in this dimension (true = overworld, false = nether).
     */
    @Override
    public boolean canRespawnHere ()
    {
        if (Storageprops.vmrespawn) {
            return true;
        }
        return false;
    }

    @Override
    public String getWelcomeMessage ()
    {
        return "Entering the VanityBlocks Mining Swampland Dimension";
    }

    @Override
    public String getDepartMessage ()
    {
        return "Leaving the VanityBlocks Mining Swampland Dimension";
    }

    @Override
    public String getDimensionName ()
    {
        return "VanityBlocks Mining Swampland Dimension";
    }
}