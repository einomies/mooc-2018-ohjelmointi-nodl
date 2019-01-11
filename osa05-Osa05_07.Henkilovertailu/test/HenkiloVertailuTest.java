import fi.helsinki.cs.tmc.edutestutils.Points;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

@Points("05-07")
public class HenkiloVertailuTest {

    @Test
    public void testi1() throws Throwable {
        Henkilo eka = new Henkilo("Leevi", new Paivays(1, 1, 2017), 70, 10);
        Henkilo toka = new Henkilo("Leevi", new Paivays(1, 1, 2017), 70, 10);
        
        assertEquals("Kahden kutsulla\nnew Henkilo(\"Leevi\", new Paivays(1, 1, 2017), 70, 10)\n luodun henkilön pitäisi olla samat.", eka, toka);
    }
    
    @Test
    public void testi2() throws Throwable {
        Henkilo eka = new Henkilo("Leevi", new Paivays(1, 1, 2017), 70, 10);
        Henkilo toka = new Henkilo("Leena", new Paivays(1, 1, 2017), 70, 10);
        
        assertFalse("Kokeile verrata seuraavia olioita:\nHenkilo eka = new Henkilo(\"Leevi\", new Paivays(1, 1, 2017), 70, 10);\n" +
"        Henkilo toka = new Henkilo(\"Leena\", new Paivays(1, 1, 2017), 70, 10);.", eka.equals(toka));
    }
    
    @Test
    public void testi3() throws Throwable {
        Henkilo eka = new Henkilo("Leevi", new Paivays(1, 1, 2017), 70, 10);
        Henkilo toka = new Henkilo("Leevi", new Paivays(2, 1, 2017), 70, 10);
        
        assertFalse("Kokeile verrata seuraavia olioita:\nHenkilo eka = new Henkilo(\"Leevi\", new Paivays(1, 1, 2017), 70, 10);\n" +
"        Henkilo toka = new Henkilo(\"Leevi\", new Paivays(2, 1, 2017), 70, 10);.", eka.equals(toka));
    }
    
    @Test
    public void testi4() throws Throwable {
        Henkilo eka = new Henkilo("Leevi", new Paivays(1, 1, 2017), 70, 10);
        Henkilo toka = new Henkilo("Leevi", new Paivays(1, 2, 2017), 70, 10);
        
        assertFalse("Kokeile verrata seuraavia olioita:\nHenkilo eka = new Henkilo(\"Leevi\", new Paivays(1, 1, 2017), 70, 10);\n" +
"        Henkilo toka = new Henkilo(\"Leevi\", new Paivays(1, 2, 2017), 70, 10);.", eka.equals(toka));
    }
    
    @Test
    public void testi5() throws Throwable {
        Henkilo eka = new Henkilo("Leevi", new Paivays(1, 1, 2017), 70, 10);
        Henkilo toka = new Henkilo("Leevi", new Paivays(1, 1, 2018), 70, 10);
        
        assertFalse("Kokeile verrata seuraavia olioita:\nHenkilo eka = new Henkilo(\"Leevi\", new Paivays(1, 1, 2017), 70, 10);\n" +
"        Henkilo toka = new Henkilo(\"Leevi\", new Paivays(1, 1, 2018), 70, 10);.", eka.equals(toka));
    }
    
    @Test
    public void testi6() throws Throwable {
        Henkilo eka = new Henkilo("Leevi", new Paivays(1, 1, 2017), 70, 10);
        Henkilo toka = new Henkilo("Leevi", new Paivays(1, 1, 2017), 71, 10);
        
        assertFalse("Kokeile verrata seuraavia olioita:\nHenkilo eka = new Henkilo(\"Leevi\", new Paivays(1, 1, 2017), 70, 10);\n" +
"        Henkilo toka = new Henkilo(\"Leevi\", new Paivays(1, 1, 2017), 71, 10);.", eka.equals(toka));
    }
    
    @Test
    public void testi7() throws Throwable {
        Henkilo eka = new Henkilo("Leevi", new Paivays(1, 1, 2017), 70, 10);
        Henkilo toka = new Henkilo("Leevi", new Paivays(1, 1, 2017), 70, 11);
        
        assertFalse("Kokeile verrata seuraavia olioita:\nHenkilo eka = new Henkilo(\"Leevi\", new Paivays(1, 1, 2017), 70, 10);\n" +
"        Henkilo toka = new Henkilo(\"Leevi\", new Paivays(1, 1, 2017), 70, 11);.", eka.equals(toka));
    }
}
