import org.junit.Test;

import java.io.File;

public class Directory_ {

    // 判断 news1.txt 是否存在, 如果存在就删除
    @Test
    public void m1() {
        String filePath = "/Users/josh/Documents/Data_Structures_with_Java/IO流/news1.txt";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(filePath + " 删除成功");
            } else {
                System.out.println(filePath + " 删除失败");
            }
        } else {
            System.out.println("该文件不存在");
        }
    }

    // 判断 /Users/josh/Documents/Data_Structures_with_Java/IO流/a 是否存在
    // 如果存在就提示已经存在，否则就创建
    @Test
    public void m3() {
        String directoryPath = "/Users/josh/Documents/Data_Structures_with_Java/IO流/a";
        File file = new File(directoryPath);

        if (file.exists()) {
            System.out.println("/Users/josh/Documents/Data_Structures_with_Java/IO流/a" + "存在");
        } else {
            if (file.mkdirs()) {
                System.out.println("/Users/josh/Documents/Data_Structures_with_Java/IO流/a" + "创建成功");
            } else {
                System.out.println(directoryPath + "创建");
            }
        }
    }
}
