package leetcode.marina;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SectionSplitter {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/leetcode/marina/Text.txt");
        List<String> texts = FileUtils.readLines(file, "UTF-8");

        int linesPerSection = 9;
        int maxCharsPerLine = 24;
        int lineIndex = 0;
        int sectionIndex = 1;
        System.out.println("          " + sectionIndex);
        for (String text : texts) {
            int actualLines = (text.length() / maxCharsPerLine) + (text.length() % maxCharsPerLine > 0 ? 1 : 0);
            int actualLinesAfterThisText = lineIndex + actualLines;
            if (actualLinesAfterThisText > linesPerSection) {
                // add empty lines to fill the section
                for (int i = 0; i < linesPerSection - lineIndex; i++) {
                    System.out.println();
                }
                // next section starts
                System.out.println("\n");
                System.out.println("          " + ++sectionIndex);
                System.out.println(text);
                lineIndex = actualLines;
            } else if (actualLinesAfterThisText == linesPerSection) {
                System.out.println(text);

                // next section starts
                System.out.println("\n");
                System.out.println("          " + ++sectionIndex);

                lineIndex = 0;
            } else if (actualLinesAfterThisText < linesPerSection) {
                System.out.println(text);
                lineIndex = actualLinesAfterThisText;
            }
        }
    }
}
