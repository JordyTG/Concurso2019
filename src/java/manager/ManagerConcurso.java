/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entidades.tbl_concurso;
import entidades.tbl_grupo;
import entidades.tbl_participante;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author JordyTG
 */
@Stateless
@LocalBean
public class ManagerConcurso {

    @PersistenceContext(unitName = "concursoDS")
    private EntityManager em;

    public tbl_concurso guardarCampeonato(tbl_concurso obj, String accion) throws Exception {
        if (obj.getConNombre() == null || obj.getConNombre().length() < 6) {
            throw new Exception("Nombre requerido o muy corto (Menor a 5 caracteres)"); // lo eliminamos:
        }
//        if (obj.getTblparticipanteList().size() == 0) {
//            throw new Exception("Nombre hay elementos en lista participantes."); // lo eliminamos:
//        }
        if (accion.equals("crear")) {

            em.persist(obj);
        } else {
            em.merge(obj);
        }
        return obj;

    }

    public tbl_participante guardarParticipante(tbl_participante obj, String accion) throws Exception {
        if (obj.getParNombre() == null || obj.getParNombre().length() < 1) {
            throw new Exception("Nombre requerido o muy corto (Menor a 1 caracteres)"); // lo eliminamos:
        }
        if (accion.equals("crear")) {

            
            obj.setParPuntajeCompas(new BigDecimal("0.0"));
            obj.setParPuntajeDominioescenico(new BigDecimal("0.0"));
            obj.setParPuntajePresentacion(new BigDecimal("0.0"));
            obj.setParPuntajeVocalizacion(new BigDecimal("0.0"));
            obj.setParPuntajeResultado(new BigDecimal("0.0"));

            em.persist(obj);
        } else {
            em.merge(obj);
        }
        return obj;
    }

    public tbl_grupo guardarGrupo(tbl_grupo obj, String accion) throws Exception {
        if (obj.getGruNombre() == null || obj.getGruNombre().length() < 1) {
            throw new Exception("Nombre requerido o muy corto (Menor a 1 caracteres)"); // lo eliminamos:
        }
        if (accion.equals("crear")) {
            obj.setGruPuntajeAutenticidad(0.0);
            obj.setGruPuntajeCoreografia(0.0);
            obj.setGruPuntajeExpresioncorporal(0.0);
            obj.setGruPuntajeVestuario(0.0);
            obj.setGruPuntajeResultado(0.0);
            em.persist(obj);
        } else {
            em.merge(obj);
        }
        return obj;
    }

    public tbl_concurso findConcurso(int id) throws Exception {
        tbl_concurso a = em.find(tbl_concurso.class, id);
        if (a == null) {
            throw new Exception("No existe el Campeonato especificado."); // lo eliminamos:
        }
        a.getTblparticipanteList().size();
        a.getTblgrupoList().size();

        for (int i = 0; i < a.getTblgrupoList().size(); i++) {
            System.out.println("----::: " + a.getTblgrupoList().get(i).getGruNombre());
        }

        return a;
    }

    public tbl_concurso readConcurso(int id) throws Exception {
        tbl_concurso a = em.find(tbl_concurso.class, id);
        if (a == null) {
            throw new Exception("No existe el Campeonato especificado."); // lo eliminamos:
        }
        return a;
    }

    public tbl_participante findParticipante(int id) throws Exception {
        tbl_participante a = em.find(tbl_participante.class, id);
        if (a == null) {
            throw new Exception("No existe el Participante especificado."); // lo eliminamos:
        }
        return a;
    }

    public tbl_grupo findGrupo(int id) throws Exception {
        tbl_grupo a = em.find(tbl_grupo.class, id);
        if (a == null) {
            throw new Exception("No existe el Grupo especificado."); // lo eliminamos:
        }
        return a;
    }

    public void eliminarConcurso(int id) throws Exception { // buscamos el Campeonato:
        tbl_concurso a = findConcurso(id);
        if (a == null) {
            throw new Exception("No existe el Concurso especificado."); // lo eliminamos:
        }
        em.remove(a);
    }

    public void eliminarParticipante(int id) throws Exception { // buscamos el Campeonato:
        tbl_participante a = findParticipante(id);
        if (a == null) {
            throw new Exception("No existe el Participante especificado."); // lo eliminamos:
        }
        em.remove(a);
    }

    public void eliminarGrupo(int id) throws Exception { // buscamos el Campeonato:
        tbl_grupo a = findGrupo(id);
        if (a == null) {
            throw new Exception("No existe el Participante especificado."); // lo eliminamos:
        }
        em.remove(a);
    }

    public void editarConcurso(tbl_concurso objA) throws Exception { // buscamos el

        tbl_concurso a = findConcurso(objA.getConId());
        if (a == null) {
            throw new Exception("No existe el Concurso especificado."); // actualizamos ciertos campos especificados
        }																		// en los parametros del metodo:
        a.setConNombre(objA.getConNombre());
        a.setConDescripcion(objA.getConDescripcion());
        em.merge(a);

    }

    public void editarParticipante(tbl_participante objA) throws Exception { // buscamos el

        tbl_participante a = findParticipante(objA.getParId());
        if (a == null) {
            throw new Exception("No existe el Concurso especificado."); // actualizamos ciertos campos especificados
        }																		// en los parametros del metodo:
        a.setParNombre(objA.getParNombre());
        a.setParCategoria(objA.getParCategoria());
        a.setParPuntajeCompas(objA.getParPuntajeCompas());
        a.setParPuntajeDominioescenico(objA.getParPuntajeDominioescenico());
        a.setParPuntajePresentacion(objA.getParPuntajePresentacion());
        a.setParPuntajeVocalizacion(objA.getParPuntajeVocalizacion());

        double resultado = (objA.getParPuntajeCompas().doubleValue() + objA.getParPuntajeDominioescenico().doubleValue() + objA.getParPuntajePresentacion().doubleValue() + objA.getParPuntajeVocalizacion().doubleValue()) / 4.0;
        BigDecimal resp = new BigDecimal("" + resultado);
        a.setParPuntajeResultado(resp);

        em.merge(a);

    }

    public void editarGrupo(tbl_grupo objA) throws Exception { // buscamos el

        tbl_grupo a = findGrupo(objA.getGruId());
        if (a == null) {
            throw new Exception("No existe el Grupo especificado."); // actualizamos ciertos campos especificados
        }																		// en los parametros del metodo:
        a.setGruNombre(objA.getGruNombre());
        a.setGruPuntajeAutenticidad(objA.getGruPuntajeAutenticidad());
        a.setGruPuntajeCoreografia(objA.getGruPuntajeCoreografia());
        a.setGruPuntajeExpresioncorporal(objA.getGruPuntajeExpresioncorporal());
        a.setGruPuntajeVestuario(objA.getGruPuntajeVestuario());
        a.setGruPuntajeResultado((objA.getGruPuntajeAutenticidad() + objA.getGruPuntajeCoreografia() + objA.getGruPuntajeExpresioncorporal() + objA.getGruPuntajeVestuario()) / 4.0);
        em.merge(a);

    }

    public List<tbl_concurso> findAllConcursos() {
        Query q;
        List<tbl_concurso> listado;
        String sentenciaSQL;
        sentenciaSQL = "SELECT o FROM tbl_concurso o";
        q = em.createQuery(sentenciaSQL);
        listado = q.getResultList();
        return listado;
    }

}
