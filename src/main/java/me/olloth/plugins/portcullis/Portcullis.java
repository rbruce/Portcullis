package me.olloth.plugins.portcullis;

import me.olloth.plugins.portcullis.blocks.Blocks;
import me.olloth.plugins.portcullis.generators.PortGenerator;
import me.olloth.plugins.portcullis.listeners.PortEntities;
import me.olloth.plugins.portcullis.listeners.PortPlayers;
import me.olloth.plugins.portcullis.listeners.PortSpout;
import me.olloth.plugins.portcullis.listeners.PortWeather;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Portcullis extends JavaPlugin {
	public static Portcullis instance;

	PluginManager pm;
	PortSpout spouts;
	PortEntities entities;
	PortWeather weathers;
	PortPlayers players;
	Blocks blocks;

	@Override
	public void onDisable() {
		System.out.println(this + " is now disabled!");
	}

	@Override
	public void onEnable() {
		instance = this;

		pm = getServer().getPluginManager();

		blocks = new Blocks();
		spouts = new PortSpout(this);
		entities = new PortEntities(this);
		weathers = new PortWeather(this);
		players = new PortPlayers(this);

		pm.registerEvents(entities, this);
		pm.registerEvents(players, this);
		pm.registerEvents(spouts, this);
		pm.registerEvents(weathers, this);

		System.out.println(this + " is now enabled!");
	}

	@Override
	public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
		return new PortGenerator();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {

		return super.onCommand(sender, command, label, args);
	}
}
