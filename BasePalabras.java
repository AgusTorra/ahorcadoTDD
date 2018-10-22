package agustin.ahorcado;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import agustin.ahorcado.modelos.Palabra;

/**
 * Created by Agustin on 9/10/2018.
 */

public class BasePalabras {
    private static Map<Integer, Palabra> base = new HashMap<Integer, Palabra>();

    static void generarPalabras() {
        base.put(0, new Palabra("Fácil", "esp", "Animales", "Gato"));
        base.put(1, new Palabra("Intermedio", "esp", "Animales", "Rinoceronte"));
        base.put(1, new Palabra("Difícil", "esp", "Animales", "Fanfin"));
    }

    static Palabra obtenerPalabra(String idioma, String dificultad, String temática) {
        Palabra palabra = null;
        int cantPalabras = base.size();
        Random rand = new Random();

        int  n = 0;
        while (!base.get(n).getIdioma().equals(idioma) ||
               !base.get(n).getTemática().equals(temática) ||
               !base.get(n).getDificultad().equals(dificultad)) {
            n = rand.nextInt(cantPalabras) + 1;
        }
        return palabra = base.get(n);
    }
}
