import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;

import com.caru.biz.fee.Fee;
import com.caru.web.BasicResponse;
import com.caru.web.Response;
import java.io.*;

public class JsonTest {
	public static void main(String[] args) {
		try {
			
		OutputStream out = new FileOutputStream("test.txt"); 
		DataOutputStream out1 = new DataOutputStream(out); 
		
			
				
			// String json =
			// "{" +
			// "\"Rqst\" : {" +
			// "\"Job\" : \"UserLogin\", " +
			// "\"Data\" : {" +
			// "\"UserName\" : \"robin\","+
			// "\"feeId\" : [1,2,3]"+
			// "}" +
			// "}" +
			// "}";
			//			
			// JSONObject obj1 = new JSONObject(json);
			// JSONObject rqstJO = obj1.getJSONObject("Rqst");
			// JSONObject dataJO = rqstJO.getJSONObject("Data");
			// System.out.println(dataJO);

			List result = new ArrayList();
			Fee fee1 = new Fee();
			fee1.setFeeId(1);
			fee1.setAmount(100);
			// result.add(new Byte((byte)1));
			result.add(fee1);
			// result.add(new Date());
			Fee fee2 = new Fee();
			fee2.setFeeId(2);
			fee2.setAmount(200);

			// result.add(new Byte((byte)2));
			result.add(fee2);
			// result.add(new Date());
			Fee fee3 = new Fee();
			fee3.setFeeId(3);
			fee3.setAmount(300);

			// result.add(new Byte((byte)3));
			result.add(fee3);
			// result.add(new Date());
			BasicResponse basicResponse = new BasicResponse();
			basicResponse.setData(result);
			basicResponse.setCredential("asdklfjasdlkfjasd");
			Response response = new Response();
			response.setRsps(basicResponse);
			JSONObject obj = new JSONObject(result, true);
			System.out.println("obj = " + obj);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
