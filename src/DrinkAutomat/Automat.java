package DrinkAutomat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Automat extends JFrame {

    int drink = 1;
    int money = 2;
    State myState;

    JLabel info = new JLabel("Icecek: " + drink + "|| Para:  " + money);

    public Automat() {
        this.myState = new DontGiveDrinkState(this);
        initializeUI();
    }

    public void payMoney() {
        this.myState.payMoney();
    }

    public void absentMoney() {
        this.myState.absentMoney();
    }

    public void giveDrink() {
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
                payMoney();
                info.setText("Icecek; " + drink + "|| Para:  " + money);
                myFrame.validate();
            }
        });

        drinkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                giveDrink();
                info.setText("Icecek; " + drink + "|| Para:  " + money);
                myFrame.validate();
            }
        });
        myFrame.setTitle("Drink Automat");
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myFrame.add(paymentButton, BorderLayout.EAST);
        myFrame.add(drinkButton, BorderLayout.WEST);
        myFrame.add(info, BorderLayout.CENTER);
        myFrame.setPreferredSize(new Dimension(500, 250));
        myFrame.pack();
        myFrame.setVisible(true);
    }

}
