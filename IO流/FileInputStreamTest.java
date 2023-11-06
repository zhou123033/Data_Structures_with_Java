import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 演示 FileInputStream 的使用(字节输入流 文件 --> 程序)
 */
public class FileInputStreamTest {
    public static void main(String[] args) {

    }

    @Test
    public void readFile01() {
        String filePath =
                "E:\\GitHub\\Data_Structures_with_Java\\IO流\\news4.txt";
        int readData = 0;
        FileInputStream fileInputStream = null;
        try {
            // 创建 FileInputStream 对象, 用于读取文件
            fileInputStream = new FileInputStream(filePath);
            // 从该输入流读取一个字节的数据, 如果没有输入可用, 此方法将阻止
            // 如果返回 -1, 表示读取完毕
            while ((readData = fileInputStream.read()) != -1) {
                System.out.println((char) readData); // 转成 char 显示
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭文件流, 释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
