package software.ulpgc.imageviewer;

public interface ImageDisplay {
    void show(Image image, int offset);
    Image image();
    int getWidth();
    void clear();
    void on(Shift shift);
    void on(Released released);
    void on(Pressed pressed);
}
