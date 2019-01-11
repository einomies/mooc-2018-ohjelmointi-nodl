
import java.util.Scanner;
import java.math.BigDecimal;

public class TyontekijanElakevakuutus {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        BigDecimal bruttopalkka;
        final BigDecimal tyelTyonantajaPros = BigDecimal.valueOf(18);
        final BigDecimal tyelTyontekijaPros = BigDecimal.valueOf(6);
        
        /*        
        System.out.print("Syötä bruttopalkka: ");
        bruttopalkka = lukija.nextBigDecimal();

        System.out.print("Syötä veroprosentti: ");
        veroprosentti = lukija.nextBigDecimal();
        
        System.out.println("Nettopalkka: " +bruttopalkka.subtract(bruttopalkka.multiply(veroprosentti.divide(BigDecimal.valueOf(100)))));
        
        Työnantajan maksama TyEL-maksu on vuonna 2017 noin 18% työntekijän palkasta.
        Työntekijä maksaa palkastaan TyEL-maksua noin 6%. 
        */

        System.out.print("Syötä bruttopalkka: ");
        bruttopalkka = lukija.nextBigDecimal();
        
        System.out.println("Työnantaja maksaa TyEL-maksuja: "
                +bruttopalkka.multiply(tyelTyonantajaPros.divide(BigDecimal.valueOf(100))));

        System.out.println("Työntekijän kustannus työnantajalle vähintään: " 
                +bruttopalkka.add(bruttopalkka.multiply(tyelTyonantajaPros.divide(BigDecimal.valueOf(100)))));

        System.out.println("");
                
        System.out.println("Työntekijä maksaa TyEL-maksuja: "
                +bruttopalkka.multiply(tyelTyontekijaPros.divide(BigDecimal.valueOf(100))));
        
        System.out.println("Työntekijän palkka TyEL-maksun jälkeen: "
                +bruttopalkka.subtract(bruttopalkka.multiply(tyelTyontekijaPros.divide(BigDecimal.valueOf(100)))));

        System.out.println("TyEL-kulut yhteensä: "
                +bruttopalkka.multiply(tyelTyonantajaPros.divide(BigDecimal.valueOf(100))).add(bruttopalkka.multiply(tyelTyontekijaPros.divide(BigDecimal.valueOf(100)))));
    }
}
