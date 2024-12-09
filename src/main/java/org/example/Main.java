package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Codificar cod = new Codificar();
        Decodificar decode = new Decodificar();
        String mensagem;
        String senha;
        String codMnsg;
        int op = 0;

        System.out.println("======================== = BEM VINDO = ========================");
        while(op != 3){
            System.out.println("----- Qual opção você deseja? - Digite apenas o número -----");
            System.out.println("| 1. Codificar mensagem.                                   |");
            System.out.println("| 2. Decodificar mensagem.                                 |");
            System.out.println("| 3. SAIR.                                                 |");
            System.out.println("------------------------------------------------------------");
            op = read.nextInt();
            read.nextLine();
            switch(op){
                case 1:
                    System.out.println("Digite a mensagem a ser codificada: ");
                    mensagem = read.nextLine();
                    if(!mensagem.isEmpty()){
                        System.out.println("Digite a senha - SEM ESPAÇOS: ");
                        senha    = read.nextLine();
                        if(!senha.isEmpty()){
                            codMnsg = cod.codificarMensagem(senha, mensagem);
                            System.out.println("**********************************************");
                            System.out.println("Mensagem codificada: " + codMnsg);
                            System.out.println("**********************************************");
                        }else {
                            System.out.println("### ERROR - SENHA VAZIA ###");
                        }
                    }else {
                        System.out.println("### ERROR - MENSAGEM VAZIA ###");
                    }

                    break;
                case 2:
                    System.out.println("Digite a mensagem a ser decodificada: ");
                    mensagem = read.nextLine();
                    if(!mensagem.isEmpty()){
                        System.out.println("Digite a senha - SEM ESPAÇOS: ");
                        senha    = read.nextLine();
                        if(!senha.isEmpty()){
                            String decodMnsg = decode.decodificarMensagem(senha, mensagem);
                            System.out.println("**********************************************");
                            System.out.println("Mensagem Decodificada: " + decodMnsg);
                            System.out.println("**********************************************");
                        }else {
                            System.out.println("### ERROR - SENHA VAZIA ###");
                        }
                    }else {
                        System.out.println("### ERROR - MENSAGEM VAZIA ###");
                    }
                    break;
                case 3:
                    System.out.println("SAINDO");;
                    break;
            }
        }
        System.out.println("ENCERRANDO");;

    }
}