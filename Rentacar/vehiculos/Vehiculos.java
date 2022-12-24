package practicas.Rentacar.vehiculos;
import tads.*;
/** 
 * Colecci�n de vehiculos dados de alta en la empresa.
 * 
 * @author Javier Galve
 */

public class Vehiculos extends ArrayList<Vehiculo>
{
  private Vehiculos list =  Vehiculos.this;
  /** 
   * Constructor de Vehiculos.
   */
  public Vehiculos() 
  {
    super();
  }
 /*
 Castea un objeto tipo Vehiculos a un
    array de Vehiculos para poder acceder
    a los elementos.
 */
  private Vehiculo[] createArray(Vehiculos v){
    Vehiculo[] v1= new Vehiculo[v.size()];
    for(int i=0; i<v.size(); i++)
      v1[i]=v.get(i);
    return v1;
  }
   /** 
   Añade un vehículo a la lista, poniéndolo
   al final para respetar el orden de llegada.
   */
  public void registrarVehiculo (Vehiculo v){
    if(list.size()==0)
    list.add(0,v);
    else{
      Vehiculo[] v1= createArray(list);
      for(int i=list.size(); i<0; i--){
        v1[i]=v1[i-1];
        list.set(i, v1[i]);
      }
      list.add(list.size(), v);
      }
  }
  /** 
   * POST: Devuelve el vehiculo con <matricula> o null en caso
   *       de no encontrarlo. 
   */
  public Vehiculo buscaVehiculo(String matricula) 
  {
    Vehiculo[] v1= createArray(list); boolean found=false;
    Vehiculo fin= null;
    if(v1.length==0)
      return null;
    else
      for(int i=0; i<v1.length && !found; i++){
        if(v1[i].matricula().equals(matricula)){
          found=true;
          fin= v1[i];
        }
      }
      return fin;
    }
  /** 
   * PRE: Hay al menos un vehiculo con <matricula> en la lista de veh�culos.
   * POST: resultado es el precio del alquiler del vehiculo con <matricula> y 
           durante un periodo de varios <dias>.
   * throws: RuntimeException en caso que no haya ning�n vehiculo con esta
             matricula en la lista de veh�culos.
   */
  public double precioAlquiler (String matricula, int dias) 
  {
    if(buscaVehiculo(matricula)==null)
      throw new RuntimeException("No hay vehiculos registrados con esta matricula");
    else
      return buscaVehiculo(matricula).precioAlquiler(dias);
  } 
  /**
   POST: resultado es una cadena de caracteres con todos los 
         veh�culos registrados y sus precios en funci�n del numero 
         de <dias>.
   */
  public String mostrarTodosLosPrecios (int dias) 
  {
    String result="";
    for(int i=0;i<super.size();i++){
      result=result + super.get(i) + " Precio: " + super.get(i).precioAlquiler(dias) + "  ";
    }
    return "<" + result + ">";
  }
}
