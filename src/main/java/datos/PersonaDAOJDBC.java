package datos;

import java.util.*;
import java.sql.*;

import domain.*;

public class PersonaDAOJDBC implements IPersonaDao{
	
	private Connection ConexionTransaccional;
	
	private static final String SQL_SELECT = "SELECT * FROM test.persona";
	private static final String SQL_INSERT = "INSERT INTO test.persona (nombre, apellido, email, telefono) VALUES (?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE test.persona SET nombre = ?, apellido = ?, telefono = ? WHERE idpersona = ?";
	private static final String SQL_DELETE = "DELETE FROM test.persona WHERE idpersona = ?";
	
	public PersonaDAOJDBC() {}
	
	public PersonaDAOJDBC(Connection conexionTransaccional) {
		this.ConexionTransaccional = conexionTransaccional;
	}
	
	public List<PersonaDTO> select() throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		PersonaDTO personaDTO = null;
		List<PersonaDTO> personaDTOs = new ArrayList<>();
		
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
				
				personaDTO = new PersonaDTO(idPersona, nombre, apellido, email, telefono);
				personaDTOs.add(personaDTO);
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
		
		return personaDTOs;
		
	}
	
	public int insert(PersonaDTO personaDTO) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registros = 0;
		
		try {
			conn = this.ConexionTransaccional != null ? this.ConexionTransaccional : Conexion.getConnection();
			stmt =  conn.prepareStatement(SQL_INSERT);
			
			stmt.setString(1, personaDTO.getNombre());
			stmt.setString(2, personaDTO.getApellido());
			stmt.setString(3, personaDTO.getEmail());
			stmt.setString(4, personaDTO.getTelefono());
			
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
	
	public int update(PersonaDTO personaDTO) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int contador = 0;
		
		try {
			conn = this.ConexionTransaccional != null ? this.ConexionTransaccional : Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			
			stmt.setString(1, personaDTO.getNombre());
			stmt.setString(2, personaDTO.getApellido());
			stmt.setString(3, personaDTO.getTelefono());
			stmt.setInt(4, personaDTO.getIdPersona());
			
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
	
	public int delete(PersonaDTO personaDTO) throws SQLException {
		  Connection conn = null;
		  PreparedStatement stmt = null;
		  int contador = 0;
		  
		  try {
			conn = this.ConexionTransaccional != null ? this.ConexionTransaccional : Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			
			stmt.setInt(1, personaDTO.getIdPersona());
			
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
