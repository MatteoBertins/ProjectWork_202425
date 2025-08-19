import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SimulazioneInvestimentoDTO } from './dto/SimulazioneInvestimentoDTO';
import { TransazioneDTO } from './dto/TransazioneDTO';
import { FinanziamentoDTO } from './dto/FinanziamentoDTO';

@Injectable({
  providedIn: 'root'
})
export class FinanziamentiService {



  constructor(private http: HttpClient) {}

  salvaFinanaziamentoPrestiti(finanziamento: FinanziamentoDTO,idUtente:number): Observable<any> {
        const apiUrlSavePrestiti = 'http://localhost:8080/finanziamenti/salvaFinanaziamentoPrestiti/' + idUtente;

    return this.http.post<void>(apiUrlSavePrestiti, finanziamento, );
  }

   salvaFinanaziamentoMutui(finanziamento: FinanziamentoDTO,idUtente:number): Observable<any> {
        const apiUrlSaveMutui = 'http://localhost:8080/finanziamenti/salvaFinanaziamentoMutui/' + idUtente;

    return this.http.post<void>(apiUrlSaveMutui, finanziamento, );
  }
   findFInanziamentiMutui(idUtente:number): Observable<any[]> {
        const apiUrlFindMutui = 'http://localhost:8080/finanziamenti/findFinanziamentiMutui/' + idUtente;

    return this.http.get<any[]>(apiUrlFindMutui, );
  }

 findFInanziamentiPrestiti(idUtente:number): Observable<any[]> {
      const apiUrlFindPrestiti = 'http://localhost:8080/finanziamenti/findFinanziamentiPrestiti/' + idUtente;

    return this.http.get<any[]>(apiUrlFindPrestiti, );
  }

}
