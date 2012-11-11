package me.olloth.plugins.portcullis.listeners;

import me.olloth.plugins.portcullis.Portcullis;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

public class PortPlayers implements Listener {
	Portcullis plugin;

	public PortPlayers(Portcullis plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerToggleSneak(PlayerToggleSneakEvent event) {
		SpoutPlayer player = SpoutManager.getPlayer(event.getPlayer());
		if (event.isSneaking()) {
			player.setJumpingMultiplier(0.5);
		} else {
			player.setJumpingMultiplier(1);
		}
	}
}
