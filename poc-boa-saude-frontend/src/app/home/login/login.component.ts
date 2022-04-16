import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AutenticacaoService } from 'src/app/autenticacao/autenticacao.service';
import { UsuarioService } from 'src/app/autenticacao/usuario/usuario.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  usuario = '';
  senha = '';

  constructor(
    private authService: AutenticacaoService,
    private router: Router,
    private usuarioService: UsuarioService
  ) {}

  ngOnInit(): void {}

  login() {
    this.authService.autenticar(this.usuario, this.senha).subscribe(
      (resposta) => {
        this.usuarioService.salvaToken(resposta?.token);
        console.log('Autenticado com sucesso');
        this.router.navigate(['agenda-consultas']);
      },
      (error) => {
        alert('Usuário ou senha inválido');
        console.log(error);
      }
    );
  }
}
