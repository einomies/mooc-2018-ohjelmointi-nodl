package matkavalokuvat;


import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Yhdistin {
    
    public WritableImage vaalein(final ArrayList<Image> kuvat) {
        int leveys = (int) kuvat.get(0).getWidth();
        int korkeus = (int) kuvat.get(0).getHeight();
        
        WritableImage kuva = new WritableImage(leveys, korkeus);
        PixelWriter kuvanKirjoittaja = kuva.getPixelWriter();
        
        for (int y = 0; y < korkeus; y++) {
            for (int x = 0; x < leveys; x++) {
                
                ArrayList<Color> varitPikselissa = kuvienVaritPikselissa(kuvat, x, y);
                double vaaleinPunainen = 0.0;
                double vaaleinVihrea = 0.0;
                double vaaleinSininen = 0.0;
                
                for (int i = 0; i < varitPikselissa.size(); i++) {
                    Color vari = varitPikselissa.get(i);
                    
                    if (vari.getRed() > vaaleinPunainen) {
                        vaaleinPunainen = vari.getRed();
                    }
                    
                    if (vari.getGreen() > vaaleinVihrea) {
                        vaaleinVihrea = vari.getGreen();
                    }
                    
                    if (vari.getBlue() > vaaleinSininen) {
                        vaaleinSininen = vari.getBlue();
                    }
                }
                
                kuvanKirjoittaja.setColor(x, y, Color.color(vaaleinPunainen, vaaleinVihrea, vaaleinSininen));
            }
        }
        
        return kuva;
    }
    
    public WritableImage tummin(final ArrayList<Image> kuvat) {
        return null;

    }
    
    public WritableImage mediaani(final ArrayList<Image> kuvat) {
        return null;

    }
    
    public ArrayList<Color> kuvienVaritPikselissa(ArrayList<Image> kuvat, int x, int y) {
        return kuvat.stream().map(k -> k.getPixelReader().getColor(x, y)).collect(Collectors.toCollection(ArrayList::new));
    }
    
}
