import java.util.List;
import java.util.ArrayList;

public class Especialidades { 
    private static List<String> ListaEspecialidades = new ArrayList<>(List.of(
            "Clínico Geral", 
            "Cardiologista", 
            "Pediatra", 
            "Ortopedista", 
            "Dermatologista", 
            "Oftalmologista", 
            "Ginecologista", 
            "Neurologista", 
            "Psiquiatra", 
            "Endocrinologista",
            "Urologista"
        ));

    public List<String> getLista() {
        return ListaEspecialidades;
    };
}