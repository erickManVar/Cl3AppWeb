package pe.edu.manrique.Cl3Manrique.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import pe.edu.manrique.Cl3Manrique.entidad.Empleado;
import pe.edu.manrique.Cl3Manrique.servicio.EmpleadoServicio;

import java.util.List;

@Controller
public class EmpleadoControlador {
    @Autowired
    private EmpleadoServicio servicio;

    @GetMapping("/empleados")
    public String listarEmpleados(Model modelo) {
        List<Empleado> empleados = servicio.listarTodosLosEmpleados();
        modelo.addAttribute("empleados", empleados);
        return "nosotros";
    }

    @GetMapping("/nuevo")
    public String nuevoEmpleadoForm(Model modelo) {
        Empleado empleado = new Empleado();
        modelo.addAttribute("empleado", empleado);
        return "nuevo";
    }

    @PostMapping("/guardar")
    public String guardarEmpleado(@ModelAttribute("empleado") Empleado empleado) {
        // Set the dni value before saving
        empleado.setDni(empleado.getDni());
        servicio.guardarEmpleado(empleado);
        return "redirect:/empleados"; // Redirect to the "empleados" page
    }

    @GetMapping("/editar/{id}")
    public String editarEmpleadoForm(@PathVariable Long id, Model modelo) {
        Empleado empleado = servicio.obtenerEmpleadoPorId(id);
        modelo.addAttribute("empleado", empleado);
        return "editar";
    }

    @PostMapping("/editar/{id}")
    public String actualizarEmpleado(@ModelAttribute("empleado") Empleado empleadoActualizado, @PathVariable Long id) {
        Empleado empleado = servicio.obtenerEmpleadoPorId(id);

        // Actualizar los campos necesarios del empleado con los valores del formulario
        empleado.setNombre(empleadoActualizado.getNombre());
        empleado.setApellido(empleadoActualizado.getApellido());
        empleado.setDni(empleadoActualizado.getDni());
        empleado.setEdad(empleadoActualizado.getEdad());
        empleado.setSalario(empleadoActualizado.getSalario());
        empleado.setPuesto(empleadoActualizado.getPuesto());

        servicio.guardarEmpleado(empleado);
        return "redirect:/empleados"; // Redirect to the "empleados" page
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEmpleado(@PathVariable Long id) {
        servicio.eliminarEmpleado(id);
        return "redirect:/empleados"; // Redirect to the "empleados" page
    }

    @GetMapping("/")
    public String redirectToEmpleados() {
        return "redirect:/empleados"; // Redirect to the "empleados" page
    }
}
