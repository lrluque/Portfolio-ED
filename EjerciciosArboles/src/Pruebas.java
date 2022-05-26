
public class Pruebas {


    public static void main(String[] args) {
        Arbol arbol9 = new Arbol(9);
        Arbol arbol15 = new Arbol(15);
        Arbol arbol4 = new Arbol(4, arbol9, arbol15);
        Arbol arbol5 = new Arbol(5);
        Arbol arbol2 = new Arbol(2, arbol4, arbol5);
        Arbol arbol8 = new Arbol(8);
        Arbol arbol7 = new Arbol(7);
        Arbol arbol3 = new Arbol(3, arbol8, arbol7);
        Arbol arbol = new Arbol(1, arbol2, arbol3);

        arbol.preOrden();
        arbol.ordenCentral();
        arbol.postOrden();
        arbol.amplitud();
        arbol.amplitud2();
        System.out.println("Está el valor valor 5?: " + arbol.contiene(5));
        System.out.println("Está el valor valor 51?: " + arbol.contiene(51));
        System.out.println("Es hoja el valor 2? " + arbol.contieneEnHoja(2));
        System.out.println("Es hoja el valor 9? " + arbol.contieneEnHoja(9));
        System.out.println("Es hoja el valor 15? " + arbol.contieneEnHoja(15));
        System.out.println("Es hoja el valor 8? " + arbol.contieneEnHoja(8));
        System.out.println("Es hoja el valor 2? " + arbol.contieneEnHoja(2));
        System.out.println("Es hoja el valor 4? " + arbol.contieneEnHoja(4));
        System.out.println("Es hoja el valor 7? " + arbol.contieneEnHoja(7));
        System.out.println("Es hoja el valor 3? " + arbol.contieneEnHoja(3));
        System.out.println("Es hoja el valor 5? " + arbol.contieneEnHoja(5));
        System.out.println("Suma de los nodos: " + arbol.suma());
        System.out.println("Numero de hojas: " + arbol.numHojas());
        System.out.println("Suma de los nodos impares: " + arbol.sumaDatosImparesDosHijos());
        System.out.println("Son iguales el arbol 1 y 2?: " + arbol.esIgual(arbol2));
        System.out.println("Son iguales el arbol 2 y 1?: " + arbol2.esIgual(arbol));
        System.out.println("Son iguales el arbol 1 y 1?: " + arbol.esIgual(arbol));
        System.out.println("Son iguales el arbol 2 y 2?: " + arbol2.esIgual(arbol2));
        System.out.println("Suma de nodos del nivel 2: " + arbol.sumaDatosNivel(4));
        System.out.println("Altura del árbol: " + arbol.altura());

        Arbol arbol20 = new Arbol(20);
        Arbol arbol25 = new Arbol(25, arbol20, null);
        Arbol arbol10 = new Arbol(10);
        Arbol arbol152 = new Arbol(15, arbol10, arbol25);
        Arbol arbol90 = new Arbol(90);
        Arbol arbol80 = new Arbol(80, null, arbol90);
        Arbol arbol60 = new Arbol(60, null, arbol80);
        Arbol arbol40 = new Arbol(40, arbol152, arbol60);

        arbol40.preOrdenNivel();
        arbol40.completar2Hijos();
        arbol40.preOrdenNivel();

        System.out.println("Suma de hojas del nivel 1: " + arbol.sumarHojasNivel(1));
        System.out.println("Suma de hojas del nivel 2: " + arbol.sumarHojasNivel(2));
        System.out.println("Suma de hojas del nivel 3: " + arbol.sumarHojasNivel(3));
        System.out.println("Suma de hojas del nivel 4: " + arbol.sumarHojasNivel(4));
        System.out.println("Suma de hojas del nivel 15: " + arbol.sumarHojasNivel(15));
        System.out.println("Suma de hojas del nivel 3 del arbol 2: " + arbol2.sumarHojasNivel(3));

        arbol.preOrden();
        arbol.invertir();
        arbol.preOrden();

        System.out.println(arbol.esUnivaluado());

        Arbol arbol201 = new Arbol(1);
        Arbol arbol251 = new Arbol(1, arbol201, null);
        Arbol arbol101 = new Arbol(1);
        Arbol arbol1521 = new Arbol(1, arbol101, arbol251);
        Arbol arbol901 = new Arbol(1);
        Arbol arbol801 = new Arbol(1, null, arbol901);
        Arbol arbol601 = new Arbol(1, null, arbol801);
        Arbol arbol401 = new Arbol(1, arbol1521, arbol601);

        System.out.println(arbol401.esUnivaluado());

        System.out.println(arbol.raizEsHojas());

        System.out.println(arbol.sumaNiveles(4, 3));

    }

}

