package chapter03.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ProcessFileEx {
    public static String processFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/jjy/IdeaProjects/modernJavaInAction/src/chapter03/data.txt"))) {
            return br.readLine(); // 실제 필요한 작업을 하는 행
        }
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/jjy/IdeaProjects/modernJavaInAction/src/chapter03/data.txt"))) {
            return p.process(br); // 실제 필요한 작업을 하는 행
        }
    }
}
