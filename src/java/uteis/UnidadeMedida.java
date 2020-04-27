 package uteis;

/**
 *
 * @author Igor Sodré
 */
public enum UnidadeMedida {
    GO("GO"),
    MT("MT"),
    SP("SP"),
    RJ("RJ");
    private String unidadeMedida;

    private UnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }
    
    public String getUnidadeMedida(){
        return this.unidadeMedida; 
    } 
}
