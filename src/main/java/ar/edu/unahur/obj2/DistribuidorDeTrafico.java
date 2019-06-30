package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.proveedores.*;

import java.util.List;
import java.util.Random;

public class DistribuidorDeTrafico {


    private List<Proveedor> proveedores;

    public DistribuidorDeTrafico(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }
    public void setProveedor(Proveedor proveedor){

        proveedores.add(proveedor);

    }

    public Proveedor proveedor() {

            return proveedores.get(new Random().nextInt(proveedores.size()));
        }
}
