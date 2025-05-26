package model;

public class Quarto {
    private int id;
    private String nome;
    private String numero;
    private double qtd_cama_casal;
    private double qtd_cama_solteiro;
    private double preco;
    private boolean disponivel;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getQtd_cama_casal() {
        return qtd_cama_casal;
    }

    public void setQtd_cama_casal(int qtd_cama_casal) {
        this.qtd_cama_casal = qtd_cama_casal;
    }

    public double getQtd_cama_solteiro() {
        return qtd_cama_solteiro;
    }

    public void setQtd_cama_solteiro(int qtd_cama_solteiro) {
        this.qtd_cama_solteiro = qtd_cama_solteiro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
