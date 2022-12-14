package XOTabla3;

import java.util.ArrayList;

public class XOTabla {
    private ArrayList<String> polje;
    private String winningLineX;
    private String winningLineO;
    private String imeXIgraca;
    private String imeOIgraca;
    private char naPotezu;
    private int brojRedova;

    public int getBrojRedova() {
        return brojRedova;
    }

    public void setBrojRedova(int brojRedova) {
        this.brojRedova = brojRedova;
    }

    public String getImeXIgraca() {
        return imeXIgraca;
    }

    public String getImeOIgraca() {
        return imeOIgraca;
    }

    public char getNaPotezu() {
        return naPotezu;
    }

    public void setPolje(ArrayList<String> polje) {
        this.polje = polje;
    }

    public void setImeXIgraca(String imeXIgraca) {
        this.imeXIgraca = imeXIgraca;
    }

    public void setImeOIgraca(String imeOIgraca) {
        this.imeOIgraca = imeOIgraca;
    }

    public void winningLine(int tempInt) {
        winningLineX = "";
        winningLineO = "";
        for (int i = 0; i < tempInt; i++) {
            winningLineX += 'X';
            winningLineO += 'O';
        }
    }

    public void pokreniIgru() {

        polje.clear();
        for (int i = 0; i < brojRedova * brojRedova; i++) {
            polje.add("" + (i + 1));
        }
        naPotezu = 'X';
    }

    public void stampaj() {
        System.out.print("|");
        for (int i = 0; i < brojRedova * brojRedova; i++) {
            if (i < 9 || !poljePrazno(i)) {
                System.out.print(" " + polje.get(i) + "|");
            } else {
                System.out.print("" + polje.get(i) + "|");
            }
            if ((i + 1) % brojRedova == 0) {
                System.out.println();
                if (i != (brojRedova * brojRedova) - 1) {
                    System.out.print("|");
                }
            }


        }
        System.out.println("Igrac X: " + imeXIgraca);
        System.out.println("Igrac O: " + imeOIgraca);
    }

    public boolean poljePrazno(int index) {
        if (GameLogic.isBetweenOrEqual(0, index, polje.size() - 1)) {
            if (!polje.get(index).equals("X") && !polje.get(index).equals("O")) {
                return true;
            }
        }
        return false;
    }

    public void zameniIgraca() {
        if (naPotezu == 'X') {
            naPotezu = 'O';
        } else {
            naPotezu = 'X';
        }
    }

    public void odigrajPotez(int index) {
        index -= 1;
        if (poljePrazno(index)) {
            if (naPotezu == 'X') {
                polje.set(index, "X");
            } else {
                polje.set(index, "O");
            }
            zameniIgraca();
        } else {
            System.out.println("Potez nije validan!");
        }
    }

    public boolean popunjenaTabla() {
        for (int i = 0; i < brojRedova * brojRedova; i++) {
            if (poljePrazno(i)) {
                return false;
            }
        }
        return true;

    }

    public char checkWinner() {
        String line;
        int tempInt;
        //Gledaju se redovi
        for (int i = 0; i < brojRedova; i++) {
            line = "";
            for (int j = 0; j < brojRedova; j++) {
                line += polje.get((i * brojRedova) + j);
                if (line.contains(winningLineX)) {
                    return 'X';
                }
                if (line.contains(winningLineO)) {
                    return 'O';
                }
            }
        }
        //Gledaju se kolone
        for (int i = 0; i < brojRedova; i++) {
            line = "";
            for (int j = 0; j < brojRedova; j++) {
                line += polje.get(i + (j * brojRedova));
                if (line.contains(winningLineX)) {
                    return 'X';
                }
                if (line.contains(winningLineO)) {
                    return 'O';
                }
            }
        }
        //Gledaju se dijagonale \ prvog reda
        for (int i = 0; i < brojRedova; i++) {
            line = "";
            for (int j = 0; j < brojRedova; j++) {
                tempInt = i + j * (brojRedova + 1);
                if (tempInt < polje.size()) {
                    line += polje.get(tempInt);
                }
                if (line.contains(winningLineX)) {
                    return 'X';
                }
                if (line.contains(winningLineO)) {
                    return 'O';
                }
            }
        }
        //Gledaju se dijagonale \ prve kolone
        for (int i = 0; i < brojRedova; i++) {
            line = "";
            for (int j = 0; j < brojRedova; j++) {
                tempInt = i * brojRedova + j * (brojRedova + 1);
                if (tempInt < polje.size()) {
                    line += polje.get(tempInt);
                }
                if (line.contains(winningLineX)) {
                    return 'X';
                }
                if (line.contains(winningLineO)) {
                    return 'O';
                }
            }
        }
        // Gledaju se dijagonale / prvog reda
        for (int i = 0; i < brojRedova; i++) {
            line = "";
            for (int j = 0; j < brojRedova; j++) {
                tempInt = i + j * (brojRedova - 1);
                if (tempInt < polje.size()) {
                    line += polje.get(tempInt);
                }
                if (line.contains(winningLineX)) {
                    return 'X';
                }
                if (line.contains(winningLineO)) {
                    return 'O';
                }
            }
        }
        // Gledaju se dijagonale / zadnje kolone
        for (int i = 0; i < brojRedova; i++) {
            line = "";
            for (int j = 0; j < brojRedova; j++) {
                tempInt = (i + 1) * brojRedova - 1 + j * (brojRedova - 1);
                if (tempInt < polje.size()) {
                    line += polje.get(tempInt);
                }
                if (line.contains(winningLineX)) {
                    return 'X';
                }
                if (line.contains(winningLineO)) {
                    return 'O';
                }
            }
        }
        return '0';
    }

    public void proglasiPobednika() {
        if (checkWinner() == 'X') {
            System.out.println("Pobednik je " + getImeXIgraca() + "!");
        }
        if (checkWinner() == 'O') {
            System.out.println("Pobednik je " + getImeOIgraca() + "!");
        }
        if (popunjenaTabla()) {
            System.out.println("Nereseno");
        }
        System.out.println();
        System.out.print("Jos jedna igra? y/n: ");
    }
}
