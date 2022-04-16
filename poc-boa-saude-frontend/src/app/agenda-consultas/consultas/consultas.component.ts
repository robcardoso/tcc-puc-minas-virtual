import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { empty } from 'rxjs';
import { map, tap, switchMap } from 'rxjs/operators';
import { NovoUsuario } from 'src/app/home/novo-usuario/novo-usuario';
import { Estado, Estados, EstadosBr, CidadesBr, CidadesBrAtendimento, Associado, Prestador } from './consultas.model';
import { ConsultasService } from './consultas.service';
import { HoraConsulta } from './consultas.model';
import { HORA } from 'src/assets/dados/horaConsulta';

@Component({
  selector: 'app-consultas',
  templateUrl: './consultas.component.html',
  styleUrls: ['./consultas.component.css']
})
export class ConsultasComponent implements OnInit {
  novaConsultaForm!: FormGroup;
  estados: Estados[] = [];
  estados2: Estado[] = [];
  estadosBr: EstadosBr[] = [];

  dataFormatada: any;

  // cidadesBr: CidadesBr[] = [];
  cidadesBrAtendimento: CidadesBrAtendimento[] = [];
  filtroCidades: CidadesBrAtendimento[] = [];
  dadosAssociados: Associado[] = []
  dadosPrestador: Prestador [] = [];

  escolherMedico = true;
  medicoSelecionado!: string;

  radioSel!:any;
  radioSelected!:string;
  radioSelectedString!:string;
  itemsList: HoraConsulta[] = HORA;

  estadoAgendado: any;
  cidadeAgendada: any;
  especialidadeAgendada: any;
  medicoEndereco: any;
  medicoTel: any;
  agendadaSucesso = false;

  constructor(
    private formBuilder: FormBuilder,
    private consultasService: ConsultasService,

    private router: Router


  ) {}



  ngOnInit(): void {
    this.escolherMedico = true;
    this.itemsList = HORA;

    this.novaConsultaForm = this.formBuilder.group(
      {
        email: ['', [Validators.required, Validators.email]],
        fullName: ['', [Validators.required, Validators.minLength(4)]],
        userName: [''],
        dataControl: [''],
        radioControl: [''],
        estadoControl: ['', [Validators.required,]],
        cidadeControl: ['', [Validators.required]],
        associadosControl: ['', [Validators.required]]
      },

    );

    this.pegarCidade();
    // this.pegarEstados();
    this.pegarEstadosBr();

    // this.getSelecteditem();
    this.radioSel = ''
  }

  getSelecteditem( HoraConsulta: HoraConsulta){
    // this.radioSel = HORA.find(Item => Item.value === this.radioSelected);
    this.radioSel = HoraConsulta.name
    this.radioSelectedString = JSON.stringify(this.radioSel);
  }

  onItemChange(HoraConsulta: any){

    this.getSelecteditem( HoraConsulta);
  }

  pegarCidade(){
    this.consultasService.getCidades().subscribe(
      (retorno) => {
         this.estados = retorno
      }

    )
  }


  pegarEstadosBr(){
    this.consultasService.getEstadosBr().subscribe(
      (retornoEstados) => {
         this.estadosBr = retornoEstados
      }

    )

    this.novaConsultaForm.get('estadoControl')?.valueChanges
    .pipe(
      tap(estado => this.estadoAgendado = estado),
      map(estado => this.estadosBr.filter(e => e.Sigla === estado)),
      map(estados => estados && estados.length > 0 ? estados[0].ID : empty()),
      switchMap((estadoId) => this.consultasService.getCidadesBr(estadoId)),

    )
    .subscribe(
      cidades => {
         this.cidadesBrAtendimento = cidades;
         this.dadosPrestador = [];
         this.dadosAssociados = [];

      });


      this.novaConsultaForm.get('cidadeControl')?.valueChanges.subscribe(
      dados => {
        const valorDados = dados
        this.filtroCidades = this.cidadesBrAtendimento.filter( item => item.ID == valorDados)
        this.cidadeAgendada =  this.filtroCidades.map(item => item.Nome).toString()


        const listaAssociado = this.filtroCidades.map((item)=> item.associados.map((itemdados)=>itemdados))
        let arrMap: any = [];
        listaAssociado.forEach((item) => arrMap.push(...item));
        this.dadosAssociados = arrMap
      }
    );


    this.novaConsultaForm.get('associadosControl')?.valueChanges.subscribe(
        dados => {
          const valorDados = dados
          const listamedico = this.dadosAssociados.filter(item => item.id == valorDados);
          this.especialidadeAgendada = listamedico.map(item=> item.nome).toString()
          const medico = listamedico.map(item => item.prestadores)
          let arrMapMedico: any = [];
          medico.forEach((item) => arrMapMedico.push(...item));
          this.dadosPrestador = arrMapMedico
        }
      );



      this.novaConsultaForm.get('dataControl')?.valueChanges.subscribe(
        dados => {
          let dataAtual2 = new Date(dados); //02/10/2020
          let dataAtualFormatada2 = (adicionaZero(dataAtual2.getDate().toString()) + "/" + (adicionaZero(dataAtual2.getMonth()+1).toString()) + "/" + dataAtual2.getFullYear());
          function adicionaZero(numero: any){
            if (numero <= 9)
                return "0" + numero;
            else
                return numero;
        }

        this.dataFormatada = dataAtualFormatada2
        }

       )
  }


  agendarConsulta() {

    if (this.novaConsultaForm.valid) {
      const agendar = this.novaConsultaForm.getRawValue() as NovoUsuario;
      this.consultasService.cadastraNovoUsuario(agendar).subscribe(
        () => {
          // this.router.navigate(['']);
          console.log(" agendar Consulta=", agendar)

          this.agendadaSucesso = true;
        },
        (error) => {
          console.log(error);
        }
      );
    }

  }


  selecionaMedico(medico: Prestador){
    this.escolherMedico = !this.escolherMedico
    this.medicoSelecionado = medico.nome
    this.medicoEndereco = medico.endereco
    this.medicoTel = medico.tel

  }


}
