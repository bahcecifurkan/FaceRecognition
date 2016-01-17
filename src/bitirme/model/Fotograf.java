/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitirme.model;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author furkanb
 */
@Entity
@Table(name = "Fotograf")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "Fotograf.findAll", query = "SELECT f FROM Fotograf f"),
   @NamedQuery(name = "Fotograf.findByIdFotograf", query = "SELECT f FROM Fotograf f WHERE f.idFotograf = :idFotograf"),
   @NamedQuery(name = "Fotograf.findByUrl", query = "SELECT f FROM Fotograf f WHERE f.url = :url")})
public class Fotograf implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(name = "idFotograf")
   private Integer idFotograf;
   @Basic(optional = false)
   @Column(name = "url")
   private String url;
   @JoinColumn(name = "Kullanici_idKullanici", referencedColumnName = "idKullanici")
   @ManyToOne(optional = false)
   private Kullanici kullaniciidKullanici;

   public Fotograf() {
   }

   public Fotograf(Integer idFotograf) {
      this.idFotograf = idFotograf;
   }

   public Fotograf(Integer idFotograf, String url) {
      this.idFotograf = idFotograf;
      this.url = url;
   }

   public Integer getIdFotograf() {
      return idFotograf;
   }

   public void setIdFotograf(Integer idFotograf) {
      this.idFotograf = idFotograf;
   }

   public String getUrl() {
      return url;
   }

   public void setUrl(String url) {
      this.url = url;
   }

   public Kullanici getKullaniciidKullanici() {
      return kullaniciidKullanici;
   }

   public void setKullaniciidKullanici(Kullanici kullaniciidKullanici) {
      this.kullaniciidKullanici = kullaniciidKullanici;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (idFotograf != null ? idFotograf.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Fotograf)) {
         return false;
      }
      Fotograf other = (Fotograf) object;
      if ((this.idFotograf == null && other.idFotograf != null) || (this.idFotograf != null && !this.idFotograf.equals(other.idFotograf))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "bitirme.model.Fotograf[ idFotograf=" + idFotograf + " ]";
   }
   
}
