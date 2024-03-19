package ar.edu.unlam.pb1;

public class Invitado {
	private String nombre;
	private boolean esAdulto;
	private int codigoInvitacion;
    private boolean confirmo;
	/***
	 * Se deben agregar todos los atributos que se requieran.
	 */
	
	/***
	 * El constructor debe realizar todas las acciones necesarias para garantizar el correcto funcionamiento
	 * @param nombre Nombre del invitado
	 * @param esAdulto Si es adulto o no
	 * @param codigoInvitacion C�digo de invitaci�n que permitir� confirmar que el invitado es leg�timo a la hora de asistir al sal�n
	 */
	public Invitado(String nombre, boolean esAdulto, int codigoInvitacion) {
		this.codigoInvitacion = codigoInvitacion;
		this.esAdulto = esAdulto;
		confirmo = false;
		setNombre(nombre);
	}

	/***
	 * Devuelve el nombre del invigtado
	 * @return Nombre del invitado
	 */
	public String getNombre() {
		return this.nombre;
	}

	/***
	 * Actualiza el nombre del invitado
	 * @param nombre El nuevo nombre del invitado
	 */
	public void setNombre(String nombre) {
		this.nombre  = nombre;
	}

	/****
	 * Devuelve si el invitado es un adulto
	 * @return True si es adulto o false en caso contrario
	 */
	public boolean esAdulto() {
		
		return this.esAdulto;
	}

	/***
	 * Actualiza el estado del invitado, confirmando su asistencia.
	 */
	public void confirmar() {
		this.confirmo = true;
	}
	
	/***
	 * Devuelve el estado de confirmaci�n del invitado
	 * @return true si confirmo su asistencia y false en caso contrario
	 */
	public boolean getConfirmo() {
		return this.confirmo;
	}
	
	/***
	 * Actualiza el estado de asistencia de un invitado
	 * @param codigoInvitacion al evento
	 * @return true si se pudo confirmar su asistencia o false en caso contrario (cuando el c�digo de asistencia no coincide con el definido inicialmente)
	 */
	public boolean asistir(int codigoInvitacion) {
		if(this.codigoInvitacion == codigoInvitacion) {
			return true;
		}else {
		return false;
		}
	}

	@Override
	public String toString() {
		return "Invitado [nombre=" + nombre + ", esAdulto=" + esAdulto + ", codigoInvitacion=" + codigoInvitacion
				+ ", confirmo=" + confirmo + "]";
	}

	public int getCodigoInvitacion() {
		return codigoInvitacion;
	}

	public void setCodigoInvitacion(int codigoInvitacion) {
		this.codigoInvitacion = codigoInvitacion;
	}

	/****
	 * El m�todo toString debe devolver informaci�n que nos ayude a conocer el estado del objeto Invitado.
	 */
	
}
