/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JordyTG
 */
@Entity
@Table(name = "tbl_grupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "tbl_grupo.findAll", query = "SELECT t FROM tbl_grupo t")
    , @NamedQuery(name = "tbl_grupo.findByGruId", query = "SELECT t FROM tbl_grupo t WHERE t.gruId = :gruId")
    , @NamedQuery(name = "tbl_grupo.findByGruNombre", query = "SELECT t FROM tbl_grupo t WHERE t.gruNombre = :gruNombre")
    , @NamedQuery(name = "tbl_grupo.findByGruPuntajeCoreografia", query = "SELECT t FROM tbl_grupo t WHERE t.gruPuntajeCoreografia = :gruPuntajeCoreografia")
    , @NamedQuery(name = "tbl_grupo.findByGruPuntajeExpresioncorporal", query = "SELECT t FROM tbl_grupo t WHERE t.gruPuntajeExpresioncorporal = :gruPuntajeExpresioncorporal")
    , @NamedQuery(name = "tbl_grupo.findByGruPuntajeAutenticidad", query = "SELECT t FROM tbl_grupo t WHERE t.gruPuntajeAutenticidad = :gruPuntajeAutenticidad")
    , @NamedQuery(name = "tbl_grupo.findByGruPuntajeVestuario", query = "SELECT t FROM tbl_grupo t WHERE t.gruPuntajeVestuario = :gruPuntajeVestuario")
    , @NamedQuery(name = "tbl_grupo.findByGruPuntajeResultado", query = "SELECT t FROM tbl_grupo t WHERE t.gruPuntajeResultado = :gruPuntajeResultado")})
public class tbl_grupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gru_id")
    private Integer gruId;
    @Size(max = 255)
    @Column(name = "gru_nombre")
    private String gruNombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "gru_puntaje_coreografia")
    private Double gruPuntajeCoreografia;
    @Column(name = "gru_puntaje_expresioncorporal")
    private Double gruPuntajeExpresioncorporal;
    @Column(name = "gru_puntaje_autenticidad")
    private Double gruPuntajeAutenticidad;
    @Column(name = "gru_puntaje_vestuario")
    private Double gruPuntajeVestuario;
    @Column(name = "gru_puntaje_resultado")
    private Double gruPuntajeResultado;
    @JoinColumn(name = "con_id", referencedColumnName = "con_id")
    @ManyToOne
    private tbl_concurso conId;

    public tbl_grupo() {
    }

    public tbl_grupo(Integer gruId) {
        this.gruId = gruId;
    }

    public Integer getGruId() {
        return gruId;
    }

    public void setGruId(Integer gruId) {
        this.gruId = gruId;
    }

    public String getGruNombre() {
        return gruNombre;
    }

    public void setGruNombre(String gruNombre) {
        this.gruNombre = gruNombre;
    }

    public Double getGruPuntajeCoreografia() {
        return gruPuntajeCoreografia;
    }

    public void setGruPuntajeCoreografia(Double gruPuntajeCoreografia) {
        this.gruPuntajeCoreografia = gruPuntajeCoreografia;
    }

    public Double getGruPuntajeExpresioncorporal() {
        return gruPuntajeExpresioncorporal;
    }

    public void setGruPuntajeExpresioncorporal(Double gruPuntajeExpresioncorporal) {
        this.gruPuntajeExpresioncorporal = gruPuntajeExpresioncorporal;
    }

    public Double getGruPuntajeAutenticidad() {
        return gruPuntajeAutenticidad;
    }

    public void setGruPuntajeAutenticidad(Double gruPuntajeAutenticidad) {
        this.gruPuntajeAutenticidad = gruPuntajeAutenticidad;
    }

    public Double getGruPuntajeVestuario() {
        return gruPuntajeVestuario;
    }

    public void setGruPuntajeVestuario(Double gruPuntajeVestuario) {
        this.gruPuntajeVestuario = gruPuntajeVestuario;
    }

    public Double getGruPuntajeResultado() {
        return gruPuntajeResultado;
    }

    public void setGruPuntajeResultado(Double gruPuntajeResultado) {
        this.gruPuntajeResultado = gruPuntajeResultado;
    }

    public tbl_concurso getConId() {
        return conId;
    }

    public void setConId(tbl_concurso conId) {
        this.conId = conId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gruId != null ? gruId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof tbl_grupo)) {
            return false;
        }
        tbl_grupo other = (tbl_grupo) object;
        if ((this.gruId == null && other.gruId != null) || (this.gruId != null && !this.gruId.equals(other.gruId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.tbl_grupo[ gruId=" + gruId + " ]";
    }
    
}
