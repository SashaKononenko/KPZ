import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class Telephone extends JPanel
{
    Color color;
    String maker;
    int prise;
    Color backgroundColor;

    Telephone() {

    }

    //Конструктори
    Telephone(String maker)
    {
        this.maker = maker;
    }
    Telephone(String maker,int prise)
    {
        this.maker = maker;
        this.prise = prise;
    }
    //Методи
    public void paint (Graphics g)
    {
        g.setColor(color);
        g.drawRect(10,15,prise,50);
        g.drawString(maker, 50, 10);
    }

    void DrawWindow()
    {
        JFrame SettingWindow = new JFrame("Setting telephone");
        GridLayout gridLayout = new GridLayout(4,1);
        SettingWindow.setLayout(gridLayout);
        SettingWindow.setLocation(0,350);


        backgroundColor = Color.white;
        JButton changeCol = new JButton("");
        changeCol.setBackground(backgroundColor);

        String[] listMaterials = {
                "Alcatel",
                "Panasonic",
                "Philips",
                "Texet"
        };
        JComboBox comboBoxMaker = new JComboBox(listMaterials);

        JTextField  textPrise = new JTextField();
        JLabel lebelSetCol = new JLabel("Color:");
        JLabel lebelMaker = new JLabel("Maker:");
        JLabel lebelPrise = new JLabel("Prise:");
        JButton apply = new JButton("Input data");

        SettingWindow.getContentPane().add(lebelSetCol);
        SettingWindow.getContentPane().add(changeCol);
        SettingWindow.getContentPane().add(lebelMaker);
        SettingWindow.getContentPane().add(comboBoxMaker);
        SettingWindow.getContentPane().add(lebelPrise);
        SettingWindow.getContentPane().add(textPrise);
        SettingWindow.getContentPane().add(apply);

        SettingWindow.setVisible(true);
        SettingWindow.setSize(500,300);

        changeCol.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    backgroundColor= JColorChooser.showDialog(null, "Choose a background",backgroundColor);
                    changeCol.setBackground(backgroundColor);
                }
            }
        );
        apply.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    inputData(backgroundColor,comboBoxMaker,textPrise);
                }
            }
        );
    }
    void inputData(Color color, JComboBox maker, JTextField prise)
    {
        this.color = color;
        this.maker = (String)maker.getSelectedItem();
        this.prise = Integer.parseInt(prise.getText());
    }

    String outputData()
    {
        return "color:"+color+"\n"+"maker:"+maker+"\n"+"prise:"+prise;
    }



}