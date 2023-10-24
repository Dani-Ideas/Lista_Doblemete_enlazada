package fes.aragon.utilerias.dinamicas.listasimple;		

public class ListaSimpleSinRepetir<E> extends ListaSimple<E>{
	
	/**
	 * este método busca duplicados en la lista original y, cuando los encuentra, los elimina de la lista original y los agrega a la lista list_errace, al tiempo que muestra mensajes informativos y actualiza las listas para su visualización.
	 * @param list_errace parametro necesario para aagergar los datos repetidos
	 * */
	
	public void eliminaYPasarRepetidos(ListaSimple<E> list_errace) {
	    Nodo<E> referencia,temporal = cabeza;
	    int indiceTempral,indiceReferencia=indiceTempral=0;
	    E basura;
	    while (temporal != null) {
	    referencia = temporal.getSiguiente();
	        while (referencia != null) {
	            if (temporal.getDato().equals(referencia.getDato())) {
	            	list_errace.agregarEnCola(referencia.getDato());
	            	basura=super.eliminarEnIndice(indiceReferencia);
	            	System.out.println("Se detecto un numero repetido en el indice "+indiceReferencia+" se pasara a la lista de repetidos:");
	            	System.out.println("----------------------------------------------");
	        		System.out.println("----------------------------------------------");
	        		System.out.println("----------------------------------------------");
	            	System.out.println("Esta es la lista original actualizada:");
	            	super.imprimirElementos();
	            	System.out.println("Esta es la lista de repetidos actualizada:");
	            	System.out.println("***********************************************");
	            	System.out.println("***********************************************");
	            	System.out.println("***********************************************");
	            	list_errace.imprimirElementos();
	            }
	            indiceReferencia++;
	            referencia = referencia.getSiguiente();
	        }
	        indiceReferencia=indiceTempral++;
	        temporal = temporal.getSiguiente();
	    }
    } 
}
