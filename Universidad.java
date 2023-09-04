import java.util.ArrayList;

public class Universidad {
    private String nombreSede;
    private ArrayList<Sede> sedes;

    public Universidad(String nombreSede) {
        this.nombreSede = nombreSede;
        this.sedes = new ArrayList<>();
    }

    public void agregarSede(Sede sede) {
        sedes.add(sede);
    }

    public ArrayList<Sede> obtenerSedes() {
        return sedes;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public static void main(String[] args) {
        Universidad miUniversidad = new Universidad("Mi Universidad");

        Sede sede1 = new Sede("Sede 1");
        Sede sede2 = new Sede("Sede 2");

        miUniversidad.agregarSede(sede1);
        miUniversidad.agregarSede(sede2);

        ArrayList<Sede> sedes = miUniversidad.obtenerSedes();
        for (Sede sede : sedes) {
            System.out.println("Nombre de la Sede: " + sede.getNombre());
        }
    }
}
