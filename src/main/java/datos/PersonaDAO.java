package datos;

import java.util.*;
import java.sql.*;

import domain.*;

public class PersonaDAO {
	
	private static final String SQL_SELECT = "SELECT * FROM test.persona";
	private static final String SQL_INSERT = "INSERT INTO test.persona (nombre, apellido, email, telefono) VALUES (?,?,?,?)";
	
	public List<Persona> seleccionar(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Persona persona = null;
		List<Persona> personas = new ArrayList<>();
		
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				int idPersona = rs.getInt("idpersona");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String email = rs.getString("apellido");
				String telefono = rs.getString("telefono");
				
				persona = new Persona(idPersona, nombre, apellido, email, telefono);
				personas.add(persona);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		}finally {
			try {
				Conexion.close(rs);
				Conexion.close(stmt);
				Conexion.close(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(System.out);
			}
			
		}
		
		return personas;
		
	}
	
	public int insertar(Persona persona) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			stmt =  conn.prepareStatement(SQL_INSERT);
			
			stmt.setString(1, persona.getNombre());
			stmt.setString(2, persona.getApellido());
			stmt.setString(3, persona.getEmail());
			stmt.setString(4, persona.getTelefono());
			
			registros = stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		}finally {
			try {
				Conexion.close(stmt);
				Conexion.close(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(System.out);
			}
		}
		
		return registros;
	}

}
