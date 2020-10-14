package lab1;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClipMaker {

    public static void main(String[] args) throws IOException {


        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(
                    "test.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line = null;
        Scanner scanner = null;
        int index = 0;
        List<Clip> emptyList = new ArrayList<>();

        while (true) {
            try {
                assert reader != null;
                if ((line = reader.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            Clip clip = new Clip();
            assert line != null;
            scanner = new Scanner(line);
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 0)
                    clip.setSingerName(data);


                else if (index == 1)
                    clip.setSongName(data);
                else if (index == 2)
                    clip.setLengthInSecond(Integer.parseInt(data));

                else if (index == 3)
                    clip.setAmountOfViewsOnYouTube(Integer.parseInt(data));
                else
                    System.out.println("Error!!!" + data);
                index++;
            }
            index = 0;
            emptyList.add(clip);
        }


        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Clip[] clips = new Clip[0];
        clips = emptyList.toArray(clips);




        long start = System.currentTimeMillis();
        Clip[] information = Utils.bubbleSorting(clips);
        long end = System.currentTimeMillis();
        printData(information, "Buble Sort", end - start,
                Utils.getExchange(), Utils.getCompare());



        long startSort = System.currentTimeMillis();
        Clip[] clipsInfo = Utils.quickSort(clips, 0, 5);
        long endSort = System.currentTimeMillis();

        printData(clipsInfo, "Quick Sort", endSort - startSort,
                Utils.getQuickExchange(), Utils.getQuickCompare());




    }
    protected static void printData(Clip[] clips, String nameOfAlgorithm, long timeInMillis,
                                    int numberOfExchanges, int numberOfCompare) {
        System.out.println(nameOfAlgorithm + " "  + timeInMillis+ " "  + numberOfCompare+ " "
                + numberOfExchanges+ " " + "\n");
        for (Clip clip : clips) {
            System.out.println(clip);
        }
    }

}




