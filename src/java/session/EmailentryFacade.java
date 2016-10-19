/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Emailentry;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class EmailentryFacade extends AbstractFacade<Emailentry> {
    @PersistenceContext(unitName = "jmarreroA1PU")
    private EntityManager em;
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public EmailentryFacade() {
        super(Emailentry.class);
    }    
    //add additional business logic
    public void persistEmailentryData(int id, String firstName, String lastName, String emailAddress) {
        try {
            Emailentry g = new Emailentry();
            g.setId(id);
            g.setFirstname(firstName);
            g.setLastname(lastName);
            g.setEmailAddress(emailAddress);
            em.persist(g);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     public List<Emailentry> findByLastName(String name) {
        // Query q = em.createNamedQuery("Emailentry.findByLastname");
        Query q = em.createQuery("SELECT g FROM Emailentry g WHERE g.lastname = :lastname");
        q.setParameter("lastname", name);
        List<Emailentry> emailList = q.getResultList();
        return emailList;
    }
    
    public List<Emailentry> showAllRecords() {
        Query q=em.createNamedQuery("Emailentry.findAll");
        List<Emailentry> emailList = q.getResultList();
        return emailList;        
    }    
    public void editRecord(Emailentry entity) throws Exception {
        try {
            edit(entity);
        }
        catch (Exception e) {
            throw new Exception("Edit Transaction Failed");
        }
    }    
    public List<Emailentry> findById(int id) {
        Query q=em.createNamedQuery("Emailentry.findById");
        q.setParameter("id", id);
        List<Emailentry> emailList = q.getResultList();
        return emailList;
    }    
    public void deleteById(Emailentry entity) throws Exception {
        try {
            remove(entity);
        }
        catch(Exception e) {
            throw new Exception("Delete Transaction Failed");
        }
    }    
    public int getNumberOfRecords() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Emailentry> rt = cq.from(Emailentry.class);
        cq.select(cb.count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
}
