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
@Table(name="assento")
public class Assento {
    @Id
    @GeneratedValue
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "id_itinerario", nullable = false)
    private Itinerario itinerario;
    
    @Column(name = "numero_assento", nullable = false)
    private Integer numeroAssento;
    
    @Column(name = "nome_passageiro", nullable = false, length = 60)
    private String nomePassageiro;
    
    @Column(name = "telefone_passageiro", nullable = false, length = 60)
    private String telefonePassageiro;

    public Assento() {
    }

    public Assento(Itinerario itinerario, Integer numeroAssento) {
        this.itinerario = itinerario;
        this.numeroAssento = numeroAssento;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Itinerario getItinerario() {
        return itinerario;
    }

    public void setItinerario(Itinerario itinerario) {
        this.itinerario = itinerario;
    }

    public Integer getNumeroAssento() {
        return numeroAssento;
    }

    public void setNumeroAssento(Integer numeroAssento) {
        this.numeroAssento = numeroAssento;
    }

    public String getNomePassageiro() {
        return nomePassageiro;
    }

    public void setNomePassageiro(String nomePassageiro) {
        this.nomePassageiro = nomePassageiro;
    }

    public String getTelefonePassageiro() {
        return telefonePassageiro;
    }

    public void setTelefonePassageiro(String telefonePassageiro) {
        this.telefonePassageiro = telefonePassageiro;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Assento other = (Assento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    public void validate() throws ValidateException {
        if(this.itinerario == null){
            throw new ValidateException("Itinerário não selecionado!");
        }
        if(this.numeroAssento <= 0 || this.numeroAssento == null){
            throw new ValidateException("Assento não selecionado!");
        }
        if(this.nomePassageiro == null || this.nomePassageiro.equals("")){
            throw new ValidateException("Nome do passageiro não preenchido!");
        }
        if(this.telefonePassageiro == null || this.telefonePassageiro.equals("")){
            throw new ValidateException("Telefone do passageiro não preenchido!");
        }
        if(this.numeroAssento > this.itinerario.getQtdLugares()){
            throw new ValidateException("O número do assento não deve ser maior que a quantidade de assentos disponíveis!");
        }        
    }
    
}
