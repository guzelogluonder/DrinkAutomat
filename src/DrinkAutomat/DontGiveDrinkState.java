package DrinkAutomat;

public class DontGiveDrinkState implements State {

    Automat automat;

    public DontGiveDrinkState(Automat a) {
        this.automat = a;
    }

    @Override
    public void payMoney() {

        this.automat.changeState(new GiveDrinkState(this.automat));

    }

    @Override
    public void absentMoney() {
        this.automat.changeState(new GiveDrinkState(this.automat));

    }

    @Override
    public void giveDrink() {

    }

    @Override
    public void absentDrink() {

    }
}
