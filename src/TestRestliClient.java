import com.chinamobile.rcs.newrcsserver.Account;
//import com.chinamobile.rcs.newrcsserver.CreateRequest;
import com.chinamobile.rcs.newrcsserver.Identity;
import com.chinamobile.rcs.newrcsserver.IdentityType;
import com.chinamobile.rcs.newrcsserver.RegistrationBuilders;
import com.chinamobile.rcs.newrcsserver.RegistrationCreateBuilder;


public class TestRestliClient {

	public static void main(String[] args){
		RegistrationCreateBuilder registrationCreateBuilder = new RegistrationBuilders().create();
		Account account = new Account().setIdentity(
				new Identity().setIdentityStr("cmti95035@gmail.com").setIdentityType(IdentityType.EMAIL));
		//CreateRequest<Account> registrationReq = registrationCreateBuilder.input(account).build();
		
		System.out.println("It builds!");
	}
}
