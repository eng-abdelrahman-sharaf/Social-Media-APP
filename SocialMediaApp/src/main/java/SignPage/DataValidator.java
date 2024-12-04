/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SignPage;

//this is DataValidator interface
//follow the rules behind the methoeds (Notes)
//characters --> ch
public interface DataValidator {

    boolean isValidName(String name);// Only ch and _ btw{2,}

    boolean isValidID(String id); //any thing btw{4,10}

    boolean isValidEmail(String email); // email should have ch @ ch . ch  btw{5,}

    boolean isValidDate(String dateStr);// in this format yyyy-MM-dd and Valed 

    boolean isValidStatus(String status); // 

    boolean isValidPhoneNumber(String phoneNumber); // digit btw {6,}

    boolean isStrongPassword(String password); //  method for password validation
    // Medium strength: at least 1 lowercase, 1 uppercase, 1 digit, and minimum 6 characters
}
