package PandaHexCode.Commands;

import org.bukkit.Material;

public class StandartArrayCommands{

	public static ChatCommandArray freeze;
	public static ChatCommandArray freezeRotation;

	public static ChatCommandArray disablebreak;
	public static ChatCommandArray disablebuild;
	public static ChatCommandArray disabledrop;
	public static ChatCommandArray disablepickup;
	public static ChatCommandArray disablegravity;
	
	public static ChatCommandArray explosionbreak;
	public static ChatCommandArray ultrabreak;
	
	public static ChatCommandArray instantkillmobs;
	public static ChatCommandArray nulldamage;
	
	public static ChatCommandArray mute;
	
	public static ChatCommandArray commandspy;
	
	public static ChatCommandArray superjumpboost;
	public static ChatCommandArray ultraknockback;
	
	public static ChatCommandArray limitedcreative;
	
	public static ChatCommandArray dirtterrain;
	public static ChatCommandArray glide;
	public static ChatCommandArray movelag;
	public static ChatCommandArray autojump;
	
	public static ChatCommandArray clientSidePlaceArray;
	public static void Register(){
		freeze = new ChatCommandArray("freeze", Material.ICE);
		freezeRotation = new ChatCommandArray("freezerotation", Material.ICE);
		
		disablebreak = new ChatCommandArray("disablebreak", Material.BARRIER);
		disablebuild = new ChatCommandArray("disablebuild", Material.BARRIER);
		disabledrop = new ChatCommandArray("disabledrop", Material.BARRIER);
		disablepickup = new ChatCommandArray("disablepickup", Material.BARRIER);
		disablegravity = new ChatCommandArray("disablegravity", Material.BARRIER);
		
		explosionbreak = new ChatCommandArray("explosionbreak", Material.TNT);
		ultrabreak = new ChatCommandArray("ultrabreak", Material.NETHERITE_PICKAXE);
		
		instantkillmobs = new ChatCommandArray("instantkillmobs", Material.NETHERITE_SWORD);
		nulldamage = new ChatCommandArray("nulldamage", Material.WOODEN_SWORD);
		
		mute = new ChatCommandArray("mute", Material.BARRIER);
		
		commandspy = new ChatCommandArray("commandspy", Material.PLAYER_HEAD);
		
		superjumpboost = new ChatCommandArray("superjumpboost", Material.SLIME_BLOCK);
		ultraknockback = new ChatCommandArray("ultraknockback", Material.WOODEN_AXE);
		
		limitedcreative = new ChatCommandArray("limitedcreative", Material.BARRIER);
		
		dirtterrain = new ChatCommandArray("dirtterrain", Material.DIRT);
		glide = new ChatCommandArray("glide", Material.ELYTRA);
		movelag = new ChatCommandArray("movelag", Material.BLUE_ICE);
		autojump = new ChatCommandArray("autojump", Material.PLAYER_HEAD);
		
		clientSidePlaceArray = new ChatCommandArray("clientsideplacearray", Material.PLAYER_HEAD);
	}
	
}
