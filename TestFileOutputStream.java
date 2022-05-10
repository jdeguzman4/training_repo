// This is a sample test class.
package org.ssglobal.training.codes.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class TestFileOutputStream {

	public static void main(String[] args) {
		File file = new File("./src/config/poem.txt");
		Scanner scan = new Scanner(System.in);

		try (FileOutputStream fos = new FileOutputStream(file);) {
			// Composition Design Pattern
			while (true) {
				System.out.println("Enter a Message: ");
				String message = scan.nextLine();
				String messageLine = String.join("", message, "\n"); // fos does not include line feed
				byte[] msgBytes = messageLine.getBytes();
				if (message.length() == 0) {
					break;
				}
				fos.write(msgBytes);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		scan.close();
	}
}
