package d.studio.chatapi.test;

import d.studio.chatapi.api.Chat;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static de.tr7zw.nbtapi.NBTType.NBTTagCompound;

public class test implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Chat api = new Chat();
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta itemMeta = item.getItemMeta();

        itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        item.setItemMeta(itemMeta);

        String itemnbt = NBTItem.convertItemtoNBT(item).getCompound().toString();

        api.createHover("hola que tal", itemnbt, Chat.Type.ITEM, true);


        return false;
    }
}
