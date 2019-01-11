
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import jdk.nashorn.internal.objects.NativeArray;

// luo tänne luokkaan oma tekoälysi Uno-peliä varten
public class Tekoalypelaaja implements Pelaaja {

    // Saat luoda tarvittaessa oliomuuttujia. Jos luot konstruktorin, varmista
    // että tekoäly toimii myös parametrittomalla konstruktorilla, eli kutsulla
    // Tekoalypelaaja pelaaja = new Tekoalypelaaja();
    
    final String[] okVarit = {"Keltainen", "Punainen", "Sininen", "Vihreä"};

    public Tekoalypelaaja() {

    }
    
    /**
     * Metodia pelaa kutsutaan kun on pelaajan vuoro ja pelaajan tulee valita
     * seuraavaksi pelattava kortti.
     *
     * Parametri omatKortit sisältää pelaajan omat kortit, parametri
     * paallimmainen kertoo päällimmäisenä näkyvän kortin ja parametri vari
     * kertoo odotetun värin. Väri kerrotaan esimerkiksi jos edellinen pelaaja
     * on pelannut Villin kortin, jolla voi valita värin uudestaan.
     *
     * Metodin tulee palauttaa sen kortin indeksi, jonka haluat pelata. Jos et 
     * voi pelata mitään korttia, palauta arvo -1. Tässä tapauksessa käteesi 
     * lisätään uusi kortti.
     */
    @Override
    public int pelaa(ArrayList<Kortti> omatKortit, Kortti paallimmaisin, String vari, Pelitilanne tilanne) {

        if (paallimmaisin.onOhitus() && paallimmaisin.getVari().equalsIgnoreCase("vihreä")) {
            tulostaOmatKortit(omatKortit);
        }

        if (onVari(vari, okVarit)) {
            if (samaaVariaLkm(omatKortit, null, vari) > 0) {
                return valitseSamaVariMax(omatKortit, vari);
            } else {
                return valitseVillikortti(omatKortit);
            }
        }

        String omaVariEniten = variEniten(omatKortit, okVarit);

        if (paallimmaisin.onVillikortti() && !onVari(vari, okVarit)) {
            if (onVari(omaVariEniten, okVarit)) {
                return valitseSamaVariMax(omatKortit, omaVariEniten);
            }
        }
        
//      Tutkitaan, voiko/kannattaako vaihtaa väriä
        if (paallimmaisin.onNumerokortti()) {
            Kortti samaNroEriVari = samaNroEriVariaLkm(omatKortit, paallimmaisin, okVarit);
            if (samaNroEriVari.getNumero() > samaaVariaLkm(omatKortit, paallimmaisin, vari)) {
            	samaNroEriVari.setNumero(paallimmaisin.getNumero());
            	return valitseSamaNroEriVari(omatKortit, samaNroEriVari);
            }
        }

        if (paallimmaisin.onSuunnanvaihto() || paallimmaisin.onOhitus()) {
        	if (valitseSamaVariMax(omatKortit, paallimmaisin.getVari()) >= 0) {
                return valitseSamaVariMax(omatKortit, paallimmaisin.getVari());
        	}
        	if (valitseErikoisVariKortti(omatKortit, paallimmaisin) >= 0 ) {
            	return valitseErikoisVariKortti(omatKortit, paallimmaisin);
        	} else {
                return valitseVillikortti(omatKortit);
        	}
        }

        if (samaaVariaLkm(omatKortit, paallimmaisin, vari) > 0) {
            if (!onVari(vari, okVarit)) {
                return valitseSamaVariMax(omatKortit, paallimmaisin.getVari());
            } else {
                return valitseSamaVariMax(omatKortit, vari);
            }
        } else {
            if (loytyySamaNro(omatKortit, paallimmaisin)) {
                return valitseSamaNroEriVari(omatKortit, paallimmaisin);
            } else {
                return valitseVillikortti(omatKortit);
            }
        }
    }

