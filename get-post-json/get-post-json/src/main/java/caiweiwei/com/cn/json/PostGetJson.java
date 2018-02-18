package caiweiwei.com.cn.json;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;


@Path("/json")
public class PostGetJson {
	
	@Path("/get_json")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public MyJaxbBean getMyBean() {
	    return new MyJaxbBean("Agamemnon", 32);
	}
	
	@Path("/post_json")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void postMyBean(MyJaxbBean myJaxBean) {
		System.out.println(myJaxBean.getName());
	}
}
