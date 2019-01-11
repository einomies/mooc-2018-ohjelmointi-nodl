import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Arvosanatilastot {

    private ArrayList<Integer> pisteet;

    public Arvosanatilastot() {
        this.pisteet = new ArrayList<>();
    }

    public void lisaaPistemaara(int pisteet) {
        if (pisteet < 0 || pisteet > 100) {
            return;
        }
        this.pisteet.add(pisteet);
    }

    public void tulosta() {
        double summa = 0;
        double hyvaksyttyjenSumma = 0;
        int hyvaksyttyjenLkm = 0;
        for (Integer piste : pisteet) {
            summa += piste;
            if (piste >= 70) {
                hyvaksyttyjenSumma += piste;
                hyvaksyttyjenLkm++;
            }
        }
        System.out.println("Pisteiden keskiarvo (kaikki): " + summa / this.pisteet.size());
        if (hyvaksyttyjenLkm > 0) {
            System.out.println("Pisteiden keskiarvo (hyväksytyt): " + hyvaksyttyjenSumma / hyvaksyttyjenLkm);
        } else {
            System.out.println("Pisteiden keskiarvo (hyväksytyt): -");
        }
        System.out.println("Hyväksymisprosentti: " + (100.0 * hyvaksyttyjenLkm / this.pisteet.size()));
        System.out.println("Arvosanajakauma:");
        for (int i = 5; i >= 0; i--) {
            System.out.println(i + ": " + tahtienTulostus(i));
        }
    }

    private String tahtienTulostus(int arvosana) {
        int montakotahtea = 0;
        for (Integer piste : pisteet) {
            if (laskeArvosana(piste) == arvosana) {
                montakotahtea++;
            }
        }
        return tahtia(montakotahtea);
    }

    // seuraavat metodit ovat vain luokan omaan käyttöön ja ne on määritelty privateksi eli ei ulospäin näkyviksi
    private String tahtia(int n) {
        String tahdet = "";
        for (int i = 0; i < n; i++) {
            tahdet += "*";
        }
        return tahdet;
    }

    private int laskeArvosana(int pistemaara) {
        int numero = 5;
        if (pistemaara < 70) {
            numero = 0;
        } else if (pistemaara < 76) {
            numero = 1;
        } else if (pistemaara < 81) {
            numero = 2;
        } else if (pistemaara < 86) {
            numero = 3;
        } else if (pistemaara < 91) {
            numero = 4;
        }
        return numero;
    }
}
