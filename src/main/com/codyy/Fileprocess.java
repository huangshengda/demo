package main.com.codyy;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class Fileprocess {
	public static void main(String[] args) throws IOException {
		String uuid = UUID.randomUUID().toString();
		Path file = Paths.get("D:/" + uuid + ".txt");

		if (!Files.exists(file)) {
			Files.createFile(file);
		}
		
		BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8);
        writer.write("测试文件写操作");
        writer.newLine();
        writer.write("测试文件写操作");
        writer.write("测试文件写操作");
        writer.flush();
        writer.close();
        
        System.out.println("Output:"+System.getProperty("line.separator"));
	}
}
