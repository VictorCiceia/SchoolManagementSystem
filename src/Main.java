import java.util.Date;

public class Main {
    public static void main(String[] args) {

         Estudiante estudiante1 = new Estudiante(1, "Juan", "Perez", new Date(), "matriculado");
         Estudiante estudiante2 = new Estudiante(2, "Maria", "Rojas", new Date(), "matriculado");

         Curso curso1 = new Curso(1, "Fisica", "La Materia", 2, 3);
         Curso curso2 = new Curso(2, "Quimica", "Super Materia", 4, 2);

         GestorAcademico gestorAcademico = new GestorAcademico();



         // Solo debe matricular a 2 estudiantes
        System.out.println("\n\n------------------------------------------------------------------------------------");
         gestorAcademico.matricularEstudiante(estudiante1);
         gestorAcademico.matricularEstudiante(estudiante1);
         gestorAcademico.matricularEstudiante(estudiante2);
         System.out.println("Estudiantes matriculados: " + gestorAcademico.getEstudiantes().size());

         // Solo debe crear dos cursos
        System.out.println("\n\n------------------------------------------------------------------------------------");
        gestorAcademico.agregarCurso(curso1);
        gestorAcademico.agregarCurso(curso1);
        gestorAcademico.agregarCurso(curso2);
        System.out.println("Cursos: " + gestorAcademico.getCursos().size());

        // Debe inscribir
        System.out.println("\n\n------------------------------------------------------------------------------------");
        try{
            System.out.println("Debe inscribir a " + estudiante1.getNombre() + " en " + curso1.getNombre());
            gestorAcademico.inscribirEstudianteCurso(estudiante1, curso1.getId());
            System.out.println(estudiante1.getNombre() + " inscripto de " + curso1.getNombre() );
        } catch (EstudianteYaInscritoException e) {
            System.out.println(e);
        }

        // No debe inscribir
        System.out.println("\n\n------------------------------------------------------------------------------------");
        try{
            System.out.println("No debe inscribir a " + estudiante1.getNombre() + " en " + curso1.getNombre());
            gestorAcademico.inscribirEstudianteCurso(estudiante1, curso1.getId());
            System.out.println(estudiante1.getNombre() + " inscripto de " + curso1.getNombre() );
        } catch (EstudianteYaInscritoException e) {
            System.out.println(e);
        }

        System.out.println("\n\n------------------------------------------------------------------------------------");
        try{
            System.out.println("Debe desinscribir a " + estudiante1.getNombre() + " en " + curso1.getNombre());
            gestorAcademico.desinscribirEstudianteCurso(estudiante1.getId(), curso1.getId());
            System.out.println(estudiante1.getNombre() + " desinscripto de " + curso1.getNombre() );
        } catch (EstudianteNoInscritoEnCursoException e) {
            System.out.println(e);
        }

        System.out.println("\n\n------------------------------------------------------------------------------------");
        try{
            System.out.println("No debe desinscribir a " + estudiante1.getNombre() + " en " + curso1.getNombre());
            gestorAcademico.desinscribirEstudianteCurso(estudiante1.getId(), curso1.getId());
            System.out.println(estudiante1.getNombre() + " desinscripto de " + curso1.getNombre() );
        } catch (EstudianteNoInscritoEnCursoException e) {
            System.out.println(e);
        }

    }
}