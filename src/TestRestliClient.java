import java.util.Collections;

import com.chinamobile.rcs.newrcsserver.Account;
//import com.chinamobile.rcs.newrcsserver.CreateRequest;
import com.chinamobile.rcs.newrcsserver.Identity;
import com.chinamobile.rcs.newrcsserver.IdentityType;
import com.chinamobile.rcs.newrcsserver.RegistrationBuilders;
import com.chinamobile.rcs.newrcsserver.RegistrationCreateBuilder;
import com.linkedin.r2.transport.common.Client;
import com.linkedin.r2.transport.common.bridge.client.TransportClientAdapter;
import com.linkedin.r2.transport.http.client.HttpClientFactory;
import com.linkedin.restli.client.CreateRequest;
import com.linkedin.restli.client.ResponseFuture;
import com.linkedin.restli.client.RestClient;
import com.linkedin.restli.common.EmptyRecord;

public class TestRestliClient {

	public static void main(String[] args) throws Exception {
		final HttpClientFactory http = new HttpClientFactory();
		final Client r2Client = new TransportClientAdapter(
				http.getClient(Collections.<String, String> emptyMap()));

		// Create a RestClient to talk to localhost:8080
		RestClient restClient = new RestClient(r2Client,
				"http://localhost:8080/newrcsserver-server/");
		RegistrationCreateBuilder registrationCreateBuilder = new RegistrationBuilders()
				.create();
		Account account = new Account().setIdentity(new Identity()
				.setIdentityStr("cmti95035@gmail.com").setIdentityType(
						IdentityType.EMAIL));
		CreateRequest<Account> registrationReq = registrationCreateBuilder
				.input(account).build();

		ResponseFuture<EmptyRecord> createFuture = restClient
				.sendRequest(registrationReq);

		System.out.println("Status code from publishing activity: "
				+ createFuture.getResponse().getStatus());
		System.out.println("It builds successfully!");
	}
}
