package com.tunyl;

import com.tunyl.tthread.CounterThread;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

/**
 * @author create by Tunyl on 2020/1/21
 * @version 1.0
 */
public class MappedByteBufferTest {
    public static void main(String[] args) throws IOException {
        File file = new File("d://data-test.txt");
        long len = file.length();
        byte[] ds = new byte[(int) len];
        MappedByteBuffer mappedByteBuffer = new RandomAccessFile(file, "r")
                .getChannel()
                .map(FileChannel.MapMode.READ_ONLY, 0, len);
        for (int offset = 0; offset < len; offset++) {
            byte b = mappedByteBuffer.get();
            ds[offset] = b;
        }
        Scanner scan = new Scanner(new ByteArrayInputStream(ds)).useDelimiter("\r\n");
        while (scan.hasNext()) {
            System.out.println(scan.next());
        }


    }
}
