import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { SimulazioneContoDepositoService } from '../simulazione-conto-deposito.servic';
import { ContoDepositoVincolato } from '../dto/contoDepositoVincolato';
import { ToastrService } from 'ngx-toastr';
import { TransazioneService } from '../transazione.service';

@Component({
  selector: 'app-conto-deposito-vincola',
  templateUrl: './conto-deposito-vincola.component.html',
  styleUrls: ['./conto-deposito-vincola.component.css']
})
export class ContoDepositoVincolaComponent implements OnInit {

  constructor(private contoDepositoService: SimulazioneContoDepositoService,private toastr: ToastrService,private transazioneService: TransazioneService) { }
  formConto!: FormGroup
  idUtente!: number
    transazioni: any[] = []
  saldoDisponibile!: number

  ngOnInit(): void {
        this.initForm()
        this.idUtente = Number(localStorage.getItem('isLogged'));
      this.findTransazioni()
  }
 initForm(){
    this.formConto = new FormGroup({
      importoDaVincolare: new FormControl(),
      durata: new FormControl()
    })
  }

    findTransazioni() {
    this.transazioneService.findTransazioni(this.idUtente).subscribe(resp => {
      this.transazioni = resp
      this.calculateSaldoDisponibile()
    })
  }

  calculateSaldoDisponibile() {
    let totale = 0;
    for (const t of this.transazioni) {
      if (t.tipologiaTransazione === 1) {
        totale += t.importo;
      } else if (t.tipologiaTransazione === 2) {
        totale -= t.importo;
      }
    }
    this.saldoDisponibile = totale;
    this.transazioneService.saveSaldo(this.idUtente, totale).subscribe(resp => {

    })
  }

  vincolaDeposito(){
  let contoVincolato=  new  ContoDepositoVincolato()
    contoVincolato.importoVincolato = this.formConto.get('importoDaVincolare')!.value
    contoVincolato.mesi = this.formConto.get('durata')!.value


if ((this.saldoDisponibile - this.formConto.get('importoDaVincolare')?.value) < 0) {
        this.toastr.error('Non hai soldi sufficenti', 'Errore')
      } else {
        this.contoDepositoService.vincolaDeposito(contoVincolato,this.idUtente).subscribe(resp =>{
      this.initForm()
      this.toastr.success('Operazione effettuata con successo!')
    })
      }


   
  }
}
