package software.ulpgc.imageviewer.swing;

import software.ulpgc.imageviewer.Image;
import software.ulpgc.imageviewer.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SwingImageDisplay extends JPanel implements ImageDisplay {
    private int initShift;
    private Shift shift = Shift.Null;
    private Released released = Released.Null;
    private Pressed pressed = Pressed.Null;
    private List<Paint> paints = new ArrayList<>();
    private Image image;
    private BufferedImage bitmap;

    public SwingImageDisplay() {
        this.addMouseListener(mouseListener());
        this.addMouseMotionListener(mouseMotionListener());
    }

    private MouseMotionListener mouseMotionListener() {
        return new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {shift.offset(e.getX() - initShift);}

            @Override
            public void mouseMoved(MouseEvent e) {}
        };
    }

    private MouseListener mouseListener() {
        return new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                initShift = e.getX();
                pressed.offset(initShift);
            }

            @Override
            public void mouseReleased(MouseEvent e) {released.offset(e.getX() - initShift);}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
    }

    @Override
    public void show(Image image, int offset) {
        this.image = image;
        this.bitmap = load(image.id());
        paints.add(new Paint(image, offset));
        repaint();
    }

    private BufferedImage load(String id) {
        try {
            return ImageIO.read(new File(id));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Image image() {
        return image;
    }

    @Override
    public void clear() {paints.clear();}

    /* private static final Map<String, Color> colors = Map.of(
            "cyan", Color.CYAN,
            "magenta", Color.MAGENTA,
            "yellow", Color.YELLOW,
            "red", Color.RED,
            "green", Color.GREEN,
            "blue", Color.BLUE
    ); */

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        for (Paint paint : paints) {
            bitmap = load(paint.image.id());

            if (paint.image != null)
                g.drawImage(bitmap, paint.offset, 0, null);
        }
    }

    @Override
    public void on(Shift shift) {this.shift = shift != null ? shift : Shift.Null;}

    @Override
    public void on(Released released) {this.released = released != null ? released : Released.Null;}

    @Override
    public void on(Pressed pressed) {
        this.pressed = pressed != null ? pressed : Pressed.Null;
    }

    private record Paint(Image image, int offset) {
    }
}
