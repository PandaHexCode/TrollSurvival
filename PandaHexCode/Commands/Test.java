package PandaHexCode.Commands;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.command.Command;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import PandaHexCode.PluginMain;

public class Test extends ChatCommandTarget{

	public Test(String command){
		super(command);
	}
	
	@Override
	public void onNewCommand(Player sender, Player otherPlayer, Command command, String[] arg){
		sender.getWorld().generateTree(otherPlayer.getLocation(), TreeType.BIG_TREE);
	}

}
