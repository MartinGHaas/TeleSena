import java.util.Objects;

/*
 nome: Martin Gabriel Haas
 autor: https://github.com/MartinGHaas
 */

public class ArrayHelp {

    // preencheNoVazio
    public static void preencheNoVazio(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = num;
                break;
            }
        }

    }

    public static void preencheNoVazio(String[] arr, String word) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                arr[i] = word;
                break;
            }
        }
    }

    public static void preencheNoVazio(double[] arr, double num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0.0) {
                arr[i] = num;
                break;
            }
        }
    }

    // taNaLista
    public static boolean taNaLista(int[] arr, int num) {
        for (int numero : arr) {
            if (numero == num) return true;
        }
        return false;
    }

    public static boolean taNaLista(String[] arr, String w) {
        for (int i = 0; i < arr.length; i++) {
            if (Objects.equals(arr[i], w)) {
                return true;
            }
        }
        return false;
    }

    public static boolean taNaLista(double[] arr, double num) {
        for (double numero : arr) {
            if (numero == num) {
                return true;
            }
        }
        return false;
    }

    public static boolean taNaListaIgnoreCase(String[] arr, String w) {
        for (String palavra : arr) {
            if (palavra.equalsIgnoreCase(w)) {
                return true;
            }
        }
        return false;
    }

    // imprimeSemDefault | paia
    public static void imprimeSemDefault(int[] arr) {
        for(int i  = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    public static void imprimeSemDefault(String[] arr) {
        for(int i  = 0; i < arr.length; i++) {
            if(arr[i] != null) {
                System.out.println(arr[i]);
            }
        }
    }
}