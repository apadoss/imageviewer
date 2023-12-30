package software.ulpgc.imageviewer.swing;

import software.ulpgc.imageviewer.FileImageLoader;
import software.ulpgc.imageviewer.Image;
import software.ulpgc.imageviewer.ImagePresenter;
import software.ulpgc.imageviewer.mock.MockImageLoader;

import java.io.File;

public class Main {
    private static final String folder = "C:/Users/Alejandro/Pictures/Nueva Carpeta";

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        Image image = new FileImageLoader(new File(folder)).load();
        ImagePresenter presenter = new ImagePresenter(image, frame.getImageDisplay());
        presenter.show();
        frame.setVisible(true);
    }
}
