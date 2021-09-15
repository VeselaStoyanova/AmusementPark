package DataBaseConnector;

import java.util.Scanner;

public class DB2AddItem {
    private static final DB2ValidationData validationData = new DB2ValidationData();

    public static void addPark(DataBaseConnector dataBaseConnector) {
        System.out.print("Please enter the name of the park (max length: 100 symbols): ");
        Scanner park = new Scanner(System.in);
        String parkName = park.nextLine();
        while (!validationData.validateName(parkName)) {
            parkName = park.next();
        }

        System.out.print("Please enter the address of the park (max length: 200 symbols): ");
        Scanner address = new Scanner(System.in);
        String parkAddress = address.nextLine();
        while (!validationData.validateString(parkAddress)) ;
        while (!validationData.validateString(parkAddress)) {
            parkAddress = address.nextLine();
        }

        dataBaseConnector.openConnection();
        String stmnt = "INSERT INTO FN71949.PARKS(NAME, ADDRESS)" + " VALUES ('" + parkName + "','" + parkAddress + "')";
        dataBaseConnector.insert(stmnt);
    }

    public static void addAttraction(DataBaseConnector dataBaseConnector) {
        System.out.print("Please enter the name of attraction (max length: 100 symbols): ");
        Scanner attraction = new Scanner(System.in);
        String attractionName = attraction.nextLine();
        if (!validationData.validateName(attractionName)) {
            attractionName = attraction.nextLine();
        }

        System.out.print("Please enter the name of the park (max length: 200 symbols): ");
        Scanner park = new Scanner(System.in);
        String parkName = park.nextLine();
        if (!validationData.validateName(parkName)) {
            parkName = park.nextLine();
        }

        System.out.print("Please enter the type of the attraction: ");
        Scanner type = new Scanner(System.in);
        String typeName = type.nextLine();
        if (!validationData.validateAttractionType(typeName)) {
            typeName = type.nextLine();
        }

        System.out.print("Please enter the minimum age for the attraction: ");
        Scanner age = new Scanner(System.in);
        int minAge = age.nextInt();
        if (!validationData.validateInteger(minAge)) {
            minAge = age.nextInt();
        }

        System.out.print("Please enter the duration of the attraction: ");
        Scanner duration = new Scanner(System.in);
        int attractionDuration = duration.nextInt();
        if (!validationData.validateInteger(attractionDuration)) {
            attractionDuration = duration.nextInt();
        }

        System.out.print("Please enter the speed of the attraction: ");
        Scanner speed = new Scanner(System.in);
        int attractionSpeed = speed.nextInt();
        if (!validationData.validateInteger(attractionSpeed)) {
            attractionSpeed = speed.nextInt();
        }

        System.out.print("Please enter the dangers of the attraction (max length: 200 symbols): ");
        Scanner dangers = new Scanner(System.in);
        String dangersStr = type.nextLine();
        if (!validationData.validateString(dangersStr)) {
            dangersStr = dangers.nextLine();
        }

        System.out.print("Please enter the minimum height for the attraction: ");
        Scanner height = new Scanner(System.in);
        double minHeight = height.nextDouble();
        if (!validationData.validateDouble(minHeight)) {
            minHeight = height.nextDouble();
        }

        System.out.print("Please enter the work time of the attraction: ");
        Scanner workTime = new Scanner(System.in);
        String workTimeStr = workTime.nextLine();
        if (!validationData.validateHours(workTimeStr)) {
            workTimeStr = workTime.nextLine();
        }

        System.out.print("Please enter the height of the attraction: ");
        Scanner attrHeight = new Scanner(System.in);
        double attractionHeight = attrHeight.nextInt();
        if (!validationData.validateDouble(attractionHeight)) {
            attractionHeight = attrHeight.nextDouble();
        }

        System.out.print("Please enter the length of the attraction: ");
        Scanner attrLength = new Scanner(System.in);
        double attractionLength = attrLength.nextDouble();
        if (!validationData.validateDouble(attractionLength)) {
            attractionLength = attrLength.nextDouble();
        }

        System.out.print("Please enter the condition of the attraction: ");
        Scanner condition = new Scanner(System.in);
        String attractionCondition = condition.nextLine();
        while (!validationData.validateConditions(attractionCondition)) {
            attractionCondition = condition.nextLine();
        }

        dataBaseConnector.openConnection();
        String stmnt = " INSERT INTO FN71949.ATTRACTIONS(NAME, PARK_NAME, TYPE, MINIMUM_AGE, DURATION, SPEED, DANGERS, MINIMUM_HEIGHT, WORK_TIME, HEIGHT, LENGTH, CONDITIONS)"
                + " VALUES ('" + attractionName + "','" + parkName + "','" + typeName + "','" + minAge + "','" + attractionDuration + "','" +
                attractionSpeed + "','" + dangersStr + "','" + minHeight + "','" + workTimeStr + "','" + attractionHeight + "','" + attractionLength + "','"
                + attractionCondition + "')";

        dataBaseConnector.insert(stmnt);
    }

