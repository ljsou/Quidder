/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.master.thesis.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Javier
 */
@Entity
@Table(name = "resources")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resources.findAll", query = "SELECT r FROM Resources r"),
    @NamedQuery(name = "Resources.findByIdResource", query = "SELECT r FROM Resources r WHERE r.idResource = :idResource"),
    @NamedQuery(name = "Resources.findByResourceName", query = "SELECT r FROM Resources r WHERE r.resourceName = :resourceName"),
    @NamedQuery(name = "Resources.findByResourceDescription", query = "SELECT r FROM Resources r WHERE r.resourceDescription = :resourceDescription"),
    @NamedQuery(name = "Resources.findByResourceThumbnailAddress", query = "SELECT r FROM Resources r WHERE r.resourceThumbnailAddress = :resourceThumbnailAddress"),
    @NamedQuery(name = "Resources.findByResourceUrl", query = "SELECT r FROM Resources r WHERE r.resourceUrl = :resourceUrl"),
    @NamedQuery(name = "Resources.findByTimestamp", query = "SELECT r FROM Resources r WHERE r.timestamp = :timestamp"),
    @NamedQuery(name = "Resources.findByResourceImageUrl", query = "SELECT r FROM Resources r WHERE r.resourceImageUrl = :resourceImageUrl"),
    @NamedQuery(name = "Resources.findByResourceImageAddress", query = "SELECT r FROM Resources r WHERE r.resourceImageAddress = :resourceImageAddress")})
public class Resources implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_resource")
    private Integer idResource;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "resource_name")
    private String resourceName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 140)
    @Column(name = "resource_description")
    private String resourceDescription;
    @Size(max = 2147483647)
    @Column(name = "resource_thumbnail_address")
    private String resourceThumbnailAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "resource_url")
    private String resourceUrl;
    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @Size(max = 2147483647)
    @Column(name = "resource_image_url")
    private String resourceImageUrl;
    @Size(max = 2147483647)
    @Column(name = "resource_image_address")
    private String resourceImageAddress;
    @JoinColumn(name = "resource_type", referencedColumnName = "id_resource_type")
    @ManyToOne(optional = false)
    private ResourceTypes resourceType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resources")
    private List<ResourcesGoals> resourcesGoalsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resources")
    private List<ResourcesGoalsUsers> resourcesGoalsUsersList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resources")
    private List<ResourcesTags> resourcesTagsList;

    public Resources() {
    }

    public Resources(Integer idResource) {
        this.idResource = idResource;
    }

    public Resources(Integer idResource, String resourceName, String resourceDescription, String resourceUrl) {
        this.idResource = idResource;
        this.resourceName = resourceName;
        this.resourceDescription = resourceDescription;
        this.resourceUrl = resourceUrl;
    }

    public Integer getIdResource() {
        return idResource;
    }

    public void setIdResource(Integer idResource) {
        this.idResource = idResource;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceDescription() {
        return resourceDescription;
    }

    public void setResourceDescription(String resourceDescription) {
        this.resourceDescription = resourceDescription;
    }

    public String getResourceThumbnailAddress() {
        return resourceThumbnailAddress;
    }

    public void setResourceThumbnailAddress(String resourceThumbnailAddress) {
        this.resourceThumbnailAddress = resourceThumbnailAddress;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getResourceImageUrl() {
        return resourceImageUrl;
    }

    public void setResourceImageUrl(String resourceImageUrl) {
        this.resourceImageUrl = resourceImageUrl;
    }

    public String getResourceImageAddress() {
        return resourceImageAddress;
    }

    public void setResourceImageAddress(String resourceImageAddress) {
        this.resourceImageAddress = resourceImageAddress;
    }

    public ResourceTypes getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceTypes resourceType) {
        this.resourceType = resourceType;
    }

    @XmlTransient
    public List<ResourcesGoals> getResourcesGoalsList() {
        return resourcesGoalsList;
    }

    public void setResourcesGoalsList(List<ResourcesGoals> resourcesGoalsList) {
        this.resourcesGoalsList = resourcesGoalsList;
    }

    @XmlTransient
    public List<ResourcesGoalsUsers> getResourcesGoalsUsersList() {
        return resourcesGoalsUsersList;
    }

    public void setResourcesGoalsUsersList(List<ResourcesGoalsUsers> resourcesGoalsUsersList) {
        this.resourcesGoalsUsersList = resourcesGoalsUsersList;
    }

    @XmlTransient
    public List<ResourcesTags> getResourcesTagsList() {
        return resourcesTagsList;
    }

    public void setResourcesTagsList(List<ResourcesTags> resourcesTagsList) {
        this.resourcesTagsList = resourcesTagsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResource != null ? idResource.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resources)) {
            return false;
        }
        Resources other = (Resources) object;
        if ((this.idResource == null && other.idResource != null) || (this.idResource != null && !this.idResource.equals(other.idResource))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.master.thesis.persistence.Resources[ idResource=" + idResource + " ]";
    }
    
}
