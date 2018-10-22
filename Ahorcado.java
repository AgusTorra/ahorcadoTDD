package agustin.ahorcado;

import java.util.HashMap;
import java.util.Map;

import agustin.ahorcado.modelos.Jugador;
import agustin.ahorcado.modelos.Palabra;
import agustin.ahorcado.utils.Cronometro;
import agustin.ahorcado.utils.Helper;

import static java.nio.file.Paths.get;

/**
 * Created by Agustin on 8/10/2018.
 */

class Ahorcado {
    private String palabras[] = {"ahorcado", "primavera", "jugador", "facultad", "programacion"};
    private Map<String, Integer> tiempos = new HashMap<String, Integer>();
    private char palabraActual[] = {'_','_','_','_','_','_','_','_'}; //ahorcado
    private String modoJuego = "Estándar";
    private String letrasAcertadas = "";
    private Cronometro cronometro;
    private Jugador jugador;
    private int errores = 6;
    private Palabra palabra;

    Ahorcado() {
        BasePalabras.generarPalabras();
    }

    boolean ingresarLetra(String letra) {
        boolean letraEnPalabra = false;
        if(quedanErrores()) {
            letraEnPalabra = isEnPalabra(letra);
            if (letraEnPalabra) {
                ubicarLetraEnPalabra(letra.charAt(0));
                letrasAcertadas += letra + ',';
            } else {
                errores--;
            }
        }
        return letraEnPalabra;
    }

    void seleccionarModo(String modo) {
        switch (modo) {
            case "Estándar":
                this.modoJuego = "Estándar";
                break;
            case "Por tiempo":
                this.modoJuego = "Por tiempo";
                break;
            case "Cuenta regresiva":
                this.modoJuego = "Cuenta regresiva";
                break;
        }
    }

    String rankingPorTiempo() {
        int i = 0; //Posición
        String salida = "Ranking por tiempo\n"; //Titulo de la salida
        tiempos = Helper.ordenarPorValor(tiempos); //Ordeno los tiempos de menor a mayor
        for (String key : tiempos.keySet()) { //Armo la salida para mostrarla
            i++;
            salida += i + ") " + key + ": " + tiempos.get(key) + " seg.\n";
        }
        return salida.substring(0,salida.length()-1);
    }

    String getResultado() {
        if (!quedanErrores()) {
            return "Perdiste!";
        } else if (isPalabraDescubierta() && quedanErrores()) {
            return "Ganaste!";
        } else {
            return "Jugando";
        }
    }

    private void ubicarLetraEnPalabra(char letra) {
        int cantLetras = palabras[0].length();
        //int cantLetras = this.palabra.getPalabra().length();
        for (int i = 0; i < cantLetras; i++) {
            if (palabras[0].charAt(i) == letra) {
                palabraActual[i] = letra;
            }
        }
    }

    int getTiempo() {
        cronometro.stop();
        int tiempo = (int) cronometro.getSeconds();
        tiempos.put(jugador.getNombre(), tiempo);
        return (int) cronometro.getSeconds();
    }

    void iniciarCronometro() {
        cronometro = new Cronometro();
        cronometro.start();
    }

    void comenzarJuego() {
        this.palabra = BasePalabras.obtenerPalabra(Opciones.getIdioma(), Opciones.getDificultad(),
                Opciones.getTemática());
        //prepararPalabra();
    }

    void seleccionarDificultad(String dificultad) {
        Opciones.seleccionarDificultadPalabras(dificultad);
    }

    private boolean isPalabraDescubierta() {
        return Helper.ArrayToString(palabraActual).equals(palabras[0]);
    }

    void seleccionarIdioma(String idioma) {
        Opciones.seleccionarIdiomaPalabras(idioma);
    }

    void seleccionarTemática(String tematica) {
        Opciones.seleccionarTematicaPalabras(tematica);
    }

    void seleccionarTiempoLímite(int tiempo) { Opciones.seleccionarTiempoLimite(tiempo); }

    private boolean isEnPalabra(String letra) {
        return palabras[0].contains(letra);
    }

    boolean arriesgarPalabra(String palabra) {
        return this.palabras[0].equals(palabra);
    }

    void jugadorAnonimo() {
        this.jugador = new Jugador("anónimo");
    }

    void altaJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    private boolean quedanErrores() {
        return errores > 0;
    }

    String getLetrasAcertadas() {
        return letrasAcertadas.substring(0, letrasAcertadas.length()-1);
    }

    String getPalabraFija() {
        return palabras[0];
    }

    String[] getPalabras() {
        return palabras;
    }

    Jugador getJugador() {
        return jugador;
    }

    String getModoJuego() {
        return this.modoJuego;
    }

    String getIdiomaPalabra() {
        return Opciones.getIdioma();
    }

    String getDificultadPal() {
        return Opciones.getDificultad();
    }

    String getTemáticaPal() {
        return Opciones.getTemática();
    }

    int getTiempoLímite() {
        return Opciones.getTiempoLimite();
    }

    Palabra getPalabra() {
        return palabra;
    }

    String getPalabraActual() {
        return Helper.ArrayToString(palabraActual);
    }

    /*private void prepararPalabra() {
        int longitudPal = this.palabra.getLongitud();
        this.palabraActual = new char[longitudPal];
        for (int i = 0; i < longitudPal; i++) {
            this.palabraActual[i] = '_';
        }
    }*/
}
