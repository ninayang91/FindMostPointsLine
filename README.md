# FindMostPointsLine
 Given a two-dimensional graph with points on it, find a line which passes the most number of points.
 
  for(i=0-length){

    for(j=i+1-length){

         line l=(i,j);

         countEquivLines(hashMap,l);

    }

 }

put lines with same slope in arraylist, -> count equal lines in list

put arrayList in HashMap -> count equal lines (equal lines in list (k,k+epsilon,k-epsilon)) in map

we use epsilon to floor the slope, 

if abs()<epsilon, they are considered equal
