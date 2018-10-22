package agustin.ahorcado;

import android.graphics.Path;

/**
 * Created by Agustin on 29/8/2018.
 */

class Opciones {
    private static String dificultad = "Fácil";
    private static String temática = "Animales";
    private static String idioma = "esp";
    private static int tiempoLimite;

    public Opciones() {
    }

    public static String getDificultad() {
        return dificultad;
    }

    public static void setDificultad(String dificultad) {
        Opciones.dificultad = dificultad;
    }

    public static String getTemática() {
        return temática;
    }

    public static void setTemática(String temática) {
        Opciones.temática = temática;
    }

    public static String getIdioma() {
        return idioma;
    }

    public static void setIdioma(String idioma) {
        Opciones.idioma = idioma;
    }

    public static int getTiempoLimite() {
        return tiempoLimite;
    }

    public static void setTiempoLimite(int tiempoLimite) {
        Opciones.tiempoLimite = tiempoLimite;
    }

    static void seleccionarIdiomaPalabras(String idioma) {
        switch (idioma) {
            case "esp":
                setIdioma("esp");
                break;
            case "Ing":
                setIdioma("ing");
                break;
        }
    }

    static void seleccionarDificultadPalabras(String dificultad) {
        switch (dificultad) {
            case "Fácil":
                Opciones.dificultad = "Fácil";
                break;
            case "Medio":
                Opciones.dificultad = "Intermedia";
                break;
            case "Dificil":
                Opciones.dificultad = "Dificil";
                break;
        }
    }

    static void seleccionarTematicaPalabras(String tematica) {
        switch (tematica) {
            case "Cine":
                Opciones.temática = "Cine";
                break;
            case "Deportes":
                Opciones.temática = "Deportes";
                break;
            case "Animales":
                Opciones.temática = "Animales";
                break;
        }
    }

    static void seleccionarTiempoLimite(int tiempo) {
        switch (tiempo) {
            case 30:
                Opciones.tiempoLimite = 30;
                break;
            case 60:
                Opciones.tiempoLimite = 60;
                break;
            case 90:
                Opciones.tiempoLimite = 90;
                break;
            case 120:
                Opciones.tiempoLimite = 120;
                break;
        }
    }
}
