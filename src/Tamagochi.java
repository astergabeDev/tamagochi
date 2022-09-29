import lombok.*;

@Data

public class Tamagochi {

    private String nome;
    private boolean morto = false;

    //idade em dias
    //quando idade = 15 ele morre
    private int idade = 0;

    // Comer pouco + 1 quilo
    // Comer muito 5 quilos && dormir
    // Sem fome e sem sono - 2 quilos
    // 20 quilos ele explode (morre)
    // 0 quilos  desnutrido (morre)
    private boolean fome = false;
    private double peso = 10;

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

    //region Fome
    public void sentirFome(){
    //1
        System.out.println(this.nome + " está com fome...");
        System.out.println("O que deseja fazer?: ");
        System.out.println(" 1 - Comer Muito");
        System.out.println(" 2 - Comer Pouco");
        System.out.println(" 3 - Não Comer");
    }

    public void comerMuito(){
        this.peso += 5;
        System.out.println(this.nome + " está com " + this.peso + "kg");
        System.out.println("Seu tamagochi comeu demais e agora ira dormir...");
        dormir();
    }

    public void comerPouco(){
        this.peso += 1;
        System.out.println("Seu tamagochi come um pouco...");
        System.out.println(this.nome + " está com " + this.peso + "kg");
    }

    public void naoComer(){
        this.peso -= 2;
        System.out.println("Seu tamagochi não comeu...");
        System.out.println(this.nome + " está com " + this.peso + "kg");
    }

    //endregion

    //region Sono
    public void sentirSono(){
    //2
        System.out.println(this.nome + " está com sono...");
        System.out.println("O que deseja fazer?: ");
        System.out.println(" 1 - Dormir");
        System.out.println(" 2 - Permanecer Acordado");
    }

    public void dormir(){
        this.idade += 1;
        System.out.println("Seu tamagochi dormiu...");
        System.out.println(this.nome + " tem " + this.idade + " dias de vida");
    }

    public void permanecerAcordado(){
        somaSono++;
        System.out.println(this.nome + " não dormiu e esta um pouco mais cansado");
    }
    //endregion

    //region Entediado

    public void ficarEntediado (){
    //3
        System.out.println(this.nome + " está com entediado...");
        System.out.println("O que deseja fazer?: ");
        System.out.println(" 1 - Correr 10 minutos");
        System.out.println(" 2 - Caminhar 10 minutos");
    }

    public void correr (){
        this.peso -= 4;
        System.out.println("Seu tamagochi correu e agora precisa comer muito...");
        comerMuito();
    }

    public void caminhar (){
        this.peso--;
        System.out.println("Seu tamagochi");
        System.out.println(this.nome + " está com " + this.peso + "kg");
        fome = true;
    }
    //endregion

    public void morrer(){
        System.out.println(this.nome + " morreu D:");
        morto = true;
    }
}

