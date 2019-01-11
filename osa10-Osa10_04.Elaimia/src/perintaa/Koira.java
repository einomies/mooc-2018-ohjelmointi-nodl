/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perintaa;

/**
 *
 * @author einomies
 */
public class Koira extends Elain implements Aanteleva {

    public Koira() {
        super("Koira");
    }

    public Koira(String nimi) {
        super(nimi);
    }

    public void hauku() {
        System.out.println(super.getNimi() + " haukkuu");
    }

    @Override
    public void aantele() {
        hauku();
    }

}

/*
package perintaa;
public class Koira extends Elain implements Aanteleva {

    public Koira() {
        this("Koira");
    }

    public Koira(String nimi) {
        super(nimi);
    }

    public void hauku() {
        System.out.println(getNimi() + " haukkuu");
    }

    @Override
    public void aantele() {
        this.hauku();
    }
}
*/