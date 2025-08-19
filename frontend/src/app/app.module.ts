import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { InvestimentiComponent } from './investimenti/investimenti.component';
import {FinanziamentiPresitiComponent } from './finanziamenti-prestiti/finanziamenti-prestiti.component';
import { SpallaSxComponent } from './spalla-sx/spalla-sx.component';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FinanziamentiMutuiComponent } from './finanziamenti-mutui/finanziamenti-mutui.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { ContoDepositoComponent } from './conto-deposito/conto-deposito.component';
import { ContoDepositoVincolaComponent } from './conto-deposito-vincola/conto-deposito-vincola.component';
import { RegistrazioneComponent } from './registrazione/registrazione.component';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    InvestimentiComponent,
    FinanziamentiPresitiComponent,
    SpallaSxComponent,
    FinanziamentiMutuiComponent,
    LoginComponent,
    ContoDepositoComponent,
    ContoDepositoVincolaComponent,
    RegistrazioneComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  BrowserAnimationsModule,
    ToastrModule.forRoot({
      positionClass: 'toast-bottom-right',
      timeOut: 3000,
      preventDuplicates: true,
    }),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
