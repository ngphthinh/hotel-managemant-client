package iuh.fit.se.group1;


import iuh.fit.se.group1.network.client.AppSocketManager;
import iuh.fit.se.group1.ui.swing.AdvancedSplashScreen;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;


@Slf4j
public class Main2 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");

        // Initialize Socket Client Connection
        System.out.println("Initializing socket connection...");
        if (AppSocketManager.initialize("LAPTOP-Q1PTRMJM", 3637)) {
            log.info("Socket connected successfully!");
        } else {
            log.error("Socket connection failed!");
        }

        // Add shutdown hook for cleanup
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down application...");
            AppSocketManager.shutdown();
        }));

        CountDownLatch latch = new CountDownLatch(1);


        latch.countDown();
        // Hiển thị splash screen
        SwingUtilities.invokeLater(() -> {
            new AdvancedSplashScreen(latch).setVisible(true);
        });
    }
}