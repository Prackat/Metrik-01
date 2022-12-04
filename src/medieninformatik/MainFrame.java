package medieninformatik;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class FrameAdapter extends WindowAdapter {

    Frame frame;

    FrameAdapter(Frame f) {
        frame = f;
    }

    public void windowClosing(WindowEvent we) {
        frame.dispose();
    }
}

public class MainFrame extends Frame {

    //Constructor
    MainFrame() {

        // Frame

        //Aufruf des Constructors von Frame
        super("Metrik 1.0");

        this.setLayout(null);
        this.setSize(800, 600);
        this.setVisible(true);
        this.setResizable(false);
        setLocationRelativeTo(null);

        this.addWindowListener(new FrameAdapter(this));

        // Canvas

        DrawCanvas c = new DrawCanvas(this.getWidth(), this.getHeight());
        this.add(c);

        // Background
        setBackground(Color.lightGray);
    }
}
