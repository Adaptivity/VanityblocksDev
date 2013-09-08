package vanityblocks.Util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.BlockPane;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import vanityblocks.tileentitys.TileCurtain;

public class BlockProperties
{

	/**
	 * Suppresses block updates.
	 */
	private static boolean suppressBlockUpdates = false;
	
	/**
	 * Ejects an item at given coordinates.
	 */
	private static void ejectEntity(TileCurtain TE, ItemStack itemStack)
	{
		if (!TE.worldObj.isRemote)
		{
			float offset = 0.7F;
			double rand1 = TE.worldObj.rand.nextFloat() * offset + (1.0F - offset) * 0.5D;
			double rand2 = TE.worldObj.rand.nextFloat() * offset + (1.0F - offset) * 0.2D + 0.6D;
			double rand3 = TE.worldObj.rand.nextFloat() * offset + (1.0F - offset) * 0.5D;

			EntityItem entityEjectedItem = new EntityItem(TE.worldObj, TE.xCoord + rand1, TE.yCoord + rand2, TE.zCoord + rand3, itemStack);

			entityEjectedItem.delayBeforeCanPickup = 10;
			TE.worldObj.spawnEntityInWorld(entityEjectedItem);
		}
	}
	
	/**
	 * Converts byte to unsigned integer.
	 */
	public static int unsignedToBytes(byte value)
	{
	    return value & 0xff;
	}
	
	/**
	 * Plays block placement sound when set as a cover.
	 */
	private static void playBlockPlacementSound(TileCurtain TE, int blockID)
	{
		if (!TE.worldObj.isRemote && blockID > 0)
		{
			Block block = Block.blocksList[blockID];
			TE.worldObj.playSoundEffect(TE.xCoord + 0.5F, TE.yCoord + 0.5F, TE.zCoord + 0.5F, block.stepSound.getPlaceSound(), block.stepSound.getVolume() + 1.0F / 2.0F, block.stepSound.getPitch() * 0.8F);
		}
	}
	
	/**
	 * Strips side of all properties.
	 */
	public final static void clearAttributes(TileCurtain TE, int side)
	{
		suppressBlockUpdates = true;
		
		setDyeColor(TE, side, DyeColorHandler.NO_COLOR);
		setOverlay(TE, side, (ItemStack)null);
		setCover(TE, side, (ItemStack)null);
		setPattern(TE, side, 0);
		
		suppressBlockUpdates = false;
		
		TE.worldObj.markBlockForUpdate(TE.xCoord, TE.yCoord, TE.zCoord);
	}
				
	/**
	 * Returns cover block ID.
	 */
	public final static int getCoverID(TileCurtain TE, int side)
	{
		return TE.cover[side] & 0xfff;
	}
	
	/**
	 * Returns cover block metadata.
	 */
	public final static int getCoverMetadata(TileCurtain TE, int side)
	{
		return (TE.cover[side] & 0xf000) >>> 12;
	}
	
	/**
	 * Returns whether block has a cover.
	 * Checks if block ID exists and whether it is a valid cover block.
	 */
	public final static boolean hasCover(TileCurtain TE, int side)
	{
		int coverID = getCoverID(TE, side);
		int metadata = getCoverMetadata(TE, side);

		return	coverID > 0 &&
				Block.blocksList[coverID] != null &&
				isCover(new ItemStack(coverID, 1, metadata));
	}
	
	/**
	 * Returns whether block has side covers.
	 */
	public final static boolean hasSideCovers(TileCurtain TE)
	{
		for (int side = 0; side < 6; ++side)
			if (hasCover(TE, side))
				return true;
		
		return false;
	}
	
	/**
	 * Returns cover block.
	 */
	public final static Block getCoverBlock(IBlockAccess blockAccess, int side, int x, int y, int z)
	{
		TileCurtain TE = (TileCurtain) blockAccess.getBlockTileEntity(x, y, z);
		
		return getCoverBlock(TE, side);
	}
	
	/**
	 * Returns cover block.
	 */
	public final static Block getCoverBlock(TileCurtain TE, int side)
	{
		Block coverBlock;
		
		if (hasCover(TE, side))
			coverBlock = Block.blocksList[getCoverID(TE, side)];
		else
			coverBlock = Block.blocksList[TE.worldObj.getBlockId(TE.xCoord, TE.yCoord, TE.zCoord)];
		
		return coverBlock;
	}
		
	/**
	 * Returns whether block is a cover.
	 */
	public final static boolean isCover(ItemStack itemStack)
	{
		if (itemStack.getItem() instanceof ItemBlock && !isOverlay(itemStack))
		{
			Block block = Block.blocksList[itemStack.getItem().itemID];
			
			return	!block.hasTileEntity(itemStack.getItemDamage()) &&
					(
						block.renderAsNormalBlock() ||
						block instanceof BlockHalfSlab ||
						block instanceof BlockPane ||
						block instanceof BlockBreakable
					);
		}

		return false;
	}

