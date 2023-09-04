import java.util.ArrayList;
import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Universidad miUniversidad = new Universidad("Mi Universidad");

        while (true) {
            System.out.println("Bienvenido a " + miUniversidad.getNombreSede());
            System.out.println("1. Agregar Sede");
            System.out.println("2. Mostrar Sedes");
            System.out.println("3. Ver Estadísticas de Examen");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la sede: ");
                    String nombreSede = scanner.nextLine();
                    Sede nuevaSede = new Sede(nombreSede);
                    miUniversidad.agregarSede(nuevaSede);

                    // Menú de opciones para la sede recién creada
                    while (true) {
                        System.out.println("Sede: " + nuevaSede.getNombre());
                        System.out.println("1. Agregar Estudiante");
                        System.out.println("2. Agregar Examen");
                        System.out.println("3. Mostrar Estudiantes");
                        System.out.println("4. Mostrar Exámenes");
                        System.out.println("5. Volver al menú principal");
                        System.out.print("Seleccione una opción: ");

                        int opcionSede = scanner.nextInt();
                        scanner.nextLine(); 

                        switch (opcionSede) {
                            case 1:
                                System.out.print("Ingrese el nombre del estudiante: ");
                                String nombreEstudiante = scanner.nextLine();
                                System.out.print("Ingrese el apellido del estudiante: ");
                                String apellidoEstudiante = scanner.nextLine();
                                System.out.print("Ingrese el código único del estudiante: ");
                                String codigoUnico = scanner.nextLine();
                                System.out.print("Ingrese la fecha de nacimiento del estudiante: ");
                                String fechaNacimiento = scanner.nextLine();
                                System.out.print("Ingrese el correo electrónico del estudiante: ");
                                String correoElectronico = scanner.nextLine();

                                Estudiante nuevoEstudiante = new Estudiante(nombreEstudiante, apellidoEstudiante, codigoUnico, fechaNacimiento, correoElectronico);
                                nuevaSede.agregarEstudiante(nuevoEstudiante);

                                System.out.println("Estudiante agregado con éxito.");
                                break;

                            case 2:
                                System.out.print("Ingrese el nombre del examen: ");
                                String nombreExamen = scanner.nextLine();
                                Examen nuevoExamen = new Examen(nombreExamen);

                                // Solicitar y agregar notas para este examen
                                System.out.print("Ingrese la cantidad de estudiantes que tomaron el examen: ");
                                int cantidadEstudiantes = scanner.nextInt();
                                scanner.nextLine(); 

                                for (int i = 0; i < cantidadEstudiantes; i++) {
                                    System.out.print("Ingrese la nota del estudiante " + (i + 1) + ": ");
                                    double nota = scanner.nextDouble();
                                    scanner.nextLine(); 
                                    nuevoExamen.agregarResultadoEstudiante(nota);
                                }

                                nuevaSede.agregarExamen(nuevoExamen);
                                System.out.println("Examen agregado con éxito.");
                                break;

                            case 3:
                                ArrayList<Estudiante> estudiantes = nuevaSede.obtenerEstudiantes();
                                System.out.println("Lista de Estudiantes:");
                                for (Estudiante estudiante : estudiantes) {
                                    System.out.println("Nombre: " + estudiante.getNombre() + " " + estudiante.getApellido());
                                }    
                                break;

                            case 4:
                                ArrayList<Examen> examenes = nuevaSede.obtenerExamenes();
                                System.out.println("Lista de Exámenes:");
                                for (Examen examen : examenes) {
                                    System.out.println("Nombre del Examen: " + examen.getNombreExamen());
                                }

                            break;

                            case 5:
                                // Volver al menú principal de la sede
                                break;

                            default:
                                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                                break;
                        }

                        if (opcionSede == 5) {
                            break; // Salir del menú de la sede y volver al menú principal
                        }
                    }
                    break;

                case 2:
                    ArrayList<Sede> sedes = miUniversidad.obtenerSedes();
                    System.out.println("Lista de Sedes:");
                    for (Sede sede : sedes) {
                        System.out.println("Nombre de la Sede: " + sede.getNombre());
                    }
                    break;

                case 3:
                    // Código para mostrar estadísticas de un examen
                    mostrarEstadisticasExamen(miUniversidad);
                    break;

                case 4:
                    System.out.println("¡Gracias por usar nuestro programa!");
                    scanner.close();
                    System.exit(0); // Salir del programa
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }

    // Método para mostrar estadísticas de un examen
    public static void mostrarEstadisticasExamen(Universidad universidad) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar el nombre del examen
        System.out.print("Ingrese el nombre del examen para ver estadísticas: ");
        String nombreExamen = scanner.nextLine();

        // Buscar el examen en todas las sedes
        for (Sede sede : universidad.obtenerSedes()) {
            for (Examen examen : sede.obtenerExamenes()) {
                if (examen.getNombreExamen().equalsIgnoreCase(nombreExamen)) {
                    System.out.println("Estadísticas del Examen: " + examen.getNombreExamen());
                    System.out.println("Promedio: " + examen.calcularPromedio());
                    System.out.println("Mediana: " + examen.calcularMediana());
                    System.out.println("Moda: " + examen.calcularModa());
                    System.out.println("Desviación Estándar: " + examen.calcularDesviacionEstandar());
                    return; // Salir del método después de mostrar las estadísticas
                }
            }
        }

        // Si no se encontró el examen
        System.out.println("El examen \"" + nombreExamen + "\" no se encontró en ninguna sede.");
    }
}
