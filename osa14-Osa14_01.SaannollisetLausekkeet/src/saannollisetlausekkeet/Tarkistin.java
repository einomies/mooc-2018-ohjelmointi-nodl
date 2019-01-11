package saannollisetlausekkeet;

public class Tarkistin {

    public boolean onViikonpaiva(String merkkijono) {
        return merkkijono.matches("ma|ti|ke|to|pe|la|su");
    }

    public boolean kaikkiVokaaleja(String merkkijono) {
        return merkkijono.matches("(a|e|i|o|u|y|å|ä|ö)*");
    }

    public boolean kellonaika(String merkkijono) {
        return merkkijono.matches("([0-1][0-9]|[2][0-3]):([0-5][0-9]):([0-5][0-9])");
    }

}
/*
package saannollisetlausekkeet;

public class Tarkistin {

    public boolean onViikonpaiva(String merkkijono) {
        return merkkijono.matches("ma|ti|ke|to|pe|la|su");
    }

    public boolean kaikkiVokaaleja(String merkkijono) {
        return merkkijono.matches("[aeiouåäö]*");
    }

    public boolean kellonaika(String merkkijono) {
        return merkkijono.matches("([01][0123456789]|2[0123]):[012345][0123456789]:[012345][0123456789]");
    }

}
*/