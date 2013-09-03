package vanityblocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class VanityTrapDoors extends BlockTrapDoor {
    public static boolean disableValidation = false;
    String textureName;

    public VanityTrapDoors(int par1, Material par2Material, String texture)
    {
        super(par1, par2Material);
        textureName = texture;
		setCreativeTab(vanityblocks.VanityBlocks.tabCustom);
        this.disableStats();
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons (IconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon("vanityblocks:"+ textureName);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon (int side, int meta)
    {
        return this.blockIcon;
    } 
/*	private Icon[] iconBuffer;

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		iconBuffer = new Icon[6];

		iconBuffer[0] = par1IconRegister.registerIcon("vanityblocks:claybrick");
		iconBuffer[1] = par1IconRegister
				.registerIcon("vanityblocks:whitesoulsand");
		iconBuffer[2] = par1IconRegister
				.registerIcon("vanityblocks:oldlapisblock");
		iconBuffer[3] = par1IconRegister
				.registerIcon("vanityblocks:oldlapisbrick");
		iconBuffer[4] = par1IconRegister
				.registerIcon("vanityblocks:lapisbrick");
	}

	@Override
	public Icon getIcon(int side, int metadata) {
		if (metadata == 0) {
			return iconBuffer[0];
		}
		if (metadata == 1) {
			return iconBuffer[1];
		}
		if (metadata == 2) {
			return iconBuffer[2];
		}
		if (metadata == 3) {
			return iconBuffer[3];
		}
		if (metadata == 4) {
			return iconBuffer[4];
		}
		return blockIcon;
	} */
	@Override
	public int damageDropped(int metadata) {
		return metadata;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs tab, List subItems) {
		for (int ix = 0; ix < 5; ix++) {
			subItems.add(new ItemStack(this, 1, ix));
		}
	}
}


