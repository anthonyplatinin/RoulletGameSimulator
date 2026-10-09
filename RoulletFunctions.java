import java.util.Random;

public class RoulletFunctions {
    private int bet = 100;
    private int balance = 1000;
    private int wins = 0;
    private int defeat = 0; 

    private double percentWin = 0.0;
    private double percentDef = 0.0;
    private int matchs = 1000;

    private final GlobalAttributes global = new GlobalAttributes();

    public void statusGameUser(int balance, int bet, int wins, int defeat, double percentWin, double percentDef, int gameUs) {
        System.out.println("===Status==");
        System.out.println("Your $cash: " + balance); 
        System.out.println("Game: " + gameUs + "\nBet: " + bet + " \nWins: " + wins + " \nDefeat: " + defeat);
        System.out.printf("\nWin Rate: %.2f%%%n",percentWin);
        System.out.printf("Defeat Rate: %.2f%%%n",percentDef);
        global.sleepManager();
    }
    public void percentGame(int win, int defeat, int matchs) {
        percentWin = ((double) win / matchs) * 100;
        percentDef = ((double) defeat / matchs) * 100;
    }
    public Boolean is_odd(int number, String opt) {
        if(number % 2 == 0 && opt.equals("even")) {
            return true;
        } 
        if (number % 2 == 1 && opt.equals("odd")){
            return true;
        } 
        return false;
    }

    public void numberFunction() {
        global.clean();
        System.out.println("===ROULLET-GAME-SIMULATOR===");
    
        Random rnd = new Random();
    
        System.out.println("Your bet is 100 $, your balance is 1000 $");
        System.out.println("If you choose a number"); 
        for(int i = 0; i < matchs; ++i) { 
            global.clean();
            int numberChooseByRandom = rnd.nextInt(37);
            int numberChooseByYou = rnd.nextInt(37);

            System.out.println("Computer Number -> " + numberChooseByRandom);
            System.out.println("Your Number -> " + numberChooseByYou);
            if(numberChooseByYou == numberChooseByRandom) {
                wins += 1;
                balance += bet * 35;
            } else {
                defeat += 1;
                balance -= bet; 
            }

            percentGame(wins,defeat,matchs);
            statusGameUser(balance,bet,wins,defeat,percentWin,percentDef,i);
        }
    }
 
    public void dozensFunction(String opt) {
        Random rnd = new Random();

        Boolean dozens_true = false;
        for(int i = 0; i < matchs; i++) {
            global.clean();
            int numberChooseByRandom = rnd.nextInt(37);

            System.out.println("Your dozen: " + opt + " Choose Number: " + numberChooseByRandom);
            switch(opt) {
                case "1st12": dozens_true = numberChooseByRandom >= 1 && numberChooseByRandom <= 12; break;
                case "2nd12": dozens_true = numberChooseByRandom >= 13 && numberChooseByRandom <= 24; break;
                case "3rd12": dozens_true = numberChooseByRandom >= 25 && numberChooseByRandom <= 36; break;
                default: System.out.println("Option not found!"); break;
            }

            if(dozens_true) {
                wins += 1;
                balance += bet * 2;
            } else {
                defeat += 1;
                balance -= bet;
            }
            percentGame(wins,defeat,matchs);
            statusGameUser(balance,bet,wins,defeat,percentWin,percentDef,i);
        }
    }

    public void lowAndHigh(String opt) {
        Random rnd = new Random();

        Boolean isWin = false;
        for(int i = 0; i < matchs; ++i) {
            global.clean();
            int numberChooseByRandom = rnd.nextInt(37);
            System.out.println("Your choose: " + opt + " Number Choose: " + numberChooseByRandom);
            
            switch(opt) {
                case "1to18": isWin = numberChooseByRandom >= 1 && numberChooseByRandom <= 18; break;
                case "19to36": isWin = numberChooseByRandom >= 19 && numberChooseByRandom <= 36; break;
                case "odd": isWin = is_odd(numberChooseByRandom, "odd"); break;
                case "even": isWin = is_odd(numberChooseByRandom, "even"); break;
                default: System.out.println("This option not found!"); break;
            }
            if(isWin) {
                balance += bet * 2;
                wins += 1;
            } else {
                balance -= bet;
                defeat += 1;
            }
            percentGame(wins,defeat,matchs);
            statusGameUser(balance,bet,wins,defeat,percentWin,percentDef,i);
        }    
    
    }
}