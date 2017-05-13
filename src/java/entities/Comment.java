/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sergiodiaz
 */
@Entity
@Table(name = "comment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c")
    , @NamedQuery(name = "Comment.findByCommentId", query = "SELECT c FROM Comment c WHERE c.commentId = :commentId")
    , @NamedQuery(name = "Comment.findByTexwt", query = "SELECT c FROM Comment c WHERE c.texwt = :texwt")
    , @NamedQuery(name = "Comment.findByPubDate", query = "SELECT c FROM Comment c WHERE c.pubDate = :pubDate")})
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "comment_id")
    private Integer commentId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "texwt")
    private String texwt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pub_date")
    @Temporal(TemporalType.DATE)
    private Date pubDate;
    @JoinColumn(name = "piu_id", referencedColumnName = "piu_id")
    @ManyToOne(optional = false)
    private Piu piuId;
    @JoinColumn(name = "author_id", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private User authorId;

    public Comment() {
    }

    public Comment(Integer commentId) {
        this.commentId = commentId;
    }

    public Comment(Integer commentId, String texwt, Date pubDate) {
        this.commentId = commentId;
        this.texwt = texwt;
        this.pubDate = pubDate;
    }

    public Comment(String texwt, Date pubDate, Piu piuId, User authorId) {
        this.texwt = texwt;
        this.pubDate = pubDate;
        this.piuId = piuId;
        this.authorId = authorId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getTexwt() {
        return texwt;
    }

    public void setTexwt(String texwt) {
        this.texwt = texwt;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
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
        hash += (commentId != null ? commentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comment)) {
            return false;
        }
        Comment other = (Comment) object;
        if ((this.commentId == null && other.commentId != null) || (this.commentId != null && !this.commentId.equals(other.commentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Comment[ commentId=" + commentId + " ]";
    }
    
}
