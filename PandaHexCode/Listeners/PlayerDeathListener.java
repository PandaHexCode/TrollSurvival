package PandaHexCode.Listeners;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import PandaHexCode.PluginMain;


public class PlayerDeathListener implements Listener{
	
	public static ArrayList<Death> deaths = new ArrayList<Death>();
	
	public class Death{
		public Player player;
		public Location loc;
		public ItemStack[] items;
		public String deathMessage;
		public String time;
		
		public Death(Player player, Location loc, ItemStack[] items, String deathMessage) {
			this.player = player;
			this.loc = loc;
			this.items = items;
			this.deathMessage = deathMessage;
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			this.time = dtf.format(now);
		}
		
		public void Remove() {
			PlayerDeathListener.deaths.remove(this);
		}
		
		public void Teleport(Player p) {
			p.teleport(loc);
		}
		
		public void Receive(boolean teleportPlayer) {
			player.getInventory().setContents(items);
			if(teleportPlayer)
				player.teleport(loc);
			Remove();
		}
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = (Player)e.getEntity();
		Location loc = p.getLocation();
		
		deaths.add(new Death(p, loc, p.getInventory().getContents(), e.getDeathMessage()));
		PluginMain.SendMessageToAllTrollers(PluginMain.PR+"§e"+p.getName()+"§2 died at §cX"+(int)loc.getX()+" Y:"+(int)loc.getY()+" Z:"+(int)loc.getZ()+"§2!");
	}
}
