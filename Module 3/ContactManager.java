import java.util.*; 
 
public class ContactManager { 
 
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        // Step 4: add contacts here 
        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 123 456 7890"));
        contacts.put("Bob Jordan", new Contact("Bob Jordan", "+1 223 456 7891"));
        contacts.put("Caitlyn Mitchel", new Contact("Caitlyn Mitchel", "+1 323 456 7892"));
        contacts.put("Derrik loft", new Contact("Derrik loft", "+1 423 456 7893"));
        contacts.put("Emanual Richards", new Contact("Emanual Richards", "+1 523 456 7894"));
        contacts.put("Frank Sizzle", new Contact("Frank Sizzle", "+1 623 456 7895"));
 
        // Step 5: look up a contact 
        Contact lookup = contacts.get("Ada Lovelace");

        if (lookup == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(lookup);
        }

        Contact find = contacts.get("John Doe");

        if (find == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(find);
        }
 
        // Step 6: print sorted list 
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());

        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));

        System.out.println("\nAll The Contacts");
        System.out.println("-----------------------");

        for (Contact contact : sorted){
            System.out.println(contact);
        }

    } 
}