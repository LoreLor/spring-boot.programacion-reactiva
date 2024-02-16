import reactor.core.publisher.Mono;

public class Ejemplo02Mono {
    public static void main (String[] args) {
        // agrego String
        Mono<String> mono = Mono.just("Soy Lorena");

        // me subscribo y aplico lambda
        mono.subscribe(
                data -> System.out.println(data),       // esto sería el método onNext() para pasar al siguiente elemento;
                err -> System.out.println(err),         // es el método onError()
                () -> System.out.println("Completed!")  // método onCompleted()
        );
    }
}
