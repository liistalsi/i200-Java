
/**
 * Loo Chat klass, et käesolev programm saaks normaalselt toimida.
 *
 * On üks reegel: Gitter klassi muuta ei tohi.
 */
public class Gitter {

    public static void main(String[] args) {

        String toaNimi = "Elutuba";
        Chat chat = new Chat(toaNimi);

        chat.sisestaSonum("Taavi", "Tere, on keegi siin?");
        chat.sisestaSonum("Eva", "Tsau, ilus poiss. Mis otsid?");
        chat.sisestaSonum("Taavi", "Kuule, ega sa ei tea kuidas seda OOP ülesannet lahendada?");
        chat.sisestaSonum("Taavi", "Pean siin nii kasutajanime kui ka sõnumi kuhugi salvestama..");
        chat.sisestaSonum("Eva", "Oh sind totut, võimalusi on ju mitu.");
        chat.sisestaSonum("Eva", "Aga pead ise välja mõtlema");
        chat.sisestaSonum("Eva", "sest õppejõud näeb meie kirjutatut.");
        chat.sisestaSonum("Taavi", "Kurat ta jälle nii raske eksami tegi..");

        chat.prindiKoikSonumidKoosKasutajanimega();

        chat.adminKustutabSonumi("Kurat ta jälle nii raske eksami tegi..");
        chat.sisestaSonum("Krister", "Sul veab, et siin chatis välja viskamise funktsionaalsust ei ole :)");

        chat.prindiKoikSonumidKoosKasutajanimega();
        chat.prindiToaNimi();
    }
}
