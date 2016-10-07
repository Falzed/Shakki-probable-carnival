package components;

/**
 * Luokka toteuttaa standardishakin kuninkaan.
 *
 * @author oemkulma
 */
public class Kuningas extends Nappula {

    private static final char VALKOINENMERKKI = '\u2654';
    private static final char MUSTAMERKKI = '\u265A';
    private static final char NOTAATIOMERKKI = 'K';

    /**
     * Konstruktori, kutsuu vain Nappula-luokan konstruktoria. Puoli stringinä.
     *
     * @param puoli onko kuningas valkoinen vai musta *
     */
    public Kuningas(String puoli) {
        super(puoli);
    }

    /**
     * Konstruktori, kutsuu vain Nappula-luokan konstruktoria. Puoli enumina.
     *
     * @param puoli valkoinen vai musta
     */
    public Kuningas(Nappula.Puoli puoli) {
        super(puoli);
    }

    @Override
    public char getMerkki() {
        if (getPuoli().equals(Puoli.VALKOINEN)) {
            return VALKOINENMERKKI;
        }
        if (getPuoli().equals(Puoli.MUSTA)) {
            return MUSTAMERKKI;
        }
        return super.getMerkki();
    }

    @Override
    public char getNotaatioMerkki() {
        return NOTAATIOMERKKI;
    }

    @Override
    public Kuningas kopioi() {
        Kuningas kopio = new Kuningas(super.getPuoli());
//        kopio.asetaKoordinaatit(sijainti);
        return kopio;
    }
}
