package com.github.huda0209.usefulcommandsbdevdojo;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class UsefulCommandsBDevDojo extends JavaPlugin implements CommandExecutor{

    @Override
    public void onEnable() {
        getCommand("heal").setExecutor(new healCMDExecutor());
        getCommand("broadcast").setExecutor(new broadcastCMDExecutor());
        getCommand("loc").setExecutor(new locCMDExecutor());

        String[] EnableMessage = {"=============================","Plugin Name : "+this.getDescription().getName() ,"Author : "+ this.getDescription().getAuthors(),"============================="};
        for (String s : EnableMessage) {
            getLogger().info(s);
        }
    }

    @Override
    public void onDisable() {
        getLogger().info(this.getDescription().getName()+" was disable.");
    }

    private class healCMDExecutor implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if(!sender.hasPermission("UsefulCommandsBDevDojo.command.heal")){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cYou don't have permission!"));
                return true;
            }
            if(!(sender instanceof Player)){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cThis command can use player only!"));
                return true;
            }
            Player player = (Player) sender;
            double maxHealth = player.getAttribute(Attribute.valueOf("GENERIC_MAX_HEALTH")).getValue();
            player.setHealth(maxHealth);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&aYou are Healed."));
            return true;
        }
    }

    private class broadcastCMDExecutor implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if(!sender.hasPermission("UsefulCommandsBDevDojo.command.broadcast")){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cYou don't have permission!"));
                return true;
            }
            if(args[0]==null){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cMessage  ."));
                return true;
            }
            String message = "&6[&eお知らせ&6] &r"+args[0];
            sender.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&',message));
            return true;
        }

    }
}
