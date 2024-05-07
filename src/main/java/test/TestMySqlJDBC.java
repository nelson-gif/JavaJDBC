package test;

import java.sql.*;
import java.util.*;

import datos.*;
import domain.*;

public class TestMySqlJDBC {
	
	public static void main(String[] args) {
		
		PersonaDAO personaDao = new PersonaDAO();
		List<Persona> personas = personaDao.seleccionar();
		
		
		
		//insertando nuevo objeto persona
		/*
		 * Persona persona = new Persona("Juan", "solorzano", "jsolorzano@gmail.com",
		 * "234345346"); int registros = personaDao.insertar(persona);
		 * System.out.println(registros + " registros fueron insertados");
		 */
		
		//actualizando un dato
//		Persona persona = new Persona(5, "Pedro", "Linarez", "pedroL@gamil.com", "345345");
//		int contador = personaDao.actualizar(persona);
//		System.out.println(contador + " registros fueron actualizados");
		
		personas.forEach(personax -> {
			System.out.println(personax);
		});
		
		
		
//		String url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
		
		
		/*
		 * try { // Class.forName("com.mysql.cj.jdbc.Driver"); Connection conexion =
		 * DriverManager.getConnection(url, "root", "admin"); Statement instruccion =
		 * conexion.createStatement(); String sql =
		 * "SELECT idpersona, nombre, apellido, email, telefono FROM test.persona";
		 * ResultSet resultado = instruccion.executeQuery(sql);
		 * 
		 * while (resultado.next()) {
		 * System.out.print("{Id persona: "+resultado.getInt("idpersona"));
		 * System.out.print(" , nombre: "+resultado.getString("nombre"));
		 * System.out.print(" , apellido: "+resultado.getString("apellido"));
		 * System.out.println(" , email: "+resultado.getString("email"));
		 * System.out.println(" , telefono: "+resultado.getString("telefono")+"}");
		 * System.out.println(); }
		 * 
		 * resultado.close(); instruccion.close(); conexion.close();
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(System.out); }
		 */
		 
		
		
		
	}

}
