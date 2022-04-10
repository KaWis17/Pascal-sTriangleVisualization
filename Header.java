
import javax.swing.*;
import java.awt.*;

public class Header extends JLabel {
    Header(String title){
        this.setText(title);
        this.setPreferredSize(new Dimension(1200, 100));
        this.setFont(new Font("Arial", Font.ITALIC, 30 ));
        this.setHorizontalAlignment(CENTER);
        this.setForeground(Color.WHITE);
        this.setBackground(Color.BLACK);
        this.setOpaque(true);
    }
}
