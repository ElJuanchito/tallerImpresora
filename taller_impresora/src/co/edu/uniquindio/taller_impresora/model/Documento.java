package co.edu.uniquindio.taller_impresora.model;

import java.io.Serializable;

public class Documento implements Serializable{
	private String titulo;
	private Integer prioridad;
	private String path;
	private EstadoDocumento estado;

	public Documento(){

	}

	public Documento(String titulo, Integer prioridad, String path) {
		super();
		this.titulo = titulo;
		this.prioridad = prioridad;
		this.path = path;
		this.estado = EstadoDocumento.CREADO;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public EstadoDocumento getEstado() {
		return estado;
	}

	public void setEstado(EstadoDocumento estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((prioridad == null) ? 0 : prioridad.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Documento other = (Documento) obj;
		if (estado != other.estado)
			return false;
		if (prioridad == null) {
			if (other.prioridad != null)
				return false;
		} else if (!prioridad.equals(other.prioridad))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Documento [titulo=" + titulo + ", prioridad=" + prioridad + ", texto=" + path + ", estado=" + estado
				+ "]";
	}





}
