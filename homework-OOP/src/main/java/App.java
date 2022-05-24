import com.agolikov.homework.*;

public class App {

       public static void main(String[] args) {
        Playable[] playables = {
                new Drum(1, "Pearl EXX-705NBR/C704"),
                new Guitar(2, "FENDER SQUIER MM STRATOCASTER BLACK"),
                new Piano(3, "Becker CBUP-121PB"),
                new Violin(4, "Stagg EVN X-4/4 BK"),
                new Radio("Radioplayer", 105.2)

        };

        for (Playable p : playables) {
            p.play();
        }


    }

}
