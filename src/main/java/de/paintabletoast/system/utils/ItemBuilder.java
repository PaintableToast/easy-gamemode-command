package de.paintabletoast.system.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemBuilder extends ItemStack {
    private ItemMeta itemmeta;
    public ItemBuilder(Material material) {
        super(material);
        itemmeta = this.getItemMeta();
    }
    public ItemBuilder(Material material, int amount) {
        super(material, amount);
        itemmeta = this.getItemMeta();
    }
    public ItemBuilder(Material material, int amount, byte subid) {
        super(material, amount, subid);
        itemmeta = this.getItemMeta();
    }
    public ItemBuilder setDisplayName(String displayName) {
        itemmeta.setDisplayName(displayName);
        this.setItemMeta(itemmeta);
        return this;
    }
    public String getDisplayName() {
        return itemmeta.getDisplayName();
    }
    public ItemBuilder setLore(String lore, String split) {
        itemmeta.setLore(Arrays.asList(lore.split(split)));
        this.setItemMeta(itemmeta);
        return this;
    }
    public ItemBuilder setLore(ArrayList<String> lore) {
        itemmeta.setLore(lore);
        this.setItemMeta(itemmeta);
        return this;
    }
    public ArrayList<String> getLore() {
        return (ArrayList<String>) itemmeta.getLore();
    }
    public ItemBuilder setCustomModelData(int customModelData) {
        this.setCustomModelData(customModelData);
        return this;
    }
    public int getCustomModelData() {
        return this.getCustomModelData();
    }
}
