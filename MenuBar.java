
import javax.swing.*;
import java.awt.*;

public class MenuBar extends JMenuBar {
    static JMenu options;
    static JMenuItem subOptions;
    MenuBar(){
        options = new JMenu("Options");
            subOptions = new JMenuItem("open options");
            JMenuItem reset = new JMenuItem("reset");
            JMenu color = new JMenu("color");
                JMenuItem colBlue = new JMenuItem("blue");
                JMenuItem colWhite = new JMenuItem("white");
                JMenuItem colGreen = new JMenuItem("green");
            JMenu background = new JMenu("background");
                JMenuItem light = new JMenuItem("light");
                JMenuItem dark = new JMenuItem("dark");
        JMenu close = new JMenu("Exit");
            JMenuItem subClose = new JMenuItem("close program");

        subOptions.addActionListener(e -> new OptionsWindow());
        reset.addActionListener(e -> Main.resetting());

        colBlue.addActionListener(e -> Print.color = Color.blue);
        colWhite.addActionListener(e -> Print.color = Color.white);
        colGreen.addActionListener(e -> Print.color = Color.green);

        light.addActionListener(e -> {
            for(int i=0; i<=Window.size; i++){
                TrianglePanel.tiles[i].setBackground(Color.lightGray);
                TrianglePanel.tiles[i].setBorder(BorderFactory.createLineBorder(Color.darkGray));
            }
        });
        dark.addActionListener(e -> {
            for(int i=0; i<=Window.size; i++){
                TrianglePanel.tiles[i].setBackground(Color.darkGray);
                TrianglePanel.tiles[i].setBorder(BorderFactory.createLineBorder(Color.lightGray));
            }
        });
        subClose.addActionListener(e -> System.exit(0));

        this.add(options);
            options.add(subOptions);
            options.add(reset);
            options.add(color);
                color.add(colBlue);
                color.add(colWhite);
                color.add(colGreen);
            options.add(background);
                background.add(light);
                background.add(dark);
        this.add(close);
            close.add(subClose);
    }
}
