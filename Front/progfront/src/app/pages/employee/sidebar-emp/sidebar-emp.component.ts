import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-sidebar-emp',
  templateUrl: './sidebar-emp.component.html',
  styleUrls: ['./sidebar-emp.component.css']
})
export class SidebarEmpComponent implements OnInit {

  constructor(private login:LoginService) { }

  ngOnInit(): void {
  }
  public logout(){
    this.login.logout();
    window.location.reload();
    //this.login.loginStatusSubject.next(false);
  }
}
