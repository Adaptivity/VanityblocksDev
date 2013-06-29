package vanityblocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MarbleWall extends BlockWall
{
    public MarbleWall(int vanityDesignworldWallId, int par1, Block par2Block)
    {
        super(par1, par2Block);
    }    

	@SideOnly(Side.CLIENT)
    private Icon icon[];
    
	@Override
    public Icon getIcon(int side, int meta)
    {
        return icon[meta];
    }

    @Override
    public boolean isBlockSolidOnSide(World world, int x, int y, int z, ForgeDirection side)
    {
        return side == ForgeDirection.UP;
    }
    
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
//    @Override
//   public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
//  {
//        par3List.add(new ItemStack(par1, 1, 0));
//        par3List.add(new ItemStack(par1, 1, 1));
//        par3List.add(new ItemStack(par1, 1, 2));
//       par3List.add(new ItemStack(par1, 1, 3));
//    }
}