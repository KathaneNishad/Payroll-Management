import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import leaveUrl from './leaveurl';

@Injectable({
  providedIn: 'root'
})
export class LeaveserviceService {


  
  constructor(private http:HttpClient) { }
  
  public auth_token:string=localStorage.getItem('token')!;
  
  httpOptions = {
    headers: new HttpHeaders({
    'Content-Type':'application/json',
    'Authorization':`Bearer ${this.auth_token}`
    })
  };

  //request leave
  public requestLeave(leave : any){
    return this.http.post(`${leaveUrl}leave/request-leave/`,leave);
  }

  //all leave by a user fetched using user_id
  public getAllLeaveByUserId(id:any){
    return this.http.get(`${leaveUrl}leave/view-leave/${id}`);
  }

  //all leaves
  public getAllLeave(){
    return this.http.get(`${leaveUrl}leave/view-all-leaves/`);
  }

  //edit leaves
  public editLeaves(leave:any){
    return this.http.put(`${leaveUrl}leave/update-leave-status`,leave);
  }

  //Display Leave Table
  public displayLeaveChart(){
    return this.http.get(`${leaveUrl}leave/view-categories/`);
  }

  //Edit Leave Categories
  public editCategories(leaveCat:any){
    return this.http.put(`${leaveUrl}leave/edit-categories`,leaveCat);
  }
}
