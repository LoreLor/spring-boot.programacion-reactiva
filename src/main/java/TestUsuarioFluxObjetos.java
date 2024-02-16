
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class TestUsuarioFluxObjetos {
    // genero Logger para msjs en ejecucuón
    private static final Logger log = LoggerFactory.getLogger(TestUsuarioFluxObjetos.class);

    public static void main(String[] args){

        // me genero el observable (flujo)
        Flux<String> nombres = Flux.just("Lorena", "Hector cJava", "Bruno", "Nico");

        // mapeo el array y me genero una copia con el formato que quiero mostrar: un objeto
        Flux<Usuario> usuarios = nombres.map(nombre -> {
            String[] partes = nombre.split(" ");
            String nombreUsuario = partes[0].toUpperCase();
            String apellidoUsuario = partes.length > 1 ? partes[1].toUpperCase() : ""; // Manejo del caso cuando no hay apellido
            return new Usuario(nombreUsuario, apellidoUsuario);
        })
            .filter(usuario -> usuario.getApellido().equalsIgnoreCase("cJava"))
            .doOnNext(usuario -> {
                    if (usuario == null){
                        throw new RuntimeException("Los Nombres no pueden estar vacíos");
                    }
                    System.out.println(usuario.getNombre().concat(" ").concat(usuario.getApellido()));
                })
            .map(usuario -> {
                String nombre = usuario.getNombre().toLowerCase();
                usuario.setNombre(nombre);
                return usuario;
            });
        // ahora me subscribo al observable
        usuarios.subscribe(
                e -> log.info(e.toString()),
                error -> log.error(error.getMessage()),
                new Runnable() {
                    @Override
                    public void run() {

                        log.info("La ejecución del Observable ha finalizado con éxito!");
                    }
                }
        );
    }
}
