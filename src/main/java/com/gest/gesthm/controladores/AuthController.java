package com.gest.gesthm.controladores;

import com.gest.gesthm.entity.Usuario;
import com.gest.gesthm.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario loginRequest) {
        Usuario usuario = usuarioService.findByNombreUsuario(loginRequest.getNombreUsuario());

        if (usuario != null && usuario.getContraseña().equals(loginRequest.getContraseña())) {
            return ResponseEntity.ok("Autenticación exitosa");
        } else {
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }
    }
}
