import java.util.LinkedList;
import java.util.Stack;
public class Grafo {
    private int numNodos;
    private LinkedList<Nodo> nodos;

    public Grafo() {
        this.numNodos=0;
        nodos=new LinkedList<>();
    }
    public void imprimirListaDeVertices() throws Exception{
        if(this.nodos==null) throw new Exception("Grafo vacio, no se han introducido vertices aun");
        for(int i=0; i<this.nodos.size();i++){
            System.out.print(this.nodos.get(i).getValor());
            if(i+1<this.nodos.size()){
                System.out.print(", ");
            }
        }
        System.out.println();
    }
    public void imprimirListasAd()throws Exception{
        Nodo actual; LinkedList<Nodo> adyActual;
        if(this.nodos==null) throw new Exception("Grafo vacio, no se han introducido vertices aun");
        for(int i=0;i<this.nodos.size();i++){
            actual=this.nodos.get(i);
            adyActual=actual.getAdy();
            System.out.print("Vertice "+actual.getValor());
            for(int j=0;j<adyActual.size();j++){
                System.out.print(" -> Vertice "+adyActual.get(j).getValor());
                }
            System.out.println();
        } 
    }
    public int encontrarNodo(int valor) throws Exception{
        int resultado = -1;
        if(this.nodos==null) throw new Exception("Grafo vacio, no se han introducido vertices aun");
        for(int i=0;i<this.nodos.size();i++){
           if(this.nodos.get(i).getValor()==valor){
            resultado = i;
            return resultado;
            }
        }
        return resultado;
    }
    public void addNodo(int valor) throws Exception{
        try{
         if(encontrarNodo(valor)!=-1){
                throw new Exception("Nodo ya existente");
            }
            else{
                Nodo nuevo = new Nodo(valor);
                this.nodos.add(nuevo);
                this.numNodos++;
            }   
        } catch(Exception e){
            if(e.getMessage().equals("Nodo ya existente")){
                throw e;
            } else {
                Nodo nuevo = new Nodo(valor);
                this.nodos.add(nuevo);
                this.numNodos++;
            }
        } 
    }
    public void addArista(int valorSalida, int valorEntrada)throws Exception{
        int salida = encontrarNodo(valorSalida);
        int entrada = encontrarNodo(valorEntrada);
        try {
            if(entrada==-1||salida==-1){
                throw new Exception("Uno o ambos vertices ingresados no existen");
            }
            if(entrada==salida){
                throw new Exception("Se intento crear un lazo");
            }
            Nodo a = this.nodos.get(entrada);
            Nodo b = this.nodos.get(salida);
            a.getAdy().add(b);
            } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        
    }
    public void recorridoProfundidad(int valorOrigen) throws Exception{
        int v, w;
        Nodo nodo;
        try{
            v=encontrarNodo(valorOrigen);
            if(v==-1) throw new Exception("Nodo de origen no existente");
            boolean[] visitados = new boolean[this.numNodos];
            visitados[v]=true;
            Stack<Integer> pila = new Stack<>();
            pila.push(v);
            while(!pila.isEmpty()){
                w=pila.pop();
                nodo=this.nodos.get(w);
                System.out.println("Vertice n° "+nodo.getValor());
                for (int i=0;i<this.nodos.size();i++){
                    if((nodo.buscarAdyacencia(this.nodos.get(i))) && visitados[i]==false){
                        pila.push(i);
                        visitados[i]=true;
                    }
                }
            }
        } catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
}
