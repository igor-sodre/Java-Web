package beans;

import entidade.Veiculo;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Igor Sodré
 */
@Named(value = "veiculoMbean")
@SessionScoped
public class VeiculoMbean implements Serializable {

    private Veiculo veiculo; 
    private String parametroPesquisa;
    
    private List ListaVeiculos = new ArrayList<>();
    
    public VeiculoMbean() {
    }
    
    public void botaopesquisar(){
    
        
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
        return ListaVeiculos;
    }

    public void setListaVeiculos(List ListaVeiculos) {
        this.ListaVeiculos = ListaVeiculos;
    }
    
    
    
}
