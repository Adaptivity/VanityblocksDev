package vanityblocks.Dimensions;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Collection;
import java.util.Iterator;

import vanityblocks.VanityBlocks;
import vanityblocks.VbLog;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.relauncher.Side;

public class PacketDimensionList implements IAdvancedPacket
{
    public static byte packetID = 0;
	public static Object registeredPlanets;

    public static Packet buildDimensionListPacket(Collection<?> col)
    {
        final Packet250CustomPayload packet = new Packet250CustomPayload();
        packet.channel = "VBPackets";

        final ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        final DataOutputStream data = new DataOutputStream(bytes);

        try
        {
            data.writeInt(PacketDimensionList.packetID);
            data.writeInt(col.size());
            final Iterator<?> var3 = col.iterator();

            while (var3.hasNext())
            {
                final Integer var4 = (Integer) var3.next();
                VbLog.info("Registering remote dimension: " + var4);
                data.writeInt(var4.intValue());
            }

            packet.data = bytes.toByteArray();
            packet.length = packet.data.length;

            data.close();
            bytes.close();
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }

        return packet;
    }

    @Override
    public void handlePacket(DataInputStream stream, Object[] extradata, Side side)
    {
    }

    @Override
    public byte getPacketID()
    {
        return PacketDimensionList.packetID;
    }
}