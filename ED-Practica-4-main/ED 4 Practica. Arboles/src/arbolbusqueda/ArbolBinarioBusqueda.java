package arbolbusqueda;

public class ArbolBinarioBusqueda {

	private NodoArbol raiz;
	private int numElementos;

	public ArbolBinarioBusqueda() {
		raiz = null;
		numElementos = 0;
	}

	public boolean vacia() {
		return raiz == null;
	}


	/**
	 * Busca la clave en la lista. Si la encuentra devuelve el alumno asociado a dicha clave,
	 * y si no la encuentra devuelve NULL.
	 */
	public Alumno getElemento(int clave) {
		return this.getElementoRec(raiz, clave);
	}

	private Alumno getElementoRec(NodoArbol nodo, int clave) {
		if (nodo == null) {    // No encontrado
			return null;
		} else if (clave == nodo.getClave()) {    // Encontrado
			return nodo.getDato();
		} else if (clave < nodo.getClave()) {     // Subárbol izquierdo
			return this.getElementoRec(nodo.getIzquierdo(), clave);
		} else {        // Subárbol izquierdo
			return this.getElementoRec(nodo.getDerecho(), clave);
		}
	}

	/**
	 * Inserta el alumno en la posición que le corresponde según la clave
	 */
	public boolean insertar(Alumno dato) {
		int previousNumElementos = numElementos;
		raiz = this.insertarRec(raiz, dato);
		return (previousNumElementos < numElementos);
	}

	private NodoArbol insertarRec(NodoArbol nodo, Alumno dato) {
		if (nodo == null) {
			nodo = new NodoArbol(dato);   // Crear nuevo nodo
			numElementos++;
		} else if (dato.getMatricula() < nodo.getClave()) {    // Subárbol izquierdo
			NodoArbol nuevoIzq = this.insertarRec(nodo.getIzquierdo(), dato);
			nodo.setIzquierdo(nuevoIzq);
		} else if (dato.getMatricula() > nodo.getClave()) {    // Subárbol derecho
			NodoArbol nuevoDer = this.insertarRec(nodo.getDerecho(), dato);
			nodo.setDerecho(nuevoDer);
		} else {
			System.out.println("Error inserción. La clave " + dato.getMatricula() + " ya existe");
			nodo = null;
		}
		return nodo;
	}


	/**
	 * Determina si la clave recibida como parámetro existe en la lista.
	 */
	public boolean contiene(int clave) {
		return this.getElemento(clave) != null;
	}

	/**
	 * Elimina de la lista el alumno con número de matrícula clave,
	 * en caso de existir.
	 */
	public boolean borrar(int clave) {
		int previousNumElementos = numElementos;
		raiz = this.borrarRec(raiz, clave);
		return (numElementos < previousNumElementos);
	}

	private NodoArbol borrarRec(NodoArbol nodo, int clave) {
		if (nodo == null) {
			System.out.println("la clave buscada no existe");
		} else if (nodo.getClave() > clave) {  // Buscar en subarbol izquierdo
			NodoArbol nuevoIzq = this.borrarRec(nodo.getIzquierdo(), clave);
			nodo.setIzquierdo(nuevoIzq);
		} else if (nodo.getClave() < clave) {  // Buscar en subarbol derecho
			NodoArbol nuevoDer = this.borrarRec(nodo.getDerecho(), clave);
			nodo.setDerecho(nuevoDer);
		} else {  // Borrar elemento en nodo
			if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
				nodo = null;  // Caso 1
			} else if (nodo.getDerecho() == null) {  // Caso 2
				nodo = nodo.getIzquierdo();
			} else if (nodo.getIzquierdo() == null) {  // Caso 2
				nodo = nodo.getDerecho();
			} else {    // Caso 3
				NodoArbol nuevoIzq = this.cambiarPorMenor(nodo, nodo.getIzquierdo());
				nodo.setIzquierdo(nuevoIzq);
			}
			numElementos--;
		}
		return nodo;
	}

	private NodoArbol cambiarPorMenor(NodoArbol nodoBorrar, NodoArbol nodoMenor) {
		if (nodoMenor.getDerecho() != null) {   // Seguir en subárbol derecho
			NodoArbol nuevoDer = this.cambiarPorMenor(nodoBorrar, nodoMenor.getDerecho());
			nodoMenor.setDerecho(nuevoDer);
			return nodoMenor;
		} else {  // Encontrado nodo menor inmediato
			nodoBorrar.setDato(nodoMenor.getDato()); // Cambiar datos de nodos
			return nodoMenor.getIzquierdo();  // Devolver subarbol izquierdo de menor inmediato
		}
	}

	public int getNumElementos() {
		return numElementos;
	}

	public void preOrdenNivel() {
		System.out.println("Preorden con niveles: ");
		preOrdenNivelRec(raiz, 1);
	}

	private void preOrdenNivelRec(NodoArbol nodo, int nivel) {
		if (nodo != null) {
			System.out.println("Clave " + nodo.getClave() + ". En el nivel " + nivel);
			preOrdenNivelRec(nodo.getIzquierdo(), nivel + 1);
			preOrdenNivelRec(nodo.getDerecho(), nivel + 1);
		}
	}

	// ------------------------------------------------------------------------
	// TODO 3.2
	public ListaOrdinalAlumnos aLista() {
		return null;
	}

	// ------------------------------------------------------------------------
	// TODO 3.3
	public Alumno getCalificacionMaxima(int minimaMat, int maximaMat) {
		return null;
	}

	// ------------------------------------------------------------------------
	// TODO 3.4
	public double getCalificacionMedia(int minimaMat, int maximaMat) {
		return 0.0;
	}

	// ------------------------------------------------------------------------
	// TODO 3.5
	public boolean esEquilibrado() {
		return false;
	}

}
