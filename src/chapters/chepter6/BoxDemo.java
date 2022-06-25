package chapters.chepter6;

public class BoxDemo {
    public static void main(String[] args) {
        Box myBox1 = new Box(3, 5, 17);
        Box myBox2 = new Box();
        Box mycube = new Box(6);
        Box myclon = new Box(myBox1);
        double vol;

        vol = myBox1.volume();
        System.out.println("vol " + vol);


        vol = myBox2.volume();
        System.out.println("vol " + vol);

        vol = mycube.volume();

        vol = myclon.volume();
        System.out.println("vol " + vol);




    }
}
