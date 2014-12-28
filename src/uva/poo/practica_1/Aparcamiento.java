package uva.poo.practica_1;
import java.util.ArrayList;


/**
 *  Clase que define el acceso al aparcamiento del campus donde las tarjetas pueden 
 * ser introducidas o por el contrario, salir
 * 
 * @author Rodrigo Nuñez Paul 
 * @author Pablo Garcia Sanz
 * @version 1.0 11/11/2014
 *
 */
public class Aparcamiento {
	
	private ArrayList <Tarjeta> tarjetas;
	
	/**
	 * Constructor por defecto sin argumentos,
	 * que inicializa la lista de tarjetas
	 */
	public Aparcamiento(){
		super();
		tarjetas=new ArrayList<Tarjeta>();
	}
	/**
	 * Acceso a la lista de tarjetas
	 * @return tarjetas devuelve la lista de tarjetas
	 */
	public ArrayList<Tarjeta> getLista(){
		
		return tarjetas;
	}
	

	/**
	 * Comprueba que una tarjeta cumple las condiciones para que pueda ser introducida
	 * en el Aparcamiento
	 * 
	 * @param card la tarjeta que se va a introducir en el aparcamiento
	 */
	public void meter(Tarjeta card){
			if(card.getFinPeriodo()!=null && !card.isDentro() && 
				card.pagado() && !consultar_dni(card.getDni())){
				card.setDentro();
				tarjetas.add(card);
			}
					
		}
	
	/**
	 * Comprueba que un dni no está repetido la lista de tarjetas
	 * @param dni el identificador de la tarjeta
	 * @return true si hay un dni equivalente al que se busca,
	 * false si sucede lo contrario
	 * 		
	 * 
	 */
	public boolean consultar_dni(String dni){
		boolean dni_igual=false;
		
		for(int i=0;i<tarjetas.size();i++){
			if(tarjetas.get(i).getDni().equals(dni)){
				dni_igual = true;
				break;
			}
		}
		return dni_igual;
	} 
	/**
	 * Búsqueda de una tarjeta a partir del dni
	 * @param dni de la tarjeta a buscar
	 * @return devuelve la tarjeta que corresponde al dni
	 */
	public Tarjeta busca_tarjeta(String dni){
		for(int i=0;i<tarjetas.size();i++){
			if(tarjetas.get(i).getDni().equals(dni)){
				return tarjetas.get(i);
				
			}
		}
		return null;
	}
	

	/**
	 * Permite salir a una tarjeta del aparcamiento
	 * @param card la tarjeta que va a salir
	 */
	public void salir(Tarjeta card){
		if(card.isDentro()){
			card.setDentro();
			tarjetas.remove(card);
		}else{
	
   	}

   }
}