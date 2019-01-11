package esimerkki;

/**
 * Peräkkäishaku on hakualgoritmi, joka etsii tietoa taulukosta käymällä taulukkoa
 * läpi alkio alkiolta. Heti kun haettu alkio löytyy, sen indeksi palautetaan.
 *
 * Jos alkiota ei löydy, palautetaan tieto siitä ettei haettavaa alkiota löytynyt
 * -- tämä kerrotaan tyypillisesti palauttamalla indeksin sijaan arvo -1.
 *
 * Pahimmassa tapauksessa, eli tilanteessa missä alkiota ei lödy, algoritmi tekee
 * taulukon koon verran vertailuja. Vaikkapa 10 miljoonaa arvoa sisältävässä taulukossa
 * tämä tarkoittaa kymmentä miljoonaa vertailua. Jos tietoa haetaan useampia kertoja,
 * kannattaa tehokkuutta yrittää parantaa.
 *
 * @author einomies
 */
public class Algoritmit {

    public int perakkaishaku(int[] taulukko, int haettava) {
        for (int i = 0; i < taulukko.length; i++) {
            if (taulukko[i] == haettava) {
                return i;
            }
        }
        return -1;
    }

}
