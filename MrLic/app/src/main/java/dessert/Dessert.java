package dessert;

/**
 * Created by fgual on 06/09/2017.
 */

public class Dessert {

    private int id;
    private String nome;
    private String ingrediednti;
    private double prezzo;

    public Dessert(int pId, String pNome, String pIngrediednti, double pPrezzo) {
        this.id = pId;
        this.nome = pNome;
        this.ingrediednti = pIngrediednti;
        this.prezzo = pPrezzo;
    }

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

    public String getIngrediednti() {
        return ingrediednti;
    }

    public void setIngrediednti(String pIngrediednti) {
        this.ingrediednti = pIngrediednti;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double pPrezzo) {
        this.prezzo = pPrezzo;
    }

    @Override
    public String toString() {
        return "Dessert{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", ingrediednti='" + ingrediednti + '\'' +
                ", prezzo=" + prezzo +
                '}';
    }
}
