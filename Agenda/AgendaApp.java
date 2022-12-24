package Practica1;
import java.util.InputMismatchException;
import stdlib.*;
public class AgendaApp {
    public static void main(String[] args) {
        boolean salir=false;
        int opcion;

        Agenda agenda = new Agenda();
        Contacto c1=new Contacto("a","b","c"); String nombre;
        while(!salir) {
            System.out.println("1: Añadir Contacto"+"\n");
            System.out.println("2: Eliminar Contacto"+"\n");
            System.out.println("3: Buscar Contacto"+"\n");
            System.out.println("4: Mostrar nombres guardados"+"\n");
            System.out.println("5: Modifica Contacto"+"\n");
            System.out.println("6: Cargar agenda desde archivo"+"\n");
            System.out.println("7: Exportar agenda como .txt"+"\n");
            System.out.println("8: Ordenar agenda alfabeticamente"+"\n");
            System.out.println("9: Salir");
            try {
                System.out.println("Selecione la opción que desee utilizar");
                opcion = StdIn.readInt();

                switch(opcion) {
                    case 1: //Crear contacto
                        if(agenda.estaLLena())
                        System.out.println("La agenda está llena");
                        else
                            c1= Contacto.leer();
                            if(agenda.exists(c1))
                            System.out.println("Ya existe el contacto");
                            else
                                agenda.anhadirContacto(c1);
                                System.out.println("Se añadió correctamente");
                    break;

                    case 2: //Eliminar Contacto
                        if(agenda.isEmpty())
                        System.out.println("ERROR: La agenda está vacía");
                        else
                            System.out.println("Escriba el nombre del contacto a eliminar");
                            nombre = StdIn.readLine();
                            c1=agenda.buscarNombre(nombre);
                            if(c1 == null)
                            System.out.println("No existe el contacto");
                            else
                                agenda.cdc.remove(c1);
                                System.out.println("Se eliminó correctamente");
                    break;

                    case 3: //Buscar Contacto
                        if(agenda.isEmpty())
                        System.out.println("ERROR: La agenda está vacía");
                        else
                            System.out.println("Escriba el nombre del contacto a eliminar");
                            nombre = StdIn.readLine();
                            c1=agenda.buscarNombre(nombre);
                            if(c1 == null)
                            System.out.println("No existe el contacto");
                            else
                                System.out.println(c1);
                    break;

                    case 4://Mostrar nombres guardados
                        if(agenda.isEmpty())
                        System.out.println("ERROR: La agenda está vacía");
                        else
                            System.out.println(agenda.nombresContactos());
                    break;

                    case 5://Modificar Contacto
                        if(agenda.isEmpty())
                        System.out.println("ERROR: La agenda está vacía");
                        else
                            System.out.println("Escriba el nombre del contacto a eliminar");
                            nombre = StdIn.readLine();
                            c1=agenda.buscarNombre(nombre);
                            if(c1 == null)
                            System.out.println("No existe el contacto");
                            else
                                agenda.modificar(c1);
                    break;

                    case 6://Carga agenda desde archivo
                        System.out.println("Copie la ruta del archivo");
                        String path= StdIn.readLine();
                        agenda= AgendaAmpliada.leer(path);
                    break;
                    
                    case 7://Exporta agenda a .txt
                        System.out.println("Especifique donde crear el archivo");
                        String pathtocreate= StdIn.readLine();
                        AgendaAmpliada.escribir(agenda, pathtocreate);
                    break;

                    case 8://Ordena alfabeticamente
                        AgendaAmpliada.ordenar(agenda);
                        System.out.println("agenda = \n" + agenda);
                    break;

                    case 9: //Salir
                        salir=true;
                    break;
                    default: 
                    System.out.println("Selecione solo las opciones en pantalla");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
            }
        }
    }
}
