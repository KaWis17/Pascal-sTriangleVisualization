
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionsWindow extends JFrame implements ActionListener, ChangeListener {
    RadioButton option1;
    RadioButton option2;
    JSlider slider;
    Desc description1;
    Desc description2;
    boolean localNumberOnly = true;
    int localSpeed = 30;

    OptionsWindow(){
        MenuBar.options.setEnabled(false);
        Footer.button.setEnabled(false);
        this.setTitle("Options");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400, 400);
        this.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));


        //---RADIO---//
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridBagLayout());
        option1 = new RadioButton("Only numbers");
        option1.addActionListener(this);
        option2 = new RadioButton("Multiplication formulas");
        option2.addActionListener(this);
        radioPanel.add(option1);
        radioPanel.add(Box.createHorizontalStrut(30));
        radioPanel.add(option2);
        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        panel.add(radioPanel);


        //---SLIDER---//
        slider = new JSlider(0,300,Print.speedMS);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(50);
        slider.setPaintLabels(true);
        slider.setFont(new Font("Arial", Font.ITALIC, 15));
        slider.addChangeListener(this);
        panel.add(slider);


        //---DESCRIPTION---//
        JLabel description = new JLabel();
        description.setLayout(new GridLayout(1, 2));
        description1 = new Desc("Numbers only");
        if(!Print.numberOnly) description1.setText("Formulas");
        description.add(description1);
        description2 = new Desc("Speed = "+slider.getValue()+"ms");
        description.add(description2);
        panel.add(description);


        //---BUTTONS--//
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        OptionButton button1 = new OptionButton("Cancel");
        button1.addActionListener(e ->{
            MenuBar.options.setEnabled(true);
            Footer.button.setEnabled(true);
            this.dispose();
        });
        buttonPanel.add(button1);
        buttonPanel.add(Box.createHorizontalStrut(30));
        OptionButton button2 = new OptionButton("Apply changes");
        button2.addActionListener(e -> {
            MenuBar.options.setEnabled(true);
            Footer.button.setEnabled(true);
            Print.speedMS = localSpeed;
            Print.numberOnly = localNumberOnly;
            this.dispose();
        });
        buttonPanel.add(button2);
        panel.add(buttonPanel);

        this.add(panel);
        this.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==option1){
            description1.setText("Number only");
            localNumberOnly = true;
        }
        else if(e.getSource()==option2){
            description1.setText("Formulas");
            localNumberOnly = false;
        }
    }

    @Override
    public void stateChanged(ChangeEvent e){
        description2.setText("Speed = "+slider.getValue()+"ms");
        localSpeed = slider.getValue();
    }
}

class OptionButton extends JButton{
    OptionButton(String title){
        this.setText(title);
        this.setFont(new Font("Arial", Font.ITALIC, 15));
        this.setForeground(Color.white);
        this.setBackground(Color.darkGray);
        this.setFocusable(false);
        this.setSize(new Dimension(100,50));
    }
}

class RadioButton extends JRadioButton{
    RadioButton(String title){
        this.setText(title);
        this.setFont(new Font("Arial", Font.ITALIC, 15));

    }
}

class Desc extends JLabel{
    Desc(String text){
        this.setText(text);
        this.setFont(new Font("Arial", Font.ITALIC, 15));
        this.setHorizontalAlignment(CENTER);
    }
}

