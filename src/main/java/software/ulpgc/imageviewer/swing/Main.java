package software.ulpgc.imageviewer.swing;

import software.ulpgc.imageviewer.FileImageLoader;
import software.ulpgc.imageviewer.Image;
import software.ulpgc.imageviewer.ImagePresenter;
import software.ulpgc.imageviewer.mock.MockImageLoader;

import java.io.File;

public class Main {
    private static final String folder = "C:/Users/Alejandro/Pictures";

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        ImagePresenter presenter = new ImagePresenter(frame.getImageDisplay());
        presenter.show(image());
        frame.setVisible(true);
    }

    private static Image image() {
        return new FileImageLoader(new File(folder)).load();
    }
}
