/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.master.thesis.view;

import com.master.thesis.ejb.ControlSessionBean;
import com.master.thesis.persistence.ResourceTypes;
import com.master.thesis.persistence.Resources;
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
public class ResourcesManagedBean {

    @EJB
    private ControlSessionBean controlSessionBean;
    private Resources currentResource;
    private ResourceTypes currentyResourceType;
    private List<Resources> resources;
    private List<ResourceTypes> resourcesTypes;

    /*
     * This are methods that control the Resources class
     */
    public ResourcesManagedBean() {
        currentResource = new Resources();
        currentyResourceType = new ResourceTypes();
        //currentResource.setResourceType(currentyResourceType);
    }

    public Resources getCurrentResource() {
        return currentResource;
    }

    public void setCurrentResource(Resources currentResource) {
        this.currentResource = currentResource;
    }

    public List<Resources> getResources() {
        resources = controlSessionBean.findAllResources();
        return resources;
    }

    public void setResources(List<Resources> resources) {
        this.resources = resources;
    }

    public void loadResourcers() {
        this.resources = controlSessionBean.findAllResources();
    }

    public String addResource() {
        System.out.println("Resource Saved");
        controlSessionBean.createResource(currentResource);
        return "SAVED";
    }

    public Resources findResourceByID(Integer idResource) {
        return controlSessionBean.findResource(idResource);
    }

    /*
     * This are methods that control the ResourcesType class
     */
    public void setCurrentyResourceType(ResourceTypes currentyResourceType) {
        this.currentyResourceType = currentyResourceType;
    }

    public List<ResourceTypes> getResourcesTypes() {
        resourcesTypes = controlSessionBean.findAllResourceTypes();
        return resourcesTypes;
    }

    public void setResourcesTypes(List<ResourceTypes> resourcesTypes) {
        this.resourcesTypes = resourcesTypes;
    }

    public String addResourceType() {
        System.out.println("ResourceType Saved");
        controlSessionBean.createResourceType(currentyResourceType);
        return "SAVED";
    }
}
