package co.edu.uniquindio.taller_impresora.model;

import java.io.Serializable;

public class Documento implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String titulo;
	private Integer prioridad;
	private String path;

	/**
	 * Constructor de la case <b>Documento</b>
	 */
	public Documento() {

	}

	/**
	 * Constructor de la clase <b>Documento</b>. Permite inicializar los
	 * atributos
	 *
	 * @param titulo
	 * @param prioridad
	 * @param path
	 */
	public Documento(String titulo, Integer prioridad, String path) {
		super();
		this.titulo = titulo;
		this.prioridad = prioridad;
		this.path = path;
	}

	/**
	 * Obtiene el titulo del <b>Documento</b>
	 *
	 * @return
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Establece el titulo del <b>Documento</b>
	 *
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Obtiene la prioridad del <b>Documento</b>
	 *
	 * @return
	 */
	public Integer getPrioridad() {
		return prioridad;
	}

	/**
	 * Establece la prioridad del <b>Documento</b>
	 *
	 * @param prioridad
	 */
	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}

	/**
	 * Obtiene el path del <b>Documento</b>
	 *
	 * @return
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Establece el path del <b>Documento</b>
	 *
	 * @param path
	 */
	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + ((prioridad == null) ? 0 : prioridad.hashCode());
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
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (prioridad == null) {
			if (other.prioridad != null)
				return false;
		} else if (!prioridad.equals(other.prioridad))
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
		return "Nombre: " + titulo + " | Prioridad: " + prioridad + " | Ruta: " + path;
	}

}
