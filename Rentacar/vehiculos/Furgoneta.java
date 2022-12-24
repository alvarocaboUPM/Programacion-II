package practicas.Rentacar.vehiculos;

public class Furgoneta extends VehiculoCarga{

    public Furgoneta(String matricula, int pma){
        super(matricula, pma);
    }
    public String toString(){
        return super.toString();
    }
    public double precioAlquiler(int dias){
        return super.precioAlquiler(dias);
    }
}
