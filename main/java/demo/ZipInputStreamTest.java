package demo;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipInputStreamTest {
    public static void main(String[] args) {
        try {
            decryptZipFile("D:\\project\\ziptest.zip");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void decryptZipFile(String filePath) throws IOException {
        System.out.println("start decryptZipFile");
        if (Objects.isNull(filePath)){
            return;
        }
        if (!filePath.endsWith(".zip")) {
            return;
        }
        File file = new File(filePath);
        if (!file.exists()) {
            return;
        }
        FileInputStream fileInputStream = new FileInputStream(filePath);
        ZipInputStream zipInputStream = new ZipInputStream(fileInputStream, Charset.forName("GBK"));
        decryptZipFile(zipInputStream, file.getParent() + File.separator);
        zipInputStream.close();
        fileInputStream.close();
    }

    public static void decryptZipFile(ZipInputStream inputStream, String outFilePath) throws IOException, IllegalArgumentException {
        System.out.println("decryptZip to " + outFilePath);
        ZipEntry zipEntry;
        while ((zipEntry = inputStream.getNextEntry()) != null) {
            String zipName = zipEntry.getName();
            System.out.println("zipEntryNAME " + zipName + "  isDir " + zipEntry.isDirectory());
            if (zipName == null) {
                continue;
            }
            File file = new File(outFilePath, zipName);
            System.out.println(file.getAbsolutePath());
            if (zipEntry.isDirectory()) {
                file = new File(outFilePath, zipName);
                System.out.println(file.getAbsolutePath());
                file.mkdir();
            } else {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                int cha;
                byte[] bytes = new byte[1024];
                while (((cha = inputStream.read(bytes)) != -1)) {
                    bufferedOutputStream.write(bytes, 0, cha);
                }
                bufferedOutputStream.close();
                fileOutputStream.close();
            }
            inputStream.closeEntry();
        }
    }
}
