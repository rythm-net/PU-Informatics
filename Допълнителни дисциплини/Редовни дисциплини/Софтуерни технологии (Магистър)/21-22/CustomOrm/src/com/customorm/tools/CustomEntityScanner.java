package com.customorm.tools;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;

public class CustomEntityScanner {
	
	public static ArrayList<Class> scannPackage(String packageName) {
		
		String packagePath = packageName.replace('.', '/');
		
		try {
 
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			Enumeration<URL> classUrlCollection =  loader.getResources(packagePath);
				
			while(classUrlCollection.hasMoreElements()) {
				
				URL classUrl 					= classUrlCollection.nextElement();
				File classFileRepresentation 	= new File(classUrl.getFile());  
				return extractClassFromFile(classFileRepresentation, packageName);
			}
			
			return null;
			
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	private static ArrayList<Class> extractClassFromFile(
			File classFileReference, 
			String packageName
	) throws ClassNotFoundException {
		
		ArrayList<Class> classCollection = new ArrayList();
		File[] fileCollection = classFileReference.listFiles();
		
		for(File singleFile : fileCollection) {
			
			String fileName 	 = singleFile.getName();
			String className 	 = fileName.replaceAll(".class", "");
			String fullClassName = packageName + "." + className; 
			Class classReference = Class.forName(fullClassName);
			classCollection.add(classReference);
		}
		
		return classCollection;
	}
	
}
