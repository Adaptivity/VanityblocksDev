package vanityblocks.Blocks;

import java.util.List;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import vanityblocks.tileentitys.TileMeltingcore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Vanitytileblock extends BlockContainer
{
    public Vanitytileblock(int id)
    {
        super(id, Material.rock);
        setResistance(10.0F);
        setCreativeTab(vanityblocks.VanityBlocks.tabCustom);

    }

    private Icon[] iconBuffer;

    @Override
    public void registerIcons (IconRegister par1IconRegister)
    {
        iconBuffer = new Icon[2];

        iconBuffer[1] = par1IconRegister.registerIcon("vanityblocks:meltingcore");
    }

    @Override
    public Icon getIcon (int side, int metadata)
    {
        if (metadata == 0)
        {
            return iconBuffer[1];
        }
        return blockIcon;
    }


    public float getBlockHardness (World par1World, int par2, int par3, int par4)
    {
        int metadata = par1World.getBlockMetadata(par2, par3, par4);
        if (metadata == 0)
            return 2f;
        return 2f;
    }
    @Override
    public void onBlockAdded (World world, int x, int y, int z)
    {
        world.setBlockTileEntity(x, y, z, this.createNewTileEntity(world));
    }
    
    public TileEntity createNewTileEntity (World var1)
    {
        return new TileMeltingcore();
    }
    
    @Override
    public int damageDropped (int metadata)
    {
        return metadata;
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks (int par1, CreativeTabs tab, List subItems)
    {
        for (int ix = 0; ix < 1; ix++)
        {
            subItems.add(new ItemStack(this, 1, ix));
        }
    }
}