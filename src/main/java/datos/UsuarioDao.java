package datos;

import java.sql.*;
import java.util.*;

import domain.*;

public class UsuarioDao {
	
	private static final String SQL_SELECT = "SELECT * FROM test.usuario";
	private static final String SQL_INSERT = "INSERT INTO test.usuario (username, password) VALUES (?,?)";
	private static final String SQL_UPDATE = "UPDATE test.usuario SET username = ?, password = ? WHERE idusuario = ?";
	private static final String SQL_DELETE = "DELETE FROM test.usuario WHERE idusuario = ?";
	
	public List<Usuario> seleccionar(){
		
		List<Usuario> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				int id_usuario = rs.getInt("idusuario");
				String username = rs.getString("username");
				String password = rs.getString("password");
				
				Usuario user = new Usuario(id_usuario, username, password);
				list.add(user);
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
		
		
		return list;
	}
	
	public int insertar(Usuario user) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			
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
				e.printStackTrace();
			}
			
		}
		
		
		return registros;
	}
	
	
	public int update(Usuario user) {
		int registros = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setInt(3, user.getId_usuario());
			
			registros = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace(System.out);
			System.out.println("el registro no existe");
		}finally {
			try {
				Conexion.close(stmt);
				Conexion.close(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return registros;
	}
	
	public int eliminar(Usuario user) {
		int registro = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			
			stmt.setInt(1, user.getId_usuario());
			
			registro = stmt.executeUpdate();
			
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
		
		
		return registro;
	}
	

}
