import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SimulazioneInvestimentoDTO } from './dto/SimulazioneInvestimentoDTO';
import { TransazioneDTO } from './dto/TransazioneDTO';

@Injectable({
  providedIn: 'root'
})
export class SimulazioneInvestimentoService {



  constructor(private http: HttpClient) {}

  salvaSimulazioneInvestimento(simInv: SimulazioneInvestimentoDTO[],idUtente:number): Observable<void> {
        const apiUrl = 'http://localhost:8080/simulazioneInvestimento/salvaSimulazioneInvestimento/'+ idUtente;

    return this.http.post<void>(apiUrl, simInv, );
  }

   findSimulazioniInvestimenti(idUtente:number): Observable<any[]> {
        const apiUrlFind = 'http://localhost:8080/simulazioneInvestimento/findSimulazioniInvestimenti/' + idUtente;

    return this.http.get<any[]>(apiUrlFind, );
  }


}
