import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args)
    {
        JFrame windowMain = new JFrame("Lab6");
        windowMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Елементи інтерфейсу:
        GridLayout gridLayout = new GridLayout(3,1);
        windowMain.setLayout(gridLayout);
        JLabel jLabel = new JLabel("Select the option you start program:");
        JButton variant1 = new JButton("Variant 1");
        JButton variant2 = new JButton("Variant 2");
        windowMain.getContentPane().add(jLabel);
        windowMain.getContentPane().add(variant1);
        windowMain.getContentPane().add(variant2);
        windowMain.setVisible(true);
        windowMain.setSize(270,100);
        ProgramVariant1 programVariant1 = new ProgramVariant1();
        ProgramVariant2 programVariant2 = new ProgramVariant2();
        variant1.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    programVariant1.StartProgram();
                }
            }
        );
        variant2.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    programVariant2.StartProgram();
                }
            }
        );
    }
}
