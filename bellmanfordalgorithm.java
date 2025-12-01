//Bellman Short

package bellmanford;

import java.util.Scanner;

public class Bellmanford {
    int vert ,max=999;
    int [] dist;
    
    public Bellmanford(int vert){
        this.vert = vert;
        dist = new int[vert + 1];                
    }
    
    
    public void disteval(int src, int [][] adjmat){

        for(int node= 1; node <= vert; node++ ){
            dist[node]= max;
        }
        dist[src]=0;
      
        for(int i=1; i<= vert; i++){
            for(int x=1; x<= vert; x++){
                for(int y=2; y<= vert; y++){
                    if(adjmat[x][y] != max && dist[x] != max && dist[y] > dist[x] + adjmat[x][y]){
                        dist[y] = dist[x] + adjmat[x][y];
                    }
                }
            }
        }
        

        //Hint to remember next for loop is copy same above three loops but delete the i loop
        
        for(int x=1; x<= vert; x++){
            for(int y=1; y<= vert; y++){
                if(adjmat[x][y] != max && dist[x] != max && dist[y] > dist[x] + adjmat[x][y]){
                    System.out.println("The graph has -ve edge cycle --- ");
                    return;
                }
            }
        }
        

        for(int v=1; v<=vert; v++){
            System.out.println(" Distance of source " +src+ 
                    " to vertex " +v+ " is " +dist[v]);
        }
    }
    
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter no. of vertices: ");
        int vert = sc.nextInt();
        
        System.out.println("Enter vertices: ");
        int [][] adjmat = new int [50][50];
        
        for(int i=1;i<=vert; i++){
            for(int j=1;j<= vert; j++){
                adjmat[i][j]=sc.nextInt();
            }
        }
        
        System.out.println(" enter the source vertex: ");
        int src = sc.nextInt();
        
        Bellmanford ob = new Bellmanford(vert);
        ob.disteval(src, adjmat);
        
        
    }
    
}
