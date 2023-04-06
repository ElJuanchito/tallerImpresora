package co.edu.uniquindio.taller_impresora.model;

import java.io.Serializable;

public enum EstadoImpresora implements Serializable{
	ENCENDIDO("ECENDIDO"), APAGADO("APAGADO");

	private final String estado;

    private EstadoImpresora(String estado){
    	this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
}
