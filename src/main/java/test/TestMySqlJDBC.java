package test;

import java.sql.*;
import java.util.*;

import datos.*;
import domain.*;

public class TestMySqlJDBC {
	
	public static void main(String[] args) {
		
		testPersonaDao();
		
		testUsuarioDao();
		
		
		
	}
	
	public static void testUsuarioDao() {
		
		Connection conexionUser = null;
		
		try {
			
			
			conexionUser = Conexion.getConnection();
			
			if(conexionUser.getAutoCommit()) {
				conexionUser.setAutoCommit(false);
			}
			
			IUsuarioDao usuarioDao = new UsuarioDAOJDBC(conexionUser);
			
			List<UsuarioDTO> usuarios = usuarioDao.select();
			
			usuarios.forEach( element -> {
				System.out.println("usuario DTO: " +element);
			});
			
			
			conexionUser.commit();
			System.out.println("Se hizo commit de la transaccion");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
			System.out.println("Se entro al rollback, actions were not executed");
			try {
				conexionUser.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace(System.out);
			}
			
		}
		
	}
		
	
	
	public static void testPersonaDao() {
		Connection conexion = null;
		
		
		try {
			conexion = Conexion.getConnection();
			
			if(conexion.getAutoCommit()) {
				conexion.setAutoCommit(false);
			}
			
			IPersonaDao personaDao = new PersonaDAOJDBC(conexion);
			
			List<PersonaDTO> personas = personaDao.select();
			
			personas.forEach( element-> {
				System.out.println("Persona DTO: " +element);
			});
		    
		    //guarda los cambios si todo salio bien
		    conexion.commit();
		    System.out.println("Se ha hecho commit de la transaccion");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
			System.out.println("Entramos al rollback");
			
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace(System.out);
			}
		}
	

	}
	
}
