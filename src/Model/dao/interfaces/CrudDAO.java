/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao.interfaces;

import java.util.List;

/**
 *
 * @author gabri
 */
public interface CrudDAO<E> {

    void delete(E e);

    void insertUpdate(E e);

    List<E> search(E e);
    
}
