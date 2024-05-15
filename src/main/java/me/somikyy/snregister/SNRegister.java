package me.somikyy.snregister;

import me.somikyy.snregister.Commands.ForgotPasswordCommand;
import me.somikyy.snregister.Commands.LoginCommand;
import me.somikyy.snregister.Commands.RegisterCommand;
import me.somikyy.snregister.User.UserManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class SNRegister extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        UserManager userManager = new UserManager();

        // Registering commands
        this.getCommand("register").setExecutor(new RegisterCommand(userManager));
        this.getCommand("login").setExecutor(new LoginCommand(userManager));
        this.getCommand("forgotpassword").setExecutor(new ForgotPasswordCommand(userManager));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
