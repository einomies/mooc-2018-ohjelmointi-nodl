
import java.util.ArrayList;

public class ViestiPaaohjelma {

    public static void main(String[] args) {
        Viesti sms = new Viesti("SMS");
        Viesti mms = new Viesti("MMS");

        System.out.println(sms.equals(sms));
        System.out.println(sms.equals(mms));

        ArrayList<Viesti> viestit = new ArrayList<>();
        if (!viestit.contains(sms)) {
            viestit.add(sms);
        }

        if (!viestit.contains(sms)) {
            viestit.add(sms);
        }

        if (!viestit.contains(new Viesti("SMS"))) {
            viestit.add(sms);
        }

        System.out.println(viestit.size());
    }

}
