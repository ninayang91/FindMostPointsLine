
//determine whether two lines on a Cartesian plane would intersect
//use data structure class Line
//y=kx+b, use Line(k,b) as constructor
//use Math.abs(k-l.k)>epsilon instead of ==
//if they are same lines, Math.abs(b-l.b)<epsilon



public class Line {
	
	public static double epsilon=0.0001;
	double k;
	double b;//y=kx+b
/*	Point p1;
	Point p2;*/
	boolean infinite_slope=false;
	public Line(double k, double b){
		this.k=k;
		this.b=b;
	}
	
	public Line(Point p1, Point p2){
/*		this.p1=p1;
		this.p2=p2;*/
		if(isEqual(p1.x,p2.x)) {
			infinite_slope=true;
			b=p1.x;
		}else{
			k=(p1.y-p2.y)/(p1.x-p2.x);
			b=p1.y-k*p1.x;
		}
	}
	
	public boolean isEqual(double a, double b){
		return (Math.abs(a-b))<epsilon;
	}
	
	public boolean isEqual(Object o){
		Line l=(Line)o;
		return (isEqual(this.k,l.k))&&(isEqual(this.b,l.b))&&(this.infinite_slope==l.infinite_slope);
	}
	
	public static double floored(double a){//3.14926->3.1492
		
		int r=(int)(1/epsilon);
		int b=(int)(a*r);
		return (double)b*epsilon;

	}

	
	public boolean intersect(Line l){
		return Math.abs(k-l.k)>epsilon ||  Math.abs(b-l.b)<epsilon;
	}
	
	

}
