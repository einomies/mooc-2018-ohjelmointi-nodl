public class Raha {

    private final int euroa;
    private final int senttia;

    public Raha(int euroa, int senttia) {

        if (senttia > 99) {
            euroa += senttia / 100;
            senttia %= 100;
        }

        this.euroa = euroa;
        this.senttia = senttia;
    }

    public int eurot() {
        return euroa;
    }

    public int sentit() {
        return senttia;
    }

    public String toString() {
        String nolla = "";
        if (senttia < 10) {
            nolla = "0";
        }

        return euroa + "." + nolla + senttia + "e";
    }
    
//  Palauttaa uuden raha-olion, joka on arvoltaan yhtä suuri kuin se olio,
//  jolle metodia kutsuttiin ja parametrina oleva olio yhteensä.
    public Raha plus(Raha lisattava) {
        int eurot = this.eurot() + lisattava.eurot();
        int sentit = this.sentit() + lisattava.sentit();
        return new Raha(eurot, sentit);
    }
    
//  Palauttaa true, jos raha-olio jolle metodia kutsutaan on arvoltaan pienempi
//  kuin raha-olio, joka on metodin parametrina.
    public boolean vahemman(Raha verrattava) {
        if (this.euroa < verrattava.euroa) {
            return true;
        } else if (this.euroa == verrattava.euroa) {
            if (this.senttia < verrattava.senttia) {
                return true;
            }
        }
        return false;
    }
    /*
    Fiksumpi tapa:
    public boolean vahemman(Raha verrattava) {
        return (100 * euroa + senttia) < (100 * verrattava.eurot() + verrattava.sentit());
    }
    */
    
//  Palauttaa uuden raha-olion, jonka arvoksi tulee sen olion jolle metodia kutsuttiin
//  ja parametrina olevan olion arvojen erotus. Jos erotus on negatiivinen, tulee
//  luotavan raha-olion arvoksi 0.
    public Raha miinus(Raha vahennettava) {
        int sentitUusi = (this.euroa*100 + this.senttia)-(vahennettava.euroa*100 + vahennettava.senttia);
        if (sentitUusi > 0) {
            return new Raha(0, sentitUusi);
        }
        return new Raha(0, 0);
    }

}
