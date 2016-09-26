import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
	}
	public static void insertLine(HashMap<Double, ArrayList<Line>> linesInMap,Line l){
		double key=l.floored(l.k);
		if(linesInMap.containsKey(key)){
			linesInMap.get(key).add(l);
		}else{
			ArrayList<Line> linesInList=new ArrayList<Line>();
			linesInList.add(l);
			linesInMap.put(key, linesInList);
		}
	}
	
	public static int countEqualLines(ArrayList<Line> linesInList,Line l){
		if(linesInList==null)return 0;
		int count=0;
		for(Line x:linesInList){
			if(x.isEqual(l)){
				count++;
			}
		}
		return count;
	}
	
	public static int countEqualLines(HashMap<Double, ArrayList<Line>> linesInMap,Line l){
		
		double key=l.floored(l.k);
		double eps=l.epsilon;
		int count= countEqualLines(linesInMap.get(key),l)+
				countEqualLines(linesInMap.get(key-eps),l)+
				countEqualLines(linesInMap.get(key+eps),l);
		return count;
	}
	
	public static Line findBestLine(Point[] points){
		HashMap<Double, ArrayList<Line>> linesInMap=new HashMap<Double, ArrayList<Line>>();
		int count=0;
		Line bestLine=null;
		
		for(int i=0;i<points.length;i++){
			for(int j=i+1;j<points.length;j++){
				Line l=new Line(points[i],points[j]);
				insertLine(linesInMap, l);
				int countX=countEqualLines(linesInMap,l);
				if(count<countX){
					count=countX;
					bestLine=l;
				}
			}
			
		}
		return bestLine;
	}

}
