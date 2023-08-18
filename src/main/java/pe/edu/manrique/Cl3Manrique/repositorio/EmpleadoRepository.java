package pe.edu.manrique.Cl3Manrique.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.manrique.Cl3Manrique.entidad.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    // No es necesario agregar métodos aquí, JpaRepository ya proporciona los métodos CRUD básicos
}
