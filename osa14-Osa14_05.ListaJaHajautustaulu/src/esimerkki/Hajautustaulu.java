package esimerkki;

/**
 * Hajautustaulun toimintaperiaate perustuu siihen, että avain-arvo -parit
 * jaetaan hajautusarvon perusteella pieniin joukkoihin. Tällöin avaimen
 * perusteella haettaessa käydään läpi vain hyvin pieni joukko avain-arvo
 * -pareja -- olettaen toki, että hajautusarvo on järkevä.
 *
 * Jos hajautusarvo on aina sama -- esimerkiksi 1 -- vastaa hajautustaulun
 * sisäinen toteutus listaa -- kaikki arvot ovat samalla listalla. Jos taas
 * hajautusarvo on hyvin satunnainen, arvot hajautetaan mahdollisimman
 * tasaisesti taulukon eri listoille.
 *
 * Hajautustaulu toimii lisäksi siten, että hajautustaulun käyttämää taulukkoa
 * kasvatetaan mikäli arvojen määrä on tarpeeksi iso (tyypillisesti noin 75%
 * taulukon koosta). Tyypillisesti miljoonia avain-arvo -pareja sisältävän
 * hajautustaulun taulukon yhdessä indeksissä on vain muutama avain-arvo -pari.
 * Tämä tarkoittaa käytännössä sitä, että avain-arvo -parin olemassaolon
 * selvittämiseen tarvitaan vain hajautusarvon laskeminen sekä muutaman olion
 * tarkastelu -- tämä on paljon nopeampaa kuin listan läpikäynti.
 *
 * @author einomies
 * @param <K>
 * @param <V>
 */
public class Hajautustaulu<K, V> {

    private Lista<Pari<K, V>>[] arvot;
    private int arvoja;

    public Hajautustaulu() {
        this.arvot = new Lista[32];
        this.arvoja = 0;
    }

    /**
     * Toteutetaan ensin metodi public V hae(K avain), jota käytetään arvon
     * hakemiseen avaimen perusteella. Metodissa lasketaan ensin avaimen
     * hajautusarvo ja päätellään sen perusteella hajautustaulun sisäisen
     * taulukon indeksi, mistä arvoja haetaan. Mikäli kyseisessä indeksissä ei
     * ole listaa, ei indeksiin ole lisätty vielä yhtäkään avain-arvo -paria,
     * eikä avaimelle ole tallennettu arvoa. Tällöin palautetaan null. Muussa
     * tapauksessa taulukon indeksissä oleva lista käydään läpi, ja avaimen
     * yhtäsuuruutta vertaillaan jokaiseen listan avain-arvo -parin avaimeen.
     * Mikäli joku listalla olevista avaimista vastaa avainta, jonka perusteella
     * arvoa haetaan, palautetaan kyseinen arvo. Muulloin avainta (ja siihen
     * liittyvää arvoa) ei löydy, ja palautetaan arvo null.
     */
    public V hae(K avain) {
        int hajautusArvo = Math.abs(avain.hashCode() % this.arvot.length);
        if (this.arvot[hajautusArvo] == null) {
            return null;
        }

        Lista<Pari<K, V>> arvotIndeksissa = this.arvot[hajautusArvo];

        for (int i = 0; i < arvotIndeksissa.koko(); i++) {
            if (arvotIndeksissa.arvo(i).getAvain().equals(avain)) {
                return arvotIndeksissa.arvo(i).getArvo();
            }
        }
        return null;
    }

    /**
     * Hajautustaulun kokoa kasvatetaan aina jos hajautustaulussa olevien
     * avain-arvo -parien määrä on yli 75% taulukon koosta.
     */
    public void lisaa(K avain, V arvo) {
        Lista<Pari<K, V>> arvotIndeksissa = haeAvaimeenLittyvaLista(avain);
        int indeksi = haeAvaimenIndeksi(arvotIndeksissa, avain);

        if (indeksi < 0) {
            arvotIndeksissa.lisaa(new Pari<>(avain, arvo));
            this.arvoja++;
        } else {
            arvotIndeksissa.arvo(indeksi).setArvo(arvo);
        }

        if (1.0 * this.arvoja / this.arvot.length > 0.75) {
            kasvata();
        }
    }

    private void kasvata() {
        // luodaan uusi taulukko
        Lista<Pari<K, V>>[] uusi = new Lista[this.arvot.length * 2];

        for (int i = 0; i < this.arvot.length; i++) {
            // kopioidaan vanhan taulukon arvot uuteen
//            kasvata(uusi, indeksista);
            kopioi(uusi, i);
        }

        // korvataan vanha taulukko uudella
        this.arvot = uusi;
    }

    private void kopioi(Lista<Pari<K, V>>[] uusi, int indeksista) {
        System.out.print("esimerkki.Hajautustaulu.kopioi(): ");
        System.out.println(indeksista+"/"+this.arvot[indeksista].koko());
        for (int i = 0; i < this.arvot[indeksista].koko(); i++) {
            Pari<K, V> arvo = this.arvot[indeksista].arvo(i);

            int hajautusarvo = Math.abs(arvo.getAvain().hashCode() % uusi.length);
            if (uusi[hajautusarvo] == null) {
                uusi[hajautusarvo] = new Lista<>();
            }

            uusi[hajautusarvo].lisaa(arvo);
        }
    }

    private Lista<Pari<K, V>> haeAvaimeenLittyvaLista(K avain) {
        int hajautusArvo = Math.abs(avain.hashCode() % arvot.length);
        if (arvot[hajautusArvo] == null) {
            arvot[hajautusArvo] = new Lista<>();
        }
        return arvot[hajautusArvo];
    }

    private int haeAvaimenIndeksi(Lista<Pari<K, V>> lista, K avain) {
        for (int i = 0; i < lista.koko(); i++) {
            if (lista.arvo(i).getAvain().equals(avain)) {
                return i;
            }
        }
        return -1;
    }

    public V poista(K avain) {
        Lista<Pari<K, V>> arvotIndeksissa = haeAvaimeenLittyvaLista(avain);
        if (arvotIndeksissa == null || arvotIndeksissa.koko() == 0) {
            return null;
        }

        int indeksi = haeAvaimenIndeksi(arvotIndeksissa, avain);
        if (indeksi < 0) {
            return null;
        }

        Pari<K, V> pari = arvotIndeksissa.arvo(indeksi);
        arvotIndeksissa.poista(pari);
        return pari.getArvo();
    }

}
