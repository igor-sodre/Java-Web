/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;


import entidade.Veiculo;
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
public class VeiculoSBean {

    @PersistenceContext(unitName = "Java-WebPU")
   private EntityManager em;
    
    public void salvar(Veiculo veiculo){
        System.out.println("Salvar veiculo sbean " + veiculo.getNome() );
        em.merge(veiculo);
        
    }
    public void excluir (Veiculo veiculo){
    em.remove(em.find(Veiculo.class, veiculo.getId()));
} 
    public Veiculo pesquisar (long id){
        return em.find(Veiculo.class, id);
    }
    public List<Veiculo> pesquisar(String valorPesquisa){
        List<Veiculo> listaveicVeiculos;
        Query consulta = em.createNamedQuery("Veiculo.findByNome");
        consulta.setParameter("nome", valorPesquisa + "%");
        listaveicVeiculos = consulta.getResultList();
        return listaveicVeiculos;
    }  
}
