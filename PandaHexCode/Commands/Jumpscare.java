package PandaHexCode.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import PandaHexCode.PluginMain;

public class Jumpscare{

	public static class JumpscareC extends ChatCommandTarget{	
		public JumpscareC(String command) {
			super(command);
		}
		@Override
		public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
			otherPlayer.closeInventory();
			ItemStack oldHelmet = otherPlayer.getInventory().getHelmet();
			ItemStack h =  new ItemStack(Material.CARVED_PUMPKIN, 1);
			otherPlayer.getInventory().setHelmet(h);
			otherPlayer.playSound(otherPlayer.getLocation(), Sound.ENTITY_WITHER_DEATH, 10, 10);
			 Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(PluginMain.instance, new Runnable(){
					public void run(){
						otherPlayer.getInventory().setHelmet(oldHelmet);
					}
				},50);;
		}
	}
	
	public static class JumpscarePack extends ChatCommandTarget{	
		public JumpscarePack(String command) {
			super(command);
		}
		@Override
		public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
			otherPlayer.setResourcePack("https://download.mc-packs.net/pack/3b62c0672da3e6c6395f81f2ceb0f28266f6a9e7.zip");
		}
	}
	
}
