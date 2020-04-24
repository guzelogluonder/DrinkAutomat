package DrinkAutomat;

public class GiveDrinkState implements State {


    Automat automat;


    public GiveDrinkState(Automat a){
        this.automat = a;
    }

    @Override
    public void payMoney() {

    }

    @Override
    public void absentMoney() {

    }

    @Override
    public void giveDrink() {
        this.automat.changeState(new DontGiveDrinkState(this.automat));

    }

    @Override
    public void absentDrink() {
        this.automat.changeState(new DontGiveDrinkState(this.automat));

    }
}