    public static void addVisitors(DataBaseConnector dataBaseConnector) {
        System.out.print("Please enter the visitor unique number: ");
        Scanner visitorUniqueNumber = new Scanner(System.in);
        String visitorsUniqueNumberString = visitorUniqueNumber.nextLine();
        if (!validationData.validateString(visitorsUniqueNumberString)) {
            visitorsUniqueNumberString = visitorUniqueNumber.nextLine();
        }

        System.out.print("Please enter the height of the visitor: ");
        Scanner height = new Scanner(System.in);
        int visitorHeight = height.nextInt();
        if (!validationData.validateInteger(visitorHeight)) {
            visitorHeight = height.nextInt();
        }

        System.out.print("Please enter the age of the visitor: ");
        Scanner age = new Scanner(System.in);
        int visitorAge = age.nextInt();
        if (!validationData.validateInteger(visitorAge)) {
            visitorAge = age.nextInt();
        }

        System.out.print("Please enter the name of the visitor (max length: 100 symbols): ");
        Scanner name = new Scanner(System.in);
        String visitorName = name.nextLine();
        if (!validationData.validateName(visitorName)) {
            visitorName = name.nextLine();
        }

        System.out.print("Please enter the email of the visitor (max length: 100 symbols): ");
        Scanner email = new Scanner(System.in);
        String visitorEmail = email.nextLine();
        if (!validationData.validateEmail(visitorEmail)) {
            visitorEmail = email.nextLine();
        }

        System.out.print("Please enter the phone number of the visitor (max length: 10 symbols): ");
        Scanner phoneNumber = new Scanner(System.in);
        String visitorPhoneNumber = phoneNumber.nextLine();
        if (!validationData.validatePhoneNumber(visitorPhoneNumber)) {
            visitorPhoneNumber = phoneNumber.nextLine();
        }

        dataBaseConnector.openConnection();
        String stmnt = "INSERT INTO FN71949.VISITORS(UNIQUE_NUMBER, HEIGHT, AGE, NAME, EMAIL, PHONE_NUMBER)" +
                "VALUES ('" + visitorsUniqueNumberString + "','" + visitorHeight + "','" + visitorAge + "','" +
                visitorName + "','" + visitorEmail + "','" + visitorPhoneNumber + "')";
        dataBaseConnector.insert(stmnt);
    }

