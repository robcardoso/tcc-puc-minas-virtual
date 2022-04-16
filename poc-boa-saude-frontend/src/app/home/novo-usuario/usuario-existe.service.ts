import { Injectable } from '@angular/core';
import { AbstractControl } from '@angular/forms';
import { NovoUsuarioService } from './novo-usuario.service';
import { map, switchMap, first } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class UsuarioExisteService {
  constructor(private novoUsuarioService: NovoUsuarioService) {}

  // requisição assincrona ao backend  switchMap (para trocar fluxo), map ( para trocar resultado), first (encerrar o observar)
  usuarioJaExiste() {
    return (control: AbstractControl) => {
      return control.valueChanges?.pipe(
        switchMap((nomeUsuario) =>
          this.novoUsuarioService.verificaUsuarioExistente(nomeUsuario)
        ),
        map((usuarioExiste) => (usuarioExiste ? { usuarioExistente: true } : null)
        ),
        first()
      );
    };
  }
}
