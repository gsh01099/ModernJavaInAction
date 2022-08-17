package chapter01;

import java.io.File;
import java.io.FileFilter;

public class FileExample {
    public static void main(String[] args) {

        // jdk 8 이전에 사용 되었던 익명객체  코드
        File[] oldHiddenFilse = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });

        // jdk 8 이후의 익명객체 사용 코드
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);
    }
}
