package es.juliogtrenard.jasperagenda.model;

import java.util.Objects;

/**
 * Clase Teléfono
 */
public class Telefono {
    /**
     * ID de teléfono
     */
    private int id;

    /**
     * Persona del teléfono
     */
    private Persona persona;

    /**
     * telefono
     */
    private String telefono;

    /**
     * Constructor con parámetros de teléfono
     *
     * @param id del teléfono
     * @param persona del teléfono
     * @param telefono teléfono
     */
    public Telefono(int id, Persona persona, String telefono) {
        this.id = id;
        this.persona = persona;
        this.telefono = telefono;
    }

    /**
     * Constructor vacío
     */
    public Telefono() {}

    /**
     * Getter para el id de teléfono
     *
     * @return id de teléfono
     */
    public int getId() {
        return id;
    }

    /**
     * Setter para el id de teléfono
     *
     * @param id nuevo id de teléfono
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter para la persona del teléfono
     *
     * @return persona del teléfono
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Setter para la persona del teléfono
     *
     * @param persona nueva persona del teléfono
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Getter para el teléfono
     *
     * @return teléfono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Setter para el teléfono
     *
     * @param telefono nuevo teléfono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Telefono telefono = (Telefono) o;
        return id == telefono.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
