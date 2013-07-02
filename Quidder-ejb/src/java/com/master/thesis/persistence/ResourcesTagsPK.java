/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.master.thesis.persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Javier
 */
@Embeddable
public class ResourcesTagsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_resources")
    private int idResources;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tags")
    private int idTags;

    public ResourcesTagsPK() {
    }

    public ResourcesTagsPK(int idResources, int idTags) {
        this.idResources = idResources;
        this.idTags = idTags;
    }

    public int getIdResources() {
        return idResources;
    }

    public void setIdResources(int idResources) {
        this.idResources = idResources;
    }

    public int getIdTags() {
        return idTags;
    }

    public void setIdTags(int idTags) {
        this.idTags = idTags;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idResources;
        hash += (int) idTags;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResourcesTagsPK)) {
            return false;
        }
        ResourcesTagsPK other = (ResourcesTagsPK) object;
        if (this.idResources != other.idResources) {
            return false;
        }
        if (this.idTags != other.idTags) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.master.thesis.persistence.ResourcesTagsPK[ idResources=" + idResources + ", idTags=" + idTags + " ]";
    }
    
}
