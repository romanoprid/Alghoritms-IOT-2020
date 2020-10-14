package lab1;

public class Utils {
    private static int bubbleExchanges = 0;
    private static int bubbleCompares = 0;
    private static int quickSort = 0;
    private static int quickCompares = 0;

    public static Clip[] bubbleSorting(Clip[] clips) {
        int n = clips.length;
        Clip free_space;
        for (int i = 0; i < clips.length; i++) {
            for (int j = 1; j < clips.length - i; j++) {
                bubbleCompares++;
                if (clips[j - 1].getLengthInSecond() < clips[j].getLengthInSecond()) {
                    free_space = clips[j - 1];

                    clips[j - 1] = clips[j];

                    clips[j] = free_space;

                    ++bubbleExchanges;
                }
            }
        }
        return clips;
    }


    public static Clip[] quickSort(Clip[] clips, int leftBorder, int rightBorder) {
        int leftSpot = leftBorder;
        int rightSpot = rightBorder;
        Clip middle = clips[(leftSpot + rightSpot) / 2];

        do {

            while (clips[leftSpot].getAmountOfViewsOnYouTube() < middle.getAmountOfViewsOnYouTube()) {
                leftSpot++;
            }
            while (clips[rightSpot].getAmountOfViewsOnYouTube() > middle.getAmountOfViewsOnYouTube()) {
                rightSpot--;
            }
            if (leftSpot <= rightSpot) {
                quickCompares++;
                if (leftSpot < rightSpot) {

                    Clip free_space = clips[leftSpot];
                    clips[leftSpot] = clips[rightSpot];
                    clips[rightSpot] = free_space;
                    ++quickSort;
                }
                leftSpot++;
                rightSpot--;
            }
        } while (leftSpot <= rightSpot);


        if (leftSpot < rightBorder) {
            quickSort(clips, leftSpot, rightBorder);
        }

        if (leftBorder < rightSpot) {
            quickSort(clips, leftBorder, rightSpot);
        }
        return clips;
    }
    public static int getCompare() {
        return bubbleCompares;
    }

    public static int getExchange() {

        return bubbleExchanges;
    }

    public static int getQuickCompare() {
        return quickCompares;
    }

    public static int getQuickExchange() {

        return quickSort;
    }
}