import reactor.core.publisher.Mono;

public class Ejemplo03FromSupplier {
    public static void main(String[] args) {

        // fromSupllier interface de programación funcional para emitir excepciones
        Mono<String> mono = Mono.fromSupplier(() -> {
            throw new RuntimeException("Excepción ocurrida");
        });
        mono.subscribe(
                data -> System.out.println(data), //onNext()
                err -> System.out.println(err), //onError()
                () -> System.out.println("Completed!") //onComplete()
        );
        // larga la excepción pq no existe data para mostrar
    }
}
