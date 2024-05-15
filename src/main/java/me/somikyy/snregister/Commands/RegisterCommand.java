package me.somikyy.snregister.Commands;

import me.somikyy.snregister.User.UserManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RegisterCommand implements CommandExecutor{
    private final UserManager userManager;

    public RegisterCommand(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("You must be a player to execute this command!");
            return true;
        }

        Player player = (Player) sender;

        if(args.length != 2){
            player.sendMessage(ChatColor.RED + "Usage: /register <password> <confirm password>");
            return true;
        }

        String password = args[0];

        userManager.registerUser(player.getName(), password);

        player.sendMessage(ChatColor.GREEN + "You have successfully registered!");

        return true;
    }
}
