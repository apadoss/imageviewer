package software.ulpgc.imageviewer;

public class ImagePresenter {
    private final ImageDisplay display;
    private Image image;

    public ImagePresenter(ImageDisplay display) {
        this.display = display;
        this.display.on((Shift) this::shift);
        this.display.on((Released) this::released);
    }

    private void shift(int offset) {
        display.clear();
        display.paint(image.id(), offset);
        if (offset > 0)
            display.paint(image.previous().id(), offset - display.getWidth());
        else
            display.paint(image.next().id(), offset + display.getWidth());
    }

    private void released(int offset) {
        if (Math.abs(offset) >= 0.5 * display.getWidth())
            image = offset > 0 ? image.next() : image.previous();
        repaint();
    }

    private void show(Image image) {
        this.image = image;
        repaint();
    }

    private void repaint() {
        display.clear();
        display.paint(image.id(), 0);
    }
}
