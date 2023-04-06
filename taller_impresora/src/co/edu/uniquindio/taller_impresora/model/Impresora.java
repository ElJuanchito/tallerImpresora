package co.edu.uniquindio.taller_impresora.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Scanner;

import co.edu.uniquindio.taller_impresora.exceptions.ExceptionImpresora;

public class Impresora implements Serializable{
	private EstadoImpresora estado;
	private String nombre;
	private String marca;
	private final TipoImpresa tipo;
	private Integer porcentajeTinta;
	private Documento documentoImprimir;

	/**
	 * Constructor de la clase Impresora
	 *
	 * @param estado
	 * @param nombre
	 * @param marca
	 * @param tipo
	 */
	public Impresora(EstadoImpresora estado, String nombre, String marca, TipoImpresa tipo) {
		this.estado = estado;
		this.nombre = nombre;
		this.marca = marca;
		this.tipo = tipo;
		this.porcentajeTinta = 100;
		this.documentoImprimir = new Documento("vacio", 1, "ruta no existente");
	}

	public EstadoImpresora getEstado() {
		return estado;
	}

	public void setEstado(EstadoImpresora estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getPorcentajeTinta() {
		return porcentajeTinta;
	}

	public void setPorcentajeTinta(Integer porcentajeTinta) {
		this.porcentajeTinta = porcentajeTinta;
	}

	public Documento getDocumentoImprimir() {
		return documentoImprimir;
	}

	public void setDocumentoImprimir(Documento documentoImprimir) {
		this.documentoImprimir = documentoImprimir;
	}

	public TipoImpresa getTipo() {
		return tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((documentoImprimir == null) ? 0 : documentoImprimir.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((porcentajeTinta == null) ? 0 : porcentajeTinta.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Impresora other = (Impresora) obj;
		if (documentoImprimir == null) {
			if (other.documentoImprimir != null)
				return false;
		} else if (!documentoImprimir.equals(other.documentoImprimir))
			return false;
		if (estado != other.estado)
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (porcentajeTinta == null) {
			if (other.porcentajeTinta != null)
				return false;
		} else if (!porcentajeTinta.equals(other.porcentajeTinta))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Impresora [estado=" + estado + ", nombre=" + nombre + ", marca=" + marca + ", tipo=" + tipo
				+ ", porcentajeTinta=" + porcentajeTinta + ", documentoImprimir=" + documentoImprimir + "]";
	}

	private void verificarTinta() throws ExceptionImpresora{
		if(porcentajeTinta == 0) throw new ExceptionImpresora("La impresora ya no tiene tinta");
	}

	private String getTexto() throws FileNotFoundException {
		File file = new File(documentoImprimir.getPath());
		Scanner scan = new Scanner(file);
		String cadena = "";

		while (scan.hasNextLine()) {
			cadena += scan.nextLine();
		} scan.close();
		return cadena;
	}

	public String imprimir() throws FileNotFoundException, ExceptionImpresora {
		verificarTinta();
		if (tipo == TipoImpresa.CARTUCHO)
			porcentajeTinta -= 5;
		else
			porcentajeTinta -= 2;

		return getTexto();
	}

}
