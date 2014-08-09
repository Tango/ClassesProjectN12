package FractionPack;

import java.math.BigDecimal;
import java.math.MathContext;


class Fr{
	//int intNum; 		// ����� ����� ��� ��������� ������
	int num;    		// ���������
	int denom;			// �����������
	double fraction;	// ���������� - ���������� �����
	 
	
	Fr(){
		num = 0;
		denom = 1;
	}
	
	Fr(Double x){		
		BigDecimal bigDec = new BigDecimal("1");
		bigDec = BigDecimal.valueOf(x).multiply((bigDec));//��������� Double x � BigDecimal ��� ����������� �����������-� � ������
		bigDec = bigDec.stripTrailingZeros();
	    String dec = bigDec.toPlainString();
		
		Str2frac(dec); // �������� x � ���� ������  � �����   
		reducFr(num,denom); //�������� ����������
		fraction = (double)num/(double)denom;

	}
	
	Fr(int x, int y){
		num = x;
		denom = y;
		reducFr(num,denom);
		fraction = (double)num/(double)denom;
	}
	
	Fr(int z, int x, int y){ // ����������� ��� ��������� �����
		num = z*y+x;         // ���������� ��������� ����� � ������������
		denom = y;
		reducFr(num,denom);  // ���������
		fraction = (double)num/(double)denom;
	}
	
	private void Str2frac (String dec){//������������ �����.����� �� ������ � �������, - � ����������, ������������ � ����� ������ 
		denom=1;
		int m = Integer.parseInt(dec.substring(0, dec.indexOf(".")));
		int k = dec.substring(dec.indexOf(".")+1).length(); 
		for (int i=0; i<k;i++)	denom*=10;
		num = Integer.parseInt(dec.substring(dec.indexOf(".")+1))+m*denom;
	}
	
	private void reducFr(int x, int y){  // ����������
	  if (y==0) {
		  System.out.println("ERROR! Denominator can't be equaled 0!");
		  y=1;
		  return;
	    }
		  else if (x<y){
			 for (int i=x; i>1; i--){
				    if ((x%i)==0 &&(y%i==0)){  // ���� ���
				    	num=x/i;
				    	denom=y/i;
				    	break;
				    } else {
						num=x;
						denom=y;
				      }
			}
		  } else if (x>y){
					for (int i=y; i>1; i--){
						if ((y%i)==(x%i)&&(y%i==0)){
							num=x/i;
							denom=y/i;
							break;
						} else {
							num=x;
							denom=y;
					      } 
					}
	  	   		} else if (x==y){
	  		   				 num=1;
							 denom=1;
	  	           }
	}
	
	void showFr(){	
		System.out.println(num+" / "+denom);
		System.out.println(fraction);
	}
}

public class ProgramFraction {

	public static void main(String[] args) {
		Fr a = new Fr(1.0004333);
		Fr b = new Fr(10004333, 10000000);
		a.showFr();
		b.showFr();

	}
}