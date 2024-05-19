import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.lang.*;

public class PostgresJDBC {
    
   public void BookTicket(String user,int num_passenger, String[] names, String train_num, String date, String coach)
   {Connection conn = null;
    Statement statement = null;
    try {
       conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/train_management","admin", "admin");
       conn.setAutoCommit(false);

       statement = conn.createStatement();

       String sql="INSERT INTO TICKET VALUES('" /*+PNR */+"','"+coach+"',"+ String.valueOF(num_passenger) + ","+ 
       train_num +",'"+ date+"');";
       statement.executeUpdate(sql);
    
       int i;

       for(i=0;i<num_passenger;i++)
       {  sql = "INSERT INTO PASSENGER VALUES (1, 'Paul', 32, 'California', 20000.00 );";
       statement.executeUpdate(sql);}

       statement.close();
       conn.commit();
       conn.close();
    } catch (Exception e) {
       System.err.println( e.getClass().getName()+": "+ e.getMessage() );
    }}

   public void Addtrain(String train_num, String date, String ac, String sl)
   {Connection conn = null;
      Statement statement = null;
      try {
         conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/train_management","admin", "admin");
         conn.setAutoCommit(false);
  
         statement = conn.createStatement();
  
         String sql="INSERT INTO TRAIN VALUES("+train_num +",'"+ date+"',"+ac+","+sl+");";
         System.out.println(sql);
         statement.executeUpdate(sql);

         sql="INSERT INTO TRAIN_STATUS VALUES("+train_num + ",'" + date + "'," + 
                String.valueOF(Integer.parseInt(ac)*18) + "," + String.valueOF(Integer.parseInt(sl)*24)+");";
  
         statement.close();
         conn.commit();
         conn.close();
      } catch (Exception e) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
      }}

}