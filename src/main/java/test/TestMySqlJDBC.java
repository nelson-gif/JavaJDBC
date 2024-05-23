package test;

import java.sql.*;
import java.util.*;

import datos.*;
import domain.*;

public class TestMySqlJDBC {
	
	public static void main(String[] args) {
		
		//personaSql();
		usuarioSql();
		
		
	}
	
	public static void usuarioSql() {
		
		
		UsuarioDao userDao = new UsuarioDao();
		
		
		Usuario user3 = new Usuario("carlos.g", "passwor");
		Usuario user4 = new Usuario("nvl-q", "asmin");
		Usuario user5 = new Usuario("user-name-1", "guat=wer");
		
		//insertando registros
//		int insert1 = userDao.insertar(user3);
		//System.out.println(insert1+"fueron actualizados");
//		int insert2 = userDao.insertar(user4);
		//System.out.println(insert2+"fueron actualizados");
//		int insert3 = userDao.insertar(user5);
		//System.out.println(insert3+"fueron actualizados");
		
		
		//actualizando registros
//		Usuario user33 = new Usuario(3, "carlos.g-actualizado", "passwor-actualizado");
//		Usuario user44 = new Usuario(4, "nvl-q-actualizado", "asmin-actualizado");
//		
//		int update1 = userDao.update(user33);
//		System.out.println("Se actualizo: "+update1+"registro");
//		int update2 = userDao.update(user44);
//		System.out.println("Se actualizo: "+update2+"registro");
		

		//eliminando registros
//		Usuario delete = new Usuario(1);
//		Usuario delete2 = new Usuario(2);
//		int delete1 = userDao.eliminar(delete); 
//		delete1 += userDao.eliminar(delete2); 
		
//		System.out.println(delete1+" registros were deleted");
		
		List<Usuario> listUser = userDao.seleccionar();
		print(listUser);
		
		
	} 
	
	public static <T> void print(List<T> list) {
		list.forEach( element -> {
			System.out.println(element);
		});
	}
	
	
	
	public static void personaSql() {
		PersonaDAO personaDao = new PersonaDAO();
		
		
		
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
		
		/*
		 * Persona persona = new Persona(1); int contador =
		 * personaDao.eliminar(persona); System.out.println(contador +
		 * " record was deleted");
		 */
		
		List<Persona> personas = personaDao.seleccionar();
		print(personas);
		
		
		
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
