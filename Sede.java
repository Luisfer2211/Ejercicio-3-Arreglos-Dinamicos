import java.util.ArrayList;

public class Sede {
    private String nombre;
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Examen> examenes;

    public Sede(String nombre) {
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
        this.examenes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void agregarExamen(Examen examen) {
        examenes.add(examen);
    }

    public ArrayList<Estudiante> obtenerEstudiantes() {
        return estudiantes;
    }

    public ArrayList<Examen> obtenerExamenes() {
        return examenes;
    }

    public String getNombre() {
        return nombre;
    }
}
