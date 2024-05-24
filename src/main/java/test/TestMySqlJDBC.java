package test;

import java.sql.*;
import java.util.*;

import datos.*;
import domain.*;

public class TestMySqlJDBC {
	
	public static void main(String[] args) {
		
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
