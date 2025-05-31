package projet;

import java.util.Random;

public class LoiNature {
    private static final int P1 = 30;
    private static final int P2 = 20;
    private static final int P3 = 2;
    private static final int P4 = 1;
    private static final int P5 = 80;
    private static final int P6 = 30;
    private static final int P7 = 50;


    public boolean placerProie() {
        Random r = new Random();
        return r.nextInt(100) <= P1;
    }

    public boolean placerPredateur() {
        Random r = new Random();
        return r.nextInt(100) <= P2;
    }

    public boolean reproduireProie() {
        Random r = new Random();
        return r.nextInt(100) <= P3;
    }

    public boolean reproduirePredateur() {
        Random r = new Random();
        return r.nextInt(100) <= P4;
    }

    public boolean realiserPredation() {
        Random r = new Random();
        return r.nextInt(100) <= P5;
    }

    public boolean deplacerProie() {
        Random r = new Random();
        return r.nextInt(100) <= P6;
    }

    public boolean deplacerPredateur() {
        Random r = new Random();
        return r.nextInt(100) <= P7;
    }


}
