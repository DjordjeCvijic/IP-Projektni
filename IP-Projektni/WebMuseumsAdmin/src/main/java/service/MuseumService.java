package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import beans.MuseumBean;
import dao.MuseumDao;
import dao.MuseumTypeDao;
import dto.MuseumDto;
import dto.MuseumTypeDto;

public class MuseumService {
	
	
	public static List<MuseumBean> getAllMuseums(){
		List<MuseumBean>resultList=new LinkedList<>();
		List<MuseumDto>museumDtoList=new LinkedList<>();
		museumDtoList=MuseumDao.getMuseums();
		museumDtoList.forEach(e->{
			MuseumTypeDto museumType=MuseumTypeDao.getMuseumTypeById(e.getMuseumTypeId());
			MuseumBean bean=new MuseumBean();
			bean.setAddress(e.getAddress());
			bean.setCityName(e.getCityName());
			bean.setCountryName(e.getCountryName());
			bean.setLatitude(e.getLatitude());
			bean.setLongitude(e.getLongitude());
			bean.setMuseumId(e.getMuseumId());
			bean.setMuseumTypeName(museumType.getName());
			bean.setName(e.getName());
			bean.setPhoneNumber(e.getPhoneNumber());
			resultList.add(bean);
		});
		
		
		return resultList;
	}

	
	public static void addMuseum(MuseumBean museumBean) {
		MuseumDto museumDto=new MuseumDto();
		museumDto.setAddress(museumBean.getAddress());
		museumDto.setCityName(museumBean.getCityName());
		museumDto.setCountryName(getCountryNameByCode(museumBean.getCountryName()));//problem
		museumDto.setLatitude(museumBean.getLatitude());
		museumDto.setLongitude(museumBean.getLongitude());
		museumDto.setMuseumTypeId(Integer.valueOf(museumBean.getMuseumTypeName()));
		museumDto.setName(museumBean.getName());
		museumDto.setPhoneNumber(museumBean.getPhoneNumber());
		MuseumDao.addMuseum(museumDto);
	}


	private static String getCountryNameByCode(String countryCode) {
		URL url;
		StringBuffer content = new StringBuffer();
		try { 
			url = new URL("http://battuta.medunes.net/api/country/code/"+countryCode+"/?key=653c9ff668e214b2cc4187e30e531ceb");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			
			
			BufferedReader in = new BufferedReader(
					  new InputStreamReader(con.getInputStream()));
			String inputLine;
			
			while ((inputLine = in.readLine()) != null) {
			    content.append(inputLine);
			}
			in.close();
					
					
			con.disconnect();		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray jsonArray=new JSONArray(content.toString());
		JSONObject jsonObject=jsonArray.getJSONObject(0);
		String result=jsonObject.getString("name");//jsonObject.getString("code");
		System.out.println(result);
		return result;
	}
	
}
