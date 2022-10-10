
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

            tamagochi.delay(2);

            int n = (int)(Math.random()*6);
            switch (n) {
                case 1 -> sentirFome(tamagochi);
                case 2 -> sentirSono(tamagochi);
                case 3 -> ficarEntediado(tamagochi);
                default -> System.out.println("...");
            }

        }
    }
    public static void ficarEntediado (Tamagochi tamagochi){
        //5
        System.out.println(tamagochi.getNome() + " está entediado...");
        tamagochi.delay(2);
        System.out.println("O que deseja fazer?: ");
        System.out.println(" 1 - Correr 10 minutos");
        System.out.println(" 2 - Caminhar 10 minutos");
        int opcao = input.nextInt();
        switch (opcao) {
            case 1 -> tamagochi.correr();
            case 2 -> tamagochi.caminhar();
            default -> System.out.println("insira uma opção valida");
        }
    }

    public static void sentirSono(Tamagochi tamagochi){
        //3
        System.out.println(tamagochi.getNome() + " está com sono...");
        tamagochi.delay(2);
        System.out.println("O que deseja fazer?: ");
        System.out.println(" 1 - Dormir");
        System.out.println(" 2 - Permanecer Acordado");
        int opcao = input.nextInt();
        switch (opcao) {
            case 1 -> tamagochi.dormir();
            case 2 -> tamagochi.permanecerAcordado();
            default -> System.out.println("insira uma opçao valida");
        }
    }
    public static void sentirFome(Tamagochi tamagochi){
        //1
        System.out.println(tamagochi.getNome() + " está com fome...");
        tamagochi.delay(2);
        System.out.println("O que deseja fazer?: ");
        System.out.println(" 1 - Comer Muito");
        System.out.println(" 2 - Comer Pouco");
        System.out.println(" 3 - Não Comer");
        int opcao = input.nextInt();
        switch (opcao) {
            case 1 -> tamagochi.comerMuito();
            case 2 -> tamagochi.comerPouco();
            case 3 -> tamagochi.naoComer();
            default -> System.out.println("insira uma opção válida");
        }
    }
}