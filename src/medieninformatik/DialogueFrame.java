package medieninformatik;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DialogueFrame extends Frame {

    DrawCanvas dc;

    public DialogueFrame(DrawCanvas dc) {

        super();
        this.dc = dc;

        Button submit = new Button("Confirm");
        submit.setBounds(20, 100, 60, 40);
        submit.setVisible(true);

        Button cancel = new Button("Cancel");
        cancel.setBounds(120, 100, 60, 40);
        cancel.setVisible(true);

        TextField size = new TextField();
        size.setBounds(20,50, 160,40);
        size.setVisible(true);

        setLayout(null);
        setVisible(true);
        setResizable(false);
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setSize(200, 160);

        add(size);
        add(submit);
        add(cancel);

        size.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                size.setEditable(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9');
            }
        });

        submit.addActionListener(event -> {
            int result = Integer.parseInt(size.getText());
            dc.setCircleSize(result);
            dc.repaint();
            dispose();
        });

        cancel.addActionListener(cancelEvent -> dispose());
    }
}
