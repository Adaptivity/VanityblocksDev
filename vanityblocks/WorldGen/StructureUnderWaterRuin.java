package vanityblocks.WorldGen; 
  
import java.util.Random; 
  
import net.minecraft.block.Block; 
import net.minecraft.world.World; 
import net.minecraft.world.gen.feature.WorldGenerator; 
  
public class StructureUnderWaterRuin extends WorldGenerator 
{ 
  
    public StructureUnderWaterRuin() 
    { 
    	
    } 
  
    public boolean generate(World world, Random rand, int x, int y, int z) 
    { 
        if(world.getBlockId(x, y, z)!= Block.grass.blockID || world.getBlockId(x, y + 1, z)!= 0)
        {
           return false;
        }
  		int block = Block.blockGold.blockID;
  			
        world.notifyBlockChange(x, y + 1, z, block);
  		world.notifyBlockChange(x, y + 2, z, block);
  		world.notifyBlockChange(x, y + 3, z, block);
  		world.notifyBlockChange(x, y + 4, z, block);
  		world.notifyBlockChange(x, y + 5, z, block);
  		world.notifyBlockChange(x, y + 6, z, block);
  		world.notifyBlockChange(x, y + 6, z + 1, block);
  		world.notifyBlockChange(x, y + 6, z + 2, block);
  		world.notifyBlockChange(x, y + 6, z + 3, block);
  		world.notifyBlockChange(x, y + 6, z + 4, block);
  		world.notifyBlockChange(x, y + 6, z + 5, block);
  		world.notifyBlockChange(x, y + 6, z + 6, block);
  		world.notifyBlockChange(x + 1, y + 6, z, block);
  		world.notifyBlockChange(x + 2, y + 6, z , block);
  		world.notifyBlockChange(x + 3, y + 6, z  , block);		
  		world.notifyBlockChange(x + 4, y + 6, z , block);
  		world.notifyBlockChange(x + 5, y + 6, z , block);
  		world.notifyBlockChange(x + 6, y + 6, z  ,block);
  		world.notifyBlockChange(x + 7, y + 6, z , block);
  		world.notifyBlockChange(x + 8, y + 6, z  ,block);
  		world.notifyBlockChange(x + 9, y + 6, z , block);
  		world.notifyBlockChange(x + 9, y + 1, z + 6, block);
  		world.notifyBlockChange(x + 9, y + 2, z + 6, block);
  		world.notifyBlockChange(x + 9, y + 3, z + 6, block);
  		world.notifyBlockChange(x + 9, y + 4, z + 6, block);
  		world.notifyBlockChange(x + 9, y + 5, z + 6, block);
  		world.notifyBlockChange(x + 9, y + 6, z + 6, block);
  		world.notifyBlockChange(x + 1, y + 0, z, block);
  		world.notifyBlockChange(x + 2, y + 0, z, block);
  		world.notifyBlockChange(x + 3, y + 0, z, block);
  		world.notifyBlockChange(x + 4, y + 0, z, block);
  		world.notifyBlockChange(x + 5, y + 0, z, block);
  		world.notifyBlockChange(x + 6, y + 0, z, block);
  		world.notifyBlockChange(x + 7, y + 0, z, block);
  		world.notifyBlockChange(x + 8, y + 0, z, block);
  		world.notifyBlockChange(x + 9, y + 0, z, block);
  		world.notifyBlockChange(x + 9, y + 1, z, block);
  		world.notifyBlockChange(x +9, y + 2, z, block);
  		world.notifyBlockChange(x + 9, y + 3, z, block);
  		world.notifyBlockChange(x + 9, y + 4, z, block);
  		world.notifyBlockChange(x + 9, y + 5, z, block);
  		world.notifyBlockChange(x + 9, y + 6, z, block);
  		world.notifyBlockChange(x + 9, y + 0, z + 1, block);
  		world.notifyBlockChange(x + 9, y + 0, z + 2, block);
  		world.notifyBlockChange(x + 9, y + 0, z + 3, block);
  		world.notifyBlockChange(x + 9, y + 0, z + 4, block);
  		world.notifyBlockChange(x + 9, y + 0, z + 5, block);
  		world.notifyBlockChange(x + 9, y + 0, z + 6, block);
  		world.notifyBlockChange(x + 8, y + 0, z + 6, block);
  		world.notifyBlockChange(x + 7, y + 0, z + 6, block);
  		world.notifyBlockChange(x + 6, y + 0, z + 6, block);
  		world.notifyBlockChange(x + 5, y + 0, z + 6, block);
  		world.notifyBlockChange(x + 4, y + 0, z + 6, block);
  		world.notifyBlockChange(x + 3 , y + 0, z + 6, block);
  		world.notifyBlockChange(x + 2 , y + 0, z + 6, block);
  		world.notifyBlockChange(x , y + 0, z + 6, block);
  		world.notifyBlockChange(x , y + 0, z + 6, block);
  		world.notifyBlockChange(x , y + 1, z + 6, block);
  		world.notifyBlockChange(x , y + 2, z + 6, block);
  		world.notifyBlockChange(x , y + 3, z + 6, block);
  		world.notifyBlockChange(x , y + 4, z + 6, block);
  		world.notifyBlockChange(x , y + 5, z + 6, block);
  		world.notifyBlockChange(x , y + 6, z + 6, block);
  		world.notifyBlockChange(x , y + 0, z + 5, block);
  		world.notifyBlockChange(x , y + 0, z + 4, block);
  		world.notifyBlockChange(x , y + 0, z + 3, block);
  		world.notifyBlockChange(x , y + 0, z + 2, block);
  		world.notifyBlockChange (x + 9, y + 1, z + 6, block);
  		world.notifyBlockChange (x + 9 , y + 2, z + 6, block);	
  		world.notifyBlockChange (x + 9 , y + 3, z  + 6, block);
  		world.notifyBlockChange (x + 9 , y + 4, z + 6, block);
  		world.notifyBlockChange (x + 9, y + 5, z + 6, block);	
  		world.notifyBlockChange (x + 9 , y + 6, z + 6, block);		
  		
  		return true;
     }   
  }
