package fogueteNaoDaRe;

import java.util.Scanner;

public class elevador{

    Scanner in = new Scanner(System.in);

    int andares = 0;
    int passageiros = 0;
    int escolha = 0 ;

    public int andar; //andar atual do elevador
    public int totalAndar; //total de andares
    public int capacidade; //capacidade de tranporte
    public int pessoas; // pessoas a  bordo do elevador

    public void Escolha()
    {

        System.out.println("O elevador est� no " + this.andar + "�");
        System.out.println("O elevador tem " + this.pessoas + " a bordo");

        System.out.print("Voc� quer subir ou descer ?, 0 para descer e 1 para subir: ");
        escolha = in.nextInt();

        while( escolha > 1 || escolha < 0  ){

            System.out.println("N�mero incorreto");

            System.out.print("Voc� quer subir ou descer ?, 0 para descer e 1 para subir: ");
            escolha = in.nextInt();
        }

        switch(escolha){

            case 0:
                Descer();
                break;

            case 1:
                Subir();
                break;
        }

    }

    //m�todo de entrada de passageiros
    public void Entrar()
    {
        System.out.print("Quantos passageiros entraram ? ");
        passageiros = in.nextInt();
        System.out.println("Entrando " + passageiros + " pessoas.");
        this.pessoas = this.pessoas + passageiros;

        if(this.pessoas > this.capacidade ){

            System.out.println("Elevador lotado !!");
            System.out.println( (this.pessoas - this.capacidade) + " Pessoas v�o ficar do lado de fora ");
            this.pessoas = this.capacidade;

        }else{

            System.out.println("Elevador est� com " + this.pessoas + " a bordo.");

        }

    }

    //m�todo de sa�da de passageiros
    public void Sair()
    {

        System.out.print("Quantos passageiros sairam ? ");
        passageiros = in.nextInt();
        this.pessoas = this.pessoas - passageiros;

        if(this.pessoas == 0){

            System.out.println("Elevador vazio !!!");

        }else{

            System.out.println("Elevador est� com " + this.pessoas + " a bordo.");
        }



    }

    //m�todo subir
    public void Subir()
    {
        System.out.print("Vai subir at� qual andar ? ");
        andares = in.nextInt();

        this.andar = this.andar + (andares - this.andar);

        if( this.andar >= this.totalAndar){

            this.andar = this.totalAndar;
            System.out.println("Estamos no �ltimo andar, " + this.andar + "�" );

        }else{

            System.out.println("Subindo at� o " + this.andar);

        }

        //loop
        Sair();
        Entrar();
        Escolha();


    }

    //m�todo descer
    public void Descer()
    {

        System.out.print("Vai descer at� qual andar ? ");
        andares = in.nextInt();

        while( andares >= this.andar ){
            System.out.print("Andar inv�lido, Vai descer at� qual andar ? ");
            andares = in.nextInt();
        }

        this.andar = (andares + this.andar) - this.andar ;

        if( this.andar <= 0 ){

            System.out.println("Descendo at� o t�rreo");
            this.andar = 0;

        }else{
            System.out.println("Descendo at� " + this.andar + "�");
        }

        //loop
        Sair();
        Entrar();
        Escolha();

    }



    public static void main(String[] args) {

        //estanciamento de classe

        elevador shopping = new elevador();
        shopping.andar = 4;
        shopping.totalAndar = 10;
        shopping.capacidade = 15;
        shopping.pessoas = 9;


        shopping.Escolha();

    }

}