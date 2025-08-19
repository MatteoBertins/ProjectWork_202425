import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { InvestimentiComponent } from './investimenti/investimenti.component';
import { FinanziamentiPresitiComponent } from './finanziamenti-prestiti/finanziamenti-prestiti.component';
import { FinanziamentiMutuiComponent } from './finanziamenti-mutui/finanziamenti-mutui.component';
import { AuthGuard } from './auth.guard';
import { LoginComponent } from './login/login.component';
import { ContoDepositoComponent } from './conto-deposito/conto-deposito.component';
import { ContoDepositoVincolaComponent } from './conto-deposito-vincola/conto-deposito-vincola.component';
import { RegistrazioneComponent } from './registrazione/registrazione.component';

const routes: Routes = [

  { path: '', component: LoginComponent }, // root path
    { path: 'registrati', component: RegistrazioneComponent }, // root path
  { path: 'investimenti', component: InvestimentiComponent, canActivate: [AuthGuard] }, // root path
  { path: 'home', component: DashboardComponent, canActivate: [AuthGuard] }, // root path
  { path: 'finanziamenti/prestiti', component: FinanziamentiPresitiComponent, canActivate: [AuthGuard] }, // root path
  { path: 'finanziamenti/mutui', component: FinanziamentiMutuiComponent, canActivate: [AuthGuard] }, // root path
  { path: 'conto-deposito/simulazione', component: ContoDepositoComponent, canActivate: [AuthGuard] }, // root path
  { path: 'conto-deposito/vincola', component: ContoDepositoVincolaComponent, canActivate: [AuthGuard] }, // root path

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
