package arviot;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TunteikkaatArviot {

    private List<String> listRivit;
    private Map<String, Integer> mapSanatLkm;
    private Map<String, Map<Integer, Integer>> mapSanatArviotLkm;

    private final int ARVIO_MIN = 0;
    private final int ARVIO_MAX = 4;

    // Huom! Älä muuta konstruktorin parametrien määrää -- konstruktoria
    // saa toki muuten muuttaa
    public TunteikkaatArviot(List<String> rivit) {
        this.listRivit = rivit;
        this.mapSanatLkm = new HashMap<>();
        this.mapSanatArviotLkm = new HashMap<>();

        for (String rivi : rivit) {
            String[] palat = rivi.split(" ");

            if (onOikeaArvio(palat[0])) {
                int arvosana = Integer.parseInt(palat[0]);

                for (int i = 1; i < palat.length; i++) {
                    String sana = palat[i].toLowerCase();

                    if (this.mapSanatLkm.containsKey(sana)) {
                        this.mapSanatLkm.put(sana, this.mapSanatLkm.get(sana) + 1);
                    } else {
                        this.mapSanatLkm.put(sana, 1);
                    }

                    if (this.mapSanatArviotLkm.containsKey(sana)) {
                        if (this.mapSanatArviotLkm.get(sana).containsKey(arvosana)) {
                            this.mapSanatArviotLkm.get(sana).put(arvosana, this.mapSanatArviotLkm.get(sana).get(arvosana) + 1);
                        } else {
                            this.mapSanatArviotLkm.get(sana).put(arvosana, 1);
                        }
                    } else {
                        Map<Integer, Integer> map = new HashMap<>();
                        map.put(arvosana, 1);
                        this.mapSanatArviotLkm.put(sana, map);
                    }
                }
            }
        }
    }

    public int sanojenLukumaara(String sana) {
        return this.mapSanatLkm.getOrDefault(sana.toLowerCase(), 0);
    }

    public double sananTunne(String sana) {
        double tunne = 2;
        if (this.mapSanatArviotLkm.containsKey(sana)) {
            Map<Integer, Integer> arvosanat = this.mapSanatArviotLkm.get(sana);
            double summa = 0;
            int sanaLkm = sanojenLukumaara(sana);
            for (Map.Entry<Integer, Integer> entry : arvosanat.entrySet()) {
                Integer key = entry.getKey();
                Integer value = entry.getValue();
                summa += key * value;
            }
            tunne = summa / sanaLkm;
        }
        return tunne;
    }

    public double lauseenTunne(String lause) {
//      lauseen tunnearvo = lauseeseen liittyvien sanojen tunnearvojen keskiarvo
        String[] sanat = lause.split(" ");
        double summa = 0;
        for (int i = 0; i < sanat.length; i++) {
            summa += sananTunne(sanat[i]);
        }
        return summa / sanat.length;
    }

    public String sananTunneMerkkijonona(String sana) {
        return tunneMerkkijonona(sananTunne(sana));
    }

    public String lauseenTunneMerkkijonona(String lause) {
        return tunneMerkkijonona(lauseenTunne(lause));
    }

    private String tunneMerkkijonona(double luku) {
        if (luku <= 1.9) {
            return "negatiivinen";
        } else if (luku <= 2.1) {
            return "neutraali";
        } else {
            return "positiivinen";
        }
    }

    private boolean onOikeaArvio(String str) {
        if (onKokonaisluku(str)) {
            int luku = Integer.parseInt(str);
            if (luku >= ARVIO_MIN && luku <= ARVIO_MAX) {
                return true;
            }
        }
        return false;
    }

    private boolean onKokonaisluku(String str) {
//        return str.matches("-?\\d+");
        return str.matches("\\d+");
    }

    public void tulostaSanojenArviot() {
        for (Map.Entry<String, Map<Integer, Integer>> entry : mapSanatArviotLkm.entrySet()) {
            String key = entry.getKey();
            Map<Integer, Integer> value = entry.getValue();
            int summa = 0;
            for (Map.Entry<Integer, Integer> entry1 : value.entrySet()) {
                Integer key1 = entry1.getKey();
                Integer value1 = entry1.getValue();
                summa += value1;
            }
            System.out.println(key + " " + value + " = " + summa);
        }
    }

}
