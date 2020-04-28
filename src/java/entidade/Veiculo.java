package entidade;


import uteis.UnidadeMedida;

/**
 *
 * @author Igor Sodré
 */
public class Veiculo {
   
    private Long id;
    private String veiculo;
    private UnidadeMedida unidadeMedida;
    private String Ano;
    private String valor;
    private String marca;

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

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public String getAno() {
        return Ano;
    }

    public void setAno(String Ano) {
        this.Ano = Ano;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String Valor) {
        this.valor = Valor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String Marca) {
        this.marca = Marca;
    }


 

}