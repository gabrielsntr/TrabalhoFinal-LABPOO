/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao.impl;

import Model.dao.interfaces.Conexao;
import Model.dao.interfaces.CrudDAO;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author gabri
 */
public abstract class CrudDAOImpl<E, I> implements CrudDAO<E> {
 
    protected abstract I getChave(E e);
    protected abstract String getConsultaSql(E e);
    protected abstract Map<String, Object> getParametrosMapa(E e);

    @Override
    public void insertUpdate(E e){
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        if (getChave(e) != null){            
            e = em.merge(e);
        }
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }
    
    @Override
    public void delete(E e){
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        e = em.merge(e);
        em.remove(e);
        em.getTransaction().commit();
        em.close();
    }
    
    @Override
    public List<E> search(E e){
        EntityManager em = Conexao.getEntityManager();
        Query q = em.createQuery(getConsultaSql(e));
        Map<String, Object> parametros = getParametrosMapa(e);
        for (String chave : parametros.keySet()){
            q.setParameter(chave, parametros.get(chave));
        }
        List<E> result = q.getResultList();
        em.close();
        return result;
    }

    
}
