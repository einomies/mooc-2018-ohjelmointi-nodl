/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siirrettava;

/**
 *
 * @author einomies
 */
public class Elio implements Siirrettava {

    private int x;
    private int y;

    public Elio(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void siirra(int dx, int dy) {
        this.x = this.x + dx;
        this.y = this.y + dy;
    }

    @Override
    public String toString() {
        return "x: " + x + "; y: " + y;
    }

}

/*
package siirrettava;
public class Elio implements Siirrettava {

    private int x;
    private int y;

    public Elio(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public void siirra(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public String toString() {
        return "x: " + this.x + "; y: " + this.y;
    }
}
*/