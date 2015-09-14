/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksoft2;

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class BookSoft2 {
   public String localhost="jdbc:mysql://localhost/booksoft";
   //public String localhost="jdbc:mysql://db4free.net/booksoft";
   public  String user = "root";
   public  String password="";
   //public  String user = "alejolayaasdf";
   //public  String password="dw9puxac8rE7a";
public void ListarLibros(){
    
     
     String name;

     Scanner teclado= new Scanner(System.in);
     
        try {
            System.out.println("Intentando conectar a la BD. . . ");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(this.localhost, this.user, this.password);
            //Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net/contactos_asdf", user2, password2);
            System.out.println("Concexión exitosa...");
            Statement estado = con.createStatement();
            //Cargar todos los contactos******************************************************************************************
            ResultSet resultado= estado.executeQuery("SELECT * FROM `books`");
           
            while(resultado.next()){
                System.out.println(resultado.getString("idbook")+"\t"+resultado.getString("name"));
            }
            //********************************************************************************************************************

        }catch(SQLException ex){
        System.out.println("Error de mysql");
        }
        catch(Exception e){
        System.out.println("Se ha encontrado un error que es:"+e.getMessage());
        }   
        
}
public void IngresarLibro(){


     Scanner teclado= new Scanner(System.in);
     
        try {
            System.out.println("Intentando conectar a la BD. . . ");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(this.localhost, this.user, this.password);
            //Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net/contactos_asdf", user2, password2);
            System.out.println("Concexión exitosa...");
            Statement estado = con.createStatement();
            //ingresar contacto******************************************************************************************
             
            System.out.println("Ingrese el Nombre del libro: "); String nombre=teclado.nextLine();
           // teclado.nextLine();
            System.out.println("Ingrese el Autor : "); String autor=teclado.nextLine();
            System.out.println("Ingrese el Año de publicacion : "); String year=teclado.nextLine();
            System.out.println("Ingrese el NUMERO del Codigo : "); String codigo=teclado.nextLine();
            System.out.println("Ingrese la cantidad de libros : "); int cantidad=teclado.nextInt();
            String area;
            String[] areas ={"Quimica","Física","Tecnologia","Cálculo","Programación"};
            int temp;
            do{System.out.println("Ingrese NUMERO del Area :\n1.Quimica\n2.Fisica\n3.Tecnologia\n4.Calculo\n5.Programacion ");
            temp=teclado.nextInt();
            area=areas[temp-1];
            }while(temp<1 && temp>5);
            estado.executeUpdate("INSERT INTO `books` VALUES (NULL,'"+nombre+"','"+autor+"','"+year+"','"+codigo+"','"+cantidad+"','"+area+"')");
            System.out.println("Libro ingresado con exito");
            ResultSet resultado= estado.executeQuery("SELECT * FROM `books` WHERE `name` LIKE '"+nombre+"'");
           
            while(resultado.next()){
                System.out.println(resultado.getString("idbook")+"\t"+resultado.getString("name")+"\t"+resultado.getString("author")+"\t"+resultado.getString("year")+"\t"+resultado.getString("code")+"\t"+resultado.getString("lot")+"\t"+resultado.getString("area"));
            }
            //********************************************************************************************************************

        }catch(SQLException ex){
        System.out.println("Error de mysql");
        }
        catch(Exception e){
        System.out.println("Se ha encontrado un error que es:"+e.getMessage());
        }   
        
}
public void ActulizarLibro(){

     Scanner teclado= new Scanner(System.in);
     
        try {
            System.out.println("Intentando conectar a la BD. . . ");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(this.localhost, this.user, this.password);
            //Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net/contactos_asdf", user2, password2);
            System.out.println("Concexión exitosa...");
            Statement estado = con.createStatement();
            //ingresar libro para sacar id*****************************************************************************************
            System.out.println("Cual es el nombre del libro que desea actualizar?");
            String aux= teclado.nextLine();
            ResultSet resultado= estado.executeQuery("SELECT * FROM `books` WHERE `name` LIKE '"+aux+"'");
            if(resultado.next()){
                resultado.beforeFirst();
            while(resultado.next()){
                System.out.println("id\tNombre\t\tAutor\tAño\tCodigo\tCantidad\tArea");
                System.out.println(resultado.getString("idbook")+"\t"+resultado.getString("name"));
            String aux2=resultado.getString("idbook");
            //teclado.nextLine();
            System.out.println("Ingrese el Nombre del libro: "); String nombre=teclado.nextLine();
           // teclado.nextLine();
            System.out.println("Ingrese el Autor : "); String autor=teclado.nextLine();
            System.out.println("Ingrese el Año de publicacion : "); String year=teclado.nextLine();
            System.out.println("Ingrese el NUMERO del Codigo : "); String codigo=teclado.nextLine();
            System.out.println("Ingrese la cantidad de libros : "); int cantidad=teclado.nextInt();
            String area;
            String[] areas ={"Quimica","Física","Tecnologia","Cálculo","Programación"};
            int temp;
            do{System.out.println("Ingrese NUMERO del Area :\n1.Quimica\n2.Fisica\n3.Tecnologia\n4.Calculo\n5.Programacion ");
            temp=teclado.nextInt();
            area=areas[temp-1];
            }while(temp<1 && temp>5);
            
            estado.executeUpdate("UPDATE `booksoft`.`books` SET `name` = '"+nombre+"',`author` = '"+autor+"',`year` = '"+year+"',`code` = '"+codigo+"',`lot` = '"+cantidad+"',`area` = '"+area+"' WHERE `books`.`idbook`= '"+aux2+"'");
            System.out.println("Libro Actualizado con exito");
            resultado= estado.executeQuery("SELECT * FROM `books` WHERE `name` LIKE '"+nombre+"'");
           
            while(resultado.next()){
                System.out.println(resultado.getString("idbook")+"\t"+resultado.getString("name")+"\t"+resultado.getString("author")+"\t"+resultado.getString("year")+"\t"+resultado.getString("code")+"\t"+resultado.getString("lot")+"\t"+resultado.getString("area"));
            }
            }
            }
            else System.out.println("No se encontraron libros con ese nombre");

            //********************************************************************************************************************

        }catch(SQLException ex){
        System.out.println("Error de mysql");
        }
        catch(Exception e){
        System.out.println("Se ha encontrado un error que es:"+e.getMessage());
        }   
        
}
public void EliminarLibro(){
     Scanner teclado= new Scanner(System.in);
     
        try {
            System.out.println("Intentando conectar a la BD. . . ");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(this.localhost, this.user, this.password);
            //Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net/contactos_asdf", user2, password2);
            System.out.println("Concexión exitosa...");
            Statement estado = con.createStatement();
            //ingresar libro para sacar id*****************************************************************************************
            System.out.println("Cual es el nombre del libro que desea Eliminar?");
            String aux= teclado.nextLine();
            ResultSet resultado= estado.executeQuery("SELECT * FROM `books` WHERE `name` LIKE '"+aux+"'");
            if(resultado.next()){
                resultado.beforeFirst();
            while(resultado.next()){
                System.out.println("id\tNombre\t\tAutor\tAño\tCodigo\tCantidad\tArea");
                System.out.println(resultado.getString("idbook")+"\t"+resultado.getString("name"));
                String aux2=resultado.getString("idbook");
                estado.executeUpdate("DELETE FROM `booksoft`.`books` WHERE `books`.`idbook`='"+aux2+"'");
                System.out.println("Libro Actualizado con exito");
            }
            }
            else System.out.println("No se encontraron libros con ese nombre");


            //********************************************************************************************************************

        }catch(SQLException ex){
        System.out.println("Error de mysql");
        }
        catch(Exception e){
        System.out.println("Se ha encontrado un error que es:"+e.getMessage());
        }   
        
}
public void BuscarLibro(){
    Scanner teclado= new Scanner(System.in);
     
        try {
            System.out.println("Intentando conectar a la BD. . . ");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(this.localhost, this.user, this.password);
            //Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net/contactos_asdf", user2, password2);
            System.out.println("Concexión exitosa...");
            Statement estado = con.createStatement();
            //ingresar libro para sacar id*****************************************************************************************
            System.out.println("Cual es el nombre del libro que desea Buscar?");
            String aux= teclado.nextLine();
            ResultSet resultado= estado.executeQuery("SELECT * FROM `books` WHERE `name` LIKE '"+aux+"'");
            if(resultado.next()){
                resultado.beforeFirst();
            while(resultado.next()){
                System.out.println("id\tNombre\t\tAutor\tAño\tCodigo\tCantidad\tArea");
               System.out.println(resultado.getString("idbook")+"\t"+resultado.getString("name")+"\t"+resultado.getString("author")+"\t"+resultado.getString("year")+"\t"+resultado.getString("code")+"\t"+resultado.getString("lot")+"\t"+resultado.getString("area"));
               
            }
            }
            else System.out.println("No se encontraron libros con ese nombre");


            //********************************************************************************************************************

        }catch(SQLException ex){
        System.out.println("Error de mysql");
        }
        catch(Exception e){
        System.out.println("Se ha encontrado un error que es:"+e.getMessage());
        }
}
public void PrestarLibro(){
    Scanner teclado= new Scanner(System.in);
    try {
        System.out.println("Intentando conectar a la BD. . . ");
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(this.localhost, this.user, this.password);
        //Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net/contactos_asdf", user2, password2);
        System.out.println("Concexión exitosa...");
        Statement estado = con.createStatement();
        //ingresar libro para sacar id*****************************************************************************************
        
        System.out.println("Cual es el nombre del libro que desea prestar?");
        String aux= teclado.nextLine();
        ResultSet resultado= estado.executeQuery("SELECT * FROM `books` WHERE `name` LIKE '"+aux+"'");
        if(resultado.next()){
            resultado.beforeFirst();
        while(resultado.next()){
            System.out.println("id\tNombre\t\tAutor\tAño\tCodigo\tCantidad\tArea");
           System.out.println(resultado.getString("idbook")+"\t"+resultado.getString("name")+"\t"+resultado.getString("author")+"\t"+resultado.getString("year")+"\t"+resultado.getString("code")+"\t"+resultado.getString("lot")+"\t"+resultado.getString("area"));
           
           String idlibro=resultado.getString("idbook");
           String nombrelibro=resultado.getString("name");
           int aux3=resultado.getInt("lot");
           if(aux3-->0){
             System.out.println("Ingrese cedula");
             String cedula=teclado.nextLine();
             estado.executeUpdate("INSERT INTO `usuarios` VALUES (NULL,'"+cedula+"','"+idlibro+"','"+nombrelibro+"')");
             estado.executeUpdate("UPDATE `booksoft`.`books` SET `lot` = '"+aux3+"' WHERE `books`.`idbook`= '"+idlibro+"'");
             System.out.println("Prestamo exitoso");
           }
           else{
               System.out.println("Este libro esta agotado");
           }
        }
        }
        else System.out.println("No se encontraron libros con ese nombre");


        //********************************************************************************************************************

    }catch(SQLException ex){
    System.out.println("Error de mysql");
    }
    catch(Exception e){
    System.out.println("Se ha encontrado un error que es:"+e.getMessage());
    }
}
public void DevolverLibro(){
     Scanner teclado= new Scanner(System.in);
    try {
        System.out.println("Intentando conectar a la BD. . . ");
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(this.localhost, this.user, this.password);
        //Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net/contactos_asdf", user2, password2);
        System.out.println("Concexión exitosa...");
        Statement estado = con.createStatement();
        //ingresar libro para sacar id*****************************************************************************************
        
        System.out.println("Ingrese cedula");
        String aux= teclado.nextLine();
        ResultSet resultado= estado.executeQuery("SELECT * FROM `usuarios` WHERE `cedula` LIKE '"+aux+"'");
        if(resultado.next()){
            resultado.beforeFirst();
        while(resultado.next()){
            System.out.println("idPrestamo\tcedula\t\tid libro\tNombre libro");
           System.out.println(resultado.getString("idusuario")+"\t"+resultado.getString("cedula")+"\t"+resultado.getString("idlibro")+"\t"+resultado.getString("libro"));
                  
        }
            System.out.println("Ingrese el codigo id del PRESTAMO");
            String idprestamo=teclado.nextLine();
                      
            ResultSet resultado2= estado.executeQuery("SELECT * FROM `usuarios` WHERE `cedula` LIKE '"+aux+"' AND `idusuario` = '"+idprestamo+"'");
            //mostrar prestamo con el id de prestamo seleccionado
            if(resultado2.next()){
                resultado2.beforeFirst();
                while(resultado2.next()){
                    System.out.println("Cedula\tLibro");
                    System.out.println(resultado2.getString("cedula")+resultado2.getString("libro"));
                }
                
                int idlibro=resultado2.getInt("idlibro");
                ResultSet resultado3=estado.executeQuery("SELECT * FROM `books` WHERE `idbook` LIKE '"+idlibro+"'");
                int newlot=resultado3.getInt("lot");
                newlot++;
                estado.executeUpdate("UPDATE `booksoft`.`books` SET `lot` = '"+newlot+"' WHERE `books`.`idbook`= '"+idlibro+"'"); 
                estado.executeUpdate("DELETE FROM `booksoft`.`usuarios` WHERE `usuarios`.`idusuario`='"+idprestamo+"'");
            }
            else{
                System.out.println("Id prestamo no coincide");
            }
            //verificar que este el prestamo y sacar a pantalla el resultado de lo que se ingreso
//
            
        }
        else System.out.println("No se encontraron prestamos con esa cedula");


        //********************************************************************************************************************

    }catch(SQLException ex){
    System.out.println("Error de mysql");
    }
    catch(Exception e){
    System.out.println("Se ha encontrado un error que es:"+e.getMessage());
    }   
}
public void ListarPrestamos(){
Scanner teclado= new Scanner(System.in);
     
        try {
            System.out.println("Intentando conectar a la BD. . . ");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(this.localhost, this.user, this.password);
            //Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net/contactos_asdf", user2, password2);
            System.out.println("Concexión exitosa...");
            Statement estado = con.createStatement();
            //ingresar libro para sacar id*****************************************************************************************
            
            
            ResultSet resultado= estado.executeQuery("SELECT * FROM `usuarios`");
            if(resultado.next()){
                resultado.beforeFirst();
            while(resultado.next()){
                System.out.println("id\tCedula\t\tlibro\t");
               System.out.println(resultado.getString("idusuario")+"\t"+resultado.getString("cedula")+"\t"+resultado.getString("libro"));
               
            }
            }
            else System.out.println("No se encontraron Prestamos");


            //********************************************************************************************************************

        }catch(SQLException ex){
        System.out.println("Error de mysql");
        }
        catch(Exception e){
        System.out.println("Se ha encontrado un error que es:"+e.getMessage());
        }    
}
  public void menu(){
        System.out.println("*****************Menu***********************");
        System.out.println("1. Ingreser Nuevo Libro");
        System.out.println("2. Actualizar datos de un libro");
        System.out.println("3. Eliminar libro");
        System.out.println("4. Buscar libro");
        System.out.println("5. Prestar libro");
        System.out.println("6. Devolver libro");
        System.out.println("7. libros prestados");
        System.out.println("8. salir");
        System.out.println("****************************************");

    }
 
  
     
    public static void main(String[] args) {
        BookSoft2 libreria = new BookSoft2();
        Scanner teclado = new Scanner(System.in);
        libreria.ListarLibros();
    
    int menu;
        do{
            libreria.menu();
            menu=teclado.nextInt();
            
             switch(menu){
                    case 1://ingresar libro
                        menu=0;
                        libreria.IngresarLibro();
                     break;
                    case 2:
                        menu=0;
                        libreria.ActulizarLibro();
                    break;
                    case 3:
                        libreria.EliminarLibro();
                    break;
                    case 4:
                        libreria.BuscarLibro();
                    break;
                    case 5:
                        libreria.PrestarLibro();
                    break;
                    case 6:
                        libreria.DevolverLibro();
                    break;
                    case 7:
                        libreria.ListarPrestamos();
                    break;
                    case 8://Salir
                        
                    break;
    }
        }while(menu!=8);
    
}
}