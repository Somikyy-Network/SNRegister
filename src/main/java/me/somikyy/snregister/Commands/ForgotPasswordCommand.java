package me.somikyy.snregister.Commands;

import me.somikyy.snregister.User.UserManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.security.SecureRandom;

public class ForgotPasswordCommand implements CommandExecutor{

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static SecureRandom RANDOM = new SecureRandom();
    private final UserManager userManager;

    public ForgotPasswordCommand(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You must be a player to execute this command!");
            return true;
        }

        Player player = (Player) sender;

        String temporaryPassword = generateTemporaryPassword(8);

        userManager.resetPassword(player.getName(), temporaryPassword);

        player.sendMessage("Your temporary password is: " + temporaryPassword);

        return true;
    }

    private String generateTemporaryPassword(int length){
        StringBuilder password = new StringBuilder(length);
        for(int i = 0; i < length; i++){
            password.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return password.toString();
    }
}