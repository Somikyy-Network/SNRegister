package me.somikyy.snregister.User;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private final Map<String, String> users = new HashMap<>();

    public void registerUser(String username, String password){
        users.put(username, password);
    }

    public boolean authenticateUser(String username, String password){
        String storedPassword = users.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }

    public void resetPassword(String username, String newPassword){
        users.put(username, newPassword);
    }
}
