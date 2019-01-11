import java.util.Scanner;
import java.util.ArrayList;

public class Kayttajatunnukset {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        ArrayList<Tunnus> tunnukset = teeLista();

        System.out.println("Anna tunnus: ");
        String tunnus = lukija.nextLine();
        
        System.out.println("Anna salasana: ");
        String salasana = lukija.nextLine();
        
        boolean tunnusLoytyi = false;
        
        for (int i = 0; i < tunnukset.size(); i++) {
            if (tunnus.equals(tunnukset.get(i).getTunnus())) {
                tunnusLoytyi = true;
                if (salasana.equals(tunnukset.get(i).getSalasana())) {
                    System.out.println("Olet kirjautunut järjestelmään");
                } else {
                    System.out.println("Virheellinen tunnus tai salasana!");
                }
            }
        }
        
        if (!tunnusLoytyi) {
            System.out.println("Virheellinen tunnus tai salasana!");
        }
    }

    private static ArrayList<Tunnus> teeLista() {
        ArrayList<Tunnus> tunnukset = new ArrayList<>();
        
        Tunnus a = new Tunnus();
        a.setTunnus("aleksi");
        a.setSalasana("tappara");
        tunnukset.add(a);
        
        Tunnus b = new Tunnus();
        b.setTunnus("elina");
        b.setSalasana("kissa");
        tunnukset.add(b);
        
        Tunnus c = new Tunnus();
        c.setTunnus("xxxxx");
        c.setSalasana("yyyyy");
        tunnukset.add(c);

        Tunnus d = new Tunnus();
        d.setTunnus("einomies");
        d.setSalasana("jepulis");
        tunnukset.add(d);

        return tunnukset;
    }
}
