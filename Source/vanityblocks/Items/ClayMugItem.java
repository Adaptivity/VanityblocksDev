package vanityblocks.Items;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;


import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import vanityblocks.Registrations.GeneralFoodItemsRegistration;


public class ClayMugItem extends ItemFood
{
	public Icon[] icons;
	public String[] textureNames = new String[] { "unfired", "ceramic", "mugwithwater", "hotchocowater", "hotchocowatersweet", "mugwithmilk", "hotchocomilk" };
	
    public ClayMugItem(int id, int heal)
    {
        super(id, heal, 0.0F, false);
        setHasSubtypes(true);
        setMaxDamage(0);
        this.maxStackSize = 16;
		setCreativeTab(vanityblocks.VanityBlocks.tabCustom);
        //this.setAlwaysEdible();
    }
    
 /*   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer player)
    {
        if (player.canEat(true) && player.getFoodStats().getSaturationLevel() < 18F)
        {
            player.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        }

        return par1ItemStack;
    } */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }
    
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player)
    {
    	if (!world.isRemote)
    	{
    		int duration = 0;
    		PotionEffect potion;
	    	switch (stack.getItemDamage())
	    	{
	    	case 0:
	    		break;
	    		
	    	case 1:
	    		break;
	    		
	    	case 2:
	    		break;
	    		
	    	case 3:
	    		potion = player.getActivePotionEffect(Potion.regeneration);
	    		if (potion != null)
	    			duration = potion.duration;
	    		player.addPotionEffect(new PotionEffect(Potion.regeneration.id, duration + 8*20, 0));
	    		break;
	    		
	    	case 4:
	    		potion = player.getActivePotionEffect(Potion.regeneration);
	    		if (potion != null)
	    			duration = potion.duration;
	    		player.addPotionEffect(new PotionEffect(Potion.regeneration.id, duration + 8*20, 0));
	    		
	    		potion = player.getActivePotionEffect(Potion.moveSpeed);
	    		if (potion != null)
	    			duration = potion.duration;
	    		player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, duration + 8*20, 0));
	    		break;
	    		
	    	case 5:
//	    		potion = player.getActivePotionEffect(Potion.poison);
//	Failed    		if (potion != null)
//	    			duration = potion.duration;
	            player.curePotionEffects(stack);
//	    		potion = player.getActivePotionEffect(Potion.regeneration);
//	    		if (potion != null)
//	    			duration = potion.duration;
//	    		player.addPotionEffect(new PotionEffect(Potion.regeneration.id, duration + 8*20, 0));
	    		break;
	    		
	    	case 6:
	    		potion = player.getActivePotionEffect(Potion.regeneration);
	    		if (potion != null)
	    			duration = potion.duration;
	    		player.addPotionEffect(new PotionEffect(Potion.regeneration.id, duration + 8*20, 0));
	    		break;
	    	}
	    	
	        if (!player.capabilities.isCreativeMode)
	        {
	            --stack.stackSize;
	        }
	        
	    	switch (stack.getItemDamage()) {
	    	case 0:
	    		break;
	    	case 1:
	    		break;
	    	case 2:
	            player.inventory.addItemStackToInventory(new ItemStack(vanityblocks.Registrations.GeneralFoodItemsRegistration.claymugitem,1,1));
	            break;
	    	case 3:
	            player.inventory.addItemStackToInventory(new ItemStack(vanityblocks.Registrations.GeneralFoodItemsRegistration.claymugitem,1,1));
	            break;
	    	case 4:
	            player.inventory.addItemStackToInventory(new ItemStack(vanityblocks.Registrations.GeneralFoodItemsRegistration.claymugitem,1,1));
	            break;
	    	case 5:
	            player.inventory.addItemStackToInventory(new ItemStack(vanityblocks.Registrations.GeneralFoodItemsRegistration.claymugitem,1,1));
	            break;
	    	case 6:
	            player.inventory.addItemStackToInventory(new ItemStack(vanityblocks.Registrations.GeneralFoodItemsRegistration.claymugitem,1,1));    	
	            break;
	    	}
    	}
    }
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.drink;
    }    
 /*   public ItemStack onEaten(ItemStack ItemStack, World world, EntityPlayer par3EntityPlayer)
    {
        if (!par3EntityPlayer.capabilities.isCreativeMode)
        {
            --ItemStack.stackSize;
        }
    	switch (ItemStack.getItemDamage()) {
    	case 0:
    		break;
    	case 1:
    		break;
    	case 2:
            par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(vanityblocks.Registrations.GeneralFoodItemsRegistration.claymugitem,1,1));
            break;
    	case 3:
            par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(vanityblocks.Registrations.GeneralFoodItemsRegistration.claymugitem,1,1));
            break;
    	case 4:
            par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(vanityblocks.Registrations.GeneralFoodItemsRegistration.claymugitem,1,1));
            break;
    	case 5:
            par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(vanityblocks.Registrations.GeneralFoodItemsRegistration.claymugitem,1,1));
            break;
    	case 6:
            par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(vanityblocks.Registrations.GeneralFoodItemsRegistration.claymugitem,1,1));    	
            break;
    	}

        return ItemStack;
    } */

    @Override
    public int getMaxItemUseDuration(ItemStack itemstack)
    {
        return 24;
    }
	
/*	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation (ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		list.add("A little bit evil");
    	switch (stack.getItemDamage())
    	{
    	case 0: 
    		list.add("Killer healing");
    		break;
    	case 1:
    		break;
    	case 2:
    		break;
    	case 3:
    		break;
    	}
	} */
	@SideOnly(Side.CLIENT)
	@Override
    public void registerIcons(IconRegister iconRegister)
    {
		this.icons = new Icon[textureNames.length];

        for (int i = 0; i < this.icons.length; ++i)
        {
            this.icons[i] = iconRegister.registerIcon("vanityblocks:mug_"+textureNames[i]);
        }
    }
    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int var4 = 0; var4 < 7; ++var4)
        {
            par3List.add(new ItemStack(par1, 1, var4));
        }
    }
    @Override
    public String getUnlocalizedName(ItemStack itemstack)
    {
        return (new StringBuilder()).append("item.mug.").append(textureNames[itemstack.getItemDamage()]).toString();
    }
    /*public boolean isPotionIngredient()
    {
        return true;
    }*/
}