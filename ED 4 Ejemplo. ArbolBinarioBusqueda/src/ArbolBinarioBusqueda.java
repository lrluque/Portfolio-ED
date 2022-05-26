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

	public void mostrarClavesDescendente() {
		mostrarClavesDescendenteRec(raiz);
	}

	private void mostrarClavesDescendenteRec(NodoArbol nodo) {
		if (nodo != null) {
			mostrarClavesDescendenteRec(nodo.getDerecho());
			System.out.print(nodo.getClave() + " ");
			mostrarClavesDescendenteRec(nodo.getIzquierdo());
		}
	}

	public void mostarClavesUnSoloHijo() {
		mostrarClavesUnSoloHijoRec(raiz);
	}


	private void mostrarClavesUnSoloHijoRec(NodoArbol nodo){
		if (nodo != null){
			mostrarClavesUnSoloHijoRec(nodo.getDerecho());
			if (nodo.getIzquierdo() == null && nodo.getDerecho() != null || nodo.getIzquierdo() != null && nodo.getDerecho() == null ){
				System.out.print(nodo.getClave() + " ");
			}
			mostrarClavesUnSoloHijoRec(nodo.getIzquierdo());
		}
	}

	public void mostrarClaveEntreDos(int c1, int c2) {
		if (c1 < c2) {
			mostrarClaveEntreDosRec(c1, c2, raiz);
		} else {
			mostrarClaveEntreDosRec(c2, c1, raiz);
		}
	}


	private void mostrarClaveEntreDosRec(int c1, int c2, NodoArbol nodo) {
		if (nodo != null) {
			boolean esMasPequeno = nodo.getClave() <= c1;
			boolean esMasGrande = nodo.getClave() >= c2;
			boolean estaEnRango = !esMasGrande && !esMasPequeno;
			if (!esMasPequeno) {
				mostrarClaveEntreDosRec(c1, c2, nodo.getIzquierdo());
			}
			if (estaEnRango) {
				System.out.print(nodo.getClave() + " ");
			}
			if (!esMasGrande) {
				mostrarClaveEntreDosRec(c1, c2, nodo.getDerecho());
			}
		}
	}

	public boolean comprobarSiEnHoja(int num){return comprobarSiEnHojaRec(num, raiz);}

	private boolean comprobarSiEnHojaRec(int num, NodoArbol nodo){
		boolean enHoja = false;
		if (nodo != null){
			if (nodo.getClave() == num && nodo.getDerecho() == null && nodo.getIzquierdo() == null){
				enHoja = true;
			}else if (nodo.getClave() < num){
				enHoja = comprobarSiEnHojaRec(num, nodo.getDerecho());
			}else{
				enHoja = comprobarSiEnHojaRec(num, nodo.getIzquierdo());
			}
		}
		return enHoja;
	}

	public int antecesoresComunes(int c1, int c2){
		return (c1 > c2)?antecesoresComunesRec(c1, c2, raiz):antecesoresComunesRec(c2, c1, raiz);

	}

	private int antecesoresComunesRec(int mayor, int menor, NodoArbol nodo){
		int num = 0;
		if (nodo != null){
			if (mayor < nodo.getClave()){
				num = 1 + antecesoresComunesRec(mayor, menor, nodo.getIzquierdo());
			}else if (menor > nodo.getClave()){
				num = 1 + antecesoresComunesRec(mayor, menor, nodo.getDerecho());
			}else if (nodo.getClave() > menor && nodo.getClave() < mayor){
				num = 1;
			}
		}
		return num;
	}

	public int diferenciaNiveles(int c1, int c2){
		return Math.abs(altura(c1, raiz) - altura(c2, raiz));
	}

	private int altura(int num, NodoArbol nodo){
		int nivel = 0;
		if (nodo != null){
			if (num < nodo.getClave()){
				nivel = 1 + altura(num, nodo.getIzquierdo());
			}else if (num > nodo.getClave()){
				nivel = 1 + altura(num, nodo.getDerecho());
			}else if (nodo.getClave() == num){
				nivel = 1;
			}
		}
		return nivel;
	}


	public Alumno getElementoMasCercano(int clave){return getElementoMasCercanoRec(raiz, clave,0 );}

	private Alumno getElementoMasCercanoRec(NodoArbol nodo, int clave, int diferencia){
		Alumno res = null;
		Alumno res2 = null;
		if (nodo != null){
			int dif = nodo.getClave() - clave;
			if (dif < 0){
				res2 = getElementoMasCercanoRec(nodo.getDerecho(), clave, dif);
			}else if(dif > 0){
				res2 = getElementoMasCercanoRec(nodo.getIzquierdo(), clave, dif);
			}else{
				res = nodo.getDato();
			}
			if (res2 == null){
				if (Math.abs(dif) < Math.abs(diferencia)){
					res = nodo.getDato();
				}
			}
		}
		return (res2 != null)?res2:res;
	}

	public int sumaAntecesores(int x){return sumaAntecesoresRec(x, raiz);}

	private int sumaAntecesoresRec(int x, NodoArbol nodo){
		int suma = 0;
		if (nodo != null){
			if (nodo.getClave() != x) {
				suma += nodo.getClave();
				if (nodo.getClave() < x) {
					suma += sumaAntecesoresRec(x, nodo.getDerecho());
				} else if (nodo.getClave() > x) {
					suma += sumaAntecesoresRec(x, nodo.getIzquierdo());
				}
			}else{
				if (nodo.getIzquierdo() != null || nodo.getDerecho() != null){
					suma = -999;
				}
			}
		}
		return suma;
	}

	public int suPutaMadre(int x){return suPutaMadreRec(x, raiz, 0);}

	private int suPutaMadreRec(int x, NodoArbol nodo, int suma){
		if (nodo != null){
			if (nodo.getClave() != x) {
				suma += nodo.getClave();
				if (nodo.getClave() < x) {
					suma = suPutaMadreRec(x, nodo.getDerecho(), suma);
				} else if (nodo.getClave() > x) {
					suma = suPutaMadreRec(x, nodo.getIzquierdo(), suma);
				}
			}else{
				if (nodo.getIzquierdo() != null || nodo.getDerecho() != null){
					suma = -999;
				}
			}
		}else{
			suma = -1;
		}
		return suma;
	}

	public boolean descendientesMenores(int c){
		boolean correcto = false;
		NodoArbol nodoBuscado = buscarNodo(raiz, c);
		if (nodoBuscado != null) {
			int descendientesIzq = numDescendientes(nodoBuscado.getIzquierdo(), c);
			int descendientesDer = numDescendientes(nodoBuscado.getDerecho(), c);
			if (descendientesIzq == descendientesDer) {
				correcto = true;
			}
		}
		return correcto;
	}

	private NodoArbol buscarNodo(NodoArbol nodo, int c){
		NodoArbol buscado = null;
		if (nodo != null){
			if (nodo.getClave() == c){
				buscado = nodo;
			}else{
				buscado = buscarNodo(nodo.getDerecho(), c);
				if (buscado == null) {
					buscado = buscarNodo(nodo.getIzquierdo(), c);
				}
			}
		}
		return buscado;
	}

	private int numDescendientes(NodoArbol nodo, int c){
		int num = 0;
		if (nodo != null){
			num = 1;
			num += numDescendientes(nodo.getDerecho(), c);
			num += numDescendientes(nodo.getIzquierdo(), c);
		}
		return num;
	}

}



