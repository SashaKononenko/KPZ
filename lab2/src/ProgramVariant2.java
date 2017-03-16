import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class ProgramVariant2
{
    Telephone BaseСlass;

    public  void StartProgram()
    {
        JFrame windowVariant2 = new JFrame("Variant 2");
        windowVariant2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Елементи інтерфейсу:
        GridLayout gridLayout = new GridLayout(3,2);
        windowVariant2.setLayout(gridLayout);

        String[] listConstr = {
                "Telephone(String a)",
                "Telephone(String a,int b)",
                "Phone(int a, int b, int c)",
                "Phone(int a, int b)"
        };
        JButton setting = new JButton("Setting");
        JComboBox constructors = new JComboBox(listConstr);
        JButton create = new JButton("Create");
        JTextArea result = new JTextArea();
        JButton showResult = new JButton("Output data");
        //Виведення елементів в вікно
        windowVariant2.getContentPane().add(constructors);
        windowVariant2.getContentPane().add(create);
        windowVariant2.getContentPane().add(showResult);
        windowVariant2.getContentPane().add(result);
        windowVariant2.getContentPane().add(setting);

        windowVariant2.setVisible(true);
        windowVariant2.setSize(500,300);

        create.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    if(BaseСlass != null) {
                        windowVariant2.getContentPane().remove(BaseСlass);
                        BaseСlass = null;
                    }

                    switch (constructors.getSelectedIndex()) {
                        case 0:
                            BaseСlass = new Telephone("Alcatel");
                        break;
                        case 1:
                            BaseСlass =  new Telephone("Alcatel",143);
                        break;
                        case 2:
                            BaseСlass =  new Phone(23,12,43);
                        break;
                        case 3:
                            BaseСlass =  new Phone(12,23);
                    }
                    windowVariant2.getContentPane().repaint();
                    windowVariant2.getContentPane().add(BaseСlass);
                    result.setText("Create object");
                }
            }
        );
        setting.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    if(BaseСlass != null) {
                        BaseСlass.DrawWindow();
                    }
                }
            }
        );
        showResult.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    if(BaseСlass != null)
                    {
                        windowVariant2.getContentPane().repaint();
                        windowVariant2.getContentPane().add(BaseСlass);
                        result.setText(BaseСlass.outputData());
                    }
                }
            }
        );
    }
}