/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entidades.*;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import manager.ManagerConcurso;
import view.util.JSFUtil;

/**
 *
 * @author JordyTG
 */
@ManagedBean
@SessionScoped
public class Controller {

    private int idConcursoSeleccionado;
    private List<tbl_participante> lista;
    private List<tbl_concurso> listaConcursos;
    private tbl_concurso concurso;
    private tbl_participante participante;
    private tbl_grupo grupo;
    private String accion;

    @PostConstruct
    public void inicializar() {
        listaConcursos = obtenerListaConcursos();
        concurso = new tbl_concurso();
        setGrupo(new tbl_grupo());
        participante = new tbl_participante();
        participante.setParNombre("");
        participante.setParCategoria("SOLISTA");
        grupo.setGruNombre("");

    }

    @EJB
    private ManagerConcurso manager;
    
    
    public void inicializarConcurso() {
        try {
            concurso = manager.findConcurso(concurso.getConId());
            participante = new tbl_participante();
            participante.setParNombre("");
            participante.setParCategoria("SOLISTA");
        } catch (Exception ex) {
            mostrarMensaje(ex.getMessage());

        }
    }
    public void inicializarMazorca() {
        try {
            concurso = manager.findConcurso(concurso.getConId());
            grupo = new tbl_grupo();
            grupo.setGruNombre("");
            
        } catch (Exception ex) {
            mostrarMensaje(ex.getMessage());

        }
    }

    

    public void mostrarMensaje() {
        JSFUtil.crearMensajeInfo("Mensaje de Informacion");
    }

    public void mostrarMensaje(String msn) {
        JSFUtil.crearMensajeInfo(msn);
    }

    public List<tbl_concurso> obtenerListaConcursos() {
        List<tbl_concurso> lista = manager.findAllConcursos();
        return lista;
    }

    public void guardarParticipante() {
        try {
            participante.setConId(concurso);
            tbl_participante obj = manager.guardarParticipante(participante, "crear");
            participante = obj;
            inicializarConcurso();
            mostrarMensaje(obj.getParNombre() + " CREADO");

        } catch (Exception ex) {
            mostrarMensaje(ex.getMessage());

        }
    }
    public void guardarGrupo() {
        try {
            grupo.setConId(concurso);
            tbl_grupo obj = manager.guardarGrupo(grupo, "crear");
            grupo = obj;
            inicializarMazorca();
            mostrarMensaje(obj.getGruNombre()+ " CREADO");

        } catch (Exception ex) {
            mostrarMensaje(ex.getMessage());

        }
    }

    public void guardarConcurso() {
        try {
            tbl_concurso obj = manager.guardarCampeonato(concurso, "crear");
            concurso = obj;

            mostrarMensaje(obj.getConNombre() + " CREADO");

        } catch (Exception ex) {
            mostrarMensaje(ex.getMessage());

        }
    }

    public String entrarConcurso(int id) {
        try {
            tbl_concurso obj = manager.findConcurso(id);
            concurso = obj;
            mostrarMensaje(obj.getConNombre() + " ENCONTRADO");
            if(obj.getConDescripcion().equals("SONAR"))
            {
                return "concurso";                
            }else
            {
                return "mazorca";                
            }

        } catch (Exception ex) {
            mostrarMensaje(ex.getMessage());
            return null;
        }
    }

    public void cargarConcurso(int id) {
        try {
            tbl_concurso obj = manager.readConcurso(id);
            concurso = obj;
            mostrarMensaje(obj.getConNombre() + "ENCONTRADO");
        } catch (Exception ex) {
            mostrarMensaje(ex.getMessage());
        }
    }

    public void cargarParticipante(int id) {
        try {
            
            tbl_participante obj = manager.findParticipante(id);
            participante = obj;
            mostrarMensaje(obj.getParNombre() + " ENCONTRADO");
        } catch (Exception ex) {
            mostrarMensaje(ex.getMessage());
        }
    }
    public void cargarGrupo(int id) {
        try {
            tbl_grupo obj = manager.findGrupo(id);
            grupo = obj;
            mostrarMensaje(obj.getGruNombre()+ " ENCONTRADO");
        } catch (Exception ex) {
            mostrarMensaje(ex.getMessage());
        }
    }

    /**
     * @return the idConcursoSeleccionado
     */
    public int getIdConcursoSeleccionado() {
        return idConcursoSeleccionado;
    }

    public void editarConcurso() {
        try {
            manager.editarConcurso(concurso);
            mostrarMensaje("Actualizado");
        } catch (Exception ex) {
            mostrarMensaje(ex.getMessage());
        }
    }

    public void editarParticipante() {
        try {
            manager.editarParticipante(participante);
            inicializarConcurso();

            mostrarMensaje("Actualizado");
        } catch (Exception ex) {
            mostrarMensaje(ex.getMessage());
        }
    }
    public void editarGrupo() {
        try {
            manager.editarGrupo(grupo);
            inicializarMazorca();
            mostrarMensaje("Actualizado");
        } catch (Exception ex) {
            mostrarMensaje(ex.getMessage());
        }
    }

    public void eliminarConcurso(int id) {
        try {
            manager.eliminarConcurso(id);
            mostrarMensaje("Eliminado");
        } catch (Exception ex) {
            mostrarMensaje(ex.getMessage());
        }
    }

    public void eliminarParticipante(int id) {
        try {
            manager.eliminarParticipante(id);
            inicializarConcurso();

            mostrarMensaje("Eliminado");
        } catch (Exception ex) {
            mostrarMensaje(ex.getMessage());
        }
    }
    
    public void eliminarGrupo(int id) {
        try {
            manager.eliminarGrupo(id);
            inicializarConcurso();

            mostrarMensaje("Eliminado");
        } catch (Exception ex) {
            mostrarMensaje(ex.getMessage());
        }
    }

    /**
     * @param idConcursoSeleccionado the idConcursoSeleccionado to set
     */
    public void setIdConcursoSeleccionado(int idConcursoSeleccionado) {
        this.idConcursoSeleccionado = idConcursoSeleccionado;
    }

    /**
     * @return the lista
     */
    public List<tbl_participante> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<tbl_participante> lista) {
        this.lista = lista;
    }

    /**
     * @return the concurso
     */
    public tbl_concurso getConcurso() {
        return concurso;
    }

    /**
     * @param concurso the concurso to set
     */
    public void setConcurso(tbl_concurso concurso) {
        this.concurso = concurso;
    }

    /**
     * @return the participante
     */
    public tbl_participante getParticipante() {
        return participante;
    }

    /**
     * @param participante the participante to set
     */
    public void setParticipante(tbl_participante participante) {
        this.participante = participante;
    }

    /**
     * @return the accion
     */
    public String getAccion() {
        return accion;
    }

    /**
     * @param accion the accion to set
     */
    public void setAccion(String accion) {
        this.accion = accion;
    }

    /**
     * @return the listaConcursos
     */
    public List<tbl_concurso> getListaConcursos() {
        return listaConcursos;
    }

    /**
     * @param listaConcursos the listaConcursos to set
     */
    public void setListaConcursos(List<tbl_concurso> listaConcursos) {
        this.listaConcursos = listaConcursos;
    }

    /**
     * @return the grupo
     */
    public tbl_grupo getGrupo() {
        return grupo;
    }

    /**
     * @param grupo the grupo to set
     */
    public void setGrupo(tbl_grupo grupo) {
        this.grupo = grupo;
    }

}
