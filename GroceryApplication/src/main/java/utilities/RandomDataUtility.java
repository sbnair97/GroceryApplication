package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility 
{

	Faker fk = new Faker();
	public String generateRandomUsername()
	{
		return fk.name().username();
	}
	public String generateRandomPassword()
	{
		return fk.internet().password();
	}
	public String generateFullName()
	{
		return fk.name().fullName();
	}
	public String generateRandomEmailId()
	{
		return fk.internet().emailAddress();
	}
	public String getRandomPhoneNumber()
	{
		return fk.phoneNumber().cellPhone();
	}
}
