import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { SimulazioneInvestimentoDTO } from '../dto/SimulazioneInvestimentoDTO';
import { SimulazioneInvestimentoService } from '../simulazione-investimento.service';

@Component({
  selector: 'app-investimenti',
  templateUrl: './investimenti.component.html',
  styleUrls: ['./investimenti.component.css']
})
export class InvestimentiComponent implements OnInit {
  idUtente!: number


  isModalOpen = false;
  simulazioniInvestimenti: SimulazioneInvestimentoDTO[] = []
  assetForm!: FormGroup
  simulazioniInvestimentiDaSalvare: SimulazioneInvestimentoDTO[] = []

  openModal() {
    this.initForm()
    this.isModalOpen = true;
  }

  initForm() {
    this.assetForm = new FormGroup({
      nome: new FormControl(),
      capitale: new FormControl(),
      rendimentoAtteso: new FormControl(),
      durata: new FormControl(),
      tipologiaInvestimento: new FormControl(),
    })
  }

  closeModal() {
    this.isModalOpen = false;
  }

  constructor(private simulazioneInvService: SimulazioneInvestimentoService) { }

  ngOnInit(): void {
        this.idUtente = Number(localStorage.getItem('isLogged'));
        console.log(this.idUtente)
            this.findSimulazioniInv()


  }

  findSimulazioniInv() {
    this.simulazioneInvService.findSimulazioniInvestimenti(this.idUtente).subscribe(resp => {
      this.simulazioniInvestimenti = resp
    })
  }


  calcolaRendimento() {

    this.simulazioneInvService.salvaSimulazioneInvestimento(this.simulazioniInvestimentiDaSalvare,this.idUtente).subscribe(resp => {
      this.findSimulazioniInv()
    })
          this.simulazioniInvestimentiDaSalvare = []

  }

  saveSimulazioneInvestimento() {
    let simInv = new SimulazioneInvestimentoDTO()

    simInv.nome = this.assetForm.get('nome')!.value
    simInv.importo = this.assetForm.get('capitale')!.value
    simInv.rendimentoAtteso = this.assetForm.get('rendimentoAtteso')!.value
    simInv.durata = this.assetForm.get('durata')!.value
    simInv.tipoPiano = this.assetForm.get('tipologiaInvestimento')!.value


    this.simulazioniInvestimentiDaSalvare.push(simInv)
    this.closeModal()


  }

  elimina(index : number){
    this.simulazioniInvestimentiDaSalvare.splice(index,1)
  }


  cambiaColorePerIdCalcolo(idCalcolo: number): string {
    const classe = idCalcolo % 5
    return `bordo-${classe}`;
}
}
