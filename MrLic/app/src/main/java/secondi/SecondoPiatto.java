package secondi;

/**
 * Created by f on 06/09/2017.
 */

public class SecondoPiatto {

    private int id;
    private String nome;
    private String ingredienti;
    private double prezzo;

    public SecondoPiatto(int pId, String pNome, String pIngredienti, double pPrezzo) {
        this.id = pId;
        this.nome = pNome;
        this.ingredienti = pIngredienti;
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
        return "SecondoPiatto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", ingredienti='" + ingredienti + '\'' +
                ", prezzo=" + prezzo +
                '}';
    }

}
