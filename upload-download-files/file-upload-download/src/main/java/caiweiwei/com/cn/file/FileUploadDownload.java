package caiweiwei.com.cn.file;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;

import javax.ws.rs.PathParam;
import javax.ws.rs.POST;


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
	
	@POST
	@Path("{id}")
	public void post(@PathParam("id") String id, File file) {
		File newFile = new File(basePath + id);
		InputStream in;
		OutputStream out;
		int tmpByte;
		try {
			in = new FileInputStream(file);
			newFile.createNewFile();
			out = new FileOutputStream(newFile);
			while((tmpByte = in.read()) != -1){
				out.write((byte)tmpByte);
			}
			in.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}