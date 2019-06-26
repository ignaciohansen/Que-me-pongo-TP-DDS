package Telas;


import java.util.ArrayList;
import java.util.List;

public class Cuero extends Tela {

    public Cuero() {
        prendasIncompatibles.add("remera");
        prendasIncompatibles.add("camisa");
    }

    @Override
    public String toString() {
        return "Cuero";
    }
}

