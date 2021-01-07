package com.company.model;

import com.company.model.AbstractTaskList;
import com.company.model.Task;
import com.google.gson.Gson;

import java.io.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class TaskIO {
    private static Gson gson = new Gson();
    private static FileOutputStream fileOutputStream;
    private static FileInputStream fileInputStream;

    public static void writeBinary(AbstractTaskList tasks, File file) throws IOException {
        try{
            fileOutputStream = new FileOutputStream(file);
            write(tasks,fileOutputStream);
            fileOutputStream.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            fileOutputStream.close();
        }
    }

    public static void readBinary(AbstractTaskList tasks, File file) throws IOException {
        try {
            fileInputStream = new FileInputStream(file);
            read(tasks,fileInputStream);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            fileInputStream.close();
        }
    }


    public static void write(AbstractTaskList tasks, OutputStream out) throws IOException {
        try (DataOutputStream outs = new DataOutputStream(out)) {
            outs.writeInt(tasks.size());
            tasks.getStream().forEach(task -> {
                try {
                    outs.writeUTF(task.getTitle());
                    outs.writeInt(task.getTime().getNano());
                    outs.writeInt(task.getStartTime().getNano());
                    outs.writeInt(task.getEndTime().getNano());
                    outs.writeInt(task.getRepeatInterval());
                    outs.writeBoolean(task.isActive());
                    outs.writeBoolean(task.isRepeated());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            });
        }
    }

    public static void read(AbstractTaskList tasks, InputStream in) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(in);
        try {
            int count = dataInputStream.readInt();
            for (int i = 0; i < count; i++) {
                String title = dataInputStream.readUTF();
                LocalDateTime time = LocalDateTime.ofEpochSecond(dataInputStream.readInt(), 0, ZoneOffset.UTC);
                LocalDateTime from = LocalDateTime.ofEpochSecond(dataInputStream.readInt(), 0, ZoneOffset.UTC);
                LocalDateTime to = LocalDateTime.ofEpochSecond(dataInputStream.readInt(), 0, ZoneOffset.UTC);
                int repeatInterval = dataInputStream.readInt();
                if (dataInputStream.readBoolean()) {
                    Task task = new Task(title, from, to, repeatInterval);
                    task.setActive(dataInputStream.readBoolean());
                    tasks.add(task);
                } else {
                    Task task = new Task(title, time);
                    task.setActive(dataInputStream.readBoolean());
                    tasks.add(task);
                }
            }
        } finally {
            dataInputStream.close();
        }
    }


    public static void writeText(AbstractTaskList tasks, File file) {
        String line = gson.toJson(tasks);
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(line);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readText(AbstractTaskList tasks, File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            AbstractTaskList list = new Gson().fromJson(line, tasks.getClass());
            list.getStream().forEach(tasks::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(AbstractTaskList tasks, Writer out) throws IOException {
        gson.toJson(tasks, out);
        out.flush();
    }

    public static void read(AbstractTaskList tasks, Reader in) throws IOException {
        AbstractTaskList task = gson.fromJson(in, tasks.getClass());
        task.getStream().forEach(tasks::add);
    }
}