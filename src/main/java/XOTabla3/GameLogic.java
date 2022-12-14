package XOTabla3;

//Ova klasa sluzi da stavljam static metode u nju
public class GameLogic {
    //Metod koji sluzi da spreci crash usled pogresnog unosa
    //Vraca true ako je moguce pretvoriti string u integer, false ako ne
    public static int isInteger(String input) {
        try {
            int tempInt = Integer.parseInt(input);
            return tempInt;
        } catch (Exception e) {
            return input.length();
        }
    }

    public static boolean isBetweenOrEqual(int min, int inputInt, int max) {
        if (inputInt <= max && min <= inputInt) {
            return true;
        }
        return false;
    }
}
