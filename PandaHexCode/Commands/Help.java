package PandaHexCode.Commands;

import java.util.ArrayList;
import java.util.Collections;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import PandaHexCode.PluginMain;

public class Help extends ChatCommand implements Listener {

    private static final int COMMANDS_PER_PAGE = 45;

    public Help(String command) {
        super(command);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        int page = 1;
        if (args.length >= 1) {
            try {
                page = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                player.sendMessage(PluginMain.PR + "§cNot valid number");
                return true;
            }
        }

        openHelpGUI(player, page - 1);
        return true;
    }
    
    private ChatCommand StringToChatCommand(String str) {
        ArrayList<ChatCommand> commands = (ArrayList<ChatCommand>) ChatCommand.allCommandsC.clone();
    	  for (ChatCommand command : commands) {
              if (command.command.equalsIgnoreCase(str)) {
                  return command;
              }
         }
    	  return null;
    }

    private void openHelpGUI(Player player, int page) {
        ArrayList<String> commands = (ArrayList<String>) ChatCommand.allCommands.clone();
        Collections.sort(commands);

        int totalPages = (int) Math.ceil((double) commands.size() / COMMANDS_PER_PAGE);
        if (page < 0 || page >= totalPages) {
            player.sendMessage(PluginMain.PR + "§cThis site dont exits");
            return;
        }

        Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.DARK_GREEN + "Help - Site " + (page + 1));

        int startIndex = page * COMMANDS_PER_PAGE;
        int endIndex = Math.min(startIndex + COMMANDS_PER_PAGE, commands.size());

        for (int i = startIndex; i < endIndex; i++) {
            String command = commands.get(i);

            ItemStack commandItem = new ItemStack(StringToChatCommand(command).helpMaterial);
            ItemMeta meta = commandItem.getItemMeta();
            if (meta != null) {
                meta.setDisplayName(ChatColor.YELLOW + "/" + command);
                commandItem.setItemMeta(meta);
            }

            inventory.addItem(commandItem);
        }

        if (page < totalPages - 1) {
            ItemStack nextPage = new ItemStack(Material.ARROW);
            ItemMeta meta = nextPage.getItemMeta();
            if (meta != null) {
                meta.setDisplayName(ChatColor.GREEN + "Next Site");
                nextPage.setItemMeta(meta);
            }
            inventory.setItem(53, nextPage); 
        }

        if (page > 0) {
            ItemStack previousPage = new ItemStack(Material.ARROW);
            ItemMeta meta = previousPage.getItemMeta();
            if (meta != null) {
                meta.setDisplayName(ChatColor.GREEN + "Last Site");
                previousPage.setItemMeta(meta);
            }
            inventory.setItem(45, previousPage);
        }

        player.openInventory(inventory);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().startsWith(ChatColor.DARK_GREEN + "Help")) {
            event.setCancelled(true);
            if (event.getWhoClicked() instanceof Player) {
                Player player = (Player) event.getWhoClicked();
                ItemStack clickedItem = event.getCurrentItem();

                if (clickedItem != null && clickedItem.hasItemMeta()) {
                    String displayName = clickedItem.getItemMeta().getDisplayName();

                    int currentPage = getCurrentPage(event.getView().getTitle());
                    if (displayName.equals(ChatColor.GREEN + "Next Site")) {
                        openHelpGUI(player, currentPage + 1);
                    } else if (displayName.equals(ChatColor.GREEN + "Last Site")) {
                        openHelpGUI(player, currentPage - 1);
                    }
                }
            }
        }
    }

    private int getCurrentPage(String title) {
        try {
            return Integer.parseInt(title.replace(ChatColor.DARK_GREEN + "Help - Site ", "")) - 1;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}