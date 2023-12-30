package software.ulpgc.imageviewer;

public class ImagePresenter {
    private final ImageDisplay display;
    private Image image;

    public ImagePresenter(Image image, ImageDisplay display) {
        this.display = display;
        this.image = image;
        this.display.on((Shift) this::shift);
        this.display.on((Released) this::released);
        this.display.on((Pressed) this::pressed);
        this.display.clear();
    }

    private void pressed(int offset) {this.image = this.display.image();}

    private void shift(int offset) {
        display.clear();
        display.show(image, offset);
        if (offset > 0)
            display.show(image.previous(), offset - display.getWidth());
        else
            display.show(image.next(), offset + display.getWidth());
    }

    private void released(int offset) {
        if (Math.abs(offset) >= 0.5 * display.getWidth())
            image = offset > 0 ? image.previous() : image.next();
        repaint();
    }

    public void show() {
        repaint();
    }

    private void repaint() {
        display.clear();
        display.show(image, 0);
    }
}
