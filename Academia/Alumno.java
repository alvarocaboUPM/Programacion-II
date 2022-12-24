package Academia;
public class Alumno implements IAlumno{
    private String nombre;
    private String apellido1;
    private String apellido2;
    private double primerParcial;
    private double segundoParcial;

    public Alumno(String name, String apell1, String apell2){
        nombre = name;
        apellido1 = apell1;
        apellido2 = apell2;
        primerParcial = 0.0;
        segundoParcial = 0.0;
    }
    
    public String toString()
    {
        return "("+ nombre +","+apellido1+","+ apellido2+")" + "->"+ "("+ primerParcial +","+segundoParcial + "))";
    }
    public boolean equals (Object otro)
    {
        Alumno a = (Alumno) otro;
        return nombre.equals(a.nombre) &&
                apellido1.equals(a.nombre) &&
                apellido2.equals(a.nombre);
    }
    public String getNombreCompleto() {
        return  apellido1+" "+ apellido2 + "," +nombre;
        
    }
    
    public double getPrimerParcial() {
        
        return primerParcial;
    }
    
    public double getSegundoParcial() {
        
        return segundoParcial;
    }
    
    public void setPrimerParcial(double nota1) {
        primerParcial= nota1;
        
    }
    
    public void setSegundoParcial(double nota2) {
        segundoParcial= nota2;
        
    }
    
    private char sinTildes(char letra){
        switch(letra)
        {
            case 'Á': return 'A';
            case 'É': return 'E';
            case 'Í': return 'I';
            case 'Ó': return 'O';
            case 'Ú': return 'U';
            case 'á': return 'a';
            case 'é': return 'e';
            case 'í': return 'i';
            case 'ó': return 'o';
            case 'ú': return 'u';
            default: return letra;
        }
    }
    
    private String sinTildes(String c){
        String resultado ="";
        for(int i=0; i<c.length();i++)
            resultado =resultado + sinTildes(c.charAt(i));
        return resultado;
    }    

    public String clave() {
        
        return sinTildes(this.getNombreCompleto());
    }
}
