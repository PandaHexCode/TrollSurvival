package PandaHexCode.Commands;

import java.util.ArrayList;
import java.util.Comparator;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import PandaHexCode.PluginMain;

public class TerrainCommands{
	
	public static class TerrainFly extends ChatCommand{/*Currently broken*/
		private BukkitRunnable task;
		
		public TerrainFly(String command) {
			super(command);
		}
		@Override
		public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3){
			Player player = (Player) arg0;
			Location loc = player.getLocation();
			
	        ArrayList<Location> locations = PluginMain.GetLocationsInRadius(loc, 5, false, true);

	        ArrayList<BlockState> blockStates = new ArrayList<>();
	        for (Location location : locations) {
	            blockStates.add(location.getBlock().getState());
	        }

	        blockStates.sort(Comparator.comparingDouble(state -> state.getLocation().getY()));

	        final int maxSteps = 5;
	        
	        task = new BukkitRunnable() {
	            int step = 0;

	            @Override
	            public void run() {
	                if (step >= maxSteps) {
	                    this.cancel();
	                    return;
	                }
	                
	                for (BlockState blockState : blockStates) {
	                    Location originalLoc = blockState.getLocation();
	                    Location newLoc = originalLoc.clone().add(0, step + 1, 0);

	                    if (newLoc.getBlock().getType() == Material.AIR) {
	                        newLoc.getBlock().setType(blockState.getType());
	                        newLoc.getBlock().setBlockData(blockState.getBlockData());
	                    }
	                }
	                
	                step++;
	            }
	        };
	        
	        task.runTaskTimer(PluginMain.instance, 5L, 5L);

	        player.sendMessage(PluginMain.PR + "Blöcke werden bewegt!");
		    return true;
		}
	}
	
	public static class Rocket extends ChatCommandTarget{	
		private BukkitRunnable task;
		
		public Rocket(String command) {
			super(command);
		}
		
		@Override
		public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
		    final int maxSteps = 40;
					
			task = new BukkitRunnable(){
	            int step = 0;
	            @Override
	            public void run() {
	                if (step >= maxSteps) {
	                    this.cancel();
	                    return;
	                }
	                
	                otherPlayer.setVelocity(new Vector(0, 1, 0));
	                otherPlayer.getLocation().add(0, -1, 0).getBlock().setType(Material.DIRT);
	                
	                step++;
	            }
	        };
	        
	        task.runTaskTimer(PluginMain.instance, 0L, 0L);
		}
		
	}
	
}
