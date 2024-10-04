package PandaHexCode.Commands;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;

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
