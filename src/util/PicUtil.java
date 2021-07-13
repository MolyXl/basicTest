package util;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.sun.xml.internal.ws.api.addressing.WSEndpointReference;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * @author MaZhuli
 * @version 1.0.0
 * @package util description
 * @since 2021/7/9
 */
public class PicUtil {
    public static void main(String[] args) {
        System.out.println("开始读取图片信息...");
        File jpegFile = new File("d:\\测试图片\\tt.jpg");
        Metadata metadata;
        try {
            metadata = JpegMetadataReader.readMetadata(jpegFile);
            Iterator<Directory> it = metadata.getDirectories().iterator();
            while (it.hasNext()) {
                Directory exif = it.next();
                Iterator<Tag> tags = exif.getTags().iterator();
                while (tags.hasNext()) {
                    Tag tag = (Tag) tags.next();
                    System.out.println(tag);
                }
            }
            System.out.println("图片信息读取完成！");
        } catch (JpegProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
