import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registrazione',
  templateUrl: './registrazione.component.html',
  styleUrls: ['./registrazione.component.css']
})
export class RegistrazioneComponent implements OnInit {

  constructor(private loginService: LoginService, private router: Router) { }
  
  
    formLogin!: FormGroup;
    ngOnInit(): void {
      this.initForm()
    }
  
    initForm() {
      this.formLogin = new FormGroup({
        username: new FormControl(),
        password: new FormControl()
      })
    }
  
    register() {
      this.loginService.register(this.formLogin.get('username')?.value, this.formLogin.get("password")?.value).subscribe({
        next: (res) => {
            this.router.navigate([''])
        },
        error: err => {
          console.error("Login fallito", err);
        }
      })
    }
}
