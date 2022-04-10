
import javax.swing.*;
import java.awt.*;

public class Footer extends JPanel {
    static Text text;
    static Button button;
    Footer(){
        text = new Text();
        button = new Button();
        this.setPreferredSize(new Dimension(1200, 100));
        this.setLayout(new BorderLayout());
        this.setBackground(Color.BLACK);
        this.add(text, BorderLayout.WEST);
        this.add(button, BorderLayout.EAST);
    }
}

class Text extends JLabel{
    Text(){
        this.setText("Triangle's size: ");
        this.setHorizontalAlignment(CENTER);
        this.setFont(new Font("Arial", Font.ITALIC, 20 ));
        this.setForeground(Color.WHITE);
        this.setPreferredSize(new Dimension(300, 100));
    }
    void setText(int number){
        this.setText("Triangle's size: " + number);
    }
}

class Button extends JButton{
    Button(){
        this.setText("Start");
        this.setFont(new Font("Arial", Font.ITALIC, 20));
        this.setForeground(Color.white);
        this.setBackground(Color.darkGray);
        this.setPreferredSize(new Dimension(200, 100));
        this.setFocusable(false);
        this.addActionListener(e -> new Print().start());
    }
}
