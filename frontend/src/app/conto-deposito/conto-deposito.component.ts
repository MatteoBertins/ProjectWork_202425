import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ContoDepositoCalcolato } from '../dto/contoDepositoCalcolato';
import { SimulazioneContoDepositoService } from '../simulazione-conto-deposito.servic';

@Component({
  selector: 'app-conto-deposito',
  templateUrl: './conto-deposito.component.html',
  styleUrls: ['./conto-deposito.component.css']
})
export class ContoDepositoComponent implements OnInit {


  formConto!: FormGroup
  constructor(private contoDepositoService: SimulazioneContoDepositoService) { }
  idUtente!: number
  simulazioneCalcolata!: any
  ngOnInit(): void {
    this.initForm()
            this.idUtente = Number(localStorage.getItem('isLogged'));

  }
  
  initForm(){
    this.formConto = new FormGroup({
      importoDaVincolare: new FormControl(),
      durata: new FormControl()
    })
  }


  calcola(){
    let contoDeposito = new ContoDepositoCalcolato()
        contoDeposito.durata = this.formConto.get('durata')!.value
        contoDeposito.importoDaVincolare = this.formConto.get('importoDaVincolare')!.value
        contoDeposito.tasso = 2

        this.contoDepositoService.simulaContoDeposito(contoDeposito,this.idUtente).subscribe(resp =>{
          this.simulazioneCalcolata = resp
        })
  }
}
