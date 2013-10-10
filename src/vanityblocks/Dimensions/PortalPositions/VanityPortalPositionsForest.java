package vanityblocks.Dimensions.PortalPositions;

import vanityblocks.Dimensions.Teleporters.TeleporterVanityForest;
import net.minecraft.util.ChunkCoordinates;

public class VanityPortalPositionsForest extends ChunkCoordinates
{
    public long field_85087_d;

    final TeleporterVanityForest field_85088_e;

    public VanityPortalPositionsForest(TeleporterVanityForest par1Teleporter, int par2, int par3, int par4, long par5)
    {
        super(par2, par3, par4);
        this.field_85088_e = par1Teleporter;
        this.field_85087_d = par5;
    }
}