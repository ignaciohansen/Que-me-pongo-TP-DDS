package Imagenes;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class pruebaImagen  extends JFrame {

    ImageIcon remera = new ImageIcon("..\\2019-mi-no-group-10\\Imagenes\\remera.jpg");
    ImageIcon camisa = new ImageIcon("C:\\Users\\Nacho\\Documents\\2019-mi-no-group-10\\Imagenes\\camisa.jpg");
    ImageIcon pantalon = new ImageIcon("C:\\Users\\Nacho\\Documents\\2019-mi-no-group-10\\Imagenes\\pantalon.jpg");
    ImageIcon sweater = new ImageIcon("C:\\Users\\Nacho\\Documents\\2019-mi-no-group-10\\Imagenes\\sweater.jpg");
    ImageIcon campera = new ImageIcon("C:\\Users\\Nacho\\Documents\\2019-mi-no-group-10\\Imagenes\\campera.jpg");
    ImageIcon reloj = new ImageIcon("C:\\Users\\Nacho\\Documents\\2019-mi-no-group-10\\Imagenes\\reloj.jpg");
    ImageIcon pantufla = new ImageIcon("C:\\Users\\Nacho\\Documents\\2019-mi-no-group-10\\Imagenes\\pantufla.jpg");


    public pruebaImagen(ImageIcon imagenAmostrar)
    {
        super("Muestra de Imagen en JAVA...");

        JLabel etiquetaRemera = new JLabel(imagenAmostrar);

        //AGREGAMOS LA ETIQUETA QUE CONTIENE LA IMAGEN AL FRAME
        getContentPane().add(etiquetaRemera);

        //ESTABLECEMOS EL TAMAÑO DEL FRAME
        this.setSize(600, 900);


    }

    public static void main(String[] args)
    {
        ImageIcon remera = new ImageIcon("..\\2019-mi-no-group-10\\Imagenes\\remera.jpg");

        pruebaImagen p = new pruebaImagen(remera);
        p.show();

        //COLOCAMOS EL CODIGO QUE PERMITE CERRAR LA VENTANA
        p.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent evt)
            {
                System.exit(0);
            }
        });
    }


    public static void mostrarImagen(ImageIcon imagen)
    {

        pruebaImagen p = new pruebaImagen(imagen);
        p.show();

        //COLOCAMOS EL CODIGO QUE PERMITE CERRAR LA VENTANA
        p.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent evt)
            {
                System.exit(0);
            }
        });
    }
}
