package com.company.model;

import com.company.view.Notification;
import com.google.gson.Gson;
import java.io.*;

public class TaskIO {
    private static Gson gson = new Gson();

    public static void writeText(AbstractTaskList tasks, File file) {
        String line = gson.toJson(tasks);
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(line);
            fileWriter.flush();
        } catch (IOException e) {
            Notification.logger.warn("File does not exist and will be created.");
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                Notification.logger.error(ioException);
            }
        }
    }

    public static void readText(AbstractTaskList tasks, File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            AbstractTaskList list = new Gson().fromJson(line, tasks.getClass());
            list.getStream().forEach(tasks::add);
        } catch (IOException e) {
            Notification.logger.warn("File does not exist and will be created.");
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                Notification.logger.error(ioException);
            }
        }catch (NullPointerException s){
            Notification.emptyList();
        }
    }
}