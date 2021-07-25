package mover;

import java.awt.Dimension;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

/**
 * <h1>Mover y Desplazar</h1>
 * Para mover, cambia de posicion en ejes de X y Y cada x tiempo y bajo los
 * parametros indicados. Para desplazar, o dar esa sensacion lo que se hace es
 * reducir el ancho o alto del componente cada x tiempo.
 *
 * @author Diego Robles
 * @version 2.0
 * @since 20/07/2021
 *
 * <h2>Beldi</h2>
 *
 * Youtube: https://www.youtube.com/channel/UCZlfwXOa8je8NzAnBJDtqzA
 * <br>
 * Facebook: https://www.facebook.com/beldi13
 * <br>
 * Omlet: https://omlet.gg/profile/beldi13
 * <br>
 * Twitch: https://www.twitch.tv/beldi133
 */
public class Mover {

    public static final int MOVER = 0;
    public static final int DESPLAZAR = 1;
    private static Mover instancia = null;
    private int it = 0;

    /**
     * constructor vacio privado para evitar mas instancias.
     */
    private Mover() {

    }

    /**
     * Metodo para obtener una única in stancia de clase.
     *
     * @return instancia de tipo Mover.
     */
    public static Mover getInstancia() {
        if (instancia == null) {
            instancia = new Mover();
        }
        return instancia;
    }

    /**
     * Parte del Método que reduce el ancho o alto del componente cada x tiempo
     * que da la sencacion de dezplazamiento.
     *
     * @param componente componente que se le aplicará la acción.
     * @param x ancho.
     * @param y alto.
     */
    private void desplazar(JComponent componente, int x, int y) {
        componente.setPreferredSize(new Dimension(x, y));
        SwingUtilities.updateComponentTreeUI(componente);
    }

    /**
     * Parte del Método que cambiara de posicion al componente cada x tiempo,
     * dando la sencacion de movimiento.
     *
     * @param componente componente que se le aplicará la acción.
     * @param x pocision en el eje X.
     * @param y posicion en el eje Y.
     */
    private void mover(JComponent componente, int x, int y) {
        componente.setLocation(x, y);
    }

    /**
     * Obtiene el ancho o la posicion en X del componente
     *
     * @param componente componente del que se sacara la información.
     * @param accion acción de MOVER o DESPLAZAR.
     * @return entero.
     */
    private int getIx(JComponent componente, int accion) {
        if (accion == MOVER) {
            it = componente.getX();
        }
        if (accion == DESPLAZAR) {
            it = componente.getWidth();
        }
        return it;
    }

    /**
     * Obtiene el alto o la posicion en Y del componente
     *
     * @param componente componente del que se sacara la información.
     * @param accion acción de MOVER o DESPLAZAR.
     * @return entero.
     */
    private int getIy(JComponent componente, int accion) {
        if (accion == MOVER) {
            it = componente.getY();
        }
        if (accion == DESPLAZAR) {
            it = componente.getHeight();
        }
        return it;
    }

    /**
     * Mueve o desplaza hacia la izquierda el componente bajo los siguiente
     * parámetros.
     *
     * @param componente Componente al se le aplicará la acción.
     * @param accion Mover o Desplazar el componente mediante las variables
     * MOVER o DESPLAZAR.
     * @param milisegundos tiempo en milisegundos que tardara en en realizar la
     * acción.
     * @param saltos cada cuanto número de pixeles en que realizara la acción.
     * @param parar punto donde dentendrá el efecto.
     */
    public void Izquierda(JComponent componente, int accion, int milisegundos, int saltos, int parar) {
        (new Thread() {
            @Override
            public void run() {
                for (int i = getIx(componente, accion); i >= parar; i -= saltos) {
                    try {
                        Thread.sleep(milisegundos);
                        switch (accion) {
                            case MOVER:
                                mover(componente, i, componente.getY());
                                break;
                            case DESPLAZAR:
                                desplazar(componente, i, componente.getHeight());
                                break;
                            default:
                                System.out.println("opción desconocida..");
                                break;
                        }
                    } catch (InterruptedException e) {
                        System.out.println("Error Thread Interrumpido: " + e);
                    }
                }
            }
        }).start();
    }

