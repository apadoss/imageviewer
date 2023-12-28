package software.ulpgc.imageviewer;

public interface ImageDisplay {
    void paint(String id, int offset);
    int getWidth();
    void clear();
    void on(Shift shift);
    void on(Released released);
}
