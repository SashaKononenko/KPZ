import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class ProgramVariant1
{
    Telephone telephone;
    Phone phone;
    
    public  void StartProgram()
    {
        JFrame windowVariant1 = new JFrame("Variant 1");
        windowVariant1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Елементи інтерфейсу:
        GridLayout gridLayout = new GridLayout(3,2);
        windowVariant1.setLayout(gridLayout);

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
        windowVariant1.getContentPane().add(constructors);
        windowVariant1.getContentPane().add(create);
        windowVariant1.getContentPane().add(showResult);
        windowVariant1.getContentPane().add(result);
        windowVariant1.getContentPane().add(setting);

        windowVariant1.setVisible(true);
        windowVariant1.setSize(500,300);

        create.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    if(telephone != null) {
                        windowVariant1.getContentPane().remove(telephone);
                        telephone = null;
                    }
                    if(phone != null) {
                        windowVariant1.getContentPane().remove(phone);
                        phone = null;

                    }

                    switch (constructors.getSelectedIndex()) {
                        case 0: {
                            telephone = new Telephone("Alcatel");
                            windowVariant1.getContentPane().add(telephone);
                        }
                        break;
                        case 1: {
                            telephone =  new Telephone("Alcatel",143);
                            windowVariant1.getContentPane().add(telephone);
                        }
                        break;
                        case 2: {
                            phone =  new Phone(23,12,43);
                            windowVariant1.getContentPane().add(phone);
                        }
                        break;
                        case 3: {
                            phone =  new Phone(12,23);
                            windowVariant1.getContentPane().add(phone);
                        }
                    }
                    windowVariant1.getContentPane().repaint();
                    result.setText("Create object");
                }
            }
        );
        showResult.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    if(telephone != null)
                    {
                        windowVariant1.getContentPane().repaint();
                        windowVariant1.getContentPane().add(telephone);
                        result.setText(telephone.outputData());
                    }
                    if(phone != null)
                    {
                        windowVariant1.getContentPane().repaint();
                        windowVariant1.getContentPane().add(phone);
                        result.setText(phone.outputData());
                    }
                }
            }
        );

        setting.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(telephone != null) {
                    telephone.DrawWindow();
                }
                if(phone != null) {
                    phone.DrawWindow();
                }
            }
        });
    }
}