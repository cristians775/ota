package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.proveedores.Proveedor;
import org.joda.time.DateTime;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Ota {

    private DistribuidorDeTrafico distribuidorDeTrafico;

    public Ota(DistribuidorDeTrafico distribuidorDeTrafico) {
        this.distribuidorDeTrafico = distribuidorDeTrafico;
    }

    public List<Vuelo> buscarVuelos(DateTime fecha, String origen, String destino) {
        Proveedor codigoProveedor = distribuidorDeTrafico.proveedor();

        return codigoProveedor.buscarVuelo(fecha,origen,destino);
    }

    public Boleto reservar(Vuelo vuelo, Set<Pasajero> pasajeros) {
        Proveedor codigoProveedor = distribuidorDeTrafico.proveedor();

        return codigoProveedor.comprar(vuelo,pasajeros);
    }


}
