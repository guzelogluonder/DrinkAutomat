package DrinkAutomat;

import javax.swing.*;

public class DontGiveDrinkState implements State {

    Automat automat;

    public DontGiveDrinkState(Automat a) {
        this.automat = a;
    }

    @Override
    public void payMoney() {
        if (this.automat.money > 0) {
            if (this.automat.drink > 0) {
                this.automat.money--;
                JOptionPane.showMessageDialog(this.automat, "Para atıldı. Lütfen içeceğinizi almak için Drink butonuna basınız.");
                this.automat.changeState(new GiveDrinkState(this.automat));
            } else {
                absentDrink();
            }
        } else {
            absentMoney();
        }
    }

    @Override
    public void absentMoney() {
        JOptionPane.showMessageDialog(this.automat, "Bakiye bitti.");
        this.automat.changeState(new DontGiveDrinkState(this.automat));
    }

    @Override
    public void giveDrink() {
        if(this.automat.drink>0){
            JOptionPane.showMessageDialog(this.automat, "Henuz para atilmadi.");
        }else{
            JOptionPane.showMessageDialog(this.automat, "Para atsaniz da icecek alamazsiniz, cunku kalmadi");
        }

        this.automat.changeState(new DontGiveDrinkState(this.automat));
    }

    @Override
    public void absentDrink() {
        JOptionPane.showMessageDialog(this.automat, "İçecek kalmadı.");
        this.automat.changeState(new DontGiveDrinkState(this.automat));

    }
}
