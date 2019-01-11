package esimerkki;

public class Main01 {

    /*
	public static void main(String[] args) throws Exception {
		Tallentaja tallentaja = new Tallentaja();
		tallentaja.kirjoitaTiedostoon("paivakirja.txt", "Rakas päiväkirja, tänään oli kiva päivä.");
	}
     */
    public static void main(String[] args) {
        try {
            Tallentaja tallentaja = new Tallentaja();
            tallentaja.kirjoitaTiedostoon("paivakirja.txt", "Rakas päiväkirja, tänään ei ollut kiva päivä.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
