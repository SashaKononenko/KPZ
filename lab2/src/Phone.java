import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class Phone extends Telephone
{
    int width;
    int height;
    int thickness;

    //Конструктори
    Phone(int width, int height, int thickness)
    {
        this.width = width;
        this.height = height;
        this.thickness = thickness;
    }
    Phone(int width, int height)
    {
        this.width = width;
        this.height = height;
        thickness = 10;
    }
    @Override
    public void paint (Graphics g)
    {
        g.drawOval(20, width, height, thickness);
    }
    void DrawWindow()
    {
        JFrame SettingWindow = new JFrame("Setting mobile phone");
        GridLayout gridLayout = new GridLayout(4,1);
        SettingWindow.setLayout(gridLayout);
        SettingWindow.setLocation(0,350);

        JTextField  textWidth = new JTextField();
        JTextField  textHeight = new JTextField();
        JTextField  textThickness = new JTextField();
        JLabel labelWidth = new JLabel("width:");
        JLabel labelHeight = new JLabel("height:");
        JLabel labelThickness = new JLabel("thickness:");
        JButton apply = new JButton("Input data");

        SettingWindow.getContentPane().add(labelWidth);
        SettingWindow.getContentPane().add(textWidth);
        SettingWindow.getContentPane().add(labelHeight);
        SettingWindow.getContentPane().add(textHeight);
        SettingWindow.getContentPane().add(labelThickness);
        SettingWindow.getContentPane().add(textThickness);
        SettingWindow.getContentPane().add(apply);
        SettingWindow.setVisible(true);
        SettingWindow.setSize(500,300);

        apply.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    inputData(textWidth,textHeight,textThickness);
                }
            }
        );
    }
    void inputData(JTextField widgt,JTextField height,JTextField thickness)
    {
        this.width = Integer.parseInt(widgt.getText());
        this.height = Integer.parseInt(height.getText());
        this.thickness = Integer.parseInt(thickness.getText());
    }

    String outputData()
    {
        return "width:"+width+"\n" +"height:"+height+"\n"+"thickness:"+thickness;
    }

}