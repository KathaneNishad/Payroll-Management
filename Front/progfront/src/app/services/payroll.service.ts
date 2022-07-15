import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import payrollUrl from './payrollUrl';

@Injectable({
  providedIn: 'root'
})
export class PayrollService {

  constructor(private http:HttpClient) { }

  public auth_token:string=localStorage.getItem('token')!;
  
  httpOptions = {
    headers: new HttpHeaders({
    'Content-Type':'application/json',
    'Authorization':`Bearer ${this.auth_token}`
    })
  };
  //PayrollMaster Serivces
  public viewPayRolls(){
    return this.http.get(`${payrollUrl}PayrollMaster/viewAll`);
  }

  public updatePayrolls(payroll:any){
    return this.http.put(`${payrollUrl}PayrollMaster/update`,payroll);
  }


  //Payroll Services
  public generatePayroll(payroll:any){
    return this.http.post(`${payrollUrl}Payroll/create`,payroll);
  }

  public viewAllPayrolls(){
    return this.http.get(`${payrollUrl}Payroll/viewAll`);
  }

  public getPayrollByUserId(userId:any){
    return this.http.get(`${payrollUrl}Payroll/viewById/${userId}`);
  }

  public updatePayroll(id:any){
    return this.http.get(`${payrollUrl}Payroll/update/${id}`);
  }

}
