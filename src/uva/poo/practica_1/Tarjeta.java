package uva.poo.practica_1;


import java.util.GregorianCalendar;

/** 
 * Clase Tarjeta que define e implementa la tarjeta de acceso 
 * al aparcamiento de un determinado campus.
 * 
 * @author Rodrigo Núñez Paúl 
 * @author Pablo García Sanz
 * 
 * @version 1.0 11/11/2014
 */

	public class Tarjeta {
	
			private String nombre;
			private String apellidos;
			private String dni;
			private	GregorianCalendar finPeriodo;
			private boolean dentro;
		
	
	/**
	 * @param nombre especifica el nombre del usuario al que pertenece la tarjeta.
	 * @param apellidos especifica los apellidos del usuario al que pertenece la tarjeta.
	 * @param dni identificador de la tarjeta del usuario.
	 * @param finPeriodo fecha que representa el fin del periodo que se ha pagado del aparcamiento.
	 * @param dentro especifica si una tarjeta está dentro o está fuera.
		 */
		
	public Tarjeta(String nombre,String apellidos,String dni,GregorianCalendar finPeriodo,boolean dentro){
			super();
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.dni = dni;
			this.finPeriodo=finPeriodo;
			this.dentro=dentro;		
		}
	/**
	 * Devuelve el atributo nombre.
	 * @return nombre del usuario.
	 */
	public String getNombre(){
		return nombre;
	}
	/**
	 * Devuelve el atributo apellidos.
	 * @return apellidos del usuario.
	 */
	public String getApellidos(){
		return apellidos;
	}
	/**
	 * Devuelve el atributo dni.
	 * @return dni del usuario.
	 */
	public String getDni(){
		return dni;
	}
	/**
	 * Devuelve el atributo finPeriodo.
	 * @return fecha hasta que se ha pagado el aparcamiento.
	 */
	public GregorianCalendar getFinPeriodo(){
		return finPeriodo;
	}
	/**
	 * Determina el estado de la tarjeta.
	 * @return estado de la tarjeta.
	 */
	public boolean isDentro() {
		return dentro;
	}
	/**
	 * Cambia el estado de la tarjeta.
	 */
	public void setDentro() {
		if(dentro==false){
			dentro=true;
		}else{
			dentro=false;
		}
	}

		
	/**
	 * Modifica la fecha de periodo pagado.
	 * @param finPeriodo
	 */
	public void setFinPeriodo(GregorianCalendar finPeriodo) {
		this.finPeriodo = finPeriodo;
	}
	

      /**
       * Imprime los datos de la tarjeta 
       * para que sean visualizados correctamente
       * por el usuario.
       * @return cadena de caracteres que muestra los datos de la tarjeta.
       */
	public String toString(){
		return "Nombre: "+this.nombre+" Apellido:"+this.apellidos+" DNI:"+this.dni;
	}
		/**
		 * Coloca 'fuera' del aparcamiento una tarjeta.
		 */
   public void reiniciar(){
	   dentro = false;
	   
   }
   /**
    * Comprueba si la tarjeta está a corriente de pago.
    * @return true si la fecha es posterior, false si sucede lo contrario.
    */
   public boolean pagado(){
	   boolean pagado=false;
	   GregorianCalendar fecha_actual = new GregorianCalendar();
	   if(finPeriodo.after(fecha_actual)){
		   pagado=true;
	   }
	   return pagado;
   }

	
}