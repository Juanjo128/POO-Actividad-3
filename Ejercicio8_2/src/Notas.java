public class Notas {
    double[] listaNotas;

    public Notas(){
        listaNotas = new double[5];
    }

    double calcularPromedio(){
        double suma = 0;
        for(int i=1; i<listaNotas.length;i++){
            suma = suma + listaNotas[i];
        }
        return (suma/listaNotas.length);
    }

    double calcularDesviacion(){
        double promedio = calcularPromedio();
        double suma = 0;
        for(int i=1; i<listaNotas.length;i++){
            suma = suma + Math.pow((listaNotas[i]-promedio),2);
        }
        return Math.sqrt(suma/listaNotas.length);
    }

    double calcularMenorNota(){
        double menor = listaNotas[0];
        for(int i=1; i<listaNotas.length;i++){
            if(listaNotas[i]<menor){
                menor = listaNotas[i];
            }
        }
        return menor;
    }

    double calcularMayorNota(){
        double mayor = listaNotas[0];
        for(int i=1; i<listaNotas.length;i++){
            if(listaNotas[i]>mayor){
                mayor = listaNotas[i];
            }
        }
        return mayor;
    }
}
