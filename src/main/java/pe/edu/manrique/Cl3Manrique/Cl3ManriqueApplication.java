package pe.edu.manrique.Cl3Manrique;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class Cl3ManriqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cl3ManriqueApplication.class, args);
	}

	@RequestMapping("/")
	public String home() {
		return "redirect:/login";
	}
}
