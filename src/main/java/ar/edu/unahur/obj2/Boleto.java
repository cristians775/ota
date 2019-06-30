package ar.edu.unahur.obj2;


import java.util.Objects;
import java.util.Set;

public class Boleto {

    private final Vuelo vuelo;
    private final Set<Pasajero> pasajeros;

    public Boleto(Vuelo vuelo, Set<Pasajero> pasajeros) {
        this.vuelo = vuelo;
        this.pasajeros = pasajeros;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public Set<Pasajero> getPasajeros() {
        return pasajeros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boleto boleto = (Boleto) o;
        return vuelo.equals(boleto.vuelo) &&
                pasajeros.equals(boleto.pasajeros);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vuelo, pasajeros);
    }

    @Override
    public String toString() {
        return "Boleto{" +
                "vuelo=" + vuelo +
                ", pasajeros=" + pasajeros +
                '}';
    }
}
