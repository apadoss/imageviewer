package software.ulpgc.imageviewer;

public interface Shift {
    Shift Null = offset -> {};
    void offset(int offset);
}
