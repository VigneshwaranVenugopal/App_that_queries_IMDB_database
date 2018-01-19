import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.StringTokenizer;

/**
 *
 * @author asha
 */
public class populate {
  
    static Connection con = null;
    static ResultSet rs = null;
    static PreparedStatement ps = null;
    
    public static void main(String args[])
    {
        try
        {
            connect();
            String fileName1 = /*args[0]*/"movies";
            DataInput(fileName1);
            
            String fileName2 = /*args[1]*/"movie_genres";
            DataInput(fileName2);
           
            String fileName3 = /*args[2]*/"movie_countries";
            DataInput(fileName3);
            
            String fileName4 = /*args[3]*/"movie_locations";
            DataInput(fileName4);
            
            String fileName5 = /*args[4]*/"tags";
            DataInput(fileName5);
            
            String fileName6 = /*args[5]*/"movie_tags";
            DataInput(fileName6);
            closeConnection(con);
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
    }
    
    public static void Insert_Movie_Tags(String data[])
    {
        if(!data[0].equals(null))
        {
            int i=1;
            try
            {
                ps = con.prepareStatement("insert into Movie_Tags values(?,?,?)");
                for(String value:data)
                {
                    ps.setString(i++, value);
                }
                ps.executeUpdate();
                ps.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
   
    
    public static void Insert_Tags(String data[])
    {
        if(!data[0].equals(null))
        {
            int i=1;
            try
            {
                ps = con.prepareStatement("insert into Tags values(?,?)");
                for(String value:data)
                {
                    ps.setString(i++, value);
                }
                ps.executeUpdate();
                ps.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
    
    
    public static void Insert_Movie_Locations(String data[])
    {
        if(!data[0].equals(null))
        {
            int i=1;
            try
            {
                ps = con.prepareStatement("insert into Movie_Locations values(?,?,?,?,?)");
                for(String value:data)
                {
                    ps.setString(i++, value);
                }
                ps.executeUpdate();
                ps.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
    
     public static void Insert_Movie_Countries(String data[])
    {
        if(!data[0].equals(null))
        {
            int i=1;
            try
            {
                ps = con.prepareStatement("insert into Movie_Countries values(?,?)");
               
                for(String value:data)
                {
                    ps.setString(i++, value);
                }
                ps.executeUpdate();
                ps.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }

    
     public static void Insert_Movie_Genres(String data[])
    {
        if(!data[0].equals(null))
        {
            int i=1;
            try
            {
                ps = con.prepareStatement("insert into Movie_Genres values(?,?)");
                for(String value:data)
                {
                   
                    ps.setString(i++, value);
                }
                
                ps.executeUpdate();
                ps.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
   
     public static void Insert_Movie(String data[])
    {
        if(!data[0].equals(null))
        {
            int i=1;
            try
            {
                ps = con.prepareStatement("insert into Movie values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                for(String value:data)
                {
                    ps.setString(i++, value);
                }
                ps.executeUpdate();
                ps.close();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        
    }
    
    public static void DataInput(String fileName) throws  IOException
    {
        /*Table Names
        Movie
        Movie_Genres
        Movie_Countries
        Movie_Locations
        Tags
        Movie_Tags
        */
        
        switch (fileName)
        {
            case "movies":
            {
                System.out.println("Inserting Data into Movie");
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\asha\\Desktop\\DBMS\\Assignment 3\\Data Files\\"+fileName+".dat"));
                String row;
                
                while((row = br.readLine()) != null)
                {
                    String data[] =  row.split("\t");
                    Insert_Movie(data);
                }
                
                System.out.println("Data Successfully inserted into Movie");
                break;
            }
            
           
            case "movie_genres":
            {
                System.out.println("Inserting Data into Movie_Genres");
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\asha\\Desktop\\DBMS\\Assignment 3\\Data Files\\"+fileName+".dat"));
                String row;
                
                while((row = br.readLine()) != null)
                {
                    String data[] = row.split("\t");
                    Insert_Movie_Genres(data);
                }
                
                System.out.println("Data Successfully inserted into Movie_Genres");
                break;
            }
          
           
            case "movie_countries":
            {
                System.out.println("Inserting Data into Movie_Countries");
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\asha\\Desktop\\DBMS\\Assignment 3\\Data Files\\"+fileName+".dat"));
                String row;
                
                while((row = br.readLine()) != null)
                {
                    StringTokenizer st = new StringTokenizer(row, "\t");
                    //String data[] = row.split("\t");
                    String data[] = {null, null};
                    int i=0;
                    while(st.hasMoreTokens())
                    {
                        data[i] = st.nextToken();
                        i++;
                    }
                    Insert_Movie_Countries(data);
                }
                
                System.out.println("Data Successfully inserted into Movie_Countries");
                break;
            }
           
           
            case "movie_locations":
            {
                System.out.println("Inserting Data into Movie_Locations");
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\asha\\Desktop\\DBMS\\Assignment 3\\Data Files\\"+fileName+".dat"));
                String row;
                
                while((row = br.readLine()) != null)
                {
                    StringTokenizer st = new StringTokenizer(row, "\t");
                    //String data[] = row.split("\t");
                    String data[] = {null, null, null, null, null};
                    int i = 0;
                    while(st.hasMoreTokens())
                    {
                        data[i] = st.nextToken();
                        i++;
                    }
                    Insert_Movie_Locations(data);
                }
                
                System.out.println("Data Successfully inserted into Movie_Locations");
                break;
            }
            
            case "tags":
            {
                System.out.println("Inserting Data into Tags");
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\asha\\Desktop\\DBMS\\Assignment 3\\Data Files\\"+fileName+".dat"));
                String row;
                
                while((row = br.readLine()) != null)
                {
                    String data[] = row.split("\t");
                    Insert_Tags(data);
                }
                
                System.out.println("Data Successfully inserted into Tags");
                break;
            }
            
            case "movie_tags":
            {
                System.out.println("Inserting Data into Movie_Tags");
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\asha\\Desktop\\DBMS\\Assignment 3\\Data Files\\"+fileName+".dat"));
                String row;
                
                while((row = br.readLine()) != null)
                {
                    String data[] = row.split("\t");
                    Insert_Movie_Tags(data);
                }
                
                System.out.println("Data Successfully inserted into Movie_Tags");
                break;
            }
           
        } 
    } 
    
    public static void connect()
    {
        try
        {
            System.out.println("Connecting to Database...");     
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:orcl";   /* Constructing the JDBC URL*/
            /* Here is the information needed when connecting to a database server.
            These values are now hard coded into the program. */
            con = DriverManager.getConnection(url,"Scott","tiger");
            
            if(con != null)
            {
                System.out.println("Connected to Database");
            }
            
            try
            {
                /*  Inside this method, we are cleaning up the tables. */
                
               
                System.out.println("Deleting from Movie_Tags");
                ps = con.prepareStatement("Delete from Movie_Tags");
                ps.executeUpdate();
                System.out.println("Deleted from Movie_Tags");
                
                System.out.println("Deleting from Tags");
                ps = con.prepareStatement("Delete from Tags");
                ps.executeUpdate();
                System.out.println("Deleted from Tags");
                
                System.out.println("Deleting from Movie_Locations");
                ps = con.prepareStatement("Delete from Movie_Locations");
                ps.executeUpdate();
                System.out.println("Deleted from Movie_Locations");
                
                
                System.out.println("Deleting from Movie_Countries");
                ps = con.prepareStatement("Delete from Movie_Countries");
                ps.executeUpdate();
                System.out.println("Deleted from Movie_Countries");
                
                
                System.out.println("Deleting from Movie_Genres");
                ps = con.prepareStatement("Delete from Movie_Genres");
                ps.executeUpdate();
                System.out.println("Deleted from Movie_Genres");
                
                System.out.println("Deleting from Movie");
                ps = con.prepareStatement("Delete from Movie");
                ps.executeUpdate();
                System.out.println("Deleted from Movie");
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void closeConnection(Connection con){
        try{
              con.close();
           }
        catch(SQLException e)
           { System.err.println("Cannot close connection:" +e.getMessage());
            
                       }
        
    }
    
}

  

