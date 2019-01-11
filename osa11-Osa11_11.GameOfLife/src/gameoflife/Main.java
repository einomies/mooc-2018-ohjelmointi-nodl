package gameoflife;

public class Main {

    public static void main(String[] args) {
        // voit tehdä tänne testikoodia

        // Jos ohjelmassa on useampi luokka, joka sisältää main-metodin, voi
        // halutun main metodin käynnistää valitsemalla luokka vasemmalla
        // olevasta projektilistauksesta ja painamalla oikealla
        // hiirennapilla "Run File".
//        testi01();
        testi02();
//        testi03();
    }

    private static void testi01() {
        GameOfLife gol = new GameOfLife(3, 3);

        int[][] taulukko = new int[3][3];
        taulukko[0][0] = 1;
        taulukko[0][1] = 1;
        taulukko[1][1] = 1;
        taulukko[2][2] = 1;

        System.out.println(gol.elossaOleviaNaapureita(taulukko, 0, 0));
        System.out.println(gol.elossaOleviaNaapureita(taulukko, 1, 0));
        System.out.println(gol.elossaOleviaNaapureita(taulukko, 1, 1));
        System.out.println(gol.elossaOleviaNaapureita(taulukko, 2, 2));
        /*
        2
        3
        3
        1
         */
    }

    private static void testi02() {
        GameOfLife gol = new GameOfLife(4, 4);

        int[][] taulukko = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 0, 1, 0}, {0, 1, 0, 1}};

        System.out.println(gol.elossaOleviaNaapureita(taulukko, 0, 0));
        System.out.println(gol.elossaOleviaNaapureita(taulukko, 1, 1));
        System.out.println(gol.elossaOleviaNaapureita(taulukko, 2, 2));
        System.out.println(gol.elossaOleviaNaapureita(taulukko, 3, 3));
        /*
        3
        7
        5
        1
         */
    }

    private static void testi03() {
    }

}
