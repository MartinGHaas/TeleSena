import java.util.Arrays;

public class TeleSena {
    private final int valor = 10;
    private int[] num1 = new int[25];
    private int[] num2 = new int[25];

    // Construtor
    public TeleSena() {
        montaTeleSena();
    }

    // Métodos de Acesso
    public int getValor() {
        return valor;
    }

    public int[] getNum1() {
        return num1;
    }

    public void setNum1(int[] num1) {
        this.num1 = num1;
    }

    public int[] getNum2() {
        return num2;
    }

    public void setNum2(int[] num2) {
        this.num2 = num2;
    }

    // Monta a Tele Sena
    public boolean montaTeleSena() {
        return montaCartela(num1) && montaCartela(num2);
    }

    // Monta um conjunto de números
    public boolean montaCartela(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int numero = (int) (Math.random() * 60 + 1);

            while(taNaLista(numero, arr)) {
                numero = (int) (Math.random() * 60 + 1);
            }
            arr[i] = numero;
        }
        return arr[24] != 0;
    }

    // Checa se algum número está na lista, retornando um boolean
    public boolean taNaLista(int numCompara, int[] lista) {
        for(int i = 0; i < lista.length; i++) {
            if(numCompara == lista[i]) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "TeleSena{" +
                "num1=" + Arrays.toString(num1) +
                ", num2=" + Arrays.toString(num2) +
                "}\n";
    }
}
