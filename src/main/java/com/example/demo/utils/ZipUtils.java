package com.example.demo.utils;

import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * created by zhenzhong on 2019/12/8
 */
public class ZipUtils
{
    private static final String TEMP_PATH = "D:/temp/";

    private static final String ZIP_TEMP_PATH = "D:/tmp/zip/";

    private static final String TEMP_PATH_JPJ = "D:/tmp/picture/01.jpg";

    @Test
    public void doTest()
    {
      /*  zipFileNoBuffer(null);
        zipFileBuffer(null);*/
        zipFileChannel(null);
    }

    private File mkTempFile(String filePath, String fileName)
    {
        final File file       = new File(filePath, fileName);
        final File parentFile = file.getParentFile();
        if (!parentFile.exists())
        {
            parentFile.mkdirs();
        }
       /* else
        {
            parentFile.deleteOnExit();
            parentFile.mkdirs();
        }*/
        try
        {
            file.createNewFile();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return file;
    }

    public void zipFileNoBuffer(List<MultipartFile> files)
    {
        final File zipFile = mkTempFile(ZIP_TEMP_PATH, "01zip.zip");
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile)))
        {
            long startTime = System.currentTimeMillis();

            for (int i = 0; i < 10; i++)
            {
                final File   jpjFile     = new File(TEMP_PATH_JPJ);
                final String jpjFileName = jpjFile.getName();
                try (final FileInputStream input = new FileInputStream(jpjFile))
                {
                    zipOutputStream.putNextEntry(new ZipEntry(jpjFileName.substring(0, jpjFileName.lastIndexOf(".")) + i + ".jpg"));
                    int temp = 0;
                    while (-1 != (temp = input.read()))
                    {
                        zipOutputStream.write(temp);
                    }
                }
            }
            long endTime = System.currentTimeMillis();
            System.out.println("no bufferTIme: " + (endTime - startTime));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void zipFileBuffer(List<MultipartFile> files)
    {
        final File zipFile = mkTempFile(ZIP_TEMP_PATH, "01zip.zip");
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile)))
        {
            final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(zipOutputStream);
            long                       startTime            = System.currentTimeMillis();

            for (int i = 0; i < 10; i++)
            {
                final File   jpjFile     = new File(TEMP_PATH_JPJ);
                final String jpjFileName = jpjFile.getName();
                try (final FileInputStream input = new FileInputStream(jpjFile))
                {
                    zipOutputStream.putNextEntry(new ZipEntry(jpjFileName.substring(0, jpjFileName.lastIndexOf(".")) + i + ".jpg"));
                    int temp = 0;
                    while (-1 != (temp = input.read()))
                    {
                        bufferedOutputStream.write(temp);
                    }
                }
            }
            long endTime = System.currentTimeMillis();
            System.out.println("bufferTIme: " + (endTime - startTime));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void zipFileChannel(List<MultipartFile> files)
    {
        final File zipFile = mkTempFile(ZIP_TEMP_PATH, "01zip.zip");
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile)))
        {
            final WritableByteChannel writableByteChannel = Channels.newChannel(zipOutputStream);
            long                      startTime           = System.currentTimeMillis();

            for (int i = 0; i < 10; i++)
            {
                final File jpjFile = new File(TEMP_PATH_JPJ);
                final long length  = jpjFile.length();
                System.out.println("FileLength: " + length);
                final String jpjFileName = jpjFile.getName();
                try (final FileChannel fileChannel = new FileInputStream(jpjFile).getChannel())
                {
                    zipOutputStream.putNextEntry(new ZipEntry(jpjFileName.substring(0, jpjFileName.lastIndexOf(".")) + i + ".jpg"));
                    fileChannel.transferTo(0, length, writableByteChannel);
                }
            }
            long endTime = System.currentTimeMillis();
            System.out.println("channel time: " + (endTime - startTime));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
