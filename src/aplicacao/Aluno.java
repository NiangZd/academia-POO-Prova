package aplicacao;

public class Aluno {
    private int id;
    private String nome;
    private int idade;
    private Float peso;
    private String email;
    private String senha;

    public Aluno(String nome, int idade, Float peso, String email, String senha) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.email = email;
        this.senha = senha;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
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
    public void setPeso(float peso) {
        this.peso = peso;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

}