package com.group3.gppp.events;

import com.group3.gppp.GPPP;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class EventListener implements Listener {

    // constructor
    public EventListener(GPPP plugin) {
        System.out.println("this is working");
        plugin.getServer().getPluginManager().registerEvents(this,plugin);


    }

    @EventHandler
    public void onTossItem (PlayerDropItemEvent event) {
        String message = "";
        message += event.getPlayer().getName();
        message += " dropped ";
        message += event.getItemDrop().getItemStack().getAmount();
        message += " " + event.getItemDrop().getName() + "(s)";
        System.out.println(message);
        event.getPlayer().sendMessage(message);
    }

}
