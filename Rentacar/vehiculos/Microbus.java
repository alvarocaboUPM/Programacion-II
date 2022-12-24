package practicas.Rentacar.vehiculos;

public class Microbus extends VehiculoPasajeros {
    static final double PRECIO_POR_PLAZA =  2.0;

    public Microbus(String matricula, int plazas){
        super(matricula, plazas);
    }

    public double precioAlquiler(int dias){
        return super.precioAlquiler(dias)+PRECIO_POR_PLAZA*plazas;
    }

    public String toString(){
        return super.toString(); 
    }
}
