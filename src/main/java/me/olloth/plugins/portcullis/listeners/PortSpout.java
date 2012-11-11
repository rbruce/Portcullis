package me.olloth.plugins.portcullis.listeners;

import me.olloth.plugins.portcullis.Portcullis;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.event.spout.ServerTickEvent;
import org.getspout.spoutapi.event.spout.SpoutCraftEnableEvent;
import org.getspout.spoutapi.gui.Color;
import org.getspout.spoutapi.player.SkyManager;
import org.getspout.spoutapi.player.SpoutPlayer;

public class PortSpout implements Listener {

	Portcullis plugin;
	long count;

	public PortSpout(Portcullis plugin) {
		count = 0;
		this.plugin = plugin;
	}

	@EventHandler
	public void onSpoutCraftEnable(SpoutCraftEnableEvent event) {
		final SpoutPlayer player = event.getPlayer();
		SkyManager sm = SpoutManager.getSkyManager();

		player.resetTexturePack();
		player.setCanFly(true);
		// player.setTexturePack("http://dl.dropbox.com/u/40267690/Archive.zip");
		player.setGravityMultiplier(0.167);

		sm.setCloudsVisible(player, false);
		sm.setSunVisible(player, false);
		sm.setStarsVisible(player, true);
		sm.setSkyColor(player, new Color(0, 0, 0));

	}

	@EventHandler
	public void onServerTick(ServerTickEvent event) {
		if (count % 20 == 0) {
			plugin.getServer().getWorld("world").setTime(18000);
		}
		count++;
	}

}
