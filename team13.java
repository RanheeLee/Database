//package team13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class team13 {
   public static void main(String args[]) throws SQLException {

      String databaseURL = "jdbc:mysql://localhost:3306/team13";
      String user = "team13";
      String password = "team13";
      Connection conn = null;{

         try {
            Class.forName("com.mysql.jdbc.Driver"); 
            conn = DriverManager.getConnection(databaseURL, user, password); 
            conn.setAutoCommit(false); //transaction setting

            if (conn != null) {
               System.out.println("Connected to the database"); 
               System.out.println("Welcome to Movie Database!\\(^0^ )/");
               java.sql.Statement stmt = conn.createStatement(); 
               String dbCommand;   
               Scanner sc = new Scanner(System.in);   

               int menu;
               boolean repeat = true;
               while(repeat == true){
                  System.out.println("");
                  System.out.println("     		     		     <Menu>"
                        + "\n====================================================================================="
                        + "\n1. Print movie table   2. Insert      3. Delete      4. Update"
                        + "\n5. Movie in year   6. IMDB, Naver Rank   7. Movie-Actor      8. Rate-Awards      \n9. Exit"
                        + "\n=====================================================================================");
                  System.out.print("Choose Menu: ");
                  menu = sc.nextInt();
                  sc.nextLine();
                  System.out.println("");
                  switch(menu){
                  
                  case 1:
                  {
                     int a;      
                     team13 b = new team13();

                     System.out.println("===Menu 1==="
                           + "\nWhat information do you want ? (enter a number)");   
                     b.PrintTable();   
                     a = sc.nextInt();      
                     sc.nextLine();      
                  
                     switch(a){
                     case 1 : {ResultSet rset = stmt.executeQuery(
                           "select * from Team13.DBCOURSE_Movie");
                     
                        for(int i=0; i!= 40+40+20+4+10+10+10+10+12+40+18+9; i++){ 
                           System.out.printf("=");
                        }
                        System.out.printf("%n");
                        
                        System.out.printf("== %-40s == %-40s == %-20s == %-4s == %-10s == %-10s == %-10s == %-12s == %-40s==%n","TITLE","DIRECTOR","ACTOR","MN","RATE","GENRE","COUNTRY","BUDGET","DISTRIBUTOR");
                        
                     while(rset.next()){
                        for(int i=0; i!= 40+40+20+4+10+10+10+10+12+40+18+9; i++){//This formation is to create the graphic part.
                           System.out.printf("=");
                        }
                        System.out.printf("%n");
                        System.out.printf("== %-40s == %-40s == %-20s == %-4d == %-10s == %-10s == %-10s == %-12d == %-40s==%n",
                              rset.getString("title"),
                              rset.getString("Director_name"),
                              rset.getString("Actor_name"),
                              rset.getInt("runningtime"),
                              rset.getString("rate"),
                              rset.getString("genre"),
                              rset.getString("country"),
                              rset.getInt("budget"),
                              rset.getString("distributor"))
                              ;                
                     }//while
                     for(int i=0; i!= 40+40+20+4+10+10+10+10+12+40+18+9; i++){//This formation is to create the graphic part.
                        System.out.printf("=");
                     }
                     System.out.printf("%n");
                     break;
                     }//case 1

                     case 2: {ResultSet rset = stmt.executeQuery(
                           "select * from Team13.DBCOURSE_Actor");
                     for(int i=0; i!= 40+4+5+20+17; i++){//This formation is to create the graphic part.
                        System.out.printf("=");
                     }
                     System.out.printf("%n");
                     System.out.printf("== %-40s == %-4s == %-5s== %-20s==%n","NAME","YEAR","GENDER","COUNTRY");
                     while(rset.next()){
                        for(int i=0; i!= 40+4+5+20+17; i++){//This formation is to create the graphic part.
                           System.out.printf("=");
                        }
                        System.out.printf("%n");
                        System.out.printf("== %-40s == %-4d == %-5s == %-20s==%n", 
                              rset.getString("Name"),
                              rset.getInt("Year"),
                              rset.getString("Gender"),
                              rset.getString("Country"));
                     }//while
                     for(int i=0; i!= 40+4+5+20+17; i++){//This formation is to create the graphic part.
                        System.out.printf("=");
                     }
                     System.out.printf("%n");
                     break;
                     }//case 2

                     case 3: {ResultSet rset = stmt.executeQuery(
                           "select * from Team13.DBCOURSE_Remake");
                     for(int i=0; i!= 100+30+33+13; i++){//This formation is to create the graphic part.
                        System.out.printf("=");
                     }
                     System.out.printf("%n");
                     System.out.printf("== %-100s == %-30s == %-33s==%n", 
                           "TITLE",
                           "YEAR OF RELEASE OF THE REMAKE",
                           "YEAR OF RELEASE OF THE ORIGINAL");
                     while(rset.next()){
                        for(int i=0; i!= 100+30+33+13; i++){//This formation is to create the graphic part.
                           System.out.printf("=");
                        }
                        System.out.printf("%n");
                        System.out.printf("== %-100s == %-30d == %-33d==%n", 
                              rset.getString("Movie_title"),
                              rset.getInt("Release_year"),
                              rset.getInt("Original_year"));
                        
                     }//while
                     for(int i=0; i!= 100+30+33+13; i++){//This formation is to create the graphic part.
                        System.out.printf("=");
                     }
                     System.out.printf("%n");
                     break;
                     }//case 3

                     case 4: {ResultSet rset = stmt.executeQuery(
                           "select * from Team13.DBCOURSE_Original");
                        for(int i=0; i!= 40+20+30+13; i++){//This formation is to create the graphic part.
                           System.out.printf("=");
                        }
                        System.out.printf("%n");
                        System.out.printf("== %-40s == %-20s == %-30s==%n","TITLE","Original Genre","Name of the Author");
                     while(rset.next()){
                        for(int i=0; i!= 40+20+30+13; i++){//This formation is to create the graphic part.
                           System.out.printf("=");
                        }
                        System.out.printf("%n");
                        System.out.printf("== %-40s == %-20s == %-30s==%n",rset.getString("title"),rset.getString("Original_Genre"),rset.getString("Author_name"));
                     }//while
                     for(int i=0; i!= 40+20+30+13; i++){//This formation is to create the graphic part.
                        System.out.printf("=");
                     }
                     System.out.printf("%n");
                     break;
                     }//case 4

                     case 5: {ResultSet rset = stmt.executeQuery(
                           "select * from Team13.DBCOURSE_Awards");
                     for(int i=0; i!= 100+100+10+13; i++){//This formation is to create the graphic part.
                        System.out.printf("=");
                     }
                     System.out.printf("%n");
                     System.out.printf("== %-100s == %-100s == %-10s==%n",
                           "TITLE",
                           "AWARD NAME",
                           "AWARDS WON");
                     while(rset.next()){
                        for(int i=0; i!= 100+100+10+13; i++){//This formation is to create the graphic part.
                           System.out.printf("=");
                        }
                        System.out.printf("%n");
                        System.out.printf("== %-100s == %-100s == %-10s==%n",
                              rset.getString("Movie_title"),
                              rset.getString("Awards_name"),
                              rset.getString("Awards_win"));
                     }//while
                     for(int i=0; i!= 100+100+10+13; i++){//This formation is to create the graphic part.
                        System.out.printf("=");
                     }
                     System.out.printf("%n");
                     break;
                     }//case 5

                     case 6: {ResultSet rset = stmt.executeQuery(
                           "select * from Team13.DBCOURSE_Review");
                     
                     for(int i=0; i!= 100+5+5+13; i++){//This formation is to create the graphic part.
                        System.out.printf("=");
                     }
                     System.out.printf("%n");
                     System.out.printf("== %-100s == %-5s == %-5s==%n","TITLE","IMDB","NAVER");
                     while(rset.next()){
                        for(int i=0; i!= 100+5+5+13; i++){//This formation is to create the graphic part.
                           System.out.printf("=");
                        }
                        System.out.printf("%n");
                        System.out.printf("== %-100s == %-5.2f == %-5.2f==%n",rset.getString("Title"),rset.getFloat("IMDB"),rset.getFloat("Naver"));
                     }//while
                     for(int i=0; i!= 100+5+5+13; i++){//This formation is to create the graphic part.
                        System.out.printf("=");
                     }
                     System.out.printf("%n");
                     break;
                     }//case 6

                     case 7: {ResultSet rset = stmt.executeQuery(
                           "select * from Team13.DBCOURSE_Release_Date");
                     for(int i=0; i!= 100+10+10+10+17; i++){//This formation is to create the graphic part.
                        System.out.printf("=");
                     }
                     System.out.printf("%n");
                     System.out.printf("== %-100s == %-10s == %-10s == %-10s==%n","TITLE","YEAR",
                           "MONTH","DAY");
                     while(rset.next()){
                        for(int i=0; i!= 100+10+10+10+17; i++){//This formation is to create the graphic part.
                           System.out.printf("=");
                        }
                        System.out.printf("%n");
                        System.out.printf("== %-100s == %-10d == %-10d == %-10d==%n",rset.getString("Title"),rset.getInt("Year"),
                        rset.getInt("Month"),rset.getInt("Date"));
                     }//while
                     for(int i=0; i!= 100+10+10+10+17; i++){//This formation is to create the graphic part.
                        System.out.printf("=");
                     }
                     System.out.printf("%n");
                     break;
                     }//case 7

                     case 8: {ResultSet rset = stmt.executeQuery(
                           "select * from Team13.DBCOURSE_Country");
                     for(int i=0; i!= 20+30+9; i++){//This formation is to create the graphic part.
                        System.out.printf("=");
                     }
                     System.out.printf("%n");
                     System.out.printf("== %-20s == %-30s==%n","Continent","Country");
                     
                     while(rset.next()){
                        for(int i=0; i!= 20+30+9; i++){//This formation is to create the graphic part.
                           System.out.printf("=");
                        }
                        System.out.printf("%n");
                        System.out.printf("== %-20s == %-30s==%n",rset.getString("CONTINENT"),rset.getString("COUNTRY"));
                     }//while
                     for(int i=0; i!= 20+30+9; i++){//This formation is to create the graphic part.
                        System.out.printf("=");
                     }
                     System.out.printf("%n");
                     break;
                     }//case 8

                     case 9: {ResultSet rset = stmt.executeQuery(
                           "select * from Team13.DBCOURSE_Director");
                     for(int i=0; i!= 40+20+9; i++){//This formation is to create the graphic part.
                        System.out.printf("=");
                     }
                     System.out.printf("%n");
                     System.out.printf("== %-40s == %-20s==%n","NAME","COUNTRY");
                     while(rset.next()){
                        for(int i=0; i!= 40+20+9; i++){//This formation is to create the graphic part.
                           System.out.printf("=");
                        }
                        System.out.printf("%n");
                        System.out.printf("== %-40s == %-20s==%n",rset.getString("Name"),rset.getString("Country"));
                     }//while
                     for(int i=0; i!= 40+20+9; i++){//This formation is to create the graphic part.
                        System.out.printf("=");
                     }
                     System.out.printf("%n");
                     break;
                     }//case 9

                     case 10: {ResultSet rset = stmt.executeQuery(
                           "select * from Team13.DBCOURSE_Distributor");
                     for(int i=0; i!= 40+5+20+13; i++){//This formation is to create the graphic part.
                        System.out.printf("=");
                     }
                     System.out.printf("%n");
                     System.out.printf("== %-40s == %-5s == %-20s==%n","NAME","YEAR","COUNTRY");
                     while(rset.next()){
                        for(int i=0; i!= 40+5+20+13; i++){//This formation is to create the graphic part.
                           System.out.printf("=");
                        }
                        System.out.printf("%n");
                        System.out.printf("== %-40s == %-5d == %-20s==%n",rset.getString("Name"),rset.getInt("Year"),rset.getString("Country"));
                     }//while
                     for(int i=0; i!= 40+5+20+13; i++){//This formation is to create the graphic part.
                        System.out.printf("=");
                     }
                     System.out.printf("%n");
                     break;
                     }//case 10

                     }//switch a
                     break;
                  }
                  
                  //Insert movie information: Kim Eeejeong
                  case 2:
                  {
                     try {
                        //Menu introduction
                        System.out.println("===Menu 2==="
                              + "\nInsert Movie Information.");

                        //Insert data for all columns of the Movie table
                        System.out.print("Movie Title: ");
                        String title = sc.nextLine();
                        System.out.print("Director Name: ");
                        String director_name = sc.nextLine();
                        System.out.print("Actor Name: ");
                        String actor_name = sc.nextLine();
                        System.out.print("Running Time(only number): ");
                        int running_time = sc.nextInt();
                        sc.nextLine();   //flush the buffer
                        System.out.print("Rate: ");
                        String rate = sc.nextLine();
                        System.out.print("Genre: ");
                        String genre = sc.nextLine();
                        System.out.print("Country: ");
                        String country = sc.nextLine();
                        System.out.print("Budget(only number): ");
                        int budget = sc.nextInt();
                        sc.nextLine();   //flush the buffer
                        System.out.print("Distributor: ");
                        String distributor = sc.nextLine();

                        //insert_command for MySQL
                        String insert_command = "'" + title + "' , '" + director_name + "' , '" + actor_name + "' , '" + running_time
                              + "' , '" + rate + "' , '" + genre + "' , '" + country + "' , '" + budget + "' , '" + distributor + "'";
                        //dbCommand for MySQL
                        dbCommand = "insert Team13.DBCOURSE_Movie values (" + insert_command + ")";
                        //execute dbCommand
                        stmt.executeUpdate(dbCommand);

                        //print all the rows of Movie table to check the insertion
                        System.out.print("\n=== Movies in your Database ===\n");
                        //execute query for printing the Movie table (order by title)
                        java.sql.ResultSet rs = stmt.executeQuery("Select * From team13.DBCOURSE_Movie Order by title");
                        rs.beforeFirst();
                        //print until rs.next() has data
                        while(rs.next()){
                           for(int i=0; i!= 180+38; i++){//This formation is to create the graphic part.
                              System.out.printf("=");
                           }
                           System.out.printf("%n");
                           System.out.printf("== %-50s == %-30s == %-20s == %-4d == %-6s == %-10s == %-20s == %-10d == %-30s ==%n",rs.getString("title"),rs.getString("director_name"),rs.getString("actor_name"), 
                                 rs.getInt("runningtime"),rs.getString("rate"),rs.getString("genre"),rs.getString("country"),rs.getInt("budget"),rs.getString("distributor"));
                        }
                        for(int i=0; i!= 150+38; i++){//This formation is to create the graphic part.
                           System.out.printf("=");
                        }
                        System.out.printf("%n");
                        
                        System.out.println("");   //for additional line

                        //Insert More information: Quentin
                        boolean more = true;
                        while(more == true){
                           System.out.println("Do you want to insert more informations ? Y/N");
                           String choice = sc.nextLine();
                           if (choice.equalsIgnoreCase("y"))
                           {
                              System.out.println("What do you want to add ?");
                              System.out.println("Review          - 1");
                              System.out.println("Release date   - 2");
                              System.out.println("Original       - 3");
                              System.out.println("Awards          - 4");
                              System.out.println("Remake          - 5");

                              int choiceNum = sc.nextInt();
                              sc.nextLine();
                              String TITLE = title;
                              switch (choiceNum){ // For each case, we check the information and enter them. No errors controled (weak system).
                              case 1:
                                 float imdb,naver;//Declaration of the variables
                                 System.out.println("Please, insert a rate for IMDB.");
                                 imdb = sc.nextFloat();
                                 System.out.println("Please, insert a rate for Naver.");
                                 naver = sc.nextFloat();

                                 dbCommand = "insert into Team13.DBCOURSE_Review values (\'" + TITLE + "\', " + imdb + ", " + naver + ");";
                                 stmt.executeUpdate(dbCommand);
                                 sc.nextLine();
                                 break;
                              case 2:
                                 String year;//Declaration of the variables
                                 int month,date;
                                 System.out.println("Please, insert the year of release of the movie.");
                                 year = sc.nextLine();
                                 System.out.println("Please, insert the month of release of the movie.");
                                 month = sc.nextInt();
                                 System.out.println("Please, insert the full date of release of the movie.");
                                 date = sc.nextInt();
                                 sc.nextLine();

                                 dbCommand = "insert into Team13.DBCOURSE_Release_Date values (\'" + TITLE + "\', " + year + ", " + month + ", " + date + ");";
                                 stmt.executeUpdate(dbCommand);
                                 break;
                              case 3:
                                 String author;//Declaration of the variables
                                 System.out.println("Please, insert the original genre.");
                                 genre = sc.nextLine();
                                 System.out.println("Please, insert the author.");
                                 author = sc.nextLine();

                                 dbCommand = "insert into Team13.DBCOURSE_Original values (\'" + TITLE + "\', \'" + genre + "\', \'" + author + "\');";
                                 stmt.executeUpdate(dbCommand);
                                 break;
                              case 4:
                                 String award;//Declaration of the variables
                                 int nb;
                                 System.out.println("Please, insert one award won.");
                                 System.out.println("(Academy of Science Fiction Fantasy Horror Films, Academy Awards, BAFTA Awards, Cannes Film Festival, ASCAP Film and Television Music Awards, Venice Film Festival)");
                                 award = sc.nextLine();
                                 System.out.println("Please, insert the number of awards won.");
                                 nb = sc.nextInt();
                                 sc.nextLine();

                                 dbCommand = "insert into Team13.DBCOURSE_Awards values (\'" + TITLE + "\', \'" + award + "\', " + nb + ");";
                                 stmt.executeUpdate(dbCommand);
                                 break;
                              case 5:
                                 int release_year,original_year; //Declaration of the variables
                                 System.out.println("Please, insert the year of release of the remake.");
                                 release_year = sc.nextInt();
                                 System.out.println("Please, insert the year of release of the original movie.");
                                 original_year = sc.nextInt();
                                 sc.nextLine();

                                 dbCommand = "insert into Team13.DBCOURSE_Remake values (\'" + TITLE + "\', " + release_year + ", " + original_year + ");";
                                 stmt.executeUpdate(dbCommand);
                                 break;
                              default: // Default choice
                                 System.out.println("This is not a valid argument, we consider that you don't want to add anything");
                                 break;
                              }
                           }

                           else
                           {
                              more = false;
                              System.out.println("Movie creation completed.");
                           }
                        }
                        conn.commit();
                     }
                     catch(InputMismatchException ex1){
                        System.out.println("**Type error: Input numeric data for 'Running time' and 'Budget'.");
                        sc.nextLine();
                        conn.rollback();
                        System.out.println("---BECOME ROLLBACK---");
                     }
                     catch(SQLSyntaxErrorException ex1){
                        System.out.println("**Type error: Input \\ for ' or \".");
                        conn.rollback();
                        System.out.println("---BECOME ROLLBACK---");
                     }
                     catch (SQLIntegrityConstraintViolationException ex1){
                        System.out.println("**Intigrity error");
                        System.out.println("Check 'Country' data if it is in Country table."
                              + "\nCheck if 'Title' is null or already existed.");

                        conn.rollback();
                        System.out.println("---BECOME ROLLBACK---");
                     }
                     break;
                  }
                  
                  //Delete Movie information: Lee Ranhee
                  case 3:{
                     String Del_title;
                     //Menu Introduction
                     System.out.println("===Menu 3===");
                     //Print list of movies for user 
                     System.out.print("\n=== Movies in your Database ===\n");
                     java.sql.ResultSet rs = stmt.executeQuery("Select * From team13.DBCOURSE_Movie Order by title");
                     rs.beforeFirst();
                     while(rs.next()){
                        System.out.println(rs.getString("title"));
                     }
                     
                     
                     //Delete Movie title which user wants to
                     System.out.print("\nWhich movie do you want to delete? (Enter the title of movie.): ");
                     Del_title = sc.nextLine();   //movie title which user wants to delete
                     
                     dbCommand = "select title from team13.DBCOURSE_Movie where title = '" + Del_title +"'";
                     rs = stmt.executeQuery(dbCommand);
                     rs.beforeFirst();
                     if(!rs.next()){
                        System.out.println("No movie with that title.");
                        break;
                     }
                     dbCommand = "delete from team13.DBCOURSE_Movie where title = '" + Del_title + "'";  //Use title_index_movie
                     
                     //Delete movie_title from Original, Remake, Review, Awards and Release_Date automatically by using 'on delete cascade' when defining tables.
                     stmt.executeUpdate(dbCommand);

                     //Print updated list of movies
                     System.out.print("\n=== Movies in your Database ===\n");
                     rs = stmt.executeQuery("Select * From team13.DBCOURSE_Movie Order by title");
                     rs.beforeFirst();
                     while(rs.next()){
                        System.out.println(rs.getString("title"));
                     }
                     break;
                  }
                  //Update Review information: Sujin Han
                  case 4:
                  {
                     System.out.println("===Menu 4===");
                     //Enter the update review value
                     System.out.println("Which movie do you want to update Naver review in this month? ");

                     //scan movie title
                     String up_title=sc.nextLine(); 
                     dbCommand = "select title from team13.DBCOURSE_Movie where title = '" + up_title +"'";
                     java.sql.ResultSet rs = stmt.executeQuery(dbCommand);
                     rs.beforeFirst();
                     if(!rs.next()){
                        System.out.println("No movie with that title.");
                        break;
                     }

                     //scan updated naver review value
                     System.out.println("Insert new review: ");
                     try{
                        float up_naver=sc.nextFloat(); 

                        while(0<up_naver&up_naver<10);{
                           System.out.println("review value must in 0 to 10: ");
                           up_naver=sc.nextFloat(); 
                        }

                        //Update the naver review
                        PreparedStatement pStmt=conn.prepareStatement("UPDATE DBCOURSE_Review SET NAVER=(?) WHERE Title=(?)");
                        pStmt.setFloat(1, up_naver);
                        pStmt.setString(2, up_title);
                        pStmt.executeUpdate();

                        //SHOW Movie title and updated naver value
                        java.sql.ResultSet rset = stmt.executeQuery("Select * From DBCOURSE_Review");
                        rset.beforeFirst();
                        while(rset.next()){
                           System.out.println(rset.getString("Title")+" "+rset.getFloat("Naver"));
                        }

                     }catch(InputMismatchException e1){
                        //if exception is occurred, rollback.
                        conn.rollback();
                        sc.nextLine();
                        System.out.println("---BECOME ROLLBACK---");
                     }
               
                     break;
                  }
                  
                  //Movie in year: Keyu
                  case 5:
                  {
                     int s_year;
                     int e_year;

                     System.out.println("===Menu 5===");
                     System.out.println("Select a period of time on which to display the list of all the movies.");
                     System.out.print("From: ");
                     s_year = sc.nextInt();
                     System.out.print("To: ");
                     e_year = sc.nextInt();
                     System.out.println("");
                     dbCommand = "select Title from team13.DBCOURSE_Release_Date where team13.DBCOURSE_Release_Date.Year <="+e_year+" and team13.DBCOURSE_Release_Date.Year >= "+s_year;
                     java.sql.ResultSet rs = stmt.executeQuery(dbCommand);
                     rs.beforeFirst();
                     for(int i=0; i!= 50+5; i++){//This formation is to create the graphic part.
                        System.out.printf("=");
                     }
                     while(rs.next()){
                        System.out.println("");
                        System.out.printf("== %-50s==%n",rs.getString("Title") );
                        for(int i=0; i!= 50+5; i++){//This formation is to create the graphic part.
                           System.out.printf("=");
                        }
                     }
                     break;  
                  }
                  //IMDB & Naver review
                  case 6:
                  {
                     float in_imdb;
                     float in_naver;

                     System.out.println("===Menu 6===");
                     System.out.println("Select movies according to the rank IMDB & Naver.");
                     System.out.print("IMDB(0 ~ 10): ");
                     in_imdb = sc.nextInt();
                     System.out.print("Naver(0 ~ 10): ");
                     in_naver = sc.nextInt();

                     dbCommand = "select Title from team13.DBCOURSE_Review where team13.DBCOURSE_Review.IMDB >= "+ in_imdb + " and team13.DBCOURSE_Review.Naver >=" + in_naver;
                     java.sql.ResultSet rs = stmt.executeQuery(dbCommand);
                     rs = stmt.executeQuery(dbCommand);
                     rs.beforeFirst();
                     while(rs.next()){
                        System.out.println(rs.getString("Title") );
                     }
                     break;
                  }
                  //Movie-Actor
                  case 7:
                  {
                     String in_movie_c;
                     java.sql.ResultSet rs;
                     stmt.executeUpdate("Drop view  if exists movie_actor_view;");
                     stmt.executeUpdate("create view movie_actor_view as "
                           + "(select DBCOURSE_MOVIE.title, DBCOURSE_MOVIE.country as movie_country,dbcourse_actor.country as actor_country "
                           + "from team13.DBCOURSE_MOVIE left outer join team13.DBCOURSE_Actor on team13.DBCOURSE_MOVIE.Actor_name = team13.DBCOURSE_Actor.Name);");

                     System.out.println("===Menu 7===");
                     System.out.println("Check if the movie and the actor are originated from the same country.");
                     System.out.println("Movie title: ");
                     in_movie_c = sc.nextLine();
                     dbCommand = "select title from team13.DBCOURSE_Movie where title = '" + in_movie_c +"'";
                     rs = stmt.executeQuery(dbCommand);
                     rs.beforeFirst();
                     if(!rs.next()){
                        System.out.println("No movie with that title.");
                        break;
                     }
                     
                     dbCommand = "select title from movie_actor_view where movie_country = actor_country and title = '"+ in_movie_c+"'";
                     rs = stmt.executeQuery(dbCommand);
                     
                     if(rs.next()){
                        System.out.println(rs.getString("title")+" and the main actor are from the same country.");
                     }
                     else{
                        System.out.println(in_movie_c +" and the main actor are from different countries.");
                     }
                     break;
                  }
                  //Rate-Award
                  case 8:
                  {
                     float review;
                     System.out.println("===Menu 8===");
                     System.out.print("IMDB Review: ");
                     review = sc.nextFloat();

                     System.out.println("Judge if the moive which was reviewed more than " + review +", and won any awards.");

                     //Create view (Review + Awards)
                     stmt.executeUpdate("Drop view if exists review_award_view;");
                     dbCommand ="create view review_award_view as "
                           + "(select * "
                           + "from DBCOURSE_Review left outer join DBCOURSE_Awards on DBCOURSE_Review.Title = DBCOURSE_Awards.movie_title)";
                     stmt.executeUpdate(dbCommand);

                     //Select
                     dbCommand ="select title "
                           + "from review_award_view "
                           + "where review_award_view.IMDB >=" + review + " and review_award_view.awards_name is not null";
                     java.sql.ResultSet rs = stmt.executeQuery(dbCommand);
                     //stmt.executeUpdate(dbCommand);
                     rs = stmt.executeQuery(dbCommand);
                     rs.beforeFirst();
                     while(rs.next()){
                        for(int i=0; i!= 50+5; i++){//This formation is to create the graphic part.
                           System.out.printf("=");
                        }
                        System.out.printf("%n");
                        System.out.printf("== %-50s==%n",rs.getString("Title") );
                     }
                     for(int i=0; i!= 50+5; i++){//This formation is to create the graphic part.
                        System.out.printf("=");
                     }
                     break;
                  }
                  //Exit the program
                  case 9: 
                     System.out.println("Bye bye, see you soon!\\(T0T )/");
                     repeat = false; 
                     break; 
                  }
               }
            }

         } catch (ClassNotFoundException ex) {
            System.out.println("Could not find database driver class");
            ex.printStackTrace(); 
         } catch (SQLException ex2) {
            System.out.println("An error occurred.");
            ex2.printStackTrace(); 
         } finally {
            if ( conn != null) { 
               try {
                  conn.close(); 
                  System.out.println("Connection is closed.");
               } catch (SQLException ex) { 
                  ex.printStackTrace();
               }
            }
         }
      }
   }


   public void PrintTable(){   
      String[] arr = {"1.Movie", "2.Actor", "3.Remake", "4.Original",
            "5.Award", "6.Review", "7.Release Date", "8.Country",
            "9.Director", "10.Distributor"};
      for(int i=0 ; i<arr.length ; i++){
         System.out.println(arr[i]);
      }
   }
}