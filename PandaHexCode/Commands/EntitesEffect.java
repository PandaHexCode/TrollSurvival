package PandaHexCode.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import PandaHexCode.PluginMain;

public class EntitesEffect extends ChatCommand{

	public EntitesEffect(String command) {
		super(command);
	}

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		Player p = (Player) arg0;
		if(arg3.length < 3)
			p.sendMessage(PluginMain.PR+"§cPlease use /entitieseffect <EffectName> <Duration> <power>");
		else {
			int duration = 60;
			duration = Integer.parseInt(arg3[1]);
			int power = 1;
			power = Integer.parseInt(arg3[2]);
			
			PotionEffectType ef = PluginMain.GetPotionByName(arg3[0]);
			if(ef == null) {
				p.sendMessage(PluginMain.PR+"§c"+arg3[0]+" is not a vaild PotionEffectType!");
				return false;
			}
			
			for(Entity e : p.getWorld().getEntities()) {
				  if(!(e instanceof Player)){
					  try {
						  LivingEntity en = (LivingEntity) e;
						  PotionEffect potionEffect = new PotionEffect(ef, duration, power, false, false);
						  en.addPotionEffect(potionEffect);
					  }catch(Exception ex) {
						  Bukkit.getConsoleSender().sendMessage(ex.getMessage());
					  }
				  }
			}
			
			p.sendMessage(PluginMain.PR+"All Entites have now the Effect §e"+arg3[0]+"§2!");
		}
		

		return false;
	}
	
	public static class ClearEntitiesEffect extends ChatCommand{
		public ClearEntitiesEffect(String command) {
			super(command);
		}
		
		@Override
		public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
			Player p = (Player) arg0;
				
				for(Entity e : p.getWorld().getEntities()) {
					  if(!(e instanceof Player)){
						  try {
							  LivingEntity en = (LivingEntity) e;
							  for (PotionEffectType type : PotionEffectType.values()) {
								  en.removePotionEffect(type);
						       }
						  }catch(Exception ex) {
							  Bukkit.getConsoleSender().sendMessage(ex.getMessage());
						  }
					  }
				}
				
				p.sendMessage(PluginMain.PR+"Cleared!");
			
			

			return false;
		}
		
	}
	
}