    public static void addTickets(DataBaseConnector dataBaseConnector) {
        System.out.print("Please enter the ticket unique number: ");
        Scanner ticketUniqueNumber = new Scanner(System.in);
        String ticketUniqueNumberString = ticketUniqueNumber.nextLine();
        if (!validationData.validateString(ticketUniqueNumberString)) {
            ticketUniqueNumberString = ticketUniqueNumber.nextLine();
        }

        System.out.print("Please enter the name of the park (max length: 100 symbols): ");
        Scanner park = new Scanner(System.in);
        String parkName = park.nextLine();
        while (!validationData.validateName(parkName)) {
            parkName = park.next();
        }

        System.out.print("Please enter the type of the ticket: ");
        Scanner type = new Scanner(System.in);
        String ticketType = type.nextLine();
        if (!validationData.validateTicketType(ticketType)) {
            ticketType = type.nextLine();
        }

        System.out.print("Please enter the number of visitors: ");
        Scanner number = new Scanner(System.in);
        int numberOfVisitors = number.nextInt();
        if (!validationData.validateInteger(numberOfVisitors)) {
            numberOfVisitors = number.nextInt();
        }

        System.out.print("Please enter the price of the ticket ");
        Scanner price = new Scanner(System.in);
        double ticketPrice = price.nextDouble();
        if (!validationData.validateDouble(ticketPrice)) {
            ticketPrice = price.nextDouble();
        }

        dataBaseConnector.openConnection();
        String stmnt = "INSERT INTO FN71949.TICKETS(UNIQUE_NUMBER, PARK_NAME, TYPE, NUMBER_OF_VISITORS, PRICE)" +
                "VALUES ('" + ticketUniqueNumberString + "','" + parkName + "','" + ticketType + "','" +
                numberOfVisitors + "','" + ticketPrice + "')";
        dataBaseConnector.insert(stmnt);
    }

    public static void addEmployees(DataBaseConnector dataBaseConnector) {
        System.out.print("Please enter the employee work number: ");
        Scanner workNumber = new Scanner(System.in);
        String employeeWorkNumber = workNumber.nextLine();
        if (!validationData.validateString(employeeWorkNumber)) {
            employeeWorkNumber = workNumber.nextLine();
        }

        System.out.print("Please enter the name of the park (max length: 100 symbols): ");
        Scanner park = new Scanner(System.in);
        String parkName = park.nextLine();
        while (!validationData.validateName(parkName)) {
            parkName = park.next();
        }

        System.out.print("Please enter the name of the shop (max length: 100 symbols): ");
        Scanner shop = new Scanner(System.in);
        String shopName = shop.nextLine();
        while (!validationData.validateName(shopName)) {
            shopName = shop.next();
        }

        System.out.print("Please enter the email of the visitor (max length: 100 symbols): ");
        Scanner email = new Scanner(System.in);
        String employeeEmail = email.nextLine();
        if (!validationData.validateEmail(employeeEmail)) {
            employeeEmail = email.nextLine();
        }

        System.out.print("Please enter the phone number of the visitor (max length: 10 symbols): ");
        Scanner phoneNumber = new Scanner(System.in);
        String employeePhoneNumber = phoneNumber.nextLine();
        if (!validationData.validatePhoneNumber(employeePhoneNumber)) {
            employeePhoneNumber = phoneNumber.nextLine();
        }

        System.out.print("Please enter the name of the employee (max length: 100 symbols): ");
        Scanner employee = new Scanner(System.in);
        String employeeName = employee.nextLine();
        if (!validationData.validateName(employeeName)) {
            employeeName = employee.nextLine();
        }

        dataBaseConnector.openConnection();
        String stmnt = "INSERT INTO FN71949.EMPLOYEES(WORK_NUMBER, PARK_NAME, SHOP_NAME, EMAIL, PHONE_NUMBER, " +
                "EMPLOYEE_NAME)" +
                "VALUES ('" + employeeWorkNumber + "','" + parkName + "','" + shopName + "','" + employeeEmail + "','" +
                employeePhoneNumber + "','" + employeeName + "')";
        dataBaseConnector.insert(stmnt);
    }

