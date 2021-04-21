package com.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;


public class Helper {
	static BufferedReader reader;
	private static HttpURLConnection connection;

	public static List<JSONObject> getAllEmp() {
		String line;
		 StringBuffer response=new StringBuffer(); 
		 List<JSONObject> res=new ArrayList<>();
		try {
			URL url =new URL("http://localhost:9090/all");
			connection=(HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			int status=connection.getResponseCode();
			reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while((line=reader.readLine())!=null) {
				response.append(line);
			}
			reader.close();
			JSONArray jsonArray=new JSONArray(response.toString());
			
			for (int i = 0; i < jsonArray.length(); i++) {
			     JSONObject explrObject = jsonArray.getJSONObject(i);
			    res.add(explrObject);
			}
			
			
			return res;
		}
		catch(Exception e) {
			e.printStackTrace();;
		}
		return res;
	}
	
	public static void uploadEmp(String name,String id,String email,String dob,String location) throws IOException {
		URL url = new URL("http://localhost:9090/add");
		connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json; utf-8");
		connection.setDoOutput(true);
		
		String jsonInputString = String.format("{\"empId\":%s,\"name\":\"%s\",\"location\":\"%s\",\"email\":\"%s\",\"dob\":\"%s\"}",id,name,location,email,dob);
		try (OutputStream os = connection.getOutputStream()) {
			byte[] input = jsonInputString.getBytes("utf-8");
			os.write(input, 0, input.length);
		}
		try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}

		}
	}
}


