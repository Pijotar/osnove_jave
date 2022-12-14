package XOTabla2;

import java.util.ArrayList;

public class XOTabla {
    private ArrayList<String> polje;
    private String winningLineX;
    private String winningLineO;
    private String imeXIgraca;
    private String imeOIgraca;
    private char naPotezu;
    private int brojRedova;

    public int getBrojPolja() {
        return brojRedova;
    }

    public void setBrojPolja(int brojPolja) {
        this.brojRedova = brojPolja;
    }

    public ArrayList<String> getPolje() {
        return polje;
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

    public void pokreniIgru() {
        winningLineX = "";
        winningLineO = "";
        polje.clear();
        for (int i = 0; i < brojRedova * brojRedova; i++) {
            polje.add("" + (i + 1));
        }
        for (int i = 0; i < brojRedova; i++) {
            winningLineX += 'X';
            winningLineO += 'O';
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
        if (!polje.get(index).equals("X") && !polje.get(index).equals("O")) {
            return true;
        } else {
            return false;
        }
    }

    public void zameniIgraca() {
        if (naPotezu == 'X') {
            naPotezu = 'O';
        } else {
            naPotezu = 'X';
        }
    }

    public void odigrajPotez(int index) {
        if (naPotezu == 'X') {
            polje.set(index, "X");
        } else {
            polje.set(index, "O");
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
        for (int i = 0; i < brojRedova; i++) {
            line = "";
            for (int j = 0; j < brojRedova; j++) {
                line += polje.get((i * brojRedova) + j);
                if (line.equals(winningLineX)) {
                    return 'X';
                }
                if (line.equals(winningLineO)) {
                    return 'O';
                }
            }
        }
        for (int i = 0; i < brojRedova; i++) {
            line = "";
            for (int j = 0; j < brojRedova; j++) {
                line += polje.get(i + (j * brojRedova));
                if (line.equals(winningLineX)) {
                    return 'X';
                }
                if (line.equals(winningLineO)) {
                    return 'O';
                }
            }
        }
        line = "";
        for (int i = 0; i < brojRedova; i++) {
            line += polje.get(i * (brojRedova + 1));
            if (line.equals(winningLineX)) {
                return 'X';
            }
            if (line.equals(winningLineO)) {
                return 'O';
            }
        }
        line = "";
        for (int i = 0; i < brojRedova; i++) {
            line += polje.get((i + 1) * (brojRedova - 1));
            if (line.equals(winningLineX)) {
                return 'X';
            }
            if (line.equals(winningLineO)) {
                return 'O';
            }
        }

        return '0';
    }
}
