package practicas.Rentacar.empresa;
import practicas.Rentacar.vehiculos.*;
import tads.*;

/**
 * Empresa de alquiler de vehículos.
 *
 * @author Javier Galve
 */
public class Empresa
{
  private Vehiculos vehiculos;
  private IList<IQueue<Vehiculo>> flota;
  private IQueue<Peticion> peticiones;
  private Vehiculos asignados;
  private IQueue<Peticion> listaDeEspera;


  private static Vehiculos cargaVehiculos (Vehiculo[] vs)
  {
    Vehiculos vehiculos = new Vehiculos();
	  for (int i = 0; i < vs.length; i++)
	    vehiculos.registrarVehiculo(vs[i]);
    return vehiculos;
  }
  private static IQueue<Peticion> cargaPeticiones (Peticion[] ps)
  {
    IQueue<Peticion> peticiones = new Queue<Peticion>();
	  for (int i = 0; i < ps.length; i++)
	    peticiones.push(ps[i]);
    return peticiones;
  }
  /**
   Constructor de la Empresa.
   */
  public Empresa (Vehiculo[] vs, Peticion[] ps)
  {
    vehiculos=cargaVehiculos(vs);
    peticiones=cargaPeticiones(ps);
    flota = new ArrayList<IQueue<Vehiculo>>();
      for(int i= 0;i<4;i++)
        flota.add(i,new Queue<Vehiculo>());
    asignados= new Vehiculos();
    listaDeEspera= new Queue<Peticion>();

  }
    /**-
   Carga la <flota> de vehiculos a partir de <vehiculos>
   (ver enunciado).
   */
  public void cargarFlota (){
    for (int i = 0; i < vehiculos.size(); i++){
     if (vehiculos.get(i) instanceof Coche)
     {
       flota.get(Vehiculo.COCHE).push(vehiculos.get(i));
     }
     else if (vehiculos.get(i) instanceof Microbus)
     {
       flota.get(Vehiculo.MICROBUS).push(vehiculos.get(i));
     }
     else if (vehiculos.get(i) instanceof Furgoneta)
     {
       flota.get(Vehiculo.FURGONETA).push(vehiculos.get(i));
     }
     else 
       flota.get(Vehiculo.CAMION).push(vehiculos.get(i));
     }
    }

  public void alquilarVehiculos ()
  {
    Vehiculos a1 = new Vehiculos();
    IQueue<Peticion> l_e= new Queue<Peticion>();
   
    while(!peticiones.isEmpty()){
      switch(peticiones.peek().codigo()){
        case 0:
        if(flota.get(0).isEmpty()){
          l_e.push(peticiones.peek());
          peticiones.pop();
          break;
          }
        
        a1.registrarVehiculo(flota.get(0).peek());
                flota.get(0).pop();
                peticiones.pop();
                
        break;
        case 1:
        if(flota.get(1).isEmpty()){
          l_e.push(peticiones.peek());
          peticiones.pop(); 
          break;}
        
        a1.registrarVehiculo(flota.get(1).peek());
        flota.get(1).pop();
                peticiones.pop();
               
        break;
        case 2:
        if(flota.get(2).isEmpty()){
          l_e.push(peticiones.peek());
          peticiones.pop(); 
          break;}
          
        a1.registrarVehiculo(flota.get(2).peek());
        flota.get(2).pop();
          peticiones.pop();
               
        break;
        case 3:
        if(flota.get(3).isEmpty()){
          l_e.push(peticiones.peek());
          peticiones.pop(); 
          break;}
        
        a1.registrarVehiculo(flota.get(3).peek());
        flota.get(3).pop();
          peticiones.pop();
             
        break;
      }
    }
  asignados=a1;
  listaDeEspera=l_e;
  }
  /*
   Para implementar mejorCliente podemos utilizar
   la clase interna privada Contador y las operaciones
   posicion y actualizar.
   Contador modela la frecuencia de aparición de 
   un String llamado elemento.
  */
  private class Contador 
  {
    String elemento;
    int frecuencia;             
    Contador (String elemento) 
    {
      this.elemento = elemento;
      frecuencia = 0;
    } 
  }  
 /**
  lf es una lista de frecuencias que cuenta el número de
  apariciones del dni de un cliente.
  POST: 
    resultado tiene la posición que ocupar el dni 
    en la lista de frecuencias lf.
    En caso de no estar en la lista, el resultado 
    es -1.
  */
  private int posicion (String dni, IList<Contador> lf)
  {
    int i = 0;
    boolean esta = false;
    while (i < lf.size() && !esta)
      if (dni.equals(lf.get(i).elemento))
        esta = true;
      else
        i = i + 1;
    return esta? i : -1;
  }
 /**
  Actualiza la lista de frecuencias lf con el dni.
  */
  private void actualizar (String dni, IList<Contador> lf) 
  {
    Contador c =new Contador(dni); c.frecuencia=0;
    if(lf.size()==0||posicion(dni,lf)==-1)
      lf.add(lf.size(), c);
    else
      lf.set(posicion(dni,lf),c);
      c.frecuencia++;
  }
  /*
  PRE:  La lista no está vacía
  POST: Función auxiliar cuyo output
  es el elemento de la lista con mayor
  frecuencia
  */
  private Contador mayorF(IList<Contador> lf){
    Contador c = new Contador("DNI"); int i=0;
    while(i<lf.size()){
        if(c.frecuencia<lf.get(i).frecuencia){
           c=lf.get(i);
           i++;
          }
        else
        i++;
    }
    return c;
  }

  /**
   PRE: !peticiones.isEmpty()
   POST: resultado tiene el DNI del cliente que más peticiones
         de vehículos ha hecho.
   throws RuntimeException si peticiones.isEmpty() 
   (ver enunciado). 
   */
  public String mejorCliente ()
  { 
    IList<Contador> lf = new ArrayList<Contador>();
    if(peticiones.isEmpty())
      throw new RuntimeException("Nadie ha realizado peticiones");
    else
      while(!peticiones.isEmpty()){
        actualizar(peticiones.peek().dni(),lf);
        peticiones.pop();
      }
      return mayorF(lf).elemento;
  }
  /**
   POST: resultado es una cadena de caracteres con todos 
         los datos de la empresa.
   */
  public String toString ()
  {
    String s = new String();
    s += "vehiculos: \n" + vehiculos.toString() + "\n";
    for (int i = Vehiculo.COCHE; i <= Vehiculo.CAMION; i+=1) 
    {
      s += " flota" + i + ": " + flota.get(i).toString() + "\n";
    }
    s += "peticiones: \n" + peticiones.toString() + "\n";
    s += "asignados: \n" + asignados.toString() + "\n";
    s += "listaDeEspera: \n" + listaDeEspera.toString() + "\n";
    return s;
  }
} 
  