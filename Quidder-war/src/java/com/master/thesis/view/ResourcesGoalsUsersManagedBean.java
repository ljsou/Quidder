/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.master.thesis.view;

import com.master.thesis.ejb.ControlSessionBean;
import com.master.thesis.persistence.GoalTags;
import com.master.thesis.persistence.Resources;
import com.master.thesis.persistence.ResourcesGoalsUsers;
import com.master.thesis.persistence.UserAccounts;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Javier
 */
@ManagedBean
@SessionScoped
public class ResourcesGoalsUsersManagedBean {

    @EJB
    private ControlSessionBean controlSessionBean;
    private Resources currentResource;
    private UserAccounts currentUserAcount;
    private GoalTags currentGoalTag;
    private ResourcesGoalsUsers currentResourcesGoalsUsers;
    private List<ResourcesGoalsUsers> resourcesGoalsUsers;
    private String goal;
    private Integer idResource;
    private Integer idUserAccount;
    private Integer IdGoal;

    public ResourcesGoalsUsersManagedBean() {
        controlSessionBean = new ControlSessionBean();
        System.out.println("current user...");
        this.currentResource = new Resources();
        this.currentUserAcount = new UserAccounts();
        this.currentGoalTag = new GoalTags();
        this.currentResourcesGoalsUsers = new ResourcesGoalsUsers();
        this.resourcesGoalsUsers = new ArrayList<ResourcesGoalsUsers>();
        this.goal = null;
        this.idResource = null;
        this.idUserAccount = null;
    }

    public void createResourcesGoalsUsers(Integer idResource, String goal, Integer idUserAccount) {
        System.out.println("enter to createResourcesGoalsUsers");
        Timestamp timestamp = new Timestamp((new java.util.Date()).getTime());
        this.currentGoalTag.setTagName(goal);
        this.currentResourcesGoalsUsers.setGoalTags(currentGoalTag);
        this.currentResourcesGoalsUsers.setResources(currentResource);
        this.currentResourcesGoalsUsers.setUserAccounts(currentUserAcount);
        this.currentResourcesGoalsUsers.setTimestamp(timestamp);
    }

    public Resources findResourceById(Object id) {
        return controlSessionBean.findResource(id);
    }

    public UserAccounts findUserAccountById(Object id) {
        return controlSessionBean.findUserAccount(id);
    }

    public void createGoalTag() {
        System.out.println("IdGoal: " + goal + " - Goal:" + IdGoal);        
        this.controlSessionBean.createGoalTags(this.currentGoalTag);
    }

    public ControlSessionBean getControlSessionBean() {
        return controlSessionBean;
    }

    public void setControlSessionBean(ControlSessionBean controlSessionBean) {
        this.controlSessionBean = controlSessionBean;
    }

    public Resources getCurrentResource() {
        return currentResource;
    }

    public void setCurrentResource(Resources currentResource) {
        this.currentResource = currentResource;
    }

    public UserAccounts getCurrentUserAcount() {
        return currentUserAcount;
    }

    public void setCurrentUserAcount(UserAccounts currentUserAcount) {
        this.currentUserAcount = currentUserAcount;
    }

    public GoalTags getCurrentGoalTag() {
        return currentGoalTag;
    }

    public void setCurrentGoalTag(GoalTags currentGoalTag) {
        this.currentGoalTag = currentGoalTag;
    }

    public ResourcesGoalsUsers getCurrentResourcesGoalsUsers() {
        return currentResourcesGoalsUsers;
    }

    public void setCurrentResourcesGoalsUsers(ResourcesGoalsUsers currentResourcesGoalsUsers) {
        this.currentResourcesGoalsUsers = currentResourcesGoalsUsers;
    }

    public List<ResourcesGoalsUsers> getResourcesGoalsUsers() {
        return resourcesGoalsUsers;
    }

    public void setResourcesGoalsUsers(List<ResourcesGoalsUsers> resourcesGoalsUsers) {
        this.resourcesGoalsUsers = resourcesGoalsUsers;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public Integer getIdGoal() {
        return IdGoal;
    }

    public void setIdGoal(Integer IdGoal) {
        this.IdGoal = IdGoal;
    }        

    public Integer getIdResource() {
        return idResource;
    }

    public void setIdResource(Integer idResource) {
        this.idResource = idResource;
    }

    public Integer getIdUserAccount() {
        return idUserAccount;
    }

    public void setIdUserAccount(Integer idUserAccount) {
        this.idUserAccount = idUserAccount;
    }        
}
