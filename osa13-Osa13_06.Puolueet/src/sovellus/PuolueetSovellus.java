package sovellus;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PuolueetSovellus extends Application {

    @Override
    public void start(Stage ikkuna) throws Exception {

        ArrayList<String> lahdeData = lueLahdeData();
        tulostaLahdeData(lahdeData);

        Map<String, Map<Integer, Double>> arvot = luoArvotMappiin(lahdeData);

        NumberAxis xAkseli = new NumberAxis(1964, 2012, 4);
        NumberAxis yAkseli = new NumberAxis(0, 30, 5);

        xAkseli.setLabel("Vuosi");
        yAkseli.setLabel("Kannatus");

        LineChart<Number, Number> viivakaavio = new LineChart<>(xAkseli, yAkseli);
        viivakaavio.setTitle("Puolueiden suhteellinen kannatus");

        arvot.keySet().stream().forEach(puolue -> {
            XYChart.Series data = new XYChart.Series();
            data.setName(puolue);
            arvot.get(puolue).entrySet().stream().forEach(pari -> {
                if (pari.getValue() != null) {
                    data.getData().add(new XYChart.Data(pari.getKey(), pari.getValue()));
                }
            });
            viivakaavio.getData().add(data);
        });

        Scene nakyma = new Scene(viivakaavio, 640, 480);
        ikkuna.setScene(nakyma);
        ikkuna.show();

    }

    private ArrayList<String> lueLahdeData() {
        ArrayList<String> rivit = new ArrayList<>();
        String fileName = "puoluedata.tsv";

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(rivi -> rivit.add(rivi));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rivit;
    }

    private void tulostaLahdeData(ArrayList<String> data) {
        data.forEach((rivi) -> {
            System.out.println(rivi);
        });
    }

    public static void main(String[] args) {
        launch(PuolueetSovellus.class);
    }

    private Map<String, Map<Integer, Double>> luoArvotMappiin(ArrayList<String> lahdeData) {

        Map<String, Map<Integer, Double>> map = new HashMap<>();

        ArrayList<Integer> vuodet = new ArrayList<>();

        for (String rivi : lahdeData) {
            String[] palat = rivi.trim().split("\t");
            if (palat[0].equalsIgnoreCase("puolue")) {
                for (int i = 0; i < palat.length; i++) {
                    if (palat[i].trim().matches("^[+-]?\\d+$")) {
                        vuodet.add(Integer.parseInt(palat[i]));
                    }
                }
            }
        }
        System.out.println(vuodet);
        String puolueNimi = "";

        for (int i = 1; i < lahdeData.size(); i++) {
            Map<Integer, Double> luvut = new HashMap<>();
            String[] palat = lahdeData.get(i).trim().split("\t");
            puolueNimi = palat[0].trim();
            int k = 0;
            for (int j = 1; j < palat.length; j++) {
                if (palat[j].trim().equals("-")) {
                    luvut.put(vuodet.get(k), null);
                } else {
                    luvut.put(vuodet.get(k), Double.parseDouble(palat[j]));
                }
                k++;
            }
            map.put(puolueNimi, luvut);
        }
        System.out.println(map);

        return map;
    }

}
