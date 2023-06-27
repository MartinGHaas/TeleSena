import java.util.Scanner;

/*
 nome: Martin Gabriel Haas
 autor: https://github.com/MartinGHaas
 */

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ControleTeleSena c = new ControleTeleSena();

        System.out.println("\t[MENU]");
        System.out.println("* digite a opção desejada:");
        System.out.println("1 - Modo Rápido");
        System.out.println("2 - Modo Apresentação");
        System.out.println("3 - Ambos");

        for(int tentativas = 0; tentativas < 4; tentativas++) {
            int opcao = scanner.nextInt();

            if(opcao == 1) {
                modoRapido(c);
                break;
            } else if(opcao == 2) {
                modoApresentacao(c);
                break;
            } else if(opcao == 3) {
                modoApresentacao(c);
                System.out.println("\n\n");
                modoRapido(c);
                break;
            } else if(tentativas != 3) {
                System.out.println("Ops! Parece que esta opção não existe! Tente novamente: ");
            }
        }
        scanner.close();
    }

    public static void modoRapido(ControleTeleSena c) {
        System.out.println("\t[NUMEROS SORTEADOS]");

        System.out.print("| ");
        ArrayHelp.imprimeSemDefault(c.getNumerosSorteados());
        System.out.print("|\n\n");

        System.out.println(c.financeiro());

        System.out.println("\n\t[GANHADORES]");
        System.out.println("Quantidade de Ganhadores: " + c.qtdGanhadores());
        ArrayHelp.imprimeSemDefault(c.getGanhadores());
    }

    public static void modoApresentacao(ControleTeleSena c) {
        System.out.println("Sílvio Santos: ");
        typeEffect("SEJAM BEM VINDOS AO ANÚNCIO DA TELE SENA! MÁ OI");

        System.out.println("\nPlatéia: *aplausos*");
        try{
            Thread.sleep(1500);
        }catch(Exception ignored){}

        System.out.println("Sílvio Santos:");
        typeEffect("AGORA! VAMOS ANUNCIAR OS NÚMEROS! MÁ OI\n");
        typeEffect("OS NÚMEROS SÃO:\n");

        for(int i = 0 ; i < c.getNumerosSorteados().length; i++) {
            if(c.getNumerosSorteados()[i] != 0) {
                typeEffect(c.getNumerosSorteados()[i] + " | ");
            }
        }

        System.out.println("\nPlatéia: *aplausos*");
        try{
            Thread.sleep(1500);
        }catch(Exception ignored){}

        System.out.println("Sílvio Santos:");
        typeEffect("E OS GANHADORES FORAM:\n");

        for(int i = 0; i < c.getGanhadores().length; i++) {
            if(c.getGanhadores()[i] != null) {
                typeEffect(c.getGanhadores()[i] + " | ");
            }
        }

        System.out.println("\nPlatéia: *aplausos*");
        try{
            Thread.sleep(1500);
        }catch(Exception ignored){}

        System.out.println("Sílvio Santos:");
        typeEffect("AGORA VAMOS PARA OS DADOS FINANCEIROS! MÁ OI\n");
        typeEffect(c.financeiro());

        System.out.println("\nSílvio Santos:");
        typeEffect("E ANTES DE ACABARMOS! VAMOS FAZER O AVIÃOZINHO DE UM CAFÉ!!!\n");
        typeEffect("TODOS ESTÃO PARTICIPANDO!\n");

        String[] participantes = {"professor", "professor", "professor", "professor", "professor", "professor", "professor", "professor", "professor", "professor"};
        typeEffect("E O GANHADOR FOI: " + participantes[(int) (Math.random() * participantes.length)] + '\n');
        typeEffect("PARABÉNS! OBRIGADO TODOS! MÁ OI");
    }
    public static void typeEffect(String frase) {
        for(int i = 0 ; i < frase.length(); i++) {

            System.out.print(frase.charAt(i));

            try{
                Thread.sleep(100);
            }catch(Exception ignored){}
        }
    }
}
