import lombok.*;
import java.util.Scanner;

public class Principal {

    static Scanner input = new Scanner(System.in); //cria um scanner

    public static void main(String[] args) {

        cicloDeVida();

    }

    public static void cicloDeVida() {

        System.out.println("Insira o nome do seu tamagochi: ");
        String nomeTamagochi = input.next(); //Salva o input do usuário na variável
        Tamagochi tamagochi = new Tamagochi(nomeTamagochi); //Cria um tamagochi com o nome da variável
        System.out.println("Seu tamagochi nasceu!");

        while (!tamagochi.isMorto()) { //executa o while enquanto o tamagochi está vivo
            //verifica todas as possibilidades de morte do tamagochi
            if (tamagochi.getIdade() == 15 || tamagochi.getPeso() > 20 || tamagochi.getPeso() <= 0) {
                tamagochi.morrer(); //caso alguma seja true, o tamagochi morre
            }
            if(tamagochi.getSomaSono() > 5){
                tamagochi.dormir();
            }

            //O código abaixo (try/catch) adiciona o delay entre cada execução do while para não ficar com spam no console
            //https://www.guj.com.br/t/delay-no-java/97997/4
            tamagochi.delay(2);

            int n = (int)(Math.random()*9);
            switch (n) {
                case 1:
                    tamagochi.sentirFome();
                    break;
                case 2:
                    tamagochi.sentirSono();
                    break;
                case 3:
                    tamagochi.ficarEntediado();
                    break;
                default:
                    System.out.println("...");
                    break;
            }

        }
    }
}