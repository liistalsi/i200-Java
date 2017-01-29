package OOP;
import java.util.ArrayList;
/**
 * netist
 */
public class Sonaraamat {
    ArrayList<String> list = new ArrayList<>();
    String raamatuKeel;
    public Sonaraamat(String raamatuKeel){
        this.raamatuKeel = raamatuKeel;
    }
    public void sisestaSona(String sona){
        list.add(list.size(),sona);
    }
    public void eemaldaSona(String sona){
        for (int i = 0; i < list.size(); i++) {
            if (sona==list.get(i)){
                list.remove(i);
            }
        }
        System.out.println(list);
    }
    public String[] otsiEsimeseTaheJargi (String taht){
        String[] tulemus = new String[2];
        int a = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).startsWith(taht)){
                tulemus[a] = list.get(i);
                a++;
            }
        }
        return tulemus;
    }
    public void misKeelesRaamatOn(){
        System.out.println(raamatuKeel);
    }
}
