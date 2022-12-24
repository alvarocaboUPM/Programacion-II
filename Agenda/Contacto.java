import stdlib.*;

public class Contacto {
    
    public String nombre;
    public String tf;
    public String email;

    //constructor
    Contacto(String nombre, String tf, String email)
    {
        this.nombre = nombre;
        this.tf = tf;
        this.email = email;
    }

    public String toString()
    {
        return new String(nombre + ", " + tf + ", " + email);
    }
    //Funciones tipo get
    public String nombre()
    {
        return nombre;
    }
    public String tf()
    {
        return tf;
    }
    public String email()
    {
        return email;
    }

    //Funciones tipo set
    public void ponerNombre(String nombre) 
    {
        this.nombre = nombre;
    }
    public void ponerTf(String tf) 
    {
        this.tf = tf;
    }
    public void ponerEmail(String email) 
    {
        this.email = email;
    }
    //equals
    public boolean equals(Object obj)
    {
        Contacto c1= (Contacto) obj;
        return this.nombre==c1.nombre && this.email == c1.email && this.tf== c1.tf;
    }
    //clone
    public Contacto clone()
    {  
        return new Contacto(nombre, email, tf);
    }
    //linea
    public String linea()
    {
        return new String(nombre + ";" + tf + ";" + email);
    }
    //leer
    public static Contacto leer()
    {
        Contacto C1 = new Contacto("j", "k", "l");
        System.out.println("Escribe la siguiente información del Contacto: ");
        System.out.println("Nombre del Contacto: ");
        C1.nombre = StdIn.readLine();
        System.out.println("Teléfono del Contacto: ");
        C1.tf = StdIn.readLine();
        System.out.println("Email del Contacto: ");
        C1.email = StdIn.readLine();
    return C1;
    }
}
