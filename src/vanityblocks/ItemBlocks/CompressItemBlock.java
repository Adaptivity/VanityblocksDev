package vanityblocks.ItemBlocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class CompressItemBlock extends ItemBlock {

	private final static String[] subNames = { "9X Compressed CobblesStone", "81X Compressed CobblesStone",
			"729X Compressed CobblesStone", "", "",
			"", "", "", "", "",
			"", "", "", "", "", "" };

	public CompressItemBlock(int id) {
		super(id);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int i) {
		return i;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		return subNames[itemstack.getItemDamage()];
	}
}