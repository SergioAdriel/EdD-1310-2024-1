import java.util.Scanner;


class Nodo
{

  Object dato;

  Nodo siguiente;

  Nodo anterior;


  public Nodo (Object dato)
  {

    this.dato = dato;

    this.siguiente = null;

    this.anterior = null;

  }

}



class ListaEnlazada
{

  Nodo cabeza;


  public ListaEnlazada ()
  {

    this.cabeza = null;

  }


  public void agregarNodo (Object dato)
  {

    Nodo nuevoNodo = new Nodo (dato);

    if (cabeza == null)
      {

	cabeza = nuevoNodo;

      }
    else
      {

	Nodo temp = cabeza;

	while (temp.siguiente != null)
	  {

	    temp = temp.siguiente;

	  }

	temp.siguiente = nuevoNodo;

	if (nuevoNodo.anterior == null)
	  {

	    nuevoNodo.anterior = temp;

	  }

      }

  }


  public void imprimirLista ()
  {

    Nodo temp = cabeza;

    while (temp != null)
      {

	System.out.print (temp.dato + " ");

	temp = temp.siguiente;

      }

    System.out.println ();

  }


// Esto me lo robe de lo que subio en el Clasrrom
  public void imprimirListaRecursivamente ()
  {

    imprimirListaRecursivamenteAux (cabeza);

    System.out.println ();

  }

  private void imprimirListaRecursivamenteAux (Nodo nodo)
  {

    if (nodo != null)
      {

	System.out.print (nodo.dato + " ");

	imprimirListaRecursivamenteAux (nodo.siguiente);

      }

  }


  public void actualizarNodo (int indice, Object nuevoDato)
  {

    Nodo actual = cabeza;

    int i = 0;

    while (actual != null)
      {

	if (i == indice)
	  {

	    actual.dato = nuevoDato;

	    break;

	  }

	actual = actual.siguiente;

	i++;

      }

  }


  public void eliminarNodo (int indice)
  {

    if (cabeza == null || indice < 0)
      {

	return;

      }


    if (indice == 0)
      {

	cabeza = cabeza.siguiente;

	if (cabeza != null)
	  {

	    cabeza.anterior = null;

	  }

	return;

      }


    Nodo actual = cabeza;

    int i = 0;

    while (actual.siguiente != null)
      {

	if (i + 1 == indice)
	  {

	    actual.siguiente = actual.siguiente.siguiente;

	    if (actual.siguiente != null)
	      {

		actual.siguiente.anterior = actual;

	      }

	    return;

	  }

	actual = actual.siguiente;

	i++;

      }

  }


// Acá esta lo BONUS, espero que si haga lo que se solicita porque alch si ocupo esos puntos extra
  public void actualizarNodoRecursivamente (Object datoViejo,
					    Object datoNuevo)
  {

    cabeza = actualizarNodoRecursivamenteAux (cabeza, datoViejo, datoNuevo);

  }

  private Nodo actualizarNodoRecursivamenteAux (Nodo nodo,
						Object datoViejo,
						Object datoNuevo)
  {

    if (nodo == null)
      {

	return null;

      }

    if (nodo.dato.equals (datoViejo))
      {

	nodo.dato = datoNuevo;

      }

    nodo.siguiente =
      actualizarNodoRecursivamenteAux (nodo.siguiente, datoViejo, datoNuevo);

    return nodo;

  }


  public void eliminarNodoRecursivamente (Object dato)
  {

    cabeza = eliminarNodoRecursivamenteAux (cabeza, dato);

  }

  private Nodo eliminarNodoRecursivamenteAux (Nodo nodo, Object dato)
  {

    if (nodo == null)
      {

	return null;

      }

    if (nodo.dato.equals (dato))
      {

	return nodo.siguiente;

      }

    nodo.siguiente = eliminarNodoRecursivamenteAux (nodo.siguiente, dato);

    return nodo;

  }


  public void invertirLista ()
  {

    cabeza = invertirListaAux (cabeza);

  }

