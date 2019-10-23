package com.tunyl.iodemo;

import java.io.*;

/**
 * @author create by Tunyl on 2019/10/22
 * @version 1.0
 */
public class ReadFs {

    public static void main(String[] args) {
        try (InputStream in = new FileInputStream("d:/robot.jpg"); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            byte[] buf = new byte[1024];
            int n = 0;
            while ((n = in.read(buf)) != -1) {
                System.out.println(n);
                out.write(buf, 0, n);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] toByteArray(String fileName) {
        try (InputStream in = new FileInputStream(fileName); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            byte[] buf = new byte[1024];
            int n = 0;
            while ((n = in.read(buf)) != -1) {
                System.out.println(n);
                out.write(buf, 0, n);
            }
            return out.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}

