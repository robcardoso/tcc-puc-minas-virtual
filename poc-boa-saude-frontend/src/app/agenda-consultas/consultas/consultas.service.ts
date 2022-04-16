import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { NovoUsuario } from 'src/app/home/novo-usuario/novo-usuario';
import { CidadesBrAtendimento, Estado, Estados, EstadosBr } from './consultas.model';
import { DADOS_CIDADE } from './dadosMock';

@Injectable({
  providedIn: 'root'
})
export class ConsultasService {

  constructor(private http: HttpClient) { }
  cadastraNovoUsuario(novoUsuario: NovoUsuario) {
    return of("DADOS_SESSAO_MOCKADO");
  }


  getCidades( ){
    const dados = DADOS_CIDADE
    return this.http.get<Estados[]>('assets/dados/estados-cidades.json')
  }

  getEstados( ){
    return this.http.get<Estado[]>('assets/dados/estados.json')
  }

  getEstadosBr( ){
    return this.http.get<EstadosBr[]>('assets/dados/estadosBrasilAtendimento.json')
  }

   getCidadesBr( idEstado: any){
    return this.http.get<CidadesBrAtendimento[]>('assets/dados/cidadesBrasilAtendimento.json')
    .pipe(map((cidades:CidadesBrAtendimento[]) => cidades.filter(c => c.Estado == idEstado) ))
  }

}
