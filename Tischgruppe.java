/**
 * Klasse einer Tischgruppe, also ein Tisch mit vier Stühlen
 */
public class Tischgruppe {
    public int[] xVerschiebung = {-120, 80, -20, -20};
    public int[] yVerschiebung = {-20, -20, -120, 80};
    public int[] rOtation = {270, 90, 0, 180};

    /**
     * erstellen einer Tischgruppe
     */
    public Tischgruppe(int xPosition, int yPosition){

        Tisch tisch = new Tisch(xPosition, yPosition);
        tisch.zeige();

        for(int i = 0; i < 4; i++){
            Stuhl stuhl = new Stuhl(tisch.get_xMittelpunkt() + xVerschiebung[i], tisch.get_yMittelpunkt() + yVerschiebung[i], rOtation[i]);
            stuhl.zeige();

        }
    }
}
