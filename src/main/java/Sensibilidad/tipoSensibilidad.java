package Sensibilidad;

import TipoPrenda.TipoPrenda;

public abstract class tipoSensibilidad {

    private int valor;    // Este valor influye en el calculo para generar los atuendos ( suma o resta segun si es caluroso o friolento)
    private TipoPrenda.parteDelCuerpoQueAbriga parteCuerpo;// Esto hay que verificar con los accesorios para decir que me abrigue esa parte


    public TipoPrenda.parteDelCuerpoQueAbriga getParteCuerpo() {
        return parteCuerpo;
    }

    public void setParteCuerpo(TipoPrenda.parteDelCuerpoQueAbriga parteCuerpo) {
        this.parteCuerpo = parteCuerpo;
    }


    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }


}
