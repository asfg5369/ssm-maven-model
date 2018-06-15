package com.ssm.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestHeader;

public class FileDownloadUtils {
	public static void  getFileDownload(HttpServletResponse response, @RequestHeader String referer,String EXTERNAL_FILE_PATH) throws IOException {
		File file = new File(EXTERNAL_FILE_PATH);
		if (file.exists()) {
			response.setContentType("application/octet-stream;charset=utf-8");
			response.addHeader("Content-Disposition", "attachment; filename="+file.getName());
			FileInputStream fileInputStream = new FileInputStream(file);
			byte[] by = new byte[fileInputStream.available()];
			fileInputStream.read(by);
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(by);
			fileInputStream.close();
			outputStream.close();
		}
	}
}
