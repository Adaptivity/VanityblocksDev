package vanityblocks;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;

public class VersionCheck extends Thread
{
    public static VersionCheck instance = new VersionCheck();
    private int count = 0;

    public VersionCheck()
    {
        super("VanityBlocks Version Check Thread");
    }

    public static void startCheck(Side sideToCheck)
    {
        final Thread thread = new Thread(VersionCheck.instance);
        thread.start();
        System.out.println("Check Starting");
    }

    @Override
    public void run()
    {
        final Side sideToCheck = FMLCommonHandler.instance().getSide();

        if (sideToCheck == null)
        {
            return;
        }

        while (this.count < 3 && DefaultProps.remoteBuildVer == 0)
        {
            try
            {
                final URL url = new URL("https://www.dropbox.com/s/tkd6nu5ckgddsrq/VersionCheck.txt");
                final HttpURLConnection http = (HttpURLConnection) url.openConnection();
                http.addRequestProperty("User-Agent", "Mozilla/4.76");
                final BufferedReader in = new BufferedReader(new InputStreamReader(http.getInputStream()));
                String str;
                String str2[] = null;

                while ((str = in.readLine()) != null)
                {

                    if (str.contains("Version"))
                    {
                        str = str.replace("Version=", "");

                        str2 = str.split("#");

                        if (str2 != null && str2.length == 3)
                        {
                            DefaultProps.remoteMajVer = Integer.parseInt(str2[0]);
                            DefaultProps.remoteMinVer = Integer.parseInt(str2[1]);
                            DefaultProps.remoteBuildVer = Integer.parseInt(str2[2]);
                        }

                        if (DefaultProps.remoteMajVer > DefaultProps.LOCALMAJVERSION || DefaultProps.remoteMajVer == DefaultProps.LOCALMAJVERSION && DefaultProps.remoteMinVer > DefaultProps.LOCALMINVERSION || DefaultProps.remoteMajVer == DefaultProps.LOCALMAJVERSION && DefaultProps.remoteMinVer == DefaultProps.LOCALMINVERSION && DefaultProps.remoteBuildVer > DefaultProps.LOCALBUILDVERSION)
                        {
                            Thread.sleep(5000);

                            if (sideToCheck.equals(Side.CLIENT))
                            {
                                FMLClientHandler.instance().getClient().thePlayer.addChatMessage(LanguageRegistry.instance().getStringLocalization("newversion.message1.name", "en_US") + String.valueOf(DefaultProps.remoteMajVer) + "." + String.valueOf(DefaultProps.remoteMinVer) + "." + String.valueOf(DefaultProps.remoteBuildVer) + " http://www.minecraftforum.net/topic/1631527-");
                            }
                            else if (sideToCheck.equals(Side.SERVER))
                            {
                            	VbLog.severe(LanguageRegistry.instance().getStringLocalization("newversion.message2.name", "en_US") + String.valueOf(DefaultProps.remoteMajVer) + "." + String.valueOf(DefaultProps.remoteMinVer) + "." + String.valueOf(DefaultProps.remoteBuildVer) + " http://www.minecraftforum.net/topic/1631527-");

                            }
                        }
                    }
                }
            }
            catch (final Exception e)
            {
            	e.printStackTrace();
            }

            if (DefaultProps.remoteBuildVer == 0)
            {
                try
                {
                	VbLog.severe(LanguageRegistry.instance().getStringLocalization("newversion.failed.name", "en_US"));
                    Thread.sleep(15000);
                }
                catch (final InterruptedException e)
                {
                }
            }
            else
            {
                VbLog.info(LanguageRegistry.instance().getStringLocalization("newversion.success.name", "en_US") + " " + DefaultProps.remoteMajVer + "." + DefaultProps.remoteMinVer + "." + DefaultProps.remoteBuildVer);
            }

            this.count++;
            System.out.println("Check Ran");
        }
    }


}