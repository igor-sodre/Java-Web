package beans;

import entidade.Veiculo;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import sessionbean.VeiculoSBean;
import uteis.UnidadeMedida;

/**
 *
 * @author Igor Sodré
 */
@Named(value = "veiculoMbean")
@SessionScoped
public class VeiculoMbean implements Serializable {

    private Veiculo veiculo; 
    private String parametroPesquisa;
    private List<Veiculo> listaVeiculos;
    private List<UnidadeMedida> listaUnidadeMedida;   
    
     @EJB
    private VeiculoSBean veiculoSBeanSBem; 
    
    
    public VeiculoMbean() {
    }
    
    @PostConstruct
    public void init(){
        veiculo = new Veiculo();
        listaVeiculos = new ArrayList<>();
        listaUnidadeMedida = Arrays.asList(UnidadeMedida.values());
    }
    
    public void botaopesquisar(){
    
        
    }
    
    public String botaoSalvar(){
        listaVeiculos.add(veiculo);
        veiculo = new Veiculo();
        return "consVeiculo?faces-redirect=true";     
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
    
    
    
  

    
    
    public String getParametroPesquisa() {
        return parametroPesquisa;
    }

    public void setParametroPesquisa(String parametroPesquisa) {
        this.parametroPesquisa = parametroPesquisa;
    }

    public List getListaVeiculos() {
        return listaVeiculos;
    }


    public void setListaVeiculos(List listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public List<UnidadeMedida> getListaUnidadeMedida() {
        return listaUnidadeMedida;
    }

    public void setListaUnidadeMedida(List<UnidadeMedida> listaUnidadeMedida) {
        this.listaUnidadeMedida = listaUnidadeMedida;
    }

    public VeiculoSBean getVeiculoSBeanSBem() {
        return veiculoSBeanSBem;
    }

    public void setVeiculoSBeanSBem(VeiculoSBean veiculoSBeanSBem) {
        this.veiculoSBeanSBem = veiculoSBeanSBem;
    }
      
    
    
}
