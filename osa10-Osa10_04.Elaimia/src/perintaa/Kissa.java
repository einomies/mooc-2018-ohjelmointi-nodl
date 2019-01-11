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
public class Kissa extends Elain implements Aanteleva {

    public Kissa(String nimi) {
        super(nimi);
    }

    public Kissa() {
        super("Kissa");
    }

    public void mourua() {
        System.out.println(super.getNimi() + " mouruaa");
    }

    @Override
    public void aantele() {
        mourua();
    }

}

/*

package perintaa;

public class Kissa extends Elain implements Aanteleva {

    public Kissa() {
        this("Kissa");
    }

    public Kissa(String nimi) {
        super(nimi);
    }

    public void mourua() {
        System.out.println(getNimi() + " mouruaa");
    }

    @Override
    public void aantele() {
        this.mourua();
    }
}
*/