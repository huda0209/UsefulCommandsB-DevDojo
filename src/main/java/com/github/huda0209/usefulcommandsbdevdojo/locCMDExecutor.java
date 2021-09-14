package com.github.huda0209.usefulcommandsbdevdojo;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Locale;

public class locCMDExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if((sender instanceof Player) && args.length==0){
            if(!sender.hasPermission("UsefulCommandsBDevDojo.command.loc.own")){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cYou don't have permission!"));
                return true;
            }
            Player player = (Player) sender;
            String WorldName = "World:"+player.getWorld().getName();
            String Location = "X:"+player.getLocation().getX()+" Y:"+player.getLocation().getY()+" Z:"+player.getLocation().getZ()+" Yaw:"+player.getLocation().getYaw()+" Pitch:"+player.getLocation().getPitch();
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',WorldName+" "+Location));
        }else if(args.length==1){
            Player player = sender.getServer().getPlayer(args[0]);
            if(!sender.hasPermission("UsefulCommandsBDevDojo.command.loc.other") && !player.getName().equalsIgnoreCase(args[0].toLowerCase(Locale.ROOT))){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cYou don't have permission!"));
                return true;
            }
            if(player == null){
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cUnknown player name."));
                return true;
            }
            if(!player.getName().equalsIgnoreCase(args[0])){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cThe player's name did not match the name specified in the command."));
                return true;
            }
            String WorldName = "World:"+player.getWorld().getName();
            String Location = "X:"+player.getLocation().getX()+" Y:"+player.getLocation().getY()+" Z:"+player.getLocation().getZ()+" Yaw:"+player.getLocation().getYaw()+" Pitch:"+player.getLocation().getPitch();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&a"+player.getDisplayName()+" location"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',WorldName+" "+Location));
        }else{
            if(!sender.hasPermission("UsefulCommandsBDevDojo.command.loc.own") && !sender.hasPermission("UsefulCommandsBDevDojo.command.loc.other")){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cYou don't have permission!"));
                return true;
            }
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cThis is not the way the command is supposed to be used."));
        }
        return true;
    }
}