    private int valitseErikoisVariKortti(ArrayList<Kortti> omatKortit, Kortti paallimmaisin) {
		for (int i = 0; i < omatKortit.size(); i++) {
			if (omatKortit.get(i).getKorttityyppi().equalsIgnoreCase(paallimmaisin.getKorttityyppi())) {
				return i;
			}
		}
		return -1;
	}

	@Override
    public String valitseVari(ArrayList<Kortti> omatKortit) {
        /*
        String[] okVarit = {"Punainen", "Vihreä", "Sininen", "Keltainen"};
        HashMap<String, Integer> variLkmTaulukko = new HashMap<>();
        for (int i = 0; i < okVarit.length; i++) {
            variLkmTaulukko.put(okVarit[i], 0);
        }
        int lkm = 0;
        for (Kortti kortti : omatKortit) {
            for (int i = 0; i < okVarit.length; i++) {
                if (kortti.getVari().equalsIgnoreCase(okVarit[i])) {
                    lkm = variLkmTaulukko.get(okVarit[i]) + 1;
                    variLkmTaulukko.put(okVarit[i], lkm);
                }
            }
        }
        int maxLkm = 0;
        String vari = "";
        for (Map.Entry<String, Integer> entry : variLkmTaulukko.entrySet()) {
            if (entry.getValue() > maxLkm) {
                maxLkm = entry.getValue();
                vari = entry.getKey();
            }
        }
        if (maxLkm > 0) {
            return vari;
        }
        Random random = new Random();
        return okVarit[random.nextInt(okVarit.length-1)];
        */
        String vari = variEniten(omatKortit, okVarit);
        if (onVari(vari, okVarit)) {
            return vari;
        } else {
            Random random = new Random();
            return okVarit[random.nextInt(okVarit.length-1)];
        }
    }

    @Override
    public String nimi() {
        // kirjoita tänne nimimerkkisi, jonka haluat mahdollisesti näkyvän 
        // myös muualla
        return "Einomies";
    }
    
    private String variEniten(ArrayList<Kortti> omatKortit, String[] okVarit) {
        Integer lkm = 0;
        String omaVariEniten = "-";

        HashMap<String, Integer> varit = new HashMap<>();
        for (int i = 0; i < okVarit.length; i++) {
            varit.put(okVarit[i], 0);
        }
        
        for (Kortti kortti : omatKortit) {
            
            for (Map.Entry<String, Integer> entry : varit.entrySet()) {
                if (kortti.getVari().equalsIgnoreCase(entry.getKey())) {
                    varit.put(entry.getKey(), entry.getValue() + 1);
                }
            }
//            if (kortti.getVari().equalsIgnoreCase("keltainen")) {
//                varit.put("keltainen", varit.get("keltainen") + 1);
//            }
//            if (kortti.getVari().equalsIgnoreCase("punainen")) {
//                varit.put("punainen", varit.get("punainen") + 1);
//            }
//            if (kortti.getVari().equalsIgnoreCase("sininen")) {
//                varit.put("sininen", varit.get("sininen") + 1);
//            }
//            if (kortti.getVari().equalsIgnoreCase("vihreä")) {
//                varit.put("vihreä", varit.get("vihreä") + 1);
//            }
        }
        
        for (Map.Entry<String, Integer> entry : varit.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (entry.getValue().compareTo(lkm) > 0 ) {
                omaVariEniten = entry.getKey();
            }
        }
        
        return omaVariEniten;
    }

    private int samaaVariaLkm(ArrayList<Kortti> omatKortit, Kortti paallimmaisin, String vari) {
        int lkm = 0;
        if (paallimmaisin != null) {
            if (onVari(paallimmaisin.getVari(), okVarit)) {
                for (Kortti kortti : omatKortit) {
                    if (kortti.getVari().equalsIgnoreCase(paallimmaisin.getVari())) {
                        lkm++;
                    }
                }
            }
        }
        if (onVari(vari, okVarit)) {
            for (Kortti kortti : omatKortit) {
                if (kortti.getVari().equalsIgnoreCase(vari)) {
                    lkm++;
                }
            }
        }
        return lkm;
    }

