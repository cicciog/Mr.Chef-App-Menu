package entity;

/**
 *
 * @author ciccio
 */
public class PrimoPiatto {
    
    private int id;
    private String nome;
    private String ingredienti;
    private double prezzo;

    public int getId() {
        return id;
    }

    public void setId(int pId) {
        this.id = pId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String pNome) {
        this.nome = pNome;
    }

    public String getIngredienti() {
        return ingredienti;
    }

    public void setIngredienti(String pIngredienti) {
        this.ingredienti = pIngredienti;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double pPrezzo) {
        this.prezzo = pPrezzo;
    }

    @Override
    public String toString() {
        return "PrimoPiatto{" + "id=" + id + ", nome=" + nome + ", ingredienti=" + ingredienti + ", prezzo=" + prezzo + '}';
    }
        
    
}
