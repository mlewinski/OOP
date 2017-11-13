package lab4.klasy;

/**
 * Interfejs pozwalający na przesunięcie obiektu
 */
public interface IPrzesuwalny {
    /**
     * Przesuwa obiekt o wektor [dx, dy].
     * @param dx przesunięcie w poziomie.
     * @param dy przesunięcie w pionie.
     */
    void Przesun(int dx, int dy);
    /**
     * Przenosi obiekt do współrzędnych x, y.
     * @param x - nowa współrzędna x
     * @param y - nowa współrzędna y
     */
    void Przenies(int x, int y);    
}
