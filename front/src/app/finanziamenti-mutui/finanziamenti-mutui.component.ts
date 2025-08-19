import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { FinanziamentiService } from '../finanziamenti.service';
import { FinanziamentoDTO } from '../dto/FinanziamentoDTO';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-finanziamenti-mutui',
  templateUrl: './finanziamenti-mutui.component.html',
  styleUrls: ['./finanziamenti-mutui.component.css']
})
export class FinanziamentiMutuiComponent implements OnInit {

  mutuoForm!: FormGroup
  finanziamenti: any[] = []
  finanziamentoCalcolato = {
    rataMensile: 0,
    totInteressi: 0,
    costoTotale: 0
  };
  idUtente!: number

  constructor(private finanziamentoService: FinanziamentiService,private toastr: ToastrService) { }

  ngOnInit(): void {
    this.initForm()
    this.idUtente = Number(localStorage.getItem('isLogged'));

  }

  initForm() {
    this.mutuoForm = new FormGroup({
      finalita: new FormControl(),
      valoreCasa: new FormControl(),
      importoRichiesto: new FormControl(),
      durata: new FormControl(),
      etaRichiedente: new FormControl(),
      tipoTasso: new FormControl(),
      includiAssicurazione: new FormControl()
    })
  }


  calcolaRataMensile() {
    console.log("CIAO")
    let fin = new FinanziamentoDTO()

    fin.finalita = this.mutuoForm.get('finalita')!.value
    fin.valoreCasa = this.mutuoForm.get('valoreCasa')!.value
    fin.importoRichiesto = this.mutuoForm.get('importoRichiesto')!.value
    fin.durata = this.mutuoForm.get('durata')!.value
    fin.etaRichiedente = this.mutuoForm.get('etaRichiedente')!.value
    fin.tipoTasso = this.mutuoForm.get('tipoTasso')!.value
    const checkbox = document.getElementById("assicurazione") as HTMLInputElement;
    const includiAssicurazione = checkbox.checked ? "S" : "N";
    fin.includiAssicurazione = includiAssicurazione


    if (fin.etaRichiedente > 36 || fin.finalita != 'prima_casa') {
      if(fin.valoreCasa == fin.importoRichiesto){
        this.toastr.error('Non è possibile effettuare un muuto 100% per gli over 36')
        return
      }
    }

    this.finanziamentoService.salvaFinanaziamentoMutui(fin, this.idUtente).subscribe(resp => {
      this.finanziamentoCalcolato.costoTotale = resp.costoTotale
      this.finanziamentoCalcolato.rataMensile = resp.rataMensile
      this.finanziamentoCalcolato.totInteressi = resp.totInteressi
      this.initForm()


      console.log(this.finanziamentoCalcolato)

    })
  }
  findSimulazioniInv() {
    this.finanziamentoService.findFInanziamentiMutui(this.idUtente).subscribe(resp => {
      this.finanziamenti = resp
    })
  }

}
