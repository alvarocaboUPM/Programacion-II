package Academia;
public interface IAsignatura {
    /**
 * POST: resultado es la cadena de caracteres formada por los
 *       atributos del objeto
 */
public String toString ();
/**
* POST: El resultado es cierto si el nombre de "a" es identico al del objeto y falso en caso contrario.
*/
public boolean esIgual (Object a);
/**
* POST: Devuelve el nombre del objeto
*/
public String getNombre ();
/**
* POST: resultado es la cantidad de alumnos matriculados en la asignatura
*/
public int size ();
/**
* POST: resultado es la calificacion del segundo parcial del objeto
*/
public IAlumno get (int position);
/**
* POST: Devuelve el alumno matriculado con el nombre y apellidos "al"
*/
public IAlumno getNotas (IAlumno al);
/**
 * PRE: El alumno "al" no está matriculado en la asignatura
* POST: Matricula al alumno con el nombre "al"
*/
public void matricularAlumno (IAlumno al);
/**
 * PRE: El alumno "al" está matriculado en la asignatura
* POST: Desmatricula al alumno con el nombre "al"
*/
public void desmatricularAlumno (IAlumno al);
/**
* POST: Cambia las notas que tenga "al" por las nuevas
*/
public void calificarAlumno(IAlumno al);
}
