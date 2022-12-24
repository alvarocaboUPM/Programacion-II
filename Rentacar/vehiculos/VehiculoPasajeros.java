package practicas.Rentacar.vehiculos;

public class VehiculoPasajeros extends Vehiculo {
    protected int plazas;
    static final double PRECIO_POR_PLAZA_Y_DIA = 1.5;

    public VehiculoPasajeros(String matricula, int plazas) {
        super(matricula);
        this.plazas = plazas;
    }
    public double precioAlquiler(int dias){
        return super.precioAlquiler(dias)+PRECIO_POR_PLAZA_Y_DIA*(plazas+dias);
    }

    public int plazas(){
        return plazas;
    }

    public String toString(){
        return super.toString()+ ", Numero de plazas: " + plazas;
    }
}
