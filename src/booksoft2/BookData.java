package booksoft2;
import java.util.Scanner;
/**
 *
 * @author USER
 */
public class BookData {
  private String nombre;
  private String autor;
  private String year;
  private String codigo;
  private int cantidad;
  private String area;
  private String[] areas =new String[10];

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String[] getAreas() {
        return areas;
    }

    public void setAreas(String[] areas) {
        this.areas = areas;
    }
  
    public void setAreas(){
        this.areas[0]="Quimica";
        this.areas[1]="Fisica";
        this.areas[2]="Tecnologia";
        this.areas[3]="Calculo";
        this.areas[4]="Programacion";
    }
 

    public void LoadBook(){
        Scanner teclado = new Scanner(System.in);
        this.setAreas();
        System.out.println("Ingrese el Nombre del libro: "); nombre=teclado.nextLine();
        teclado.nextLine();
        System.out.println("Ingrese el Autor : "); autor=teclado.nextLine();
        System.out.println("Ingrese el Año de publicacion : "); year=teclado.nextLine();
        System.out.println("Ingrese el NUMERO del Codigo : "); codigo=teclado.nextLine();
        System.out.println("Ingrese la cantidad de libros : "); cantidad=teclado.nextInt();
        System.out.println("Ingrese NUMERO del Area :\n1.Quimica\n2.Fisica\n3.Tecnologia\4.Calculo\n5.Programacion "); 
        int temp=teclado.nextInt();
        if(temp<=5 || temp >=1){
        area=areas[temp-1];
        }
        else{ System.out.println("Area se almaceno como Diferente");
        area="diferente";
        }
        
    }
    public void ShowBook(){
        System.out.println("Nombre del libro: "+nombre);
        System.out.println("Autor: "+autor);
        System.out.println("Año: "+year);
        System.out.println("Codigo: "+codigo);
        System.out.println("Autor: "+autor);
        System.out.println("Cantidad disponible: "+cantidad);
        System.out.println("Area: "+area);
    }    
   
}