    public static void addShops(DataBaseConnector dataBaseConnector) {
        System.out.print("Please enter the name of the shop (max length: 100 symbols): ");
        Scanner shop = new Scanner(System.in);
        String shopName = shop.nextLine();
        while (!validationData.validateName(shopName)) {
            shopName = shop.next();
        }

        System.out.print("Please enter the name of the park (max length: 100 symbols): ");
        Scanner park = new Scanner(System.in);
        String parkName = park.nextLine();
        while (!validationData.validateName(parkName)) {
            parkName = park.next();
        }

        System.out.print("Please enter the condition of the shop: ");
        Scanner condition = new Scanner(System.in);
        String conditionString = condition.nextLine();
        if (!validationData.validateConditions(conditionString)) {
            conditionString = condition.nextLine();
        }

        dataBaseConnector.openConnection();
        String stmnt = "INSERT INTO FN71949.SHOPS(NAME, PARK_NAME, CONDITIONS)" +
                "VALUES ('" + shopName + "','" + parkName + "','" + conditionString + "')";
        dataBaseConnector.insert(stmnt);
    }

    public static void addProducts(DataBaseConnector dataBaseConnector) {
        System.out.print("Please enter the inventory number of the product: ");
        Scanner inventoryNumber = new Scanner(System.in);
        String inventoryNumberString = inventoryNumber.nextLine();
        if (!validationData.validateString(inventoryNumberString)) {
            inventoryNumberString = inventoryNumber.nextLine();
        }

        System.out.print("Please enter the supplier work number: ");
        Scanner workNumber = new Scanner(System.in);
        String supplierWorkNumber = workNumber.nextLine();
        if (!validationData.validateString(supplierWorkNumber)) {
            supplierWorkNumber = workNumber.nextLine();
        }

        System.out.print("Please enter the name of the shop (max length: 100 symbols): ");
        Scanner shop = new Scanner(System.in);
        String shopName = shop.nextLine();
        while (!validationData.validateName(shopName)) {
            shopName = shop.next();
        }

        System.out.print("Please enter the price of the product: ");
        Scanner price = new Scanner(System.in);
        double productPrice = price.nextDouble();
        if (!validationData.validateDouble(productPrice)) {
            productPrice = price.nextDouble();
        }

        System.out.print("Please enter the name of the product (max length: 100 symbols): ");
        Scanner product = new Scanner(System.in);
        String productName = product.nextLine();
        while (!validationData.validateName(productName)) {
            productName = product.next();
        }

        System.out.print("Please enter the type of the product: ");
        Scanner type = new Scanner(System.in);
        String productType = product.nextLine();
        if (!validationData.validateProductType(productType)) {
            productType = product.nextLine();
        }

        dataBaseConnector.openConnection();
        String stmnt = "INSERT INTO FN71949.PRODUCTS(INVENTORY_NUMBER, SUPPLIER_WORK_NUMBER, SHOP_NAME, PRICE, " +
                "PRODUCT_NAME, TYPE)" +
                "VALUES ('" + inventoryNumberString + "','" + supplierWorkNumber + "','" + shopName + "','" + productPrice + "','" +
                productName + "','" + productType + "')";
        dataBaseConnector.insert(stmnt);
    }

    public static void addSupplier(DataBaseConnector dataBaseConnector) {
        System.out.print("Please enter the supplier work number: ");
        Scanner workNumber = new Scanner(System.in);
        String supplierWorkNumber = workNumber.nextLine();
        if (!validationData.validateString(supplierWorkNumber)) {
            supplierWorkNumber = workNumber.nextLine();
        }

        System.out.print("Please enter the name of the supplier (max length: 100 symbols): ");
        Scanner supplier = new Scanner(System.in);
        String supplierName = supplier.nextLine();
        if (!validationData.validateName(supplierName)) {
            supplierName = supplier.nextLine();
        }

        System.out.print("Please enter the email of the supplier (max length: 100 symbols): ");
        Scanner email = new Scanner(System.in);
        String supplierEmail = email.nextLine();
        if (!validationData.validateEmail(supplierEmail)) {
            supplierEmail = email.nextLine();
        }

        System.out.print("Please enter the phone number of the supplier (max length: 10 symbols): ");
        Scanner phoneNumber = new Scanner(System.in);
        String supplierPhoneNumber = phoneNumber.nextLine();
        if (!validationData.validatePhoneNumber(supplierPhoneNumber)) {
            supplierPhoneNumber = phoneNumber.nextLine();
        }

        dataBaseConnector.openConnection();
        String stmnt = "INSERT INTO FN71949.SUPPLIERS(WORK_NUMBER, NAME, EMAIL, PHONE_NUMBER)" +
                "VALUES ('" + supplierWorkNumber + "','" + supplierName + "','" + supplierEmail + "','" + supplierPhoneNumber + "')";
        dataBaseConnector.insert(stmnt);
    }

