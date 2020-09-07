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
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(length = 50, nullable = false, unique = true)
    private String username;
    @Column(length = 50, nullable = false)
    private String password;

    public Usuario() {
    }

    public Usuario(Integer id, String username) {
        this.id = id;
        this.username = username;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final Usuario other = (Usuario) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
        public void validate() throws ValidateException {
            if(this.username == null || this.username.equals("")){
                throw new ValidateException("Campo username não preenchido!");
            }
            if(this.password == null || this.password.equals("") || 
                    this.password.trim().isEmpty()){
                throw new ValidateException("Campo senha não preenchido!");
            }        
    }
    
    
}
