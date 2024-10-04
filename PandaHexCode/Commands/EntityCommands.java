package PandaHexCode.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import PandaHexCode.PluginMain;

public class EntityCommands{

	public static class Entity extends ChatCommandTarget{	
		public Entity(String command) {
			super(command);
			minArg = 2;
			recString = "/" + command + " §e<PlayerName> <EntityName> <AI true|false>";
			defaultMessage = false;
		}
		@Override
		public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
			boolean AI = true;
			if(arg.length > 1) {
				if(arg[1].contains("false")) 
					AI = false;
			}
			EntityType type = PluginMain.instance.getEntityByName(arg[0]);
			
			if(type == null) {
				sender.sendMessage(PluginMain.PR+"§cEntityType §e"+ arg[0] + "§c not found!");
				return;
			}
			
			LivingEntity en = (LivingEntity) otherPlayer.getWorld().spawnEntity(otherPlayer.getLocation(), type);
	
			en.setAI(AI);
			sender.sendMessage(PluginMain.PR + otherPlayer.getName() +" has for the first time a Friend :O");
		}
	}
	
	public static class EntityFollower extends ChatCommand{
		private org.bukkit.entity.Entity pig;
		private BukkitRunnable task;
		public EntityFollower(String command){
			super(command);
		}

		@Override
		public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3){
			  Player player = (Player) arg0;
			  
			  if (pig != null){
		            pig.remove();
		            pig = null;
		            player.setWalkSpeed(0.2f);
		            player.sendMessage(PluginMain.PR+"§cOld entity got deleted!");
		            return true;
		      }
			  
			  if(arg3.length <1){
					player.sendMessage(PluginMain.PR+"§cPlease use /entityfollower <EntityName>");
					return false;
			  }
			  
			  EntityType type = PluginMain.instance.getEntityByName(arg3[0]);
				
			  if(type == null){
					player.sendMessage(PluginMain.PR+"§cEntityType §e"+ arg3[0] + "§c not found!");
					return false;
			  }
			  
			  
		        Location playerLocation = player.getLocation();
		        
		        Location pigLocation = playerLocation.clone();
		        
		        player.setWalkSpeed(0.1f);
		        pig = player.getWorld().spawnEntity(pigLocation, type);
		        LivingEntity en = (LivingEntity)pig;
		        en.setAI(false);
		        
		        task = new BukkitRunnable() {
		            @Override
		            public void run() {
		                if (pig == null) {
		                    cancel();
		                    return;
		                }
		                
		                en.setCollidable(false);
		                en.setHealth(10);
		                Location playerLocation2 = player.getLocation();
			            pigLocation.setWorld(playerLocation2.getWorld());
			            pigLocation.setX(playerLocation2.getX());
			            pigLocation.setY(playerLocation2.getY());
			            pigLocation.setZ(playerLocation2.getZ());
			            pigLocation.setYaw(playerLocation2.getYaw());
			            pigLocation.setPitch(playerLocation2.getPitch());
			            
			            
			            pig.teleport(pigLocation);
		            }
		        };
		        
		        task.runTaskTimer(PluginMain.instance, 0, 0);
		        
		        return true;
		}
	}
	
	public static class EntityDisableGravity extends ChatCommand{
		public EntityDisableGravity(String command){
			super(command);
		}
		@Override
		public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3){
			Player player = (Player) arg0;
			for(org.bukkit.entity.Entity e : player.getWorld().getEntities()){
				  if(!(e instanceof Player)){
					  if(e.hasGravity())
						  e.setGravity(false);
					  else 
						  e.setGravity(true);
				  }
			}
			
			player.sendMessage(PluginMain.PR+"yay");
		    return true;
		}
	}
	
}
