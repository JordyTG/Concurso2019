/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JordyTG
 */
@Entity
@Table(name = "tbl_concurso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "tbl_concurso.findAll", query = "SELECT t FROM tbl_concurso t")
    , @NamedQuery(name = "tbl_concurso.findByConId", query = "SELECT t FROM tbl_concurso t WHERE t.conId = :conId")
    , @NamedQuery(name = "tbl_concurso.findByConNombre", query = "SELECT t FROM tbl_concurso t WHERE t.conNombre = :conNombre")
    , @NamedQuery(name = "tbl_concurso.findByConDescripcion", query = "SELECT t FROM tbl_concurso t WHERE t.conDescripcion = :conDescripcion")})
public class tbl_concurso implements Serializable {

    @OneToMany(mappedBy = "conId", cascade = CascadeType.ALL)
    private List<tbl_grupo> tblgrupoList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "con_id")
    private Integer conId;
    @Size(max = 255)
    @Column(name = "con_nombre")
    private String conNombre;
    @Size(max = 255)
    @Column(name = "con_descripcion")
    private String conDescripcion;
    @OneToMany(mappedBy = "conId", cascade = CascadeType.ALL)
    private List<tbl_participante> tblparticipanteList;

    public tbl_concurso() {
    }

    public tbl_concurso(Integer conId) {
        this.conId = conId;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public String getConNombre() {
        return conNombre;
    }

    public void setConNombre(String conNombre) {
        this.conNombre = conNombre;
    }

    public String getConDescripcion() {
        return conDescripcion;
    }

    public void setConDescripcion(String conDescripcion) {
        this.conDescripcion = conDescripcion;
    }

    @XmlTransient
    public List<tbl_participante> getTblparticipanteList() {
        return tblparticipanteList;
    }

    public void setTblparticipanteList(List<tbl_participante> tblparticipanteList) {
        this.tblparticipanteList = tblparticipanteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conId != null ? conId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof tbl_concurso)) {
            return false;
        }
        tbl_concurso other = (tbl_concurso) object;
        if ((this.conId == null && other.conId != null) || (this.conId != null && !this.conId.equals(other.conId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.tbl_concurso[ conId=" + conId + " ]";
    }

    @XmlTransient
    public List<tbl_grupo> getTblgrupoList() {
        return tblgrupoList;
    }

    public void setTblgrupoList(List<tbl_grupo> tblgrupoList) {
        this.tblgrupoList = tblgrupoList;
    }
    
}
