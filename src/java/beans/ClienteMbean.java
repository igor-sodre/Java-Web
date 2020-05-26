package beans;

import converter.CidadeConverter;
import entidade.Cidade;
import entidade.Cliente;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import sessionbean.CidadeSBean;
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
    private List<Cidade> listaCidade;
    private List<Cliente> listaClientes;
    private List<UnidadeMedida> listaUnidadeMedida;

    @EJB
    private ClienteSBean clienteSBem;
    @EJB
    private CidadeSBean cidadeSBean;
    private CidadeConverter cidadeConverter;
    
    public ClienteMbean() {
        
    }
    @PostConstruct
    public void init (){
        cliente = new Cliente();
        listaClientes = new ArrayList<>();
          
    
    }
    
    
    public void botaoPesquisar(){
      try {
            /*
            Ontem na aula não estava mostrando por que não tinha passado o resultado da
            pesquisa para a listaCliente
             */
            this.listaClientes = clienteSBem.pesquisar(valorPesquisar);
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao Pesquisar", ex.getMessage()));
        }
    }
    
    private void carregarListaCidade() {
        this.listaCidade = cidadeSBean.pesquisar("");
        this.cidadeConverter = new CidadeConverter();
        this.cidadeConverter.setCidadeSBean(cidadeSBean);
    }
    
      public void botaoExcluir() throws Exception {
        clienteSBem.excluir(cliente);
        listaClientes.remove(this.cliente);
    }
    
      public String botaoNovo() {
        carregarListaCidade();
        cliente = new Cliente();
        return "cadCliente";
    }
      
    public String botaoEditar() {
        carregarListaCidade();
        return "cadCliente";
    }
    
    public String botaoSalvar(){
   try {
            clienteSBem.salvar(cliente);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Sucesso", "Cliente salvo com sucesso"));
            return "consCliente";
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Erro Salvar", "Error ao salvar cliente. " + ex.getMessage()));
        }
        return null;
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

    public List<Cidade> getListaCidade() {
        return listaCidade;
    }

    public void setListaCidade(List<Cidade> listaCidade) {
        this.listaCidade = listaCidade;
    }

    public ClienteSBean getClienteSBem() {
        return clienteSBem;
    }

    public void setClienteSBem(ClienteSBean clienteSBem) {
        this.clienteSBem = clienteSBem;
    }

    public CidadeSBean getCidadeSBean() {
        return cidadeSBean;
    }

    public void setCidadeSBean(CidadeSBean cidadeSBean) {
        this.cidadeSBean = cidadeSBean;
    }

    public CidadeConverter getCidadeConverter() {
        return cidadeConverter;
    }

    public void setCidadeConverter(CidadeConverter cidadeConverter) {
        this.cidadeConverter = cidadeConverter;
    }

    
  
    
    
}
