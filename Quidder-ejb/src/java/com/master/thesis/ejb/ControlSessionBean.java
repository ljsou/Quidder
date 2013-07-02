/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.master.thesis.ejb;

import com.master.thesis.persistence.FacebookUserProfiles;
import com.master.thesis.persistence.GoalTags;
import com.master.thesis.persistence.ResourceTypes;
import com.master.thesis.persistence.Resources;
import com.master.thesis.persistence.ResourcesGoalsUsers;
import com.master.thesis.persistence.TwitterUserProfiles;
import com.master.thesis.persistence.UserAccounts;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Javier
 */
@Stateless
@LocalBean
public class ControlSessionBean {

    @PersistenceContext(unitName = "Quidder-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public void createResource(Resources resource) {
        em.persist(resource);
    }

    public void editResource(Resources resource) {
        em.merge(resource);
    }

    public void removeResource(Resources resource) {
        em.remove(resource);
    }

    public Resources findResource(Object id) {
        return em.find(Resources.class, id);
    }

    public List<Resources> findAllResources() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Resources.class));
        return em.createQuery(cq).getResultList();
    }

    public int countResources() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<Resources> rt = cq.from(Resources.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        javax.persistence.Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    /**
     * De aquí en adelante lo metodos corresponden a la Entidad ResourceType
     */
    public void createResourceType(ResourceTypes resourceType) {
        em.persist(resourceType);
    }

    public void editResourceType(ResourceTypes resourceType) {
        em.merge(resourceType);
    }

    public void removeResourceType(ResourceTypes resourceType) {
        em.remove(resourceType);
    }

    public ResourceTypes findResourceType(Object id) {
        return em.find(ResourceTypes.class, id);
    }

    public List<ResourceTypes> findAllResourceTypes() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(ResourceTypes.class));
        return em.createQuery(cq).getResultList();
    }

    /*
     *De aquí en adelante los métodos corresponden a la entidad UserAccount 
     * 
     */
    
    public void createUserAccount(UserAccounts userAccount) {
        System.out.println("Control session ID User Account: " +  userAccount);
        em.persist(userAccount);
    }

    public void editUserAccount(UserAccounts userAccount) {
        em.merge(userAccount);
    }

    public void removeUserAccount(UserAccounts userAccount) {
        em.remove(userAccount);
    }

    public UserAccounts findUserAccount(Object id) {        
        return em.find(UserAccounts.class, id);
    }        

    public List<UserAccounts> findAllUserAccounts() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(UserAccounts.class));
        return em.createQuery(cq).getResultList();
    }

    public int countUserAccounts() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<UserAccounts> rt = cq.from(UserAccounts.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        javax.persistence.Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
    /*
     * Los siguientes metodos corresponende a la entidad TwitterUserProfiles
     */      
    
    public void createTwitterUserProfile(TwitterUserProfiles twitterUserProfile) {
        System.out.println("Control session ID TwitterUserProfiles: " + twitterUserProfile);
        em.persist(twitterUserProfile);
    }

    public void editTwitterUserProfile(TwitterUserProfiles twitterUserProfile) {
        em.merge(twitterUserProfile);
    }

    public void removeTwitterUserProfile(TwitterUserProfiles twitterUserProfile) {
        em.remove(twitterUserProfile);
    }

    public TwitterUserProfiles findTwitterUserProfile(Object id) {
        return em.find(TwitterUserProfiles.class, id);
    }       

    public List<TwitterUserProfiles> findAllTwitterUserProfiles() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(TwitterUserProfiles.class));
        return em.createQuery(cq).getResultList();
    }

    public int countTwitterUserProfiles() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<TwitterUserProfiles> rt = cq.from(TwitterUserProfiles.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        javax.persistence.Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }  
    
    /*
     * Los siguientes metodos corresponende a la entidad FacebookUserProfiles
     */      
    
    public void createFacebookUserProfile(FacebookUserProfiles facebookUserProfiles) {
        System.out.println("Control session ID FacebookUserProfiles: " + facebookUserProfiles.getIdFbUserProfile());        
        em.persist(facebookUserProfiles);
    }

    public void editFacebookUserProfile(FacebookUserProfiles facebookUserProfiles) {
        em.merge(facebookUserProfiles);
    }

    public void removeFacebookUserProfile(FacebookUserProfiles facebookUserProfiles) {
        em.remove(facebookUserProfiles);
    }

    public FacebookUserProfiles findFacebookUserProfile(Object id) {
        return em.find(FacebookUserProfiles.class, id);
    }       

    public List<FacebookUserProfiles> findAllFacebookUserProfiles() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(FacebookUserProfiles.class));
        return em.createQuery(cq).getResultList();
    }

    public int countFacebookUserProfiles() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<FacebookUserProfiles> rt = cq.from(FacebookUserProfiles.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        javax.persistence.Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }    
    
    /*
     * Los siguientes metodos corresponende a la entidad GoalTags
     */      
    
    public void createGoalTags(GoalTags goalTags) {        
        em.persist(goalTags);
    }

    public void editGoalTags(GoalTags goalTags) {
        em.merge(goalTags);
    }

    public void removeGoalTags(GoalTags goalTags) {
        em.remove(goalTags);
    }

    public GoalTags findGoalTags(Object id) {
        return em.find(GoalTags.class, id);
    }       

    public List<GoalTags> findAllGoalTags() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(GoalTags.class));
        return em.createQuery(cq).getResultList();
    }

    public int countGoalTags() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<GoalTags> rt = cq.from(GoalTags.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        javax.persistence.Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }        
    
    /*
     * Los siguientes metodos corresponende a la entidad ResourcesGoalsUsers
     */      
    
    public void createResourcesGoalsUsers(ResourcesGoalsUsers resourcesGoalsUsers) {        
        em.persist(resourcesGoalsUsers);
    }

    public void editResourcesGoalsUsers(ResourcesGoalsUsers resourcesGoalsUsers) {
        em.merge(resourcesGoalsUsers);
    }

    public void removeResourcesGoalsUsers(ResourcesGoalsUsers resourcesGoalsUsers) {
        em.remove(resourcesGoalsUsers);
    }

    public ResourcesGoalsUsers findResourcesGoalsUsers(Object id) {
        return em.find(ResourcesGoalsUsers.class, id);
    }       

    public List<ResourcesGoalsUsers> findAllResourcesGoalsUsers() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(ResourcesGoalsUsers.class));
        return em.createQuery(cq).getResultList();
    }

    public int countResourcesGoalsUsers() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<ResourcesGoalsUsers> rt = cq.from(ResourcesGoalsUsers.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        javax.persistence.Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }        
    
}
