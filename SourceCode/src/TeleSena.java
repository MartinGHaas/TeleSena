import java.util.Arrays;

/*
 nome: Martin Gabriel Haas
 autor: https://github.com/MartinGHaas
 */

public class TeleSena {

    public static final int preco = 10; // Declara o preço da TeleSena

    // Declara variáveis privadas
    private int[] cartela1 = new int[25];
    private int[] cartela2 = new int[25];

    // Construtor
    public TeleSena() {
        compraTeleSena();
    }

    // Métodos de Acesso
    public int[] getCartela1() {
        return cartela1;
    }

    public void setCartela1(int[] cartela1) {
        this.cartela1 = cartela1;
    }

    public int[] getCartela2() {
        return cartela2;
    }

    public void setCartela2(int[] cartela2) {
        this.cartela2 = cartela2;
    }

    // Compra as duas cartelas da TeleSena
    public void compraTeleSena() {
        compraCartela(cartela1);
        compraCartela(cartela2);
    }

    // Cria uma cartela da TeleSena
    public void compraCartela(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int num = (int) (Math.random() * 60 + 1);
            while(repeteNum(arr, num)) {
                num = (int) (Math.random() * 60 + 1);
            }
            arr[i] = num;
        }
    }

    // Checa se um número se repete
    public static boolean repeteNum(int[] arr, int num) {
        for (int arrNum : arr) {
            if (num == arrNum) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "TeleSena{" +
                "cartela1=" + Arrays.toString(cartela1) +
                ", cartela2=" + Arrays.toString(cartela2) +
                '}';
    }
}
