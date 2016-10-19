/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "emailentry")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emailentry.findAll", query = "SELECT e FROM Emailentry e"),
    @NamedQuery(name = "Emailentry.findById", query = "SELECT e FROM Emailentry e WHERE e.id = :id"),
    @NamedQuery(name = "Emailentry.findByFirstname", query = "SELECT e FROM Emailentry e WHERE e.firstname = :firstname"),
    @NamedQuery(name = "Emailentry.findByLastname", query = "SELECT e FROM Emailentry e WHERE e.lastname = :lastname"),
    @NamedQuery(name = "Emailentry.findByEmailAddress", query = "SELECT e FROM Emailentry e WHERE e.emailAddress = :emailAddress")})
public class Emailentry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "LASTNAME")
    private String lastname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "EmailAddress")
    private String emailAddress;

    public Emailentry() {
    }

    public Emailentry(Integer id) {
        this.id = id;
    }

    public Emailentry(Integer id, String firstname, String lastname, String emailAddress) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailAddress = emailAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emailentry)) {
            return false;
        }
        Emailentry other = (Emailentry) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Emailentry[ id=" + id + " ]";
    }
    
}
