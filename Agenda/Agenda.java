public class Agenda
{
    public ColDeContactos cdc;

    public Agenda()
    {
        cdc = new ColDeContactos();
    }
    public String toString()
    {
        String resultado = ""; String base = "Nombre | Teléfono | Email";
    for (int i = 0; i < cdc.longitud; i++)
      resultado = resultado + cdc.elementos[i] + "\n";
    return base + "\n" + resultado;
    }
    
    public boolean isEmpty()
    {
        boolean resultado=true;
        for (int i = 0; i < cdc.longitud; i++)
        {
            if(cdc.elementos[i]!=null)
                return false;
        }
        return resultado;
    }

    public boolean estaLLena()
    {
        return cdc.longitud==cdc.maxSize();
    }

    public void anhadirContacto(Contacto c1)
    {
        cdc.add(cdc.longitud, c1);
    }

    public int size()
    {
        return cdc.longitud;
    }

    public Contacto get(int pos)
    {
        return cdc.elementos[pos];
    }
    public void set(Contacto c1, int pos)
    {
        cdc.elementos[pos]= c1;
    }

    public String nombresContactos()
    {
        String result="";
        for (int i = 0; i < cdc.longitud; i++)
        {
            result= result + cdc.elementos[i].nombre + "\n";
        }
        return result;
    }

    public Contacto buscarNombre(String name)
    {
        Contacto c1 = null; boolean exists = false;
        for(int i = 0; i < cdc.longitud && !exists; i++)
        {
            if(name == cdc.elementos[i].nombre){
                c1 = get(i);
                exists = true;
            }
        }
        return c1;
    }

    public Contacto buscarTelefono(String telf)
    {
        Contacto c1 = null; boolean exists = false;
        for(int i = 0; i < cdc.longitud && !exists; i++)
        {
            if(telf == cdc.elementos[i].tf)
            {
                c1 = get(i); exists=true;
            }
        }
        return c1;
    }
    //función para checkear si existe el contacto que buscamos
    public boolean exists(Contacto c1)
    {
        boolean exists = false;
        for(int i = 0; i < cdc.longitud && exists; i++)
        {
            if(c1 == cdc.elementos[i])
            {
                 exists=true;
            }
        }
        return exists;
    }
    public void modificarContacto(String name, String telf)
    {
        Contacto c1 = buscarNombre(name);
        if(exists(c1)){
            c1.tf = telf;
        }
    }
    public void quitar(Contacto c1)
    {
        boolean exists=false;
        for(int i = 0; i < cdc.longitud && exists; i++)
        {
            if(c1 == cdc.elementos[i])
            {
                exists = true;
                c1= null;
            }
        }
    }
}