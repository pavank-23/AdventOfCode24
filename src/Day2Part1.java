import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;

import static java.lang.Math.abs;

public class Day2Part1 {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Pavan\\IdeaProjects\\AdventOfCode24\\src\\in.txt";
        String content = "";
        try {
            content = Files.readString(Path.of(filePath));
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
        ArrayList<ArrayList<Integer>> levels = new ArrayList<>();
        String[] lines = content.split("\n");
        for (String s : lines) {
            String[] nums = s.split(" ");
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                temp.add(Integer.parseInt(nums[i].trim()));
            }
            levels.add(temp);
        }
        long safe = 0;
        for (ArrayList<Integer> level : levels) {
            int j;
            for (j = 1; j < level.size(); j++) {
                if ((abs(level.get(j - 1) - level.get(j)) > 3 || abs(level.get(j - 1) - level.get(j)) < 1)) {
                    break;
                }
            }
            if (j != level.size()) continue;
            for (j = 1; j < level.size(); j++) {
                if (level.get(j - 1) >= level.get(j)) break;
            }
            if (j == level.size()) safe += 1;
            for (j = 1; j < level.size(); j++) {
                if (level.get(j - 1) <= level.get(j)) break;
            }
            if (j == level.size()) safe += 1;
        }
        System.out.println(safe);
    }
}
