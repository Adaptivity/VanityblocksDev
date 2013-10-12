package vanityblocks.Registrations;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class Modbypass
{
    public static void bypassrecipes ()
    {
        GameRegistry.addShapelessRecipe(new ItemStack(Block.planks, 8, 0), new ItemStack(Block.wood, 1, 0), new ItemStack(Block.wood, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(Block.planks, 8, 1), new ItemStack(Block.wood, 1, 0), new ItemStack(Block.wood, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(Block.planks, 8, 2), new ItemStack(Block.wood, 1, 0), new ItemStack(Block.wood, 1, 2));
        GameRegistry.addShapelessRecipe(new ItemStack(Block.planks, 8, 3), new ItemStack(Block.wood, 1, 0), new ItemStack(Block.wood, 1, 3));
    }
}
