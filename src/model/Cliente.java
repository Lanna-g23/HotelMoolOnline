package model;

import java.util.List;

public class Cliente extends Pessoa {
    private String id;
    private String cpf, telefone;

    public Cliente(String nome, String email, String cpf, String telefone) {
        super(nome, email);
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public Cliente(String nome, String Email) {
        super(nome, Email);
    }

    public int calcularOcupacoes(List<Reserva> reservas) {
        return reservas.size();
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
