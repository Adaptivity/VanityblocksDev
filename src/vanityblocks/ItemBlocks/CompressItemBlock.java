package vanityblocks.ItemBlocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class CompressItemBlock extends ItemBlock {

	private final static String[] subNames = { "9X Compressed CobblesStone", "81X Compressed CobblesStone",
			"729X Compressed CobblesStone", "9X Compressed Dirt", "81X Compressed Dirt",
			"729X Compressed Dirt", "9X Compressed Sand", "81X Compressed Sand", "729X Compressed Sand", "9X Compressed Gravel",
			"81X Compressed Gravel", "729X Compressed Gravel", "", "", "", "" };

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