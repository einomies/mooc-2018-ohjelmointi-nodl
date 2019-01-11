/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla;

import java.util.ArrayList;

/**
 *
 * @author einomies
 */
public class TestiPositiotArvot {

    public static void main(String[] args) {

        ArrayList<PositiotArvot> arvot = new ArrayList<>();

        arvot.add(new PositiotArvot(0, 0, "X"));
        arvot.add(new PositiotArvot(0, 1, "X"));
        arvot.add(new PositiotArvot(0, 2, " "));

        arvot.add(new PositiotArvot(1, 0, " "));
        arvot.add(new PositiotArvot(1, 1, "O"));
        arvot.add(new PositiotArvot(1, 2, " "));

        arvot.add(new PositiotArvot(2, 0, " "));
        arvot.add(new PositiotArvot(2, 1, " "));
        arvot.add(new PositiotArvot(2, 2, " "));

        tulostaMerkit(arvot);

        boolean samaaMerkkia = false;
        int lkmX = 0;
        int lkmY = 0;
        for (int a = 0; a < 3; a++) {
            if (samaaMerkkia) {
                break;
            }
            lkmX = 0;
            lkmY = 0;
            String ekaMerkkiX = "";
            String ekaMerkkiY = "";
            for (int b = 0; b < arvot.size(); b++) {
                if (arvot.get(b).getX() == a) {
                    if (arvot.get(b).getArvo().equals("X") || arvot.get(b).getArvo().equals("O")) {
                        lkmX++;
                        if (lkmX == 1) {
                            ekaMerkkiX = arvot.get(b).getArvo();
                        } else {
                            if (arvot.get(b).getArvo().equals(ekaMerkkiX)) {
                                samaaMerkkia = true;
                            } else {
                                samaaMerkkia = false;
                                break;
                            }
                        }
                    } else {
                        samaaMerkkia = false;
                    }
                }
            }
            if (lkmX == 3 && samaaMerkkia) {
                break;
            }
            for (int c = 0; c < arvot.size(); c++) {
                if (arvot.get(c).getY() == a) {
                    if (arvot.get(c).getArvo().equals("X") || arvot.get(c).getArvo().equals("O")) {
                        lkmY++;
                        if (lkmY == 1) {
                            ekaMerkkiY = arvot.get(c).getArvo();
                        } else {
                            if (arvot.get(c).getArvo().equals(ekaMerkkiY)) {
                                samaaMerkkia = true;
                            } else {
                                samaaMerkkia = false;
                                break;
                            }
                        }
                    } else {
                        samaaMerkkia = false;
                    }
                }
            }
            if (lkmY == 3 && samaaMerkkia) {
                break;
            }
        }

        if (!samaaMerkkia) {
            String keskimmainen = "";
            for (PositiotArvot arvo : arvot) {
                if (arvo.getX() == 1 && arvo.getY() == 1) {
                    keskimmainen = arvo.getArvo();
                }
            }
            for (PositiotArvot arvo : arvot) {
                if ((arvo.getX() == 0 && arvo.getY() == 0)
                        || (arvo.getX() == 2 && arvo.getY() == 2)) {
                    if (!arvo.getArvo().equals(" ") && arvo.getArvo().equals(keskimmainen)) {
                        samaaMerkkia = true;
                    } else {
                        samaaMerkkia = false;
                        break;
                    }
                }
            }
            if (!samaaMerkkia) {
                for (PositiotArvot arvo : arvot) {
                    if ((arvo.getX() == 2 && arvo.getY() == 0)
                            || (arvo.getX() == 0 && arvo.getY() == 2)) {
                        if (!arvo.getArvo().equals(" ") && arvo.getArvo().equals(keskimmainen)) {
                            samaaMerkkia = true;
                        } else {
                            samaaMerkkia = false;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println("samaaMerkkia: " + samaaMerkkia);
    }

    private static void tulostaMerkit(ArrayList<PositiotArvot> arvot) {
        ArrayList<String> rivit = new ArrayList<>();

        for (int i = 0; i <= maxArvo(arvot); i++) {
            String rivi = "";
            for (int j = 0; j < arvot.size(); j++) {
                PositiotArvot pa = arvot.get(j);
                if (pa.getY() == i) {
                    rivi += pa.getArvo();
                    if (rivi.length() == 3) {
                        rivit.add(rivi);
                        rivi = "";
                    }
                }
            }

        }

        rivit.forEach((rivi) -> {
            System.out.println(rivi.substring(0, 1)
                    + " "
                    + rivi.substring(1, 2)
                    + " "
                    + rivi.substring(2, 3));
        });
    }

    private static int maxArvo(ArrayList<PositiotArvot> arvot) {
        int max = 0;
        for (PositiotArvot positiotArvot : arvot) {
            if (positiotArvot.getX() > max) {
                max = positiotArvot.getX();
            }
        }
        return max;
    }

}
