package vanityblocks.tileentitys;

import vanityblocks.Blocks.VanityRandomBlocks;
import vanityblocks.ItemBlocks.CurtainItemBlock;
import vanityblocks.Registrations.CurtainRegistrations;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TileCurtain extends TileEntity
{
	public byte curtainDyeColor = -1;
	public byte curtainSpecialColor = -1;
	public short curtainCover = (short) CurtainRegistrations.CurtainBlock.blockID;
	public byte curtainCoverMetadata = 0;
//	public short curtainSoil = 0;
//	public byte curtainSoilMetadata = 0;
//	public short curtainPlant = 0;
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);		
		curtainDyeColor = nbt.getByte("curtainDyeColor");
		curtainSpecialColor = nbt.getByte("curtainSpecialColor");
		curtainCover = nbt.getShort("curtainCover");
		curtainCoverMetadata = nbt.getByte("curtainCoverMetadata");
//		curtainSoil = nbt.getShort("curtainSoil");
//		curtainSoilMetadata = nbt.getByte("curtainSoilMetadata");
//		curtainPlant = nbt.getShort("curtainPlant");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		nbt.setByte("curtainDyeColor", curtainDyeColor);
		nbt.setByte("curtainSpecialColor", curtainSpecialColor);
		nbt.setShort("curtainCover", curtainCover);
		nbt.setByte("curtainCoverMetadata", curtainCoverMetadata);
//		nbt.setShort("curtainSoil", curtainSoil);
//		nbt.setByte("curtainSoilMetadata", curtainSoilMetadata);
//		nbt.setShort("curtainPlant", curtainPlant);
	}
	
    /**
     * Overridden in a sign to provide the text.
     */
    @Override
	public Packet getDescriptionPacket()
    {    	
        NBTTagCompound nbt = new NBTTagCompound();
        this.writeToNBT(nbt);
        return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, nbt);
    }
    
    /**
     * Called when you receive a TileEntityData packet for the location this
     * TileEntity is currently in. On the client, the NetworkManager will always
     * be the remote server. On the server, it will be whomever is responsible for 
     * sending the packet.
     * 
     * @param net The NetworkManager the packet originated from 
     * @param pkt The data packet
     */
    @Override
	public void onDataPacket(INetworkManager net, Packet132TileEntityData pkt)
    {
    	readFromNBT(pkt.customParam1);

		if (this.worldObj.isRemote)
		{
			Minecraft.getMinecraft().renderGlobal.markBlockForRenderUpdate(this.xCoord, this.yCoord, this.zCoord);
			this.worldObj.updateAllLightTypes(this.xCoord, this.yCoord, this.zCoord);
		}
    }
}
