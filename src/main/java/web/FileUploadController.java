package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import util.MyPojo;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//@Controller
@RestController
public class FileUploadController {
	
	private final static Logger logger = LogManager.getLogger(FileUploadController.class);

    @RequestMapping(value = "/backend/multipart", method = RequestMethod.POST)
    public MyPojo handleFormUpload(@RequestParam("name") String name,
        @RequestParam("file") MultipartFile file) {

    	logger.info("[m:handleFormUpload] name: " + name);
    	logger.info("[m:handleFormUpload] file: " + file);
    	
        if (!file.isEmpty()) {
            //byte[] bytes = file.getBytes();
            // store the bytes somewhere
           //return "redirect:uploadSuccess";
        	String dest = "/tmp/" + file.getOriginalFilename();
        	logger.info("[m:handleFormUpload] dest: " + dest);
        	try {
				file.transferTo(new File(dest));
			} catch (IllegalStateException e) {
				logger.error("[m:handleFormUpload]", e);
			} catch (IOException e) {
				logger.error("[m:handleFormUpload]", e);
			}
        } else {
           //return "redirect:uploadFailure";
        }
        MyPojo myPojo = new MyPojo();
        myPojo.setTheString(name);
        return myPojo;
        
    }

}
