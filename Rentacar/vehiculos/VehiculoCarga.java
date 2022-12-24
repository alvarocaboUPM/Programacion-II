package practicas.Rentacar.vehiculos;

public class VehiculoCarga extends Vehiculo {
    static final double PRECIO_POR_TONELADA_DE_PMA= 20;
    protected double pma;

    public VehiculoCarga(String matricula, double pma) {
        super(matricula);
        this.pma=pma;
    }

    public double precioAlquiler(int dias){
        return super.precioAlquiler(dias)+PRECIO_POR_TONELADA_DE_PMA*pma;
    }
    public String toString(){
        return super.toString()+ " PMA: "+ this.pma;
    }
}
