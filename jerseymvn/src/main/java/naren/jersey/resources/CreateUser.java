package naren.jersey.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import naren.jersey.pojo.User;
import naren.jersy.common.Status;
import naren.spring.beans.StoreData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("User")
public class CreateUser{

	@Autowired
	private StoreData storeData;
	@Autowired
	private Status status;

	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@POST
	@Path("CreateUser")
	public Response createUser(User user) {
		if (validate(user)) {
			int userId= getId();
			storeData.addUser(userId,user);
			status.setStatus("Success");
			status.setUserId(userId);
			status.setCode(200);
		}else{
			status.setStatus("Failure. Please check the input parameters");
			status.setCode(500);
		}
		System.out.println(storeData.getUser());
		return Response.ok(status).build();
	}
	
	@GET
	@Path("/{userId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getUser(@PathParam("userId") int userId){
		if(storeData.getUser().containsKey(userId)){
			status.setStatus("Success");
			status.setMessage("message"+storeData.getUser().get(userId));	
		}else{
			status.setStatus("Failure");
			status.setMessage("No Data Found");
		}
		return Response.ok(status).build();
	}

	private int getId() {
		return storeData.getUser().size() + 1;
	}

	private boolean validate(User user) {
		if ((user.getLname() != null && !"".equals(user.getName()))
				&& (user.getLname() != null && !"".equals(user.getLname()))) {
			return true;
		}
		return false;
	}

}
