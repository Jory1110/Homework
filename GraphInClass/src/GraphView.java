import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class GraphView extends Pane {
  private Graph<? extends Displayable> graph;
  
  public GraphView(Graph<? extends Displayable> graph) {
    this.graph = graph;
    
    // Draw vertices
    java.util.List<? extends Displayable> vertices 
      = graph.getVertices();    
    for (int i = 0; i < graph.getSize(); i++) {
      int x = vertices.get(i).getX();
      int y = vertices.get(i).getY();
      String name = vertices.get(i).getName();
      
      getChildren().add(new Circle(x, y, 16)); // Display a vertex
      getChildren().add(new Text(x - 8, y - 18, name)); 
    }
    
    // Draw edges for pair of vertices
    for (int i = 0; i < graph.getSize(); i++) {
      java.util.List<Integer> neighbors = graph.getNeighbors(i);
      int x1 = graph.getVertex(i).getX();
      int y1 = graph.getVertex(i).getY();
      for (int v: neighbors) {
        int x2 = graph.getVertex(v).getX();
        int y2 = graph.getVertex(v).getY();
        
        // Draw an edge for (i, v)
        getChildren().add(new Line(x1, y1, x2, y2)); 
      }
    }
    
    Button bfs = new Button("BFS");
    bfs.setLayoutX(700);
    bfs.setLayoutY(400);
    getChildren().add(bfs);
    bfs.setOnAction(e-> 
    {
    	
        AbstractGraph<? extends Displayable>.Tree george = 
          graph.bfs(8); 

        java.util.List<Integer> searchOrders = george.getSearchOrder();
        System.out.println(george.getNumberOfVerticesFound() +
          " vertices are searched in this order:");
        for (int i = 0; i < searchOrders.size(); i++)
          System.out.println(graph.getVertex(searchOrders.get(i)).getName());

        for (int i = 0; i < searchOrders.size(); i++)
          if (george.getParent(i) != -1)
            System.out.println("parent of " + graph.getVertex(i).getName() + 
              " is " + graph.getVertex(george.getParent(i)).getName());
    });
  }
}
