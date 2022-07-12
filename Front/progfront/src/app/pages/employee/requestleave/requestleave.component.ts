import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LeaveserviceService } from 'src/app/services/leaveservice.service';
import { LoginService } from 'src/app/services/login.service';
import { UserService } from 'src/app/services/user.service';




@Component({
  selector: 'app-requestleave',
  templateUrl: './requestleave.component.html',
  styleUrls: ['./requestleave.component.css']
})
export class RequestleaveComponent implements OnInit {

minDate:any="";

  constructor(private userService:UserService,
    private snack:MatSnackBar,
    private leaveService:LeaveserviceService,
    public login:LoginService) { }

    leave={
    "lid":'',
    "user_id":'',
    "startDate":'',
    "endDate":'',
    "leaveDescription":'',
    "numberOfLeave":'',
    "leaveStatus":'Pending',
  }

  leaveCount:any=0;

  total:number=0;

  public leavesCategories = [

  ] as any;
  public category={};

  ngOnInit(): void {
    this.getDate();
    this.leaveService.getLeaveCount(this.login.getUser().id).subscribe(data=>this.leaveCount=data);

    //get leave chart 
    this.leaveService.displayLeaveChart().subscribe(data=>this.leavesCategories=data);

    
  }

  dateDifference(date2:any, date1:any) {
    let dateStart: Date = new Date(date1);
    let dateEnd: Date = new Date(date2);
    let timeInMilisec: number = dateEnd.getTime() - dateStart.getTime();
    let daysBetweenDates: number = (Math.ceil(timeInMilisec / (1000 * 60 * 60 * 24))) +1 ;
    return daysBetweenDates  ;
}

  getDate(){
    var date = new Date();
    var day:any = date.getDate();
    if(day<10){
      day ='0'+day;
    }
    var month :any = date.getMonth()+1;
    if(month<10){
      month='0'+month;
    }
    var year =date.getFullYear();

    this.minDate=year+"-"+month+"-"+day;

  }

  //get total leaves
  getTotal() {
    let total = 0;
    for (var i = 0; i < this.leavesCategories.length; i++) {
        if (this.leavesCategories[i].noOfLeaves) {
            total += this.leavesCategories[i].noOfLeaves;
         //   this.leavesCategories = total;
        }
    }
    return total;
}

  


  formSubmit(){
    //console.log(this.leave.startDate);
    //console.log(this.leave.endDate);
    this.leave.user_id = JSON.stringify(this.login.getUser().id);
    this.leave.numberOfLeave = JSON.stringify(this.dateDifference(this.leave.endDate, this.leave.startDate));
    //console.log(this.leave.numberOfLeave);
    this.leaveService.requestLeave(this.leave).subscribe();
  }
}
