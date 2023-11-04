import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用 FileOutputStream 将数据写到文件中
 * 如果该文件不存在, 则创建该文件
 */
public class FileOutputStreamTest {

    public static void main(String[] args) {

    }

    @Test
    public void writeFile() {
        // 创建 FileOutputStream 对象
        String filePath =
                "/Users/josh/Documents/Data_Structures_with_Java/IO流/news4.txt";
        FileOutputStream fileOutputStream = null;

        try {
            // 得到 fileOutputStream 对象
            fileOutputStream = new FileOutputStream(filePath);
            // 写入一个字节
            fileOutputStream.write('H');
            // 写入字符串
            String str = "Hello, World";
            // str.getBytes() 可以把 字符串->字节数组
            fileOutputStream.write(str.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
