public class Cilindro extends FiguraGeometrica {
    private double radio;
    private double altura;

    public Cilindro(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen() {
        return Math.PI * Math.pow(radio, 2) * altura;
    }

    public double calcularSuperficie() {
        double areaLadoA = Math.PI * Math.pow(radio, 2);
        double areaLadoB = 2 * Math.PI * radio * altura;
        return 2 * areaLadoA + areaLadoB;
    }

}
