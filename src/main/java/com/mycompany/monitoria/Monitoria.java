package com.mycompany.monitoria;

public class Monitoria {

    public static void main(String[] args) {
        SessaoCinema sessao = new SessaoCinema("27/04/2023", "15:30", "O Resgate do Programador Ryan",20);

        if(sessao.reservar(new Cliente("111.222.333-44","9090-9090"),1)){
          System.out.println("01 OK");
        } else {
          System.out.println("01 ERRO - reserva deveria ser autorizada");
        }
        if(sessao.reservar(new Cliente("222.333.111-44","8080-8080"),10)){
          System.out.println("02 OK");
        } else {
          System.out.println("02 ERRO - reserva deveria ser autorizada");
        }
        if(sessao.reservar(new Cliente("000.222.333-44","9090-9090"),10)){
          System.out.println("03 ERRO - reserva não deveria ser autorizada - assento ja reservado");
        } else {
          System.out.println("03 OK");
        }
        if(sessao.reservar(new Cliente("222.333.111-44","8080-8080"),15)){
          System.out.println("04 ERRO - reserva não deveria ser autorizada - cpf duplicado");
        } else {
          System.out.println("04 OK");
        }
        if(sessao.reservar(new Cliente("555.222.333-44","7777-9090"),20)){
          System.out.println("05 OK");
        } else {
          System.out.println("05 ERRO - reserva deveria ser autorizada");
        }
        
        sessao.cancelarReserva("222.333.111-44"); // assento 10 liberado
        if(sessao.reservar(new Cliente("555.666.333-44","8888-8888"),10)){
          System.out.println("06 OK");
        } else {
          System.out.println("06 ERRO - reserva deveria ser aceita no assento livre");
        }
        
        String mapa = sessao.getMapaReservas();
        System.out.println("07 Mapa abaixo deve listar assentos reservados nas posicoes:\n" +
                           "1, 10, e 20. Demais assentos devem estar livres.\n"+
                           "Mapa gerado:\n" + mapa);
    }
}