package domain;

public class Persona {
	
	private int idPersona;
	private String nombre, apellido, email, telefono;
	
	public Persona() {
		
	}
	
	public Persona(int idPersona) {
		this.idPersona = idPersona;
	}
	
	public Persona(String nombre, String apellido, String email, String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}
	
	public Persona (int idPersona, String nombre, String apellido, String email, String telefono) {
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellido =  apellido;
		this.email = email;
		this.telefono = telefono;
	}

	/**
	 * @return the idPersona
	 */
	public int getIdPersona() {
		return idPersona;
	}

	/**
	 * @param idPersona the idPersona to set
	 */
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Persona [idPersona=");
		builder.append(idPersona);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", apellido=");
		builder.append(apellido);
		builder.append(", email=");
		builder.append(email);
		builder.append(", telefono=");
		builder.append(telefono);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
