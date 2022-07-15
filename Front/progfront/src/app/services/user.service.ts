import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginComponent } from '../pages/login/login.component';
import baseUrl from './helper';
import { User } from './User';

@Injectable({
  providedIn: 'root'
})

export class UserService {
  
  
  

  constructor(
    private http:HttpClient
  ) { }

  public auth_token:string=localStorage.getItem('token')!;
  
  httpOptions = {
    headers: new HttpHeaders({
    'Content-Type':'application/json',
    'Authorization':`Bearer ${this.auth_token}`
    })
  };
  
  
  //addEmployee
  public addEmployee(emp : any){
    return this.http.post(`${baseUrl}user/`,emp);
  }
  //view Employees
  public getAllEmployees():Observable<User[]>{
    return this.http.get<User[]>(`${baseUrl}user/all`);
  }
  //getEmployee
  getUser(id:any){
    return this.http.get(`${baseUrl}user/byId/${id}`);
  }

  //getUserName
  getUserName(id:any){
    return this.http.get(`${baseUrl}user/usernameById/${id}`,this.httpOptions);
  }
  
}
