package test;

import java.sql.*;

import datos.*;
import domain.*;

public class TestMySqlJDBC {
	
	public static void main(String[] args) {
		
		//testPersonaDao();
		
		testUsuarioDao();
		
		
		
	}
	
	public static void testUsuarioDao() {
		
		Connection conexionUser = null;
		
		try {
			
			
			conexionUser = Conexion.getConnection();
			
			if(conexionUser.getAutoCommit()) {
				conexionUser.setAutoCommit(false);
			}
			
			UsuarioDao objUser = new UsuarioDao(conexionUser);
			
			Usuario delete1 = new Usuario();
			delete1.setId_usuario(11);
			
			Usuario delete2 = new Usuario();
			delete2.setId_usuario(10);
			
			Usuario delete3 = new Usuario();
			delete3.setId_usuario(9);
			
			int registroEliminado = objUser.eliminar(delete1);
			registroEliminado =+ objUser.eliminar(delete2);
			registroEliminado =+ objUser.eliminar(delete3);
			
			System.out.println("Se eliminaron: "+registroEliminado+" registros");
			
			Usuario insert1 = new Usuario("userInserted1", "passwordInserted1");
			Usuario insert2 = new Usuario("userInserted2", "passwordInserted2");
			
			int registroInsertado = objUser.insertar(insert1);
			registroInsertado += objUser.insertar(insert2);
			
			System.out.println("Se insertaron: "+ registroInsertado+" registros");
			
			conexionUser.commit();
			System.out.println("-----------------------------------------------");
			objUser.seleccionar().forEach( elemento -> {
				System.out.println(elemento);
			});
			
			
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
			
			PersonaDAO personaDao = new PersonaDAO(conexion);
			
			Persona cambioPersona = new Persona();
			cambioPersona.setIdPersona(2);
			cambioPersona.setNombre("karla modificado");
			cambioPersona.setApellido("lara modificado");
			
		    int registro = personaDao.actualizar(cambioPersona);
		    System.out.println("Se actualizaron: "+registro+" registros");
		    
		    Persona insertPersona = new Persona();
		    insertPersona.setNombre("Carlos nuevo");
		    insertPersona.setApellido("apellido Carlos");
		    int registro2 = personaDao.insertar(insertPersona);
		    System.out.println("Se insertaron: "+registro2+" registros");
		    
		    //guarda los cambios si todo salio bien
		    conexion.commit();
		    
			
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
