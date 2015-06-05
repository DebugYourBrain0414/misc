package com.practice.resourcefinder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

public class ResourceFinder {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    String haha = ClassUtils.classPackageAsResourcePath(ResourceFinder.class);
    System.out.println("ClassUtils: "+haha);
    URL haha2 = Class.forName(ResourceFinder.class.getName()).getClassLoader().getResource("config.properties");
    System.out.println("ClassLoader: "+haha2);
    URL haha3 = ResourceUtils.getURL("config.properties");
    System.out.println("ResourceUtils + URL: "+haha3);
    File file1 = ResourceUtils.getFile(haha3);
    System.out.println("ResourceUtils + File: "+file1.getAbsolutePath());
    File files2 = new File("config.properties");
    System.out.println("File 2: "+files2.exists());
    
    final String path = "classpath:amazon/config.properties";
    File file = ResourceUtils.getFile(path);
    System.out.println("File: "+file.getAbsolutePath());
    
    if ( ! file.exists() ) {
      throw new IllegalArgumentException("FileNo");
    }

    int bufferSize = Long.valueOf(file.length()).intValue();
    InputStream inputStream = new FileInputStream(file);
    
    byte[] buffer = new byte[bufferSize];
    
    IOUtils.readFully(inputStream, buffer);
    IOUtils.closeQuietly(inputStream);
    
    System.out.println(buffer.length);
  }
}