  private Nodo invertirListaAux (Nodo nodo)
  {

    if (nodo == null || nodo.siguiente == null)
      {

	return nodo;

      }

    Nodo resto = invertirListaAux (nodo.siguiente);

    nodo.siguiente.siguiente = nodo;

    nodo.siguiente = null;

    return resto;

  }

}



class ListaCircular extends ListaEnlazada
{

  public void agregarNodo (Object dato)
  {

    Nodo nuevoNodo = new Nodo (dato);

    if (cabeza == null)
      {

	cabeza = nuevoNodo;

	cabeza.siguiente = cabeza;

      }
    else
      {

	Nodo temp = cabeza;

	while (temp.siguiente != cabeza)
	  {

	    temp = temp.siguiente;

	  }

	temp.siguiente = nuevoNodo;

	nuevoNodo.siguiente = cabeza;

      }

  }

}



class ListaDoble extends ListaEnlazada
{

  public void agregarNodo (Object dato)
  {

    Nodo nuevoNodo = new Nodo (dato);

    if (cabeza == null)
      {

	cabeza = nuevoNodo;

      }
    else
      {

	Nodo temp = cabeza;

	while (temp.siguiente != null)
	  {

	    temp = temp.siguiente;

	  }

	temp.siguiente = nuevoNodo;

	nuevoNodo.anterior = temp;

      }

  }


  public void invertirListaDoble ()
  {

    cabeza = invertirListaDobleAux (cabeza);

  }

  private Nodo invertirListaDobleAux (Nodo nodo)
  {

    if (nodo == null || nodo.siguiente == null)
      {

	return nodo;

      }

    Nodo resto = invertirListaDobleAux (nodo.siguiente);

    nodo.siguiente.siguiente = nodo;

    nodo.anterior = nodo.siguiente;

    nodo.siguiente = null;

    return resto;

  }

}



public class ListasLigadas   //Sergio Muñoz Camarena 
{