    private Kortti samaNroEriVariaLkm(ArrayList<Kortti> omatKortit, Kortti paallimmaisin, String[] okVarit) {
        Kortti tulos = new Kortti("Numero", "", 0);
        int lkm = 0;
        HashMap<String, Integer> varit = new HashMap<>();
        for (int i = 0; i < okVarit.length; i++) {
        	if (!okVarit[i].equalsIgnoreCase(paallimmaisin.getVari())) {
                varit.put(okVarit[i], 0);
        	}
        }
        if (paallimmaisin != null) {
            if (paallimmaisin.onVarikortti()) {
                for (Kortti kortti : omatKortit) {
                    if (kortti.onVarikortti()
                    		&& !kortti.getVari().equalsIgnoreCase(paallimmaisin.getVari())
                    		&& kortti.getNumero() == paallimmaisin.getNumero()) {
                        for (Map.Entry<String, Integer> entry : varit.entrySet()) {
                            String key = entry.getKey();
                            Integer value = entry.getValue();
                            if (key.equalsIgnoreCase(kortti.getVari())) {
                                varit.put(key, value + 1);
                            }
                        }
                    }
            	}
            }
        }
        int maxLkm=0;
        for (Map.Entry<String, Integer> entry : varit.entrySet()) {
            if (entry.getValue() > maxLkm) {
            	tulos.setVari(entry.getKey());
            	tulos.setNumero(entry.getValue());
            }
        }
        return tulos;
    }

    private int valitseSamaVariMax(ArrayList<Kortti> omatKortit, String vari) {
        int maxNro = -1;
        int index = -1;
        for (int i = 0; i < omatKortit.size(); i++) {
            if (omatKortit.get(i).getVari().equalsIgnoreCase(vari) 
                    && omatKortit.get(i).getNumero() >= maxNro) {
                maxNro = omatKortit.get(i).getNumero();
                index = i;
            }
        }
        return index;
    }

//    private int valitseSamaNro(ArrayList<Kortti> omatKortit, Kortti paallimmaisin) {
//        int maxNro = -1;
//        int index = -1;
//        for (int i = 0; i < omatKortit.size(); i++) {
//            if (omatKortit.get(i).getVari().equalsIgnoreCase(vari) 
//                    && omatKortit.get(i).getNumero() >= maxNro) {
//                maxNro = omatKortit.get(i).getNumero();
//                index = i;
//            }
//        }
//        return index;
//    }

    private int valitseVillikortti(ArrayList<Kortti> omatKortit) {
        int index = -1;
        for (int i = 0; i < omatKortit.size(); i++) {
            if (omatKortit.get(i).onVillikortti()) {
                index = i;
            }
        }
        return index;
    }

    private boolean onVari(String vari, String[] okVarit) {
        for (int i = 0; i < okVarit.length; i++) {
            if (okVarit[i].equalsIgnoreCase(vari)) {
                return true;
            }
        }
        return false;
    }

    private boolean loytyySamaNro(ArrayList<Kortti> omatKortit, Kortti paallimmaisin) {
        if (paallimmaisin.onNumerokortti()) {
            for (Kortti kortti : omatKortit) {
                if (kortti.getNumero() == paallimmaisin.getNumero()) {
                    return true;
                }
            }
        }
        return false;
    }

    private int valitseSamaNroEriVari(ArrayList<Kortti> omatKortit, Kortti samaNroEriVari) {
        int index = -1;
        for (int i = 0; i < omatKortit.size(); i++) {
            if (omatKortit.get(i).getNumero() == samaNroEriVari.getNumero()
            		&& omatKortit.get(i).getVari().equalsIgnoreCase(samaNroEriVari.getVari())) {
                index = i;
            }
        }
        return index;
    }

    private void tulostaOmatKortit(ArrayList<Kortti> omatKortit) {
        for (Kortti kortti : omatKortit) {
            System.out.println(kortti);
        }
    }

}
