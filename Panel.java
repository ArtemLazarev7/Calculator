package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Panel extends JPanel {
    private JButton numbers[] = new JButton[10];
    private Font font = new Font("Sanserif", Font.BOLD, 20);
    private JTextField output = new JTextField();
    private JButton reset = new JButton("C");
    private JButton equ = new JButton("=");
    private JButton plus = new JButton("+");
    private JButton minus = new JButton("-");
    private JButton multiple = new JButton("*");
    private JButton division = new JButton("/");
    Handler handler=new Handler();

    int a, b;
    String x, y;

    int sum = 0, min = 0, mult = 0, div = 0;


    public Panel() {
        setLayout(null);
        setFocusable(true); // focus for keypressed
        grabFocus();      // request focus

        reset.setBounds(10, 250, 50, 50);
        reset.setFont(font);
        reset.setForeground(Color.RED);
        add(reset);
        reset.addActionListener(handler);

        equ.setBounds(130, 250, 50, 50);
        equ.setFont(font);
        equ.setForeground(Color.BLACK);
        add(equ);
        equ.addActionListener(handler);

        division.setBounds(190, 70, 50, 50);
        division.setFont(font);
        division.setForeground(Color.GREEN);
        add(division);
        division.addActionListener(handler);

        multiple.setBounds(190, 130, 50, 50);
        multiple.setFont(font);
        multiple.setForeground(Color.GREEN);
        add(multiple);
        multiple.addActionListener(handler);

        minus.setBounds(190, 190, 50, 50);
        minus.setFont(font);
        minus.setForeground(Color.GREEN);
        add(minus);
        minus.addActionListener(handler);

        plus.setBounds(190, 250, 50, 50);
        plus.setFont(font);
        plus.setForeground(Color.GREEN);
        add(plus);
        plus.addActionListener(handler);

        numbers[0] = new JButton("0");
        numbers[0].setBounds(70, 250, 50, 50);
        numbers[0].setFont(font);
        numbers[0].setForeground(Color.BLUE);
        add(numbers[0]);

//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j <3 ; j++) {
//                numbers[i*3+j+1]=new JButton((i*3+j+1)+"");
//                numbers[i*3+j+1].setBounds(i*(50+10)+10,j*(50+10)+70,50,50);
//                numbers[i*3+j+1].setFont(font);
//                add(numbers[i*3+j+1]);
//            }

        for (int i = 1; i < 10; i++) {
            numbers[i] = new JButton(i + "");
            numbers[i].setFont(font);
            if (0 < i && i < 4) {
                numbers[i].setBounds((i - 1) * (50 + 10) + 10, 70, 50, 50);
            }
            if (3 < i && i < 7) {
                numbers[i].setBounds((i - 4) * (50 + 10) + 10, 130, 50, 50);
            }
            if (i > 6) {
                numbers[i].setBounds((i - 7) * (50 + 10) + 10, 190, 50, 50);
            }
            numbers[i].setForeground(Color.BLUE);

            add(numbers[i]);


        }
        output.setBounds(10, 10, 230, 50);
        output.setFont(font);
        output.setEditable(false);
        output.getBackground();
        add(output);

//        ActionListener l1=new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        };

        ActionListener l = (ActionEvent e) -> {
            JButton number = (JButton) e.getSource();
            output.setText(output.getText() + number.getText());
        };

        for (JButton number : numbers) {
            number.addActionListener(l);

        }
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char symbol = e.getKeyChar();
                if (!Character.isDigit(symbol))
                    return;
                output.setText(output.getText() + symbol);
            }
        });

    }

    class Handler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == equ) {
                y = output.getText();
                a = Integer.parseInt(x);
                b = Integer.parseInt(y);
                if (sum == 1) {
                    output.setText(a + b + "");
                    sum = 0;
                    a = 0;
                    b = 0;
                    x = "";
                    y = "";
                }
                if (min == 1) {
                    output.setText(a - b + "");
                    min = 0;
                    a = 0;
                    b = 0;
                    x = "";
                    y = "";
                }
                if (mult == 1) {
                    output.setText(a * b + "");
                    mult = 0;
                    a = 0;
                    b = 0;
                    x = "";
                    y = "";
                }try{
                if (div == 1) {
                    output.setText(a / b + "");
                    div = 0;
                    a = 0;
                    b = 0;
                    x = "";
                    y = "";
                }}catch (ArithmeticException ex){
                    output.setText("ERROR");
                }
            }
            if(e.getSource()==plus){
                x=output.getText();
                output.setText(null);
                sum=1;
            }
            if(e.getSource()==minus){
                x=output.getText();
                output.setText(null);
                min++;}
            if(e.getSource()==multiple){
                x=output.getText();
                output.setText(null);
                mult++;}
            if(e.getSource()==division){
                x=output.getText();
                output.setText(null);
                div++;}
            if(e.getSource()==reset){
                output.setText(null);
               resetAll();
            }
        }
    }
    private void resetAll(){
        a = 0;
        b = 0;
        x = "";
        y = "";
        sum=0;
        min=0;
        div=0;
        mult=0;
    }
}