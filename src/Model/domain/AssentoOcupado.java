package Model.domain;

/**
 *
 * @author gabri
 */
public class AssentoOcupado {
    
    private int numeroAssento;
    private boolean ocupado;

    public AssentoOcupado(int numeroAssento, boolean ocupado){
        this.numeroAssento = numeroAssento;
        this.ocupado = ocupado;
    }

    public int getNumeroAssento() {
        return numeroAssento;
    }

    public void setNumeroAssento(int numeroAssento) {
        this.numeroAssento = numeroAssento;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    @Override
    public String toString() {
        String str = String.valueOf(this.numeroAssento);
        if(this.ocupado){
            str += " [Ocupado]";
        }
        return str;
    }    
    
}
