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
	  
	  private void generateSurface(World world, Random random, int blockX, int blockZ)  
	 { 
	      for (int i = 0; i < Storageprops.ruinrarity; i++) 
	        { 
	  int Xcoord1 = blockX + random.nextInt(16) + 8; 
	  int Ycoord1 = random.nextInt(11) + 60; 
	  int Zcoord1 = blockZ + random.nextInt(16) + 8; 
	     
	  (new StructureUnderWaterRuin()).generate(world, random, Xcoord1, Ycoord1, Zcoord1); 
	 } 
	 } 
	}