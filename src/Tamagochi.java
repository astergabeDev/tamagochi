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
        System.out.println("Seu Tamagochi");
    }

    public void comerMuito(){
        this.peso += 5;
        dormir();
    }

    public void comerPouco(){
        this.peso += 1;
    }

    public void naoComer(){
        this.peso -= 2;
    }

    //endregion

    //region Sono
    public void sentirSono(){
    //2
    }

    public void dormir(){
        this.idade += 1;
    }

    public void permanecerAcordado(){
        somaSono ++;
    }
    //endregion

    //region Entediado

    public void ficarEntediado (){
    //3
    }

    public void correr (){
        this.peso -= 4;
        comerMuito();
    }

    public void caminhar (){
        this.peso --;
        fome = true;
    }
    //endregion
    public void morrer(){
        morto = true;
    }



}

