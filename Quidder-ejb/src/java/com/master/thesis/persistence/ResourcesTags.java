/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.master.thesis.persistence;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Javier
 */
@Entity
@Table(name = "resources_tags")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResourcesTags.findAll", query = "SELECT r FROM ResourcesTags r"),
    @NamedQuery(name = "ResourcesTags.findByIdResources", query = "SELECT r FROM ResourcesTags r WHERE r.resourcesTagsPK.idResources = :idResources"),
    @NamedQuery(name = "ResourcesTags.findByIdTags", query = "SELECT r FROM ResourcesTags r WHERE r.resourcesTagsPK.idTags = :idTags"),
    @NamedQuery(name = "ResourcesTags.findByAmount", query = "SELECT r FROM ResourcesTags r WHERE r.amount = :amount")})
public class ResourcesTags implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ResourcesTagsPK resourcesTagsPK;
    @Column(name = "amount")
    private Integer amount;
    @JoinColumn(name = "id_resources", referencedColumnName = "id_resource", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Resources resources;
    @JoinColumn(name = "id_tags", referencedColumnName = "id_normal_tag", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NormalTags normalTags;

    public ResourcesTags() {
    }

    public ResourcesTags(ResourcesTagsPK resourcesTagsPK) {
        this.resourcesTagsPK = resourcesTagsPK;
    }

    public ResourcesTags(int idResources, int idTags) {
        this.resourcesTagsPK = new ResourcesTagsPK(idResources, idTags);
    }

    public ResourcesTagsPK getResourcesTagsPK() {
        return resourcesTagsPK;
    }

    public void setResourcesTagsPK(ResourcesTagsPK resourcesTagsPK) {
        this.resourcesTagsPK = resourcesTagsPK;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public NormalTags getNormalTags() {
        return normalTags;
    }

    public void setNormalTags(NormalTags normalTags) {
        this.normalTags = normalTags;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resourcesTagsPK != null ? resourcesTagsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResourcesTags)) {
            return false;
        }
        ResourcesTags other = (ResourcesTags) object;
        if ((this.resourcesTagsPK == null && other.resourcesTagsPK != null) || (this.resourcesTagsPK != null && !this.resourcesTagsPK.equals(other.resourcesTagsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.master.thesis.persistence.ResourcesTags[ resourcesTagsPK=" + resourcesTagsPK + " ]";
    }
    
}
