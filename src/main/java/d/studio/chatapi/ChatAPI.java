package d.studio.chatapi;

import d.studio.chatapi.api.Chat;
import d.studio.chatapi.test.test;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChatAPI extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        Chat api = new Chat();


        //this.getCommand("tedst").setExecutor(new test());

    }

}
