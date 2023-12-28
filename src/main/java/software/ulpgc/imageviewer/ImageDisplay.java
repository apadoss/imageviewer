package software.ulpgc.imageviewer;

public interface ImageDisplay {
    void show(String id, int offset);
    int getWidth();
    void clear();
    void on(Shift shift);
    void on(Released released);
}
