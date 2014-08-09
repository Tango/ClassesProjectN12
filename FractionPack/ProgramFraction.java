// проверить конструктор с аргументом double без точки
// проверить конструктор с аргументом double с точкой 9.0
// отрицательный аргумент
//

package FractionPack;
import java.math.BigDecimal;
import java.math.MathContext;

class Fr{
	//int intNum; 		// целая часть для смешанных дробей
	private int num;    		// числитель
	private int denom;			// знаменатель
	private double fraction;	// вычисление - десятичная дробь
	
	Fr(){
		num = 0;
		denom = 1;
	}
	
	Fr(Double x){		
		System.out.println(" сработал конструктор с 1парам ");
		double2frac(x);
	}
	
	Fr(int x, int y){
		System.out.println(" сработал конструктор с 2парам ");
		num = x;
		denom = y;
		reducFr(num,denom);
		fraction = (double)num/(double)denom;
	}
	
	Fr(int z, int x, int y){ // конструктор для смешанной дроби
		System.out.println(" сработал конструктор с парам ");
		num = z*y+x;         // превращаем смешанную дробь в неправильную
		denom = y;
		reducFr(num,denom);  // сокращаем
		fraction = (double)num/(double)denom;
	}
	
	private void Str2frac (String dec){//раскладывает десят.дробь из строки в простую, - с числителем, знаменателем и целой частью 
		denom=1;
		int m = Integer.parseInt(dec.substring(0, dec.indexOf(".")));
		int k = dec.substring(dec.indexOf(".")+1).length(); 
		for (int i=0; i<k;i++)	denom*=10;
		num = Integer.parseInt(dec.substring(dec.indexOf(".")+1))+m*denom;
	}
	
	private void double2frac (Double x){
		if (x==0){
			num = 0;
			denom = 1;
			fraction = 0;
		}else{
			BigDecimal bigDec = new BigDecimal("1");
			bigDec = BigDecimal.valueOf(x).multiply((bigDec)); //convert Double x to BigDecimal 
			bigDec = bigDec.stripTrailingZeros();
			String dec = bigDec.toPlainString();			   //convert BigDecimal to String 
			Str2frac(dec);                                     //pass String value for dividing to integer and decimal part   
			reducFr(num,denom);                                //fraction's reduction
			fraction = (double)num/(double)denom;			   //
		}
	}
	
	private void reducFr(int x, int y){  // fraction's reduction
		if (y==0) {
		   System.out.println("ERROR! Denominator can't be equaled 0!");
		   y=1;
		   return;
	      } else if (x==0) {
			 this.num = 0;
			 this.denom = 1;
			 fraction = 0;
		} else if (x<y){
			 for (int i=x; i>1; i--){
				    if ((x%i)==0 &&(y%i==0)){  // ищем НОД
				    	this.num=x/i;
				    	this.denom=y/i;
				    	break;
				    } else {
						this.num=x;
						this.denom=y;
				      }
			}
		  } else if (x>y){
					for (int i=y; i>1; i--){
						if ((y%i)==(x%i)&&(y%i==0)){
							this.num=x/i;
							this.denom=y/i;
							break;
						} else {
							this.num=x;
							this.denom=y;
					      } 
					}
	  	   		} else if (x==y){
	  		   				 this.num=1;
							 this.denom=1;
	  	           }
	}
	
	void showFr(){	
		System.out.println(num+" / "+denom);
		System.out.println(fraction);
	}
	
	public void setfr (int x, int y){
		num = x;
		denom = y;
		reducFr(num,denom);
		fraction = (double)num/(double)denom;
	}
	
	public void setfr (double x){
		double2frac(x);
		reducFr(num,denom);
		fraction = (double)num/(double)denom;	
	}
	
	public Fr multiply (Fr a, Fr b){
		Fr c = new Fr();
		c.num = a.num * b.num;
		c.denom = a.denom * b.denom;
		return c;
	}
	
}

public class ProgramFraction {

	public static void main(String[] args) {
		Fr a = new Fr(0.5);
		a.showFr();
		
		a.setfr(10.3);
		a.showFr();
		
		a.setfr(105,13);
		a.showFr();	

	}
}