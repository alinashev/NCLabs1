package com.company.view;

import com.company.model.Constants;
import com.company.model.Model;
import com.company.model.Task;
import com.company.model.Tasks;
import dorkbox.notify.Notify;
import org.apache.log4j.Logger;

import java.awt.*;
import java.util.Date;
import java.util.Iterator;

public class OSNotification extends Thread{
    private Model model;
    public static Logger logger = Logger.getLogger(OSNotification.class);

    /**
     * Instantiates a new Os notification.
     *
     * @param model the model object
     */
    public OSNotification(Model model) {
        this.model = model;
    }
    private SystemTray tray;
    private Image image;
    private TrayIcon trayIcon;

    public void run(){
        if(SystemTray.isSupported()){
            tray = SystemTray.getSystemTray();
            image = Toolkit.getDefaultToolkit().createImage("icon.png");
            trayIcon = new TrayIcon(image, "Notification");
            trayIcon.setImageAutoSize(true);
            trayIcon.setToolTip("Notification");
            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                logger.error("AWTException");
            }
        }
        while(true){
            try {
                sleep(30000);
            } catch (InterruptedException e) {
                logger.error("InterruptedException");
            }
            Iterable<Task> currTask = Tasks.incoming(model.getTaskList().clone(), new Date(new Date().getTime() - 45000), new Date());
            Iterator<Task> taskIterator = currTask.iterator();
            StringBuilder sb = new StringBuilder();
            while (taskIterator.hasNext()){
                Task task = taskIterator.next();
                sb.append(task.getTitle()).append("\n");
            }
            String message = sb.toString();
            if(message.length() != 0) {
                if(SystemTray.isSupported()) {
                    trayIcon.displayMessage("Notification", message, TrayIcon.MessageType.INFO);
                }
                else Notify.create().title("Notification").text(message).showInformation();
                System.out.println(Constants.ANSI_BLUE + "[Notification]: " + message + Constants.ANSI_RESET);
            }
        }
    }
}