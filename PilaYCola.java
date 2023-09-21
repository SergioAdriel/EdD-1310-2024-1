import java.util.Scanner;

class Nodo {
    String dato;
    Nodo siguiente;

    public Nodo(String dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

public class PilaYCola {

    private Nodo pilaCima; // La cima de la pila
    private Nodo colaCabeza; // La cabeza de la cola
    private Nodo colaCola;   // La cola de la cola
    private boolean estructuraModificada; // Variable para rastrear cambios, para evitar errores tontos

    public PilaYCola() {
        this.pilaCima = null;
        this.colaCabeza = null;
        this.colaCola = null;
        this.estructuraModificada = false; // Inicialmente no se ha modificado
    }

    // Métodos para la pila (LIFO)
    public void push(String elemento) {
        Nodo nuevoNodo = new Nodo(elemento);
        if (pilaCima == null) {
            pilaCima = nuevoNodo;
        } else {
            nuevoNodo.siguiente = pilaCima;
            pilaCima = nuevoNodo;
        }
        estructuraModificada = true; // La estructura se ha modificado
        imprimirPilaSiModificada(); // Imprime si la estructura se ha modificado
    }

    public String pop() {
        if (pilaCima == null) {
            return null; // La pila está vacía
        } else {
            String elemento = pilaCima.dato;
            pilaCima = pilaCima.siguiente;
            estructuraModificada = true; // La estructura se ha modificado
            imprimirPilaSiModificada(); // Imprime si la estructura se ha modificado
            return elemento;
        }
    }

    public String peekPila() {
        if (pilaCima == null) {
            return null; // La pila está vacía
        } else {
            return pilaCima.dato;
        }
    }

    // Métodos para la cola (FIFO)
    public void enqueue(String elemento) {
        Nodo nuevoNodo = new Nodo(elemento);
        if (colaCola == null) {
            colaCabeza = nuevoNodo;
            colaCola = nuevoNodo;
        } else {
            colaCola.siguiente = nuevoNodo;
            colaCola = nuevoNodo;
        }
        estructuraModificada = true; // La estructura se ha modificado
        imprimirColaSiModificada(); // Imprime si la estructura se ha modificado
    }

    public String dequeue() {
        if (colaCabeza == null) {
            return null; // La cola está vacía
        } else {
            String elemento = colaCabeza.dato;
            colaCabeza = colaCabeza.siguiente;
            if (colaCabeza == null) {
                colaCola = null; // La cola está vacía después de quitar el último elemento
            }
            estructuraModificada = true; // La estructura se ha modificado
            imprimirColaSiModificada(); // Imprime si la estructura se ha modificado
            return elemento;
        }
    }

    public String peekCola() {
        if (colaCabeza == null) {
            return null; // La cola está vacía
        } else {
            return colaCabeza.dato;
        }
    }

    public boolean buscar(String elemento) {
        Nodo actual = pilaCima;
        while (actual != null) {
            if (actual.dato.equals(elemento)) {
                return true; // Elemento encontrado en la pila
            }
            actual = actual.siguiente;
        }

        actual = colaCabeza;
        while (actual != null) {
            if (actual.dato.equals(elemento)) {
                return true; // Elemento encontrado en la cola
            }
            actual = actual.siguiente;
        }

        return false; // Elemento no encontrado en la pila ni en la cola
    }

    // Método para buscar en la pila y mostrar el ID
    public void buscarElemento(String elemento) {
        int id = 0;
        Nodo actual = pilaCima;
        while (actual != null) {
            if (actual.dato.equals(elemento)) {
                System.out.println("Elemento encontrado en la pila con ID: " + id);
                return;
            }
            actual = actual.siguiente;
            id++;
        }

        System.out.println("Elemento no encontrado en la pila.");
    }

    // Método para buscar en la cola y mostrar el ID
    public void buscarElementoCola(String elemento) {
        int id = 0;
        Nodo actual = colaCabeza;
        while (actual != null) {
            if (actual.dato.equals(elemento)) {
                System.out.println("Elemento encontrado en la cola con ID: " + id);
                return;
            }
            actual = actual.siguiente;
            id++;
        }

        System.out.println("Elemento no encontrado en la cola.");
    }

    public void imprimirPilaSiModificada() {
        if (estructuraModificada) {
            System.out.println("\nPila (LIFO):");
            Nodo actual = pilaCima;
            while (actual != null) {
                System.out.println(actual.dato);
                actual = actual.siguiente;
            }
            System.out.println("--------");
            estructuraModificada = false; // La estructura se ha impreso
        }
    }

    public void imprimirColaSiModificada() {
        if (estructuraModificada) {
            System.out.println("\nCola (FIFO):");
            Nodo actual = colaCabeza;
            while (actual != null) {
                System.out.println(actual.dato);
                actual = actual.siguiente;
            }
            System.out.println("--------");
            estructuraModificada = false; // La estructura se ha impreso
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PilaYCola estructura = new PilaYCola();
        
        // Solicitar al usuario que ingrese elementos
        String Mantequilla = "        -.._       _-*\"`  \n" +             "           \\ '-._.*' <\"   \n" +"       _.--'          \"*-._  \n" +"    _-'             :''\"*--^- \n" +" -='.-*'.   _.-\"-.  '.    \",   \n" +"   /    ;.-'      '*-.'-.   \\  \n" +"  /    /'             '\"*-   \\ \n" +" ;                            : \n" +":        .*\"*-.  .-*\"*.        ;\n" +";       /      ;:      \\       : \n" +";      ;    *  !!  *    :      : \n" +":      :     .'  '.     ;      ; \n" +" ;      '-.-'      '-.-'      : \n" +"  \\                          /  \n" +"   \\                        /   \n" +"    '.                    .'    \n" +"     /'.      _.._      .' \\   \n" +"    /   '-.          .-'    \\  \n" +"   /       \"--.,,.--\"        \\ \n" +"  :    :        |        ;    ; \n" +"  |.--.;        |        :.--.| \n" +"  (   ()        |        ()   ) \n" +"   '--^_        |        _^--'  \n" +"      | \"'*--.._I_..--*'\" |     \n" +"      | __..._  | _..._   |     \n" +"     .\"'      `\"'     ''\"'.    \n" +"     \"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"";
        System.out.println(Mantequilla); // Al chile prof voy a irlos guardando
        System.out.println("Ingresa elementos (separados por comas), cuando finalice presione ENTER:");
        String input = scanner.nextLine();
        String[] elementos = input.split(",");
        for (String elemento : elementos) {
            elemento = elemento.trim();
            if (!elemento.isEmpty()) {
                estructura.push(elemento);
                estructura.enqueue(elemento);
            }
        }

        // Menú contextual para elegir entre Pila (LIFO) o Cola (FIFO)
        System.out.println("\nElije el tipo de operación:");
        System.out.println("1. Pila (LIFO)");
        System.out.println("2. Cola (FIFO)");
        int opcion = scanner.nextInt();

        // Menú contextual para los metodos de la pila y cola
        switch (opcion) {
            case 1:
                // Operaciones en la pila
                System.out.println("\nOperaciones en la pila (LIFO):");
                System.out.println("1. Push (Agregar elemento)");
                System.out.println("2. Pop (Sacar elemento)");
                System.out.println("3. Peek (Ver elemento en la cima)");
                System.out.println("4. Buscar elemento");
                int opcionPila = scanner.nextInt();

                switch (opcionPila) {
                    case 1:
                        scanner.nextLine(); 
                        System.out.println("Ingresa el elemento que deseas agregar:");
                        String elementoPush = scanner.nextLine();
                        estructura.push(elementoPush);
                        break;
                    case 2:
                        String elementoPop = estructura.pop();
                        if (elementoPop != null) {
                            System.out.println("Elemento sacado de la pila: " + elementoPop);
                        } else {
                            System.out.println("La pila está vacía.");
                        }
                        break;
                    case 3:
                        String elementoCima = estructura.peekPila();
                        if (elementoCima != null) {
                            System.out.println("Elemento en la cima de la pila: " + elementoCima);
                        } else {
                            System.out.println("La pila está vacía.");
                        }
                        break;
                    case 4:
                        scanner.nextLine(); 
                        System.out.println("Ingresa el elemento que deseas buscar:");
                        String elementoBuscar = scanner.nextLine();
                        estructura.buscarElemento(elementoBuscar);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
                break;

            case 2:
                // Operaciones en la cola
                System.out.println("\nOperaciones en la cola (FIFO):");
                System.out.println("1. Enqueue (Agregar elemento)");
                System.out.println("2. Dequeue (Quitar elemento)");
                System.out.println("3. Peek (Ver elemento en la cabeza)");
                System.out.println("4. Buscar elemento");
                int opcionCola = scanner.nextInt();

                switch (opcionCola) {
                    case 1:
                        scanner.nextLine(); 
                        System.out.println("Ingresa el elemento que deseas agregar:");
                        String elementoEnqueue = scanner.nextLine();
                        estructura.enqueue(elementoEnqueue);
                        break;
                    case 2:
                        String elementoDequeue = estructura.dequeue();
                        if (elementoDequeue != null) {
                            System.out.println("Elemento quitado de la cola: " + elementoDequeue);
                        } else {
                            System.out.println("La cola está vacía.");
                        }
                        break;
                    case 3:
                        String elementoCabeza = estructura.peekCola();
                        if (elementoCabeza != null) {
                            System.out.println("Elemento en la cabeza de la cola: " + elementoCabeza);
                        } else {
                            System.out.println("La cola está vacía.");
                        }
                        break;
                    case 4:
                        scanner.nextLine(); // Consumir el carácter de nueva línea pendiente
                        System.out.println("Ingresa el elemento que deseas buscar:");
                        String elementoBuscarCola = scanner.nextLine();
                        estructura.buscarElementoCola(elementoBuscarCola);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
                break;
            default:
                System.out.println("Opción no válida. LIFO ó FIFO.");
        }
        scanner.close();
        System.out.println("\nAhí nos vidrios ;)");
    }
}