    public static void selectPark(DataBaseConnector dataBaseConnector) {
        dataBaseConnector.openConnection();
        String stmnt = "SELECT NAME, ADDRESS FROM FN71949.PARKS";
        dataBaseConnector.select(stmnt, 2);
        dataBaseConnector.closeConnection();
    }

    public static void selectAttraction(DataBaseConnector dataBaseConnector) {
        dataBaseConnector.openConnection();
        String stmnt = "SELECT NAME, PARK_NAME, TYPE, MINIMUM_AGE, DURATION, SPEED, DANGERS, MINIMUM_HEIGHT, WORK_TIME, " +
                "HEIGHT, LENGTH, CONDITIONS FROM FN71949.ATTRACTIONS";
        dataBaseConnector.select(stmnt, 12);
        dataBaseConnector.closeConnection();
    }

    public static void selectVisitors(DataBaseConnector dataBaseConnector) {
        dataBaseConnector.openConnection();
        String stmnt = "SELECT UNIQUE_NUMBER, HEIGHT, AGE, NAME, EMAIL, PHONE_NUMBER FROM FN71949.VISITORS";
        dataBaseConnector.select(stmnt, 6);
        dataBaseConnector.closeConnection();
    }

    public static void selectTickets(DataBaseConnector dataBaseConnector) {
        dataBaseConnector.openConnection();
        String stmnt = "SELECT UNIQUE_NUMBER, PARK_NAME, TYPE, NUMBER_OF_VISITORS, PRICE FROM FN71949.TICKETS";
        dataBaseConnector.select(stmnt, 5);
        dataBaseConnector.closeConnection();
    }

    public static void selectEmployees(DataBaseConnector dataBaseConnector) {
        dataBaseConnector.openConnection();
        String stmnt = "SELECT WORK_NUMBER, PARK_NAME, SHOP_NAME, EMAIL, PHONE_NUMBER, EMPLOYEE_NAME FROM FN71949" +
                ".EMPLOYEES";
        dataBaseConnector.select(stmnt, 6);
        dataBaseConnector.closeConnection();
    }

    public static void selectShops(DataBaseConnector dataBaseConnector) {
        dataBaseConnector.openConnection();
        String stmnt = "SELECT NAME, PARK_NAME, CONDITIONS FROM FN71949.SHOPS";
        dataBaseConnector.select(stmnt, 3);
        dataBaseConnector.closeConnection();
    }

    public static void selectProducts(DataBaseConnector dataBaseConnector) {
        dataBaseConnector.openConnection();
        String stmnt = "SELECT INVENTORY_NUMBER, SUPPLIER_WORK_NUMBER, SHOP_NAME, PRICE, PRODUCT_NAME, TYPE";
        dataBaseConnector.select(stmnt, 6);
        dataBaseConnector.closeConnection();
    }

    public static void selectSuppliers(DataBaseConnector dataBaseConnector) {
        dataBaseConnector.openConnection();
        String stmnt = "SELECT WORK_NUMBER, NAME, EMAIL, PHONE_NUMBER";
        dataBaseConnector.select(stmnt, 4);
        dataBaseConnector.closeConnection();
    }

