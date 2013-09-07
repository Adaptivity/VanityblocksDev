package vanityblocks.Blocks;

import java.util.List;

import vanityblocks.Storageprops;
import vanityblocks.Renders.BlockCurtainRender;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class CurtainBlock extends Block {
	public CurtainBlock(int id) {
		super(id, Material.cloth);
		setCreativeTab(vanityblocks.VanityBlocks.tabCustom);
        this.setBlockBounds(0F, -1F, 0.375F, 1F, 1F, 0.625F);
	}
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	@Override
	public int getMobilityFlag() {
		return 2;
	}

	@Override
	public Icon getIcon(int side, int metadata) {
		return Block.cloth.getIcon(side, metadata);
	}
/*	@Override
    //Called when the block is placed in the world.
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
    {
        int l = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
    } */
	
/*    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
    {
        int meta = world.getBlockMetadata(x, y, z);
        ForgeDirection direction = ForgeDirection.getOrientation(meta);
        if (direction == ForgeDirection.UP)
        {
            this.setBlockBounds(0F, 0F, 0.375F, 1F, 1F, 0.625F);
        }
        else if (direction == ForgeDirection.DOWN)
        {
            this.setBlockBounds(0F, 0F, 0.375F, 1F, 1F, 0.625F);
        }
        else if (direction == ForgeDirection.NORTH)
        {
            this.setBlockBounds(0F, 0F, 0.375F, 1F, 1F, 0.625F);
        }
        else if (direction == ForgeDirection.SOUTH)
        {
            this.setBlockBounds(0F, 0F, 0.375F, 1F, 1F, 0.625F);
        }
        else if (direction == ForgeDirection.EAST)
        {
            this.setBlockBounds(0F, 0F, 0.375F, 1F, 1F, 0.625F);
        }
        else if (direction == ForgeDirection.WEST)
        {
            this.setBlockBounds(0F, 0F, 0.375F, 1F, 1F, 0.625F);
        }
        else
        {
            this.setBlockBounds(1F, 1F, 1F, 1F, 1F, 1F);
            return;
        }
    }*/
    
    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderType ()
    {
        return BlockCurtainRender.curtainModelID;
    }

	@Override
	public int damageDropped(int metadata) {
		return metadata;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs tab, List subItems) {
		for (int ix = 0; ix < 16; ix++) {
			subItems.add(new ItemStack(this, 1, ix));
		}
	}
}
