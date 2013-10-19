package vanityblocks.Dimensions;

import java.io.DataInputStream;
import cpw.mods.fml.relauncher.Side;

public interface IAdvancedPacket
{
    public void handlePacket(DataInputStream stream, Object[] extradata, Side side);

    public byte getPacketID();
}