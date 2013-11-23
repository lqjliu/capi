package com.common.util;

import java.io.FileWriter;
import java.util.List;

import com.caru.db.DBAgentOO;
import com.caru.vo.CybrandVO;
import com.caru.vo.CymodelVO;
import com.caru.vo.CyvendorVO;

public class CarTypeJSConvertor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			FileWriter fw = new FileWriter("carType.js");
			fw.write("var Caru_car_type = { id:\"caru\",type:[ \r\n");
			
			dbAgentOO.beginTransaction();
			String sql = "select * from cyvendor order by id";
			List<Object> vendors = dbAgentOO.selectData(sql,
					"com.caru.vo.CyvendorVO");
			for (int i = 0; i < vendors.size(); i++) {
				CyvendorVO vendor = (CyvendorVO) vendors.get(i);
				if(i == 0){
					fw.write("  {  \r\n");
				}else{
					fw.write("  ,  \r\n");
					fw.write("  {  \r\n");
				}
				fw.write("     id:" + vendor.getId()+ ",\r\n");
				fw.write("     name:\" "+vendor.getVendor()+" \",\r\n");
				fw.write("     type:[\r\n");
				
				String sql1 = "select * from cybrand where vendorid = "
						+ vendor.getId() + " order by id";
				List<Object> brands = dbAgentOO.selectData(sql1,
						"com.caru.vo.CybrandVO");
				for (int j = 0; j < brands.size(); j++) {
					CybrandVO brand = (CybrandVO) brands.get(j);
					if(j == 0){
						fw.write("     {  \r\n");
					}else{
						fw.write("     ,  \r\n");
						fw.write("     {  \r\n");
					}
					fw.write("       id:" + brand.getId()+ ",\r\n");
					fw.write("       name:\" "+brand.getBrand()+" \",\r\n");
					fw.write("       type:[\r\n");
					
					String sql2 = "select * from cymodel where vendorid = "
							+ vendor.getId() + " and brandid = "
							+ brand.getId() + " order by id";
					List<Object> models = dbAgentOO.selectData(sql2,
							"com.caru.vo.CymodelVO");
					for (int k = 0; k < models.size(); k++) {
						CymodelVO model = (CymodelVO) models.get(k);
						if(k == 0){
							fw.write("       {  \r\n");
						}else{
							fw.write("       ,  \r\n");
							fw.write("       {  \r\n");
						}
						fw.write("         id:" + model.getId()+ ",\r\n");
						fw.write("         name:\" "+model.getModel()+" \"\r\n");
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
