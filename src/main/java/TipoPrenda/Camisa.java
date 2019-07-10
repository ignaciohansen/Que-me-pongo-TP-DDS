package TipoPrenda;

import javax.swing.*;

public class Camisa extends TipoPrenda {

    public Camisa() {
        ImageIcon camisa = new ImageIcon("C:\\Users\\Nacho\\Documents\\2019-mi-no-group-10\\Imagenes\\camisa.jpg");
        this.setFoto(camisa);
        this.setNivelDeAbrigo(4);
        this.setSuTipo("camisa");
        this.setCapaDePrenda(2);
    }
}
