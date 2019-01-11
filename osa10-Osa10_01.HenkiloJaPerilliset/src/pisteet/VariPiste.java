/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pisteet;

public class VariPiste extends Piste {

    private String vari;

    public VariPiste(int x, int y, String vari) {
        super(x, y);
        this.vari = vari;
    }

    @Override
    public String toString() {
        return super.toString() + " väri: " + vari;
    }

}
