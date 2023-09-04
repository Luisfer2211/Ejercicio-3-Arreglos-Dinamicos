import java.util.ArrayList;

public class Estudiante {
    private String nombre;
    private String apellido;
    private String codigoUnico;
    private String fechaNacimiento;
    private String correoElectronico;
    private ArrayList<Double> resultadosExamenes;

    public Estudiante(String nombre, String apellido, String codigoUnico, String fechaNacimiento, String correoElectronico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoUnico = codigoUnico;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
        this.resultadosExamenes = new ArrayList<>();
    }

    public void agregarResultadoExamen(double resultado) {
        resultadosExamenes.add(resultado);
    }

    // Métodos para obtener el nombre y apellido del estudiante
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }


    public ArrayList<Double> obtenerResultadosExamenes() {
        return resultadosExamenes;
    }
}
