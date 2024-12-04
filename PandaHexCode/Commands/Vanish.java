package PandaHexCode.Commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import PandaHexCode.PluginMain;

public class Vanish extends ChatCommand{
	public Vanish(String command) {
		super(command);
		this.helpMaterial = Material.PLAYER_HEAD;
	}

	public static ArrayList<String> playersInVanish = new ArrayList<String>();
	
	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		Player p = (Player) arg0;
		if(arg3.length < 1)
			SwitchVanish(p,p,true);
		else {
		    if(Bukkit.getPlayer(arg3[0]) == null)
				p.sendMessage(PluginMain.PR+"§cThis Player is not online!");
			else {
				Player oPlayer = Bukkit.getPlayer(arg3[0]);
				SwitchVanish(oPlayer,p,false);
			}
		}
		return false;
	}
	
	@SuppressWarnings("deprecation")
	public void SwitchVanish(Player p,Player sender,boolean withEffect) {
		if(playersInVanish.contains(p.getName())) {
			for (Player pl : Bukkit.getOnlinePlayers())
				pl.showPlayer(p);;
			p.showPlayer(p);
			playersInVanish.remove(p.getName());
			sender.sendMessage(PluginMain.PR+"§b"+p.getName()+" is no longer in vanish!");
			p.removePotionEffect(PotionEffectType.INVISIBILITY);
		}else {
			for (Player pl : Bukkit.getOnlinePlayers())
				pl.hidePlayer(p);
			p.hidePlayer(p);
			if(withEffect)
				p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 100000,100000));
			playersInVanish.add(p.getName());
			sender.sendMessage(PluginMain.PR+"§b"+p.getName()+" is now in vanish!");
		}
	}
}
