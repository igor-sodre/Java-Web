package beans;

import entidade.Cliente;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import uteis.UnidadeMedida;

/**
 *
 * @author Igor Sodré
 */
@Named(value = "clienteMbean")
@SessionScoped
public class ClienteMbean implements Serializable {
    
    private Cliente cliente;
    private String pesquisacliente;
    private List<Cliente> listaClientes;
    private List<UnidadeMedida> listaUnidadeMedida;

    
   
    
    public ClienteMbean() {
        
    }
    @PostConstruct
    public void init (){
        cliente = new Cliente();
        listaClientes = new ArrayList<>();
        listaUnidadeMedida = Arrays.asList(UnidadeMedida.values());
        
    
    }
    
    
    public void botaopesquisar(){
    }
    
    public String botaoSalvar(){
       listaClientes.add(cliente);
       cliente = new Cliente();
       return "consCriente?faces-redirect=true";
    }

    public String getPesquisacliente() {
        return pesquisacliente;
    }

    public void setPesquisacliente(String pesquisacliente) {
        this.pesquisacliente = pesquisacliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<UnidadeMedida> getListaUnidadeMedida() {
        return listaUnidadeMedida;
    }

    public void setListaUnidadeMedida(List<UnidadeMedida> listaUnidadeMedida) {
        this.listaUnidadeMedida = listaUnidadeMedida;
    }

    
  
    
    
}
