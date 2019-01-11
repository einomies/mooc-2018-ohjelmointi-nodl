public class Kasvatuslaitos {

    private int punnitus;

    public Kasvatuslaitos() {
        this.punnitus = 0;
    }

    public int punnitse(Henkilo henkilo) {
        // palautetaan parametrina annetun henkilön paino
        punnitus++;
        return henkilo.getPaino();
    }
    
    public void syota(Henkilo henkilo) {
        int paino = henkilo.getPaino();
        paino++;
        henkilo.setPaino(paino);
    }
    
    public int punnitukset() {
        return punnitus;
    }

}
