import java.util.Scanner;
public class Main {
    public static void menu(){
        System.out.println("MENU DE OPCIONES");
        System.out.println("1. Añadir un vértice");
        System.out.println("2. Añadir una arista");
        System.out.println("3. Recorrer en anchura");
        System.out.println("4. Ver grafo(Listas de adyacencia)");
        System.out.println("5. Salir");
    }
    public static void aniadirVertice( Grafo g, Scanner s) throws Exception{
        System.out.println("Ingrese el valor del nuevo vértice.");
        int valor = s.nextInt();
        g.addNodo(valor);      
    }
    public static void aniadirArista(Grafo g, Scanner s) throws Exception{
        int salida, entrada;
        g.imprimirListaDeVertices();
        System.out.println("Ingrese el valor del vértice de salida o ida de la arista");
        salida= s.nextInt();
        System.out.println(("Ingrese el valor del vértice de entrada o llegada de la arista"));
        entrada = s.nextInt();
        g.addArista(salida, entrada);
    }
    public static void recorrerGrafoProfundidad (Grafo g, Scanner s)throws Exception{
        System.out.println("Ingrese el valor del vertice de origen del recorrido");
        g.imprimirListaDeVertices();
        int valor= s.nextInt();
        g.recorridoProfundidad(valor);
    }
    public static void mostrarListasDeAdyacencia(Grafo g)throws Exception{
        g.imprimirListasAd();
    }
    public static void main(String[] args) throws Exception {
        int menu=0;
        Scanner teclado = new Scanner(System.in);
        Grafo g = new Grafo();
        do{
            menu();
            menu=teclado.nextInt();
            try {
                switch(menu){
                    case 1:
                        aniadirVertice(g, teclado);
                        break;
                    case 2:
                        aniadirArista(g, teclado);
                        break;
                    case 3:
                        recorrerGrafoProfundidad(g, teclado);
                        break;
                    case 4:
                        mostrarListasDeAdyacencia(g);
                        break;
                    case 5:
                        System.out.println("Fin del programa");
                        break;
                    default:
                        System.out.println("Opción inválida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: "+e.getMessage());
            }
            
        }while(menu!=5);
    }
}
