import lombok.*;

import java.util.Scanner;

@Data

public class Tamagochi {

    private String nome;
    private boolean IsMorto = false;

    //idade em dias
    //quando idade = 15 ele morre
    private int idade = 0;

    // Comer pouco + 1 quilo
    // Comer muito 5 quilos && dormir
    // Sem fome e sem sono - 2 quilos
    // 20 quilos ele explode (morre)
    // 0 quilos  desnutrido (morre)
    private boolean fome = false;
    private double peso = 1;

    //if sono > 5 = dormir automaticamente
    //sempre que dormir idade++ (+1 dia)
    private boolean sono = false;
    private int somaSono = 0;

    //correr 10min = peso -4kg E comerMuito()
    //caminhar 10min = peso -1kg e fome = true
    private boolean entediado = false;

    public Tamagochi(String nome) {
        this.nome = nome;
    }
    public boolean isMorto() {
        return IsMorto;
    }
    public int getIdade() {
        return idade;
    }
    public void setFome(boolean fome) {
        this.fome = fome;
    }
    public double getPeso() {
        return peso;
    }
    public int getSomaSono() {
        return somaSono;
    }
    public void setMorto(boolean morto) {
        IsMorto = morto;
    }
    static Scanner input = new Scanner(System.in); //cria um scanner

    //region Fome
    public void sentirFome(){
    //1
        System.out.println(this.nome + " está com fome...");
        System.out.println("O que deseja fazer?: ");
        System.out.println(" 1 - Comer Muito");
        System.out.println(" 2 - Comer Pouco");
        System.out.println(" 3 - Não Comer");
        int opcao = input.nextInt();
        switch (opcao){
            case 1:
                comerMuito();
                break;
            case 2:
                comerPouco();
                break;
            case 3:
                naoComer();
                break;
            default:
                System.out.println("insira uma opção válida");
                break;
        }
    }

    public void comerMuito(){
        this.peso += 5;
        if(this.peso <= 20) {
            System.out.println(this.nome + " está com " + this.peso + "kg");
            System.out.println("Seu tamagochi comeu demais, ganhou 5kg e agora ira dormir...");
            dormir();
        }else if(this.peso > 20){
            System.out.println(this.nome + " vai explodirrrrrr");
            System.out.println("BOOOOOOM!!!");
        }
    }

    public void comerPouco(){
        this.peso += 1;
        if(this.peso <= 20) {
            System.out.println("Seu tamagochi come um pouco e ganha 1kg...");
            System.out.println(this.nome + " está com " + this.peso + "kg");
            System.out.println();
        }else if(this.peso > 20){
            System.out.println(this.nome + " vai explodirrrrrr");
            System.out.println("BOOOOOOM!!!");
        }
    }

    public void naoComer(){
        this.peso -= 2;
        if(this.peso > 0) {
            System.out.println("Seu tamagochi não comeu e perdeu 2kg...");
            System.out.println(this.nome + " está com " + this.peso + "kg");
            System.out.println();
        }else if(this.peso <= 0){
            System.out.println(this.nome + " ficou desnutrido");
        }
    }

    //endregion

    //region Sono
    public void sentirSono(){
    //3
        System.out.println(this.nome + " está com sono...");
        System.out.println("O que deseja fazer?: ");
        System.out.println(" 1 - Dormir");
        System.out.println(" 2 - Permanecer Acordado");
        int opcao = input.nextInt();
        switch (opcao){
            case 1:
                dormir();
                break;
            case 2:
                permanecerAcordado();
                break;
            default:
                System.out.println("insira uma opçao valida");
                break;
        }
    }

    public void dormir(){
        this.idade += 1;
        if(this.idade < 15) {
            System.out.println("Seu tamagochi dormiu...");
            System.out.println(this.nome + " tem " + this.idade + " dias de vida");
            System.out.println();
        }
    }

    public void permanecerAcordado(){
        this.somaSono++;
        System.out.println(this.nome + " não dormiu e esta um pouco mais cansado");
        System.out.println();
    }
    //endregion

    //region Entediado

    public void ficarEntediado (){
    //5
        System.out.println(this.nome + " está com entediado...");
        System.out.println("O que deseja fazer?: ");
        System.out.println(" 1 - Correr 10 minutos");
        System.out.println(" 2 - Caminhar 10 minutos");
        int opcao = input.nextInt();
        switch (opcao){
            case 1:
                correr();
                break;
            case 2:
                caminhar();
                break;
            default:
                System.out.println("insira uma opçao valida");
                break;
        }
    }

    public void correr (){
        this.peso -= 4;
        if(this.peso <= 20) {
            System.out.println("Seu tamagochi correu, ele perdeu 4kg e agora precisa comer muito...");
            comerMuito();
        }else if(this.peso <= 0){
            System.out.println(this.nome + " ficou desnutrido");
        }
    }

    public void caminhar (){
        this.peso--;
        if(this.peso <= 20) {
            System.out.println("Seu tamagochi caminhou e perdeu 1kg");
            System.out.println(this.nome + " está com " + this.peso + "kg");
            setFome(true);
            System.out.println();
        }else if(this.peso <= 0){
            System.out.println(this.nome + " ficou desnutrido");
        }
    }
    //endregion

    public void morrer(){
        System.out.println(this.nome + " morreu ; -;");
        setMorto(true);
        System.exit(1);
    }
}

