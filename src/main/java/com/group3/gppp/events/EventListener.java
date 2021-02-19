package com.group3.gppp.events;

import com.group3.gppp.GPPP;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class EventListener implements Listener {

    // constructor
    public EventListener(GPPP plugin) {
        System.out.println("EventListener loaded.");
        plugin.getServer().getPluginManager().registerEvents(this, plugin);

    }
    // test event that prints the item you are throwing and quantity
    @EventHandler
    public void onTossItem (PlayerDropItemEvent event) {
        Player p = event.getPlayer();
        Item droppedItem = event.getItemDrop();

        String message = p.getName() + " dropped " + droppedItem.getItemStack().getAmount() + " " + droppedItem + "(s).";
        System.out.println(message); // prints to console
        event.getPlayer().sendMessage(message); // prints to server chat
    }

    // runs when item is used (durability goes down) and has custom enchantment
    @EventHandler
    public void onMine(PlayerItemDamageEvent event) {
        Player p = event.getPlayer();
        boolean hasEnchantment = p.getInventory().getItemInMainHand().containsEnchantment(GPPP.enchantOne);
        if (hasEnchantment) p.sendMessage("Your pickaxe took " + event.getDamage() + " damage.");
    }

}
