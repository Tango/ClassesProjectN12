// проверить конструктор с аргументом double без точки
// проверить конструктор с аргументом double с точкой 9.0
// отрицательный аргумент
//

package FractionPack;
import java.math.BigDecimal;
//import java.math.MathContext;

class Fr{
	private int num;    		// Numerator
	private int denom;			// Deumerator
	private double fraction;	// Decimal fraction
	//private int clm;          // Lowest Common Multiple 
	
	Fr(){
		num = 0;
		denom = 1;
	}
	
	Fr(Double x){		
		double2frac(x);
	}
	
	Fr(int x, int y){		 			// constructor for 2 arguments
		num = x;
		denom = y;
		reducFr(num,denom);  			// fraction's reduction
		fraction = (double)num/(double)denom;
	}
	
	Fr(int z, int x, int y){ 			// constructor with 3 argument
		num = z*y+x;         			// convert mixed fraction to improper fraction
		denom = y;
		reducFr(num,denom);  			// fraction's reduction
		fraction = (double)num/(double)denom;
	}
	
	private void Str2frac (String dec){                                //convert String decimal fraction to simple fraction 
		denom=1;
		int m = Integer.parseInt(dec.substring(0, dec.indexOf(".")));  //searching of integer part 
		int k = dec.substring(dec.indexOf(".")+1).length();            //searching of length of decimal part. We need it for 
		for (int i=0; i<k;i++)	denom*=10;                             // calculating of denominator
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
			fraction = (double)num/(double)denom;			   
		}
	}
	
	private void reducFr(int x, int y){  // fraction's reduction
		if (y==0) {
		   System.out.println("ERROR! Denominator can't be equaled 0!");
		   
		   return;
	      } else if (x==0) {
			 this.num = 0;
			 this.denom = 1;
			 fraction = 0;
		} else if (x<y){
			 for (int i=x; i>1; i--){
				    if ((x%i)==0 &&(y%i==0)){  // searching of Lowest Common Multiple
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
		System.out.print(""+num+" / "+denom);
		System.out.print(" ( "+fraction+" ) \n\n");
	}
	
	public void setfr (int x, int y){ // setter with 2 arguments
		num = x;
		denom = y;
		reducFr(num,denom);    // fraction's reduction
		fraction = (double)num/(double)denom;
	}
	
	public void setfr (double x){  // setter with 1 arguments? type of double
		double2frac(x);
		reducFr(num,denom);    // fraction's reduction
		fraction = (double)num/(double)denom;	
	}
	
	public Fr Multiply (Fr a, Fr b){
		Fr c = new Fr();
		c.num = a.num * b.num;
		c.denom = a.denom * b.denom;
		c.reducFr(c.num,c.denom);    // fraction's reduction
		c.fraction = a.fraction * b.fraction;
		return c;
	}
	
	public Fr Divide (Fr x, Fr y){
		Fr c = new Fr();
		c.num = x.num * y.denom;
		c.denom = x.denom * y.num;
		c.reducFr(c.num,c.denom);    // fraction's reduction
		c.fraction = x.fraction / y.fraction;
		return c;
	}
	
	public double CalcSimpleFr (int x, int y){
		double d=x/y;
		return d;
	}
	
	public Fr Addition (Fr x, Fr y){  //Method of ADDITION
		Fr c = new Fr();
		first: {   // searching of Lowest Common Multiple
			for(int i=1;i<x.denom+1;i++){
				for(int j=1;j<y.denom+1;j++){
					if ((j*x.denom)>(i*y.denom)) break;
					if ((j*x.denom)==(i*y.denom)){
					y.denom=i*y.denom; 
					y.num=i*y.num; 
					x.denom=j*x.denom; 
					x.num=j*x.num;
					break first; 
					}
				}
			}
		}
		c.num = x.num + y.num;
		c.denom = y.denom;
		c.fraction = (double)c.num/(double)c.denom;
		return c;
	}  // ================= end of Addition method

	public Fr Subtraction (Fr x, Fr y){  // Method of Subtraction
		Fr c = new Fr();
		first: {
			for(int i=1;i<x.denom+1;i++){
				for(int j=1;j<y.denom+1;j++){
					if ((j*x.denom)>(i*y.denom)) break;
					if ((j*x.denom)==(i*y.denom)){
					y.denom=i*y.denom; 
					y.num=i*y.num; 
					x.denom=j*x.denom; 
					x.num=j*x.num;
					break first; 
					}
				}
			}
		}
		c.num = x.num - y.num;
		c.denom = y.denom;
		c.fraction = (double)c.num/(double)c.denom;
		return c;
	}  // ================= End of Subtraction method	
	
	public Fr Highest (Fr x, Fr y){  // Comparing method. Returns the highest fraction
		Fr c = new Fr();
		first: {
			for(int i=1;i<x.denom+1;i++){
				for(int j=1;j<y.denom+1;j++){
					if ((j*x.denom)>(i*y.denom)) break;
					if ((j*x.denom)==(i*y.denom)){
					y.denom=i*y.denom; 
					y.num=i*y.num; 
					x.denom=j*x.denom; 
					x.num=j*x.num;
					break first; 
					}
				}
			}
		}	 
		c.num = (x.num > y.num)? x.num : y.num;
		c.denom = y.denom;
		c.fraction = (double)c.num/(double)c.denom;
		c.reducFr(c.num,c.denom);      // fraction's reduction
		return c;
	}  // ================= End of Highest method	
	
	public Fr Lowest (Fr x, Fr y){  // Comparing method. Returns the LOWest fraction
		Fr c = new Fr();
		first: {
			for(int i=1;i<x.denom+1;i++){
				for(int j=1;j<y.denom+1;j++){
					if ((j*x.denom)>(i*y.denom)) break;
					if ((j*x.denom)==(i*y.denom)){
					y.denom=i*y.denom; 
					y.num=i*y.num; 
					x.denom=j*x.denom; 
					x.num=j*x.num;
					break first; 
					}
				}
			}
		}	 
		c.num = (x.num < y.num)? x.num : y.num;
		c.denom = y.denom;
		c.fraction = (double)c.num/(double)c.denom;
		c.reducFr(c.num,c.denom);      // fraction's reduction
		return c;
	}  // ================= End of Lowest method	
	
}   // ============= End of class Fr ============

public class ProgramFraction {

	public static void main(String[] args) {
		System.out.println("Given:  ");
		Fr a = new Fr(2,1);
		System.out.print("Fraction A =  ");
		a.showFr();

		Fr b = new Fr(0.005);
		System.out.print("Fraction B =  ");
		b.showFr();
		
		Fr c = new Fr();
		
		c = c.Highest(a,b); 
		System.out.print(" > result of the Highest comparing is ");  		
		c.showFr();

		c = c.Lowest(a,b); 
		System.out.print(" > result of the Lowest comparing is ");  		
		c.showFr();
		
		c = c.Multiply(a,b);
		System.out.print(" * result of multiplication is ");
		c.showFr();     
		
		c = c.Divide(a,b);
		System.out.print(" / result of division is ");
		c.showFr();

		c = c.Addition(a,b);
		System.out.print(" + result of addition is ");
		c.showFr(); 
		
		c = c.Subtraction(a,b); 
		System.out.print(" - result of subtraction is ");  		
		c.showFr();
		

	} 
}