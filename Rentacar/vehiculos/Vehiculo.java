package practicas.Rentacar.vehiculos;

public class Vehiculo {
    public static final int COCHE=0, MICROBUS=1, FURGONETA=2, CAMION=3;
    static final double PRECIO_POR_DIA=50.0;
    private String matricula;
    

    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }

    public double precioAlquiler(int dias){
        return dias*PRECIO_POR_DIA;
    }
    public String matricula() {
        return matricula;
    }

    public String toString(){
        return "Vehículo con matrícula: " + this.matricula;
    }
  
}
