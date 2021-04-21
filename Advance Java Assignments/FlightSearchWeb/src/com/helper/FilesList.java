package com.helper;

import java.io.*;
import java.net.URLDecoder;
import java.nio.file.Paths;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

public class FilesList   {
	public static  String[] getFilesPath(String path) throws UnsupportedEncodingException {
		try {
//		String path="D:\\STS Workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\FlightSearchWeb\\Files";
		path=path+"\\Files";
		File file=new File(path);
		System.out.println(path);
		
		String[] str=file.list();
		if(str==null) {
			System.out.println("null");
			return null;
		}
		for(int i=0;i<str.length;i++) {
			
			str[i]=path+File.separator+str[i];	
			System.out.println(str[i]);
		}
		return str;
		}

		finally {
		} 
		
		
		
		
}}
