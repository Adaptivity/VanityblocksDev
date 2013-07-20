package vanityblocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class MarbleStairsItemBlock extends ItemBlock
{

    private final static String[] subNames = { "Marble", "Marble Brick", "Chiseled Marble", "Ashford Black Marble", "Ashford Black Marble Brick", "Chiseled Ashford Black Marble", "", "", "", "", "",
            "", "", "", "" };

    public MarbleStairsItemBlock(int id)
    {
        super(id);
        setHasSubtypes(true);
        //		setItemName("vanitydesignblocks");
    }

    @Override
    public int getMetadata (int i)
    {
        return i;
    }

    @Override
    //	public String getItemNameIS(ItemStack itemstack) {
    //		return getItemName() + "." + subNames[itemstack.getItemDamage()];
    //	}
    public String getUnlocalizedName (ItemStack itemstack)
    {
        return subNames[itemstack.getItemDamage()];
        //getItemName() + "." + 
    }
}