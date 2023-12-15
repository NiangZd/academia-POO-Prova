package aplicacao;

public class Instrutor extends Usuario{

    public Instrutor(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    @Override
    public String toString() {
        return "Instrutor []";
    }
    
}
