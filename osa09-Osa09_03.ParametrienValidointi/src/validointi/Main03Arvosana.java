/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validointi;

/**
 *
 * @author einomies
 */
public class Main03Arvosana {

    public static void main(String[] args) throws Exception {
        Arvosana arvosana = new Arvosana(3);
        System.out.println(arvosana.getArvosana());

        Arvosana virheellinenArvo = new Arvosana(22);
// tapahtuu poikkeus, tästä ei jatketa eteenpäin
    }

}
