package com.developercafe.files;

import org.json.JSONObject;

import java.io.*;
import java.util.Scanner;

public class Config {

    static File config;

    public static void init() throws IOException {
        config = new File("config.json");

        if (!config.exists()) {
            System.out.println("Es konnte keine Config gefunden werden, erstelle default Config!");
            config.createNewFile();
            JSONObject jsonObject = new JSONObject("{\"Token\": \"YOURBOTTOKEN\",\"Ticketcounter\": 0}");

            FileWriter configWriter = new FileWriter("config.json");
            configWriter.write(jsonObject.toString());
            configWriter.close();

        }

    }

    public static JSONObject getConfig() throws IOException {

        if (config == null) {
            init();
        }

        String configContent = null;
        Scanner configReader = new Scanner(config);
        while (configReader.hasNextLine()) {
            configContent = configReader.nextLine();
        }
        configReader.close();
        JSONObject jsonObject = new JSONObject(configContent);
        return jsonObject;
    }

    public static boolean writeConfig(String data) throws IOException {
        FileWriter configWriter = new FileWriter("config.json");
        configWriter.write(data);
        configWriter.close();
        return true;
    }

    public static String getToken() throws IOException {
        return getConfig().getString("Token");
    }

    public static int getTicketCounter() throws IOException {
        return getConfig().getInt("Ticketcounter");
    }

    public static boolean setTicketCounter(int number) throws IOException {
        JSONObject jsonObject = getConfig();
        jsonObject.put("Ticketcounter", number);
        return writeConfig(jsonObject.toString());
    }
}
