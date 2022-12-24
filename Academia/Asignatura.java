package Academia;
import ejercicios_clase.ColGenerica.*;
public class Asignatura implements IAsignatura {
    //Elementos
    private String nombre;
    private ICol<IAlumno> asig;
    private int MAX_TAMAÑO = 20;
    //CONSTRUCTOR
    public Asignatura(String name){
        nombre = name;
        asig = new Col<IAlumno>(MAX_TAMAÑO);

    }
    public boolean esIgual(IAsignatura a) {
        Asignatura otra = (Asignatura) a;
        return nombre.equals(otra.nombre);
    }

    public String toString (){
        return "("+ nombre+ ","+ asig.size()+ ",\n"+ asig +")";
    }
    
    public String getNombre() {
        
        return nombre;
    }

    
    public int size() {
        
        return asig.size();
    }

//BÚSQUEDA ---------------------------------------------------------------
    private class Bus
    {
        boolean esta;
        int pos;
        Bus(boolean si, int aqui)
        {
            esta = si;
            pos= aqui;
        }
    }

    private Bus bucarPos (IAlumno al)
    {
        String claveA1 = al.clave();
        String claveActual;
        int valorComparacion;
        boolean encontrado= false;
        boolean colocado = false;
        int i=0;
        while(i < asig.size() && !encontrado && !colocado)
        {
            claveActual = asig.get(i).clave();
            valorComparacion = claveA1.compareTo(claveActual);
            if (valorComparacion == 0)
              encontrado = true;
            else if (valorComparacion < 0)
              colocado = true;
            else
              i++;
        }
        return new Bus(encontrado,i);
    }

    public IAlumno get(int position) {
        
        return null;
    }

    
    public IAlumno getNotas(IAlumno al) {
        
        return null;
    }

    
    public void matricularAlumno(IAlumno al) {
        
        
    }

    
    public void desmatricularAlumno(IAlumno al) {
        
        
    }

    
    public void calificarAlumno(IAlumno al) {
        
        
    }
    @Override
    public boolean esIgual(Object a) {
        // TODO Auto-generated method stub
        return false;
    }

}
