import java.util.Arrays;

public class Pessoa {
    private int quantidadeTeleSenas = (int) (Math.random() * 15 + 1);
    private String nome;
    private TeleSena[] telesenas = new TeleSena[quantidadeTeleSenas];
    private double premiacao;

    // Construtor
    public Pessoa(String nome) {
        this.nome = nome;
        this.compraTeleSenas();
    }

    // Métodos de acesso
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TeleSena[] getTelesenas() {
        return telesenas;
    }

    public void setTelesenas(TeleSena[] telesenas) {
        this.telesenas = telesenas;
    }

    public double getPremiacao() {
        return premiacao;
    }

    public void setPremiacao(double premiacao) {
        this.premiacao = premiacao;
    }

    public int getQuantidadeTeleSenas() {
        return quantidadeTeleSenas;
    }

    public void setQuantidadeTeleSenas(int quantidadeTeleSenas) {
        this.quantidadeTeleSenas = quantidadeTeleSenas;
    }

    // Outros Métodos
    public int valorGasto() {
        return telesenas.length*10;
    }

    public boolean compraTeleSenas() {
        for(int i =0; i < telesenas.length; i++) {
            telesenas[i] = new TeleSena();
        }

        return telesenas[telesenas.length - 1] != null;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", telesenas=" + Arrays.toString(telesenas) +
                ", premiacao=" + premiacao +
                ", TeleSenas Compradas=" + quantidadeTeleSenas +
                '}';
    }
}
