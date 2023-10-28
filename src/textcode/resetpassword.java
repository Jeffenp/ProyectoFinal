/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package textcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class resetpassword {
   
String Email;
String Pass; 
String ConfirmPass; 

      public resetpassword(String Email,String Pass, String ConfirmPass) {
        this.Email = Email;
        this.Pass = Pass;
        this.ConfirmPass = ConfirmPass;
 }

    public resetpassword() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
      
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public String getConfirmPass() {
        return ConfirmPass;
    }

    public void setConfirmPass(String ConfirmPass) {
        this.ConfirmPass = ConfirmPass;
    }
    
    public void search(JTable tablatotalusers){
    
         try {
           
           FileWriter fw = new FileWriter("Usuarios.txt", true);
              
           fw.write(getEmail());
           fw.write(",");
           fw.write(getPass());
           fw.write(",");
           fw.write(getConfirmPass());
           fw.write(",");
           fw.write("\n");
           fw.close();
 
           JOptionPane.showMessageDialog(null, "Busqueda completada");

       }catch(Exception e) {
        
           
       }
       }
    
    public void showresult(JTable tablaresultados){
        
        String nombrearchivo = "Usuarios.txt";
        
         File file = new File(nombrearchivo);
         
           try{
           // Se utiliza para para leer texto del archivo ya creado Usuarios.txt 
           BufferedReader br = new BufferedReader(new FileReader(file));
           
           // Variable que se utiliza para mostrar los datos limpios
           String Firstlinedata = br.readLine().trim();
           
           //Importamos y creamos una nueva tabla
           DefaultTableModel model = new DefaultTableModel();
         
           Firstlinedata = br.readLine().trim();
           
           //Importamos y creamos una nueva tabla
            model = new DefaultTableModel();
         
           model.addColumn("Correo Electronico"); 
           model.addColumn("Contraseña");
           model.addColumn("Contraseña Confirmada");
           tablaresultados.setModel(model);
           
           // Crear un array para almacenar objetos que queremos buscar 
           Object[] tableLines = br.lines().toArray();
           
           //Utilizar condicional for recorre desde 0 hasta el total de datos en el archivo
           for(int i=0; i< tableLines.length; i++){
               
               // Variable creada para mostrar los datos, convertirlos en tipo String y mostrarlos limpios con .trim
               String line = tableLines[i].toString().trim();
               // Crear array para que recorra los datos desde la coma en los datos 
               String[] datarow = line.split(","); 
               //Incorporamos al modelo las filas separadas por coma
               model.addRow(datarow);
               //Incorporamos el modelo a la tabla total 
              tablaresultados.setModel(model);
           }       
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Ocurrio un error" + e.toString());
      
       }
        }    
      }  
    
    
   
   
   