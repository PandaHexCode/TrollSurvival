package PandaHexCode.Commands;

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
	public static void Register(){
		freeze = new ChatCommandArray("freeze");
		freezeRotation = new ChatCommandArray("freezerotation");
		
		disablebreak = new ChatCommandArray("disablebreak");
		disablebuild = new ChatCommandArray("disablebuild");
		disabledrop = new ChatCommandArray("disabledrop");
		disablepickup = new ChatCommandArray("disablepickup");
		disablegravity = new ChatCommandArray("disablegravity");
		
		explosionbreak = new ChatCommandArray("explosionbreak");
		ultrabreak = new ChatCommandArray("ultrabreak");
		
		instantkillmobs = new ChatCommandArray("instantkillmobs");
		nulldamage = new ChatCommandArray("nulldamage");
		
		mute = new ChatCommandArray("mute");
		
		commandspy = new ChatCommandArray("commandspy");
		
		superjumpboost = new ChatCommandArray("superjumpboost");
		ultraknockback = new ChatCommandArray("ultraknockback");
		
		limitedcreative = new ChatCommandArray("limitedcreative");
		
		dirtterrain = new ChatCommandArray("dirtterrain");
		glide = new ChatCommandArray("glide");
		movelag = new ChatCommandArray("movelag");
		autojump = new ChatCommandArray("autojump");
	}
	
}
