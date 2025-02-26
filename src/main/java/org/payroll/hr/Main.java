package org.payroll.hr;

import java.text.SimpleDateFormat;
import java.util.*;


public class Main {

    private static final int ACCEPTED_COMPANY_NAME_LEN=3;
    private static final String COMPANY_NAME = "Enter the name of the Company - ";
    private static final String PRE_NARR =  "Please enter the ";
    private static final String COMPANY_NAME_NARR = "Company Name";
    private static boolean COMPANY_NAME_CREATED = false;
    private static boolean COMPANY_EXISTS = false;
    private static boolean COMPANY_ADDRESS_EXISTS = false;
    private static final String COMPANY_NAME_EXISTS_ERROR= "Company name has already been created - Unable to change Company name at this time\n";
    private static final String COMPANY_ADDRESS_CREATED= "Company address has already been created - Unable to change Company address at this time\n";
    private static final String NO_COMPANY = "You must create a Company name before setting Company address\n";
    private static final String COMPANY_ADDRESS = "Enter the address of the Company (Street, City, Postcode, State)";
    private static final String[] COMPANY_DETAILS = { "Street - ", "City - ", "Postcode - ", "State - "};
    private  static final String SETUP_INCOMPLETE = "Company setup is incomplete - Must create a Company and Address to access Payroll Menu\n";
    private static final int COMPANY_PAYROLL_APPLICATION = 3;
    private static final int EXIT_APPLICATION = 4;
    private static final String COMPANY_NOT_CREATED = "\nInvalid Selection - Company has not yet been created.\nBoth Company Name and Address must be created first\n";
    private static final String INVALID_CHOICE_PAYROLL_NOT_COMPLETE = " Invalid choice\\nPlease select a valid option!\\nNOTE: Payroll Menu not available until Company Name and Address setup is complete!\n\n";
    private static final String HOURS_WORKED = "Enter number of hours (as integer) the contractor worked - ";
    private static final String PARTS_COST = "Enter the cost of the parts - ";
    private static final String CONTRACTOR_NAME = "Enter the name of the contractor or Business Name - ";
    private ArrayList<Contractor> contractors = new ArrayList<Contractor>();
    private final static String PAYROLL_MENU = """            
    
            Company Payroll System
            
            1. Create new Contractor
            2. Create new Salary Employee
            3. Create Hourly Employee
            4. Exit Payroll Application
            
            Enter your selection (1-4) -\s""";
    private final static String COMPANY_MENU = """           
            
            Company Maintenance
            
            1. Create new Company
            2. Add Company Address
            3. Open Company Payroll Menu
            4. Exit Payroll Application
            
            Enter your selection (1-4) -\s""";
    private Company mainCompany;
    private String companyName = "";

    public static void main(String[] args) {
        Main program = new Main();
        Scanner userInput = new Scanner(System.in);
        boolean runApp = true;
        while (runApp) {
            runApp = program.executeMenus(userInput);
        }
        System.out.println("\nExiting Payroll Application\nGood Bye\n");
    }




    private void runPayrollApplication(Scanner input) {
        int selection;
        selection = askIntegerInput(input,PAYROLL_MENU, 1, 4 );
        switch (selection) {

            case 1:
                createContractor(input);
                break;
            case 2:
              //  createSalaryEmployee(input);
                break;
            case 3:
              //  createhourlyEmployee(input);
                break;
            default:
                break;
        }
    }

    private void createContractor(Scanner input) {
        int hoursWorked = askIntegerInput(input, HOURS_WORKED,1, 10);
        double partsCost = askDoubleInput(input, PARTS_COST, 1,1000);
        String name = askStringInput(input, CONTRACTOR_NAME);
        contractors.add(new Contractor(name, hoursWorked, partsCost));
    }



    private boolean executeMenus(Scanner input) {
        int selection;
        if (COMPANY_EXISTS && COMPANY_ADDRESS_EXISTS) {
            selection = askIntegerInput(input,PAYROLL_MENU, 1, 4 );
            if (selection!=EXIT_APPLICATION) {
                runPayrollApplication(input);
            } else {
                return false;
            }

        } else {
            selection = askIntegerInput(input,COMPANY_MENU, 1, 4 );
            if (selection!=EXIT_APPLICATION) {
                runCompanyMaintenance(selection, input);
                return true;
            }
        }
        return false;
    }

