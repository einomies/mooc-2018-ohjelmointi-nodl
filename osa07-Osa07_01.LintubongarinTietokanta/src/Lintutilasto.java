
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Lintutilasto {

//    private HashMap<String, HashMap<String, Integer>> mappi = new HashMap<>();
    private ArrayList<Lintu> tilasto = new ArrayList<>();
    private String nimiSuomi;
    private String nimiLatina;
    private int bongausLkm;

    public Lintutilasto() {
//        this.mappi = new HashMap<>();
        this.tilasto = new ArrayList<>();
    }

    public void lisaaLintu(String nimiSuomi, String nimiLatina) {
//        this.mappi.putIfAbsent(nimiSuomi, new HashMap<>());
//        this.mappi.get(nimiSuomi).putIfAbsent(nimiLatina, 0);
        if (loytyykoLintuNimella(nimiSuomi)) {
            System.out.println(nimiSuomi +" on jo tietokannassa!");
        } else {
            Lintu lintu = new Lintu(nimiSuomi, nimiLatina);
            this.tilasto.add(lintu);
        }
    }

//    public void lisaaBongaus(String avain) {
//        HashMap<String, Integer> inner = this.mappi.get(avain);
//        System.out.println("Lintutilasto.lisaaBongaus() inner HashMap: " 
//                +inner);
//        String innerKey = this.mappi.get(avain).
//        System.out.println("Lintutilasto.lisaaBongaus() innerKey: " 
//                +innerKey);
//    }

    public void lisaaBongaus(String nimi) {
        if (loytyykoLintuNimella(nimi)) {
            for (Lintu lintu : this.tilasto) {
                if (lintu.getNimiSuomi().equalsIgnoreCase(nimi)) {
                    lintu.lisaaBongaus();
                }
            }
        } else {
            System.out.println("Ei ole lintu!");
        }
    }

    private boolean loytyykoLintuNimella(String nimi) {
        for (Lintu lintu : this.tilasto) {
            if (lintu.getNimiSuomi().equalsIgnoreCase(nimi)) {
                return true;
            }
        }
        return false;
    }

    public Lintu haeLintu(String nimi) {
        for (Lintu lintu : this.tilasto) {
            if (lintu.getNimiSuomi().equalsIgnoreCase(nimi)) {
                return lintu;
            }
        }
        return null;
    }

    public void tulostaLintu(String nimi) {
        if (haeLintu(nimi) != null) {
            System.out.println(haeLintu(nimi));
        } else {
            System.out.println("Ei löydy!");
        }
    }

    public void tulostaLinnut() {
        for (Lintu lintu : this.tilasto) {
            System.out.println(lintu);
        }
    }

//    public void tulostaLinnut() {
//        for (Map.Entry<String, HashMap<String, Integer>> outer : this.mappi.entrySet()) {
//            String suomi = outer.getKey();
//            HashMap<String, Integer> value = outer.getValue();
//            for (Map.Entry<String, Integer> inner : value.entrySet()) {
//                String latina = inner.getKey();
//                Integer bongaukset = inner.getValue();
//                System.out.println(suomi + " (" + latina + "): " + bongaukset + " havaintoa");
//            }
//        }
//    }

}

/*
import java.util.ArrayList;

public class LintuTietokanta {
    private ArrayList<Lintu> linnut;

    public LintuTietokanta() {
        this.linnut = new ArrayList<>();
    }

    public boolean havainto(String nimi) {
        for (Lintu lintu : linnut) {
            if (lintu.nimi().equals(nimi)) {
                lintu.havainto();
                return true;
            }
        }
        return false;
    }

    public void lisaa(String nimi, String latNimi) {
        this.linnut.add(new Lintu(nimi, latNimi));
    }

    public String nayta(String nimi) {
        for (Lintu lintu : linnut) {
            if (lintu.nimi().equals(nimi)) {
                return lintu.toString();
            }
        }
        return null;
    }

    public String tilasto() {
        String tulos = "";
        for (Lintu lintu : linnut) {
            tulos += lintu.toString();
        }
        return tulos;
    }
}
*/