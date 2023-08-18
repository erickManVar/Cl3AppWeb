package pe.edu.manrique.Cl3Manrique.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.manrique.Cl3Manrique.entidad.Empleado;
import pe.edu.manrique.Cl3Manrique.repositorio.EmpleadoRepository;

import java.util.List;

@Service
public class EmpleadoServicio {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> listarTodosLosEmpleados() {
        return empleadoRepository.findAll();
    }

    public Empleado obtenerEmpleadoPorId(Long id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    public void guardarEmpleado(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    public void eliminarEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }
}
