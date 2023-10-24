package fes.aragon.utilerias.dinamicas.listasimple;

/**
 * @author sebastian Mendoza
 */

public class ListaSimple<E> {
	protected Nodo<E> cabeza, cola;
	protected int longitud = 0;

	public ListaSimple() {
		cabeza = cola = null;
	}

	/**
	 * Metodo que agrega un nodo en la cabeza de la lista
	 * 
	 * @param dato es el parametro que indica que dato llevara el nuevo nodo
	 */
	public void agregarEnCabeza(E dato) {
		cabeza = new Nodo<E>(dato, cabeza);
		if (cola == null) {
			cola = cabeza;
		}
		longitud++;
	}

	/**
	 * Metodo que agrega un nodo en la cola de la lista
	 * 
	 * @param dato es el parametro que indica que dato llevara el nuevo nodo
	 */
	public void agregarEnCola(E dato) {
		if (cabeza == null) {
			cabeza = cola = new Nodo<E>(dato);
		} else {
			cola.setSiguiente(new Nodo<E>(dato));
			cola = cola.getSiguiente();
		}
		longitud++;
	}

	/**
	 * Metodo que imprime los elementos de la lista
	 */
	public void imprimirElementos() {
		for (Nodo<E> tmp = cabeza; tmp != null; tmp = tmp.getSiguiente()) {
			System.out.println(tmp.getDato());
		}
	}

	/**
	 * Metodo que nos muestra la información del nodo de la cabeza
	 * 
	 * @return regreza el dato que tiene cabeza
	 */
	public E obtenerCabeza() {
		return cabeza.getDato();
	}

	/**
	 * Metodo que nos muestra la información del nodo de la cola
	 * 
	 * @return regreza el dato que tiene cola
	 */
	public E obtenerCola() {
		return cola.getDato();
	}

	/**
	 * Metodo que elimina la cola de la lista y regresa el valor que borrro
	 */

	public E eliminarEnCola() {
		final E num = (E) cola.getDato();
		if (cabeza != null) {
			if (cabeza == cola) {
				cabeza = cola = null;
				longitud--;
			} else {
				Nodo<E> tmp;
				for (tmp = cabeza; tmp.getSiguiente() != cola; tmp = tmp.getSiguiente())
					;

				tmp.setSiguiente(null);
				cola = tmp;
				longitud--;
			}
		}
		return num;
	}

	/**
	 * Metodo que elimina la cabeza de la lista y regresa el valor que borrro
	 */
	public E eliminarEnCabeza() {
		final E num = (E) cabeza.getDato();
		if (cabeza != null) {
			if (cabeza == cola) {
				cabeza = cola = null;
				longitud--;
			} else {
				cabeza = cabeza.getSiguiente();
				longitud--;
			}
		}
		return num;
	}

	/**
	 * Metodo que elimina el el nodo del indice indicado
	 * 
	 * @param indice parametro que indica que indice borrar, este inicia en 0
	 * @return nos regresa si hizo el borrado del nodo
	 */

	public E eliminarEnIndice(int indice) {
	    E num = null;
	    if (indice >= 0 && indice < longitud) {
	        if (indice == 0) {
	            num = cabeza.getDato();
	            cabeza = cabeza.getSiguiente();
	            if (cabeza == null) {
	                cola = null;
	            }
	        } else {
	            Nodo<E> anterior = cabeza;
	            int contador = 0;
	            
	            while (contador < indice - 1) {
	                anterior = anterior.getSiguiente();
	                contador++;
	            }
	            
	            num = anterior.getSiguiente().getDato();
	            anterior.setSiguiente(anterior.getSiguiente().getSiguiente());
	            
	            if (anterior.getSiguiente() == null) {
	                cola = anterior;
	            }
	        }
	        longitud--;
	    }
	    return num;
	}

	/**
	 * Metodo que elimina el dato que le indicamos
	 * 
	 * @param dato es el parametro que indicara que dato es el que queremos borrar
	 * @return nos regresa si hizo el borrado del nodo
	 */
	public E eliminar(E dato) {
		E num = null;
		if (cabeza != null) {
			if (cabeza == cola && dato.equals(cabeza.getDato())) {
				num = cabeza.getDato();
				cabeza = cola = null;
				longitud--;
			} else if (dato == cabeza.getDato()) {
				num = cabeza.getDato();
				cabeza = cabeza.getSiguiente();
				longitud--;
			} else {
				Nodo<E> prd, tmp;
				for (prd = cabeza, tmp = cabeza.getSiguiente(); tmp != null&& !tmp.getDato().equals(dato); prd = prd.getSiguiente(), tmp = tmp.getSiguiente());if (tmp != null) {
					num = (E) tmp.getDato();
					longitud--;
					prd.setSiguiente(tmp.getSiguiente());
				}
				if (tmp == cola) {
					num = (E) tmp.getDato();
					cola = prd;
					longitud--;
				}
			}
		}
		return num;
	}

	/**
	 * Metodo el cual regresa el dato del indice indicado
	 * 
	 * @param indice parametro que indicara que indice queremos obtener su dato,
	 *               iniciando en el 0
	 * @return regresa el dato del indice indicado
	 */
	public E ObtenerDatoIndice(int indice) {
		E num = null;
		if (indice >= 0 && indice <= longitud - 1) {
			if (cabeza != null) {
				if (cabeza == cola && indice == 0) {
					num = cabeza.getDato();
				} else {
					Nodo<E> prd;
					int contador = 0;
					for (prd = cabeza; contador != indice; prd = prd.getSiguiente(), contador++)
						;
					num = (E) prd.getDato();
				}
			}
		}
		return num;
	}

