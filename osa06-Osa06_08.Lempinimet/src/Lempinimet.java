
import java.util.HashMap;

public class Lempinimet {

    public static void main(String[] args) {
        // Tee tehtävänannossa pyydetyt operaatiot täällä!
        HashMap<String,String> nimet = new HashMap<>();
        
        nimet.put("matti", "mage");
        nimet.put("mikael", "mixu");
        nimet.put("arto", "arppa");
//        nimet.put("arto", "artsi");
//        nimet.put("aarne", "arppa");
        
//        System.out.println(nimet);
        
        System.out.println(nimet.get("mikael"));

    }

}
