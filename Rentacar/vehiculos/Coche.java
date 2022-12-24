package practicas.Rentacar.vehiculos;

public class Coche extends VehiculoPasajeros {
    public Coche(String matricula, int plazas) {
        super(matricula, plazas);
    }
    public String toString() {
        return super.toString();
    }
    public double precioAlquiler(int dias){
        return super.precioAlquiler(dias);
    }
}
