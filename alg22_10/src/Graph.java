import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {
        int N;
        LinkedList<Integer> adg[];

        public Graph(int n) {
                N = n;
                adg = new LinkedList[N];
                for (int i = 0; i < N; i++) {
                        adg[i] = new LinkedList<>();
                }
        }

        public void addEdge(int n, int value) {
                adg[n].add(value);
        }

        public void writeAdg(LinkedList<Integer> adg[]) {
                for (int i = 0; i < N; i++) {
                        System.out.println();
                        for (Integer j : adg[i]) {
                                System.out.print(j + " ");
                        }
                        System.out.println();
                }
        }
        public void bfs(int n, BufferedWriter bufferedWriter) throws IOException {
                boolean visited[] = new boolean[N];
                int distance[] = new int[N];
                Queue<Integer> queue = new LinkedList<Integer>();
                Arrays.fill(distance,-1);

                visited[n] = true;
                distance[n] = 0;
                queue.add(n);

                while (!queue.isEmpty()){
                     int current = queue.poll();
                     bufferedWriter.write("Из вершины " + (n+1) + " в вершину "
                             + (current + 1) + " расстояние: " + distance[current] + "\n");
                     for(Integer neighbor: adg[current]){
                             if (!visited[neighbor - 1]){
                                     visited[neighbor - 1] = true;
                                     distance[neighbor - 1] = distance[current] + 1;
                                     queue.add(neighbor - 1);
                             }
                     }
                }
        }
        public void readGraph(String nameFile){
                try {
                        File file = new File(nameFile);
                        Scanner sc = new Scanner(file);

                        while (sc.hasNextLine()){
                                String line = sc.nextLine();
                                String arr[] = line.split(" ");
                                int value;
                                int count = 0;//= Integer.parseInt(arr[0]);
                                //= Integer.parseInt(arr[1]);
                                int n = Integer.parseInt(arr[count]);
                                for (int j = 0; j < N; j++) {
                                        value = Integer.parseInt(arr[j]);
                                        if (value != 0){
                                                System.out.print( value +  "  ");
                                                addEdge(n,j+1);
                                        }
                                }
                                System.out.println(arr[0] +  " " + arr[1] +  " " + arr[2] +  " " + arr[3] +  " " + arr[4] +  " " + arr[5]);
                        }
                        sc.close();
                } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                }
        }
}


//
//import java.io.*;
//import java.util.*;
//
//public class Graph {
//        private int V; // Количество вершин
//        private LinkedList<Integer> adj[]; // Список смежности
//
//        // Конструктор
//        Graph(int v) {
//                V = v;
//                adj = new LinkedList[v];
//                for (int i = 0; i < v; ++i)
//                        adj[i] = new LinkedList();
//        }
//
//        // Добавление ребра в граф
//        void addEdge(int v, int w) {
//                adj[v].add(w);
//        }
//
//        // Поиск в ширину из заданной вершины
//        void BFS(int s, BufferedWriter writer) throws IOException {
//                boolean visited[] = new boolean[V];
//                int distance[] = new int[V];
//                Arrays.fill(distance, -1); // Изначально все расстояния неизвестны
//                Queue<Integer> queue = new LinkedList<Integer>();
//
//                visited[s] = true;
//                distance[s] = 0;
//                queue.add(s);
//
//                while (!queue.isEmpty()) {
//                        int current = queue.poll();
//                        writer.write("Из вершины " + s + " в вершину " + current + " расстояние: " + distance[current] + "\n");
//
//                        for (Integer neighbor : adj[current]) {
//                                if (!visited[neighbor]) {
//                                        visited[neighbor] = true;
//                                        distance[neighbor] = distance[current] + 1;
//                                        queue.add(neighbor);
//                                }
//                        }
//                }
//        }
//
//        // Чтение графа из файла с матрицей смежности
//        void readGraphFromFile(String fileName) {
//                try {
//                        File file = new File(fileName);
//                        Scanner scanner = new Scanner(file);
//                        while (scanner.hasNextLine()) {
//                                String line = scanner.nextLine();
//                                String[] parts = line.split(" ");
//                                int v = Integer.parseInt(parts[0]);
//                                int w = Integer.parseInt(parts[1]);
//                                addEdge(v, w);
//                        }
//                        scanner.close();
//                } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                }
//        }
//}