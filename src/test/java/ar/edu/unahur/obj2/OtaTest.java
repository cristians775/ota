package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.proveedores.*;
import org.joda.time.DateTime;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.*;

public class OtaTest {


    private Vuelo vSabre;
    private Vuelo vAmadeus;
    private Vuelo vWorldspan;
    private SabreAdapter sabreAdap;
    private AmadeusAdapter amadeusAdap;
    private WorldspanAdapter worldspanAdap;
    private Amadeus amadeus;
    private Sabre sabre;
    private Worldspan worldspan;
    private DistribuidorDeTrafico distribuidorDeTrafico;
    private Ota ota;
    private Proveedor proveedor;
    private List<Proveedor> proveedores;
    private List<Proveedor> provSabre;
    private List<Proveedor> provAmadeus;
    private List<Proveedor> provrWorldspan;

    @BeforeMethod
    public void setUp() {

        sabre = new Sabre();
        amadeus = new Amadeus();
        worldspan = new Worldspan();
        sabreAdap= new SabreAdapter(sabre);
        amadeusAdap = new AmadeusAdapter(amadeus);
        worldspanAdap = new WorldspanAdapter(worldspan);
        provAmadeus = Stream.of(amadeusAdap).collect(Collectors.toList());
        provrWorldspan = Stream.of(worldspanAdap).collect(Collectors.toList());
        proveedores = Stream.of(sabreAdap, worldspanAdap, amadeusAdap).collect(Collectors.toList());
        provSabre = Stream.of(sabreAdap).collect(Collectors.toList());




    }

    @org.testng.annotations.Test



    public void testBuscarVuelos() {

        DistribuidorDeTrafico distribuidorDeTrafico = new DistribuidorDeTrafico(provAmadeus);
        Ota ota = new Ota(distribuidorDeTrafico);

        DateTime fecha = new DateTime("2019-12-13");


        List<Vuelo> vuelos = ota.buscarVuelos(fecha, "BUE", "MIA");


    }

    @org.testng.annotations.Test
    public void testReservar() {

        DistribuidorDeTrafico distribuidorDeTrafico = new DistribuidorDeTrafico(provrWorldspan);
        Ota ota = new Ota(distribuidorDeTrafico);
        DateTime fecha = new DateTime("2019-12-13");
        List<Vuelo> vuelos = ota.buscarVuelos(fecha, "BUE", "MIA");
        Vuelo elegido =  vuelos.get(0);
        Set<Pasajero> pasajeros = Stream.of(new Pasajero("Juan", "Pérez", 40)).collect(Collectors.toSet());
        Boleto boleto = ota.reservar(elegido, pasajeros );
        assertEquals(boleto.getVuelo(), elegido);



    }


    @org.testng.annotations.Test
    public void reservarAmadeus() {
        DistribuidorDeTrafico distribuidorDeTrafico = new DistribuidorDeTrafico(provAmadeus);
        ota=new Ota(distribuidorDeTrafico);
        DateTime fecha = new DateTime("2019-12-13");
        List<Vuelo> vuelos = ota.buscarVuelos(fecha, "BUE", "MIA");
        Vuelo vuelo=  vuelos.get(0);
        Set<Pasajero> pasajeros = Stream.of(new Pasajero("Fernando", "Lara", 30))
                .collect(Collectors.toSet());
        Boleto boleto = ota.reservar(vuelo, pasajeros );
        vAmadeus = new Vuelo(fecha,"BUE", "MIA", "AA1000",10,"Sabre");


        assertEquals( boleto.getVuelo(), new Boleto(vAmadeus,pasajeros).getVuelo());
    }
    @org.testng.annotations.Test
    public void reservarSabre() {
        DistribuidorDeTrafico distribuidorDeTrafico = new DistribuidorDeTrafico( provSabre);
        Ota ota = new Ota(distribuidorDeTrafico);
        DateTime fecha = new DateTime("2019-12-13");
        List<Vuelo> vuelos = ota.buscarVuelos(fecha, "BUE", "MIA");
        Vuelo vuelo =  vuelos.get(0);
        Set<Pasajero> pasajeros = Stream.of(new Pasajero("Fernando", "Freire", 40))
                .collect(Collectors.toSet());
        Boleto boleto = ota.reservar(vuelo, pasajeros );
        vSabre = new Vuelo(fecha,"BUE", "MIA", "AA1000",7,"Sabre");




        assertEquals( boleto.getVuelo(), new Boleto(vSabre,pasajeros).getVuelo());
    }

    @org.testng.annotations.Test
    public void reservarWorldspan() {
        DistribuidorDeTrafico distribuidorDeTrafico = new DistribuidorDeTrafico(provrWorldspan);
        Ota ota = new Ota(distribuidorDeTrafico);
        DateTime fecha = new DateTime("2019-12-13");
        List<Vuelo> vuelos = ota.buscarVuelos(fecha, "BUE", "MIA");
        Vuelo vuelo =  vuelos.get(0);
        Set<Pasajero> pasajeros = Stream.of(new Pasajero("Juan", "Pérez", 40))
                .collect(Collectors.toSet());
        Boleto boleto = ota.reservar(vuelo, pasajeros );
        vWorldspan = new Vuelo(fecha,"BUE", "MIA", "AA1000",10,"Sabre");
        assertEquals( boleto.getVuelo(), new Boleto(vWorldspan,pasajeros).getVuelo());
    }



    @org.testng.annotations.Test
    public void buscarSabre() {
        DistribuidorDeTrafico distribuidorDeTrafico = new DistribuidorDeTrafico( provSabre);
        Ota ota = new Ota(distribuidorDeTrafico);
        DateTime fecha = new DateTime("2019-12-13");
        List<Vuelo> vOta = ota.buscarVuelos(fecha, "BUE", "MIA");
        Assert.assertEquals(vOta, sabre.buscar(fecha, "BUE","MIA"));
    }


    public void buscarWorldspan() {
        DistribuidorDeTrafico distribuidorDeTrafico = new DistribuidorDeTrafico(provrWorldspan);
        Ota ota = new Ota(distribuidorDeTrafico);
        DateTime fecha = new DateTime("2019-12-13");
        List<Vuelo> vOta = ota.buscarVuelos(fecha, "BUE", "MIA");


        Assert.assertEquals(vOta, worldspan.searchFlights(11,10,2019, "BUE", "MIA"));

    }

    @org.testng.annotations.Test
    public void buscarAmadeus() {
        DistribuidorDeTrafico distribuidorDeTrafico = new DistribuidorDeTrafico(provAmadeus);
        Ota ota = new Ota(distribuidorDeTrafico);
        DateTime fecha = new DateTime("2019-12-13");
        List<Vuelo> vOta = ota.buscarVuelos(fecha, "BUE", "MIA");



        Assert.assertEquals(vOta, amadeus.executeSearch(fecha, "BUE", "MIA"));

    }


}
