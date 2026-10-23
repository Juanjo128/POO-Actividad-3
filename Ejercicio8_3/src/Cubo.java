public class Cubo extends FiguraGeometrica {
    private double lado;
    public Cubo(double lado) {
        this.lado = lado;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen() {
        return Math.pow(lado, 3);
    }

    public double calcularSuperficie() {
        return 6 * Math.pow(lado, 2);
    }

}
