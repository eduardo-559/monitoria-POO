package com.mycompany.monitoria;

public class Cliente {
    private String cpf;
    private String telefone;

    public Cliente(String cpf, String telefone) {
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "cpf=" + cpf + ", telefone=" + telefone + '}';
    }
}