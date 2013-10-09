package vanityblocks.Dimensions;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class VbMwManual extends ItemBlock
{
    public static ItemStack manual;

    static
    {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setString("author", "AnarchySage");
        nbt.setString("title", "Vanity Mining Dimension Help");

        NBTTagList pages = new NBTTagList();
        pages.appendTag(new NBTTagString("1", "      VanityBlocks\n      Mining World\n      Dimensions\n\nUser's Manual v1.0\n\n\n"
                + "Attention: If you still dont understand this, check the thread."));
        pages.appendTag(new NBTTagString("2", "Thank you for using the VB Dimensions Mod. Most everything can be changed in the config. Please check there for more config options."));
        pages.appendTag(new NBTTagString(
                "3",
                "This section will teach you how to make the portal shapes. You can see the design here(hard to explain) \n http://imgur.com/a/uKxAL \n The structure is always in that shape except for the hell dimension. "));
        pages.appendTag(new NBTTagString(
                "4",
                "Note the middle block in that structures bottom(the grass block(Redstone Ready world so discolored) \n Anyways, its the identifier, on the next page is biome name and its identifier block to open the portal there. \n (Lapis Block is always Required at top cept for hell)"));
        pages.appendTag(new NBTTagString(
                "5",
                "The possible dimensions are.. \n Plains - Grass Block \n Desert Hills - Sandstone Block \n Extreme Hills - Emerald Block \n Forest - Any Wood Log(Vannila)(direction doesnt matter) \n Taiga - Snow Block \n  Cont -> Next Page"));
        pages.appendTag(new NBTTagString(
                "6",
                "Swampland - Clay Block \n Shroom Island - Mycelium \n Jungle - Any leaves(Vannila) \n For the hell dimension its a bit different. All the stone is netherbrick and the lapis/identifer blocks are normal Nether Quartz Blocks."));
        pages.appendTag(new NBTTagString("7",
                "Then you right click with the lighter on the identifier block and the portals spawn, viola :) Enjoy. Please report any bugs you find, this was alot of work and effort for me."));
        pages.appendTag(new NBTTagString("7",
                "      Credits\nThanks to RebelKeithy for making Atum. Helped alot. \n\nThanks to mDiyo for help here and there. \n\nThanks to Kodos for helping with ideas/testing."));

        nbt.setTag("pages", pages);
        manual = new ItemStack(Item.writtenBook);
        manual.setTagCompound(nbt);
    }

    public VbMwManual(int id)
    {
        super(id);
        setContainerItem(this);
        setCreativeTab(DimensionManagement.tabDimensions);
        setMaxStackSize(1);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation (ItemStack stack, EntityPlayer player, List infoList, boolean advancedTooltips)
    {
        infoList.add("If you're lost, read the (in-game) manual");
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems (int itemId, CreativeTabs creativeTab, List subTypes)
    {
        subTypes.add(new ItemStack(itemId, 1, 0));
        subTypes.add(manual);
    }
}