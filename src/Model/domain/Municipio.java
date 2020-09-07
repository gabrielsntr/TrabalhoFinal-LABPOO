package Model.domain;

import Util.ValidateException;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author gabri
 */

@Entity
@Table(name="municipio")
public class Municipio {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(length = 50, nullable = false)
    private String nome;
    @Column(length = 2, nullable = false)
    private String uf;

    public Municipio() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public String toString() {
        return this.nome + "-" + this.uf;
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
        final Municipio other = (Municipio) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    public void validate() throws ValidateException {
        if(this.nome == null || this.nome.equals("")){
            throw new ValidateException("Campo nome não preenchido!");
        }
        if(this.uf == null || this.uf.equals("")){
            throw new ValidateException("Campo UF não preenchido!");
        }        
    }
    
    
}
