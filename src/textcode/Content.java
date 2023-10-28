 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package textcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringJoiner;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Content {
    
    String Email;
    String FirstName;
    String SecondName;
    String ThirdName;
    String FirstLastName; 
    String SecondLastName;
    String Pass; 
    String ConfirmPass; 
    String Admin;
    String Register; 
    String Voter;
    String Auditor; 
    
    
    public Content() {
       
    }

    public Content(String Email, String FirstName, String SecondName, String ThirdName, String FirstLastName, String SecondLastName, String Pass, String ConfirmPass, String Admin, String Register, String Voter, String Auditor) {
        this.Email = Email;
        this.FirstName = FirstName;
        this.SecondName = SecondName;
        this.ThirdName = ThirdName;
        this.FirstLastName = FirstLastName;
        this.SecondLastName = SecondLastName;
        this.Pass = Pass;
        this.ConfirmPass = ConfirmPass;
        this.Admin = Admin;
        this.Register = Register;
        this.Voter = Voter;
        this.Auditor = Auditor;
    }

        public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String SecondName) {
        this.SecondName = SecondName;
    }

    public String getThirdName() {
        return ThirdName;
    }

    public void setThirdName(String ThirdName) {
        this.ThirdName = ThirdName;
    }

    public String getFirstLastName() {
        return FirstLastName;
    }

    public void setFirstLastName(String FirstLastName) {
        this.FirstLastName = FirstLastName;
    }

    public String getSecondLastName() {
        return SecondLastName;
    }

    public void setSecondLastName(String SecondLastName) {
        this.SecondLastName = SecondLastName;
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

    public String getAdmin() {
        return Admin;
    }

    public void setAdmin(String Admin) {
        this.Admin = Admin;
    }

    public String getRegister() {
        return Register;
    }

    public void setRegister(String Register) {
        this.Register = Register;
    }

    public String getVoter() {
        return Voter;
    }

    public void setVoter(String Voter) {
        this.Voter = Voter;
    }

    public String getAuditor() {
        return Auditor;
    }

    public void setAuditor(String Auditor) {
        this.Auditor = Auditor;
    }

    @Override
    public String toString() {
        return "Content{" + "FirstName=" + FirstName + ", SecondName=" + SecondName + ", ThirdName=" + ThirdName + ", FirstLastName=" + FirstLastName + ", SecondLastName=" + SecondLastName + ", Pass=" + Pass + ", ConfirmPass=" + ConfirmPass + ", Admin=" + Admin + ", Register=" + Register + ", Voter=" + Voter + ", Auditor=" + Auditor + '}';
    }  
    
    public void Guardar(String cadena) {
        
        try {
                    // Creacion del nuevo archivo para guardar la informacion 
                    
                   FileWriter archivo = new FileWriter ("Usuarios.txt", true);
           
                   try(BufferedWriter almacen = new BufferedWriter(archivo)){
                       
                       almacen.write(cadena);
                       almacen.close();
                   }
                   archivo.close();                
                   
    }  catch(Exception ex){}
        
    }
   public void LeerDatos(){
       
       try {
           
           FileWriter fw = new FileWriter("Usuarios.txt", true);
              
           fw.write(getEmail());
           fw.write(",");
           fw.write(getFirstName());
           fw.write(",");
           fw.write(getSecondName());
           fw.write(",");
           fw.write(getThirdName());
           fw.write(",");
           fw.write(getFirstLastName());
           fw.write(",");
           fw.write(getSecondLastName());
           fw.write(",");
           fw.write(getPass());
           fw.write(",");
           fw.write(getConfirmPass());
           fw.write(",");
           fw.write(getAdmin());
           fw.write(",");
           fw.write(getRegister());
               fw.write(",");
           fw.write(getVoter());
               fw.write(",");
           fw.write(getAuditor());
           fw.write("\n");
           fw.close();
 
           JOptionPane.showMessageDialog(null, "Se agrego correctamente");

       }catch(Exception e) {
           
       }
           } 

   public void Mostrardatos(JTable tablatotalusers){
       // Crear variable para mostrar los datos 
       
       String nombrearchivo = "Usuarios.txt";
       
       // Asignar tipo de archivo que es el archivo txt donde se guardan los datos   
       File file = new File(nombrearchivo);
    
       try{
           // Se utiliza para para leer texto del archivo ya creado Usuarios.txt 
           BufferedReader br = new BufferedReader(new FileReader(file));
           
           // Variable que se utiliza para mostrar los datos limpios
           String Firstlinedata = br.readLine().trim();
           
           //Importamos y creamos una nueva tabla
           DefaultTableModel model = new DefaultTableModel();
           
           // creamos y añadimos las columnas a mostrar
           model.addColumn("Correo Electronico"); 
           model.addColumn("Primer Nombre");
           model.addColumn("Segundo Nombre");
           model.addColumn("Tercer Nombre");
           model.addColumn("Primer Apellido");
           model.addColumn("Segundo Apellido");
           model.addColumn("Contraseña");
           model.addColumn("Contraseña Confirmada");
           model.addColumn("Admin");
           model.addColumn("Register");
           model.addColumn("Voter");
           model.addColumn("Auditor");
           
           //Incorporamos la tabla model creada 
           tablatotalusers.setModel(model);
           
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
               tablatotalusers.setModel(model);
           }       
       }
       // Catch para colocar y detectar todos los errores durante el programa
       catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Ocurrio un error" + e.toString());
      
       }
   }
   
   public void selectuser(JTable tablatotalusers){
       
       try{
           // creacion de variable para obtener un valor de la fila del JTable creada
           int fila = tablatotalusers.getSelectedRow();
           
           if(fila>=0){
               
               setEmail(tablatotalusers.getValueAt(fila,0).toString());
               setFirstName(tablatotalusers.getValueAt(fila,1).toString());
               setSecondName(tablatotalusers.getValueAt(fila,2).toString());
               setThirdName(tablatotalusers.getValueAt(fila,3).toString());
               setFirstLastName(tablatotalusers.getValueAt(fila,4).toString());
               setSecondLastName(tablatotalusers.getValueAt(fila,5).toString());
               setPass(tablatotalusers.getValueAt(fila,6).toString());
               setConfirmPass(tablatotalusers.getValueAt(fila,7).toString());
               setAdmin(tablatotalusers.getValueAt(fila,8).toString());
               
           }
           
       }catch(Exception e){
              JOptionPane.showMessageDialog(null, "Ocurrio un error" + e.toString());
       }
       
   }
   
   public void Deleteuser(JTable tablatotaluser, JTextField Email){
       
       // Eliminar datos del archivo       
       
       // Llamamos la tabla ya creada
       DefaultTableModel model =(DefaultTableModel)tablatotaluser.getModel();
       
       //for utilizado para recorrer los datos en las filas      
   for(int i=0; i < model.getRowCount(); i++){
       
       if(((String)model.getValueAt(i, 0)).equals(Email.getText())){
       
           //llamamos la tabla y utilizamos removeRow para eliminar el dato que queremos, que seria solo el correo electronico
       model.removeRow(i);
       break;
   }
   }
   
   try {
       
       // Reescribir el archivo con datos en blanco, para eso es utilizado el comando PrintWriter
       PrintWriter writer = new PrintWriter("Usuarios.txt");
       //Se rellenan los espacios en blanco
       writer.print("");
       writer.close();
       
   }catch (Exception e){
        JOptionPane.showMessageDialog(null, "Ocurrio un error" + e.toString());
   }
   
   
   //Crear un nuevo registro luego de la eliminacion 
   
   try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Usuarios.txt")))){
       
       //StringJoiner permite extraer o separar string con las condiciones indicadas, en este caso el separador que utilizamos que fue la , 
            StringJoiner joiner = new StringJoiner (",");
            
            for(int col = 0; col< tablatotaluser.getColumnCount(); col++){
                    joiner.add(tablatotaluser.getColumnName(col));
                  
              }
              System.out.println(joiner.toString());
              bw.write(joiner.toString());
              bw.newLine();
              
       //Recorremos todos los datos en las fila de la tabla de los usuarios creados
       for(int row =0; row< tablatotaluser.getRowCount(); row++){
           
           joiner = new StringJoiner(",");
           
            ////Recorremos todos los datos en las columnas de la tabla de los usuarios creados
              for(int col =0; col< tablatotaluser.getColumnCount(); col++){
                  
                  //Se crea un objeto para obtener los datos recorridos en las tablas y columnas 
                  Object obj = tablatotaluser.getValueAt(row, col);
                 // Variable String para guardar el valor del anterior recorrido si en en este caso el objeto es igual a nulo 
                  String value = obj == null ? "null" :obj.toString();
                  //Se incorpora el jonier al valor obtenido 
                  joiner.add(value);
                  
              }
            
            //Mostrar lo recorrido 
            bw.write(joiner.toString()); 
            bw.newLine();
            JOptionPane.showMessageDialog(null, "Se elimino Correctamente");
       }
       
   }catch (Exception e){
       JOptionPane.showMessageDialog(null, "Ocurrio un error");
   }
   
   }
   
   public void edit(JTable tablatotaluser) {
       try {
       
       // Reescribir el archivo con datos en blanco, para eso es utilizado el comando PrintWriter
       PrintWriter writer = new PrintWriter("Usuarios.txt");
       //Se rellenan los espacios en blanco
       writer.print("");
       writer.close();
       
   }catch (Exception e){
        JOptionPane.showMessageDialog(null, "Ocurrio un error" + e.toString());
   }
   
   
   //Crear un nuevo registro luego de la eliminacion 
   
   try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Usuarios.txt")))){
       
       //StringJoiner permite extraer o separar string con las condiciones indicadas, en este caso el separador que utilizamos que fue la , 
            StringJoiner joiner = new StringJoiner (",");
            
            for(int col = 0; col< tablatotaluser.getColumnCount(); col++){
                    joiner.add(tablatotaluser.getColumnName(col));
                  
              }
              System.out.println(joiner.toString());
              bw.write(joiner.toString());
              bw.newLine();
              
       //Recorremos todos los datos en las fila de la tabla de los usuarios creados
       for(int row =0; row< tablatotaluser.getRowCount(); row++){
           
           joiner = new StringJoiner(",");
           
            ////Recorremos todos los datos en las columnas de la tabla de los usuarios creados
              for(int col =0; col< tablatotaluser.getColumnCount(); col++){
                  
                  //Se crea un objeto para obtener los datos recorridos en las tablas y columnas 
                  Object obj = tablatotaluser.getValueAt(row, col);
                 // Variable String para guardar el valor del anterior recorrido si en en este caso el objeto es igual a nulo 
                  String value = obj == null ? "null" :obj.toString();
                  //Se incorpora el jonier al valor obtenido 
                  joiner.add(value);
                  
              }
            
            //Mostrar lo recorrido 
            bw.write(joiner.toString()); 
            bw.newLine();
            JOptionPane.showMessageDialog(null, "Se modifico Correctamente");
       }
       
   }catch (Exception e){
       JOptionPane.showMessageDialog(null, "Ocurrio un error");
   }
      } 
   
      } 