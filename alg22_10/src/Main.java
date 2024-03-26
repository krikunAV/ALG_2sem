import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        Graph graph = new Graph(6);
        graph.readGraph("graph.txt");
        graph.writeAdg(graph.adg);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("rezut.txt"));

        graph.bfs(0,bufferedWriter);
        bufferedWriter.close();
    }
}
//public static void main(String args[]) throws IOException {
//    int vertices = 6; // Количество вершин в графе
//    Graph graph = new Graph(vertices);
//    graph.readGraphFromFile("graph.txt"); // Название файла с матрицей смежности
//
//    BufferedWriter writer = new BufferedWriter(new FileWriter("rezut.txt"));
//
//    int startVertex = 0; // Начальная вершина для поиска
//    graph.BFS(startVertex, writer);
//    writer.close();
//}   }