    /**
     * Mueve o desplaza hacia la derecha el componente bajo los siguiente
     * parámetros.
     *
     * @param componente Componente al se le aplicará la acción.
     * @param accion Mover o Desplazar el componente mediante las variables
     * MOVER o DESPLAZAR.
     * @param milisegundos tiempo en milisegundos que tardara en en realizar la
     * acción.
     * @param saltos cada cuanto número de pixeles en que realizara la acción.
     * @param parar punto donde dentendrá el efecto.
     */
    public void Derecha(JComponent componente, int accion, int milisegundos, int saltos, int parar) {

        (new Thread() {
            public void run() {
                for (int i = getIx(componente, accion); i <= parar; i += saltos) {
                    try {
                        Thread.sleep(milisegundos);
                        switch (accion) {
                            case MOVER:
                                mover(componente, i, componente.getY());
                                break;
                            case DESPLAZAR:
                                desplazar(componente, i, componente.getHeight());
                                break;
                            default:
                                System.out.println("opción desconocida..");
                                break;
                        }
                    } catch (InterruptedException e) {
                        System.out.println("Error Thread Interrumpido: " + e);
                    }
                }
            }
        }).start();
    }

    /**
     * Mueve o desplaza hacia la arriba el componente bajo los siguiente
     * parámetros.
     *
     * @param componente Componente al se le aplicará la acción.
     * @param accion Mover o Desplazar el componente mediante las variables
     * MOVER o DESPLAZAR.
     * @param milisegundos tiempo en milisegundos que tardara en en realizar la
     * acción.
     * @param saltos cada cuanto número de pixeles en que realizara la acción.
     * @param parar punto donde dentendrá el efecto.
     */
    public void Arriba(JComponent componente, int accion, int milisegundos, int saltos, int parar) {
        (new Thread() {
            @Override
            public void run() {
                for (int i = getIy(componente, accion); i >= parar; i -= saltos) {
                    try {
                        Thread.sleep(milisegundos);
                        switch (accion) {
                            case MOVER:
                                mover(componente, componente.getX(), i);
                                break;
                            case DESPLAZAR:
                                desplazar(componente, componente.getWidth(), i);
                                break;
                            default:
                                System.out.println("opción desconocida..");
                                break;
                        }
                    } catch (InterruptedException e) {
                        System.out.println("Error Thread interrumpido: " + e.getMessage());
                    }
                }
            }
        }).start();
    }

    /**
     * Mueve o desplaza hacia la abajo el componente bajo los siguiente
     * parámetros.
     *
     * @param componente Componente al se le aplicará la acción.
     * @param accion Mover o Desplazar el componente mediante las variables
     * MOVER o DESPLAZAR.
     * @param milisegundos tiempo en milisegundos que tardara en en realizar la
     * acción.
     * @param saltos cada cuanto número de pixeles en que realizara la acción.
     * @param parar punto donde dentendrá el efecto.
     */
    public void Abajo(JComponent componente, int accion, int milisegundos, int saltos, int parar) {
        (new Thread() {
            @Override
            public void run() {
                for (int i = getIy(componente, accion); i <= parar; i += saltos) {
                    try {
                        Thread.sleep(milisegundos);
                        switch (accion) {
                            case MOVER:
                                mover(componente, componente.getX(), i);
                                break;
                            case DESPLAZAR:
                                desplazar(componente, componente.getWidth(), i);
                                break;
                            default:
                                System.out.println("opción desconocida..");
                                break;
                        }
                    } catch (InterruptedException e) {
                        System.out.println("Error Thread interrumpido: " + e.getMessage());
                    }
                }
            }
        }).start();
    }

}
