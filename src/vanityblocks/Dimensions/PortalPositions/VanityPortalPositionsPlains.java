package vanityblocks.Dimensions.PortalPositions;

import vanityblocks.Dimensions.Teleporters.TeleporterVanityPlains;
import net.minecraft.util.ChunkCoordinates;

public class VanityPortalPositionsPlains extends ChunkCoordinates
{
    public long field_85087_d;

    final TeleporterVanityPlains field_85088_e;

    public VanityPortalPositionsPlains(TeleporterVanityPlains par1Teleporter, int par2, int par3, int par4, long par5)
    {
        super(par2, par3, par4);
        this.field_85088_e = par1Teleporter;
        this.field_85087_d = par5;
    }
}