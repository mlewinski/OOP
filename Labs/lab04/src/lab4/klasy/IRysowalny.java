package lab4.klasy;

import java.awt.Graphics;

/**
 * Interfejs pozwalający na odrysowanie obiektu.
 */
public interface IRysowalny {
    /**
     * Rysuje obiekt
     * @param G obszar graficzny na którym zostanie odrysowany obiekt
     * @param Zaznaczony informuje, czy dany obiekt jest aktualnie zaznaczony
     */
    void Rysuj(Graphics G, boolean Zaznaczony);
}
