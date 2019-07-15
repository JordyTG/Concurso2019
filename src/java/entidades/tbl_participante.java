/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "tbl_participante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "tbl_participante.findAll", query = "SELECT t FROM tbl_participante t")
    , @NamedQuery(name = "tbl_participante.findByParId", query = "SELECT t FROM tbl_participante t WHERE t.parId = :parId")
    , @NamedQuery(name = "tbl_participante.findByParNombre", query = "SELECT t FROM tbl_participante t WHERE t.parNombre = :parNombre")
    , @NamedQuery(name = "tbl_participante.findByParCategoria", query = "SELECT t FROM tbl_participante t WHERE t.parCategoria = :parCategoria")
    , @NamedQuery(name = "tbl_participante.findByParPuntajeDominioescenico", query = "SELECT t FROM tbl_participante t WHERE t.parPuntajeDominioescenico = :parPuntajeDominioescenico")
    , @NamedQuery(name = "tbl_participante.findByParPuntajeVocalizacion", query = "SELECT t FROM tbl_participante t WHERE t.parPuntajeVocalizacion = :parPuntajeVocalizacion")
    , @NamedQuery(name = "tbl_participante.findByParPuntajePresentacion", query = "SELECT t FROM tbl_participante t WHERE t.parPuntajePresentacion = :parPuntajePresentacion")
    , @NamedQuery(name = "tbl_participante.findByParPuntajeCompas", query = "SELECT t FROM tbl_participante t WHERE t.parPuntajeCompas = :parPuntajeCompas")
    , @NamedQuery(name = "tbl_participante.findByParPuntajeResultado", query = "SELECT t FROM tbl_participante t WHERE t.parPuntajeResultado = :parPuntajeResultado")})
public class tbl_participante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "par_id")
    private Integer parId;
    @Size(max = 255)
    @Column(name = "par_nombre")
    private String parNombre;
    @Size(max = 255)
    @Column(name = "par_categoria")
    private String parCategoria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "par_puntaje_dominioescenico")
    private BigDecimal parPuntajeDominioescenico;
    @Column(name = "par_puntaje_vocalizacion")
    private BigDecimal parPuntajeVocalizacion;
    @Column(name = "par_puntaje_presentacion")
    private BigDecimal parPuntajePresentacion;
    @Column(name = "par_puntaje_compas")
    private BigDecimal parPuntajeCompas;
    @Column(name = "par_puntaje_resultado")
    private BigDecimal parPuntajeResultado;
    @JoinColumn(name = "con_id", referencedColumnName = "con_id")
    @ManyToOne
    private tbl_concurso conId;

    public tbl_participante() {
    }

    public tbl_participante(Integer parId) {
        this.parId = parId;
    }

    public Integer getParId() {
        return parId;
    }

    public void setParId(Integer parId) {
        this.parId = parId;
    }

    public String getParNombre() {
        return parNombre;
    }

    public void setParNombre(String parNombre) {
        this.parNombre = parNombre;
    }

    public String getParCategoria() {
        return parCategoria;
    }

    public void setParCategoria(String parCategoria) {
        this.parCategoria = parCategoria;
    }

    public BigDecimal getParPuntajeDominioescenico() {
        return parPuntajeDominioescenico;
    }

    public void setParPuntajeDominioescenico(BigDecimal parPuntajeDominioescenico) {
        this.parPuntajeDominioescenico = parPuntajeDominioescenico;
    }

    public BigDecimal getParPuntajeVocalizacion() {
        return parPuntajeVocalizacion;
    }

    public void setParPuntajeVocalizacion(BigDecimal parPuntajeVocalizacion) {
        this.parPuntajeVocalizacion = parPuntajeVocalizacion;
    }

    public BigDecimal getParPuntajePresentacion() {
        return parPuntajePresentacion;
    }

    public void setParPuntajePresentacion(BigDecimal parPuntajePresentacion) {
        this.parPuntajePresentacion = parPuntajePresentacion;
    }

    public BigDecimal getParPuntajeCompas() {
        return parPuntajeCompas;
    }

    public void setParPuntajeCompas(BigDecimal parPuntajeCompas) {
        this.parPuntajeCompas = parPuntajeCompas;
    }

    public BigDecimal getParPuntajeResultado() {
        return parPuntajeResultado;
    }

    public void setParPuntajeResultado(BigDecimal parPuntajeResultado) {
        this.parPuntajeResultado = parPuntajeResultado;
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
        hash += (parId != null ? parId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof tbl_participante)) {
            return false;
        }
        tbl_participante other = (tbl_participante) object;
        if ((this.parId == null && other.parId != null) || (this.parId != null && !this.parId.equals(other.parId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.tbl_participante[ parId=" + parId + " ]";
    }
    
}
