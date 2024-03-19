package ar.edu.unlam.pb1;

import java.util.Arrays;
import java.util.Random;

public class Cumpleaniero {
	private Cumple[] cumples = new Cumple[20];
	public static String nombreCumpleaniero;
	/***
	 * Se deben agregar todos los atributos que se requieran.
	 */
	
	/***
	 * El constructor debe realizar todas las acciones necesarias para garantizar el correcto funcionamiento
	 * @param nombre - Este es el nombre del cumplea�iero
	 */
	public Cumpleaniero(String nombre) {
		this.nombreCumpleaniero = nombre;
	}
	
	/***
	 * Este m�todo agrega un nuevo cumplea�os a la lista de cumplea�os del cumplea�ero. 
	 * @param cuantosCumple Este par�metro identifica un�vocamente al cumplea�os y representa los a�os que cumple.
	 * @param tematica Este par�metro es un string de texto libre que identifica la tem�tica del cumplea�os.
	 * @return true si se  pudo agregar y false en caso contrario.
	 */
	public boolean nuevoCumple(int cuantosCumple, String tematica) {
		Cumple nuevoCumple = new Cumple(cuantosCumple,tematica);
		boolean seEncontro = false;
		int contador = 0;
		while(!seEncontro && contador < cumples.length) {
			if(cumples[contador] != null && cumples[contador].getCuantosCumple() == cuantosCumple && 
					cumples[contador].getTematica().equals(tematica)) {
				seEncontro = true;
			}
			contador++;
		}
		if(!seEncontro) {
			boolean espacioNull = false;
			int contadorNull = 0;
			while(!espacioNull && contadorNull < cumples.length) {
				if(cumples[contadorNull] == null) {
					espacioNull = true;
					cumples[contadorNull] = nuevoCumple;
				}
				contadorNull++;
			}
		}
		
		return !seEncontro;
	}
	
	/***
	 * Agrega un nuevo invitado a un cumplea�os determinado. Es importante recordar que primero se debe generar el c�digo de invitaci�n para asociarlo al nuevo invitado.
	 * @param aQueCumple - Determina a qu� cumplea�os se agrega el nuevo invitado
	 * @param nombre - Es el nombre del invitado
	 * @param esAdulto - Indica si el invitado es adulto o no
	 * @return Devuelve el c�digo de invitaci�n asociado al nuevo invitado. Si no se pudo agregar al invitado al cumplea�os se devuelve -1
	 */
	public int agregarInvitado(int aQueCumple, String nombre, boolean esAdulto) {
		int codigo = calcularCodigoInvitacion();
		Invitado nuevoInvitado = new Invitado(nombre, esAdulto, codigo);
	
		
		boolean seEncontro = false;
		int contador = 0;
		while(!seEncontro && contador < cumples.length) {
			if(cumples[contador] != null && cumples[contador].getCuantosCumple() == aQueCumple) {
				cumples[contador].agregarInvitado(nuevoInvitado);
				
				seEncontro = true;
				
			}
			contador++;
		}
		

		return codigo;
	}
	
	/***
	 * Este algoritmo debe generar un c�digo de invitaci�n aleatorio entre 1 y 1000. El c�digo se puede repetir entre un invitado y otro, pero no se puede anticipar el c�digo generado
	 * @return Devuelve el c�digo de invitaci�n generado.
	 */
	public int calcularCodigoInvitacion() {
		Random random = new Random();
		int codigo = random.nextInt(999) + 1;
		return codigo;
	}

	/***
	 * Este m�todo primero debe buscar al invitado en el cumplea�os al que desea confirmar su asistenica. Si lo encuentra, confirma su asistencia. 
	 * @param cumpleAlQueConfirma Cumplea�os al que un invitado confirma su asistencia.
	 * @param nombre Nombre del invitado que env�a la confirmaci�n
	 * @return Devuelve true para el caso que se haya confirmado la invitaci�n y false en caso contrario
	 */
	public boolean confirmar(int cumpleAlQueConfirma, String nombre) {
		Invitado confirmando = null;
		boolean seConfirmo = false;
		int contador = 0;
		
		while(!seConfirmo && contador < cumples.length) {
			if(cumples[contador] != null && cumples[contador].getCuantosCumple() == cumpleAlQueConfirma) {
				confirmando = cumples[contador].buscar(nombre);
				confirmando.confirmar();
				seConfirmo = true;
				
			}
			contador++;
		}
		
		
		return seConfirmo;
	}
	
	/****
	 * Este m�todo primero debe buscar al invitado en el cumplea�os al que desea asistir. Si lo encuentra, debe verificar que el invitado haya confirmado su asistencia y que el c�digo recibido coincida con el generado al momento de enviar la invitaci�n.
	 * @param cumpleAlQueAsiste - Cumplea�os al que el invitado est� asistiendo
	 * @param nombre - Nombre del invitado
	 * @param codigoAsistencia - C�digo de asistencia con el que el invitado desea ingresar al sal�n.
	 * @return Devuelve true si el invitado puede asistir o false para los siguientes casos:
	 * 	 * Si el invitado no existe en el cumplea�os
	 * 	 * Si el invitado no hab�a confirmado previamente su asistencia
	 *   * Si el c�digo de invitaci�n no concide con el generado inicialmente 
	 */
	public boolean asistir(int cumpleAlQueAsiste, String nombre, int codigoAsistencia) {
		boolean asiste = false;
		Cumple cumple = getCumpleanios(cumpleAlQueAsiste);
		Invitado invitado = cumple.buscar(nombre);
		
		if(invitado != null && invitado.getConfirmo() && invitado.getCodigoInvitacion() == codigoAsistencia) {
			asiste = true;
		}
		
		return asiste;
	}
	
	/****
	 * Devuelve un objeto Cumple asociado al n�mero recibido por par�metro
	 * @param numero N�mero de cumplea�os que se debe retornar
	 * @return El cumplea�os recibido por par�metro
	 */
	public Cumple getCumpleanios(int aQueCumple) {
		Cumple aDevolver = null;
		boolean cualCumple = false;
		int contador = 0;
		while(!cualCumple && contador < cumples.length) {
			if(cumples[contador] != null && cumples[contador].getCuantosCumple() == aQueCumple) {
				cualCumple = true;
				aDevolver = cumples[contador];
			}
			contador++;
		}
		return aDevolver;
	}

	@Override
	public String toString() {
		if (cumples[0] != null) {
			return "Cumpleaniero [ " + cumples[0].getCuantosCumple() + " ]";
		} else {
			return "Sin ingresar";
		}
	}

	/****
	 * El m�todo toString debe devolver informaci�n que nos ayude a conocer el estado del objeto cumplea�ero.
	 */

}
