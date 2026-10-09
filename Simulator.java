import java.util.Random;
import java.util.Scanner;

public class Simulator {
    public static void main(String[] args){
        GlobalAttributes global = new GlobalAttributes();
        RoulletFunctions roullet = new RoulletFunctions();
        Scanner scn = new Scanner(System.in);

        System.out.println("===ROULLET GAME SIMULATOR===");
        System.out.println("[1] Number \n[2] Dozens \n[3] Low and High");
        int opt = scn.nextInt();
        scn.nextLine();
        
        switch(opt) {
            case 1:
                roullet.numberFunction();
                break;
            case 2:
                System.out.print("DOZEN -> ");
                String dozen = scn.nextLine();
                roullet.dozensFunction(dozen);
                break;
            case 3:
                System.out.println("[19to36] [1to18] [odd] [even]");
                String lowH = scn.nextLine();
                roullet.lowAndHigh(lowH);
                break;
            default:
                System.out.println("I don't know this option!");
        }
    }
}