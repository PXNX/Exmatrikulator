import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View {

    Main_ViewModel mvm = new Main_ViewModel();

    public void init() {

        JFrame frame = new JFrame("Exmatrikulator");
        JButton btn1, btn2, btn3;
        btn1 = new JButton(mvm.getName(113));
        btn2 = new JButton(mvm.getName(112));
        btn3 = new JButton("btn3");

        Student std = mvm.getStudent(113);
        btn3.setText(std.getName());

        ActionListener al1 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog d = new JDialog(frame, "Hello, you're exmatriculated! Goodbye:)", true);
                d.setLocationRelativeTo(frame);
                d.setSize(500, 350);
                d.setVisible(true);
            }
        };

        btn1.addActionListener(al1);
        btn2.addActionListener(al1);
        btn3.addActionListener(al1);

        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);

        frame.setLayout(new GridLayout(1, 3));

        frame.setSize(300, 500);
        frame.setVisible(true);
    }
}
