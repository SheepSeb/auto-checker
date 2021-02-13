package Ground.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class sursa4 {
    public static void main(String[] args) throws IOException {
        int output = 0;

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        output = a +b;

        System.out.print(output);
    }
}
