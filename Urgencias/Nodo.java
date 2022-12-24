
/**
 * Representa un nodo recursivo para cadenas enlazadas
 * {@code ED = TUPLA(elemento,siguiente) = (E, Nodo<E>)} <br>
 * @since 6/4/2021  
 * @version 1.0
 * @author JMB
 */
class Nodo<E>
{
  E elemento;
  Nodo<E> siguiente;

  Nodo (E elem, Nodo<E> next)
  {
    elemento  = elem;
    siguiente = next;
  }
}

//NOTAS
/**Cada vez que creamos un nodo, se crea un elemento con la forma que hemos definido:
 *  1)Elemento de tipo X
 *  2)El enlance(puntero)
*/
