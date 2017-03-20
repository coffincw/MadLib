import java.awt.*;
import javax.swing.*;

/**
 * Created by caleb on 3/20/17.
 */
public class MLibPanel extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // g.drawString("HELLO WORLD", 10, 150);

        // g.setColor(Color.WHITE);
    }
    public void erase() {
        getGraphics().clearRect(0, 0, getWidth(), getHeight() );
    }

    public void drawRandomCircle() {
        int width = getWidth();
        int height = getHeight();
        int x = (int) (Math.random() * width);
        int y = (int) (Math.random() * height);
        int radius = (int) (Math.random() * (width - x));
        Graphics g = getGraphics();

        g.setColor(new Color((int) (Math.random() * 256),
                (int) (Math.random() * 256),
                (int) (Math.random() * 256)));
        g.fillOval(x, y, radius, radius);

    }
}
