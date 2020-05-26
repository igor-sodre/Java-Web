package beans;

import entidade.Marcas;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import sessionbean.MarcasSBean;


/**
 *
 * @author Igor Sodré
 */
@Named(value = "MarcasMbean")
@SessionScoped
public class MarcasMbean implements Serializable {
    
    private Marcas marcas;
    private String Pesquisarmarcas;
    private List<Marcas> listaMarcas;
   

    @EJB
    private MarcasSBean marcasSBem; 
    
    public MarcasMbean() {
        
    }
    @PostConstruct
    public void init (){
        marcas = new Marcas();
        listaMarcas = new ArrayList<>();
          
    
    }
    
    
    public void botaoPesquisar(){
       listaMarcas = marcasSBem.pesquisar(Pesquisarmarcas);
    }
    
      public void botaoExcluir() {
        marcasSBem.excluir(marcas);
        listaMarcas.remove(this.marcas);
    }
    
      public String botaoNovo() {
          this.marcas = new Marcas();
        return "cadMarcas?faces-redirect=true";
    }
      
    public String botaoEditar() {
        return "cadCliente?faces-redirect=true";
    }
    
    public String botaoSalvar(){
       marcasSBem.salvar(marcas);
       marcas = new Marcas();
       return "consMarcas?faces-redirect=true";
    }

    public String getValorPesquisar() {
        return Pesquisarmarcas;
    }

    public void setValorPesquisar(String valorPesquisar) {
        this.Pesquisarmarcas = valorPesquisar;
    }

    public Marcas getMarcas() {
        return marcas;
    }

    public void setMarcas(Marcas marcas) {
        this.marcas = marcas;
    }

    public String getPesquisarmarcas() {
        return Pesquisarmarcas;
    }

    public void setPesquisarmarcas(String Pesquisarmarcas) {
        this.Pesquisarmarcas = Pesquisarmarcas;
    }

    public List<Marcas> getListaMarcas() {
        return listaMarcas;
    }

    public void setListaMarcas(List<Marcas> listaMarcas) {
        this.listaMarcas = listaMarcas;
    }

    public MarcasSBean getMarcasSBem() {
        return marcasSBem;
    }

    public void setMarcasSBem(MarcasSBean marcasSBem) {
        this.marcasSBem = marcasSBem;
    }

    

   

    

    
  
    
    
}
