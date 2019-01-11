/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author einomies
 */
public class Kertoja {
    
    private int kerrottava;
    
    public Kertoja(int luku) {
        this.kerrottava = luku;
    }
    
    public int kerro(int luku) {
        return this.kerrottava * luku;
    }
}
