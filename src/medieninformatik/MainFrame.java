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
        super("Metrik 1.3");

        this.setLayout(null);
        this.setSize(800, 600);
        this.setVisible(true);
        this.setResizable(false);
        setLocationRelativeTo(null);

        this.addWindowListener(new FrameAdapter(this));

        // Canvas

        DrawCanvas c = new DrawCanvas(this.getWidth(), this.getHeight());
        this.add(c);

        // Menu

        MenuBar menuBar = new MenuBar();
        setMenuBar(menuBar);

        // Background

        Menu backgroundMenu = new Menu("Change Background");

        MenuItem green = new MenuItem("Green");
        MenuItem blue = new MenuItem("Blue");
        MenuItem yellow = new MenuItem("Yellow");
        MenuItem red = new MenuItem("Red");

        backgroundMenu.add(green);
        backgroundMenu.add(blue);
        backgroundMenu.add(yellow);
        backgroundMenu.add(red);

        green.addActionListener(greenEvent -> {
            c.setBackground(Color.GREEN);
        });

        blue.addActionListener(greenEvent -> {
            c.setBackground(Color.BLUE);
        });

        yellow.addActionListener(greenEvent -> {
            c.setBackground(Color.YELLOW);
        });

        red.addActionListener(greenEvent -> {
            c.setBackground(Color.RED);
        });

        menuBar.add(backgroundMenu);

        // Edit CircleSize
        Menu edit = new Menu("Edit");

        MenuItem circleSize = new MenuItem("Circle Size");

        circleSize.addActionListener(circleEvent -> {
            DialogueFrame dialogue = new DialogueFrame(c);
        });

        edit.add(circleSize);

        menuBar.add(edit);
    }
}
