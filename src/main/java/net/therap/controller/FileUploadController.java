package net.therap.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by imran.azad on 6/24/14.
 */
@Controller
@RequestMapping({"/uploadFile"})
public class FileUploadController {
    Logger logger = LoggerFactory.getLogger(FileUploadController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String redirectToUploadPage(ModelMap model) {
		return "uploadFile";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@RequestParam(value = "name") String username,
						   @RequestParam(value = "file") MultipartFile file,
                           ModelMap model) {
        String responseMessage = "";
        String filename = file.getOriginalFilename();

		if (!file.isEmpty()) {
            try {
                byte bytes[] = file.getBytes();

                String rootPath = System.getProperty("catalina.home");
                logger.info("Root Path : " + rootPath);

                File dir = new File(rootPath + File.separator + "uploadedFiles");
                if (!dir.exists())
                    dir.mkdirs();

                File fileInServer = new File(dir.getAbsolutePath() + File.separator + filename);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fileInServer));
                stream.write(bytes);
                stream.close();

                logger.info("Uploaded File Location : " + fileInServer.getAbsolutePath());
                responseMessage = "File Successfully uploaded to server";
            } catch (IOException e) {
                responseMessage = "Failed to upload file. <br />" + e.getMessage();
            }
        } else {
            responseMessage = "Failed to upload file. <br />" + "File is empty.";
        }

        model.addAttribute("message", responseMessage);
        return "uploadFile";
	}
}
