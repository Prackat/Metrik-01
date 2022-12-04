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
                drawCanvas.popRectangle();
                clickcount = 0;
            }
            else {
                    clickcount++;
                    drawCanvas.drawRectangle(new Point(e.getX(), e.getY()));

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

    private Stack<Point> rectangles = new Stack<>();

    private int rectangleSize = 100;

    public DrawCanvas(int w, int h) {
        setBackground(Color.lightGray);
        setSize(w, h);

        this.addMouseListener(new CanvasMouse(this));
    }

    public void drawRectangle(Point c) {
        if (rectangles.size() < 2) {
            this.rectangles.push(c);
            this.repaint();
        }
    }

    public void popRectangle() {
        if (this.rectangles.empty()) {
            return;
        }

        this.rectangles = new Stack<>();
        this.repaint();
    }

    public void paint(Graphics g) {
        for (Point p : this.rectangles) {
            g.fillRect(p.x - rectangleSize / 2, p.y - rectangleSize / 2, rectangleSize, rectangleSize);
        }

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(4));
    }
}