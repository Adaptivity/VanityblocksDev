package vanityblocks.Dimensions.PortalPositions;

import net.minecraft.util.ChunkCoordinates;
import vanityblocks.Dimensions.Teleporters.TeleporterVanityHell;

public class VanityPortalPositionsHell extends ChunkCoordinates
{
    public long field_85087_d;

    final TeleporterVanityHell field_85088_e;

    public VanityPortalPositionsHell(TeleporterVanityHell par1Teleporter, int par2, int par3, int par4, long par5)
    {
        super(par2, par3, par4);
        this.field_85088_e = par1Teleporter;
        this.field_85087_d = par5;
    }
}