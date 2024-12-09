package org.example;
public class Decodificar {
    public static String decodificarMensagem(String senha, String mensagemCodificada) {
        //System.out.println("mensagem: " + mensagemCodificada);
        //System.out.println("senha: " + senha);

        String[] msg = mensagemCodificada.split("");
        String[] pass = senha.split("");
        int[] passCode = new int[mensagemCodificada.split("").length];

        int num = Integer.parseInt(mensagemCodificada.split("")[0] + mensagemCodificada.split("")[1]);
        //System.out.println("num: " + num);
        int soma = 0;
        int key = 999;
        for (String letra : pass) {
            int c = (int) letra.charAt(0);  // letra.charAt(0) retorna o caractere, e então convertemos para int
            //System.out.println(letra + " tem valor ASCII: " + c);
            soma += c;
        }
        key = soma;
        while(key > 33){
            key = key / num;
        }
        int i = 0;
        for (String msn : msg) {
            int c = (int) msn.charAt(0);
            // System.out.println(msn + " tem valor ASCII: " + (c - key));
            passCode[i] = (c + key);
            i++;
        }
        return convertAsciiToString(passCode).substring(2);
    }

    public static String convertAsciiToString(int[] asciiArray) {
        StringBuilder result = new StringBuilder();
        for (int asciiCode : asciiArray) {
            result.append((char) asciiCode); // Adiciona o caractere correspondente à StringBuilder
        }
        return result.toString(); // Retorna a string resultante
    }
}
