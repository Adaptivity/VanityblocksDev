package vanityblocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneLight;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class RedstonedimLamps extends BlockRedstoneLight {

	public RedstonedimLamps(int par1, boolean par2) {
		super(par1, par2);
		setCreativeTab(vanityblocks.VanityBlocks.tabCustom);
	}

	private Icon[] iconBuffer;

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		iconBuffer = new Icon[9];
		iconBuffer[0] = par1IconRegister
				.registerIcon("vanityblocks:redstonelamps/blackLamp");
		iconBuffer[1] = par1IconRegister
				.registerIcon("vanityblocks:redstonelamps/redLamp");
		iconBuffer[2] = par1IconRegister
				.registerIcon("vanityblocks:redstonelamps/greenLamp");
		iconBuffer[3] = par1IconRegister
				.registerIcon("vanityblocks:redstonelamps/brownLamp");
		iconBuffer[4] = par1IconRegister
				.registerIcon("vanityblocks:redstonelamps/blueLamp");
		iconBuffer[5] = par1IconRegister
				.registerIcon("vanityblocks:redstonelamps/purpleLamp");
		iconBuffer[6] = par1IconRegister
				.registerIcon("vanityblocks:redstonelamps/pinkLamp");
		iconBuffer[7] = par1IconRegister
				.registerIcon("vanityblocks:redstonelamps/lightBlueLamp");
		iconBuffer[8] = par1IconRegister
				.registerIcon("vanityblocks:redstonelamps/magentaLamp");
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
		if (metadata == 5) {
			return iconBuffer[5];
		}
		if (metadata == 6) {
			return iconBuffer[6];
		}
		if (metadata == 7) {
			return iconBuffer[7];
		}
		if (metadata == 8) {
			return iconBuffer[8];
		}
		return blockIcon;
	}
	@Override
	public int damageDropped(int metadata) {
		return metadata;
	}
	@Override
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
		int metadata = par1World.getBlockMetadata(par2, par3, par4);
        return metadata;
    }
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs tab, List subItems) {
		for (int ix = 0; ix < 9; ix++) {
			subItems.add(new ItemStack(this, 1, ix));
		}
	}
}