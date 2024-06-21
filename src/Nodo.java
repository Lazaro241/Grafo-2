import java.util.LinkedList;
public class Nodo {
    private int valor;
    private int numvertice;
    private LinkedList<Nodo> listaAdy;
    public int getValor() {
        return this.valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public int getNumVertice() {
        return this.numvertice;
    }
    public void addAdy(Nodo nuevo){
        listaAdy.add(nuevo);
    }
    public LinkedList<Nodo> getAdy(){
        return this.listaAdy;
    }
    public void setNumVertice(int numero) {
        this.numvertice = numero;
    }
    public void setAdyacente(Nodo siguiente){
        this.listaAdy.add(siguiente);
    }
    public boolean buscarAdyacencia(Nodo posible){
        return listaAdy.contains(posible);
    }
    public Nodo(int valor){
        this.valor=valor;
        this.numvertice=-1;
        listaAdy=new LinkedList<>();
    }
}
