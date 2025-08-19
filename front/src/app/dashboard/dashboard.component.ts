import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { TransazioneService } from '../transazione.service';
import { TransazioneDTO } from '../dto/TransazioneDTO';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private transazioneService: TransazioneService, private toastr: ToastrService) { }
  saldoDisponibile!: number
  formTransazione !: FormGroup
  transazioni: any[] = []
  transazioniMesePrecedente: any[] = []
  transazioniMeseCorrente: any[] = []
  uscitePrecedenti: number = 0
  entratePrecedenti: number = 0
  entrareCorrenti: number = 0
  usciteCorrenti: number = 0
  idUtente!: number
  oggi!: string
  ngOnInit(): void {
    this.initForm()
    console.log(localStorage.getItem('isLogged'))
    this.idUtente = Number(localStorage.getItem('isLogged'));
    this.findTransazioni()
    this.findTransazioniMesePrecedente()
    this.findTransazioniMeseCorrente()

    this.oggi = (new Date).toISOString().split('T')[0]

  }

  findTransazioni() {
    this.transazioneService.findTransazioni(this.idUtente).subscribe(resp => {
      this.transazioni = resp
      this.calculateSaldoDisponibile()
    })
  }


  findTransazioniMesePrecedente() {
    this.transazioneService.findTransazioniMesePrecedente(this.idUtente).subscribe(resp => {
      this.transazioniMesePrecedente = resp
      this.calculateSaldoMesePrecedente()

    })
  }

  findTransazioniMeseCorrente() {
    this.transazioneService.findTransazioniMeseCorrente(this.idUtente).subscribe(resp => {
      this.transazioniMeseCorrente = resp
      this.calculateSaldoMeseCorrente()

    })
  }

  calculateSaldoMeseCorrente() {
    let totale = 0;
    for (const t of this.transazioniMeseCorrente) {
      if (t.tipologiaTransazione === 1) {
        this.entrareCorrenti += t.importo;
        console.log(this.entrareCorrenti)
      } else if (t.tipologiaTransazione === 2) {
        this.usciteCorrenti -= t.importo;
      }
    }
  }

  calculateSaldoMesePrecedente() {
    let totale = 0;
    for (const t of this.transazioniMesePrecedente) {
      if (t.tipologiaTransazione === 1) {
        this.entratePrecedenti += t.importo;
      } else if (t.tipologiaTransazione === 2) {
        this.uscitePrecedenti -= t.importo;
      }
    }
    this.saldoDisponibile = totale;
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

  initForm() {
    this.formTransazione = new FormGroup({
      data: new FormControl(),
      tipologiaTransazione: new FormControl(),
      descrizione: new FormControl(),
      importo: new FormControl()
    })
  }

  saveTransazione() {
    let transazione = new TransazioneDTO()

    transazione.data = new Date(this.formTransazione.get('data')!.value)
    transazione.tipologiaTransazione = this.formTransazione.get('tipologiaTransazione')!.value
    transazione.descrizione = this.formTransazione.get('descrizione')!.value
    transazione.importo = this.formTransazione.get('importo')!.value
    console.log(transazione.tipologiaTransazione)
    console.log(transazione.importo)
    console.log(this.saldoDisponibile)

    if (transazione.tipologiaTransazione == 2) {
      if ((this.saldoDisponibile - transazione.importo) < 0) {
        this.toastr.error('Non hai soldi sufficenti', 'Errore')
      } else {
        this.transazioneService.salvaTransazione(transazione, this.idUtente).subscribe(resp => {
          this.findTransazioni()
          this.findTransazioniMesePrecedente()
          this.findTransazioniMeseCorrente()


          this.initForm()
        })
      }
    } else {
      this.transazioneService.salvaTransazione(transazione, this.idUtente).subscribe(resp => {
        this.findTransazioni()
        this.findTransazioniMesePrecedente()
        this.findTransazioniMeseCorrente()


        this.initForm()
      })
    }

  }
}
