package entidade;

/**
 *
 * @author Igor Sodré
 */
public class Veiculo {
    
    private Long id;
    private String veiculo;
    private String Estado;
    private String Valor;
    private String Ano;
    private String Marca;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String Valor) {
        this.Valor = Valor;
    }

    public String getAno() {
        return Ano;
    }

    public void setAno(String Ano) {
        this.Ano = Ano;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }
    
    
}
