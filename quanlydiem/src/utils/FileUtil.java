package utils;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import constans.GlobalConstans;

public class FileUtil {

	public static String rename(String fileName) {
		String nameFile = "";
		if (!fileName.isEmpty()) {
			String[] arrImg = fileName.split("\\.");
			String duoiFileImg = arrImg[arrImg.length - 1];
			
			for (int i = 0; i < (arrImg.length - 1); i++) {
				if (i == 0) {
					nameFile = arrImg[i];
				} else {
					nameFile += "-" + arrImg[i];
				}
			}
			nameFile = nameFile + "-" + System.nanoTime() + "." + duoiFileImg;
		}
		return nameFile;
	}

	public static String getName(final Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
	
	//method upload file
	public static String upload(String fileExcel, HttpServletRequest request)
			throws ServletException, IOException {
		String filePath = null;
		Part part = request.getPart(fileExcel);
		String fileName = rename(part.getSubmittedFileName());
		if(!"".equals(fileName)) {
			// lấy đường dẫn thực của dự án
			String dirPath = request.getServletContext().getRealPath("")+ GlobalConstans.DIR_UPLOAD;
			File saveDir = new File(dirPath);
			if(!saveDir.exists()) {
				saveDir.mkdirs();
			}
			filePath = dirPath + File.separator + fileName;
			part.write(filePath);
		}
		return fileName;
	}
	
	// xóa file ảnh đã có trong thư mục
	public static boolean delFile(String fileName, HttpServletRequest request) {
		if(!"".equals(fileName)) {
			String filePart = request.getServletContext().getRealPath("")+
					GlobalConstans.DIR_UPLOAD + File.separator + fileName;
			File file = new File(filePart);
			file.delete();
		}
		return false;
	}
}
