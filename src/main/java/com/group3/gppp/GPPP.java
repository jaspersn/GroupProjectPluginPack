package com.group3.gppp;

import com.group3.gppp.events.EventListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class GPPP extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        new EventListener(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
