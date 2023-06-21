import java.util.Arrays;

public class ControleTeleSena {
    public final int valorTeleSena = 10;

    private Pessoa[] compradores = new Pessoa[20];

    private int vendas = 0;

    public ControleTeleSena() {
        criaCompradores();
    }

    public Pessoa[] getCompradores() {
        return compradores;
    }

    public void setCompradores(Pessoa[] compradores) {
        this.compradores = compradores;
    }

    public int getVendas() {
        return vendas;
    }

    public void setVendas(int vendas) {
        this.vendas = vendas;
    }

    // Outros Métodos
    public boolean criaCompradores() {
        for(int i = 0; i < compradores.length; i ++) {
            compradores[i] = new Pessoa("Comprador " + (i + 1));
        }
        atualizaVendas();
        return compradores[compradores.length-1] != null;
    }

    public void atualizaVendas() {
        for(int i = 0; i < compradores.length; i++) {
            setVendas(vendas + compradores[i].getQuantidadeTeleSenas());
        }
    }

    public int totalArrecadado() {
        return getVendas() * valorTeleSena;
    }

    public double lucroObtido() {
        return getVendas() * 0.2;
    }

    @Override
    public String toString() {
        return "ControleTeleSena{" +
                "compradores=" + Arrays.toString(compradores) +
                ", vendas=" + vendas +
                '}';
    }
}
