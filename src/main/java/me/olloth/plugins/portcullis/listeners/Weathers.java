package me.olloth.plugins.portcullis.listeners;

import me.olloth.plugins.portcullis.Portcullis;

import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.weather.WeatherListener;

public class Weathers extends WeatherListener {

	Portcullis plugin;

	public Weathers(Portcullis plugin) {
		this.plugin = plugin;
	}

	@Override
	public void onWeatherChange(WeatherChangeEvent event) {
		event.setCancelled(true);
	}
}
