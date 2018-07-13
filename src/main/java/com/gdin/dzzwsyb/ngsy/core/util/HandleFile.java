package com.gdin.dzzwsyb.ngsy.core.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.MultipartFile;

public class HandleFile {

	public static void savePhoto(MultipartFile file, String id, String url) throws IOException {
		InputStream input = file.getInputStream();
		BufferedImage source = ImageIO.read(input);
		BufferedImage image = new BufferedImage(source.getWidth(), source.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = image.createGraphics();
		graphics.drawImage(source, 0, 0, null);
		ImageIO.write(image, "JPEG", new File(url + id));
	}

}
