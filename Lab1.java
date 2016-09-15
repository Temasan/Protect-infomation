import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

class NOD{
	NOD(){}
	public int Exec(int a, int b){
		while (b !=0) {
	            int tmp = a%b;
	            a = b;
	            b = tmp;
	        }
	    return a;
	}
}

class AffinCoder{// àôôèííîå øèôğîâàíèå
	NOD res = new NOD();
	String Message;
	String Alphabit; 
	int a, UNa, b;
	AffinCoder(String Alph){
		Alphabit = Alph;
		Message = "òåñò";
		Random rn = new Random();
		int Ran = rn.nextInt(4) + 1, index = 0;
		//System.out.println(Ran);
		//System.out.println("Alph = " + Alphabit.length());
		for(int i = 2; i < Alphabit.length(); i++){
			if(res.Exec(Alphabit.length(), i) == 1){
				index++;
				if(index == Ran){
					a = i;
				//	System.out.println("A = : " + a);
					break;
				}
			}
		}	
		for(int i = 1; i <Alphabit.length(); i++){
			if((Alphabit.length() * i + 1)%a == 0){
				UNa = (((Alphabit.length() * i)/a) + 1);
			//	System.out.println("UNA = : " + UNa);	
				break;
			}
		}
		b =  rn.nextInt(10) + 1;
		//System.out.println("B = : " + b);
	}
	public String Code(String Message){
		String Codes = "";	
		for(int i = 0; i < Message.length(); i++){
			int Number = Alphabit.indexOf(Message.toCharArray()[i]);
			if(Number <= 0)
				Number = Alphabit.length() + Number;
			else if(Number >= Alphabit.length())
				Number = Number - Alphabit.length() ;	
				Codes += Alphabit.substring((a * Number + b)%Alphabit.length(),(a * Number + b)%Alphabit.length() + 1); 
		}
		this.Message = Codes;
		return Codes;
	}
	public String Decode(String Message){
		String Decodes = "";
		for(int i = 0; i < Message.length(); i++){
			int Number = Alphabit.indexOf(Message.toCharArray()[i]);
			if(Number - b <= 0)
				Number = Alphabit.length() + Number;
			else if(Number - b >= Alphabit.length())
				Number = Number - Alphabit.length() ;	
			Decodes += Alphabit.substring(UNa*(Number - b)%Alphabit.length(), UNa*(Number - b)%Alphabit.length() + 1); 
		}
		this.Message = Decodes;
		return Decodes;
	}
	public String GetMessage(){
		return Message;
	} 
	
}

public class Lab1 {
	public static void main(String [] argv){
		String Alph =  "0123456789AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZzÀàÁáÂâÃãÄäÅå¨¸ÆæÇçÈèÊêËëÌìÍíÎîÏïĞğÑñÒòÓóÔôÕõÖö×÷ØøÙùÚúÛûÜüİıŞşßÿ., !?*()+/-=";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String Message = "=3210àëàëàëÿ0=-/+";
		AffinCoder B = new AffinCoder(Alph);
		try{
			System.out.println("Input message: ");
			Message = br.readLine();
		}catch (IOException ex){}
		
		System.out.println(B.Code(Message));
		System.out.println(B.Decode(B.GetMessage()));	
	}
}
