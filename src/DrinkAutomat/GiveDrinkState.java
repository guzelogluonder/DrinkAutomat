package DrinkAutomat;

import javax.swing.*;

public class GiveDrinkState implements State {


    Automat automat;


    public GiveDrinkState(Automat a) {
        this.automat = a;
    }

    @Override
    public void payMoney() {
        JOptionPane.showMessageDialog(this.automat, "Para attin, icecek almadin.");
        this.automat.changeState(new GiveDrinkState(this.automat));
    }

    @Override
    public void absentMoney() {
        JOptionPane.showMessageDialog(this.automat, "Para attin, icecek almadin.");
        this.automat.changeState(new DontGiveDrinkState(this.automat));

    }

    @Override
    public void giveDrink() {
        if (this.automat.drink > 0) {
            this.automat.drink--;
            JOptionPane.showMessageDialog(this.automat, "Afiyet olsun.");
            this.automat.changeState(new DontGiveDrinkState(this.automat));
        } else {
            absentDrink();
        }
    }

    @Override
    public void absentDrink() {
        JOptionPane.showMessageDialog(this.automat, "İçecek kalmadı.");
        this.automat.changeState(new DontGiveDrinkState(this.automat));

    }
}