	/**
	 * Metodo el cual cambia el dato que tiene el nodo del indice indicado por el
	 * dato que le indicamos
	 * 
	 * @param dato   parametro el cual indica cual es el nuevo dato a poner en un
	 *               nodo
	 * @param indice parametro que indicara que indice queremos cambiar, iniciando
	 *               en el 0
	 */
	public void asignarEnIndice(E dato, int indice) {
		if (indice >= 0 && indice <= longitud - 1) {
			if (cabeza != null) {
				if (cabeza == cola && indice == 0) {
					cabeza.setDato(dato);
				} else {
					Nodo<E> prd;
					int contador = 0;
					for (prd = cabeza; contador != indice; prd = prd.getSiguiente(), contador++)
						;
					prd.setDato(dato);
				}
			}
		}
	}

	/**
	 * Metodo que cambia el dato que le indicamos por uno nuevo
	 * @param dato parametro que indica cual es el dato que queremos cambiar
	 * @param nuevoDato parametro que indica por que dato cambiariamos 
	 * @param b boleano que indica si queremos cambiar todos los datos o solo el primero
	 */
	public void asignar(E dato, E nuevoDato, boolean b) {
		if (cabeza != null) {
			if(!b) {
				Nodo<E> tmp ;
				for (tmp = cabeza; !tmp.getDato().equals(dato) && tmp.getSiguiente() != null  ;
						tmp = tmp.getSiguiente())
					;
				tmp.setDato(nuevoDato);
			} else {
				Nodo<E> tmp ;
				for (tmp = cabeza;tmp.getSiguiente() != null  ; tmp = tmp.getSiguiente()) {
					if(tmp.getDato().equals(dato)) {
						tmp.setDato(nuevoDato);	
					}
				}
				if(tmp.getDato().equals(dato)) {
					tmp.setDato(nuevoDato);
				}					
			}
		} 
	}
	
	/**
	 * Metodo que nos da la longitud de la lista simple
	 * @return regresa en un dato de tipo entero la longitud de la lista
	 */
	public int longitud() {
		int num = 0;
		if (cabeza != null) {
			Nodo<E> tmp ;
			for (tmp = cabeza; tmp.getSiguiente() != null; tmp = tmp.getSiguiente()) {
				num++;
			}
		}
		return num;
	}
	
	/*public Integer estaEnLista(E dato, boolean b) {
		Nodo<E> tmp;
		int indice = 0;
		if (cabeza != null) {
			if(!b) {
				Nodo<E> tmp ;
				for (tmp = cabeza; !tmp.getDato().equals(dato) && tmp.getSiguiente() != null  ;
						tmp = tmp.getSiguiente())
					;
				tmp.setDato(nuevoDato);
			} else {
				Nodo<E> tmp ;
				for (tmp = cabeza;tmp.getSiguiente() != null  ; tmp = tmp.getSiguiente()) {
					if(tmp.getDato().equals(dato)) {
						tmp.setDato(nuevoDato);	
					}
				}
				if(tmp.getDato().equals(dato)) {
					tmp.setDato(nuevoDato);
				}					
			}
		}
		return longitud;
	}*/
	
	
	@SuppressWarnings({ "null", "unused" })
	public E eliminarT(E dato, boolean b) {
		E num = null;
		if (cabeza != null) {
			if(!b) {
				if (cabeza == cola && dato.equals(cabeza.getDato())) {
					num = cabeza.getDato();
					cabeza = cola = null;
					longitud--;
				} else if (dato == cabeza.getDato()) {
					num = cabeza.getDato();
					cabeza = cabeza.getSiguiente();
					longitud--;
				} else {
					Nodo<E> prd, tmp;
					for (prd = cabeza, tmp = cabeza.getSiguiente(); tmp != null
							&& !tmp.getDato().equals(dato); prd = prd.getSiguiente(), tmp = tmp.getSiguiente())
						;
					if (tmp != null) {
						num = (E) tmp.getDato();
						longitud--;
						prd.setSiguiente(tmp.getSiguiente());
					}
					if (tmp == cola) {
						num = (E) tmp.getDato();
						cola = prd;
						longitud--;
					}
				}
			} else {
				Nodo<E> prd, tmp, tmp2;
				if (dato == cabeza.getDato()) {
					num = cabeza.getDato();
					cabeza = cabeza.getSiguiente();
					longitud--;
				}
				for (prd = cabeza, tmp = prd.getSiguiente(); tmp != null
						; prd = prd.getSiguiente(), tmp = prd.getSiguiente()) {
					tmp2 = tmp.getSiguiente();
					if(tmp.getDato().equals(dato)) {
						if (tmp2.getSiguiente() != null) {
							num = (E) tmp.getDato();
							prd.setSiguiente(tmp.getSiguiente());
							tmp = tmp2.getSiguiente();
							longitud--;	
						}	
						if (tmp == cola) {
							num = (E) tmp.getDato();
							cola = prd;
							longitud--;
						}
					}	
				}	
			}
		}		
		return num;
	}
	/*
	 * if (cabeza != null) {
			if(!b) {
				Nodo<E> tmp ;
				for (tmp = cabeza; !tmp.getDato().equals(dato) && tmp.getSiguiente() != null  ;
						tmp = tmp.getSiguiente())
					;
				tmp.setDato(nuevoDato);
			} else {
				Nodo<E> tmp ;
				for (tmp = cabeza;tmp.getSiguiente() != null  ; tmp = tmp.getSiguiente()) {
					if(tmp.getDato().equals(dato)) {
						tmp.setDato(nuevoDato);	
					}
				}
				if(tmp.getDato().equals(dato)) {
					tmp.setDato(nuevoDato);
				}					
			}
		} 
	 */
}