	/**
	 * Sets cover block.
	 */
	public final static void setCover(TileCurtain TE, int side, ItemStack itemStack)
	{		
		if (hasCover(TE, side))
			ejectEntity(TE, new ItemStack(getCoverID(TE, side), 1, getCoverMetadata(TE, side)));
		
		int blockID = itemStack == null ? 0 : itemStack.itemID;
		int metadata = itemStack == null ? 0 : itemStack.getItemDamage();
		
		if (itemStack != null)
			playBlockPlacementSound(TE, blockID);

		TE.cover[side] = (short) (blockID + (metadata << 12));
		
		if (!suppressBlockUpdates)
			TE.worldObj.markBlockForUpdate(TE.xCoord, TE.yCoord, TE.zCoord);
		
		TE.worldObj.notifyBlocksOfNeighborChange(TE.xCoord, TE.yCoord, TE.zCoord, blockID);

	}
	
	/**
	 * Get block data.
	 */
	public final static int getData(TileCurtain TE)
	{
		return TE.data;
	}
	
	/**
	 * Set block data.
	 */
	public static void setData(TileCurtain TE, int data)
	{
		/*
		 * No need to update if data hasn't changed.
		 */
		if (data != getData(TE))
		{
			TE.data = (short) data;
			
			if (!suppressBlockUpdates)
				TE.worldObj.markBlockForUpdate(TE.xCoord, TE.yCoord, TE.zCoord);
		}
	}
	
	/**
	 * Returns whether side has cover.
	 */
	public static boolean hasDyeColor(TileCurtain TE, int side)
	{
		return TE.color[side] > 0;
	}
	
	/**
	 * Sets color for side.
	 */
	public static void setDyeColor(TileCurtain TE, int side, int metadata)
	{
		if (TE.color[side] > 0)
			ejectEntity(TE, new ItemStack(Item.dyePowder, 1, (15 - TE.color[side])));
		
		TE.color[side] = (byte) metadata;
		
		if (!suppressBlockUpdates)
			TE.worldObj.markBlockForUpdate(TE.xCoord, TE.yCoord, TE.zCoord);
	}
	
	/**
	 * Returns dye color for side.
	 */
	public static int getDyeColor(TileCurtain TE, int side)
	{
		return TE.color[side];
	}
	
	/**
	 * Sets overlay.
	 */
	public static void setOverlay(TileCurtain TE, int side, ItemStack itemStack)
	{
		if (hasOverlay(TE, side))
			ejectEntity(TE, OverlayHandler.getItemStack(TE.overlay[side]));

		TE.overlay[side] = (byte) OverlayHandler.getKey(itemStack);
		
		if (!suppressBlockUpdates)
			TE.worldObj.markBlockForUpdate(TE.xCoord, TE.yCoord, TE.zCoord);
	}
	
	/**
	 * Returns overlay.
	 */
	public static int getOverlay(TileCurtain TE, int side)
	{
		return TE.overlay[side];
	}
	
	/**
	 * Returns whether block has overlay.
	 */
	public static boolean hasOverlay(TileCurtain TE, int side)
	{
		return TE.overlay[side] > 0;
	}
	
	/**
	 * Returns whether ItemStack contains a valid overlay item or block.
	 */
	public static boolean isOverlay(ItemStack itemStack)
	{
		return OverlayHandler.overlayMap.containsValue(itemStack.itemID);
	}
	
	/**
	 * Returns whether block has pattern.
	 */
	public static boolean hasPattern(TileCurtain TE, int side)
	{
		return getPattern(TE, side) > 0;
	}
	
	/**
	 * Returns pattern.
	 */
	public static int getPattern(TileCurtain TE, int side)
	{
		return unsignedToBytes(TE.pattern[side]);
	}
	
	/**
	 * Sets pattern.
	 */
	public static void setPattern(TileCurtain TE, int side, int pattern)
	{
		TE.pattern[side] = (byte) pattern;
		
		if (!suppressBlockUpdates)
			TE.worldObj.markBlockForUpdate(TE.xCoord, TE.yCoord, TE.zCoord);
	}
	
    /**
     * Returns whether side should render based on cover blocks
     * of both source and adjacent block.
     */
    public static boolean shouldRenderSharedFaceBasedOnCovers(TileCurtain TE_adj, TileCurtain TE_src)
    {
		Block block_adj= BlockProperties.getCoverBlock(TE_adj, 6);
		Block block_src = BlockProperties.getCoverBlock(TE_src, 6);
    	
		if (!BlockProperties.hasCover(TE_adj, 6)) {
			return BlockProperties.hasCover(TE_src, 6);
		} else {
			if (!BlockProperties.hasCover(TE_src, 6) && block_adj.getRenderBlockPass() == 0)
				return !block_adj.isOpaqueCube();
			else if (BlockProperties.hasCover(TE_src, 6) && block_src.isOpaqueCube() == block_adj.isOpaqueCube() && block_src.getRenderBlockPass() == block_adj.getRenderBlockPass())
				return false;
			else
				return true;
		}
    }
		
}
