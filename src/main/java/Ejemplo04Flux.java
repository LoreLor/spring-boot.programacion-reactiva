import reactor.core.publisher.Flux;

public class Ejemplo04Flux {
    public static void main(String[] args) {

        // me creo el publisher: es un array de strings
        Flux<String> flux = Flux.fromArray(new String[]{"naranjas", "peras", "manzanas", "frutillas"});

        // me subscribo y lo muestro directamente
        flux.subscribe(System.out::println);

        System.out.println("****************************");

        // otra forma: aplico el método para recorrer elementos: doOnNext(), y luego me subscribo;
        flux.doOnNext(System.out::println).subscribe();
    }
}
