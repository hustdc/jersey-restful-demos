package caiweiwei.com.cn.json;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Path("/json")
public class PostGetJson {
	
	@GET
	@Produces("application/json")
	public MyJaxbBean getMyBean() {
	    return new MyJaxbBean("Agamemnon", 32);
	}
}
