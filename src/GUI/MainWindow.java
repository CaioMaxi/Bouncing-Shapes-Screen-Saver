package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainWindow extends JFrame {
    private static final int CANVAS_WIDTH = 700;
    private static final int CANVAS_HEIGHT = 700;
    private static final int UPDATE_INTERVAL = 50;

    //    Getters:
    public static int getCanvasWidth() {
        return CANVAS_WIDTH;
    }

    public static int getCanvasHeight() {
        return CANVAS_HEIGHT;
    }

    public static int getUpdateInterval() {
        return UPDATE_INTERVAL;
    }

    //    Set bounds of the main window and creates and adds the screen saver to the main panel
    public MainWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 100, getCanvasWidth(), getCanvasHeight());
        setTitle("Java OOP Screensaver");

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        ScreenSaver screen = new ScreenSaver();
        contentPane.add(screen);
        screen.setLayout(null);
    }
}
