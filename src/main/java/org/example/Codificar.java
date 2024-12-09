package org.example;
import java.util.Random;

public class Codificar {
    public static String codificarMensagem(String senha, String mensagem) {
        System.out.println("mensagem: " + mensagem);
        System.out.println("senha: " + senha);

        String[] msg = mensagem.split("");
        String[] pass = senha.split("");
        int[] passCode = new int[mensagem.split("").length];
        Random random = new Random();
        int numeroAleatorio = random.nextInt(33) + 1;

        //System.out.println("numeroAleatorio: " + numeroAleatorio);

        int soma = 0;
        int key = 999;
        for (String letra : pass) {
            int c = (int) letra.charAt(0);  // letra.charAt(0) retorna o caractere, e então convertemos para int
            //System.out.println(letra + " tem valor ASCII: " + c);
            soma += c;
        }
        //System.out.println("soma: " + soma);
        key = soma;
        while(key > 33){
            key = key / numeroAleatorio;
        }
        //System.out.println("key: " + key);
        int i = 0;
        for (String msn : msg) {
            int c = (int) msn.charAt(0);  // letra.charAt(0) retorna o caractere, e então convertemos para int
           // System.out.println(msn + " tem valor ASCII: " + (c - key));
            passCode[i] = (c - key);
            i++;
        }
        /*for(int x = 0; x<passCode.length; x++){
            System.out.println(passCode[x]);
        }*/
        String numFormat;
        if(numeroAleatorio < 10){
            numFormat = "0" + String.valueOf(numeroAleatorio);
        }else numFormat = String.valueOf(numeroAleatorio);
        String mensagemCodificada =  numFormat + convertAsciiToString(passCode);
        //System.out.println("mensagemCodificada: " + mensagemCodificada);
        return mensagemCodificada;
    }
    public static String convertAsciiToString(int[] asciiArray) {
        StringBuilder result = new StringBuilder();
        for (int asciiCode : asciiArray) {
            result.append((char) asciiCode); // Adiciona o caractere correspondente à StringBuilder
        }
        return result.toString(); // Retorna a string resultante
    }
}
