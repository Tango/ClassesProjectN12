package Coordinates;

class Point{  // ������� ����� ////////////////////////////////////////////////////
	double X;
	double Y;
		
	void setXY(double x, double y) { // ������ [
		X = x;
		Y = y;
	}//======================================= ]
	
	void MoveUp(double x) { // ������� ����� [
		Y += x;
	}//===================================== ]
	
	void MoveDown(double x) { // ������� ���� [
		Y -= x;
	}//=======================================]
	
	void MoveLeft(double x) { // ������� ����� [
		X -= x;
	}//======================================= ]
	
	void MoveRight(double x) { // ������� ������ [
		X += x; 
	}//========================================= ]
	
	public double getX() {
		return X;
	}
	public double getY() {
		return Y;
	}
	Point(double x, double y) { // ������� ����������� � ����������� [
		X = x;
		Y = y;
	}//============================================================= ]
	Point() { // ������� ����������� ��� ����������
		X = 0;
		Y = 0;
	}//============================================                 
	Point(double x) { // ������� �����������, ���  x = y
		X = x;
		Y = x;
	}//=================================================
	void ShowCoord(){
		System.out.println("( "+X+" ; "+Y+" )\n");		
	}
		
}// 

public class ProgramPoint {


	
	public static void main(String[] args) {
		Point A = new Point(); 
		Point B = new Point();
		Point C = new Point(100);
		A.ShowCoord();
		A.setXY(15, 20);
		A.ShowCoord();
		A.MoveLeft(100);
		A.ShowCoord();
		System.out.println(A.getX()+" "+A.getY() );
		
	}
}

