import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the address book!");
        ArrayList<Contact> addressBook = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int op =0;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Create a new contact");
            System.out.println("2. Display all contacts");
            System.out.println("3. Edit a contact");
            System.out.println("4. Search by name");
            System.out.println("5. Delete by name");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1 : {
                    Contact userContact = createNewContact();
                    addressBook.add(userContact);
                }
                case 2 : displayContacts(addressBook);
                case 3 : editContact(addressBook);
                case 4 : searchByName(addressBook);
                case 5 : deleteByName(addressBook);
                case 0 : System.out.println("Exiting the address book. Goodbye!");
                default : System.out.println("Invalid option. Please try again.");
            }
            System.out.print("Press 1 to return to menu or 0 to exit: ");
            op = sc.nextInt();
        } while (op != 0);
    }

    public static void displayContacts(ArrayList<Contact> addressBook) {
        if (addressBook.isEmpty()) {
            System.out.println("The address book is empty.");
        } else {
            for (Contact c : addressBook) {
                System.out.println(c);
            }
        }
    }

    public  static void deleteByName(ArrayList<Contact> addressBook) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the first name of the contact you want to delete: ");
        String name = s.nextLine();
        boolean flag = false;

        for (int i = 0; i < addressBook.size(); i++) {
            Contact c = addressBook.get(i);
            if (Objects.equals(c.getFirstName(), name)) {
                addressBook.remove(i);
                System.out.println("Contact deleted successfully.");
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println("Name not found.");
        }
    }

    public static void searchByName(ArrayList<Contact> addressBook) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the first name of the contact you want to search: ");
        String name = s.nextLine();
        boolean flag = false;

        for (Contact c : addressBook) {
            if (Objects.equals(c.getFirstName(), name)) {
                System.out.println(c);
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println("Name not found.");
        }
    }

    public  static void editContact(ArrayList<Contact> addressBook) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the first name of the contact you want to edit: ");
        String name = s.nextLine();
        boolean flag = false;

        for (Contact c : addressBook) {
            if (Objects.equals(c.getFirstName(), name)) {
                editContactDetails(c);
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println("Name not found.");
        }
    }

    public  static void editContactDetails(Contact c) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Change first name");
        System.out.println("2. Change last name");
        System.out.println("3. Change email");
        System.out.println("4. Change city");
        System.out.println("5. Change state");
        System.out.println("6. Change phone number");
        System.out.println("7. Change zip code");
        System.out.print("Enter your choice: ");
        int option = sc.nextInt();
        sc.nextLine();
        switch (option) {
            case 1 : {
                System.out.print("Enter new first name: ");
                String firstName = sc.nextLine();
                c.setFirstName(firstName);
            }
            case 2 : {
                System.out.print("Enter new last name: ");
                String lastName = sc.nextLine();
                c.setLastName(lastName);
            }
            case 3 : {
                System.out.print("Enter new email: ");
                String email = sc.nextLine();
                c.setEmail(email);
            }
            case 4 : {
                System.out.print("Enter new city: ");
                String city = sc.nextLine();
                c.setCity(city);
            }
            case 5 :{
                System.out.print("Enter new state: ");
                String state = sc.nextLine();
                c.setState(state);
            }
            case 6 : {
                System.out.print("Enter new phone number: ");
                long phoneNo = sc.nextLong();
                sc.nextLine();  // Consume newline
                c.setPhoneNo(phoneNo);
            }
            case 7 : {
                System.out.print("Enter new zip code: ");
                long zipCode = sc.nextLong();
                sc.nextLine();  // Consume newline
                c.setZipCode(zipCode);
            }
            default : System.out.println("Invalid option. Please try again.");
        }
    }

    public static Contact createNewContact() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = s.nextLine();
        System.out.print("Enter last name: ");
        String lastName = s.nextLine();
        System.out.print("Enter email: ");
        String email = s.nextLine();
        System.out.print("Enter city: ");
        String city = s.nextLine();
        System.out.print("Enter state: ");
        String state = s.nextLine();
        System.out.print("Enter phone number: ");
        long phoneNo = s.nextLong();
        System.out.print("Enter zip code: ");
        long zipCode = s.nextLong();
        return new Contact(firstName, lastName, email, city, state, phoneNo, zipCode);
    }
}
