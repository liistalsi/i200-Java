import java.util.ArrayList;

public class Kassa extends Pood {

    String kassapidaja;

    public Kassa(String kassapidaja) {

        this.kassapidaja = kassapidaja;

    }

    ArrayList<String> Ostukorv = new ArrayList<>();

    public void lisaToode(String toode) {

        Ostukorv.add(toode);

    }

    public void eemaldaToode(String toode) {

        Ostukorv.remove(toode);

    }

    public void prindiOstutsekk() {

        System.out.println("Ostukorvis on hetkel: " + Ostukorv);
    }

    public void prindiKassapidajaNimi() {

        System.out.println(kassapidaja);


    }
}
