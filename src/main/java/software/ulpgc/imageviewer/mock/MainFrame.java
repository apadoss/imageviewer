package software.ulpgc.imageviewer.mock;

import software.ulpgc.imageviewer.ImageDisplay;
import software.ulpgc.imageviewer.swing.SwingImageDisplay;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private ImageDisplay imageDisplay;

    public MainFrame() {
        this.setTitle("Image Viewer");
        this.setSize(1920, 1080);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(createImageDisplay());
    }

    private Component createImageDisplay() {
        SwingImageDisplay display = new SwingImageDisplay();
        this.imageDisplay = display;
        return display;
    }

    public ImageDisplay getImageDisplay() {
        return this.imageDisplay;
    }
}
