package eu.gloria.rti_db.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eu.gloria.tools.uuid.file.UUID;

/**
 * Servlet implementation class FileServlet
 */
@WebServlet("/FileServlet")
public class FileServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private String repositoryBasePath;
	private int repositoryCode;
	private boolean initialized;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {

    		// Always call super.init

    		super.init(config);

    		repositoryBasePath = config.getServletContext().getInitParameter("repositoryBasePath");
    		boolean repBasePathOK = false;
    		try{
    			if (repositoryBasePath != null){
    				File path = new File(repositoryBasePath);
    				if (path.exists()) repBasePathOK = true;
    			}
    			
    		}catch(Exception ex){
    			repBasePathOK = false;
    		}
    		
    		boolean repCode = false;
    		try{
    			repositoryCode = Integer.valueOf(config.getServletContext().getInitParameter("repositoryCode"));
    			repCode = true;
    		}catch(Exception ex){
    			repCode = false;
    		}
    		
    		initialized = repBasePathOK && repCode;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doTask(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doTask(request, response);
	}
	
	private void doTask(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// NO CACHE
		response.setHeader("Cache-control", "no-cache, no-store");
		response.setHeader("Pragma", "no-cache"); 
		response.setHeader("Expires", "-1");
		
		/*response.getOutputStream().print(repositoryBasePath);
		response.getOutputStream().print("-");
		response.getOutputStream().print(repositoryCode);
		if ("1".equals("1")) return;*/
		
		//initialization
		if (!initialized){
			response.sendError(HttpServletResponse.SC_NOT_FOUND); // HTTP 404
			System.out.println("FileServlet. not initialized.");
			return;
		}
		
		//Checks the input parameters
		String format = request.getParameter("format");
		if (format == null || !(format.equals("FITS") || format.equals("JPG"))){
			System.out.println("FileServlet. Wrong format.");
			response.sendError(HttpServletResponse.SC_NOT_FOUND); // HTTP 404
			return;
		}
		
		String uuid = request.getParameter("uuid");
		UUID uuidObj = null;
		try{
			uuidObj = new UUID(uuid);
		}catch(Exception ex){
			System.out.println("FileServlet. Wrong uuid=" + uuid);
			response.sendError(HttpServletResponse.SC_NOT_FOUND); // HTTP 404
			return;
		}
		
		if (uuidObj.getRepository() != repositoryCode){
			System.out.println("FileServlet. Wrong repository code=" + repositoryCode);
			response.sendError(HttpServletResponse.SC_NOT_FOUND); // HTTP 404
			return;
		}
		
		String folder = uuidObj.getFolder();
		
		String fileFullName = repositoryBasePath + folder + File.separator + uuid + "." + format.toLowerCase();
		File fullFile = new File(fileFullName);
		
		if (fullFile.exists()) {
			
			
			FileInputStream fileToDownload = new FileInputStream(fileFullName);
			ServletOutputStream out = response.getOutputStream();
			if (format.equals("JPG")) { //JPG
				response.setContentType("image/jpg");
			} else { //FITS
				response.setContentType("application/octet-stream");
				response.setHeader("Content-Disposition",
						"attachment; filename=" + uuid + "." + format.toLowerCase());
			}
			response.setContentLength(fileToDownload.available());
			
			int c;
			while ((c = fileToDownload.read()) != -1) {
				out.write(c);
			}
			
			/*byte[] fileContent = new byte[512];
			int read = 0;
			while (read  != -1) {
				read = fileToDownload.read(fileContent);
				if (read > -1)	out.write(fileContent, 0, read);
			}*/
			
			out.flush();
			out.close();
			fileToDownload.close();

		}else{
			System.out.println("FileServlet. file does not exist=" + fullFile.toString());
			response.sendError(HttpServletResponse.SC_NOT_FOUND); // HTTP 404
		}
		
	}

}
