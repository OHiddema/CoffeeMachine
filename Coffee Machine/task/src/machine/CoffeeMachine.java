package machine;

public class CoffeeMachine {
    private State state;
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;

    CoffeeMachine(int water, int milk, int beans, int cups, int money) {
        this.state = State.MAIN_MENU;
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    void processInput(String userInputLine) {
        switch (state) {
            case MAIN_MENU -> processMainMenu(userInputLine);
            case BUY -> {
                buyCoffee(userInputLine);
                setState(State.MAIN_MENU);
            }
            case FILL_STEP1 -> {
                water += Integer.parseInt(userInputLine);
                setState(State.FILL_STEP2);
            }
            case FILL_STEP2 -> {
                milk += Integer.parseInt(userInputLine);
                setState(State.FILL_STEP3);
            }
            case FILL_STEP3 -> {
                beans += Integer.parseInt(userInputLine);
                setState(State.FILL_STEP4);
            }
            case FILL_STEP4 -> {
                cups += Integer.parseInt(userInputLine);
                setState(State.MAIN_MENU);
            }
        }
    }

    void processMainMenu(String userInputLine) {
        switch (userInputLine) {
            case "buy" -> setState(State.BUY);
            case "fill" -> setState(State.FILL_STEP1);
            case "take" -> {
                takeMoney();
                setState(State.MAIN_MENU);
            }
            case "remaining" -> {
                displayState();
                setState(State.MAIN_MENU);
            }
            case "exit" -> setState(State.EXIT);
        }
    }

    void displayState() {
        System.out.println("The coffee machine has:");
        System.out.println(this.water + " ml of water");
        System.out.println(this.milk + " ml of milk");
        System.out.println(this.beans + " g of coffee beans");
        System.out.println(this.cups + " disposable cups");
        System.out.println(this.money + " of money");
    }

    void buyCoffee(String userInputLine) {
        int waterNeeded = 0, beansNeeded = 0, milkNeeded = 0, moneyAdded = 0, cupsNeeded = 0;
        switch (userInputLine) {
            case ("1") -> {
                waterNeeded = 250;
                beansNeeded = 16;
                moneyAdded = 4;
                cupsNeeded = 1;
            }
            case ("2") -> {
                waterNeeded = 350;
                milkNeeded = 75;
                beansNeeded = 20;
                moneyAdded = 7;
                cupsNeeded = 1;
            }
            case ("3") -> {
                waterNeeded = 200;
                milkNeeded = 100;
                beansNeeded = 12;
                moneyAdded = 6;
                cupsNeeded = 1;
            }
            case ("back") -> {
                return;
            }
        }
        if (water < waterNeeded) {
            System.out.println("Sorry, not enough water!");
        } else if (beans < beansNeeded) {
            System.out.println("Sorry, not enough beans!");
        } else if (milk < milkNeeded) {
            System.out.println("Sorry, not enough beans!");
        } else if (cups < 1) {
            System.out.println("Sorry, not enough cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            water -= waterNeeded;
            beans -= beansNeeded;
            milk -= milkNeeded;
            money += moneyAdded;
            cups -= cupsNeeded;
        }
    }
    void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

}