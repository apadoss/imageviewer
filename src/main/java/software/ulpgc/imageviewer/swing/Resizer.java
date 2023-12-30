package software.ulpgc.imageviewer.swing;

import java.awt.*;

public class Resizer {
    private final Dimension dimension;

    public Resizer(Dimension dimension) {
        this.dimension = dimension;
    }

    public Dimension resize(Dimension imageDimension) {
        double ratio = Math.min(dimension.getWidth() / imageDimension.getWidth(), dimension.getHeight() / imageDimension.getHeight());
        return new Dimension((int) (imageDimension.getWidth() * ratio), (int) (imageDimension.getHeight() * ratio));
    }
}
