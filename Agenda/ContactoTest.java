import stdlib.*;
public class ContactoTest {
    static Contacto c1,c2,c3,c4,c5;
    public static void main(String[] args) {
        resetear();
        //set
        Contacto  c1_2;
        c1_2 = new Contacto("Manolo", "6054561", "manolo@gmail.com");
            c1_2.ponerNombre("Pedro"); 
            c1_2.ponerTf("7654321"); 
            c1_2.ponerEmail("manolito@gmail.com");
        //get
        System.out.println("\nEl nombre del 4º Contacto es: " + c1_2.nombre());
        System.out.println("El teléfono del 4º Contacto es: " + c1_2.tf());
        System.out.println("El email del 4º Contacto es: " + c1_2.email());
        //toString
        System.out.println("\n" + c1.toString());
        //linea
        System.out.println("\n" + c1.linea());
        //equals
        System.out.println("\n" + p1(c1, c2));
        System.out.println(p1(c1, c3));
        //clone
        System.out.println("\nLa copia del Contacto 1 es: " + c1.clone());
        //leer
        System.out.println("\n" + Contacto.leer());
    }

    //prueba equals()
    public static boolean p1(Contacto C1, Contacto C2) 
    {
        return C1.equals(C2);
    }
    //reset
    public static void resetear()
    {
        c1 = new Contacto("Manolito", "60511111", "juan@gmail.com");
        c2 = new Contacto("Gumersindo", "222", "juan@gmail.com");
        c3 = new Contacto("Luciano", "333", "Pedro@gmail.com");
        c4 = new Contacto("Ermisinda", "444", "kike@gmail.com");
        c5 = new Contacto("Manolo", "1234567", "Manuel@gmail.com");
    }
    
}

