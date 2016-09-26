/*
 * ApliBodegaApp.java
 */

package aplibodega;

import Presentacion.InicioSesion.Inicio_Sesion;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;

public class ApliBodegaApp extends SingleFrameApplication {

    @Override 
    protected void startup() {
        //show(new ApliBodegaView(this));
    }

    @Override 
    protected void configureWindow(java.awt.Window root) {
    }

    public static ApliBodegaApp getApplication() {
        return Application.getInstance(ApliBodegaApp.class);
    }

    public static void main(String[] args) {
        javax.swing.JFrame.setDefaultLookAndFeelDecorated(true);
        Inicio_Sesion inicio = new Inicio_Sesion(new javax.swing.JFrame());
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
                try{
                    //para cambiar aparienza a las interfaces graficas
                    SubstanceLookAndFeel.setSkin(new org.pushingpixels.substance.api.skin.CremeCoffeeSkin());
                }
                catch (Exception e) {
                    System.out.println("Fallo la inicializacion del substance");
                    System.out.println(e.getMessage().toString());
                }
            }
        });
        
        inicio.setVisible(true);
        //launch(ApliBodegaApp.class, args);
    }
}
