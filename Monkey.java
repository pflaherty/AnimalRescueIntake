// Student name: Paige Flaherty

package grazioso.milestone;

public class Monkey extends RescueAnimal {
	
    // Instance variable for Monkey class
	// Using String for all variables because they will be part of an array
    private String tailLength;  
    private String height;  
    private String bodyLength;  
    private String species;

    // Default constructor that initiates all variables from base class and derived class
    public Monkey(String name, String gender, String age, String weight,
    String acquisitionDate, String acquisitionCountry, String trainingStatus,
	String reserved, String inServiceCountry, String tailLength,
	String height, String bodyLength, String species) {
        setName(name);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        setTailLength(tailLength);
        setHeight(height);
        setBodyLength(bodyLength);
        setSpecies(species);

}

	public String getTailLength() {
		return tailLength;
	}

	public void setTailLength(String tailLength) {
		this.tailLength = tailLength;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getBodyLength() {
		return bodyLength;
	}

	public void setBodyLength(String bodyLength) {
		this.bodyLength = bodyLength;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}
}