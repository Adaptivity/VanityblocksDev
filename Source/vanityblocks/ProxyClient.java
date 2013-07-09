package vanityblocks;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraftforge.client.MinecraftForgeClient;

//import Vanityblocks.Proxy;

public class ProxyClient extends Proxy {
	
    @Override
public void registerRenderInformation()  {
    	
    //    MinecraftForgeClient.preloadTexture(anarchysvanitys.TEXTURE_ITEMS);
    }
	@Override
	public void addNames()
	{
		super.addNames();

		LanguageRegistry.instance().addStringLocalization("item.mug.unfired.name", "en_US", "Unfired Mug");
		LanguageRegistry.instance().addStringLocalization("item.mug.ceramic.name", "en_US", "Ceramic Mug");
		LanguageRegistry.instance().addStringLocalization("item.mug.mugwithwater.name", "en_US", "Mug with water");
		LanguageRegistry.instance().addStringLocalization("item.mug.hotchocowater.name", "en_US", "Hot Chocolate with water");
		LanguageRegistry.instance().addStringLocalization("item.mug.hotchocowatersweet.name", "en_US", "Sweetened Hot Chocolate with water");
		LanguageRegistry.instance().addStringLocalization("item.mug.mugwithmilk.name", "en_US", "Mug with milk");
		LanguageRegistry.instance().addStringLocalization("item.mug.hotchocomilk.name", "en_US", "Hot Chocolate with milk");

	}
}