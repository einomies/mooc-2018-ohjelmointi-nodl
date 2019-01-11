/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pisteet;

public class Piste {

    private int x;
    private int y;

    public Piste(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int manhattanEtaisyysOrigosta() {
        return Math.abs(x) + Math.abs(y);
    }

    protected String sijainti() {
        return x + ", " + y;
    }

    @Override
    public String toString() {
        return "(" + this.sijainti() + ") etäisyys " + this.manhattanEtaisyysOrigosta();
    }

}
