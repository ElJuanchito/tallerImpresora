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
	private Impresora impresoraConectada;
	private List<Documento> listaImpresion;
	private List<Impresora> listaImpresoras;

	public CentroImpresion() {
		listaImpresion = new ArrayList<Documento>();
		listaImpresoras = new ArrayList<Impresora>();
	}

	public CentroImpresion(Impresora impresoraConectada) {
		this.impresoraConectada = impresoraConectada;
		listaImpresion = new ArrayList<Documento>();
		listaImpresoras = new ArrayList<Impresora>();
	}

	public Impresora getImpresoraConectada() {
		return impresoraConectada;
	}

	public void setImpresoraConectada(Impresora impresoraConectada) {
		this.impresoraConectada = impresoraConectada;
	}

	public List<Documento> getListaImpresion() {
		return listaImpresion;
	}

	public void setListaImpresion(List<Documento> listaImpresion) {
		this.listaImpresion = listaImpresion;
	}

	public Impresora buscarImpresora(String nombre) {
		return listaImpresoras.stream().filter(impresora -> impresora.getNombre().equalsIgnoreCase(nombre)).findAny()
				.get();
	}

	public boolean validarImpresora(String nombre) {
		if (buscarImpresora(nombre) != null)
			return true;
		return false;
	}

	public void addImpresora(EstadoImpresora estado, String nombre, String marca, TipoImpresa tipo) throws Exception {
		if (validarImpresora(nombre))
			throw new Exception("La impresora ya existe");
		listaImpresoras.add(new Impresora(estado, nombre, marca, tipo));
	}

	public List<Impresora> getListaImpresoras() {
		return listaImpresoras;
	}

	public void setListaImpresoras(List<Impresora> listaImpresoras) {
		this.listaImpresoras = listaImpresoras;
	}

	private void organizarCola() {
		Collections.sort(listaImpresion, Comparator.comparing(Documento::getPrioridad));
		Collections.reverse(listaImpresion);
	}

	public void addDocumento(String titulo, int prioridad, String path) {
		listaImpresion.add(new Documento(titulo, prioridad, path));
		organizarCola();
	}

	public String imprimirDocumento() throws FileNotFoundException, ExceptionImpresora {
		String retorno = "No existen documentos para impresion";
		//if(listaImpresion.isEmpty()) return retorno;

		impresoraConectada.setDocumentoImprimir(listaImpresion.remove(0));
		return impresoraConectada.imprimir();

	}

}
