/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author DELL
 */


import entities.Login;
import entities.Machine;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class LoginService extends AbstractFacade<Login>{
    @PersistenceContext(unitName = "gestionEmplMachinePU")
    private EntityManager em;

    public LoginService() {
        super(Login.class);
    }
    

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    
    
    public LoginService(Class<Login> entityClass) {
        super(entityClass);
    }

    public void createLogin(Login admin) {
        em.persist(admin);
    }

    public Login findLoginById(Long id) {
        return em.find(Login.class, id);
    }

     public Login findLoginByUsernameAndPassword(String username, String password) {
        try {
            return em.createQuery("SELECT a FROM Login a WHERE a.username = :username AND a.password = :password", Login.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    protected EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

