package ru.avalon.jdev_120;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class Calc extends JFrame implements ActionListener {

    private final List<String> symbols = Arrays.asList("AC", "+/-", "%", "÷",
            "7", "8", "9", "x",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "=");
    private int operator = 0;
    private final JPanel jPanel = new JPanel(new BorderLayout(5, 5));
    private final JPanel buttonsPanel = new JPanel(new GridLayout(5, 4, 2, 2));
    private final JButton[] buttons = new JButton[19];
    private final JTextArea textArea = new JTextArea(2, 0);
    private double firstNum = 0;

    public Calc() {
        init();
    }

    private void init() {
        setTitle("JDarkCalc");
        textArea.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        textArea.setBackground(Color.BLACK);
        jPanel.setBackground(Color.LIGHT_GRAY);
        buttonsPanel.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(symbols.get(i));
            buttons[i].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false);
            buttons[i].setBackground(Color.BLACK);
            buttons[i].setForeground(Color.WHITE);
            buttons[i].addActionListener(this);
            buttonsPanel.add(buttons[i]);
        }

        jPanel.add(textArea, BorderLayout.NORTH);
        jPanel.add(buttonsPanel, BorderLayout.CENTER);

        add(jPanel);
        setSize(340, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();

        switch (command) {
            case ".":
                if (!textArea.getText().contains(".")) {
                    textArea.setText(textArea.getText() + ".");
                }
                break;
            case "0":
                textArea.setText(textArea.getText() + "0");
                break;
            case "1":
                textArea.setText(textArea.getText() + "1");
                break;
            case "2":
                textArea.setText(textArea.getText() + "2");
                break;
            case "3":
                textArea.setText(textArea.getText() + "3");
                break;
            case "4":
                textArea.setText(textArea.getText() + "4");
                break;
            case "5":
                textArea.setText(textArea.getText() + "5");
                break;
            case "6":
                textArea.setText(textArea.getText() + "6");
                break;
            case "7":
                textArea.setText(textArea.getText() + "7");
                break;
            case "8":
                textArea.setText(textArea.getText() + "8");
                break;
            case "9":
                textArea.setText(textArea.getText() + "9");
                break;

            case "+":
                if (!textArea.getText().isEmpty()) {
                    firstNum = Double.parseDouble(textArea.getText());
                    operator = 1;
                    textArea.setText("");
                }
                break;
            case "-":
                if (!textArea.getText().isEmpty()) {
                    firstNum = Double.parseDouble(textArea.getText());
                    operator = 2;
                    textArea.setText("");
                }
                break;
            case "x":
                if (!textArea.getText().isEmpty()) {
                    firstNum = Double.parseDouble(textArea.getText());
                    operator = 3;
                    textArea.setText("");
                }
                break;
            case "÷":
                if (!textArea.getText().isEmpty()) {
                    firstNum = Double.parseDouble(textArea.getText());
                    operator = 4;
                    textArea.setText("");
                }
                break;

            case "AC":
                textArea.setText("");
                break;
            case "%":
                double num = Double.parseDouble(textArea.getText());
                textArea.setText(String.valueOf(num / 100.0));
                break;
            case "+/-":
                double negative = Double.parseDouble(textArea.getText());
                negative = -negative;
                textArea.setText(String.valueOf(negative));
                break;
        }

        if ("=".equalsIgnoreCase(command)) {
            if (!textArea.getText().isEmpty()) {
                double secondNum = Double.parseDouble(textArea.getText());

                switch (operator) {
                    case 1:
                        textArea.setText(String.valueOf(firstNum + secondNum));
                        break;
                    case 2:
                        textArea.setText(String.valueOf(firstNum - secondNum));
                        break;
                    case 3:
                        textArea.setText(String.valueOf(firstNum * secondNum));
                        break;
                    case 4:
                        textArea.setText(String.valueOf(firstNum / secondNum));
                        break;
                }
            }
        }
    }

}
