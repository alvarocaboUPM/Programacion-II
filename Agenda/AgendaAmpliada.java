package practicas.Agenda;

import java.util.*;
import java.io.*;
public class AgendaAmpliada {

    /*
        PRE: Los contactos de la agenda deben haber
        pasado por el método linea() para crear el String con 
        el formato deseado
    */
    public static Agenda leer(String archivo) 
    {
        Agenda a1 = new Agenda(); 
        ArrayList<String> create= new ArrayList<String>();
        //PRIMERA PARTE: LEER EL .TXT Y GUARDARLO EN STRING
        try{
        String texto = "";
        BufferedReader bf = new BufferedReader(new FileReader(archivo));

        while((texto = bf.readLine()) != null){ 
            create.add(texto); 
        }
        bf.close();
        }
            //FileNotFound error
        catch(Exception e)
        { 
            System.err.println("Archivo no encontrado");
        }
        
        //SEGUNDA PARTE: Crear la agenda
        String separado;
        String[]preAgenda; 
            for(int i=0; i<create.size(); i++)
                {
                    separado =create.get(i);
                    preAgenda=separado.split(";");
                    a1.anhadirContacto(new Contacto(preAgenda[0],preAgenda[1],preAgenda[2]));
                }
        return a1;
    }
    public static void escribir(Agenda a1,String archivo)
    {
        FileWriter fichero = null;
        PrintWriter pw = null; 
        String[] preString; String fin=""; String separado="";
        ArrayList<String> create= new ArrayList<String>();
        try
        {
            fichero = new FileWriter(archivo, true);
            pw = new PrintWriter(fichero);
            
            for(int j=0; j< a1.cdc.longitud;j++){
                create.add(a1.cdc.elementos[j].toString());}
            for (int i = 0; i < a1.cdc.longitud; i++)
            {
                String convert="";
                separado =create.get(i);
                preString = separado.split(",");
                for(int j=0; j< preString.length; j++)
                {
                convert= convert + preString[j].toString()+ ";";
                }
                fin= fin + convert;
            }
                pw.println(fin);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           //cierre de fichero
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }

    public static Agenda ordenar(Agenda agenda)
    {
        String[] nombres=new String[agenda.cdc.longitud];
        for(int i=0; i< agenda.cdc.longitud;i++){
            nombres[i]=agenda.cdc.elementos[i].nombre;
        }
        Agenda agendaAux= new Agenda();
        String[] nombresOrden=new String[nombres.length];
        for(int i=0; i< nombres.length;i++)
        {
            nombresOrden[i]=nombres[i];
        } 
        Arrays.sort(nombresOrden);
       
        for(int i=0; i< nombres.length;i++)
        {
            for(int j=0; j<nombres.length;j++){
                agendaAux.anhadirContacto(agenda.buscarNombre(nombresOrden[j]));
            }
            agenda.quitar(agenda.buscarNombre(nombres[i]));
            agenda.set(agendaAux.cdc.elementos[i], i);          
        }
        return agenda;
    }

}

