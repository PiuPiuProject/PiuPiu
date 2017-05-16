/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
 * @author DAM
 */
@Entity
@Table(name = "piu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Piu.findAll", query = "SELECT p FROM Piu p")
    , @NamedQuery(name = "Piu.findByPiuId", query = "SELECT p FROM Piu p WHERE p.piuId = :piuId")
    , @NamedQuery(name = "Piu.findByText", query = "SELECT p FROM Piu p WHERE p.text = :text")
    , @NamedQuery(name = "Piu.findByPubDate", query = "SELECT p FROM Piu p WHERE p.pubDate = :pubDate")})
public class Piu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "piu_id")
    private Integer piuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "text")
    private String text;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pub_date")
    @Temporal(TemporalType.DATE)
    private Date pubDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "piuId")
    private Collection<Comment> commentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "piuId")
    private Collection<LikePiu> likePiuCollection;
    @JoinColumn(name = "author_id", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private User authorId;

    public Piu() {
    }

    public Piu(Integer piuId) {
        this.piuId = piuId;
    }

    public Piu(Integer piuId, String text, Date pubDate) {
        this.piuId = piuId;
        this.text = text;
        this.pubDate = pubDate;
    }

    public Piu(String text, Date pubDate, User authorId) {
        this.text = text;
        this.pubDate = pubDate;
        this.authorId = authorId;
    }
    
   

    public Integer getPiuId() {
        return piuId;
    }

    public void setPiuId(Integer piuId) {
        this.piuId = piuId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    @XmlTransient
    public Collection<LikePiu> getLikePiuCollection() {
        return likePiuCollection;
    }

    public void setLikePiuCollection(Collection<LikePiu> likePiuCollection) {
        this.likePiuCollection = likePiuCollection;
    }

    public User getAuthorId() {
        return authorId;
    }

    public void setAuthorId(User authorId) {
        this.authorId = authorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (piuId != null ? piuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Piu)) {
            return false;
        }
        Piu other = (Piu) object;
        if ((this.piuId == null && other.piuId != null) || (this.piuId != null && !this.piuId.equals(other.piuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Piu[ piuId=" + piuId + " ]";
    }
    
}
