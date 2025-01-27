import java.util.*;
public class Pferd{
    private int i = 0;
    private int geschw = 5;
    Random rand = new Random();
    public Pferd(){

        geschw = 5;

    }

    public void setPosition(){
        i = i + geschw;
    }
    public int getPosition(){
        return i;
    }
    public void setGeschw(){
        int n = rand.nextInt(3);
        geschw = 5 + n;
        //System.out.println("Rand:" + n);
        //System.out.println("Gesch:" + geschw);
    }
    public int getGeschw(){
        return geschw;
    }

}
