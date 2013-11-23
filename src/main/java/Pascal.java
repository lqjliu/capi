

	import java.awt.*;    
	import javax.swing.*;    
	  
	public class Pascal extends JFrame {    
	    public Pascal() {    
	        setBackground(Color.white);    
	        setTitle("°ÍË¹¿¨Èý½ÇÐÎ");    
	        setSize(520, 350);    
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
	        show();    
	    }    
	  
	    private long combi(int n, int r){    
	        int i;    
	        long p = 1;    
	  
	        for(i = 1; i <= r; i++)    
	            p = p * (n-i+1) / i;    
	     
	        return p;    
	    }    
	  
	    public void paint(Graphics g) {    
	        final int N = 12;    
	        int n, r, t;    
	  
	        for(n = 0; n <= N; n++) {    
	            for(r = 0; r <= n; r++)    
	                g.drawString(" " + combi(n, r),    
	                    (N-n)*20 + r * 40, n * 20 + 50);    
	        }    
	    }    
	  
	    public static void main(String args[]) {    
	        Pascal frm = new Pascal();    
	    }    
	}  


