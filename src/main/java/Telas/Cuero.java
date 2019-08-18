package Telas;


import java.util.ArrayList;
import java.util.List;

public class Cuero extends Tela {

    public Cuero() {
        prendasIncompatibles.add("remera");
        prendasIncompatibles.add("camisa");
        prendasIncompatibles.add("gorro");
        prendasIncompatibles.add("guantes");
    }

    @Override
    public String toString() {
        return "Cuero";
    }
}

