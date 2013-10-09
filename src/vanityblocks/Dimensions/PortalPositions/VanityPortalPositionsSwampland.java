package vanityblocks.Dimensions.PortalPositions;

import vanityblocks.Dimensions.Teleporters.TeleporterVanitySwampland;
import net.minecraft.util.ChunkCoordinates;

public class VanityPortalPositionsSwampland extends ChunkCoordinates
{
    public long field_85087_d;

    final TeleporterVanitySwampland field_85088_e;

    public VanityPortalPositionsSwampland(TeleporterVanitySwampland par1Teleporter, int par2, int par3, int par4, long par5)
    {
        super(par2, par3, par4);
        this.field_85088_e = par1Teleporter;
        this.field_85087_d = par5;
    }
}
