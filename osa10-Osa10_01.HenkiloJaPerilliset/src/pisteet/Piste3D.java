/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pisteet;

/**
 *
 * @author einomies
 */
public class Piste3D extends Piste {

    private int z;

    public Piste3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    @Override
    protected String sijainti() {
        return super.sijainti() + ", " + z;
    }

    @Override
    public int manhattanEtaisyysOrigosta() {
        return super.manhattanEtaisyysOrigosta() + Math.abs(z);
    }
}
