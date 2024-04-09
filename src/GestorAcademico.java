import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GestorAcademico {

    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;

    private HashMap<Estudiante, Curso> estudiantesInscritos;

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public HashMap<Estudiante, Curso> getEstudiantesInscritos() {
        return estudiantesInscritos;
    }

    public void setEstudiantesInscritos(HashMap<Estudiante, Curso> estudiantesInscritos) {
        this.estudiantesInscritos = estudiantesInscritos;
    }
}
