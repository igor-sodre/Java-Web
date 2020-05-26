package beans;

import entidade.Usuario;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import sessionbean.LogarSBean;
import uteis.UteisJsf;


/**
 *
 * @author igor
 */
@Named(value = "loginMBean")
@RequestScoped
public class LoginMBean implements Serializable{
    
    private String userName = "";
    private String senha = "";
    
    
    private Usuario usuario = new Usuario();
    
    @EJB
    private LogarSBean logarSBean;
    
    public LoginMBean() {

    }
    
    public String logar() {
        try {
            this.usuario = logarSBean.logar(this.userName, this.senha);
            if (this.usuario != null) {
                UteisJsf.setObjectSession("usuarioLogado", this.usuario);
                return "home";
            }
            UteisJsf.addMensagemInfo("Usuario ou senha invalidos.", "");
        } catch (Exception ex) {
            UteisJsf.addMensagemInfo(ex.getMessage(), "");
        }
        this.usuario = new Usuario();
        this.userName = "";
        this.senha = "";
        return null;
    }
    
    public String sair() {
        UteisJsf.removeObjectSession("usuarioLogado");        
        return "login";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
