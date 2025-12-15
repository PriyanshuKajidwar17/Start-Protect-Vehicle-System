import java.util.*;

class Underwriter {
    int id;
    String name;
    String dob;
    String joiningDate;
    String password;

    Underwriter(int id, String name, String dob, String joiningDate, String password) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.joiningDate = joiningDate;
        this.password = password;
    }
}

public class StartProtectVehicle {

    /*
     * 1 → Admin Login
     * 
     * 2 → Underwriter Login
     */
    static HashMap<Integer, Underwriter> underwriter_data = new HashMap<>();
    static int underwriterIdCounter = 1001;

    // credential for Admin user
    static final String Admin_username = "admin";
    static final String Admin_password = "1234";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String str;
        while (true) {

            System.out.println("========== Welcome to Star Protect Vehicle System ================= ");
            System.out.println("choices:");
            System.out.println("1. Admin Login");
            System.out.println("2. Underwriter Login");
            System.out.println("3. Exit from the Star Protect Vehicle System");

            // taking choices from the user

            System.out.println("Enter Your Choice : ");
            str = sc.nextLine();

            switch (str) {
                case "1" -> {
                    String uname;
                    String passwd;
                    System.out.println("=========== Welcome to Admin Pannel =============");
                    // admin login using default userid and password
                    System.out.print("Enter Admin Username : ");
                    uname = sc.nextLine();

                    System.out.print("Enter admin Password : ");
                    passwd = sc.nextLine();

                    // authentication process here
                    if (uname.equals(Admin_username) && passwd.equals(Admin_password)) {
                        System.out.println("Admin " + Admin_username + " Log-in Successfully ... ");
                        adminmenu();
                    }

                }
                case "2" -> {
                    System.out.println("*********** Welcome to UnderWriter Login Panel ************");
                    String uname;
                    String upassword;
                    System.out.print("Enter UnderWriter Username : ");
                    uname = sc.nextLine();
                    System.out.println("Enter Password : ");
                    upassword = sc.nextLine();

                    if (underwriter_data.containsKey(uname) && underwriter_data.containsValue(upassword)) {
                        System.out.println(uname + " UnderWriter Login Successfully.........");
                        underwritermenu();
                    }

                }
                case "3" -> {
                    System.out.println("Thank you for using Star Protect Vehicle System.");
                    return;
                }
                default -> {
                    System.out.println("Invalid Entry....");
                }
            }

        }

    }

    static void underwritermenu() {
        System.out.println("implementing underWriter.....");
    }

    static void adminmenu() {
        String ch;
        while (true) {
            System.out.println("*********** Welcome to Admin Pannel ************");
            System.out.println("1. Add UnderWriter.");
            System.out.println("2. Remove UnderWriter.");
            System.out.println("3. View UnderWriter.");
            System.out.println("4. Search underWritter.");
            System.out.println("5. Update Password.");
            System.out.println("0. LogOut");

            // enter choice
            System.out.println("Enter Your Choice : ");
            ch = sc.nextLine();
            switch (ch) {
                case "1" -> add_underwriter();
                case "2" -> remove_underwriter();
                case "3" -> view_underwriter();
                case "4" -> search_underwritter();
                case "5" -> update_passwd();
                case "0" -> {
                    System.out.println("Successfully Log-Out " + Admin_username);
                    return;
                }
                default -> {
                    System.out.println("Invalid Choice ");
                }
            }
        }

    }

    static void update_passwd() {

    System.out.print("Enter UnderWriter ID: ");
    int id = Integer.parseInt(sc.nextLine());

    // check if underwriter exists
    if (!underwriter_data.containsKey(id)) {
        System.out.println("UnderWriter not found.");
        return;
    }

    System.out.print("Enter New Password: ");
    String newPass = sc.nextLine();

    // password validation (at least one special character)
    if (!newPass.matches(".*[!@#$%^&*()].*")) {
        System.out.println("Password must contain at least one special character.");
        return;
    }

    // update password
    Underwriter u = underwriter_data.get(id);
    u.password = newPass;

    System.out.println("Password updated successfully.");
}


    static void search_underwritter() {
        String id;
        System.out.println("Enter name(id) of the :");
        id = sc.nextLine();
        // search underwritter by id
        if (underwriter_data.containsKey(id)) {
            System.out.println("UnderWriter Found:");
            System.out.println("Username: " + id);
            // System.out.println("Password: " + underwriter_data.get(id));
            // System.out.println("data search using the id : " +
            // underwriter_data.containsKey(id));
        } else {
            System.out.println("data not found..");
        }
    }

    static void add_underwriter() {

        System.out.println("******* Register Underwriter ********");

        int id = underwriterIdCounter++;

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter DOB (dd-mm-yyyy): ");
        String dob = sc.nextLine();

        System.out.print("Enter Joining Date (dd-mm-yyyy): ");
        String joiningDate = sc.nextLine();

        System.out.print("Enter Default Password: ");
        String password = sc.nextLine();

        // password validation
        if (!password.matches(".*[!@#$%^&*()].*")) {
            System.out.println("Password must contain at least one special character.");
            return;
        }

        Underwriter uw = new Underwriter(id, name, dob, joiningDate, password);
        underwriter_data.put(id, uw);

        System.out.println("Underwriter registered successfully.");
        System.out.println("Generated Underwriter ID: " + id);
    }

    static void remove_underwriter() {
        String name;
        System.out.println("****** Remove underwriter. **********");
        System.out.println("Enter Username of UnderWriter: ");
        name = sc.nextLine();

        // underwriter_data.remove(name);
        if (underwriter_data.remove(name) != null) {
            System.out.println("UnderWriter Record removed successfully");
        } else {
            System.out.println(" UnderWriter Record not found ....");
        }
    }

    static void view_underwriter() {
        if (underwriter_data.isEmpty()) {
            System.out.println("No underwriters found.");
            return;
        }

        for (Map.Entry<Integer, Underwriter> e : underwriter_data.entrySet()) {
            Integer Id = e.getKey();
            Underwriter u = e.getValue();
            System.out.println("Id: "+u.id+"Name : "+u.name+" DOB : "+u.dob+" Joining date : "+u.joiningDate);
        }
        // for (Underwriter u : underwriter_data.values()) {
        // System.out.println(
        // "ID: " + u.id +
        // ", Name: " + u.name +
        // ", DOB: " + u.dob +
        // ", Joining Date: " + u.joiningDate
        // );
        // }
    }

}
