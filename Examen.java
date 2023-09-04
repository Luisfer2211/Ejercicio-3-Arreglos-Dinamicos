import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Examen {
    private String nombreExamen;
    private ArrayList<Double> resultadosEstudiantes;

    public Examen(String nombreExamen) {
        this.nombreExamen = nombreExamen;
        this.resultadosEstudiantes = new ArrayList<>();
    }

    public void agregarResultadoEstudiante(double resultado) {
        resultadosEstudiantes.add(resultado);
    }

    public double calcularPromedio() {
        double suma = 0;
        for (double resultado : resultadosEstudiantes) {
            suma += resultado;
        }
        return suma / resultadosEstudiantes.size();
    }

    public double calcularMediana() {
        Collections.sort(resultadosEstudiantes);
        int n = resultadosEstudiantes.size();
        if (n % 2 == 0) {
            int medio1 = n / 2 - 1;
            int medio2 = n / 2;
            return (resultadosEstudiantes.get(medio1) + resultadosEstudiantes.get(medio2)) / 2.0;
        } else {
            int medio = n / 2;
            return resultadosEstudiantes.get(medio);
        }
    }

    public double calcularModa() {
        Map<Double, Integer> conteo = new HashMap<>();
        for (double resultado : resultadosEstudiantes) {
            conteo.put(resultado, conteo.getOrDefault(resultado, 0) + 1);
        }

        double moda = 0;
        int maxFrecuencia = 0;

        for (Map.Entry<Double, Integer> entry : conteo.entrySet()) {
            if (entry.getValue() > maxFrecuencia) {
                moda = entry.getKey();
                maxFrecuencia = entry.getValue();
            }
        }

        return moda;
    }

    public double calcularDesviacionEstandar() {
        double promedio = calcularPromedio();
        double sumatoriaCuadrados = 0;

        for (double resultado : resultadosEstudiantes) {
            double diferencia = resultado - promedio;
            sumatoriaCuadrados += Math.pow(diferencia, 2);
        }

        double varianza = sumatoriaCuadrados / resultadosEstudiantes.size();
        return Math.sqrt(varianza);
    }

    public String getNombreExamen() {
        return nombreExamen;
    }

    public ArrayList<Double> obtenerResultadosEstudiantes() {
        return resultadosEstudiantes;
    }
}
