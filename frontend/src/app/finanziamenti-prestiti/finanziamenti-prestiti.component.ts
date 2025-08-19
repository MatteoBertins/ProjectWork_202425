import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { FinanziamentoDTO } from '../dto/FinanziamentoDTO';
import { FinanziamentiService } from '../finanziamenti.service';

@Component({
  selector: 'app-finanziamenti',
  templateUrl: './finanziamenti-prestiti.component.html',
  styleUrls: ['./finanziamenti-prestiti.component.css']
})
export class FinanziamentiPresitiComponent implements OnInit {
prestitoForm !: FormGroup
  idUtente!: number

  constructor(private finanziamentoService: FinanziamentiService) { }
finanziamentoCalcolato = {
  rataMensile: 0,
  totInteressi: 0,
  costoTotale: 0
};
  finanziamenti :any[]= []
  ngOnInit(): void {
    this.initForm()
        this.idUtente = Number(localStorage.getItem('isLogged'));

  }

  initForm(){
    this.prestitoForm = new FormGroup({
      motivo : new FormControl(),
      importo : new FormControl(),
      durata : new FormControl(),
      tipoTasso : new FormControl(),
      assicurazione : new FormControl()
    })
  }

    calcolaRataMensile(){
          let fin = new FinanziamentoDTO()
      
          fin.motivazione = this.prestitoForm.get('motivo')!.value
          fin.importo = this.prestitoForm.get('importo')!.value
          fin.durata = this.prestitoForm.get('durata')!.value
          fin.tipoTasso = this.prestitoForm.get('tipoTasso')!.value
     const checkbox = document.getElementById("assicurazione") as HTMLInputElement;
        const includiAssicurazione = checkbox.checked ? "S" : "N";
      fin.includiAssicurazione = includiAssicurazione
      this.finanziamentoService.salvaFinanaziamentoPrestiti(fin,this.idUtente).subscribe(resp =>{
            this.finanziamentoCalcolato.costoTotale = resp.costoTotale
        this.finanziamentoCalcolato.rataMensile = resp.rataMensile
                this.finanziamentoCalcolato.totInteressi = resp.totInteressi
          this.initForm()

      })
    }

 findSimulazioniInv() {
    this.finanziamentoService.findFInanziamentiPrestiti(this.idUtente).subscribe(resp => {
      this.finanziamenti = resp
    })
  }


}
