package me.somikyy.snregister.Commands;

import me.somikyy.snregister.User.UserManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class LoginCommand implements CommandExecutor{
    private final UserManager userManager;

    public LoginCommand(UserManager userManager) {
        this.userManager = userManager;
    }
        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("You must be a player to execute this command!");
                return true;
            }

            Player player = (Player) sender;

            if (args.length != 1) {
                player.sendMessage("Usage: /login <password>");
                return true;
            }

            String password = args[0];

            userManager.registerUser(player.getName(), password);

            return true;
        }
}
