

public class Vehicle {

    private char vehicleType;
    private char fuelType;
    private String regNumber;

    public Vehicle(char vehicleType, char fuelType, String regNumber) {
        setVehicleType(vehicleType);
        setFuelType(fuelType);
        setRegistrationNumber(regNumber);
    }

    public char getVehicleType() {
        return this.vehicleType;
    }


    public char getFuelType() {
        return this.fuelType;
    }

    public String getRegistrationNumber() {
        return this.regNumber;
    }

    public void setFuelType(char fuelType) {
        if(checkFuelType(fuelType)) {
            this.fuelType = fuelType;
        }
        else {
            throw new IllegalArgumentException("Wrong fuel type");
        }
    }

    public void setVehicleType(char vehicleType) {
        if(checkVehicleType(vehicleType)) {
            this.vehicleType = vehicleType;
        }
        else {
            throw new IllegalArgumentException("Wrong vehicle type");
        }
    }


    public void setRegistrationNumber(String regNumber) {
        if(!validateLegalSignInRegNumber(regNumber)) {
            throw new IllegalArgumentException("RegNumber contains illegal letters or signs");
        }
        if(!checkValidLengthRegNumber(regNumber, getVehicleType())) {
            throw new IllegalArgumentException("RegNumber is not the right lenght");
        }
        if(!compareRegNumberToFuelType(regNumber, getFuelType())) {
            throw new IllegalArgumentException("RegNumber is not right compared to fueltype");
        }

        this.regNumber = regNumber;
    }

    //Alle private metoder under
    private boolean validateLegalSignInRegNumber(String regNumber) {
        return regNumber.matches("^[A-Z]{2}\\d{4,5}$");
    }

    private boolean compareRegNumberToFuelType(String regNumber, char fuelType) {
        String subRegNumber = regNumber.substring(0,2);

        return ((subRegNumber.contains("EL") || subRegNumber.contains("EK")) && fuelType == 'E')
                || (subRegNumber.contains("HY") && fuelType == 'H')
                ||(!(subRegNumber.contains("HY") || subRegNumber.contains("EK") || subRegNumber.contains("EL")) && (fuelType == 'D' || fuelType=='G'));
    }

    private boolean checkValidLengthRegNumber(String regNumber, char vehicleType) {
        return (vehicleType =='C' && regNumber.length() == 7) || (vehicleType=='M' && regNumber.length() == 6);
    }


    private boolean checkFuelType(char fuelType) {
        return (fuelType =='H' && getVehicleType() == 'C') || fuelType == 'E' || fuelType =='G' || fuelType =='D';
    }

    private boolean checkVehicleType(char vehicleType) {
        return vehicleType == 'C' || vehicleType == 'M';
    }


}