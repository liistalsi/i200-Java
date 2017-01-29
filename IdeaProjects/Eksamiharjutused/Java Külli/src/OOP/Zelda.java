package OOP;

/**
 * TEHTUD!
 * Created by kullirist on 19/01/2017.
 */
public class Zelda {

    private int elusid;

    public Zelda(int elusid) {
        this.elusid = elusid;
    }

    public void kaklusKolliga(int kollilelusid){
        this.elusid = this.elusid - kollilelusid;
    }

    public void prindiMituEluAlles(){
        System.out.println(this.elusid);
    }

    public void prindiKasOnElus(){
        if(this.elusid > 0){
            System.out.println("Elus");
        }
        else{
            System.out.println("Surnud");
        }
    }
}
