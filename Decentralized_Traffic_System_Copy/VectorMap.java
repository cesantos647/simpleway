import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class VectorMap {
  
  char[][] map = {
    {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}, 
    {'X', 'd', 'X', ' ', ' ', ' ', ' ', 'X', 'G', 'X'}, 
    {'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X'}, 
    {'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X'}, 
    {'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X'}, 
    {'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X'}, 
    {'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', ' ', 'X'}, 
    {'X', 'r', ' ', ' ', ' ', ' ', ' ', ' ', 'u', 'X'}, 
    {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}, 
    {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}, 
  };
  
  char[][] nmap = map;
  
  List<double[]> vecMap = new ArrayList<double[]>();
  
  public boolean solve(int row, int col) {
    
    char right = map[row][col + 1];
    char left = map[row][col - 1];
    char up = map[row - 1][col];
    char down = map[row + 1][col];
    
    if (right == 'G' || left == 'G' || up == 'G' || down == 'G') {
      return true;
    }
    
    System.out.println("position=>"+"("+row + ":" + col+")");
    
    if (right == ' ') {
      map[row][col] = 'r';
      return solve(row,col+1);
    }
    if (down == ' ') {
      map[row][col] = 'd';
      return solve(row+1,col);
    }
    if (left == ' ') {
      map[row][col] = 'l';
      return solve(row,col-1);
    }
    if (up == ' ') {
      map[row][col] = 'u';
      return solve(row-1,col);
    }
    return false;
  }
  
  public void mapPrint() {
    for(int i = 0; i < map.length; i++){  
      for(int j = 0; j < map.length - 1; j++) {
          System.out.print(map[i][j]);
        }
        System.out.println(map[i][map.length - 1]);
      }
    }
  }
