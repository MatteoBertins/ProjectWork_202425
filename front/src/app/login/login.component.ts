import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

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

  login() {
    this.loginService.login(this.formLogin.get('username')?.value, this.formLogin.get("password")?.value).subscribe({
      next: (res) => {
        if (res != null) {
          this.loginService.setLoggedIn(res)
          this.router.navigate(['/home'])
        } else {
          this.loginService.setLoggedIn(null)
        }

      },
      error: err => {
        console.error("Login fallito", err);
      }
    })
  }

}
