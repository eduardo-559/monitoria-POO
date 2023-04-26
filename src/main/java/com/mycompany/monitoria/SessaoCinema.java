package com.mycompany.monitoria;

public class SessaoCinema {
    private String data;
    private String horario;
    private String filme;
    private Cliente[] assentos;

    public SessaoCinema(String data, String horario, String filme, Integer capacidade) {
        this.data = data;
        this.horario = horario;
        this.filme = filme;
        this.assentos = new Cliente[capacidade];
    }
    
    public Boolean reservar(Cliente c, Integer assento) {
        for(Cliente k : this.assentos) {
            if(k != null && k.getCpf() == c.getCpf()) {
                return false;
            }
        }
        
        if(this.assentos[assento - 1] == null) {
            this.assentos[assento - 1] = c;
            return true;
        } else {
            return false;
        }
    }
    
    public void cancelarReserva(String cpf) {
        for(int i = 0; i < this.assentos.length; i++) {
            if(this.assentos[i] != null && this.assentos[i].getCpf() == cpf) {
                this.assentos[i] = null;
            }
        }
    }

    
    public String retornaFilmes() {
        String listaAcentos = "";
        for(int i = 0; i < this.assentos.length; i++) {
            if(this.assentos[i] == null) {
                listaAcentos += ((i + 1) + " livre \n");
            } else {
                listaAcentos += ((i + 1) + " " + this.assentos[i] + "\n");
            }
        }
        return listaAcentos;
    }
    
    public String getMapaReservas() {
        return this.filme + " - " + this.data + " - " + this.horario + "\n" + retornaFilmes();
    }
}