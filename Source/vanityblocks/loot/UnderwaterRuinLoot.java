package vanityblocks.loot;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class UnderwaterRuinLoot {
	
	public static List<ItemStack>greatloot;
	public static RuinWeightedLootSet goodLoot;
	public static RuinWeightedLootSet junkLoot;

	public static void init()
	{
		greatloot = new ArrayList<ItemStack>();
		goodLoot = new RuinWeightedLootSet();
		junkLoot = new RuinWeightedLootSet();

		ItemStack stack = new ItemStack(Item.pickaxeIron);
		stack.addEnchantment(Enchantment.fortune, 3);
		stack.addEnchantment(Enchantment.unbreaking, 3);
		stack.addEnchantment(Enchantment.efficiency, 5);
		greatloot.add(stack);


		// Junk Loot Stuff
		junkLoot.addLoot(new ItemStack(Item.seeds), 5, 1, 3);
		junkLoot.addLoot(new ItemStack(Item.leather), 5, 1, 5);
		junkLoot.addLoot(new ItemStack(Item.dyePowder, 1, 3), 5, 1, 3);
		junkLoot.addLoot(new ItemStack(Item.saddle), 5, 1, 1);

		// Good Loot
		goodLoot.addLoot(new ItemStack(Item.ingotIron), 38, 1, 3);
		goodLoot.addLoot(new ItemStack(Item.ingotGold), 20, 1, 3);
		goodLoot.addLoot(new ItemStack(Item.diamond), 4, 1, 2);
		goodLoot.addLoot(new ItemStack(Item.enchantedBook, 1, 1), 5, 1, 1);
//		ItemStack stick = new ItemStack(Item.stick);
//		stick.setItemName("Amazing Stick");
//		goodLoot.addLoot(stick, 1, 1, 1);
	}

	public static void addTool(ItemStack stack)
	{
		greatloot.add(stack);
	}

	public static ItemStack getRandomLoot()
	{
		if(greatloot == null)
			init();

		return greatloot.get(0);
	}

	public static ItemStack getRandomOpTool()
	{
		if(greatloot == null)
			init();

		int i = (new Random()).nextInt(greatloot.size());
		return greatloot.get(i).copy();
	}

	public static void fillChest(IInventory inventory, int multiplier, float quality) 
	{
		if(inventory == null)
		{
			System.out.println("Error trying to fill empty chest");
			return;
		}

		if(greatloot == null)
			init();

		Random rand = new Random();
		for(int i = 0; i < multiplier; i++)
		{
			int slot = rand.nextInt(inventory.getSizeInventory());
			float roll = rand.nextFloat();
			ItemStack stack = new ItemStack(0, 0, 0);
			if(rand.nextFloat() < quality)
			{
				if(roll > 0.20)
				{
					stack = goodLoot.getRandomLoot();
//				} else if(roll > 0.02) {
//					stack = ItemLoot.getRandomLoot(rand, true);
				} else {
					int randomgreatlootID = rand.nextInt(greatloot.size());
					stack = greatloot.get(randomgreatlootID).copy();
				}
			} else {

				stack = junkLoot.getRandomLoot();
			}
			inventory.setInventorySlotContents(slot, stack);
		}
	}
}

