package DrinkAutomat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Automat extends JFrame {

    int drink = 1;
    int money = 2;
    State myState;

    JLabel info = new JLabel("Icecek: "+ drink + "|| Para:  " + money);

    public Automat() {
        this.myState = new DontGiveDrinkState(this);
        initializeUI();
    }

    public void payMoney() {
        money--;
        this.myState.payMoney();
    }

    public void absentMoney() {
        this.myState.absentMoney();
    }

    public void giveDrink() {
        drink--;
        this.myState.giveDrink();
    }

    public void absentDrink() {
        this.myState.absentDrink();
    }

    public void changeState(State s) {
        this.myState = s;
    }

    public void initializeUI() {
        JFrame myFrame = this;
        JButton paymentButton = new JButton("Pay Money", new ImageIcon("BirLira.jpeg"));
        JButton drinkButton = new JButton("Give Drink", new ImageIcon("Ayran.jpeg"));
        paymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(myState instanceof DontGiveDrinkState && money > 0 ) {
                    payMoney();
                    info.setText("Icecek: "+ drink + "|| Para:  " + money);
                    JOptionPane.showMessageDialog(myFrame, "para atıldı Lütfen içeceğinizi almak için Drink butonuna basınız.");
                }
                else if (myState instanceof DontGiveDrinkState && money <= 0){
                    absentMoney();
                    info.setText("Icecek: " + drink + " || para: " + money);
                    JOptionPane.showMessageDialog(myFrame,"Bakiye bitti.");
                }
                else
                    JOptionPane.showMessageDialog(myFrame,"Para attın içecek almadın.");
                myFrame.validate();
            }
        });

        drinkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(myState instanceof GiveDrinkState && drink > 0) {
                    giveDrink();
                    info.setText("Icecek; "+ drink + "|| Para:  " + drink);

                    JOptionPane.showMessageDialog(myFrame, "Afiyet olsun.");
                }
                else if(myState instanceof GiveDrinkState && drink <= 0){
                 absentDrink();
                 JOptionPane.showMessageDialog(myFrame,"İçecek kalmadı.");
                }
                else
                    JOptionPane.showMessageDialog(myFrame,"Henüz para atmadınız.Lütfen Para atma butonuna basınız.");
                myFrame.validate();
            }
        });
        myFrame.setTitle("Drink Automat");
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myFrame.add(paymentButton, BorderLayout.EAST);
        myFrame.add(drinkButton, BorderLayout.WEST);
        myFrame.add(info, BorderLayout.CENTER);
        myFrame.setPreferredSize(new Dimension(500,250));
        myFrame.pack();
        myFrame.setVisible(true);
    }

}
