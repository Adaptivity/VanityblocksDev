package vanityblocks.Blocks;

import static net.minecraftforge.common.ForgeDirection.UP;

import java.util.List;

import vanityblocks.VanityBlocks;

import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CompressBlocks extends Block {
	public CompressBlocks(int id) {
		super(id, Material.rock);
		setResistance(10.0F);
		setCreativeTab(vanityblocks.VanityBlocks.tabCustom);
	}
	@Override
	public float getBlockHardness(World par1World, int par2, int par3, int par4) {
		int metadata = par1World.getBlockMetadata(par2, par3, par4);
		if (metadata == 0)
			return 2f;
		if (metadata == 1)
			return 2f;
		if (metadata == 2)
			return 2f;
		if (metadata == 3)
			return .8f;
		if (metadata == 4)
			return .8f;
		if (metadata == 5)
			return .8f;
		if (metadata == 6)
			return .8f;
		if (metadata == 7)
			return .8f;
		if (metadata == 8)
			return .8f;

		return 2f;
	}
	private Icon[] iconBuffer;

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		iconBuffer = new Icon[3];

		iconBuffer[0] = par1IconRegister
				.registerIcon("vanityblocks:cobble9x");
		iconBuffer[1] = par1IconRegister
				.registerIcon("vanityblocks:cobble81x");
		iconBuffer[2] = par1IconRegister
				.registerIcon("vanityblocks:cobble729x");
	}

	@Override
	// public Icon getBlockTextureFromSideAndMetadata (int side, int metadata) {
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
		return blockIcon;
	}

	@Override
	public int damageDropped(int metadata) {
		return metadata;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs tab, List subItems) {
		for (int ix = 0; ix < 3; ix++) {
			subItems.add(new ItemStack(this, 1, ix));
		}
	}
}