import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AgendaConsultasRoutingModule } from './agenda-consultas-routing.module';
import { ConsultasComponent } from './consultas/consultas.component';
import { ReactiveFormsModule } from '@angular/forms';
import { MensagemModule } from '../componentes/mensagem/mensagem.module';




@NgModule({
  declarations: [
    ConsultasComponent
  ],
  imports: [
    CommonModule,
    AgendaConsultasRoutingModule,
    ReactiveFormsModule,
    MensagemModule
  ]
})
export class AgendaConsultasModule { }