    public static void deletePark(DataBaseConnector dataBaseConnector) {
        System.out.println("Please enter the name of the park to be deleted: ");
        Scanner parkName = new Scanner(System.in);
        String parkNameToDelete = parkName.nextLine();
        while (!validationData.validateName(parkNameToDelete)) {
            parkNameToDelete = parkName.nextLine();
        }

        dataBaseConnector.openConnection();
        String stmnt = "DELETE FROM FN71949.PARKS WHERE NAME = " + "'" + parkNameToDelete + "'";
        dataBaseConnector.delete(stmnt);
        dataBaseConnector.closeConnection();
    }

    public static void deleteAttraction(DataBaseConnector dataBaseConnector) {
        System.out.println("Please enter the name of attraction to be deleted: ");
        Scanner attractionName = new Scanner(System.in);
        String attractionNameToDelete = attractionName.nextLine();

        dataBaseConnector.openConnection();
        String stmnt = "DELETE FROM FN71949.ATTRACTIONS WHERE NAME = " + "'" + attractionNameToDelete + "' ";
        dataBaseConnector.delete(stmnt);
        dataBaseConnector.closeConnection();
    }

    public static void deleteVisitor(DataBaseConnector dataBaseConnector) {
        System.out.println("Please enter the unique number of the visitor to be deleted: ");
        Scanner visitorUniqueNumber = new Scanner(System.in);
        String visitorUniqueNumberToDelete = visitorUniqueNumber.nextLine();

        dataBaseConnector.openConnection();
        String stmnt = "DELETE FROM FN71949.VISITORS WHERE UNIQUE_NUMBER = " + "'" + visitorUniqueNumberToDelete + "'";
        dataBaseConnector.delete(stmnt);
        dataBaseConnector.closeConnection();
    }

    public static void deleteTicket(DataBaseConnector dataBaseConnector) {
        System.out.println("Please enter the unique number of the ticket to be deleted: ");
        Scanner ticketUniqueNumber = new Scanner(System.in);
        String ticketUniqueNumberToDelete = ticketUniqueNumber.nextLine();

        dataBaseConnector.openConnection();
        String stmnt = "DELETE FROM FN71949.TICKETS WHERE UNIQUE_NUMBER = " + "'" + ticketUniqueNumberToDelete + "'";
        dataBaseConnector.delete(stmnt);
        dataBaseConnector.closeConnection();
    }

    public static void deleteEmployee(DataBaseConnector dataBaseConnector) {
        System.out.println("Please enter the work number of the employee to be deleted: ");
        Scanner employeeWorkNumber = new Scanner(System.in);
        String employeeWorkNumberToDelete = employeeWorkNumber.nextLine();

        dataBaseConnector.openConnection();
        String stmnt = "DELETE FROM FN71949.EMPLOYEES WHERE WORK_NUMBER = " + "'" + employeeWorkNumberToDelete + "'";
        dataBaseConnector.delete(stmnt);
        dataBaseConnector.closeConnection();
    }

    public static void deleteShop(DataBaseConnector dataBaseConnector) {
        System.out.println("Please enter the name of the shop to be deleted: ");
        Scanner shopName = new Scanner(System.in);
        String shopNameToDelete = shopName.nextLine();

        dataBaseConnector.openConnection();
        String stmnt = "DELETE FROM FN71949.SHOPS WHERE NAME = " + "'" + shopNameToDelete + "'";
        dataBaseConnector.delete(stmnt);
        dataBaseConnector.closeConnection();
    }

    public static void deleteProduct(DataBaseConnector dataBaseConnector) {
        System.out.println("Please enter the inventory number of the product to be deleted: ");
        Scanner inventoryNumber = new Scanner(System.in);
        String inventoryNumberToDelete = inventoryNumber.nextLine();

        dataBaseConnector.openConnection();
        String stmnt = "DELETE FROM FN71949.PRODUCTS WHERE INVENTORY_NUMBER = " + "'" + inventoryNumberToDelete + "'";
        dataBaseConnector.delete(stmnt);
        dataBaseConnector.closeConnection();
    }

