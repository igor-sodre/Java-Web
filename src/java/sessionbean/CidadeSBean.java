package sessionbean;


import entidade.Cidade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author igor
 */
@Stateless
public class CidadeSBean {

    @PersistenceContext(unitName = "Java-WebPU")
    private EntityManager em;

    public void salvar(Cidade cidade) {
        em.merge(cidade);
    }

    public void excluir(Cidade cidade) {
        em.remove(em.find(Cidade.class, cidade.getId()));
    }

    public Cidade pesquisar(Long id) {
        return em.find(Cidade.class, id);
    }

    public List<Cidade> pesquisar(String nome) {
        List<Cidade> listaCidades;
        Query consulta = em.createNamedQuery("Cidade.findByNome");
        consulta.setParameter("nome", nome.toUpperCase() + "%");
        listaCidades = consulta.getResultList();
        return listaCidades;
    }
}
