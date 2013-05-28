package vanityblocks.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class greenrupee extends Item
{
    public greenrupee(int par1)
    {
        super(par1);
        this.setHasSubtypes(true);
		setCreativeTab(vanityblocks.VanityBlocks.tabCustom);
    }

    public void registerIcons(IconRegister iconRegister)
    {
             itemIcon = iconRegister.registerIcon("vanityblocks:greenrupee1");
    }
}