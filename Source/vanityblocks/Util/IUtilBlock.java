package vanityblocks.Util;

import vanityblocks.tileentitys.TileCurtain;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IUtilBlock
{

	/**
	 * Provides block-specific onBlockClicked events.
	 */
	void auxiliaryOnBlockClicked(TileCurtain TE, World world, int x, int y, int z, EntityPlayer entityPlayer);
	
	/**
	 * Provides block-specific onBlockPlacedBy events.
	 */
	void auxiliaryOnBlockPlacedBy(TileCurtain TE, World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack itemStack);
	
	/**
	 * Provides block-specific onBlockActivated events.
	 */
	boolean auxiliaryOnBlockActivated(TileCurtain TE, World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX, float hitY, float hitZ);

	/**
	 * Provides block-specific breakBlock events.
	 */
	void auxiliaryBreakBlock(TileCurtain TE, World world, int x, int y, int z, int var5, int var6);

	/**
	 * Controls block behavior when clicking with the Carpenter's Chisel.
	 * Will return pattern.
	 */
	int onChiselClick(TileCurtain TE, int pattern, int side, boolean leftClick);
	
	/**
	 * Controls block behavior when left clicking with the Carpenter's Hammer.
	 * Will return data.
	 */
	int onHammerLeftClick(TileCurtain TE, EntityPlayer entityPlayer, int data);

	/**
	 * Controls block behavior when right clicking with the Carpenter's Hammer.
	 * Will return data.
	 */
	int onHammerRightClick(TileCurtain TE, EntityPlayer entityPlayer, int data, int side);
	
    /**
     * Returns whether block can support cover on side.
     */
    boolean canCoverSide(TileCurtain TE, World world, int x, int y, int z, int side);
	
}
