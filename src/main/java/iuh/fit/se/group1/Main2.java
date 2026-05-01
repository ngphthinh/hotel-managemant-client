package iuh.fit.se.group1;


import iuh.fit.se.group1.network.client.AppSocketManager;
import iuh.fit.se.group1.ui.swing.AdvancedSplashScreen;
import iuh.fit.se.group1.util.PropertiesReader;

import javax.swing.*;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;


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
        if (AppSocketManager.initialize(PropertiesReader.getInstance().get("server.host"), Integer.parseInt(PropertiesReader.getInstance().get("server.port")))) {
            System.out.println("✓ Socket connected successfully!");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Không thể kết nối đến server. Vui lòng thử lại sau.",
                    "Lỗi kết nối",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println("✗ Warning: Socket connection failed. Is TestServer running?");
            return;
        }

        // Add shutdown hook for cleanup
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down...");
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