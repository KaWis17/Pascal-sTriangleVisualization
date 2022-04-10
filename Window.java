
import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    static int size = 0;
    Window(){
        this.setTitle("Pascal's Triangle");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 800);
        this.setMinimumSize(new Dimension(600, 600));
        this.setResizable(true);
        this.setLayout(new BorderLayout());

        this.setJMenuBar(new MenuBar());
        this.add(new Header("Pascal's Triangle generator"), BorderLayout.NORTH);
        this.add(new Footer(), BorderLayout.SOUTH);
        this.setVisible(true);
        setSize();
        while(size==0){
            JOptionPane.showMessageDialog(null, "You should input a size of a triangle!");
            setSize();
        }
        this.add(new JScrollPane(new Body(size)), BorderLayout.CENTER);
        this.setVisible(true);
    }

    private void setSize(){
        String stringSize = JOptionPane.showInputDialog(null, "Input triangle's size: ");
        if(stringSize == null || stringSize.length() == 0){
            size = 0;
            Footer.text.setText(size);
        }
        else{
            try{
                size = Integer.parseInt(stringSize);
                if(size<0){
                    JOptionPane.showMessageDialog(null, "Number out of range");
                    setSize();
                }
                Footer.text.setText(size);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Incorrect data");
                setSize();
            }
        }
    }
}
