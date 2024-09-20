package fr.alexis.report.api.database;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class PlayerListener {

    public static boolean hasPlayerJoinedBefore(String playerName) {
        // Le chemin vers le fichier usercache.json dans le dossier du serveur
        String filePath = "usercache.json"; // Chemin vers le fichier usercache.json

        try (FileReader reader = new FileReader(filePath)) {
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Map<String, Object>>>(){}.getType();
            List<Map<String, Object>> userCacheList = gson.fromJson(reader, listType);

            for (Map<String, Object> user : userCacheList) {
                String cachedName = (String) user.get("name");
                if (cachedName.equalsIgnoreCase(playerName)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
