package vanityblocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MarbleSlab extends BlockHalfSlab {
    public static final String[] slabType = new String[] {"marble", "marblebrick", "marblechisel", "blackmarble", "blackmarblebrick", "blackmarblechisel"};

	public MarbleSlab(int par1, boolean par2) {
		super(par1, par2, Material.rock);
		this.setCreativeTab(vanityblocks.VanityBlocks.tabCustom);
		setHardness(2.0F);
		setResistance(5.0F);
		setStepSound(soundStoneFootstep);


	}
	@Override
	public int damageDropped (int metadata) {
		return metadata;
	}

	@SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    private Icon[] iconBuffer;
   @Override
   public void registerIcons(IconRegister par1IconRegister)
	    {
	        iconBuffer = new Icon[7]; 
	        
	        iconBuffer[1] = par1IconRegister.registerIcon("vanityblocks:marble"); 
	        iconBuffer[2] = par1IconRegister.registerIcon("vanityblocks:marblebrick");
	        iconBuffer[3] = par1IconRegister.registerIcon("vanityblocks:marblechisel");
	        iconBuffer[4] = par1IconRegister.registerIcon("vanityblocks:blackmarble");
	        iconBuffer[5] = par1IconRegister.registerIcon("vanityblocks:blackmarblebrick");
	        iconBuffer[6] = par1IconRegister.registerIcon("vanityblocks:blackmarblechisel");
	    }
	@Override
//	public Icon getBlockTextureFromSideAndMetadata (int side, int metadata) {
	public Icon getIcon (int side, int metadata) {

		if (metadata == 0){
			return iconBuffer[0];
		}
		if (metadata == 1){
			return iconBuffer[1];
		}
		if (metadata == 2){
			return iconBuffer[2];
		}
		if (metadata == 3){
			return iconBuffer[3];
		}
		return blockIcon;
	}
    /**
     * Returns the slab block name with step type.
     */
	@Override
    public String getFullSlabName(int par1)
    {
        if (par1 < 0 || par1 >= slabType.length)
       {
           par1 = 0;
       }

        return super.getUnlocalizedName() + "." + slabType[par1];
    }

    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
	@Override
//    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
//    {
//        if (par1 != Atum.atumSlabs.blockID)
//        {
//           for (int j = 0; j < 4; ++j)
//            {
//                par3List.add(new ItemStack(par1, 1, j));
//            }
//        }
//    }

    public void getSubBlocks(int par1, CreativeTabs tab, List subItems) {
        for (int i = 0; i < 7; i++) {
            subItems.add(new ItemStack(this, 1, i));
        }
    }
}