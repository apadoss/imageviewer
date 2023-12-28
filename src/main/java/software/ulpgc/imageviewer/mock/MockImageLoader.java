package software.ulpgc.imageviewer.mock;

import software.ulpgc.imageviewer.Image;
import software.ulpgc.imageviewer.ImageLoader;

public class MockImageLoader implements ImageLoader {
    private String[] ids = new String[] {"cyan", "purple", "yellow", "red", "green", "blue"};

    @Override
    public Image load() {
        return imageAt(0);
    }

    private Image imageAt(int i) {
        return new Image() {
            @Override
            public String id() {
                return ids[i];
            }

            @Override
            public Image previous() {
                return imageAt(i > 0 ? i - 1 : ids.length - 1);
            }

            @Override
            public Image next() {
                return imageAt((i + 1) % ids.length);
            }
        };
    }
}
