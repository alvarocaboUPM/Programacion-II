package practicas.Rentacar.vehiculos;

public class Camion extends VehiculoCarga{
    
    public Camion(String matricula, int pma){
        super(matricula, pma);
    }

    public double precioAlquiler(int dias){
        return super.precioAlquiler(dias)+40;
    }

    public String toString(){
        return super.toString();
    }
}
