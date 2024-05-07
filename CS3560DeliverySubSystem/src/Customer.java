import java.sql.*;

public class Customer {
    private int customerID;
    private String fName;
    private String lName;
    private String phoneNumber;
    private String paymentInfo;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Customer customer1 = new Customer(2, "9356741034", "Credit", "Drake", "Drizzy");
    }


    Customer(int customerID, String phoneNumber, String paymentInfo, String fName, String lName) throws ClassNotFoundException, SQLException {
        this.customerID = customerID;
        this.fName = fName;
        this.lName = lName;
        this.phoneNumber = phoneNumber;
        this.paymentInfo = paymentInfo;

         //SQL statement
         String sqlQuery = "INSERT INTO cs3560dfss.customer(customer_id, phoneNumber, paymentInfo, firstName, lastName) VALUES (?, ?, ?, ?, ?)";
         //Opens connection to the database
         Connection dbConnect = ConnectToServer.openConnect();
         //Try statement for inserting values into the database
         try (PreparedStatement sqlSt = dbConnect.prepareStatement(sqlQuery)) {
             // Set parameters for the SQL statement
             sqlSt.setInt(1, customerID);
             sqlSt.setString(2, phoneNumber);
             sqlSt.setString(3, paymentInfo);
             sqlSt.setString(4, fName);
             sqlSt.setString(5, lName);
 
             // Execute the SQL statement
             int rowsInserted = sqlSt.executeUpdate();
             if (rowsInserted > 0) {
                 //Successfully entering the value
                 System.out.println("Data inserted into database.");
             } else {
                 //Did not enter any values
                 System.err.println("Error: Failed to insert data into database.");
             }
             //Try-Catch throw for errors
         } catch (SQLException error) {
             System.err.println("Error inserting data into database: " + error.getMessage());
             error.printStackTrace();
         }
         //Closing the connection to the database (no leaks)
         ConnectToServer.closeConnect(dbConnect);
    }

     // METHODS FOR CUSTOMER (USE CASES)
        // VIEW MENU -- RATE/REVIEW SERVICE -- FILL SHOPPING CART -- CHECK STATUS -- CANCEL ORDER -- VIEW REVIEW

    public ResultSet viewMenu() {
        return null;
    };

    public void rateService() {

    };

    public void fillShoppingCart() {

    };

    public String checkStatus(int orderID) {
        return null;
    };

    public void cancelOrder(int orderID) {

    };

    public ResultSet viewReviews() {
        return null;
    };




}