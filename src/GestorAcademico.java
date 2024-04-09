import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GestorAcademico implements ServiciosAcademicosI{

    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;

    //Curso contiene estudiantes
    private HashMap<Long, List<Long>> estudiantesInscritos;

    public GestorAcademico() {
        this.estudiantes = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.estudiantesInscritos = new HashMap<>();
    }

    @Override
    public void matricularEstudiante(Estudiante estudiante) {
        if (!this.estudiantes.contains(estudiante)) {
            this.estudiantes.add(estudiante);
        }
    }

    @Override
    public void agregarCurso(Curso curso) {
        if (!this.cursos.contains(curso)) {
            this.cursos.add(curso);
            List<Long> estudiantes = new ArrayList<>();
            this.estudiantesInscritos.put(curso.getId(), estudiantes);
        }
    }

    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, Long idCurso) throws EstudianteYaInscritoException {
        if (this.estudiantesInscritos.containsKey(idCurso) && this.estudiantesInscritos.get(idCurso).contains(estudiante.getId())){
            throw new EstudianteYaInscritoException("Ya está inscrito.");
        }
        if(this.estudiantesInscritos.containsKey(idCurso)){
            this.estudiantesInscritos.get(idCurso).add(estudiante.getId());
        }else{
            System.out.println("No existe el curso");
        }
    }

    @Override
    public void desinscribirEstudianteCurso(long idEstudiante, long idCurso) throws EstudianteNoInscritoEnCursoException {
        if (!this.estudiantesInscritos.containsKey(idCurso) || !this.estudiantesInscritos.get(idCurso).contains(idEstudiante)) {
            throw new EstudianteNoInscritoEnCursoException("No está inscrito o el ID del curso no es válido.");
        }
        this.estudiantesInscritos.get(idCurso).remove(idEstudiante);
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public HashMap<Long, List<Long>> getEstudiantesInscritos() {
        return estudiantesInscritos;
    }
}
