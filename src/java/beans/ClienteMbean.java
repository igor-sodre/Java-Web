package beans;

import entidade.Cliente;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import sessionbean.ClienteSBean;
import uteis.UnidadeMedida;

/**
 *
 * @author Igor Sodré
 */
@Named(value = "clienteMbean")
@SessionScoped
public class ClienteMbean implements Serializable {
    
    private Cliente cliente;
    private String valorPesquisar;
    private List<Cliente> listaClientes;
    private List<UnidadeMedida> listaUnidadeMedida;

    @EJB
    private ClienteSBean clienteSBem; 
    
    public ClienteMbean() {
        
    }
    @PostConstruct
    public void init (){
        cliente = new Cliente();
        listaClientes = new ArrayList<>();
          
    
    }
    
    
    public void botaoPesquisar(){
       listaClientes = clienteSBem.pesquisar(valorPesquisar);
    }
    
      public void botaoExcluir() {
        clienteSBem.excluir(cliente);
        listaClientes.remove(this.cliente);
    }
    
      public String botaoNovo() {
          this.cliente = new Cliente();
        return "cadCliente?faces-redirect=true";
    }
      
    public String botaoEditar() {
        return "cadCliente?faces-redirect=true";
    }
    
    public String botaoSalvar(){
       clienteSBem.salvar(cliente);
       cliente = new Cliente();
       return "consCliente?faces-redirect=true";
    }

    public String getValorPesquisar() {
        return valorPesquisar;
    }

    public void setValorPesquisar(String valorPesquisar) {
        this.valorPesquisar = valorPesquisar;
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
