import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileInformation {
    public static void main(String[] args) {

    }

    // 获取文件信息
    @Test
    public void info() {
        // 先创建文件对象
        File file = new File("/Users/josh/Documents/Data_Structures_with_Java/IO流/news1.txt");

        // 调用相应的方法，得到对应信息
        System.out.println("文件名字=" + file.getName() + "\n");
        System.out.println("文件绝对路径" + file.getAbsolutePath() + "\n");
        System.out.println("文件父级目录" + file.getParent() + "\n");
        System.out.println("文件大小(字节)=" + file.length());
    }

    @Test
    public void create03() {
        String parentPath = "/Users/josh/Documents/Data_Structures_with_Java/IO流";
        String fileName = "news4.txt";

        File file = new File(parentPath, fileName);

        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
