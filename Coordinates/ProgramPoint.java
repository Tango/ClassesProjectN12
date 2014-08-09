package Coordinates;

class Point{  // создаем класс ////////////////////////////////////////////////////
	double X;
	double Y;
		
	void setXY(double x, double y) { // сеттер [
		X = x;
		Y = y;
	}//======================================= ]
	
	void MoveUp(double x) { // двигаем вверх [
		Y += x;
	}//===================================== ]
	
	void MoveDown(double x) { // двигаем вниз [
		Y -= x;
	}//=======================================]
	
	void MoveLeft(double x) { // двигаем влево [
		X -= x;
	}//======================================= ]
	
	void MoveRight(double x) { // двигаем вправо [
		X += x; 
	}//========================================= ]
	
	public double getX() {
		return X;
	}
	public double getY() {
		return Y;
	}
	Point(double x, double y) { // создаем конструктор с параметрами [
		X = x;
		Y = y;
	}//============================================================= ]
	Point() { // создаем конструктор без параметров
		X = 0;
		Y = 0;
	}//============================================                 
	Point(double x) { // создаем конструктор, где  x = y
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

