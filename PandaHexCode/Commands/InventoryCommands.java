package PandaHexCode.Commands;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import PandaHexCode.PluginMain;

public class InventoryCommands{

	public static class CloseInv extends ChatCommandTarget{	
		public CloseInv(String command) {
			super(command);
		}
		@Override
		public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
			otherPlayer.closeInventory();
		}
	}
	
	public static class Invsee extends ChatCommandTarget{	
		public Invsee(String command) {
			super(command);
		}
		@Override
		public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
			sender.openInventory(otherPlayer.getInventory());
		}
	}
	
	public static class InvseeArmor extends ChatCommandTarget{	
		public InvseeArmor(String command) {
			super(command);
		}
		@Override
		public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
			  openArmorInventory(sender, otherPlayer);
		}
		  private void openArmorInventory(Player player, Player target) {
		        Inventory armorInventory = Bukkit.createInventory(null, 9, "Rüstung von " + target.getName());
		        
		        ItemStack[] armorContents = target.getInventory().getArmorContents();
		        armorInventory.setItem(0, armorContents[3]);
		        armorInventory.setItem(1, armorContents[2]);
		        armorInventory.setItem(2, armorContents[1]);
		        armorInventory.setItem(3, armorContents[0]);

		        player.openInventory(armorInventory);	       
		    }	
	}
	
	public static class SetArmorSlot extends ChatCommandTarget{	
		public SetArmorSlot(String command) {
			super(command);
		}
		@Override
		public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
			 int slot = 0; 
			 slot = Integer.parseInt(arg[0]);
			 ItemStack[] armor = otherPlayer.getInventory().getArmorContents().clone();
			 armor[slot] = sender.getInventory().getItemInMainHand();
			 otherPlayer.getInventory().setArmorContents(armor);
		}
	}
	
	public static class Workbench extends ChatCommandTarget{	
		public Workbench(String command) {
			super(command);
		}
		@Override
		public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
			otherPlayer.openWorkbench(otherPlayer.getLocation(), true);
		}
	}
	
}
