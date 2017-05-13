/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sergiodiaz
 */
@Entity
@Table(name = "like_piu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LikePiu.findAll", query = "SELECT l FROM LikePiu l")
    , @NamedQuery(name = "LikePiu.findByLikeId", query = "SELECT l FROM LikePiu l WHERE l.likeId = :likeId")})
public class LikePiu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "like_id")
    private Integer likeId;
    @JoinColumn(name = "piu_id", referencedColumnName = "piu_id")
    @ManyToOne(optional = false)
    private Piu piuId;
    @JoinColumn(name = "author_id", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private User authorId;

    public LikePiu() {
    }

    public LikePiu(Integer likeId) {
        this.likeId = likeId;
    }

    public Integer getLikeId() {
        return likeId;
    }

    public void setLikeId(Integer likeId) {
        this.likeId = likeId;
    }

    public Piu getPiuId() {
        return piuId;
    }

    public void setPiuId(Piu piuId) {
        this.piuId = piuId;
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
        hash += (likeId != null ? likeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LikePiu)) {
            return false;
        }
        LikePiu other = (LikePiu) object;
        if ((this.likeId == null && other.likeId != null) || (this.likeId != null && !this.likeId.equals(other.likeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LikePiu[ likeId=" + likeId + " ]";
    }
    
}
