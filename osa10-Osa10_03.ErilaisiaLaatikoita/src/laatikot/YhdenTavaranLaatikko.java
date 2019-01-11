/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laatikot;

/**
 *
 * @author einomies
 */
public class YhdenTavaranLaatikko extends Laatikko {

    private Tavara tavara;

    public YhdenTavaranLaatikko() {
        this.tavara = null;
    }

    @Override
    public void lisaa(Tavara tavara) {
        if (this.tavara == null) {
            this.tavara = tavara;
        }
    }

    @Override
    public boolean onkoLaatikossa(Tavara tavara) {
        if (this.tavara != null && this.tavara.equals(tavara)) {
            return true;
        }
        return false;
    }

}

/*
package laatikot;

public class YhdenTavaranLaatikko extends Laatikko {

    private Tavara tavara;

    public YhdenTavaranLaatikko() {
    }

    @Override
    public void lisaa(Tavara tavara) {
        if (this.tavara != null) {
            return;
        }
        this.tavara = tavara;
    }

    @Override
    public boolean onkoLaatikossa(Tavara tavara) {
        return this.tavara != null && this.tavara.equals(tavara);
    }
}
*/