public class Pruebas {
    public static void main(String[] args){
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();
        arbol.insertar(new Alumno("", 50, 0));
        arbol.insertar(new Alumno("", 25, 0));
        arbol.insertar(new Alumno("", 75, 0));
        arbol.insertar(new Alumno("", 60, 0));
        arbol.insertar(new Alumno("", 90, 0));
        arbol.insertar(new Alumno("", 58, 0));
        arbol.insertar(new Alumno("", 64, 0));
        arbol.insertar(new Alumno("", 59, 0));
        arbol.insertar(new Alumno("", 40, 0));
        arbol.insertar(new Alumno("", 15, 0));
        arbol.insertar(new Alumno("", 32, 0));
        arbol.insertar(new Alumno("", 45, 0));
        arbol.insertar(new Alumno("", 43, 0));
        arbol.insertar(new Alumno("", 21, 0));
        arbol.insertar(new Alumno("", 13, 0));
        arbol.insertar(new Alumno("", 11, 0));
        arbol.insertar(new Alumno("", 14, 0));
        arbol.insertar(new Alumno("", 10, 0));
        System.out.println(arbol.suPutaMadre(34));
        arbol.mostrarClavesDescendente();
        System.out.println();
        arbol.mostarClavesUnSoloHijo();
        System.out.println();
        arbol.mostrarClaveEntreDos(34, 90);
        System.out.println();
        System.out.println(arbol.comprobarSiEnHoja(59));
        System.out.println(arbol.comprobarSiEnHoja(40));
        System.out.println(arbol.comprobarSiEnHoja(10));
        System.out.println(arbol.comprobarSiEnHoja(68));
        System.out.println(arbol.comprobarSiEnHoja(90));
        System.out.println(arbol.comprobarSiEnHoja(14));
        System.out.println(arbol.antecesoresComunes(13, 10));
        System.out.println(arbol.antecesoresComunes(14, 10));
        System.out.println(arbol.diferenciaNiveles(25, 45));
        System.out.println(arbol.diferenciaNiveles(13, 59));
        System.out.println(arbol.diferenciaNiveles(11, 43));
        System.out.println(arbol.getElementoMasCercano(20).getMatricula());



    }
}
