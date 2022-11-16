package proyecto_testng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestPizzaOrden {
	
	PizzaOrden nuevaOrden;
	List<String> listIngredientes;

	@BeforeClass
	public void bienvenida() {
		nuevaOrden = new PizzaOrden();
		String[] ingredientes = {"Pimiento", "Hongos", "Espinaca", "Peperoni", "Jamon", "Salchicha"};
		listIngredientes = new ArrayList<>(Arrays.asList(ingredientes));
		nuevaOrden.desplegarMensajeInicio();
		nuevaOrden.desplegarMensajeDefault();
	}
		
	@Test(priority = 0)
	public void verificarOpcionVeganaVerdadera() {
		nuevaOrden.preguntarPizzaVegetariana();
		nuevaOrden.desplegarIngredientes();
		nuevaOrden.guardarIngredientes();
		boolean actualResult = nuevaOrden.getOpcionVeg();
		boolean expectedResult = true;
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test(priority = 1)
	public void verificarOpcionVeganaFalsa() {
		nuevaOrden.setOpcionVeg("N"); 
		boolean actualResult = nuevaOrden.getOpcionVeg();
		boolean expectedResult = false;
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	
	@Test(priority = 2)
	public void verificarIngrediente1() {
		
		String auxResult = nuevaOrden.getIngrediente1();
		boolean	actualResult = true;
		boolean expectedResult = listIngredientes.indexOf(auxResult) >= 0 ? true : false;
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test(priority = 3)
	public void verificarIngrediente2() {
		String auxResult = nuevaOrden.getIngrediente2();
		boolean	actualResult = true;
		boolean expectedResult = listIngredientes.indexOf(auxResult) >= 0 ? true : false;
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test(priority = 4)
	public void verificarIngrediente3() {
		String auxResult = nuevaOrden.getIngrediente3();
		boolean	actualResult = true;
		boolean expectedResult = listIngredientes.indexOf(auxResult) >= 0 ? true : false;
		Assert.assertEquals(actualResult, expectedResult);
	}
	

	@Test(priority = 5)
	public void verificarOpcionInvalidaIngrediente1() {
		String opcion = nuevaOrden.getIngrediente1();
		boolean actualResult = false;
		boolean expectedResult = false;
		if(opcion.equals("Opcion_Invalida")) {
			expectedResult = true;
		}
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test(priority = 6)
	public void verificarOpcionInvalidaIngrediente2() {
		String opcion = nuevaOrden.getIngrediente2();
		boolean actualResult = false;
		boolean expectedResult = false;
		if(opcion.equals("Opcion_Invalida")) {
			expectedResult = true;
		}
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	
	@Test(priority = 7)
	public void verificarOpcionInvalidaIngrediente3() {
		String opcion = nuevaOrden.getIngrediente3();
		boolean actualResult = false;
		boolean expectedResult = false;
		if(opcion.equals("Opcion_Invalida")) {
			expectedResult = true;
		}
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@AfterClass
	public void desplegarOrdenPizzaFinal() {
		try {
			nuevaOrden.desplegarResumenOrden();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("¡¡¡Opciones Invalidas - No se seleccionaron ingredientes!!!\n");
		}
	}
}
