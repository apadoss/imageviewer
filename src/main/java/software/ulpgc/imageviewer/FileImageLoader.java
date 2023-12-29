package software.ulpgc.imageviewer;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Set;

public class FileImageLoader implements ImageLoader{
    private File[] files;

    public FileImageLoader(File folder) {
        this.files = folder.listFiles(isImage());
    }

    private static final Set<String> imageExtensions = Set.of(".jpg", ".png");
    private FilenameFilter isImage() {
        return ((dir, name) -> imageExtensions.stream()
                .anyMatch(name::endsWith));
    }

    @Override
    public Image load() {
        return imageAt(0);
    }

    private Image imageAt(int i) {
        return new Image() {
            @Override
            public String id() {
                return files[i].getAbsolutePath();
            }

            @Override
            public Image previous() {
                return imageAt((i - 1 + files.length) % files.length);
            }

            @Override
            public Image next() {
                return imageAt((i + 1) % files.length);
            }
        };
    }
}
