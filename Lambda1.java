import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Productos{
    static  Integer IDIncremet = 0;
    Integer ID;
    private String nombre;
    private double precio;

    public Productos(String nombre, double precio){
        this.ID = ++IDIncremet;
        this.setPrecio(precio);
        this.setNombre(nombre);
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;

    }

    public double getPrecio(){
        return this.precio;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Productos{"+ID +" "+
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}

class ListProductos{
    List<Productos> producto = new ArrayList<>();

    public ListProductos(){

    }

    public ListProductos(Productos productos){
        this.setListProdcutos(productos);
    }

    public void setListProdcutos(Productos productos){
        this.producto.add(productos);
    }

    public List<Productos> getListProductos(){
        return this.producto;
    }

    public void  MostrarDatos(){
        this.getListProductos().forEach(System.out::println);

    }


}

class Clientes{
    private static Integer IDIncremental = 0;
    private Integer ID;
    private String nombre;

    public Clientes() {
    }

    public Clientes(String nombre) {

        this.ID = ++IDIncremental;
        this.nombre = nombre;
    }

    public static Integer getIDIncremental() {
        return IDIncremental;
    }


    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "ID=" + ID +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

class ListaClientes{
  private   List<Clientes> listaClientes = new ArrayList<>();

    public ListaClientes() {
    }

    public ListaClientes(Clientes clientes) {
        this.setListaClientes(clientes);
    }

    public List<Clientes> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(Clientes clientes) {
        this.listaClientes.add(clientes);
    }

    public void mostrarClientes(){
        this.getListaClientes().forEach(x-> System.out.println(x));
    }
}

class Factura{
    private Clientes clientes;
    List<Productos> ProdcutosComrpados = new ArrayList<>();

    public Factura(Clientes clientes) {
        this.clientes = clientes;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public List<Productos> getProdcutosComrpados() {
        return ProdcutosComrpados;
    }

    public void setProdcutosComrpados(Productos prodcutosComrpados) {
        ProdcutosComrpados.add(prodcutosComrpados);
    }

    public double totalFactura(){
        return this.getProdcutosComrpados().stream().mapToDouble(Productos::getPrecio).sum();
    }

    public void mostrarFactura(){

        System.out.println("\n🧾 Factura para: " + clientes.getNombre());
        System.out.println("----------------------------------");
        this.getProdcutosComrpados().forEach(System.out::println);
        System.out.println("----------------------------------");
        System.out.println("Total a pagar: $" + this.totalFactura());
    }
}



public class CarritoLambda {
    public static void main(String[] args) {
        ListProductos lista1 = new ListProductos();
        lista1.setListProdcutos(new Productos("Computador",2500000));
        lista1.setListProdcutos(new Productos("Teclado",130000));
        lista1.setListProdcutos(new Productos("Mouse",100000));

        Clientes cl1 = new Clientes("Juan");


        ListaClientes clientes = new ListaClientes();

        clientes.setListaClientes(cl1);
        clientes.setListaClientes(new Clientes("Maria"));
        clientes.setListaClientes(new Clientes("Sofia"));
        clientes.setListaClientes(new Clientes("Pedro"));

        Factura f1 = new Factura(cl1);
        Factura f2 = new Factura(clientes.getListaClientes().get(0));
        Factura f3 = new Factura(clientes.getListaClientes().get(1));

        // se agrega a la factura el producto
        f1.setProdcutosComrpados(lista1.getListProductos().get(0));
        f1.setProdcutosComrpados(lista1.getListProductos().get(1));

        f2.setProdcutosComrpados(lista1.getListProductos().get(1));
        f2.setProdcutosComrpados(lista1.getListProductos().get(2));

        f3.setProdcutosComrpados(lista1.getListProductos().get(2));
        f3.setProdcutosComrpados(lista1.getListProductos().get(0));



        System.out.println("Producotos");
        lista1.MostrarDatos();
        System.out.println(".....................................\n");
        System.out.println("Clientes");
        clientes.mostrarClientes();
        System.out.println(".....................................\n");
        System.out.println("Facturas");
        f1.mostrarFactura();
        f2.mostrarFactura();
        f3.mostrarFactura();






    }
}
