import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SimulazioneInvestimentoDTO } from './dto/SimulazioneInvestimentoDTO';
import { TransazioneDTO } from './dto/TransazioneDTO';

@Injectable({
  providedIn: 'root'
})
export class TransazioneService {



  constructor(private http: HttpClient) { }

  salvaTransazione(transazione: TransazioneDTO, idUtente: number): Observable<void> {
    const apiUrlSave = 'http://localhost:8080/transazioni/salvaTransazione/' + idUtente;

    return this.http.post<void>(apiUrlSave, transazione,);
  }

  findTransazioni(idUtente: number): Observable<any[]> {
    const apiUrlFind = 'http://localhost:8080/transazioni/findTransazioni/' + idUtente;

    return this.http.get<any[]>(apiUrlFind,);
  }

    findTransazioniMesePrecedente(idUtente: number): Observable<any[]> {
    const apiUrlFind = 'http://localhost:8080/transazioni/findTransazioniMesePrecedente/' + idUtente;

    return this.http.get<any[]>(apiUrlFind,);
  }

    findTransazioniMeseCorrente(idUtente: number): Observable<any[]> {
    const apiUrlFind = 'http://localhost:8080/transazioni/findTransazioniMeseCorrente/' + idUtente;

    return this.http.get<any[]>(apiUrlFind,);
  }
 saveSaldo(idUtente: number,totale:number): Observable<void> {
    const apiUrlSave = 'http://localhost:8080/transazioni/saveSaldo/' + idUtente;

    return this.http.post<void>(apiUrlSave, totale,);
  }


}
