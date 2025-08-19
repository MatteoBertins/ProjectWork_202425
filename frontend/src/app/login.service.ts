import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SimulazioneInvestimentoDTO } from './dto/SimulazioneInvestimentoDTO';
import { TransazioneDTO } from './dto/TransazioneDTO';
import * as CryptoJS from 'crypto-js';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private secretKey = '1234567890123456'

  private apiUrlLogin = 'http://localhost:8080/api/login';
    private apiUrlRegister = 'http://localhost:8080/api/register';


  constructor(private http: HttpClient) { }


  register(username: string, password: string): Observable<any> {
    const dati = JSON.stringify({
      username: username,
      password: password
    });

    const encrypted = CryptoJS.AES.encrypt(dati, CryptoJS.enc.Utf8.parse(this.secretKey), {
      mode: CryptoJS.mode.ECB,
      padding: CryptoJS.pad.Pkcs7
    });
    const datiCriptati = encrypted.ciphertext.toString(CryptoJS.enc.Base64);
    return this.http.post<any>(this.apiUrlRegister, { datiCriptati });
  }

  login(username: string, password: string): Observable<any> {
    const dati = JSON.stringify({
      username: username,
      password: password
    });

    const encrypted = CryptoJS.AES.encrypt(dati, CryptoJS.enc.Utf8.parse(this.secretKey), {
      mode: CryptoJS.mode.ECB,
      padding: CryptoJS.pad.Pkcs7
    });
    const datiCriptati = encrypted.ciphertext.toString(CryptoJS.enc.Base64);
    return this.http.post<any>(this.apiUrlLogin, { datiCriptati });
  }

  setLoggedIn(loggedIn: number | null): void {
    localStorage.setItem('isLogged', String(loggedIn));
  }
  isAuthenticated(): boolean {
    return !!localStorage.getItem('isLogged');
  }

}
