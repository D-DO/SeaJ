package ru.dandam.seabattle.View;

import ru.dandam.seabattle.Controller.GameController;
import ru.dandam.seabattle.Model.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {


    JPanel jPaneCenter = new JPanel();
    JPanel jPanelLeft = new JPanel();
    JPanel jPanelRight = new JPanel();
    JPanel jPanelTop = new JPanel();
    public static JPanel jPanelBottom = new JPanel();

    JTextField jTextField = new JTextField();
    JTextField jTextField1 = new JTextField();
    public static   JTextField jTextFieldWin = new JTextField();

  public static   JButton[][] buttons = new JButton[10][10];
    public static   JButton[][] buttons1 = new JButton[10][10];


    public void init() {

        setTitle(" Морской бой");
        setAlwaysOnTop(true);
        setLocation(225, 150);
        jTextField.setText("     Ваше поле:");
        jTextField1.setText("     Поле соперника:");

        jPanelTop.setLayout(new GridLayout(1, 2));
        jPaneCenter.setLayout(new GridLayout(1, 3));
        jPanelLeft.setLayout(new GridLayout(10, 10));
        jPanelRight.setLayout(new GridLayout(10, 10));

        setSize(865, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        for (int i = 0; i < buttons.length; i++) {
            JButton[] buttonline = buttons[i];
            for (int j = 0; j < buttonline.length; j++) {
                JButton jButton = new JButton("~");
//                        buttonline[j];

//                jButton.setFont(Font.getFont("Arial 3"));
//                jButton.setForeground(Color.RED);
                buttons[i][j] = jButton;


                jPanelLeft.add(jButton);

            }

        }
        for (int i = 0; i < buttons1.length; i++) {
            JButton[] buttonline = buttons1[i];
            for (int j = 0; j < buttonline.length; j++) {
                JButton jButton = new JButton("~");
//                        buttonline[j];

                int finalI = i;
                int finalJ = j;
                jButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        System.out.println(getWidth() + " " + getHeight());
                        System.out.println(getX() + " " + getY());
                        GameController.doShootFromWindow(new Point(finalI, finalJ));
                        jButton.setBackground(Color.GRAY);
                    }
                });
                buttons1[i][j] = jButton;

                jPanelRight.add(jButton);

            }

        }


        add(jPanelTop, BorderLayout.NORTH);
        add(jPaneCenter);
        jPaneCenter.add(jPanelLeft);

        jPanelTop.add(jTextField);
        jPanelTop.add(jTextField1);

        jPaneCenter.add(jPanelRight);
        jPaneCenter.add(jPanelRight);

        add(jPanelBottom, BorderLayout.SOUTH);

//        jTextFieldWin.setText("                                                                 ");
        setVisible(true);

    }


}
