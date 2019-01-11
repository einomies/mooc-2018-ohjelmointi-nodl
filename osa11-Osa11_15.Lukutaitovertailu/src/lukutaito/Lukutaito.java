package lukutaito;

/*
Adult literacy rate, population 15+ years, female (%),Trinidad and Tobago,2014,98.62493
Adult literacy rate, population 15+ years, female (%),Trinidad and Tobago,2015,98.70233
Adult literacy rate, population 15+ years, female (%),Eritrea,2014,64.25323
Adult literacy rate, population 15+ years, female (%),Eritrea,2015,65.60877
Adult literacy rate, population 15+ years, male (%),Malaysia,2015,96.19606
Adult literacy rate, population 15+ years, female (%),Kuwait,2015,95.23039
Adult literacy rate, population 15+ years, female (%),Uruguay,2014,98.80905
Adult literacy rate, population 15+ years, female (%),Uruguay,2015,98.80391
Adult literacy rate, population 15+ years, male (%),Belarus,2015,99.78625
Adult literacy rate, population 15+ years, male (%),Guyana,2015,85.84388
Adult literacy rate, population 15+ years, male (%),El Salvador,2015,90.10247
Adult literacy rate, population 15+ years, female (%),Togo,2015,55.30268
Adult literacy rate, population 15+ years, female (%),India,2015,62.98472
Adult literacy rate, population 15+ years, male (%),Mozambique,2015,73.42743
Adult literacy rate, population 15+ years, female (%),Palestine,2014,94.4073
Adult literacy rate, population 15+ years, female (%),Palestine,2015,94.80767
Adult literacy rate, population 15+ years, male (%),Yemen,2014,84.17932
Adult literacy rate, population 15+ years, male (%),Yemen,2015,84.97328

Tiedoston lukutaito.csv yksittäisen rivin muoto on seuraava:
teema
ikäryhmä
sukupuoli
maa
vuosi
lukutaitoprosentti

 */
public class Lukutaito implements Comparable<Lukutaito> {

    private String teema;
    private String ikaryhma;
    private String sukupuoli;
    private String maa;
    private int vuosi;
    private double lukutaitoprosentti;

    public Lukutaito(String teema, String ikaryhma, String sukupuoli, String maa, int vuosi, double lukutaitoprosentti) {
        this.teema = teema.trim();
        this.ikaryhma = ikaryhma.trim();
        this.sukupuoli = sukupuoli.replace("(%)", "").trim();
        this.maa = maa.trim();
        this.vuosi = vuosi;
        this.lukutaitoprosentti = lukutaitoprosentti;
    }

    public String getTeema() {
        return teema;
    }

    public void setTeema(String teema) {
        this.teema = teema;
    }

    public String getIkaryhma() {
        return ikaryhma;
    }

    public void setIkaryhma(String ikaryhma) {
        this.ikaryhma = ikaryhma;
    }

    public String getSukupuoli() {
        return sukupuoli;
    }

    public void setSukupuoli(String sukupuoli) {
        this.sukupuoli = sukupuoli;
    }

    public String getMaa() {
        return maa;
    }

    public void setMaa(String maa) {
        this.maa = maa;
    }

    public int getVuosi() {
        return vuosi;
    }

    public void setVuosi(int vuosi) {
        this.vuosi = vuosi;
    }

    public double getLukutaitoprosentti() {
        return lukutaitoprosentti;
    }

    public void setLukutaitoprosentti(double lukutaitoprosentti) {
        this.lukutaitoprosentti = lukutaitoprosentti;
    }

    @Override
    public String toString() {
//        return "Lukutaitovertailu{" + "teema=" + teema + ", ikaryhma=" + ikaryhma + ", sukupuoli=" + sukupuoli + ", maa=" + maa + ", vuosi=" + vuosi + ", lukutaitoprosentti=" + lukutaitoprosentti + '}';
        return this.maa + " (" + this.vuosi + "), " + this.sukupuoli + ", " + this.lukutaitoprosentti;
    }

    @Override
    public int compareTo(Lukutaito vertailtava) {
        int a = (int) (this.lukutaitoprosentti - vertailtava.getLukutaitoprosentti());
//        return (int)(this.lukutaitoprosentti - vertailtava.getLukutaitoprosentti());
        return Double.compare(this.lukutaitoprosentti, vertailtava.getLukutaitoprosentti());
    }
}
