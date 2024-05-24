package datos;

import java.util.*;
import java.sql.*;

import domain.*;

public class PersonaDAO {
	
	private Connection ConexionTransaccional;
	
	private static final String SQL_SELECT = "SELECT * FROM test.persona";
	private static final String SQL_INSERT = "INSERT INTO test.persona (nombre, apellido, email, telefono) VALUES (?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE test.persona SET nombre = ?, apellido = ?, telefono = ? WHERE idpersona = ?";
	private static final String SQL_DELETE = "DELETE FROM test.persona WHERE idpersona = ?";
	
	public PersonaDAO() {}
	
	public PersonaDAO(Connection conexionTransaccional) {
		this.ConexionTransaccional = conexionTransaccional;
	}
	
	public List<Persona> seleccionar() throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Persona persona = null;
		List<Persona> personas = new ArrayList<>();
		
		try {
			conn = this.ConexionTransaccional != null ? this.ConexionTransaccional : Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				int idPersona = rs.getInt("idpersona");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String email = rs.getString("email");
				String telefono = rs.getString("telefono");
				
				persona = new Persona(idPersona, nombre, apellido, email, telefono);
				personas.add(persona);
			}
			
		
		}finally {
			try {
				Conexion.close(rs);
				Conexion.close(stmt);
				if(this.ConexionTransaccional == null)
					Conexion.close(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(System.out);
			}
			
		}
		
		return personas;
		
	}
	
	public int insertar(Persona persona) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registros = 0;
		
		try {
			conn = this.ConexionTransaccional != null ? this.ConexionTransaccional : Conexion.getConnection();
			stmt =  conn.prepareStatement(SQL_INSERT);
			
			stmt.setString(1, persona.getNombre());
			stmt.setString(2, persona.getApellido());
			stmt.setString(3, persona.getEmail());
			stmt.setString(4, persona.getTelefono());
			
			registros = stmt.executeUpdate();
			
		}finally {
			try {
				Conexion.close(stmt);
				if(this.ConexionTransaccional == null)
					Conexion.close(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(System.out);
			}
		}
		
		return registros;
	}
	
	public int actualizar(Persona persona) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int contador = 0;
		
		try {
			conn = this.ConexionTransaccional != null ? this.ConexionTransaccional : Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			
			stmt.setString(1, persona.getNombre());
			stmt.setString(2, persona.getApellido());
			stmt.setString(3, persona.getTelefono());
			stmt.setInt(4, persona.getIdPersona());
			
			contador = stmt.executeUpdate();
			
			
			
		}finally {
			try {
				Conexion.close(stmt);
				if(this.ConexionTransaccional == null)
					Conexion.close(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(System.out);
			}
		}
		
		
		
		return contador;
	}
	
	public int eliminar(Persona persona) throws SQLException {
		  Connection conn = null;
		  PreparedStatement stmt = null;
		  int contador = 0;
		  
		  try {
			conn = this.ConexionTransaccional != null ? this.ConexionTransaccional : Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			
			stmt.setInt(1, persona.getIdPersona());
			
			contador = stmt.executeUpdate();
			
		}finally {
			try {
				Conexion.close(stmt);
				if(this.ConexionTransaccional == null)
					Conexion.close(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(System.out);
			}
		}
		
		  return contador;
	  }
	


}
