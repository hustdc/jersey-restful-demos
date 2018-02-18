package caiweiwei.com.cn.xml;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;

@Path("/xmls")
public class GetPostXml {
	
	@Path("/get_planet")
	@GET
	@Produces(MediaType.APPLICATION_XML)
    public Planet getPlanet() {
    	final Planet planet = new Planet();
    	planet.id = 1;
    	planet.name = "Earth";
    	planet.radius = 1.0;
    	
    	return planet;
    }
	
	@Path("/post_planet")
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void postPlanet(Planet planet) {
		System.out.println(planet);
	}
}
