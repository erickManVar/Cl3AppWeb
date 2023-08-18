package pe.edu.manrique.Cl3Manrique.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.manrique.Cl3Manrique.entidad.Empleado;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    // Aquí puedes añadir métodos personalizados si es necesario.
    List<Empleado> findByNombre(String nombre);
}
