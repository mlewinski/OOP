package lab4.klasy;

/**
 * Interfejs dający możliwość sprawdzenia, czy punkt (xk, yk) 
 * leży wewnątrz obszaru ograniczonego konturem danego obiektu.
*/
public interface IZaznaczalny {
    /**
     * Sprawdzenie punktu (xk, yk)
     * @param xk współrzędna X sprawdzanego punktu
     * @param yk współrzędna Y sprawdzanego punktu
     * @return odpowiedź, czy punkt leży wewnątrz konturu obiektu
     */
    boolean Zaznacz(int xk, int yk);
}
