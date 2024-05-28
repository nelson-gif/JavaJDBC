package domain;

public class UsuarioDTO {
	
	private int id_usuario;
	private String username;
	private String password;
	
	public UsuarioDTO() {
	}
	
	public UsuarioDTO(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public UsuarioDTO(int id_usuario, String username, String password) {
		super();
		this.id_usuario = id_usuario;
		this.username = username;
		this.password = password;
	}

	public UsuarioDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public int getId_usuario() {
		return id_usuario;
	}
	
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [id_usuario=");
		builder.append(id_usuario);
		builder.append(", username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}
	
	

}
