
public class Main {

    /*
    Toteuta luokka Palaute, joka saa konstruktorin parametrina tekstikuvauksen sekä
    välillä 1-5 olevan arvosanan. Luokan tulee toimia esimerkiksi seuraavasti:

    Palaute p = new Palaute("Kiitti letuista", 2);
    System.out.println(p)

    (2/5) Kiitti letuista

    Kirjoita tämän jälkeen luokka Palauteanalyytikko, jolle voidaan lisätä palautteita.
    Palauteanalyytikon tulee tarjota seuraavat metodit:

    public void add(Palaute p) -- lisää palautteen analysoitavaksi
    public double palautteidenKeskiarvo() -- laskee palautteiden keskiarvon ja palauttaa sen. Mikäli palautteita ei ole, palauta arvo -1
    public ArrayList<Palaute> palautteetValilta(int alku, int loppu) -- palauttaa kaikki palautteet, joiden arvosana on annetulla välillä
    public String toString() -- tulostaa kaikki palautteet

    Palauteanalyytikko pa = new Palauteanalyytikko();
    pa.add(new Palaute("Kiitti letuista", 2));
    pa.add(new Palaute(“Kiitti letuista ja hillosta”, 4));

    System.out.println(pa.palautteidenKeskiarvo());
    System.out.println();
    System.out.println(pa.palautteetValilta(3, 5));
    System.out.println();
    System.out.println(pa);

    3.0

    [(4/5) Kiitti letuista ja hilloista]

    Palautteet:
    * (2/5) Kiitti letuista
    * (4/5) Kiitti letuista ja hillosta

     */
    public static void main(String[] args) throws Exception {

//        Palaute p = new Palaute("Kiitti letuista", 2);
//        System.out.println(p);
        Palauteanalyytikko pa = new Palauteanalyytikko();
        pa.add(new Palaute("Kiitti letuista", 2));
        pa.add(new Palaute("Kiitti letuista ja hillosta", 4));
        pa.add(new Palaute("Ihan kuraa", 1));
        pa.add(new Palaute("Ok", 2));
        pa.add(new Palaute("Jepulis", 3));
        pa.add(new Palaute("Tosi jees", 4));
        pa.add(new Palaute("Mahtavaa palvelua", 5));
        pa.add(new Palaute("Loistavaa", 5));

        System.out.println(pa);
        System.out.println("Palautteiden keskiarvo: " +pa.palautteidenKeskiarvo());
        System.out.println();

        System.out.println("Palautteet väliltä 3-5: " +pa.palautteetValilta(3, 5).toString());
        System.out.println();
    }

}
