package constant;

public class Constant 
{
	public static final String CONFIGFILE=System.getProperty("user.dir")+"\\src\\main\\resources\\config.property";
	public static final String TESTDATA=System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx";
	public static final String VALIDCREDENTIALERROR="User is unable to login with valid credentials";
	public static final String INVALIDCREDENTIALERROR="User is able to login with invalid credentials";
	public static final String INVALIDPASSWORDERROR="User is able to login with invalid password";
	public static final String INVALIDUSERNAMEERROR="User is able to login with invalid username";
	public static final String ADDNEWADMINUSERERROR="Unable to create new user";
	public static final String ADMINUSERNOTFOUNDERROR="User not found";
	public static final String LOGOUTERROR="User is unable to log out";
	public static final String UPDATECONTACTERROR="Unable to update contact";
	public static final String ADDNEWNEWSERROR="Unable to add new news";
	public static final String NEWSNOTFOUNDERROR="News not found";
}
