package lab1;

public class Clip {

    private String singerName;
    private String songName;
    private int lengthInSecond;
    private int amountOfViewsOnYouTube;

    public Clip() {
        this(null, null, 0, 0);
    }


    public Clip(String singerName, String songName, int lengthInSecond, int amountOfViewsOnYouTube) {
        this.singerName = singerName;
        this.songName = songName;
        this.lengthInSecond = lengthInSecond;
        this.amountOfViewsOnYouTube = amountOfViewsOnYouTube;
    }


    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public int getLengthInSecond() {
        return lengthInSecond;
    }

    public void setLengthInSecond(int lengthInSecond) {
        this.lengthInSecond = lengthInSecond;
    }

    public float getAmountOfViewsOnYouTube() {
        return amountOfViewsOnYouTube;
    }

    public void setAmountOfViewsOnYouTube(int amountOfViewsOnYouTube) {
        this.amountOfViewsOnYouTube = amountOfViewsOnYouTube;
    }




    @Override
    public String toString() {
        return "ua.lviv.iot.first.lab.Clip{" +
                "singerName='" + singerName + '\'' +
                ", songName='" + songName + '\'' +
                ", lengthInSecond=" + lengthInSecond +
                ", amountOfViewsOnYouTube=" + amountOfViewsOnYouTube +
                '}';
    }



}