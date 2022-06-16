package DataStructures; 
import java.security.spec.EdDSAParameterSpec;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;

class VerticeNotFoundException extends Exception{
    private String verticeName;
    public VerticeNotFoundException(String verticeName){
        this.verticeName = verticeName;
    }

    public String toString(){
        return "The vertice " + this.verticeName +" does not exist. ";
    }
}
class EgdeNotFoundException extends Exception{
    private String edgeName, verticeName;
    public EgdeNotFoundException(String edgeName, String verticeName){
        this.edgeName = edgeName;
        this.verticeName = verticeName;
    }

    public String toString(){
        return "The edge " + this.edgeName + " is not connected to the vertice " + this.verticeName + ". ";
    }
}

class InvalidVerticeException extends Exception{
    private String verticeName;
    public InvalidVerticeException(String verticeName){
        this.verticeName = verticeName;

    }
    public String toString() {
        return "Vertice with the name "+this.verticeName+" already exists.";
    }
}

class InvalidEdgeException extends Exception{
    private String edgeName;
    public InvalidEdgeException(String edgeName){
        this.edgeName = edgeName;
    }

    @Override
    public String toString() {
        return "The edge "+ this.edgeName + " is the name of the vertice you are trying to connect to. ";
    }
}

public class Graph {
    private HashMap<String, ArrayList<String>> graphs;
    public Graph(){
        this.graphs = new HashMap<>();
    }

    public void addVertice(String verticeName) throws InvalidVerticeException{
        if(this.graphs.get(verticeName) == null)
            this.graphs.put(verticeName, new ArrayList<String>());
        else{
            throw new InvalidVerticeException(verticeName);
        }
    }

    public void addEdges(String verticeName, String ...edges) throws InvalidEdgeException, InvalidVerticeException{
        if(this.graphs.get(verticeName) == null) throw new InvalidEdgeException(verticeName);
        for(String vertices: edges){
            if(vertices.equals(verticeName)) throw new InvalidEdgeException(verticeName);
            if(this.graphs.get(vertices) == null){
                this.addVertice(vertices);
            }
            this.graphs.get(verticeName).add(vertices);
        }

    }

    public void removeEdge(String verticeName, String edgeName) throws VerticeNotFoundException, EgdeNotFoundException{
        if(this.graphs.get(verticeName) != null){
            if(!this.graphs.get(verticeName).remove(edgeName)) throw new EgdeNotFoundException(edgeName, verticeName);
        }else throw new VerticeNotFoundException(verticeName);

    }

    public void removeVertice(String verticeName) throws VerticeNotFoundException{
        if(this.graphs.containsKey(verticeName)){
            this.graphs.remove(verticeName);
            Set keys = this.graphs.keySet();
            for(Object vertice: keys){
                this.graphs.get(vertice.toString()).remove(verticeName);
            }
        }else throw new VerticeNotFoundException(verticeName);
    }

    public String toString(){
        return this.graphs.toString();
    }

    public static void main(String[] args) throws InvalidVerticeException, InvalidEdgeException, EgdeNotFoundException, VerticeNotFoundException{
        Graph g = new Graph();
        g.addVertice("Anam");
        g.addEdges("Anam", "Ho", "Hello");
        g.addEdges("Hello", "Anam", "Wow");
        System.out.println(g);
        g.removeVertice("Anam");
        System.out.println(g);


    }
}
