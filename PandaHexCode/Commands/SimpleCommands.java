package PandaHexCode.Commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import PandaHexCode.PluginMain;

public class SimpleCommands{

	public static class Jump extends ChatCommandTarget{
			public Jump(String command){
				super(command);
				this.helpMaterial = Material.PLAYER_HEAD;
			}
			@Override
			public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
				Vector vt = otherPlayer.getVelocity();
				vt.setY(0.5f);
				otherPlayer.setVelocity(vt);
			}
			
	}
	
	public static class EntitiesJump extends ChatCommand{
		public EntitiesJump(String command) {
			super(command);
			this.helpMaterial = Material.CREEPER_HEAD;
		}
		@Override
		public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
			Player p = (Player) arg0;
			if(arg3.length <1)
				p.sendMessage(PluginMain.PR+"§cPlease use /entitiesjump <jumpheigh>");
			else {
				float y = 0.5f;
				y = Float.parseFloat(arg3[0]);
				
				for(Entity e : p.getWorld().getEntities()) {
					  if(!(e instanceof Player)){
						  Vector vt = e.getVelocity();
						  vt.setY(y);
						  e.setVelocity(vt);
					  }
				}
				p.sendMessage(PluginMain.PR+"Jump! xD");
			}
			return false;
		}
	}
	
	public static class Mlg extends ChatCommandTarget{	
		public Mlg(String command) {
			super(command);
			this.helpMaterial = Material.WATER_BUCKET;
		}
		@Override
		public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
			Vector vt = otherPlayer.getVelocity();
			vt.setY(5f);
			otherPlayer.setVelocity(vt);
		}
	}
	
	public static class Explosion extends ChatCommandTarget{	
		public Explosion(String command) {
			super(command);
			minArg = 2;
			recString = "/" + command + " §e<PlayerName> <Strength>";
			this.helpMaterial = Material.TNT;
		}
		
		@Override
		public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
			float strength = Float.parseFloat(arg[0]);
			otherPlayer.getWorld().createExplosion(otherPlayer.getLocation(), strength);
		}
	}
	
	public static class Sudo extends ChatCommandTarget{	
		public Sudo(String command) {
			super(command);
			minArg = 2;
			recString = "/" + command + " §e<PlayerName> <Command/Message>";
			this.helpMaterial = Material.PLAYER_HEAD;
		}
		
		@Override
		public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
			String finalMessage = "";
			for(int i = 0;i< arg.length;i++) {
				finalMessage = finalMessage+arg[i]+" ";
			}
			otherPlayer.chat(finalMessage);
		}
	}
	
	public static class SetVelocity extends ChatCommandTarget{	
		public SetVelocity(String command) {
			super(command);
			minArg = 4;
			recString = "/" + command + " §e<PlayerName> <x> <y> <z>";
			this.helpMaterial = Material.PLAYER_HEAD;
		}
		
		@Override
		public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
			float x = 0.5f;
			x = Float.parseFloat(arg[0]);
			float y = 0.5f;
			y = Float.parseFloat(arg[1]);
			float z = 0.5f;
			z = Float.parseFloat(arg[2]);
			otherPlayer.setVelocity(new Vector(x,y,z));
		}
	}
	
	public static class WalkSpeed extends ChatCommandTarget{	
		public WalkSpeed(String command) {
			super(command);
			minArg = 2;
			recString = "/" + command + " §e<PlayerName> <Speed(Standart=0.2)>";
			this.helpMaterial = Material.LEATHER_BOOTS;
		}
		
		@Override
		public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
			float walkSpeed;
			walkSpeed = Float.parseFloat(arg[0]);
			otherPlayer.setWalkSpeed(walkSpeed);
		}
	}
	
	public static class Grumm extends ChatCommand{
		public Grumm(String command) {
			super(command);
			this.helpMaterial = Material.PIGLIN_HEAD;
		}
		@Override
		public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
			Player p = (Player) arg0;
			p.sendMessage(PluginMain.PR+"Grumm!");
			
			for(Entity e : p.getWorld().getEntities()) {
				  if(!(e instanceof Player))
				  {
					  e.setCustomName("Grumm");
				  }
			}
			return false;
		}

	}
	
	public static class GroundBug extends ChatCommandTarget{
		public GroundBug(String command){
			super(command);
			this.helpMaterial = Material.PLAYER_HEAD;
		}
		@Override
		public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
			otherPlayer.teleport(otherPlayer.getLocation().add(0,-1.2f,0));
		}
	}
	
	public static class CreeperSound extends ChatCommandTarget{
		public CreeperSound(String command){
			super(command);
			this.helpMaterial = Material.CREEPER_HEAD;
		}
		@Override
		public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
			otherPlayer.playSound(otherPlayer.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 1.0f, 1.0f);
		}
	}
	
	public static class Drop extends ChatCommandTarget{
		public Drop(String command){
			super(command);
			this.helpMaterial = Material.DIAMOND_SWORD;
		}
		@Override
		public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
			otherPlayer.dropItem(true);
			otherPlayer.setItemInHand(null);
		}
	}
	
	public static class RandomItem extends ChatCommandTarget{
		public RandomItem(String command){
			super(command);
			this.helpMaterial = Material.DIAMOND;
		}
		public static ItemStack item = null;
		@Override
		public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
			PluginMain.PlaySoundToAll(Sound.BLOCK_BEACON_ACTIVATE);
			PluginMain.SendTitleToAll("§c§lRandom§e§lItem", "§b§lEvent §e§l@" + otherPlayer.getName(), 10, 50, 10, true);
			
			  new BukkitRunnable() {
	                @Override
	                public void run(){
	                    item = null;
	                    Random random = new Random();
        			    int i = random.nextInt(20);
        			    if(i < 1)
        			    	i = 1;
	        			while(item == null){
	        				Material[] materials = Material.values();
	        			    Material randomMaterial = materials[random.nextInt(materials.length)];
	        			    item = new ItemStack(randomMaterial, i);
	        			}
	        		    otherPlayer.getInventory().addItem(item);
	        		    PluginMain.SendTitleToAll("§b§l"+item.getType().name() + " x " + i, "§e§lCongratulations!", 10, 50, 10, true);
	        		    PluginMain.PlaySoundToAll(Sound.ENTITY_PLAYER_LEVELUP);
	                }
	            }.runTaskLater(PluginMain.instance, 120);
		}
	}
	
	public static class EventPicker extends ChatCommand{
		public EventPicker(String command){
			super(command);
	            names.add("Quiz");
	            names.add("Lucky chest");
	            names.add("Fight");
	    		this.helpMaterial = Material.ELYTRA;
		}
	
		private ArrayList<String> names = new ArrayList<>();
		    private Random random = new Random();
		
		@Override
		public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		         

		            BukkitRunnable titleRunnable = new BukkitRunnable() {
		                int ticksPassed = 0;
		                int maxTicks = 60; 

		                @Override
		                public void run() {
		                    if (ticksPassed >= maxTicks) {
		                        cancel();
		                        String selectedName = names.get(random.nextInt(names.size()));
		                        sendTitleToAllPlayers(selectedName);
		                        return;
		                    }

		                    shuffleArrayList(names);
		                    String currentName = names.get(0);

		                    sendTitleToAllPlayers(currentName);

		                    ticksPassed++;
		                }
		            };

		            titleRunnable.runTaskTimer(PluginMain.instance, 0, 2); 

			return false;
			
		}
		  private void shuffleArrayList(ArrayList<String> list) {
		        int n = list.size();
		        for (int i = 0; i < n; i++) {
		            int j = random.nextInt(n);
		            String temp = list.get(i);
		            list.set(i, list.get(j));
		            list.set(j, temp);
		        }
		    }

		
		private void sendTitleToAllPlayers(String title) {
	        for (Player player : Bukkit.getOnlinePlayers()) {
	            player.sendTitle(ChatColor.GREEN + title, "", 0, 20, 10);
	        }
	    }
	}
		
		public static class PunishmentPicker extends ChatCommand{
			public PunishmentPicker(String command){
				super(command);
				   names.add("Item theft(3)");
		            names.add("More mobs");
		            names.add("New event");
		            names.add("Item theft(2)");
		            names.add("NullDamage for 10Minutes");
		    		this.helpMaterial = Material.NETHERITE_AXE;
			}
		
			private ArrayList<String> names = new ArrayList<>();
			    private Random random = new Random();
			
			@Override
			public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
			         

			            BukkitRunnable titleRunnable = new BukkitRunnable() {
			                int ticksPassed = 0;
			                int maxTicks = 60; 

			                @Override
			                public void run() {
			                    if (ticksPassed >= maxTicks) {
			                        cancel();
			                        String selectedName = names.get(random.nextInt(names.size()));
			                        sendTitleToAllPlayers(selectedName);
			                        return;
			                    }

			                    shuffleArrayList(names);
			                    String currentName = names.get(0);

			                    sendTitleToAllPlayers(currentName);

			                    ticksPassed++;
			                }
			            };

			            titleRunnable.runTaskTimer(PluginMain.instance, 0, 2); 

				return false;
			}
		
		  private void shuffleArrayList(ArrayList<String> list) {
		        int n = list.size();
		        for (int i = 0; i < n; i++) {
		            int j = random.nextInt(n);
		            String temp = list.get(i);
		            list.set(i, list.get(j));
		            list.set(j, temp);
		        }
		    }

		
		private void sendTitleToAllPlayers(String title) {
	        for (Player player : Bukkit.getOnlinePlayers()) {
	            player.sendTitle("§c" + title, "", 0, 20, 10);
	        }
	    }
	}
	
	public static class ConsoleSudo extends ChatCommand{

	public ConsoleSudo(String command) {
		super(command);
		
	}

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		Player p = (Player) arg0;
		
		if(arg3.length < 1)
			p.sendMessage(PluginMain.PR+"§cPlease use /consolesudo <Command>");
		else {
			String finalMessage = "";
			for(int i = 0;i < arg3.length;i++) {
				finalMessage = finalMessage+arg3[i]+" ";
			}
			
			Send(finalMessage);
		}

		return false;
	}
	
	public void Send(String finalMessage) {
		try {
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), finalMessage);
		}catch(Exception e) {
			Bukkit.getConsoleSender().sendMessage("§4Expection: §7"+e.getMessage());
		}
	}

}


}
