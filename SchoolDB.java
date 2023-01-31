import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class SchoolDB
{
  public static void main(String[] args)
  {
    Connection connection = null;
    try
    {
      // create a database connection
      connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
      Statement statement = connection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.
      statement.executeUpdate("drop table if exists POKEINFO");
      statement.executeUpdate("create table POKEINFO (Name string, NationalNum integer, Species string, NextEvolution string, PrevEvolution string, PRIMARY KEY(NationalNum))");
      statement.executeUpdate("insert into POKEINFO values('Bulbasuar', 1, 'Seed', 'None')");
      statement.executeUpdate("insert into POKEINFO values('Ivysaur', 2, 'Seed',  'Bulbasuar')");
      statement.executeUpdate("insert into POKEINFO values('Charmander', 4, 'Lizard',  'None')");
      statement.executeUpdate("insert into POKEINFO values('Charmelon', 5, 'Flame', 'Charizard', 'Charmander')");
      statement.executeUpdate("insert into POKEINFO values('Eevee', 133, 'Evolution Pokemon', 'None')");
      statement.executeUpdate("insert into POKEINFO values('Vaporean', 134, 'Bubble Jet',  'Eevee')");
      statement.executeUpdate("insert into POKEINFO values('Flareon', 136, 'Flame',  'Eevee')");
      statement.executeUpdate("insert into POKEINFO values('Weedle', 13, 'Hairy Bug Pokemon',  'None')");

      ResultSet rs = statement.executeQuery("select * from POKEINFO");
      while(rs.next())  // read the result set
      {
        System.out.println("Name = " + rs.getString("Name"));
        System.out.println("NationalNum = " + rs.getInt("NationalNum"));
        System.out.println("Species = " + rs.getString("Species"));
        System.out.println("NextEvolution = " + rs.getString("NextEvolution"));
        System.out.println("PrevEvolution = " + rs.getString("PrevEvolution"));
      }

      statement.executeUpdate("drop table if exists TYPE");
      statement.executeUpdate("create table TYPE (Name string, Type string, PRIMARY KEY(Name, Type))");
      statement.executeUpdate("insert into TYPE values('Bulbasuar', 'Grass')");
      statement.executeUpdate("insert into TYPE values('Bulbasuar', 'Poison')");
      statement.executeUpdate("insert into TYPE values('Ivysaur', 'Grass')");
      statement.executeUpdate("insert into TYPE values('Ivysaur', 'Poison')");
      statement.executeUpdate("insert into TYPE values('Charmander', 'Fire')");
      statement.executeUpdate("insert into TYPE values('Charmelon', 'Fire')");
      statement.executeUpdate("insert into TYPE values('Eevee', 'Normal')");
      statement.executeUpdate("insert into TYPE values('Vaporean', 'Water')");
      statement.executeUpdate("insert into TYPE values('Flareon', 'Fire')");
      statement.executeUpdate("insert into TYPE values('Weedle', 'Bug')");
      statement.executeUpdate("insert into TYPE values('Weedle', 'Poison')");
      
      rs = statement.executeQuery("select * from TYPE");
      while(rs.next())  // read the result set
      {
        System.out.println("Name = " + rs.getString("Name"));
        System.out.println("Type = " + rs.getString("Type"));
       
      }

      statement.executeUpdate("drop table if exists POKEABIL");
      statement.executeUpdate("create table POKEABIL (Name string, Abilities string)");
      statement.executeUpdate("insert into POKEABIL values('Bulbasuar', 'Overgrow')");
      statement.executeUpdate("insert into POKEABIL values('Bulbasuar', 'Chlorophyll')");
      statement.executeUpdate("insert into POKEABIL values('Ivysaur', 'Overgrow')");
      statement.executeUpdate("insert into POKEABIL values('Ivysaur', 'Chlorophyll')");
      statement.executeUpdate("insert into POKEABIL values('Charmander', 'Blaze')");
      statement.executeUpdate("insert into POKEABIL values('Charmander', 'Solar Power')");
      statement.executeUpdate("insert into POKEABIL values('Charmeleon', 'Blaze')");
      statement.executeUpdate("insert into POKEABIL values('Charmeleon', 'Solar Power')");
      statement.executeUpdate("insert into POKEABIL values('Eevee', 'Run Away')");
      statement.executeUpdate("insert into POKEABIL values('Eevee', 'Adaptability')");
      statement.executeUpdate("insert into POKEABIL values('Vaporean', 'Water Absorb')");
      statement.executeUpdate("insert into POKEABIL values('Flareon', 'Flash Fire')");
      statement.executeUpdate("insert into POKEABIL values('Weedle', 'Shield Dust')");

      rs = statement.executeQuery("select * from POKEABIL");
      while(rs.next())  // read the result set
      {
        System.out.println("Name = " + rs.getString("Name"));
        System.out.println("Abilities = " + rs.getString("Abilities"));
       
      }

      statement.executeUpdate("drop table if exists NEXTEV");
      statement.executeUpdate("create table NEXTEV (Name string, NextEv string)");
      statement.executeUpdate("insert into NEXTEV values('Bulbasuar', 'Ivysaur')");
      statement.executeUpdate("insert into NEXTEV values('Ivysaur', 'Venusaur')");
      statement.executeUpdate("insert into NEXTEV values('Charmander', 'Charmelon')");
      statement.executeUpdate("insert into NEXTEV values('Charmelon', 'Charizard')");
      statement.executeUpdate("insert into NEXTEV values('Eevee', 'Vaporean')");
      statement.executeUpdate("insert into NEXTEV values('Eevee', 'Joltean')");
      statement.executeUpdate("insert into NEXTEV values('Eevee', 'Flareon')");
      statement.executeUpdate("insert into NEXTEV values('Vaporean', 'None')");
      statement.executeUpdate("insert into NEXTEV values('Flareon', 'None')");
      statement.executeUpdate("insert into NEXTEV values('Weedle', 'Kakuna')");

      rs = statement.executeQuery("select * from NEXTEV");
      while(rs.next())  // read the result set
      {
        System.out.println("Name = " + rs.getString("Name"));
        System.out.println("NextEv = " + rs.getString("NextEv"));
       
      }
     
      System.out.println("Welcome to the Pokemon Database. Type 1 to display all Pokemon names, Type 2 for info on one Pokemon, Type 3 to see all Pokemon types, Type 4 if you want to see alll the Pokemon that fit with one type, Type 5 to delete a Pokemon, Type 6 to add a new Pokemon, Type 7 to update an already existing Pokemon");
      Scanner scan = new Scanner(System.in);
      String select = scan.nextLine();

      switch(select)
      {
        case "1":
        rs = statement.executeQuery("select * from POKEINFO");
         while(rs.next())  // read the result set
            {
                System.out.println("Name = " + rs.getString("Name"));
            }
        case "2":
            System.out.println("Which Pokemon would you like information on? Type the name.");
            String pokename = scan.nextLine();

            rs = statement.executeQuery("select * from POKEINFO WHERE Name = '" + pokename + "' ");
                while(rs.next())  // read the result set
                    {
                        System.out.println("Name = " + rs.getString("Name"));
                        System.out.println("NationalNum = " + rs.getInt("NationalNum"));
                        System.out.println("Species = " + rs.getString("Species"));
                        System.out.println("NextEvolution = " + rs.getString("NextEvolution"));
                        System.out.println("PrevEvolution = " + rs.getString("PrevEvolution"));
                    }
            rs = statement.executeQuery("select * from TYPE WHERE Name = '" + pokename + "' ");
                while(rs.next())  // read the result set
                    {
                        System.out.println("Type = " + rs.getString("Type"));
                    }
                
            rs = statement.executeQuery("select * from POKEABIL WHERE Name = '" + pokename + "' ");
                while(rs.next())  // read the result set
                    {
                        System.out.println("Abilities = " + rs.getString("Abilities"));
                    }

            rs = statement.executeQuery("select * from NEXTEV WHERE Name = '" + pokename + "' ");
                while(rs.next())  // read the result set
                    {
                      System.out.println("NextEv = " + rs.getString("NextEv"));
                    }
        case "3":
            rs = statement.executeQuery("select Type from TYPE ");
                while(rs.next())  // read the result set
                    {
                        System.out.println("Type = " + rs.getString("Type"));
                    }

        case "4":
        //enter name and return type like case two but backwards
            System.out.println("Which Pokemon type would you like information on? Type it here.");
            String poketype = scan.nextLine();
            rs = statement.executeQuery("select * from TYPE WHERE Type = '" + poketype + "' ");
                while(rs.next())  // read the result set
                    {
                        System.out.println("Name = " + rs.getString("Name"));
                    }

        case "5":
            System.out.println("Which Pokemon would you like to delete. Type it here:");
            String pokedelete = scan.nextLine();
            rs = statement.executeQuery("DELETE from POKEINFO WHERE Name = '" + pokedelete + "' ");
            rs = statement.executeQuery("DELETE from TYPE WHERE Name = '" + pokedelete + "' ");
            rs = statement.executeQuery("DELETE from POKEABIL WHERE Name = '" + pokedelete + "' ");
            rs = statement.executeQuery("DELETE from NEXTEV WHERE Name = '" + pokedelete + "' ");

        case "6":
            System.out.println("Insert Pokemon name");
            String insertname = scan.nextLine();
            System.out.println("Insert Pokemon national number");
            String insertnum = scan.nextLine();
            System.out.println("Insert Pokemon species");
            String insertspec = scan.nextLine();
            System.out.println("Insert Pokemon next evolution");
            String nexte = scan.nextLine();
            System.out.println("Insert Pokemon previous evolution");
            String preve = scan.nextLine();
            System.out.println("Insert Pokemon type");
            String inserttype = scan.nextLine();
            System.out.println("Insert Pokemon abilities");
            String insertabil = scan.nextLine();

            rs = statement.executeQuery("INSERT INTO POKEINFO VALUES ('" + insertname + "' , '" +  insertnum + "' , '" +  insertspec+ "' , '" +  preve + "') ");
            rs = statement.executeQuery("INSERT INTO TYPE VALUES ('" + insertname + "' ,'" + inserttype + "') ");
            rs = statement.executeQuery("INSERT INTO POKEABIL VALUES ('" + insertname + "' ,'" + insertabil + "') ");
            rs = statement.executeQuery("INSERT INTO NEXTEV VALUES ('" + insertname + "' ,'" + nexte + "') ");

            rs = statement.executeQuery("SELECT * FROM POKEINFO ORDER BY ID DESC LIMIT 1");
            rs = statement.executeQuery("SELECT * FROM TYPE ORDER BY ID DESC LIMIT 1");
            rs = statement.executeQuery("SELECT * FROM POKEABIL ORDER BY ID DESC LIMIT 1");
            rs = statement.executeQuery("SELECT * FROM NEXTEV ORDER BY ID DESC LIMIT 1");

        case "7":
            System.out.println("Insert Pokemon name you would like to update");
            String insname = scan.nextLine();
            System.out.println("Insert what you want to change Pokemon name to");
            String newname = scan.nextLine();
            System.out.println("Insert Pokemon national number");
            String insnum = scan.nextLine();
            System.out.println("Insert Pokemon species");
            String inspec = scan.nextLine();
           
            rs = statement.executeQuery("UPDATE POKEINFO SET Name = '" +  insname + "' WHERE Name = '" + newname + "'");        
            rs = statement.executeQuery("UPDATE POKEINFO SET NationalNum = '" +  insnum + "' WHERE Name = '" + newname + "'");
            rs = statement.executeQuery("UPDATE POKEINFO SET Species = '" +  inspec + "' WHERE Name = '" + newname + "'");

      }


    }
    catch(SQLException e)
    {
      // Error message "out of memory", probably means no database file found
      System.err.println(e.getMessage());
    }
    finally
    {
      try
      {
        if(connection != null)
          connection.close();
      }
      catch(SQLException e)
          {
            System.err.println(e.getMessage());  // connection close failed.
          }
        }
      }
    }