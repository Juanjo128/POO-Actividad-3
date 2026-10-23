public class Prisma extends FiguraGeometrica {
    private double base;
    private double altura;
    private double profundidad;

    public Prisma(double base, double altura, double profundidad) {
        this.base = base;
        this.altura = altura;
        this.profundidad = profundidad;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen() {
        return base * altura * profundidad;
    }

    public double calcularSuperficie() {
        double areaLadoA = base * altura;
        double areaLadoB = base * profundidad;
        double areaLadoC = altura * profundidad;
        return 2 * (areaLadoA + areaLadoB + areaLadoC);
    }

}