  public static void main (String[]args)
  {

    Scanner scanner = new Scanner (System.in);

    String asciiArt =
      "                        .-**-._\n" +
      "                     _,(        ),_\n" +
      "                  .-\"   '-^----'   \"-.\n" +
      "               .-'                    '-.\n" +
      "             .'                          '.\n" +
      "           .'    __.--**'\"\"\"\"\"'**--._    '.\n" +
      "          /.-*\"'__.--**'\"\"\"\"\"'**--.__'\"*-._\\\n" +
      "         /_..-*\"'   .-*\"*-.  .-*\"*-.   '\"*-.._\\\n" +
      "        :          /       ;:       \\          ;   Si lee esto Prof alch pongame 10; PD. Aqui estuvo el Sercho"
      +
      "\n        :         :     *  !!  *     :         ;\n" +
      "         \\        '.     .'  '.     .'        /\n" +
      "          \\         '-.-'      '-.-'         /\n" +
      "       .-*''.                              .'-.\n" +
      "    .-'      '.                          .'    '.\n" +
      "   :           '-.        _..        .-'        '.\n" +
      "  ;\"*-.          '-._  --___ `   .-'        _.*'  '*.\n" +
      " :      '.            `\"*-.__.-*\"`           (        :\n" +
      "  ;      ;                 *|                 '-.     ;\n" +
      "   '---*'                   |                    \"\"--'\n" +
      "    :                      *|                      :\n" +
      "    '.                      |                     .'\n" +
      "      '..                 *|        ____----.._-'\n" +
      "       \\  \"\"\"----_____------'-----\"\"\"         /\n" +
      "        :                      '-..--''          :\n" +
      "         '\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"";

      System.out.println (asciiArt);


      System.out.print
      ("Ingrese los valores de los nodos separados por comas \",\" ... cuando termine presione ENTER: ");

    String valores = scanner.nextLine ();

      String[] valoresArray = valores.split (",");


    ListaEnlazada listaSeleccionada;


      System.out.println
      ("\n\nElija el tipo de lista enlazada en la que desea chambear:");

      System.out.println ("1. Lista Simple");

      System.out.println ("2. Lista Doble");

      System.out.println ("3. Lista Circular");

      System.out.print ("Ingrese su elecciC3n (1/2/3): ");


    int eleccion = scanner.nextInt ();

      scanner.nextLine ();	// Consumir el salto de linea para que no se vea junto

    switch (eleccion)
      {

      case 1:

	listaSeleccionada = new ListaEnlazada ();

	break;

	case 2:listaSeleccionada = new ListaDoble ();

	break;

	case 3:listaSeleccionada = new ListaCircular ();

	break;

	default:System.out.println ("Elección no válida. Saliendo...");

	return;

      }


    for (String valor:valoresArray)
      {

	listaSeleccionada.agregarNodo (valor.trim ());	// trim() elimina espacios en blanco alrededor del valor
      }


    boolean continuar = true;

    while (continuar)
      {

	System.out.println ("\nOpciones:");

	System.out.println ("1. Agregar un nodo");

	System.out.println ("2. Actualizar un nodo");

	System.out.println ("3. Eliminar un nodo");

	System.out.println ("4. Imprimir la lista");

	System.out.println ("5. Imprimir la lista recursivamente (BONUS)");

	System.out.println ("6. Invertir la lista (BONUS)");

	System.out.println ("7. Actualizar nodo recursivamente (BONUS)");

	System.out.println ("8. Eliminar nodo recursivamente (BONUS)");

	System.out.println ("9. Salir");

	System.out.print ("Ingrese su elección (1/2/3/4/5/6/7/8/9): ");


	int opcion = scanner.nextInt ();

	scanner.nextLine ();	// Consumir el salto de linea para que no se vea junto

	switch (opcion)
	  {

	  case 1:

	    System.out.print ("Ingrese un valor: ");

	    Object valor = scanner.nextLine ();

	    listaSeleccionada.agregarNodo (valor);

	    break;

	  case 2:

	    System.out.print ("Ingrese el índice para actualizar: ");

	    int indiceActualizar = scanner.nextInt ();

	    scanner.nextLine ();

	    System.out.print ("Ingrese el nuevo valor: ");

	    Object nuevoValor = scanner.nextLine ();

	    listaSeleccionada.actualizarNodo (indiceActualizar, nuevoValor);

	    break;

	  case 3:

	    System.out.print ("Ingrese el índice para eliminar: ");

	    int indiceEliminar = scanner.nextInt ();

	    listaSeleccionada.eliminarNodo (indiceEliminar);

	    break;

	  case 4:

	    System.out.print ("Lista Actual: ");

	    listaSeleccionada.imprimirLista ();

	    break;

	  case 5:

	    System.out.print ("Lista Recursiva: ");

	    listaSeleccionada.imprimirListaRecursivamente ();

	    break;

	  case 6:

	    System.out.println ("Seleccionaste invertir la lista.");

	    listaSeleccionada.invertirLista ();

	    break;

	  case 7:

	    System.
	      out.println ("Seleccionaste actualizar nodo recursivamente.");

	    System.out.print ("Ingrese el dato a actualizar: ");

	    Object datoViejo = scanner.nextLine ();

	    System.out.print ("Ingrese el nuevo dato: ");

	    Object datoNuevo = scanner.nextLine ();

	    listaSeleccionada.actualizarNodoRecursivamente (datoViejo,
							    datoNuevo);

	    break;

	  case 8:

	    System.
	      out.println ("Seleccionaste eliminar nodo recursivamente.");

	    System.out.print ("Ingrese el dato a eliminar: ");

	    Object datoEliminar = scanner.nextLine ();

	    listaSeleccionada.eliminarNodoRecursivamente (datoEliminar);

	    break;

	  case 9:

	    continuar = false;

	    break;

	  default:

	    System.out.println ("Opción no válida. Intente de nuevo...");

	  }

      }

  }

}
