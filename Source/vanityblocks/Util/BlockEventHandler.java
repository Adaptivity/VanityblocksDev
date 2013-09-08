package vanityblocks.Util;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import vanityblocks.Blocks.BlockCurtain;
public class BlockEventHandler
{

	/**
	 * Stores face for onBlockClicked().
	 */
	public static int faceClicked;
	
	@ForgeSubscribe
	/**
	 * Used to store side clicked and also forces onBlockActivated
	 * event when entityPlayer is sneaking and activates block with the
	 * Carpenter's Hammer.
	 */
	public void playerInteractEvent(PlayerInteractEvent event)
	{
		int blockID = event.entity.worldObj.getBlockId(event.x, event.y, event.z);

		if (blockID > 0 && Block.blocksList[blockID] instanceof BlockCurtain)
		{
			BlockCurtain block = (BlockCurtain) Block.blocksList[blockID];

			if (event.action == PlayerInteractEvent.Action.LEFT_CLICK_BLOCK) {

				faceClicked = event.face;

			} 
		}
	}

}
