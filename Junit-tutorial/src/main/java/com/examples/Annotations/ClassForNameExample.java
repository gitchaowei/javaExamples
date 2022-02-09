package com.examples.Annotations;

// test Class.forName()
public class ClassForNameExample {

    public static void main(String[] args) throws ClassNotFoundException {

        Class classlldr = Class.forName("java.lang.ClassLoader");  //lang class loader is passed as parameter
        System.out.println("Name of Class  = " + classlldr.getName());  //get the name of class
        System.out.println("Package Name  = " + classlldr.getPackage());//get the name of class
        System.out.println("Construcors     = " + classlldr.getConstructors());//get the constructor
        System.out.println("Classes        = " + classlldr.getClasses());//get the class
        System.out.println("Interface Name  = " + classlldr.getInterfaces());  //get the name of class

        classlldr = Class.forName("com.examples.Annotations.ForNameClass");
        System.out.println("Name of Class  = " + classlldr.getName());  //get the name of class
        System.out.println("Package Name  = " + classlldr.getPackage());//get the name of class
        System.out.println("Construcors     = " + classlldr.getConstructors());//get the constructor
        System.out.println("Classes        = " + classlldr.getClasses());//get the class
        System.out.println("Interface Name  = " + classlldr.getInterfaces());  //get the name of class

        new ForNameClass();

//        // method 1
//        try {
//            // The newInstance() call is a work around for some
//            // broken Java implementations
//
//            Class.forName("com.mysql.jdbc.Driver");
//
//            // or
//            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//            //
//            Connection con = DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","password");
                // or
//             Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test?", "user=minty", "password=greatsqldb");



//        } catch (SQLException ex) {
//            // handle any errors
//            System.out.println("SQLException: " + ex.getMessage());
//            System.out.println("SQLState: " + ex.getSQLState());
//            System.out.println("VendorError: " + ex.getErrorCode());
//        }

        // another example codes:
//        try{
//            String database="student.mdb";//Here database exists in the current directory
//
//            String url="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};
//            DBQ=" + database + ";DriverID=22;READONLY=true";
//
//            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//            Connection c= DriverManager.getConnection(url);
//            Statement st=c.createStatement();
//            ResultSet rs=st.executeQuery("select * from login");
//
//            while(rs.next()){
//                System.out.println(rs.getString(1));
//            }
//
//        }catch(Exception ee){System.out.println(ee);}

    }



}

class ForNameClass {
    static {
        System.out.println("in Static"); // called when ForNameClass loaded
    }
    {
        System.out.println("in instance");  // called when instance is created
    }
}

//class  getCLOBdata() {
//
//    //Registering the Driver
//      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//    //Getting the connection
//    String mysqlUrl = "jdbc:mysql://localhost/sampledatabase";
//    Connection con = DriverManager.getConnection(mysqlUrl, "root", "password");
//        System.out.println("Connection established......");
//    //Creating a Statement object
//    Statement stmt = con.createStatement();
//    //Inserting values
//    String query = "INSERT INTO Technologies_data VALUES (?, ?, ?)";
//    PreparedStatement pstmt = con.prepareStatement(query);
//      pstmt.setString(1,"JavaFX");
//      pstmt.setString(2,"Java Library");
//    FileReader reader = new FileReader("E:\\images\\javafx_contents.txt");
//      pstmt.setClob(3,reader);
//      pstmt.execute();
//
//      pstmt.setString(1,"CoffeeScript");
//      pstmt.setString(2,"Scripting Language");
//    reader =new FileReader("E:\\images\\coffeescript_contents.txt");
//      pstmt.setClob(3,reader);
//      pstmt.execute();
//
//      pstmt.setString(1,"Cassandra");
//      pstmt.setString(2,"NoSQL Database");
//    reader =new FileReader("E:\\images\\cassandra_contents.txt");
//      pstmt.setClob(3,reader);
//      pstmt.execute();
//
//    //Retrieving the data
//    ResultSet rs = stmt.executeQuery("select * from Technologies_data");
//      System.out.println("Contents of the table are: ");
//      while(rs.next())
//
//    {
//        System.out.println("Article: " + rs.getString("Name"));
//        Clob clob = rs.getClob("Article");
//        Reader r = clob.getCharacterStream();
//        StringBuffer buffer = new StringBuffer();
//        int ch;
//        while ((ch = r.read()) != -1) {
//            buffer.append("" + (char) ch);
//        }
//        System.out.println("Contents: " + buffer.toString());
//        System.out.println(" ");
//    }
//}