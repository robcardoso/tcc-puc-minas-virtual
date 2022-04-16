export interface EstadosBr {
  ID: number;
  Sigla: string;
  Nome: string;
}

export interface CidadesBr {
  ID: number;
  Nome: string;
  Estado: number;
}

///////////

export interface CidadesBrAtendimento {
  ID: number;
  Nome: string;
  Estado: number;
  associados: Associado[];
}

export interface Associado {
  id: number;
  nome: string;
  prestadores: Prestador[];
}
export interface Prestador {
  idPrestador: number;
  nome: string;
  endereco: string;
  tel: string;
}

////////////

export interface Estados {
  estados: Estado[];
}

// export interface Estado {
//   sigla: string;
//   nome: string;
//   codEstado: number;
//   cidades: Cidade[];
// }

export interface Estado {
  sigla: string;
  nome: string;
  cidades: string[];
}

export interface Cidade {
  nomeCidade: string;
  codCidade: number;
}

// prestadores


// horario consultas

export class HoraConsulta{
  name!:string;
  value!:string;
}


//

export interface Prestadore {
  codPrestador: string;
  nome: string;
}

export interface Especialidade {
  codEspecialidade: string;
  nome: string;
  prestadores: Prestadore[];
}

export interface CidadesPrestador {
  nome: string;
  codCidade: string;
  especialidade: Especialidade[];
}

export interface RootObject {
  cidadesPrestador: CidadesPrestador[];
}
