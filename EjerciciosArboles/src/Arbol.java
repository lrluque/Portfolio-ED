import java.util.ArrayDeque;

public class Arbol {
    private NodoArbol raiz;

    public Arbol() {
        raiz = null;
    }

    public Arbol(int dato) {
        raiz = new NodoArbol(dato);
    }

    public Arbol(int dato, Arbol izquierdo, Arbol derecho) {
        NodoArbol nodoIzq = null;
        NodoArbol nodoDer = null;
        if (izquierdo != null) {
            nodoIzq = izquierdo.raiz;
        }
        if (derecho != null) {
            nodoDer = derecho.raiz;
        }
        raiz = new NodoArbol(dato, nodoIzq, nodoDer);
    }

    /**
     * Recorrido en preorden
     */
    public void preOrden() {
        System.out.print("Preorden: ");
        this.preOrdenRec(raiz);
        System.out.println();
    }

    private void preOrdenRec(NodoArbol nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato() + "  ");
            this.preOrdenRec(nodo.getIzquierdo());
            this.preOrdenRec(nodo.getDerecho());
        }
    }

    /**
     * Recorrido en orden central
     */
    public void ordenCentral() {
        System.out.print("Orden Central: ");
        this.ordenCentralRec(raiz);
        System.out.println();
    }

    private void ordenCentralRec(NodoArbol nodo) {
        if (nodo != null) {
            this.ordenCentralRec(nodo.getIzquierdo());
            System.out.print(nodo.getDato() + "  ");
            this.ordenCentralRec(nodo.getDerecho());
        }
    }

    /**
     * Recorrido en postorden
     */
    public void postOrden() {
        System.out.print("Postorden: ");
        this.postOrdenRec(raiz);
        System.out.println();
    }

    private void postOrdenRec(NodoArbol nodo) {
        if (nodo != null) {
            this.postOrdenRec(nodo.getIzquierdo());
            this.postOrdenRec(nodo.getDerecho());
            System.out.print(nodo.getDato() + "  ");
        }
    }

    /**
     * Recorrido en amplitud con una cola de nodos del árbol
     */
    public void amplitud() {
        Cola cola = new Cola();
        System.out.print("Amplitud: ");
        if (raiz != null) {
            cola.encolar(raiz);
            while (!cola.vacia()) {
                NodoArbol nodo = cola.desencolar();
                System.out.print(nodo.getDato() + "  ");
                if (nodo.getIzquierdo() != null) {
                    cola.encolar(nodo.getIzquierdo());
                }
                if (nodo.getDerecho() != null) {
                    cola.encolar(nodo.getDerecho());
                }
            }
        }
        System.out.println();
    }

    /**
     * Recorrido en amplitud con una cola proporcionada por la clase ArrayDeque
     */
    public void amplitud2() {
        ArrayDeque<NodoArbol> cola = new ArrayDeque<NodoArbol>();
        System.out.print("Amplitud: ");
        if (raiz != null) {
            cola.add(raiz);
            while (!cola.isEmpty()) {
                NodoArbol nodo = cola.remove();
                System.out.print(nodo.getDato() + "  ");
                if (nodo.getIzquierdo() != null) {
                    cola.add(nodo.getIzquierdo());
                }
                if (nodo.getDerecho() != null) {
                    cola.add(nodo.getDerecho());
                }
            }
        }
        System.out.println();
    }

    /**
     * Ejemplo: método que recorre el árbol para determinar si contiene un dato.
     */
    public boolean contiene(int dato) {
        return this.contieneRec(raiz, dato);
    }

    private boolean contieneRec(NodoArbol nodo, int dato){
        if (nodo != null){
            if (nodo.getDato() == dato){
                return true;
            }else{
                boolean estaEnDerecha = contieneRec(nodo.getDerecho(), dato);
                boolean estaEnIzquierda = contieneRec(nodo.getIzquierdo(), dato);
                return estaEnDerecha || estaEnIzquierda;
            }
        }else{
            return false;
        }
    }

    public boolean contieneEnHoja(int dato){return contieneEnHojaRec(raiz, dato);}

    private boolean contieneEnHojaRec(NodoArbol nodo, int dato){
        if (nodo != null){
            if (nodo.getDato() == dato && nodo.getDerecho() == null && nodo.getIzquierdo() == null){
                return true;
            }else{
                boolean estaEnDerecha = contieneEnHojaRec(nodo.getDerecho(), dato);
                boolean estaEnIzquierda = contieneEnHojaRec(nodo.getIzquierdo(), dato);
                return estaEnDerecha || estaEnIzquierda;
            }
        }else{
            return false;
        }
    }

    public int numHojas(){return numHojasRec(raiz);}

    private int numHojasRec(NodoArbol nodo){
        int resul = 0;
        if (nodo != null){
            if (nodo.getDerecho() == null && nodo.getIzquierdo() == null){
                return 1;
            }else{
                resul += numHojasRec(nodo.getDerecho());
                resul += numHojasRec(nodo.getIzquierdo());
                return resul;
            }
        }else{
            return 0;
        }
    }

    public int sumaDatosImparesDosHijos(){return sumaDatosImparesDosHijosRec(raiz);}

    private int sumaDatosImparesDosHijosRec(NodoArbol nodo){
        int suma = 0;
        if (nodo != null){
            if (nodo.getDato() % 2 != 0 && nodo.getIzquierdo() != null && nodo.getDerecho() != null){
                suma += nodo.getDato();
            }
            suma += sumaDatosImparesDosHijosRec(nodo.getIzquierdo());
            suma += sumaDatosImparesDosHijosRec(nodo.getDerecho());
        }else{
            return 0;
        }
        return suma;
    }

    public boolean esIgual(Arbol arbol){return esIgualRec(raiz, arbol.raiz);}

    private boolean esIgualRec(NodoArbol nodoA1, NodoArbol nodoA2){
        boolean esIgual = false;
        if (nodoA1 != null && nodoA2 != null){
            if (nodoA1 == nodoA2) {
                boolean esIgualIzquierda = esIgualRec(nodoA1.getIzquierdo(), nodoA2.getIzquierdo());
                boolean esIgualDerecha = esIgualRec(nodoA1.getDerecho(), nodoA2.getDerecho());
                esIgual = esIgualIzquierda && esIgualDerecha;
            }
        }else{
            esIgual = nodoA1 == null && nodoA2 == null;
        }
        return esIgual;
    }

    public int sumaDatosNivel(int nivel){return sumaDatosNivelRec(raiz, nivel);}

    private int sumaDatosNivelRec(NodoArbol nodo, int nivel){
        int suma = 0;
        if (nodo != null) {
            if (nivel == 1) {
                suma += nodo.getDato();
            } else {
                suma += sumaDatosNivelRec(nodo.getIzquierdo(), nivel - 1);
                suma += sumaDatosNivelRec(nodo.getDerecho(), nivel - 1);
            }
        }
        return suma;
    }

    public int altura(){return alturaRec(raiz);}

    private int alturaRec(NodoArbol nodo){
        int altura = 0;
        if (nodo != null){
            int alturaIzq = 1 + alturaRec(nodo.getIzquierdo());
            int alturaDer = 1 + alturaRec(nodo.getDerecho());
            altura = (alturaDer > alturaIzq)?alturaDer:alturaIzq;
        }
        return altura;
    }

    public void completar2Hijos(){completar2HijosRec(raiz, 1);}

    private void completar2HijosRec(NodoArbol nodo, int nivel){
        if (nodo != null){
           if (nodo.getIzquierdo() == null && nodo.getDerecho() != null){
               nodo.setIzquierdo(new NodoArbol(nivel + 1));
           }else if (nodo.getIzquierdo() != null && nodo.getDerecho() == null){
               nodo.setDerecho(new NodoArbol(nivel + 1));
           }
           completar2HijosRec(nodo.getDerecho(), nivel + 1);
           completar2HijosRec(nodo.getIzquierdo(), nivel + 1);
        }
    }

    public int sumarHojasNivel(int maxNivel){return sumarHojasNivelRec(raiz,maxNivel);}

    private int sumarHojasNivelRec(NodoArbol nodo, int maxNivel){
        int suma = 0;
        if (nodo != null){
            if (maxNivel >= 1) {
                if (nodo.getDerecho() == null && nodo.getIzquierdo() == null) {
                        suma = nodo.getDato();
                }
                suma += sumarHojasNivelRec(nodo.getIzquierdo(), maxNivel - 1);
                suma += sumarHojasNivelRec(nodo.getDerecho(), maxNivel - 1);
            }
        }
        return suma;
    }

    public void invertir(){invertirRec(raiz);}

    private void invertirRec(NodoArbol nodo){
        if (nodo != null) {
            NodoArbol aux = nodo.getIzquierdo();
            nodo.setIzquierdo(nodo.getDerecho());
            nodo.setDerecho(aux);
            invertirRec(nodo.getDerecho());
            invertirRec(nodo.getIzquierdo());
        }
    }

    public boolean esUnivaluado(){return esUnivaluadoRec(raiz, raiz.getDato());}

    private boolean esUnivaluadoRec(NodoArbol nodo, int valor){
        boolean univaluado = true;
        if (nodo != null) {
            if (nodo.getDerecho() != null && nodo.getDerecho().getDato() != valor || nodo.getIzquierdo() != null && nodo.getIzquierdo().getDato() != valor){
                univaluado = false;
            }else{
                univaluado = esUnivaluadoRec(nodo.getIzquierdo(), valor) && esUnivaluadoRec(nodo.getDerecho(), valor);
            }
        }
        return univaluado;
    }

    public boolean raizEsHojas(){return numHojas(raiz) == raiz.getDato();}


    private int numHojas(NodoArbol nodo){
        int num = 0;
        if (nodo != null){
            if (nodo.getIzquierdo() != null){
                num += numHojas(nodo.getIzquierdo());
            }if (nodo.getDerecho() != null){
                num += numHojas(nodo.getDerecho());
            }if (nodo.getDerecho() == null && nodo.getIzquierdo() == null){
                num = 1;
            }
        }
        return num;
    }



    public int suma() {
        return this.sumaRec(raiz);
    }

    private int sumaRec(NodoArbol nodo) {
        if (nodo == null) {
            return 0;
        } else {
            return nodo.getDato() + this.sumaRec(nodo.getIzquierdo()) + this.sumaRec(nodo.getDerecho());
        }
    }


    public void preOrdenNivel() {
        System.out.println("Preorden con niveles: ");
        preOrdenNivelRec(raiz, 1);
    }

    private void preOrdenNivelRec(NodoArbol nodo, int nivel) {
        if (nodo != null) {
            System.out.println(nodo.getDato() + " en el nivel " + nivel);
            preOrdenNivelRec(nodo.getIzquierdo(), nivel + 1);
            preOrdenNivelRec(nodo.getDerecho(), nivel + 1);
        }
    }

    public boolean sumaNiveles(int n1, int n2){return (n1 > n2)?sumaNivelesRec(n1, n2, raiz, 1) == 0:sumaNivelesRec(n2, n1, raiz, 1) == 0;}

    private int sumaNivelesRec(int mayor, int menor, NodoArbol nodo, int nivel){
        int suma = 0;
        if (nodo != null){
            if (nivel == menor){
                suma += nodo.getDato();
            }else if (nivel == mayor){
                suma -= nodo.getDato();
            }
            suma += sumaNivelesRec(mayor, menor, nodo.getDerecho(), nivel + 1);
            suma += sumaNivelesRec(mayor, menor, nodo.getIzquierdo(), nivel + 1);
        }
        return suma;
    }




}
