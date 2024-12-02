import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Math.abs;

public class Day1Part2 {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Pavan\\IdeaProjects\\AdventOfCode24\\src\\in.txt";
        String content = "";
        try {
            content = Files.readString(Path.of(filePath));
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
        ArrayList<Integer> l1 = new ArrayList<>();
        HashMap<Integer, Integer> hm2 = new HashMap<>();
        String[] lines = content.split("\n");
        for (String s : lines) {
            String[] nums = s.split("   ");
            Integer n1 = (Integer.parseInt(nums[0].trim()));
            Integer n2 = (Integer.parseInt(nums[1].trim()));
            l1.add(n1);
            hm2.put(n2, hm2.getOrDefault(n2, 0) + 1);
        }
        long similarity = 0;
        for (int i = 0; i < l1.size(); i++) {
            similarity += abs(l1.get(i) * hm2.getOrDefault(l1.get(i), 0));
        }
        System.out.println(similarity);
    }
}