public class Doacao {
    private String tipo;
    private double quantidade;
    private String data;

    public Doacao(String tipo, double quantidade, String data) {
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return tipo + "," + quantidade + "," + data;
    }

}