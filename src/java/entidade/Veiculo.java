package entidade;


import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import uteis.UnidadeMedida;

/**
 *
 * @author Igor Sodré
 */
@Entity
@Table(name = "Veiculo", schema = "autocar")
@NamedQueries({
    @NamedQuery(
            name = "Veiculo.findByNome",
            query = "SELECT v FROM Veiculo v WHERE v.nome LIKE :nome"
    )
})
public class Veiculo implements Serializable{
   
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "veiculo", length = 50, nullable = false)
    private String veiculo;
    @Column (name = "unidade_medida", length = 2)
    @Enumerated (EnumType.STRING)
    private UnidadeMedida unidadeMedida;
    @Column(name = "ano", length = 4)
    private String Ano;
    @Column(name = "valor", length = 200)
    private String valor;
    @Column(name = "marca", length = 50)
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Veiculo other = (Veiculo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public String getNome() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


 

}