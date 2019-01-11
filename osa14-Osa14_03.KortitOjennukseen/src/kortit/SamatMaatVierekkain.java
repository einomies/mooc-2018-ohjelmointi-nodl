/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kortit;

import java.util.Comparator;

/**
 *
 * @author einomies
 */
public class SamatMaatVierekkain implements Comparator<Kortti> {

    @Override
    public int compare(Kortti k1, Kortti k2) {
        return k1.getMaa().ordinal() - k2.getMaa().ordinal();
    }

}
