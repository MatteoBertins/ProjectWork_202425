import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SimulazioneInvestimentoDTO } from './dto/SimulazioneInvestimentoDTO';
import { TransazioneDTO } from './dto/TransazioneDTO';
import { ContoDepositoCalcolato } from './dto/contoDepositoCalcolato';

@Injectable({
  providedIn: 'root'
})
export class SimulazioneContoDepositoService {



  constructor(private http: HttpClient) {}

  vincolaDeposito(contoDepositoVincolato : any,idUtente:number): Observable<void> {
        const apiUrl = 'http://localhost:8080/contoDeposito/vincolaSoldi/'+ idUtente;

    return this.http.post<void>(apiUrl, contoDepositoVincolato, );
  }
  simulaContoDeposito(contoDeposito : ContoDepositoCalcolato,idUtente:number): Observable<void> {
        const apiUrl = 'http://localhost:8080/contoDeposito/simulaContoDeposito/'+ idUtente;

    return this.http.post<void>(apiUrl, contoDeposito, );
  }


}
