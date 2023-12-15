import java.awt.*;

/**
 * Ueberklasse fuer alle Moebel, enthaelt die wichtigen funktionen, welche zum erstellen,
 * interagieren und graphisch darstellen notwendig sind.
 * @author Lukas
 * @version 1202312151018
 */
public abstract class Moebel {

    protected int xPosition;
    protected int yPosition;
    protected int orientierung;
    protected String farbe;
    protected boolean istSichtbar;
    protected int breite;
    protected int tiefe;

    /**
     * Diese methode wird in den Unterklassen ueberschrieben, ist aber notwendig, weil Java
     * sie an dieser Stelle verlangt.
     */
    protected abstract Shape gibAktuelleFigur();
    
    /**
     * Mache dieses Objekt sichtbar. Wenn es bereits sichtbar ist, tue nichts.
     */
    public void zeige() {
        if (!istSichtbar) {
            istSichtbar = true;
            this.zeichne();
        }
    }

    /**
     * Mache dieses Objekt unsichtbar. Wenn es bereits unsichtbar ist, tue nichts.
     */
    public void verberge() {
        loesche(); // "tue nichts" wird in loesche() abgefangen.
        istSichtbar = false;
    }
    
    /**
     * Drehe auf den angegebenen Winkel
     */
    public void dreheAuf(int neuerWinkel) {
        loesche();
        orientierung = neuerWinkel;
        zeichne();
    }

    /**
     * Bewege dieses Objekt horizontal um 'entfernung' Bildschirmpunkte.
     * @param entfernung
     */
    public void bewegeHorizontal(int entfernung) {
        loesche();
        xPosition += entfernung;
        zeichne();
    }

    /**
     * Setzt die X-Koordinate auf 'xPosition'
     * @param int xPosition
     */
    public void set_xPosition(int xPosition){
        loesche();
        this.xPosition = xPosition;
        zeichne();
    }

    /**
     * Setzt die Y-Koordinate auf 'yPosition'
     * @param int yPosition
     */
    public void set_yPosition(int yPosition){
        loesche();
        this.yPosition = yPosition;
        zeichne();
    }
    
    /**
     * Bewege dieses objekt vertikal um 'entfernung' Bildschirmpunkte.
     * @param entfernung
     */
    public void bewegeVertikal(int entfernung) {
        loesche();
        yPosition += entfernung;
        zeichne();
    }

    /**
     * Methode zum berechnen des Mittelpunktes, gibt einen Integer zurück.
     * @return xmittelpunkt
     */
    public int get_xMittelpunkt(){
        return (xPosition + (breite/2));
    }

    /**
     * Methode zum berechnen des Mittelpunktes, gibt einen Integer zurück.
     * @return ymittelpunkt
     */
    public int get_yMittelpunkt(){
        return (yPosition + (tiefe/2));

    }
    
    /**
     * Aendere die Farbe dieses Objektes in 'neueFarbe'.
     * Gueltige Angaben sind "rot", "gelb", "blau", "gruen",
     * "lila" und "schwarz".
     * @param neueFarbe
     */
    public void aendereFarbe(String neueFarbe) {
        loesche();
        farbe = neueFarbe;
        zeichne();
    }

     /**
     * Zeichne dieses Objekt mit seinen aktuellen Werten auf den Bildschirm.
     */
    protected void zeichne() {
        if (istSichtbar) {
            Shape figur = gibAktuelleFigur();
            Leinwand leinwand = Leinwand.gibLeinwand();
            leinwand.zeichne (
              this,           // leinwand kennt das Objekt
              farbe,          // definiert seine Zeichenfarbe
              figur);         // definiert seinen grafischen Aspekt
            leinwand.warte(10);
        }
    }
    
    /**
     * Loesche dieses Objekt vom Bildschirm.
     */
    protected void loesche() {
        if (istSichtbar){
            Leinwand leinwand = Leinwand.gibLeinwand();
            leinwand.entferne(this);
        }
    }
    
}
