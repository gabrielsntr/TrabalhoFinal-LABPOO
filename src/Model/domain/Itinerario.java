package Model.domain;

import Util.ValidateException;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author gabri
 */

@Entity
@Table(name="itinerario")
public class Itinerario {
    @Id
    @GeneratedValue
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "id_municipio_origem", nullable = false)
    private Municipio municipioOrigem;
    
    @ManyToOne
    @JoinColumn(name = "id_municipio_destino", nullable = false)
    private Municipio municipioDestino;
    
    @Column
    private Integer qtdLugares;

    public Itinerario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Municipio getMunicipioOrigem() {
        return municipioOrigem;
    }

    public void setMunicipioOrigem(Municipio municipioOrigem) {
        this.municipioOrigem = municipioOrigem;
    }

    public Municipio getMunicipioDestino() {
        return municipioDestino;
    }

    public void setMunicipioDestino(Municipio municipioDestino) {
        this.municipioDestino = municipioDestino;
    }

    public Integer getQtdLugares() {
        return qtdLugares;
    }

    public void setQtdLugares(Integer qtdLugares) {
        this.qtdLugares = qtdLugares;
    }

    @Override
    public String toString() {
        return municipioOrigem + " -> " + municipioDestino + " [" + qtdLugares + " lugares]";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Itinerario other = (Itinerario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    public void validate() throws ValidateException {
        if(this.municipioOrigem == null){
            throw new ValidateException("Município de origem não preenchido!");
        }
        if(this.municipioOrigem == null){
            throw new ValidateException("Município de destino não preenchido!");
        }
        if(this.qtdLugares <= 0){
            throw new ValidateException("A quantidade de lugares deve ser maior que 0!");
        }        
    }
    
}
