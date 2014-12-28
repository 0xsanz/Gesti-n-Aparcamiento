package uva.poo.practica_1;

import java.util.GregorianCalendar;

/*
 * Clase en la que se realizarán las pruebas 
 * de los métodos creados en las clases Aparcamiento y Tarjeta
 *
 */
public class Prueba {
 

	public static void main(String[] args){
		//Creamos dos aparcamientos
		Aparcamiento park = new Aparcamiento();
		Aparcamiento park2=new Aparcamiento();
		//Creación de una tarjeta con todos los datos correctos
		Tarjeta card = new Tarjeta("Rodrigo","Nuñez","71157812A",new GregorianCalendar(2015,12,1),false);
		/*Creación de otra tarjeta con el campo finPeriodo incorrecto*/
		Tarjeta card2 = new Tarjeta("Pablo","Garcia","71155231B",new GregorianCalendar(2013,11,23),false);
		
		/*
		 * Caso en el que introducimos una tarjeta que cumple las condiciones para entrar
		 */
		System.out.println("***CASE 1***");
		condiciones_entrada(card,park);
		caseEntrar(card,park);
		condiciones_entrada(card,park);
		imprimir_lista(park);
		System.out.println("________________________________");
		 
		/*
		 * Caso en el que se introduce una tarjeta que no 
		 * ha pagado hasta la fecha del sistema pero que se modifica
		 * para que pueda entrar
		 */
		System.out.println("***CASE 2***");
		condiciones_entrada(card2,park);
		caseEntrar(card2,park);
		card2.setFinPeriodo(new GregorianCalendar(2016,2,3));
		caseEntrar(card2,park);
		condiciones_entrada(card,park);
		imprimir_lista(park);
		 System.out.println("________________________________");
		/*
		 * Buscar una tarjeta a partir de un dni
		 */
		   System.out.println("***CASE 3***");
		   System.out.println(park.busca_tarjeta(card.getDni()));
		   System.out.println("________________________________");
		   /*
		    * Sacamos una tarjeta del aparcamiento
		    */
		   System.out.println("***CASE 4***");
		   condiciones_entrada(card,park);
		   imprimir_lista(park);
		   caseSalir(card,park);
		   condiciones_entrada(card,park);
		   imprimir_lista(park);


		   /*
		    * Intentamos introducir una tarjeta que esta en otro aparcamiento,
		    */
		   	System.out.println("***CASE 5***");
			condiciones_entrada(card2,park2);
		   	caseEntrar(card2,park2);
		   	condiciones_entrada(card2,park2);
		   
		   /*
		    * Reiniciamos la tarjeta
		    */

		   System.out.println("***CASE 6***");
		  
		   		System.out.println(card2.isDentro());
		   		card2.reiniciar();
		   	System.out.println(card2.isDentro());
		   	
		   	
	
		   	
		 }
    /*
     * Diferentes salidas por pantalla dependiendo si la tarjeta cumple las condiciones
     * para entrar en el aparcamiento.
     */
	public static void condiciones_entrada(Tarjeta card,Aparcamiento park){
		if(card.pagado()){
			  System.out.println("Al corriente de pago");
		}else{
			System.out.println("Usted no está al corriente de pago");
		}
		
		if(card.isDentro()){
			
			System.out.println("La tarjeta ya está dentro");
		}else{
			System.out.println("La tarjeta está fuera");
		}
		
		if(park.consultar_dni(card.getDni())){
			System.out.println("Ya existe una tarjeta con ese dni");	
		
		}
	}
	/*
	 *Metodo que introduce una tarjeta.
	 */
	public static void caseEntrar(Tarjeta card,Aparcamiento park){
		 
		 park.meter(card);
		
	}
	/*
	 * Método que saca una tarjeta.
	 */
	public static void caseSalir(Tarjeta card,Aparcamiento park){
		park.salir(card);
	}
	/*
	 * Imprime la lista de tarjetas que están dentro del aparcamiento.
	 */
	public static void imprimir_lista(Aparcamiento park){
		
		for(int i=0; i<park.getLista().size();i++){
			System.out.println(park.getLista().get(i).toString());
		}
	}
	
	
	
	}
