package sessionbean;


import entidade.Marcas;
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
public class MarcasSBean {

    public static List<Marcas> pesquisar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @PersistenceContext(unitName = "Java-WebPU")
   private EntityManager em;
    
    public void salvar(Marcas marcas){
        System.out.println("Salvar marcas sbean " + marcas.getNome() );
        em.merge(marcas);
        
    }
    public void excluir (Marcas marcas){
    em.remove(em.find(Marcas.class, marcas.getId()));
} 
    public Marcas pesquisar (long id){
        return em.find(Marcas.class, id);
    }
    public List<Marcas> pesquisar(String Pesquisamarcas){
        List<Marcas> listamarcas;
        Query consulta = em.createNamedQuery("Marcas.findByNome");
        consulta.setParameter("nome", Pesquisamarcas + "%");
        listamarcas = consulta.getResultList();
        return listamarcas;
    }  
}