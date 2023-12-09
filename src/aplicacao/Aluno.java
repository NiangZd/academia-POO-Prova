package aplicacao;

public class Aluno extends Usuario{
    private int idade;
    private Float peso;

    public Aluno(String nome, int idade, float peso, String email, String senha) {
        super(nome, email, senha);
        this.idade = idade;
        this.peso = peso;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public Float getPeso() {
        return peso;
    }
    public void setPeso(Float peso) {
        this.peso = peso;
    }

}