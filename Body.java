
import javax.swing.*;
import java.awt.*;

public class Body extends JPanel {
    static SideBar sideBar;
    static TrianglePanel trianglePanel;
    Body(int size){
        sideBar = new SideBar(size);
        trianglePanel = new TrianglePanel(size);
        this.setLayout(new BorderLayout());
        this.add(sideBar, BorderLayout.WEST);
        this.add(trianglePanel, BorderLayout.CENTER);
    }
}

class SideBar extends JPanel{
    SideBar(int size){
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(50, 100));
        this.setLayout(new GridLayout(size+1, 1));
    }
}

class TrianglePanel extends JPanel{
    static Tiles[] tiles;
    static Element[][] elements;
    TrianglePanel(int size){
        tiles = new Tiles[size+1];
        elements = new Element[size+1][size+1];
        this.setBackground(Color.lightGray);
        this.setLayout(new GridLayout(size+1, 1));
        for(int i=0; i<=size; i++){
            tiles[i] = new Tiles();
            tiles[i].setLayout(new GridBagLayout());
            this.add(tiles[i]);
            for(int j=0; j<=i; j++){
                elements[i][j] = new Element();
                elements[i][j].setBackground(Color.darkGray);
                elements[i][j].setOpaque(true);
                TrianglePanel.tiles[i].add(elements[i][j]);
            }
        }
    }
}

class Tiles extends JPanel{
    Tiles(){
        this.setBorder(BorderFactory.createLineBorder(Color.darkGray));
    }
}

class Element extends JLabel{
    Element(){
        this.setText("");
        this.setFont(new Font("Arial", Font.ITALIC, 30));
        this.setHorizontalAlignment(CENTER);
        this.setForeground(Color.red);
        this.setVerticalAlignment(CENTER);
    }

    void setValue(String string){
        this.setText("   " + string+ "   ");
    }
}
