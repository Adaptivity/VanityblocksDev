package vanityblocks.WorldGen;

import java.util.Random; 

import vanityblocks.Storageprops;

import net.minecraft.world.World; 
import net.minecraft.world.chunk.IChunkProvider; 
  
import cpw.mods.fml.common.IWorldGenerator; 
  
public class UnderWaterRuinHandler implements IWorldGenerator  
{ 
	 public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	 { 
	  switch (world.provider.dimensionId) 
	  { 
	   case 0: generateSurface(world, random, chunkX*16, chunkZ*16); 
	  } 
	 } 
	  
	  private void generateSurface(World world, Random rand, int y, int z)  
	 { 
//	      for (int i = 0; i < Storageprops.ruinrarity; i++) 
          for(int a = 0; a < Storageprops.ruinrarity; a++)
              {
                 int RandPosX = y + rand.nextInt(16);
                 int RandPosY = rand.nextInt(16);
                 int RandPosZ = z + rand.nextInt(16);
                 (new StructureUnderWaterRuin()).generate(world, rand, RandPosX, RandPosY, RandPosZ);
	 } 
	 } 
	}