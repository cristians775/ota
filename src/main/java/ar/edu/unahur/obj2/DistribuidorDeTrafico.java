package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.proveedores.*;

import java.util.Random;

public class DistribuidorDeTrafico {

    private Random random = new Random();

    public Proveedor proveedor() {
        switch (random.nextInt(9)) {
            case 0:
            case 1:
            case 2: return new AmadeusAdapter(new Amadeus());
            case 3:
            case 4:
            case 5: return new SabreAdapter(new Sabre());
            case 6:
            case 7:
            case 8: return new WorldspanAdapter(new Worldspan());
            default: return new AmadeusAdapter(new Amadeus());
        }

    }
}
