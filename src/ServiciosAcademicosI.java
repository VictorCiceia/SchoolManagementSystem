public interface ServiciosAcademicosI {

    void matricularEstudiante(Estudiante estudiante);

    void agregarCurso(Curso curso);

    void inscribirEstudianteCurso(Estudiante estudiante, Long idCurso) throws EstudianteYaInscritoException;

    void desinscribirEstudianteCurso(long idEstudiante, long idCurso) throws EstudianteNoInscritoEnCursoException;

}
