package DataBaseConnector;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DB2ValidationData {
    public boolean validateName(String name){
        name = name.trim();
        if(name == null || name.equals("") || name.length() > 100){
            return false;
        }else if(!name.matches("[A-Z][a-z]+( [A-Z][a-z]+)?")){
            return false;
        }
        return true;
    }

    public boolean validateAttractionType(String attractionType){
        if(attractionType.matches("FAST") || attractionType.matches("CALM") || attractionType.matches("WATER") || attractionType.matches("DARK")
        || attractionType.matches("NOISY") || attractionType.matches("DANGER") || attractionType.matches("DARK")){
            return true;
        }
        return false;
    }

    public boolean validateHours(String hours){
        hours = hours.trim();
        if(!hours.matches("([01]?[0-9]|2[0-3]):[0-5][0-9] - ([01]?[0-9]|2[0-3]):[0-5][0-9]")){
            return false;
        }
        return true;
    }

    public boolean validateDate(String strDate) {
        if (strDate.trim().equals("")) {
            return true;
        } else {
            SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
            sdfrmt.setLenient(false);
            try {
                Date javaDate = sdfrmt.parse(strDate);
                System.out.println(strDate+" is valid date format");
            } catch (ParseException e) {
                System.out.println(strDate+" is Invalid Date format");
                return false;
            }
            return true;
        }
    }

    public boolean validateInteger(int number){
        if(number < 0){
            return false;
        }
        return true;
    }

    public boolean validateDouble(double number){
        if(number < 0){
            return false;
        }
        return true;
    }

    public boolean validateConditions(String conditions){
        if(conditions.matches("OPEN") || conditions.matches("CLOSE")){
            return true;
        }
        return false;
    }

    public boolean validateString(String string){
        string = string.trim();
        if(string.length() > 200){
            System.out.println("The string is too long.");
            return false;
        }
        return true;
    }

    public boolean validateEmail(String email){
        email = email.trim();
        if(email == null || email.equals("") || email.length() > 100){
            return false;
        }else if(!email.matches("^(.+)@(.+)$")){
            return false;
        }
        return true;
    }

    public boolean validatePhoneNumber(String phoneNumber){
        phoneNumber = phoneNumber.trim();
        if(phoneNumber == null || phoneNumber.equals("") || phoneNumber.length() > 10){
            return false;
        }else if(!phoneNumber.matches("^(\\d{3}[- .]?){2}\\d{4}$")){
            return false;
        }
        return true;
    }

    public boolean validateProductType(String productType){
        if(productType.matches("FOOD") || productType.matches("CLOTHES") || productType.matches("OTHERS")){
            return true;
        }
        return false;
    }

    public boolean validateGender(String gender){
        if(gender.matches("F") || gender.matches("M")){
            return true;
        }
        return false;
    }

    public boolean validateTicketType(String ticketType){
        if(ticketType.matches("ONE_DAY") || ticketType.matches("TWO_DAYS")|| ticketType.matches("WEEKLY") ||
            ticketType.matches("FAMILY") || ticketType.matches("COMBO") || ticketType.matches("CHILD")){
            return true;
        }
        return false;
    }
}
