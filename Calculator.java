package Calculator;

import javax.swing.*;

public class Calculator {
    private JFrame frame;
    public Calculator(){
        frame=new JFrame("Calculator");
        frame.setSize(267,350);
        frame.add(new Panel());
        frame.setLocationRelativeTo(null); // in the center of the screen
        frame.setResizable(false); //cannot be resized
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Calculator();
            }
        });
    }
}
