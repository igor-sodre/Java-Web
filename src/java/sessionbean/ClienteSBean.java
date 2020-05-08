/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entidade.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Igor Sodré
 */
@Stateless
public class ClienteSBean {

    @PersistenceContext(unitName = "Java-WebPU")
   private EntityManager em;
    
    public void salvar(Cliente cliente){
        System.out.println("Salvar cliente sbean " + cliente.getNome() );
        em.merge(cliente);
        
    }
    public void excluir (Cliente cliente){
    em.remove(em.find(Cliente.class, cliente.getId()));
} 
    public Cliente pesquisar (long id){
        return em.find(Cliente.class, id);
    }
    public List<Cliente> pesquisar(String valorPesquisa){
        List<Cliente> listacliClientes;
        Query consulta = em.createNamedQuery("Cliente.findByNome");
        consulta.setParameter("nome", valorPesquisa + "%");
        listacliClientes = consulta.getResultList();
        return listacliClientes;
    } 
}
