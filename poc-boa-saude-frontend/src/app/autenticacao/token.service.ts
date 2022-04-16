import { Injectable } from '@angular/core';

const KEY = 'token';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  // caso não pegue a chave retorne uma variável em branco
  retornaToken(){
    return localStorage.getItem(KEY) ?? '';
  }

  salvaToken(token: string) {
    localStorage.setItem(KEY, token);
  }

  excluirToken(){
    localStorage.removeItem(KEY);
  }

  possuiToken(){
    //  não é para retornar o token é apenas para saber se tem token ou não.
    return !!this.retornaToken();
  }

}
