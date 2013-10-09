package vanityblocks.Dimensions;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class VanityPortalItemBlock extends ItemBlock
{

    private final static String[] subNames = { "VB Plains Dimension Portal", "VB Desert Hills Dimension Portal", "VB Extreme Hills Dimension Portal", "VB Forest Dimension Portal",
            "VB Taiga Dimension Portal", "VB Swampland Dimension Portal", "VB Shroom Dimension Portal", "VB Jungle Dimension Portal", "", "", "", "", "", "", "", "" };

    public VanityPortalItemBlock(int id)
    {
        super(id);
        setHasSubtypes(true);
    }

    @Override
    public int getMetadata (int i)
    {
        return i;
    }

    @Override
    public String getUnlocalizedName (ItemStack itemstack)
    {
        return subNames[itemstack.getItemDamage()];
    }
}