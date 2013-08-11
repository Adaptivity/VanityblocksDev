package vanityblocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class VanityRandomItemBlock extends ItemBlock {

	private final static String[] subNames = { "Clay Brick", "White Soul Sand", "Lapis Block - Old", "Lapis Brick - Old", "Lapis Brick", "",
			"", "", "", "", "", "", "", "", "", "", "", "" };

	public VanityRandomItemBlock(int id) {
		super(id);
		setHasSubtypes(true);
		// setItemName("vanitydesignblocks");
	}

	@Override
	public int getMetadata(int i) {
		return i;
	}

	@Override
	// public String getItemNameIS(ItemStack itemstack) {
	// return getItemName() + "." + subNames[itemstack.getItemDamage()];
	// }
	public String getUnlocalizedName(ItemStack itemstack) {
		return subNames[itemstack.getItemDamage()];
		// getItemName() + "." +
	}
}