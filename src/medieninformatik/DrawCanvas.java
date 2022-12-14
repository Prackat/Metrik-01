package medieninformatik;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Stack;

class CanvasMouse implements MouseListener {

    DrawCanvas drawCanvas;
    int clickcount= 0;

    CanvasMouse(DrawCanvas dc) {
        drawCanvas = dc;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2){
            if (clickcount == 2){
                drawCanvas.popCircle();
                clickcount = 0;
            }
            else {
                    clickcount++;
                    drawCanvas.drawCircle(new Point(e.getX(), e.getY()));
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }
}

public class DrawCanvas extends Canvas {

    private Stack<Point> circles = new Stack<>();

    private int circleSize = 100;

    public DrawCanvas(int w, int h) {
        setBackground(Color.lightGray);
        setSize(w, h);

        this.addMouseListener(new CanvasMouse(this));
    }

    public void drawCircle(Point c) {
        if (circles.size() < 2) {
            this.circles.push(c);
            this.repaint();
        }
    }

    public void popCircle() {
        if (this.circles.empty()) {
            return;
        }

        this.circles = new Stack<>();
        this.repaint();
    }

    public void paint(Graphics g) {
        int offset = 0;
        for (Point p : this.circles) {
            g.fillOval(p.x - circleSize / 2, p.y - circleSize / 2, circleSize, circleSize);
            g.drawString("X: " + p.x + "  Y: " + p.y, 20, 60 + 20 * offset);
            offset++;
        }

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(4));

        if (this.circles.size() == 2) {
            Point p1 = this.circles.get(0);
            Point p2 = this.circles.get(1);

            g2.drawLine(p1.x, p1.y, p2.x, p2.y);

            g.drawString("Distance: " + (int) p1.distance(p2), 20, 540);
        }
    }

    public void setCircleSize(int circleSize) {
        this.circleSize = circleSize;
    }
}