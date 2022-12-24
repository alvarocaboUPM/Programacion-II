/**
 * Implementacion del TAD GUrgencias<br>
 * {@code ED = TUPLA(ppo,fin)=(Nodo,Nodo)}<br>
 * @since 22/4/2021
 * @version 1.0
 * @author JMB
 */
public class GUrgencias implements IGUrgencias
{

  private Nodo<IPaciente> ppo;   // Indice al primero
  private Nodo<IPaciente> fin;   // Indice al ultimo

  public GUrgencias ()
  {
    ppo = null;
    fin = null;
  }
  public String toString ()
  {
    String resultado = "<";
    Nodo<IPaciente> aux = ppo;
    int contador = 0;
    while (aux != null)
    {
      contador = contador + 1;
      resultado = resultado + aux.elemento;
      if (aux.siguiente != null) resultado = resultado + ",";
      aux = aux.siguiente;
    }  
    resultado = resultado + ">";
    return "(" + contador + "," + resultado + ")";
  }
  public boolean estaVacio ()
  {
    return ppo == null;
  }

  public int size() {
    int size = 0;
    for(Nodo<IPaciente> n = ppo; n.siguiente != null; n = n.siguiente)
        size++;     
    return size;
 }
// TIPO BUSQUEDA ----------------------------------------------------

  private class Par
  {
    Nodo<IPaciente> anterior;
    Nodo<IPaciente> actual;
    
    Par (Nodo<IPaciente> pp1, Nodo<IPaciente> pp2)
    {
      anterior = pp1;
      actual   = pp2;
    }
  }
  /**
   * POST: resultado es el Par(anterior,actual) del elemento de
   *       menor edad del objeto.
   */    
  private Par elDeMenorEdad()
  {
    Nodo<IPaciente> minAnterior = null;
    Nodo<IPaciente> minActual = null;
    int minEdad = 200;
    Nodo<IPaciente> anterior = ppo;
    Nodo<IPaciente> actual = ppo;
    while (actual != null)
    {
      int edadActual = actual.elemento.getEdad();
      if (edadActual < minEdad)
      {
        minAnterior = anterior;
        minActual = actual;
        minEdad = edadActual; 
      }
      anterior = actual;
      actual = actual.siguiente;
    }
    return new Par(minAnterior,minActual);
  }
//----------------------------------------------------------------
//METODO AUXILIAR MAYOR PRIORIDAD

private Par elDeMayorPrio()
{
  Nodo<IPaciente> maxAnterior = null;
  Nodo<IPaciente> maxActual = null;
  int maxPrioridad = 0;
  Nodo<IPaciente> anterior = ppo;
  Nodo<IPaciente> actual = ppo;
  boolean result=false;

  while (actual != null && !result)
  {
    int prioridadActual = actual.elemento.getPrioridad();
    if (prioridadActual >= maxPrioridad)
    {
      maxAnterior = anterior;
      maxActual = actual;
      maxPrioridad = prioridadActual; 
      if(prioridadActual == 3)
      result = true;
    }
    anterior = actual;
    actual = actual.siguiente;
  }
  return new Par(maxAnterior,maxActual);
}
  
//  -----------------------------------------------------------------
  
public IPaciente primero() {
  if (estaVacio())
    throw new RuntimeException("ERROR --> No hay primero de COLA");
  else if(elDeMayorPrio().actual.elemento.getPrioridad()==0) 
    return elDeMenorEdad().actual.elemento;
  else
  return elDeMayorPrio().actual.elemento;
}

/*
private void insertarAUX(IPaciente elem)
{
  Nodo<IPaciente> nuevoNodo= new Nodo(elem,null);
  if(estaVacio())
  {
    ppo=fin=nuevoNodo;
  }
  else                     
    fin.siguiente=nuevoNodo;
    fin= nuevoNodo;
  
}
*/

  public void insertar(IPaciente elem){
    if(estaVacio()){
      ppo = fin= new Nodo<IPaciente>(elem,null);
    }else if(elem.getPrioridad()!=0 && elem.getPrioridad()>ppo.elemento.getPrioridad() ||
      elem.getPrioridad()==0 && elem.getEdad()<ppo.elemento.getEdad())
      ppo= new Nodo<IPaciente>(elem,ppo); 
        else {
          Nodo<IPaciente> aux =ppo; boolean insert;
          for(insert=false; aux!=null && !insert; aux=aux.siguiente)
            if(aux.siguiente == null) {
              aux.siguiente = fin= new Nodo<IPaciente>(elem, null);
              insert= true;
            } 
            else if (elem.getPrioridad()!=0 && elem.getPrioridad()>aux.siguiente.elemento.getPrioridad() ||
            elem.getPrioridad()==0 && elem.getEdad()<aux.siguiente.elemento.getEdad()){
            aux.siguiente = new Nodo<IPaciente>(elem, aux.siguiente);
            insert=true;
        }
      }
  }
  public void borrar (){
    if(!estaVacio()){
      ppo=ppo.siguiente;
    }
  }
}