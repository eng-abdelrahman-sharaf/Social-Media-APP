
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public class DataValidator {

    public static boolean isValidName(String name) {
        return name != null && name.matches("[A-Za-z\\s]{2,}");
    }

    
    public static boolean isValidID(String id) {
        return id != null && id.matches("\\w{4,10}"); 
    }

    
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@[\\w-\\.]+\\.[a-z]{2,}$";
        return email != null && Pattern.matches(emailRegex, email);
    }

  
    public static boolean isValidDate(String dateStr) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(dateStr, formatter);
            return !date.isBefore(LocalDate.now()); 
        } catch (DateTimeParseException e) {
            return false; 
        }
    }

  
    public static boolean isValidMembershipType(String type) {
        String[] allowedTypes = {"basic", "premium", "gold", "silver"};
        for (String allowedType : allowedTypes) {
            if (allowedType.equalsIgnoreCase(type)) return true;
        }
        return false;
    }

    
    public static boolean isValidStatus(String status) {
        String[] allowedStatuses = {"active", "expired", "pending"};
        for (String allowedStatus : allowedStatuses) {
            if (allowedStatus.equalsIgnoreCase(status)) return true;
        }
        return false;
    }

   
    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches("\\d{2,}"); 
    }

}
