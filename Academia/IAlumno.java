package Academia;
/**
 * Especificaciñn del TAD Alumno<br>
 * {@code ED = TUPLA(nombre, apellido1, apellido2, 
 *                   primerParcial, segundoParcial) = 
 *                  (cadena,cadena,cadena,real,real}<br>
 * @since 2/4/2018
 * @version 1.0
 * @author JMB
 */

public interface IAlumno
{
 
/**
 * POST: resultado es la cadena de caracteres formada por los
 *       atributos del objeto
 */
public String toString ();

  public boolean equals (Object a);
/**
 * POST: Devuelve el nombre completo del alumno con el 
 *       formato <apellido1 apellido2, nombre>
 */
  public String getNombreCompleto ();
/**
 * POST: resultado es la calificacion del primer parcial del objeto
 */
  public double getPrimerParcial ();
/**
 * POST: resultado es la calificacion del segundo parcial del objeto
 */
  public double getSegundoParcial ();
/**
 * POST: modifica la calificacion del primer parcial del objeto por "nota1"
 */
  public void setPrimerParcial (double nota1);
/**
 * POST: modifica la calificacion del segundo parcial del objeto por "nota2"
 */
  public void setSegundoParcial (double nota2);
/**
 * POST: resultado es la cadena formada por los caracteres del
 *       nombre y los apellidos del objeto, donde se han cambiado
 *       las vocales acentuadas por las equivalentes sin acentuar.
 *       Proporciona una clave para ordenaciones lexicograficas.
 */
  public String clave();
}