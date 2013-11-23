
public class MonkeyPear {
	public static void main(String[] args){
		int lastEach = 1;
		boolean meetFlag = false;
		int lastSum = 0;
		while(!meetFlag){
			lastEach ++;
			System.out.println("lastEach = " + lastEach);
			lastSum = lastEach * 5 + 1;
			System.out.println("lastSum5 = " +  lastSum);
			for(int mNo= 4; mNo > 0; mNo--){
				boolean meetC = (mNo == 1 && (lastSum -1) % 5 == 0) || (lastSum -1) % 5 == 0 && lastSum % 4 == 0;
				if(meetC){
					if(lastSum * 5 % 4 == 0){
						meetFlag = true;
						lastSum = lastSum * 5 / 4 + 1;
						System.out.println("lastSum" + mNo + " = " + lastSum);
					}else{
						meetFlag = false;
						break;
					}
				}else{
					meetFlag = false;
					break;
				}
			}
		}
		
		System.out.print("lastSum = " + lastSum);
		
	}
}