    private String generatePayDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }

        private void runCompanyMaintenance(int selection, Scanner input) {

        String[] details = new String[4];

        switch (selection) {
            case 1:
                if (!COMPANY_NAME_CREATED) {
                    companyName = createCompanyName(input);
                } else {
                    errorNarration(COMPANY_NAME_EXISTS_ERROR);
                }
                break;

            case 2:
               if (COMPANY_NAME_CREATED && !COMPANY_ADDRESS_EXISTS) {
                   details= addCompanyAddress(input);
                   mainCompany = createCompanyObject(details, companyName);
               } else if (!COMPANY_NAME_CREATED){
                   errorNarration(NO_COMPANY);
               } else {
                   errorNarration(COMPANY_ADDRESS_CREATED);
               }
                break;
            case 3:
                if (COMPANY_EXISTS && COMPANY_ADDRESS_EXISTS) {
                    runPayrollApplication(input);
                } else {
                    errorNarration(COMPANY_NOT_CREATED);
                }
            default:
                System.out.println(INVALID_CHOICE_PAYROLL_NOT_COMPLETE);
                break;
       }

    }

    private void errorNarration(String narration) {
        System.out.println(narration);
    }

     private Company createCompanyObject(String[] addAdressDetails, String name) {
        Address address = new Address(addAdressDetails[0], addAdressDetails[1], addAdressDetails[2],addAdressDetails[3]);
        return new Company(name, address);
     }

    private String askStringInput(Scanner input, String narr) {
        System.out.print(narr);
        String userInput = input.nextLine();
        if (!isAlphabet(userInput)) {

            System.out.printf("Invalid Input\n\n%s ", narr);
            userInput = input.nextLine();
        }
        return userInput;
    }

    private boolean isAlphabet(String s) {
        return s.matches("[\\w\\s]*");
    }


    private String createCompanyName(Scanner input) {
        boolean valid = false;
        String companyName="";
        while (!valid) {
            companyName = askStringInput(input, COMPANY_NAME);
            if (companyName.isEmpty() || companyName.length()<=ACCEPTED_COMPANY_NAME_LEN) {
                System.out.println("\nInvalid Company name - Must only contain letters, numbers and spaces and be at least 4 characters\n");
            } else {
                valid = true;
            }
        }
        COMPANY_NAME_CREATED = true;
        return companyName;
    }


    private String[] addCompanyAddress(Scanner input) {
        String[] details = new String[4];
        int i = 0;
        boolean valid;
        for (String companyAdd : COMPANY_DETAILS) {
            valid = false;
            while (!valid) {

                System.out.print(PRE_NARR + companyAdd);
                details[i] = input.nextLine();
                if (!validString(details[i])) {
                    System.out.printf("Invalid Company %s - must only contain letters, numbers or spaces. Minimum length must be greater than 3 characters\n", companyAdd);
                } else if (!isAlphabet(details[i])) {
                    System.out.printf("Please enter a valid %s (Letters, numbers and spaces only)\n", companyAdd);
                } else {
                    valid = true;
                    i++;
                }
            }
        }
        return details;


    private boolean validString(String s) {
        return !s.isBlank() && s.length() >= ACCEPTED_COMPANY_NAME_LEN;
    }






    /**
     * Method for getting input as an integer - validated input plus given range of acceptable values
     * @param narration Prompt for the user instructing what input required
     * @param lowerLimit Lowest acceptable value
     * @param upperLimit Highest acceptable value
     * @return The integer entered by user in console
     */
    public int askIntegerInput(Scanner userInput, String narration, int lowerLimit, int upperLimit) {
        boolean valid = false;
        int num =0;
        while (!valid) {
            System.out.print( narration );
            try {
                num = userInput.nextInt();
                userInput.nextLine();
                if ((num<lowerLimit) || (num>upperLimit)) {
                    System.out.printf("Invalid input - enter a number greater than %d and less than %d\n", lowerLimit, upperLimit);
                } else {
                    valid = true;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input - please enter an integer\n");
            }
        }
        return num;
    }

    /**
     * Method for getting input as a double - validated input plus given range of acceptable values
     * @param narration Prompt for the user instructing what input required
     * @param lowerLimit Lowest acceptable value
     * @param upperLimit Highest acceptable value
     * @return The double entered by user in console
     */
    public double askDoubleInput(Scanner userInput, String narration, double lowerLimit, double upperLimit) {
        boolean valid = false;
        double num =0;
        while (!valid) {
            System.out.print(narration);

            try {
                num = userInput.nextDouble();
                userInput.nextLine();
                valid = true;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input - please enter an number\n");
            }
        }
        return num;
    }


}