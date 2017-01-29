package OOP;

import java.util.ArrayList;
import java.util.HashMap;

/** TEHTUD reedel koos
 */

public class Chat {

    ArrayList<String> nimed = new ArrayList<>();
    ArrayList<String> sonumid = new ArrayList<>();
    int loendur;
    String toaNimi;
    public Chat(String toaNimi){
        this.toaNimi = toaNimi;
    }
    public void sisestaSonum(String nimi, String sonum){

        nimed.add(nimed.size(),nimi);
        sonumid.add(sonumid.size(),sonum);

    }
    public void prindiKoikSonumidKoosKasutajanimega(){

        for (int i = 0; i < nimed.size(); i++) {
            System.out.println(nimed.get(i)+": "+sonumid.get(i));
        }
        System.out.println("");
    }
    public void adminKustutabSonumi(String sonum){


        for (int i = 0; i <sonumid.size() ; i++) {
            if (sonum == sonumid.get(i)){
                sonumid.set(i, "Kustutatud Admini poolt!");
            }
        }
    }
    public void prindiToaNimi(){
        System.out.println(toaNimi);
    }
}