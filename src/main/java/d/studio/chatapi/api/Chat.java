package d.studio.chatapi.api;

import de.tr7zw.nbtapi.NBTItem;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.*;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

import static com.google.gson.internal.$Gson$Types.arrayOf;

public class Chat {

    /**
     * Crea un nuevo mensaje
     * @param player
     * @param args
     */
    public void createMessage(Player player, String args) {

        player.sendMessage(ChatColor.translateAlternateColorCodes('&', args));

    }

    /**
     * Crea un nuevo mensaje global
     * * Importante agregar permisos
     * @param args
     * @param perms
     */
    public void broadcast(String args, String perms) {

        Bukkit.broadcast(ChatColor.translateAlternateColorCodes('&', args), perms);

    }

    /**
     * Crea un nuevo component, BaseComponent
     * * BaseComponent
     *
     * @param args
     * @return BaseComponent
     */
    public BaseComponent createComponent(String args) {

        return new TextComponent(args);

    }

    /**
     * Crea un nuevo hoverEvent con los parametros dados
     * * Tipos: TEXT, ITEM
     * @param args
     * @param hoverText
     * @param Types
     * @param broadcast?
     *
     * @return BaseComponent como HoverEvent
     */
    public BaseComponent createHover(String args, String hoverText, Type Types, Boolean broadcast) {

        BaseComponent e = createComponent(args);

        switch (Types) {
            case TEXT:
                e.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(hoverText).create()));
                break;
            case ITEM:
                e.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_ITEM, new ComponentBuilder(hoverText).create()));
                break;
            default:
                break;
        }


        if (broadcast) {
            Bukkit.spigot().broadcast(e);
        }

        return e;
    }

    /**
     * Crea un nuevo clickEvent con los parametros dados
     * * Tipos: TEXT, ITEM
     * @param args
     * @param clickText
     * @param Type
     * @param broadcast?
     *
     * @return BaseComponent como HoverEvent
     */
    public BaseComponent clickEvent(String args, String clickText, ClickType Type, Boolean broadcast) {

        BaseComponent e = createComponent(args);

        switch (Type) {
            case COMMAND:
                e.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, clickText));
                break;
            case URL:
                e.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, clickText));
                break;
            default:
                break;
        }


        if (broadcast) {
            Bukkit.spigot().broadcast(e);
        }

        return e;

    }

    /**
     * Tipo de hover
     *
     * * TEXT, ACTION
     *
     * @return Action.TYPE
     */
    public enum Type {
        /**
         * Tipo: Texto(Valor string)
         *
         * @return Action.SHOW_TEXT
         */
        TEXT,

        /**
         * Tipo: Item(Valor BaseComponent[])
         *
         * @return Action.SHOW_ITEM
         */
        ITEM

    }

    /**
     * Tipo de click
     *
     * * COMMAND, URL
     *
     * @return Action.TYPE
     */
    enum ClickType {
        /**
         * Tipo: Command(Valor string)
         *
         * @return Action.Command
         */
        COMMAND,

        /**
         * Tipo: Url(Valor BaseComponent[])
         *
         * @return Action.Url
         */
        URL

    }

}
