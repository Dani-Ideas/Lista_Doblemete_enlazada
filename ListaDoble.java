package fes.aragon.utilerias.dinamicas.listasimple;

public class ListaDoble <E> {
	protected Nodo<E> cabeza, cola, n;
	protected int longitud = 0;
	
	public ListaDoble(){
		cabeza = cola = null;	
	}
	
	public void agregarEnCabeza(E dato) {
	    n = new Nodo<E>(dato, cabeza, null); 
	    if (cabeza == null) {
	        cola = cabeza = n;
	    } else {
	        n.setSiguiente(cabeza);
	        cabeza.setAnterior(n);
	        cabeza = n;
	    }
	    longitud++;
	}
	
	public void agregarEnCola(E dato) {
		n = new Nodo<E>(dato);
		if (cabeza == null) {
			cabeza = cola = n;
		} else {
			n.setAnterior(cola);
			cola.setSiguiente(n);
			cola = n;
		}
		longitud++;
	}
	
	public void imprimirElementos() {
		for (Nodo<E> tmp = cabeza; tmp != null; tmp = tmp.getSiguiente()) {
			System.out.println(tmp.getDato());
		}
	}
	
	public E obtenerCabeza() {
		return cabeza.getDato();
	}
	
	public E obtenerCola() {
		return cola.getDato();
	}
	
	public int longitud() {
		return longitud;
	}
	
	/* la idea detras de esto es alamacenar el dato elmindo antes de desconectarlo del
	 *  apunatdor cola, una vez almacenado, se cambia el apuntador cola al anterior y 
	 *  despues se desconecta la vieja cola asignandole nulo al siguiente dato
	 *  finalmete se retorna el valor eliminado*/
	public E eliminarEnCola() {
		E datoEliminado= cola.getDato();
		if (cabeza != null) {
			if (cabeza == cola) {
				cabeza = cola = null;
				longitud--;
			} else {
			cola=cola.getAnterior();
			cola.setSiguiente(null);
			longitud--;
			}
		}
		return datoEliminado;
	}
	public E eliminarEnCabeza() {
	    E datoEliminado = cabeza.getDato();
	    if (cabeza != null) {
	        if (cabeza == cola) {
	            cabeza = cola = null;
	        } else {
	            cabeza = cabeza.getSiguiente();
	            cabeza.setAnterior(null);
	        }
	        longitud--;
	    }
	    return datoEliminado;
	}

	public E eliminarEnIndice(int indice) {
		E datoEliminado=null;
		if (indice<=longitud-1&&indice>=0) {
			if (indice==0) {
				datoEliminado= cabeza.getDato();
				cabeza=cabeza.getSiguiente();
				cabeza.setAnterior(null);
				if (cabeza == null) {
	                cola = null;
	            }
			}else {
				Nodo<E> anterior = cabeza;
				Nodo<E> nuevoSiguiente= null;
	            int contador = 0;
	            
	            while (contador < indice) {
	                anterior = anterior.getSiguiente();
	                contador++;
	            }
	            
	            datoEliminado= anterior.getSiguiente().getDato();
	            nuevoSiguiente=anterior.getSiguiente().getSiguiente();
	            anterior.setSiguiente(nuevoSiguiente);
	            nuevoSiguiente.setAnterior(anterior);
	            
	            if (anterior.getSiguiente() == null) {
	                cola = anterior;
	            }
			}
			longitud --;
		}
		return datoEliminado;
	}
	// en este metodo sospecho que es void, pero en los metodos del primer parcial esta asi
	public E eliminar(E dato) {
		E datoEliminado =null;
		if (dato.equals(cabeza.getDato())) {
			datoEliminado=eliminarEnIndice(0);
		}else {
			boolean continueFor= true;
			Nodo<E> pivote =cabeza;
			for(int i=0;i<=longitud&&!pivote.getDato().equals(dato)&&!pivote.equals(null)&&continueFor; i++, pivote = pivote.getSiguiente()) {
				datoEliminado=eliminarEnIndice(i);
				continueFor= false;
			}
		}
		longitud--;
		return datoEliminado;
	}
	public E eliminarT(E dato, boolean b) {
	    E datoEliminado = null;
	    
	    if (b) {
	        Nodo<E> pivote = cabeza;
	        int i = 0;
	        while (pivote != null) {
	            if (pivote.getDato().equals(dato)) {
	                datoEliminado = eliminarEnIndice(i);
	                i--;  // Ajustar el índice después de la eliminación
	            }
	            pivote = pivote.getSiguiente();
	            i++;
	        }
	    } else {
	        datoEliminado = eliminar(dato);
	    }
	    
	    return datoEliminado;
	}
	public E obtenerDatoIndice(int indice) {
	    E dato = null;
	    if (indice >= 0 && indice <= longitud - 1&&cabeza != null) {
	        //if (cabeza != null) {
	            if (cabeza == cola && indice == 0) {
	                dato = cabeza.getDato();
	            } else {
	                Nodo<E> nodoActual = cabeza;
	                int contador = 0;
	                while (contador != indice) {
	                    nodoActual = nodoActual.getSiguiente();
	                    contador++;
	                }
	                dato = nodoActual.getDato();
	            }
	        //}
	    }
	    return dato;
	}
	public void asignarEnIndice(E dato, int indice) {
	    if (indice >= 0 && indice <= longitud - 1) {
	        if (cabeza != null) {
	            if (cabeza == cola && indice == 0) {
	                cabeza.setDato(dato);
	            } else {
	                Nodo<E> nodoActual = cabeza;
	                int contador = 0;
	                while (contador != indice) {
	                    nodoActual = nodoActual.getSiguiente();
	                    contador++;
	                }
	                nodoActual.setDato(dato);
	            }
	        }
	    }
	}
	public void asignar(E dato, E nuevoDato, boolean b) {
	    if (b) {
	        Nodo<E> nodoActual = cabeza;
	        int contador = 0;
	        while (nodoActual != null) {
	            if (nodoActual.getDato().equals(dato)) {
	                asignarEnIndice(nuevoDato, contador);
	            }
	            nodoActual = nodoActual.getSiguiente();
	            contador++;
	        }
	    } else {
	        Nodo<E> nodoActual = cabeza;
	        int contador = 0;
	        boolean cambioRealizado = false;
	        while (nodoActual != null && !cambioRealizado) {
	            if (nodoActual.getDato().equals(dato)) {
	                asignarEnIndice(nuevoDato, contador);
	                cambioRealizado = true;
	            }
	            nodoActual = nodoActual.getSiguiente();
	            contador++;
	        }
	    }
	}
}