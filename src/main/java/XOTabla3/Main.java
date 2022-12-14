package XOTabla3; //ver 3.0.3

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Varijable

        Scanner scanner = new Scanner(System.in); //skener
        XOTabla tabla = new XOTabla(); //ovde se skoro sve odvija
        tabla.setPolje(new ArrayList<String>()); //lista polja
        boolean igraTraje = true; //sluzi da bi igraci mogli da ponavljaju igru bez da ponovo pokrecu program

        //Krecemo lagano sa imenima

        System.out.print("Unesite ime igraca X: ");
        tabla.setImeXIgraca(scanner.next());
        System.out.print("Unesite ime igraca O: ");
        tabla.setImeOIgraca(scanner.next());

        //Tabela se pravi

        while (igraTraje) {
            System.out.print("Unesite broj redova: ");
            tabla.setBrojRedova(Math.max(GameLogic.isInteger(scanner.next()), 3));
            System.out.print("Unesite velicinu kombinacije: ");
            tabla.winningLine(Math.min(Math.max(GameLogic.isInteger(scanner.next()), 3), tabla.getBrojRedova()));
            tabla.pokreniIgru(); //cisti prethodnu tablu i popunjava novu praznim poljima

            //while petlja u kojoj se igra

            while (!tabla.popunjenaTabla() && tabla.checkWinner() == '0') {

                tabla.stampaj();
                System.out.print("Na potezu je igrac " + tabla.getNaPotezu() + ": ");

                tabla.odigrajPotez(GameLogic.isInteger(scanner.next()));
            }

            tabla.stampaj();
            System.out.println();
            tabla.proglasiPobednika();
            if (!scanner.next().equals("y")) {
                igraTraje = false;
            }
        }

    }
}


