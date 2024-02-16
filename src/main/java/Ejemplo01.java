import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Ejemplo01 {
    public static void main(String[] args){

        List<Integer> elementFromMono = new ArrayList<Integer>();
        List<Integer> elementFromFlux = new ArrayList<Integer>();

        // Mono: es un publisher(observable) - un observable que emite datos de 0 a 1;
        // 1 - genero el flujo mono
        Mono<Integer> mono = Mono.just(121);

        // 2 - me subscribo al observable, obtengo los datos y  agrego a la lista con método de referencia:
        mono.subscribe(elementFromMono::add);

        // 3 - muestro datos
        System.out.println(elementFromMono);


        // Flux: es un publisher (Observable) que emite datos de 0 a n elementos;
        // 1 - me genero el flujo Flux
        Flux<Integer> flux = Flux.just(1,3,4,6,78);

        // 2 - me subscribo y agrego los datos a la lista con método de referencia;
        flux.subscribe(elementFromFlux::add);

        // 3 - muestro datos
        System.out.println(elementFromFlux);

    }
}
