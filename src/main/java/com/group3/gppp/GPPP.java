package com.group3.gppp;

import com.group3.gppp.enchants.TestEnchant;
import com.group3.gppp.events.EventListener;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.HashMap;

public final class GPPP extends JavaPlugin {

    public static Enchantment enchantOne;
    @Override
    public void onEnable() {
        // On plugin startup (register everything here)
        loadEnchantments();
        new EventListener(this);
    }

    @Override
    public void onDisable() {
        // On plugin shutdown
        unloadEnchantments();
    }

    private void loadEnchantments() {
        enchantOne = new TestEnchant(101);
        try {
            try {
                Field f = Enchantment.class.getDeclaredField("acceptingNew");
                f.setAccessible(true);
                f.set(null, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Enchantment.registerEnchantment(enchantOne);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void unloadEnchantments() {
        try {
            Field byIdField = Enchantment.class.getDeclaredField("byId");
            Field byNameField = Enchantment.class.getDeclaredField("byName");

            byIdField.setAccessible(true);
            byNameField.setAccessible(true);

            HashMap<Integer, Enchantment> byId = (HashMap<Integer, Enchantment>) byIdField.get(null);
            HashMap<Integer, Enchantment> byName = (HashMap<Integer, Enchantment>) byNameField.get(null);

            if (byId.containsKey(enchantOne.getId())) byId.remove(enchantOne.getId());
            if (byName.containsKey(enchantOne.getName())) byId.remove(enchantOne.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
