package ar.edu.unlam.pb1;

import java.util.Arrays;

public class Cumple {
	private String tematica;
	private int cuantosCumple;
	private Invitado[] invitados = new Invitado[20];
	//private int numeroCumpleanios = 0;
	/***
	 * Se deben agregar todos los atributos que se requieran.
	 */
	
	/****
	 * El constructor debe realizar todas las acciones necesarias para garantizar el correcto funcionamiento
	 * @param cuantosCumple Esto es un valor num�rico que identifica los a�os que se celebran en el presente cumplea�os
	 * @param tematica Esto es una variable de tipo String que denota la tem�tica del cumplea�os. 
	 */
	public Cumple(int cuantosCumple, String tematica) {
		this.tematica = tematica;
		this.cuantosCumple = cuantosCumple;
		//setNumeroCumpleanios(getNumeroCumpleanios() + 1);
	}
	
	/***
	 * Agrega un nuevo invitado a la lista de invitados del cumplea�os
	 * @param nuevo - El invitado a agregar
	 * @return Devuelve true si se pudo agregar al nuevo invitado o false en caso contrario.
	 */
	public boolean agregarInvitado(Invitado nuevoInvitado) {
		boolean espacioNull = false;
		int contadorNull = 0;
		while(!espacioNull && contadorNull < invitados.length) {
			if(invitados[contadorNull] == null) {
				espacioNull = true;
				invitados[contadorNull] = nuevoInvitado;
			}
			contadorNull++;
		}

		return false;
	}

	/***
	 * Este m�todo busca un invitado en la lista de invitados a partir de su nombre.
	 * @param nombre Nombre del invitado a buscar.
	 * @return Devuelve true si encuentra al invitado o false en caso contrario.
	 */
	public Invitado buscar(String nombre) {
		Invitado aDevolver = null;
		boolean encontrado = false;
		int contador = 0;
		while(!encontrado && contador < invitados.length) {
			if(invitados[contador].getNombre().equals(nombre)) {
				aDevolver = invitados[contador];
				encontrado = true;
			}
			contador++;
		}
		return aDevolver;
	}

	/****
	 * El m�todo toString debe devolver informaci�n que nos ayude a conocer el estado del objeto Cumple.
	 */


	public String getTematica() {
		return tematica;
	}

	public void setTematica(String tematica) {
		this.tematica = tematica;
	}

	public int getCuantosCumple() {
		return cuantosCumple;
	}

	public void setCuantosCumple(int cuantosCumple) {
		this.cuantosCumple = cuantosCumple;
	}


	@Override
	public String toString() {
		return "Cumple [tematica=" + tematica + ", cuantosCumple=" + cuantosCumple + "]";
	}
	
	
}
