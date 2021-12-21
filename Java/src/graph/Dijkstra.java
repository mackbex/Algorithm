package graph;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Test;

import java.util.*;

class Node{
    String name;
    Integer distance = Integer.MAX_VALUE;

    public Node(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

//    @Override
//    public int compare(Node node1, Node node2)
//    {
//        return node1.distance - node2.distance; //ASC
//    }
}

public class Dijkstra {

   @Test
    public void test() {

        JsonObject obj = new JsonParser().parse(
                "{" +
                        "'A': {'B': 8, 'C': 1, 'D': 2}," +
                        "'B': {}," +
                        "'C': {'B': 5, 'D': 2}," +
                        "'D': {'E': 3, 'F': 5}," +
                        "'E': {'F': 1}," +
                        "'F': {'A': 5}" +
                    "}"
        ).getAsJsonObject();

        System.out.println(dijkstra(obj, "A", "F"));
    }

    private String dijkstra(JsonObject obj, String start, String end) {
        Map<String, Node> distances = new HashMap<>();

        for(Map.Entry<String, JsonElement> entry : obj.entrySet()) {
            distances.put(entry.getKey(), new Node("A", Integer.MAX_VALUE));
        }

        distances.get(start).distance = 0;

        PriorityQueue<Node> queue = new PriorityQueue<Node>((node1, node2) -> {
            return node1.distance - node2.distance;
        });
        queue.add(new Node(start, distances.get(start).distance));

        while(!queue.isEmpty()) {

            Node curNode = queue.poll();
            int current_distance = curNode.distance;
            String current_vertex = curNode.name;

            if(distances.get(current_vertex).distance < current_distance) continue;
            JsonObject graphItem = obj.get(current_vertex).getAsJsonObject();

            for(Map.Entry<String, JsonElement> entry : graphItem.entrySet()) {
                int distance = current_distance + entry.getValue().getAsInt();

                if(distance < distances.get(entry.getKey()).distance) {
                    distances.put(entry.getKey(), new Node(current_vertex, distance));
                    queue.add(new Node(entry.getKey(),distance));
                }
            }
        }

        String path = end;
        String path_output = end + "->";
        while(distances.get(path).name != start){
            if(distances.get(path).name == start) break;
            path_output += distances.get(path).name + "->";
            path = distances.get(path).name;
        }

        path_output += start;


        return path_output;
    }

}
