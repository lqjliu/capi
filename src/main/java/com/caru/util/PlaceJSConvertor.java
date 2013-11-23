package com.caru.util;

import java.io.FileWriter;
import java.util.List;

import com.caru.db.DBAgentOO;
import com.caru.vo.CycityVO;
import com.caru.vo.CycountyVO;
import com.caru.vo.CymodelVO;
import com.caru.vo.CyprovinceVO;

public class PlaceJSConvertor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			FileWriter fw = new FileWriter("placeType.js");
			fw.write("var Caru_place_type = { id:\"caru\",type:[ \r\n");
			
			dbAgentOO.beginTransaction();
			String sql = "select * from cyprovince order by id";
			List<Object> provinces = dbAgentOO.selectData(sql,
					"com.caru.vo.CyprovinceVO");
			for (int i = 0; i < provinces.size(); i++) {
				CyprovinceVO province = (CyprovinceVO) provinces.get(i);
				if(i == 0){
					fw.write("  {  \r\n");
				}else{
					fw.write("  ,  \r\n");
					fw.write("  {  \r\n");
				}
				fw.write("     id:" + province.getId()+ ",\r\n");
				fw.write("     name:\" "+province.getProvince()+" \",\r\n");
				fw.write("     type:[\r\n");
				
				String sql1 = "select * from cycity where provinceid = '"
						+ province.getProvinceid() + "' order by id";
				List<Object> citys = dbAgentOO.selectData(sql1,
						"com.caru.vo.CycityVO");
				for (int j = 0; j < citys.size(); j++) {
					CycityVO city = (CycityVO) citys.get(j);
					if(j == 0){
						fw.write("     {  \r\n");
					}else{
						fw.write("     ,  \r\n");
						fw.write("     {  \r\n");
					}
					fw.write("       id:" + city.getId()+ ",\r\n");
					fw.write("       name:\" "+city.getCity()+" \",\r\n");
					fw.write("       type:[\r\n");
					
					String sql2 = "select * from cycounty where " + "cityid = '"
							+ city.getCityid() + "' order by id";
					List<Object> countys = dbAgentOO.selectData(sql2,
							"com.caru.vo.CycountyVO");
					for (int k = 0; k < countys.size(); k++) {
						CycountyVO county = (CycountyVO) countys.get(k);
						if(k == 0){
							fw.write("       {  \r\n");
						}else{
							fw.write("       ,  \r\n");
							fw.write("       {  \r\n");
						}
						fw.write("         id:" + county.getId()+ ",\r\n");
						fw.write("         name:\" "+county.getCounty()+" \"\r\n");
						fw.write("       }  \r\n");
					}
					
					fw.write("       ]\r\n");
					fw.write("     }  \r\n");
				}
				fw.write("     ]\r\n");
				fw.write("  }  \r\n");
			}
			dbAgentOO.commitTransaction();
			
			fw.write("]};");
			fw.close();
		} catch (Exception ex) {
			try {
				dbAgentOO.rollbackTransaction();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
			ex.printStackTrace();
		}
	}
}
