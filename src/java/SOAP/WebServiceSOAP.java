/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SOAP;

import controller.Controller;
import entidades.*;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import manager.ManagerConcurso;

/**
 *
 * @author JordyTG
 */
@WebService(serviceName = "WebServiceSOAP")
public class WebServiceSOAP {

    /**
     * This is a sample web service operation
     */
    @EJB
    private ManagerConcurso manager;

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "consultar")
    public List<tbl_participante> consultar(@WebParam(name = "id") int id) {
        try {
            List<tbl_participante> lista = manager.findConcurso(id).getTblparticipanteList();
            return lista;
        } catch (Exception e) {
            return null;
        }

    }
    @WebMethod(operationName = "consultarMazorca")
    public List<tbl_grupo> consultarMazorca(@WebParam(name = "id") int id) {
        try {
            List<tbl_grupo> lista = manager.findConcurso(id).getTblgrupoList();
            return lista;
        } catch (Exception e) {
            return null;
        }

    }

}
