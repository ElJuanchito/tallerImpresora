package co.edu.uniquindio.taller_impresora.model;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import co.edu.uniquindio.taller_impresora.exceptions.ExceptionImpresora;

public class CentroImpresion implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *
	 */
	private Impresora impresoraConectada;
	private List<Documento> listaImpresion;
	private List<Impresora> listaImpresoras;

	/**
	 * Constructor de la clase <b>CentroImpresion</b>
	 */
	public CentroImpresion() {
		listaImpresion = new ArrayList<Documento>();
		listaImpresoras = new ArrayList<Impresora>();
	}

	/**
	 * Constructor de la clase <b>CentroImpresion</b> donde se inicializa la
	 * <b>impresoraConectada</b>
	 *
	 * @param impresoraConectada
	 */
	public CentroImpresion(Impresora impresoraConectada) {
		this.impresoraConectada = impresoraConectada;
		listaImpresion = new ArrayList<Documento>();
		listaImpresoras = new ArrayList<Impresora>();
	}

	/**
	 * Obtiene la <b>impresoraConectada</b>
	 *
	 * @return <b>impresoraConectada</b>
	 */
	public Impresora getImpresoraConectada() {
		return impresoraConectada;
	}

	/**
	 * Establece la <b>impresoraConectada</b>
	 *
	 * @param impresoraConectada
	 */
	public void setImpresoraConectada(Impresora impresoraConectada) {
		this.impresoraConectada = impresoraConectada;
	}

	/**
	 * Obtiene la <b>lista de impresion</b>
	 *
	 * @return
	 */
	public List<Documento> getListaImpresion() {
		return listaImpresion;
	}

	/**
	 * Establece la <b>Lista de impresion</b>
	 *
	 * @param listaImpresion
	 */
	public void setListaImpresion(List<Documento> listaImpresion) {
		this.listaImpresion = listaImpresion;
	}

	/**
	 * Obtiene la <b>lista de Impresoras</b>
	 *
	 * @return
	 */
	public List<Impresora> getListaImpresoras() {
		return listaImpresoras;
	}

	/**
	 * Establece la <b>lista de Impresoras</b>
	 *
	 * @param listaImpresoras
	 */
	public void setListaImpresoras(List<Impresora> listaImpresoras) {
		this.listaImpresoras = listaImpresoras;
	}

	@Override
	public String toString() {
		return "CentroImpresion [impresoraConectada=" + impresoraConectada + ", listaImpresion=" + listaImpresion
				+ ", listaImpresoras=" + listaImpresoras + "]";
	}

	/**
	 * Busca una <b>impresora</b> con base a su nombre
	 *
	 * @param nombre
	 * @return
	 */
	public Impresora buscarImpresora(String nombre) {
		return listaImpresoras.stream().filter(impresora -> impresora.getNombre().equalsIgnoreCase(nombre)).findAny()
				.get();
	}

	/**
	 * Valida si una <b>Impresora</b> existe
	 *
	 * @param nombre
	 * @return
	 */
	private boolean validarImpresora(String nombre) {
		if (buscarImpresora(nombre) != null)
			return true;
		return false;
	}

	/**
	 * Agrega una <b>Impresora</b> a la <b>lista de Impresoras</b>
	 *
	 * @param estado
	 * @param nombre
	 * @param marca
	 * @param tipo
	 * @throws Exception
	 */
	public void addImpresora(EstadoImpresora estado, String nombre, String marca, TipoImpresa tipo) throws Exception {
		if (validarImpresora(nombre))
			throw new Exception("La impresora ya existe");
		listaImpresoras.add(new Impresora(estado, nombre, marca, tipo));
	}

	/**
	 * Organiza la <b>cola de Impresora</b>
	 */
	private void organizarCola() {
		Collections.sort(listaImpresion, Comparator.comparing(Documento::getPrioridad));
		Collections.reverse(listaImpresion);
	}

	/**
	 * Agrega un <b>Documento</b> a la <b>lista de Impresion</b>
	 *
	 * @param titulo
	 * @param prioridad
	 * @param path
	 */
	public void addDocumento(String titulo, int prioridad, String path) {
		listaImpresion.add(new Documento(titulo, prioridad, path));
		organizarCola();
	}

	/**
	 * Imprime un <b>Documento</b> desde la <b>impresora conectada</b>
	 *
	 * @return
	 * @throws FileNotFoundException
	 * @throws ExceptionImpresora
	 */
	public String imprimirDocumento() throws FileNotFoundException, ExceptionImpresora {
		if (!off()) {
			impresoraConectada.setDocumentoImprimir(listaImpresion.remove(0));
			return impresoraConectada.imprimir();
		}
		return null;
	}

	/**
	 * Enciende la <b>impresora conectada<b>
	 */
	public void encenderImpresora() {
		impresoraConectada.encender();
	}

	/**
	 * Apaga la<b> impresora conectada</b>
	 */
	public void apagarImpresora() {
		impresoraConectada.apagar();
	}

	/**
	 * verifica si la <b>impresora conectada</b> esta apagada
	 *
	 * @return
	 */
	public boolean off() {
		System.out.println(impresoraConectada.getNombre() + " " + impresoraConectada.getEstado());
		return impresoraConectada.getEstado() == EstadoImpresora.APAGADO;

	}

}
