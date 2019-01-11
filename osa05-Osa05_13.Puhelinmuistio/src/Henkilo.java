public class Henkilo {
    
    private String nimi;
    private String numero;
    
    public Henkilo(String nimi, String numero) {
        this.nimi = nimi;
        this.numero = numero;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    @Override
    public String toString() {
        return this.nimi +" puh: " +this.numero;
    }
    
    public void vaihdaNumeroa(String uusiNumero) {
        setNumero(uusiNumero);
    }
    
}
