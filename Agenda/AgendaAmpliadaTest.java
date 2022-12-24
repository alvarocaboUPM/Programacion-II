
/**
 * Prueba de AgendaAmpliada<br>
 * @version 1.0     
 * @author Javier Galve
 */
public class AgendaAmpliadaTest
{
  public static String path =".Practica1\\agenda.txt";
  public static String pathToCreate=".Practica1\\agendacreada.txt";
  public static void pruebaLeerAgenda ()
  {
    Agenda agenda = AgendaAmpliada.leer((path));
    System.out.println("agenda = \n" + agenda);
  }
  
  public static void pruebaEscribirAgenda ()
  {
    Agenda agenda = AgendaAmpliada.leer(path);
    AgendaAmpliada.escribir(agenda, pathToCreate);
  }
  
  public static void pruebaOrdenarAgenda ()
  {
    Agenda agenda = AgendaAmpliada.leer(path);
    System.out.println("agenda = \n" + agenda);
    System.out.println("ordenar(agenda);");
    AgendaAmpliada.ordenar(agenda);
    System.out.println("agenda = \n" + agenda);
  }
  
  public static void main (String[] args)
  {
    pruebaLeerAgenda(); //OK
    //
    pruebaEscribirAgenda(); //OK
    //
    pruebaOrdenarAgenda();
    //
    //System.out.println(leerTxt(path)); //OK
  }
}