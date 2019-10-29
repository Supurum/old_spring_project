package com.pjt.util.ys;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.util.FileCopyUtils;

import com.pjt.exception.ys.MyException;

public class UploadFileUtils {
	
	public static String calcPath(String uploadPath) {
		
		DecimalFormat decimalFormat = new DecimalFormat("00");
		Calendar cal = Calendar.getInstance();
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		// -> /2017
		int month = cal.get(Calendar.MONTH) + 1;
		String monthPath = yearPath + File.separator + decimalFormat.format(month);
		// -> /2017/10
		int date = cal.get(Calendar.DATE);
		String datePath = monthPath + File.separator + decimalFormat.format(date);
		// -> /2017/10/26
		
		makeDir(uploadPath, yearPath, monthPath, datePath);
		
//		String uploadFullPath = uploadPath + ;
		return datePath; // /2017/10/26
	}
	
	private static void makeDir(String uploadPath, String... paths) {
		// paths -> /2017, /2017/10, /2017/10/26
		File f = new File(uploadPath + File.separator + paths[paths.length-1]);
		
		if (f.exists()) {
			return;
		}
		
		for (String path : paths) {
			File dirPath = new File(uploadPath + path);
			
			if (! dirPath.exists()) {
				dirPath.mkdir();
			}
		}
		
	}
	
	private static String makeThumbnail(
			String uploadPath,	// D://upload
			String path, // /2017/10/26
			String fileName) // uuid-filename 
					throws Exception {
		
		File sourceFile = new File(uploadPath + path, fileName);
		BufferedImage sourceImg = ImageIO.read(sourceFile);
		
		int height = sourceImg.getHeight();
		
		BufferedImage destImg = null;
		
		// 원본 이미지의 높이가 100보다 작은경우 원본 크기 유지
		if (height <= 100) {
			destImg = Scalr.crop(sourceImg, 
					sourceImg.getWidth(), sourceImg.getHeight());
		} else {
			destImg = Scalr.resize(
					sourceImg, Scalr.Method.AUTOMATIC, 
					Scalr.Mode.FIT_TO_HEIGHT, 100);
		}
		
		
		String thumbnailName = 
				uploadPath + path + File.separator + "s_" + fileName;
		
		File destFile = new File(thumbnailName);
		
		String formatName = MediaUtils.getFormatName(fileName);
		
		ImageIO.write(destImg, formatName, destFile);
		
		String s = thumbnailName.substring(uploadPath.length());
		s = s.replace(File.separatorChar, '/');
		

		return s; // /2017/10/26/s_<oFileName>
		
	}
	
	public static String uploadFile(
			String uploadPath, String originalName, byte[] fileData) 
					throws Exception {
		
		UUID uuid = UUID.randomUUID();
		String savedName = uuid.toString() + "_" + originalName;
		String savedPath = calcPath(uploadPath);
		
		File target = new File(uploadPath + savedPath, savedName);
		FileCopyUtils.copy(fileData, target);
		
		int dotIndex = originalName.lastIndexOf(".");
		
		String formatName = originalName.substring(dotIndex + 1);
		
		String uploadFileName = null;
		
		if (MediaUtils.getMediaType(formatName) != null) {
			uploadFileName =  makeThumbnail(uploadPath, savedPath, savedName);
			//System.out.println("uploadFileName:" + uploadFileName);
		} else {
			throw new MyException("이미지가 아닙니다.", 0x00);
//			uploadFileName = makeIcon(uploadPath, savedPath, savedName);
		}
		
		return uploadFileName;
	}
	
	private static String makeIcon(
			String uploadPath, String path, String fileName) 
					throws Exception {
		// -> uploadPath: D:\\upload
		// -> path: \\2017\\10\\27 -> 2017/10/27
		// -> fileName: xxxx.mp3
		
		String iconName = uploadPath + path + File.separator + fileName;
		// -> D:\\upload\\2017\\10\\27\\xxxx.mp3
		String s = iconName.substring(uploadPath.length());
		// -> \\2017\\10\\27\\xxxx.mp3
		String retName = s.replace(File.separatorChar, '/');
		System.out.println("retName:" + retName);
		
		return retName;
	}
	
	public static void deleteOriginalImage(
			String uploadPath, String thumbnailName) {
		//thumbnailName:user/displayFile?fileName=/2017/11/27/19527e8c-71f4-4042-b058-581d838275cc_dog.jpg
		int sIndex = thumbnailName.indexOf("s");
		String preStr = thumbnailName.substring(0, sIndex);
		String postStr = thumbnailName.substring(sIndex + 2);
		String originalFileName = uploadPath + preStr + postStr;
		System.out.println("원래 파일 이름:"+originalFileName);
		String targetName = originalFileName.replace('/', File.separatorChar);
		File f = new File(targetName);
		if (f.exists()) {
			f.delete();
		}
	}
	public static void deletethumnailImage(
			String uploadPath, String fileName) {
		int index=fileName.lastIndexOf('/');
		String tempString="";
		tempString=fileName.substring(0,index+1)+"s_";
		
		fileName=tempString+fileName.substring(index+1);
		String localFileName = uploadPath 
				+ fileName.replace('/', File.separatorChar);
		System.out.println("삭제 패스"+localFileName);
		File f = new File(localFileName);
		if (f.exists()) {
			f.delete();
		}
	}
	
	public static void deleteLocalFile(
			String uploadPath, String fileName) {
		String localFileName = uploadPath 
				+ fileName.replace('/', File.separatorChar);
		System.out.println("삭제 패스"+localFileName);
		File f = new File(localFileName);
		if (f.exists()) {
			f.delete();
		}
	}

}