    public static void deleteSuppliers(DataBaseConnector dataBaseConnector) {
        System.out.println("Please enter the inventory number of the product to be deleted: ");
        Scanner inventoryNumber = new Scanner(System.in);
        String inventoryNumberToDelete = inventoryNumber.nextLine();

        dataBaseConnector.openConnection();
        String stmnt = "DELETE FROM FN71949.PRODUCTS WHERE INVENTORY_NUMBER = " + "'" + inventoryNumberToDelete + "'";
        dataBaseConnector.delete(stmnt);
        dataBaseConnector.closeConnection();
    }

    public static void printSecondaryMenu() {
        System.out.println("Enter 1 for park");
        System.out.println("Enter 2 for attraction");
        System.out.println("Enter 3 for visitor");
        System.out.println("Enter 4 for ticket");
        System.out.println("Enter 5 for employees");
        System.out.println("Enter 6 for shop");
        System.out.println("Enter 7 for product");
        System.out.println("Enter 8 for supplier");
    }

    public static void printMenu() {
        DataBaseConnector dataBaseConnector = new DataBaseConnector();

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        System.out.println("---ENTER WHAT DO YOU WANT TO DO: ---");
            System.out.println("Enter 1 to select");
            System.out.println("Enter 2 to insert");
            System.out.println("Enter 3 to delete");
            System.out.println("Enter 4 to exit");

            switch (choice) {
                case 1:
                    System.out.println("---ENTER WHAT DO YOU WANT TO SELECT: ---");
                    printSecondaryMenu();
                    int selectChoice = input.nextInt();
                    switch (selectChoice) {
                        case 1:
                            selectPark(dataBaseConnector);
                            break;
                        case 2:
                            selectAttraction(dataBaseConnector);
                            break;
                        case 3:
                            selectVisitors(dataBaseConnector);
                            break;
                        case 4:
                            selectTickets(dataBaseConnector);
                            break;
                        case 5:
                            selectEmployees(dataBaseConnector);
                            break;
                        case 6:
                            selectShops(dataBaseConnector);
                            break;
                        case 7:
                            selectProducts(dataBaseConnector);
                            break;
                        case 8:
                            selectSuppliers(dataBaseConnector);
                            break;
                        default:
                            System.out.println("Not a valid operation");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("---ENTER WHAT DO YOU WANT TO INSERT: ---");
                    printSecondaryMenu();
                    int insertChoice = input.nextInt();
                    switch (insertChoice) {
                        case 1:
                            addPark(dataBaseConnector);
                            break;
                        case 2:
                            addAttraction(dataBaseConnector);
                            break;
                        case 3:
                            addVisitors(dataBaseConnector);
                            break;
                        case 4:
                            addTickets(dataBaseConnector);
                            break;
                        case 5:
                            addEmployees(dataBaseConnector);
                            break;
                        case 6:
                            addShops(dataBaseConnector);
                            break;
                        case 7:
                            addProducts(dataBaseConnector);
                            break;
                        case 8:
                            addSupplier(dataBaseConnector);
                            break;
                        default:
                            System.out.println("Not a valid operation");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("---ENTER WHAT DO YOU WANT TO DELETE: ---");
                    printSecondaryMenu();
                    int deleteChoice = input.nextInt();
                    switch (deleteChoice) {
                        case 1:
                            deletePark(dataBaseConnector);
                            break;
                        case 2:
                            deleteAttraction(dataBaseConnector);
                            break;
                        case 3:
                            deleteVisitor(dataBaseConnector);
                            break;
                        case 4:
                            deleteTicket(dataBaseConnector);
                            break;
                        case 5:
                            deleteEmployee(dataBaseConnector);
                            break;
                        case 6:
                            deleteShop(dataBaseConnector);
                            break;
                        case 7:
                            deleteProduct(dataBaseConnector);
                            break;
                        case 8:
                            deleteSuppliers(dataBaseConnector);
                            break;
                        default:
                            System.out.println("Not a valid operation");
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Exiting from the application.....");
                    input.close();
                    break;
                default:
                    System.out.println("Not a valid operation");
                    break;
            }
    }

    public static void main(String[] args) {
        printMenu();
    }
}
