package fes.aragon.utilerias.dinamicas.listasimple;

public class ListaSimpleCircular<E> extends ListaSimple<E>{
	
	
	public void imprimirElemetos() {
	    Nodo<E> temporal = cabeza;
	    int count = 0;
	    while (temporal != null && count < longitud) {
	        System.out.print(temporal.getDato());
	        temporal = temporal.getSiguiente();
	        count++;
	        if (temporal == cabeza) {
	        	System.out.println(" ");
	            break;
	        }
	    }
	}
	
	public void imprimirElemetos(int startPoint) {
	    Nodo<E> lineEnd,temporal = lineEnd =cabeza;
	    
	    for (int i =0; i<startPoint; i++) {
	    	temporal = temporal.getSiguiente();
	    	lineEnd= lineEnd.getSiguiente();
	    }
	    
	    int count = 0;
	    while (temporal != null && count < longitud) {
	        System.out.print(temporal.getDato());
	        temporal = temporal.getSiguiente();
	        count++;
	        if (temporal == lineEnd) {
	        	System.out.println(" ");
	            break;
	        }
	    }
	}
	
	public boolean transfomacionCircular() {
		if (cabeza.equals(null))
			return false;
		else {
			cola.setSiguiente(cabeza);
			return true;
		}
	}
}