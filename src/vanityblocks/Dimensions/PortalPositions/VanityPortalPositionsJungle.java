package vanityblocks.Dimensions.PortalPositions;

import net.minecraft.util.ChunkCoordinates;
import vanityblocks.Dimensions.Teleporters.TeleporterVanityJungle;

public class VanityPortalPositionsJungle extends ChunkCoordinates
{
    public long field_85087_d;

    final TeleporterVanityJungle field_85088_e;

    public VanityPortalPositionsJungle(TeleporterVanityJungle par1Teleporter, int par2, int par3, int par4, long par5)
    {
        super(par2, par3, par4);
        this.field_85088_e = par1Teleporter;
        this.field_85087_d = par5;
    }
}