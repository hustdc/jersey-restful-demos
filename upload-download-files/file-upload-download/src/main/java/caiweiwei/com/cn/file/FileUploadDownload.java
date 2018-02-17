package caiweiwei.com.cn.file;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.io.File;
import javax.ws.rs.PathParam;

@Path("/files")
public class FileUploadDownload {
	private static final String basePath = "/home/chao/pictures/";
	
	@GET
	@Path("/{filepath:.*}")
	@Produces("text/plain")
	public File getFile(@PathParam("filepath") String path)
	{
		return new File(basePath + path);
	}
}