import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.abs;

public class Day1_Part1 {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Pavan\\IdeaProjects\\AdventOfCode24\\src\\in.txt";
        String content = "";
        try {
            content = Files.readString(Path.of(filePath));
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
        ArrayList<Integer> n1 = new ArrayList<>();
        ArrayList<Integer> n2 = new ArrayList<>();
        String[] lines = content.split("\n");
        for (String s : lines) {
            String[] nums = s.split("   ");
            n1.add(Integer.parseInt(nums[0].trim()));
            n2.add(Integer.parseInt(nums[1].trim()));
        }
        Collections.sort(n1);
        Collections.sort(n2);
        long distance = 0;
        for (int i = 0; i < n1.size(); i++) {
            distance += abs(n1.get(i) - n2.get(i));
        }
        System.out.println(distance);
    }
}