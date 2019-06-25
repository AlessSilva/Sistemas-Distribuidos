package proxy;

import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.*;
import java.util.Base64;

import javax.imageio.ImageIO;

import client.*;

public class Proxy {
	
	private ClientTCP client;
	
	
	public Proxy() {
		try {
			client = new ClientTCP();
		} catch ( Exception e ) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public String ReconhecerElementos( File file ) {
		
		try {
			
			byte[] fileContent = Files.readAllBytes(file.toPath());
			String imageString =  new String( Base64.getEncoder().encode(fileContent) );
			
			String response = client.doOperation("ObjectDetection", 1, imageString );
			
			if( response.equals("erro") ) {
				return response;
			}
			
			fileContent = Base64.getDecoder().decode(response);
			
			BufferedImage i = ImageIO.read( new ByteArrayInputStream(fileContent) );
			String path = "/home/alessandro/Pictures/Result";
			ImageIO.write(i, "jpg", new File(path));
			
			return path;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	public String AplicarFiltroBW( File file ) {
		
		try {
			byte[] fileContent = Files.readAllBytes(file.toPath());
			String imageString =  new String( Base64.getEncoder().encode(fileContent) );
			
			String response = client.doOperation("ObjectDetection", 2, imageString );
			
			if( response.equals("erro") ) {
				return response;
			}
			
			fileContent = Base64.getDecoder().decode(response);
			BufferedImage i = ImageIO.read( new ByteArrayInputStream(fileContent) );
			String path = "/home/alessandro/Pictures/Result";
			ImageIO.write(i, "jpg", new File(path));
			
			return path;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	
	public void close() {
		client.close();
	}

}
