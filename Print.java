
import javax.swing.*;
import java.awt.*;

public class Print extends Thread{
    static Color color = Color.green;
    static int speedMS = 30;
    static Element[][] elements;
    static boolean numberOnly = true;
    @Override
    public void run(){
        int size = Window.size;
        elements = new Element[size+1][size+1];
        Footer.button.setEnabled(false);
        MenuBar.options.setEnabled(false);
        Footer.button.setText("Working...");
        if(numberOnly){
            printingNumbersOnly(size);
        }
        else{
            printingWithFormulas(size);
        }
        for(int i=size; i>=0; i--){
            for(int j=i; j>=0; j--){
                TrianglePanel.elements[i][j].setForeground(color);
            }
            try {
                Thread.sleep(speedMS* 3L /4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Footer.button.setText("Finished :)");
        MenuBar.options.setEnabled(true);
        MenuBar.subOptions.setEnabled(false);
    }

    private String TrojkatPascala(int n, int k){
        long value = 1;
        int i;
        for(i=1; i<=k; i++){
            value = value * (n-i+1) / i;
        }
        return String.valueOf(value);
    }

    private void printingNumbersOnly(int size){
        for(int i=0; i<=size; i++){
            Element element = new Element();
            element.setText(String.valueOf(i));
            Body.sideBar.add(element);
            for(int j=0; j<=i; j++){
                TrianglePanel.elements[i][j].setValue(TrojkatPascala(i, j));
                TrianglePanel.elements[i][j].setBorder(BorderFactory.createLineBorder(Color.lightGray, 5));

                try {
                    Thread.sleep(speedMS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void printingWithFormulas(int size){
        Body.sideBar.setPreferredSize(new Dimension(150, 100));
        for(int i=0; i<=size; i++){
            Element element = new Element();
            element.setText("<html>(a+b)<sup>"+i+"</sup></html>");
            Body.sideBar.add(element);
            for(int j=0; j<=i; j++){
                int a = i-j;
                if(i==0){
                    TrianglePanel.elements[i][j].setText(TrojkatPascala(i, j));
                }
                else if(j==0){
                    TrianglePanel.elements[i][j].setText("<html>a<sup>" + a + "</sup></html>");
                }
                else if(i-j==0){
                    TrianglePanel.elements[i][j].setText("<html>b<sup>" + j + "</sup></html>");
                }
                else if(a==0 && j ==1){
                    TrianglePanel.elements[i][j].setText("<html>" + TrojkatPascala(i, j) + "b</html>");
                }
                else if(a==1 && j ==1){
                    TrianglePanel.elements[i][j].setText("<html><sup>"+"\u2800"+"</sup>" + TrojkatPascala(i, j) + "ab<sup>"+"\u2800"+"</sup></html>");
                }
                else if(a==0){
                    TrianglePanel.elements[i][j].setText("<html>" + TrojkatPascala(i, j) + "b<sup>" + j + "</sup>" + "</html>");
                }
                else if(a==1){
                    TrianglePanel.elements[i][j].setText("<html>" + TrojkatPascala(i, j) + "a b<sup>" + j + "</sup>" + "</html>");
                }
                else if(j ==1){
                    TrianglePanel.elements[i][j].setText("<html>" + TrojkatPascala(i, j) + "a<sup>" + a + "</sup>" + "b</html>");
                }
                else{
                    TrianglePanel.elements[i][j].setText("<html>" + TrojkatPascala(i, j) + "a<sup>" + a + "</sup>" + "b<sup>" + j + "</sup>" + "</html>");
                }

                TrianglePanel.elements[i][j].setBorder(BorderFactory.createLineBorder(Color.lightGray, 10));
                try {
                    Thread.sleep(speedMS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
