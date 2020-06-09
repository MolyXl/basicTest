package mq.rocket;

import java.util.zip.CRC32;

/**
 * @author mazhuli
 * @date 2020/5/25
 * @desc ${description}
 */
public class HashUtil {
    public static long crc32Code(byte[] bytes) {
        CRC32 crc32 = new CRC32();
        crc32.update(bytes);
        return crc32.getValue();
    }
}
