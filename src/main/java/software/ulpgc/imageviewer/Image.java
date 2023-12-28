package software.ulpgc.imageviewer;

public interface Image {
    String id();
    Image previous();
    Image next();
}
