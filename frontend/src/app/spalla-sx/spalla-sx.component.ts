import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-spalla-sx',
  templateUrl: './spalla-sx.component.html',
  styleUrls: ['./spalla-sx.component.css']
})
export class SpallaSxComponent implements OnInit {

sottoMenuFinanziamenti = false;
sottoMenuContoDeposito = false;

  clickSottoMenuFinanziamenti() {
    this.sottoMenuFinanziamenti = !this.sottoMenuFinanziamenti;
    console.log(this.sottoMenuFinanziamenti)
  }

   clickSottoMenuContoDeposito() {
    this.sottoMenuContoDeposito = !this.sottoMenuContoDeposito;
  }
    constructor(private router:Router) { }

  ngOnInit(): void {
    const url = this.router.url

    if(url.includes("/finanziamenti")){
            this.sottoMenuFinanziamenti = true
    }
      if(url.includes("/conto-deposito")){
            this.sottoMenuContoDeposito = true
    }
  }
closeSottoMenu(){
      this.sottoMenuFinanziamenti = false
      this.sottoMenuContoDeposito = false

}
}
