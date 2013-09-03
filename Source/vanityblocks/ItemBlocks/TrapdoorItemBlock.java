package vanityblocks.ItemBlocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class TrapdoorItemBlock extends ItemBlock {

	private final static String[] subNames = { "Birch Trapdoor", "",
			"", "", "",
			"", "", "", "", "",
			"", "", "", "", "", "" };

	public TrapdoorItemBlock(int id) {
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