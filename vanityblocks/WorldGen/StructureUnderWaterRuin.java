package vanityblocks.WorldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

//check biome decorates - lemming
public class StructureUnderWaterRuin extends WorldGenerator {

	public StructureUnderWaterRuin() {

	}

	public boolean generate(World world, Random rand, int x, int y, int z) 
    { 
 //       if(world.getBlockId(x, y, z)!= Block.grass.blockID || world.getBlockId(x, y + 1, z)!= 0)
 //       	//try messing with these
//        {
 //          return false;
 //       }
  		int block = Block.blockGold.blockID;
  		int cobble = Block.cobblestone.blockID;
		int mossycobble = Block.cobblestoneMossy.blockID;
  		int stonebrick = Block.stoneBrick.blockID;
  		int dirt = Block.dirt.blockID;
//		int mossybrick = (Block.stoneBrick.blockID,2,2);
//  	#using bbob builder, take the data and use it like so 1,2,3,4
//		# that turns to this x + 1, y + 2, z + 3, 4 is the blockid
  		world.setBlock(x + 0,  y + 0,  z + 0, cobble);
  		world.setBlock(x - 1,  y + 0,  z + 0, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x - 2,  y + 0,  z + 0, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x - 3,  y + 0,  z + 0, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x - 3,  y + 0,  z + 1, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x - 3,  y + 0,  z + 2, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x + 0,  y + 0,  z + 1, mossycobble);
  		world.setBlock(x + 0,  y + 0,  z + 2, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x + 0,  y + 0,  z + 3, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x - 1,  y + 0,  z + 3, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x - 2,  y + 0,  z + 3, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x - 3,  y + 0,  z + 3, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x - 3,  y + 0,  z - 1, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x - 3,  y + 0,  z - 2, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x - 3,  y + 0,  z - 3, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x - 2,  y + 0,  z - 3, mossycobble);
  		world.setBlock(x - 1,  y + 0,  z - 3, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x + 0,  y + 0,  z - 3, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x + 1,  y + 0,  z - 3, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x + 1,  y + 0,  z + 0, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x + 2,  y + 0,  z + 0, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x + 3,  y + 0,  z + 0, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x + 3,  y + 0,  z - 1, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x + 3,  y + 0,  z - 2, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x + 3,  y + 0,  z - 3, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x + 2,  y + 0,  z - 3, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x + 3,  y + 0,  z + 1, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x + 3,  y + 0,  z + 2, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x + 3,  y + 0,  z + 3, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x + 2,  y + 0,  z + 3, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x + 1,  y + 0,  z + 3, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x + 1,  y + 0,  z + 2, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x + 1,  y + 0,  z + 1, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x + 2,  y + 0,  z + 1, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x + 2,  y + 0,  z + 2, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x - 1,  y + 0,  z + 2, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x - 2,  y + 0,  z + 2, mossycobble);
  		world.setBlock(x - 2,  y + 0,  z + 1, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x - 1,  y + 0,  z + 1, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x - 2,  y + 0,  z - 1, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x - 1,  y + 0,  z - 2, Block.stoneBrick.blockID,1,2);
  		world.setBlock(x + 0,  y + 0,  z - 2, Block.stoneBrick.blockID,1,2);
		world.setBlock(x + 1,  y + 0,  z - 2, Block.stoneBrick.blockID,1,2);
		world.setBlock(x + 2,  y + 0,  z - 2, Block.stoneBrick.blockID,1,2);
		world.setBlock(x + 2,  y + 0,  z - 1, Block.stoneBrick.blockID,1,2);
		world.setBlock(x + 1,  y + 0,  z - 1, mossycobble);
		world.setBlock(x + 0,  y + 0,  z - 1, Block.stoneBrick.blockID,1,2);
		world.setBlock(x - 1,  y + 0,  z - 1, Block.stoneBrick.blockID,1,2);
		world.setBlock(x - 2,  y + 0,  z - 2, Block.stoneBrick.blockID,1,2);
		
		world.setBlock(x - 3,  y + 1,  z + 2, cobble);
		world.setBlock(x - 3,  y + 1,  z + 0, cobble);
		world.setBlock(x - 3,  y - 1,  z + 1, cobble);//
		world.setBlock(x - 3,  y + 1,  z - 3, cobble);
		world.setBlock(x + 1,  y + 1,  z - 3, cobble);
		world.setBlock(x + 2,  y + 1,  z - 3, cobble);
		world.setBlock(x + 3,  y + 1,  z - 3, cobble);
		world.setBlock(x - 3,  y + 1,  z - 2, Block.stoneBrick.blockID,2,2);
		world.setBlock(x - 3,  y + 1,  z + 3, Block.stoneBrick.blockID,2,2);
		world.setBlock(x + 2,  y + 1,  z + 3, Block.stoneBrick.blockID,2,2);
		world.setBlock(x + 0,  y + 1,  z + 3, Block.stoneBrick.blockID,2,2);
		world.setBlock(x + 3,  y + 1,  z + 1, Block.stoneBrick.blockID,2,2);
		world.setBlock(x + 3,  y + 1,  z + 0, Block.stoneBrick.blockID,2,2);
		world.setBlock(x + 3,  y + 1,  z - 2, mossycobble);
		world.setBlock(x + 3,  y + 1,  z - 1, mossycobble);
		world.setBlock(x + 3,  y + 1,  z + 2, mossycobble);
		world.setBlock(x + 0,  y + 1,  z + 0, Block.chest.blockID);
		world.setBlock(x + 1,  y + 1,  z + 3, mossycobble);
		
		world.setBlock(x - 3,  y + 2,  z + 3, Block.stoneBrick.blockID,1,2);
		world.setBlock(x - 3,  y + 2,  z + 2, Block.stoneBrick.blockID,1,2);
		world.setBlock(x + 1,  y + 2,  z - 3, Block.stoneBrick.blockID,1,2);
		world.setBlock(x + 3,  y + 2,  z + 0, Block.stoneBrick.blockID,1,2);
		world.setBlock(x + 3,  y + 2,  z + 1, Block.stoneBrick.blockID,1,2);
		world.setBlock(x + 3,  y + 2,  z + 2, Block.stoneBrick.blockID,1,2);
		world.setBlock(x - 3,  y + 2,  z - 3, mossycobble);
		
		
		world.setBlock(x - 3,  y + 3,  z - 3, mossycobble);
		world.setBlock(x - 1,  y + 3,  z - 3, mossycobble);
		world.setBlock(x + 2,  y + 3,  z - 3, mossycobble);
		world.setBlock(x - 3,  y + 3,  z - 1, mossycobble);
		world.setBlock(x - 3,  y + 3,  z + 2, mossycobble);
		world.setBlock(x - 3,  y + 3,  z + 3, mossycobble);
		world.setBlock(x - 3,  y + 3,  z - 2, Block.stoneBrick.blockID,1,2);
		world.setBlock(x - 3,  y + 3,  z + 0, Block.stoneBrick.blockID,1,2);
		world.setBlock(x - 2,  y + 3,  z - 3, Block.stoneBrick.blockID,1,2);
		world.setBlock(x + 3,  y + 3,  z + 1, Block.stoneBrick.blockID,1,2);
		world.setBlock(x - 3,  y + 3,  z + 1, Block.stoneBrick.blockID,2,2);
		world.setBlock(x + 0,  y + 3,  z - 3, Block.stoneBrick.blockID,2,2);
		world.setBlock(x + 3,  y + 3,  z - 3, Block.stoneBrick.blockID,2,2);
		world.setBlock(x + 3,  y + 3,  z + 2, Block.stoneBrick.blockID,2,2);
		
  		return true;
     }}
