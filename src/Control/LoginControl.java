package Control;

import Model.dao.interfaces.UsuarioDAO;
import Model.dao.impl.UsuarioDAOImpl;
import Model.domain.Usuario;
import Util.ValidateException;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author gabri
 */
public class LoginControl {
    
    private PropertyChangeSupport propertyChangeSupport = 
            new PropertyChangeSupport(this);
    
    private Usuario usuarioDigitado;
    private Usuario usuarioSelecionado;
    private List<Usuario> usuariosTabela;
    private UsuarioDAO usuarioDAO;
    
    public LoginControl(){
        usuarioDAO = new UsuarioDAOImpl();
        usuariosTabela = ObservableCollections.observableList(
                new ArrayList<Usuario>());
        novo();
    }
    
    public Usuario login(String username, char[] password) throws ValidateException{
        Usuario usuarioLogado = new Usuario();
        usuarioLogado.setUsername(username);
        usuarioLogado.setPassword(password.toString());
        usuarioLogado.validate();
        search();
        if (!this.getUsuariosTabela().isEmpty()){
            return this.getUsuariosTabela().get(0);
        } else {
            return null;
        }
    }
    
    public void novo() {
        setUsuarioDigitado(new Usuario());
    }

    public void search() {
        usuariosTabela.clear();
        usuariosTabela.addAll(usuarioDAO.search(usuarioDigitado));
    }
    

    public Usuario getUsuarioDigitado() {
        return usuarioDigitado;
    }

    public void setUsuarioDigitado(Usuario usuarioDigitado) {
        Usuario oldUsuarioDigitado = this.usuarioDigitado;
        propertyChangeSupport.firePropertyChange(
                "usuarioDigitado", oldUsuarioDigitado, usuarioDigitado);
        this.usuarioDigitado = usuarioDigitado;
    }

    public Usuario getUsuarioSelecionado() {
        return usuarioSelecionado;
    }

    public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
        if (this.usuarioDigitado != null){
            setUsuarioDigitado(usuarioDigitado);
        }
    }

    public List<Usuario> getUsuariosTabela() {
        return usuariosTabela;
    }

    public void setUsuariosTabela(List<Usuario> usuariosTabela) {
        this.usuariosTabela = usuariosTabela;
    }
    
    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener){
        propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener){
        propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
    }
    
}
